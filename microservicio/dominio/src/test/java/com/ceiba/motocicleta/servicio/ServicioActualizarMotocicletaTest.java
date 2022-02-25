package com.ceiba.motocicleta.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionNoMotocicletasDisponibles;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;
import com.ceiba.motocicleta.servicio.testdatabuilder.MotocicletaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ServicioActualizarMotocicletaTest {

    private static final String LA_MOTOCICLETA_NO_EXISTE = "Esta motocicleta no existe en el sismtema";

    @Mock
    private RepositorioMotocicleta repositorioMotocicleta;

    @InjectMocks
    private ServicioActualizarMotocicleta servicioActualizarMotocicleta;

    private Motocicleta motocicleta = new MotocicletaTestDataBuilder().build();

    @Test
    @DisplayName("Deberia lanzar una excepcion si la motocicleta no existe")
    void deberiaLanzarUnaExcepcionSiLaMotocicletaNoExiste(){

        Mockito.doReturn(false).when(repositorioMotocicleta).existe(Mockito.anyLong());

        BasePrueba.assertThrows(()-> servicioActualizarMotocicleta.ejecutar(motocicleta),
                ExcepcionDuplicidad.class,
                LA_MOTOCICLETA_NO_EXISTE);

    }

    @Test
    @DisplayName("Deberia actualizar una motocicleta correctamente")
    void deberiaActualizarUnaMotocicletaCorrectamente(){

        Mockito.doReturn(true).when(repositorioMotocicleta).existe(Mockito.anyLong());

        servicioActualizarMotocicleta.ejecutar(motocicleta);

        Mockito.verify(repositorioMotocicleta,Mockito.times(1)).actualizar(motocicleta);

    }

}
