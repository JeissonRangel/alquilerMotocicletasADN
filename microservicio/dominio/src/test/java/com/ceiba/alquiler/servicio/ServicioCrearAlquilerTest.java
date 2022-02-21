package com.ceiba.alquiler.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionNoMotocicletasDisponibles;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ServicioCrearAlquilerTest {

    private static final String NO_HAY_MOTOCICLETAS_DISPONIBLES = "En este momento no hay motocicletas disponibles para alquilar";

    @Mock
    private DaoMotocicleta daoMotocicleta;

    @Mock
    private ServicioCrearAlquiler servicioCrearAlquiler;

    @InjectMocks
    private Alquiler alquiler = new AlquilerTestDataBuilder().build();

    @Test
    @DisplayName("Deberia lanzar una excepcion si no hay motocicletas disponibles")
    void deberiaLanzarUnaExcepcionSiNoHayMotocicletasDisponibles(){
        //Arrange
        Mockito.when(daoMotocicleta.validarDisponibilidad()).thenReturn(false);
        Mockito.doReturn(false).when(daoMotocicleta).validarDisponibilidad();

        //Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.ejecutar(alquiler), ExcepcionNoMotocicletasDisponibles.class, "error");
    }

    @Test
    @DisplayName("Deberia no lanzar una excepcion si no hay motocicletas disponibles")
    void noDeberiaLanzarUnaExcepcionSiNoHayMotocicletasDisponibles(){
        Mockito.when(daoMotocicleta.validarDisponibilidad()).thenReturn(true);

        servicioCrearAlquiler.ejecutar(alquiler);
    }
}
