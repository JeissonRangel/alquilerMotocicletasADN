package com.ceiba.motocicleta.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.servicio.testdatabuilder.MotocicletaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotocicletaTest {
    private static final String DEBE_INGRESA_NOMBRE_MOTOCICLETA = "Debe ingresar el nombre de la motocicleta";
    private static final String LONGITUD_DE_NOMBRE_DEBE_SER_MINIMO = "El nombre de la motocicleta debe tener al menos 4 letras";
    private static final String VALOR_MOTOCICLETA_NO_PERMITIDO = "Ingrese un valor de motocicleta valido";
    private static final String DEBE_INGRESAR_ANIO_MODELO_VALIDO = "Debe ingresar un año de modelo valido";

    @Test
    @DisplayName("Deberia crear correctamente la motocicleta")
    void deberiaCrearCorrectamenteLaMotocicleta(){
        Motocicleta motocicleta = new MotocicletaTestDataBuilder().conId(1L).build();

        assertEquals(1,motocicleta.getId());
        assertEquals("YAMAHA R1M",motocicleta.getNombre());
        assertEquals(10000000D,motocicleta.getValorMotocicleta());
        assertEquals(2001,motocicleta.getAnioModelo());
        assertEquals(true,motocicleta.getDisponible());
    }

    @Test
    @DisplayName("Deberia fallar si no se ingresa el nombre de la motocicleta")
    void deberiaFallarSiNoIngresaNombreMotocicleta(){
        MotocicletaTestDataBuilder motocicletaTestDataBuilder = new MotocicletaTestDataBuilder().conNombre(null);

        BasePrueba.assertThrows(()->{
            motocicletaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,DEBE_INGRESA_NOMBRE_MOTOCICLETA);
    }

    @Test
    @DisplayName("Deberia fallar si el nombre es de menos de 4 caracteres")
    void deberiaFallarSiNombreMotocicletaLongitudMenorACuatro(){
        MotocicletaTestDataBuilder motocicletaTestDataBuilder = new MotocicletaTestDataBuilder().conNombre("abc");

        BasePrueba.assertThrows(()->{
            motocicletaTestDataBuilder.build();
        }, ExcepcionLongitudValor.class,LONGITUD_DE_NOMBRE_DEBE_SER_MINIMO);
    }

    @Test
    @DisplayName("Deberia fallar si el valor de la motocicleta es cero")
    void deberiaFallarSiValorMotocicletaEsCero(){
        MotocicletaTestDataBuilder motocicletaTestDataBuilder = new MotocicletaTestDataBuilder().conValorMotocicleta(0D);

        BasePrueba.assertThrows(()->{
            motocicletaTestDataBuilder.build();
        }, ExcepcionValorInvalido.class,VALOR_MOTOCICLETA_NO_PERMITIDO);
    }

    @Test
    @DisplayName("Deberia fallar si no se ingresa un anio de modelo mayor a cero")
    void deberiaFallarSiNoSeIngresaAnioModeloMayorACero(){
        MotocicletaTestDataBuilder motocicletaTestDataBuilder = new MotocicletaTestDataBuilder().conAnioModelo(0);

        BasePrueba.assertThrows(()->{
            motocicletaTestDataBuilder.build();
        }, ExcepcionValorInvalido.class,DEBE_INGRESAR_ANIO_MODELO_VALIDO);
    }
}
