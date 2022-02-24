package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.entidad.Alquiler;

import java.time.LocalDate;

public class AlquilerTestDataBuilder {
    private Long id;
    private Long personaId;
    private Long motocicletaID;
    private int cantidadDiasAlquiler;
    private LocalDate fechaDevolucion;
    private Boolean planeaSalirDeLaCiudad;
    private Boolean planeaLlevarParrillero;

    public AlquilerTestDataBuilder(){
        id=1L;
        personaId = 1L;
        motocicletaID = 1L;
        cantidadDiasAlquiler=10;
        fechaDevolucion = null;
        planeaSalirDeLaCiudad = true;
        planeaLlevarParrillero = true;
    }

    public AlquilerTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }
    public AlquilerTestDataBuilder conMotocicletaId(Long motocicletaID){
        this.motocicletaID = motocicletaID;
        return this;
    }
    public AlquilerTestDataBuilder sinPersonaId(){
        this.personaId=null;
        return this;
    }
    public AlquilerTestDataBuilder sinMotocicletaId(){
        this.motocicletaID = null;
        return this;
    }

    public AlquilerTestDataBuilder conCantidadDiasAlquiler(int cantidadDiasAlquiler){
        this.cantidadDiasAlquiler = cantidadDiasAlquiler;
        return this;
    }

    public AlquilerTestDataBuilder conCantidadDiasAlquilerCero(){
        this.cantidadDiasAlquiler=0;
        return this;
    }
    public Alquiler build(){
        return new Alquiler(
                id,
                personaId,
                motocicletaID,
                cantidadDiasAlquiler,
                planeaSalirDeLaCiudad,
                planeaLlevarParrillero);
    }
}
