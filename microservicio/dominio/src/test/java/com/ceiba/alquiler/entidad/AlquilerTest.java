package com.ceiba.alquiler.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlquilerTest {

    private static final String DEBE_INGRESAR_UNA_IDENTIFICACION = "Debe ingresar una identificacion";
    private static final String DEBE_INGRESAR_UNA_CANTIDAD_DE_DIAS_VALIDA = "La cantidad de dias que ingreso no es valida";
    private static final String DEBE_INGRESAR_ID_MOTOCICLETA = "Debe ingresar un id de una motocicleta";


    @Test
    @DisplayName("Deberia crear correctamente el alquiler")
    void deberiaCrearCorrectamenteElAlquiler(){
        Alquiler alquiler = new AlquilerTestDataBuilder().conId(1L).build();

        assertEquals(1,alquiler.getId());
        assertEquals(1,alquiler.getPersonaId());
        assertEquals(1,alquiler.getMotocicletaID());
        assertEquals(10,alquiler.getCantidadDiasAlquiler());
        assertEquals(null,alquiler.getFechaDevolucion());
        assertEquals(true,alquiler.getPlaneaSalirDeLaCiudad());
        assertEquals(true,alquiler.getPlaneaLlevarParrillero());

    }

    @Test
    void deberiaFallarSinIdentificacionDePersona(){
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conId(1L).sinPersonaId();
        BasePrueba.assertThrows(() -> {
            alquilerTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, DEBE_INGRESAR_UNA_IDENTIFICACION);
    }

    @Test
    void deberiaFallarSinMotocicletaId(){
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conId(1L).sinMotocicletaId();
        BasePrueba.assertThrows(()->{
            alquilerTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,DEBE_INGRESAR_ID_MOTOCICLETA);
    }

    @Test
    void deberiaFallarSiCantidadDiasAlquilerCero(){
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conId(1L).conCantidadDiasAlquilerCero();
        BasePrueba.assertThrows(()->{
            alquilerTestDataBuilder.build();
        }, ExcepcionValorInvalido.class,DEBE_INGRESAR_UNA_CANTIDAD_DE_DIAS_VALIDA);
    }
}
