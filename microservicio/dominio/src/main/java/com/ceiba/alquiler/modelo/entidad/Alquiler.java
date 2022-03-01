package com.ceiba.alquiler.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static  com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Alquiler {
    private static final String DEBE_INGRESAR_UNA_IDENTIFICACION = "Debe ingresar una identificacion de persona";
    private static final String DEBE_INGRESAR_UNA_CANTIDAD_DE_DIAS_VALIDA = "La cantidad de dias que ingreso no es valida";

    private Long id; // NOSONAR
    private Long personaId; // NOSONAR
    private Long motocicletaId; // NOSONAR
    private int cantidadDiasAlquiler; // NOSONAR
    private LocalDate fechaDevolucion; // NOSONAR
    private Boolean planeaSalirDeLaCiudad; // NOSONAR
    private Boolean planeaLlevarParrillero; // NOSONAR

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

        this.id = id;
        this.personaId = personaId;
        this.motocicletaId = motocicletaId;
        this.cantidadDiasAlquiler = cantidadDiasAlquiler;
        this.fechaDevolucion = LocalDate.now().plusDays(cantidadDiasAlquiler);
        this.planeaSalirDeLaCiudad = planeaSalirDeLaCiudad;
        this.planeaLlevarParrillero = planeaLlevarParrillero;
    }
}
