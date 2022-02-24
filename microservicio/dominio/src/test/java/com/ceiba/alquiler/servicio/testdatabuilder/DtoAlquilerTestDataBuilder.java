package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;

import java.time.LocalDate;

public class DtoAlquilerTestDataBuilder {
    private Long id;
    private Long personaId;
    private Long motocicletaId;
    private int cantidadDiasAlquiler;
    private LocalDate fechaDevolucion;
    private boolean planeaSalirDeLaCiudad;
    private boolean planeaLlevarParrillero;

    public DtoAlquilerTestDataBuilder() {
        this.id=1L;
        this.personaId=1L;
        this.motocicletaId=1L;
        this.cantidadDiasAlquiler=10;
        this.fechaDevolucion=null;
        this.planeaSalirDeLaCiudad=true;
        this.planeaLlevarParrillero=true;
    }

    public DtoAlquilerTestDataBuilder noPlaneaSalirCiudad(){
        this.planeaSalirDeLaCiudad=false;
        return this;
    }

    public DtoAlquilerTestDataBuilder noPlaneaLlevarParillero(){
        this.planeaLlevarParrillero=false;
        return this;
    }

    public DtoAlquiler build(){
        return new DtoAlquiler(
                id,
                personaId,
                motocicletaId,
                cantidadDiasAlquiler,
                fechaDevolucion,
                planeaSalirDeLaCiudad,
                planeaLlevarParrillero);
    }
}
