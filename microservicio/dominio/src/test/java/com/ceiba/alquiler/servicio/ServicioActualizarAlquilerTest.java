package com.ceiba.alquiler.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ServicioActualizarAlquilerTest {

    private static final String EL_ALQUILER_NO_EXISTE = "Este alquiler no existe en el sistema";

    @Mock
    private DaoAlquiler daoAlquiler;

    @Mock
    private RepositorioAlquiler repositorioAlquiler;

    @InjectMocks
    private ServicioActualizarAlquiler servicioActualizarAlquiler;

    @InjectMocks
    private Alquiler alquiler = new AlquilerTestDataBuilder().build();

    @Test
    @DisplayName("Deberia lanzar una excepcion si el alquiler no existe")
    void deberiaLanzarUnaExcepcionSiElAlquilerNoExiste(){

        Mockito.doReturn(false).when(repositorioAlquiler).existePorId(Mockito.anyLong());

        BasePrueba.assertThrows(()-> servicioActualizarAlquiler.ejecutar(alquiler),
                ExcepcionDuplicidad.class,
                EL_ALQUILER_NO_EXISTE);
    }

    @Test
    @DisplayName("Deberia actualizar el alquiler correctamente")
    void deberiaActualizarElAlquilerCorrectamente(){

        Mockito.doReturn(true).when(repositorioAlquiler).existePorId(Mockito.anyLong());

        servicioActualizarAlquiler.ejecutar(alquiler);

        Mockito.verify(repositorioAlquiler,Mockito.times(1)).actualizar(alquiler);
    }
}
