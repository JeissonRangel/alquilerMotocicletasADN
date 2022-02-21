package com.ceiba.alquiler.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionNoMotocicletasDisponibles;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ServicioCrearAlquilerTest {

    private static final String NO_HAY_MOTOCICLETAS_DISPONIBLES = "En este momento no hay motocicletas disponibles para alquilar";

    @Mock
    private DaoMotocicleta daoMotocicleta;

    @Mock
    private DtoMotocicleta dtoMotocicleta;

    @Mock
    private RepositorioMotocicleta repositorioMotocicleta;

    @Mock
    private RepositorioAlquiler repositorioAlquiler;

    @InjectMocks
    private ServicioCrearAlquiler servicioCrearAlquiler;

    @InjectMocks
    private Alquiler alquiler = new AlquilerTestDataBuilder().build();

    @Mock
    private Motocicleta motocicleta;

    @InjectMocks
    private LocalDate FECHA_ACTUAL = LocalDate.now();

    @Test
    @DisplayName("Deberia lanzar una excepcion si no hay motocicletas disponibles")
    void deberiaLanzarUnaExcepcionSiNoHayMotocicletasDisponibles(){
        //Arrange
        Mockito.doReturn(false).when(daoMotocicleta).validarDisponibilidad();

        //Act-Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.ejecutar(alquiler),
                ExcepcionNoMotocicletasDisponibles.class,
                NO_HAY_MOTOCICLETAS_DISPONIBLES
        );
    }

    @Test
    @DisplayName("Deberia calcular la fecha de devolucion de un alquiler")
    void deberiaCalcularLaFechaDevolucionDelAlquiler(){
        int cantidadDiasAlquiler = alquiler.getCantidadDiasAlquiler();
        Mockito.doReturn(true).when(daoMotocicleta).validarDisponibilidad();
        Mockito.doReturn(1L).when(motocicleta).getId();
        Mockito.doReturn(dtoMotocicleta).when(daoMotocicleta).buscarDisponible();
        Mockito.doNothing().when(repositorioMotocicleta).actualizarDisponibilidadPorId(1L,false);
        //Mockito.doReturn(1L).when(repositorioAlquiler).crear(alquiler);

        FECHA_ACTUAL.plusDays(cantidadDiasAlquiler);

        servicioCrearAlquiler.ejecutar(alquiler);

        assertEquals(FECHA_ACTUAL,alquiler.getFechaDevolucion());
    }

    @Test
    @DisplayName("Deberia crear el alquiler de forma correcta")
    void deberiaCrearElAlquilerDeFormaCorrecta(){
        Mockito.doReturn(true).when(daoMotocicleta).validarDisponibilidad();
        Mockito.doReturn(1L).when(motocicleta).getId();
        Mockito.doReturn(dtoMotocicleta).when(daoMotocicleta).buscarDisponible();
        Mockito.doNothing().when(repositorioMotocicleta).actualizarDisponibilidadPorId(1L,false);
        Mockito.doReturn(1L).when(repositorioAlquiler).crear(alquiler);

        Long idAlquiler = servicioCrearAlquiler.ejecutar(alquiler);

        assertEquals(1L,idAlquiler);

    }
}
