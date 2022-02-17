package com.ceiba.alquiler.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static  com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@Setter
public class Alquiler {
    private static final String DEBE_INGRESAR_UNA_IDENTIFICACION = "Debe ingresar una identificacion";
    private static final String DEBE_INGRESAR_UNA_CANTIDAD_DE_DIAS_VALIDA = "La cantidad de dias que ingreso no es valida";
    private static final String DEBE_INGRESAR_ID_MOTOCICLETA = "Debe ingresar un id de una motocicleta";

    private Long id;
    private Long personaId;
    private Long motocicletaID;
    private int cantidadDiasAlquiler;
    private Boolean planeaSalirDeLaCiudad;
    private Boolean planeaLlevarParrillero;

    public Alquiler(
            Long id,
            Long personaId,
            Long motocicletaId,
            int cantidadDiasAlquiler,
            Boolean planeaSalirDeLaCiudad,
            Boolean planeaLlevarParrillero
    ) {
        validarObligatorio(personaId,DEBE_INGRESAR_UNA_IDENTIFICACION);
        validarPositivo((double) cantidadDiasAlquiler,DEBE_INGRESAR_UNA_CANTIDAD_DE_DIAS_VALIDA);
        validarObligatorio(motocicletaId, DEBE_INGRESAR_ID_MOTOCICLETA);

        this.id = id;
        this.personaId = personaId;
        this.motocicletaID = motocicletaId;
        this.cantidadDiasAlquiler = cantidadDiasAlquiler;
        this.planeaSalirDeLaCiudad = planeaSalirDeLaCiudad;
        this.planeaLlevarParrillero = planeaLlevarParrillero;
    }
}
