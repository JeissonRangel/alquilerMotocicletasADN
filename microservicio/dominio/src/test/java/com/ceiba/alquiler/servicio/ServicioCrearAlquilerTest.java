package com.ceiba.alquiler.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionNoMotocicletasDisponibles;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ServicioCrearAlquilerTest {

    private static final String NO_HAY_MOTOCICLETAS_DISPONIBLES = "En este momento no hay motocicletas disponibles para alquilar";

    @Mock
    private DaoMotocicleta daoMotocicleta;

    @Mock
    private DtoMotocicleta dtoMotocicleta;

    @Mock
    private RepositorioAlquiler repositorioAlquiler;

    @Mock
    private RepositorioMotocicleta repositorioMotocicleta;

    @InjectMocks
    private ServicioCrearAlquiler servicioCrearAlquiler;

    private Alquiler alquiler = new AlquilerTestDataBuilder().build();

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
        Mockito.doReturn(1L).when(repositorioAlquiler).crear(alquiler);
        System.out.println(alquiler.getId());

        LocalDate fechaDevolucion = FECHA_ACTUAL.plusDays(cantidadDiasAlquiler);
        servicioCrearAlquiler.ejecutar(alquiler);

        assertEquals(fechaDevolucion,alquiler.getFechaDevolucion());

    }

    @Test
    @DisplayName("Deberia crear el alquiler de forma correcta")
    void deberiaCrearElAlquilerDeFormaCorrecta(){

        alquiler = new AlquilerTestDataBuilder().conId(10L).build();
        Mockito.doReturn(true).when(repositorioMotocicleta).validarDisponibilidad();
        Mockito.doReturn(dtoMotocicleta).when(daoMotocicleta).buscarDisponible();
        Mockito.doNothing().when(repositorioMotocicleta).actualizarDisponibilidadPorId(1L,false);
        Mockito.doReturn(10L).when(repositorioAlquiler).crear(Mockito.any());

        Long idAlquiler = servicioCrearAlquiler.ejecutar(alquiler);

        assertEquals(alquiler.getId(),idAlquiler);

    }
}
