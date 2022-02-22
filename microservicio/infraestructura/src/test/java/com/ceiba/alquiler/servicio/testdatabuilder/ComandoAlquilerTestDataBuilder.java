package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoAlquiler;

import java.time.LocalDate;

public class ComandoAlquilerTestDataBuilder {

    private Long id;
    private Long personaId;
    private Long motocicletaID;
    private int cantidadDiasAlquiler;
    private LocalDate fechaDevolucion;
    private Boolean planeaSalirDeLaCiudad;
    private Boolean planeaLlevarParrillero;

    public ComandoAlquilerTestDataBuilder() {
        personaId = 1L;
        motocicletaID = 1L;
        cantidadDiasAlquiler = 10;
        fechaDevolucion = null;
        planeaSalirDeLaCiudad = true;
        planeaLlevarParrillero = true;
    }

    public ComandoAlquilerTestDataBuilder sinPersonaId(){
        this.personaId = null;
        return this;
    }
    public ComandoAlquilerTestDataBuilder sinMotocicletaId(){
        this.motocicletaID = null;
        return this;
    }
    public ComandoAlquiler build(){
        return new ComandoAlquiler(id,
                personaId,
                motocicletaID,
                cantidadDiasAlquiler,
                fechaDevolucion,
                planeaSalirDeLaCiudad,
                planeaLlevarParrillero);
    }
}
