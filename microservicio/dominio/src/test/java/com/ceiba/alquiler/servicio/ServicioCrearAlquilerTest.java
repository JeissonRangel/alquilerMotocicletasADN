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

    private Alquiler alquiler = new AlquilerTestDataBuilder().conId(1L).build();

    @Mock
    private Motocicleta motocicleta;

    private LocalDate FECHA_ACTUAL = LocalDate.now();

    @Test
    @DisplayName("Deberia lanzar una excepcion si no hay motocicletas disponibles")
    void deberiaLanzarUnaExcepcionSiNoHayMotocicletasDisponibles(){
        //Arrange
        Mockito.doReturn(false).when(repositorioMotocicleta).validarDisponibilidad();

        //Act-Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.ejecutar(alquiler),
                ExcepcionNoMotocicletasDisponibles.class,
                NO_HAY_MOTOCICLETAS_DISPONIBLES
        );
    }

    @Test
    @DisplayName("Deberia calcular la fecha de devolucion de un alquiler")
    void deberiaCalcularLaFechaDevolucionDelAlquiler(){

        int cantidadDiasAlquiler = 10;
        Mockito.doReturn(true).when(repositorioMotocicleta).validarDisponibilidad();
        Mockito.doReturn(dtoMotocicleta).when(daoMotocicleta).buscarDisponible();
        Mockito.doNothing().when(repositorioMotocicleta).actualizarDisponibilidadPorId(1L,false);

        LocalDate fechaDevolucion = FECHA_ACTUAL.plusDays(cantidadDiasAlquiler);

        servicioCrearAlquiler.ejecutar(alquiler);

        assertEquals(fechaDevolucion,alquiler.getFechaDevolucion());
    }

    @Test
    @DisplayName("Deberia crear el alquiler de forma correcta")
    void deberiaCrearElAlquilerDeFormaCorrecta(){

        Mockito.doReturn(true).when(repositorioMotocicleta).validarDisponibilidad();
        Mockito.doReturn(dtoMotocicleta).when(daoMotocicleta).buscarDisponible();
        Mockito.doNothing().when(repositorioMotocicleta).actualizarDisponibilidadPorId(1L,false);

        Long idAlquiler = servicioCrearAlquiler.ejecutar(alquiler);
        System.out.println(idAlquiler);

        assertEquals(1L,idAlquiler);

    }
}
