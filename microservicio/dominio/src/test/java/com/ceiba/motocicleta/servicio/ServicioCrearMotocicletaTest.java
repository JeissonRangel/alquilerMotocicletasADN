package com.ceiba.motocicleta.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ServicioCrearMotocicletaTest {

    @Mock
    private RepositorioMotocicleta repositorioMotocicleta;

    @InjectMocks
    private ServicioCrearMotocicleta servicioCrearMotocicleta;

    private static final String DEBE_INGRESA_NOMBRE_MOTOCICLETA = "Debe ingresar el nombre de la motocicleta";
    private static final String LONGITUD_DE_NOMBRE_DEBE_SER_MINIMO = "El nombre de la motocicleta debe tener al menos 4 letras";

    @Test
    @DisplayName("Deberia lanzar una excepcion si no se ingresa un nombre de motocicleta")
    void deberiaLanzarExcepcionSiNoIngresaNombreMotocicleta(){
        MotocicletaTestDataBuilder motocicletaTestDataBuilder = new MotocicletaTestDataBuilder().conNombre(null);

        BasePrueba.assertThrows(()->motocicletaTestDataBuilder.build(),
                ExcepcionValorObligatorio.class,
                DEBE_INGRESA_NOMBRE_MOTOCICLETA);
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion si el nombre de la motocicleta tiene una longitud menor a 4 caracteres")
    void deberiaLanzarExcepcionSiLongitudNombreMotocicletaMenorCuatro(){
        MotocicletaTestDataBuilder motocicletaTestDataBuilder = new MotocicletaTestDataBuilder().conNombre("abc");

        BasePrueba.assertThrows(()->motocicletaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                LONGITUD_DE_NOMBRE_DEBE_SER_MINIMO);
    }

    @Test
    @DisplayName("Deberia crear la motocicleta correctamente")
    void deberiaCrearMotocicletaCorrectamente(){
        Motocicleta motocicleta = new MotocicletaTestDataBuilder().conId(1L).build();
        Mockito.doReturn(1L).when(repositorioMotocicleta).crear(motocicleta);

        Long idMotocicleta = servicioCrearMotocicleta.ejecutar(motocicleta);

        assertEquals(1L,idMotocicleta);
        Mockito.verify(repositorioMotocicleta,Mockito.times(1)).crear(motocicleta);
    }
}
