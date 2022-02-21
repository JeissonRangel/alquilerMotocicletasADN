package com.ceiba.alquiler.servicio.testdatabuilder;

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
        personaId = 1090494353L;
        motocicletaID = 1L;
        cantidadDiasAlquiler=10;
        planeaSalirDeLaCiudad=true;
        planeaLlevarParrillero=true;
    }

    public AlquilerTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }
    public AlquilerTestDataBuilder sinPersonaId(Long personaId){
        this.personaId=null;
        return this;
    }
    public AlquilerTestDataBuilder sinMotocicletaId(Long motocicletaID){
        this.motocicletaID = null;
        return this;
    }
    public AlquilerTestDataBuilder conCantidadDiasAlquilerCero(int diasAlquiler){
        this.cantidadDiasAlquiler=0;
        return this;
    }
}
