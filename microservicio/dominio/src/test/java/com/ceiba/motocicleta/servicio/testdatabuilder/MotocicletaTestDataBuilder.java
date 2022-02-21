package com.ceiba.motocicleta.servicio.testdatabuilder;

import com.ceiba.motocicleta.modelo.entidad.Motocicleta;

public class MotocicletaTestDataBuilder {
    private Long id;
    private Double valorMotocicleta;
    private int anioModelo;
    private Boolean disponible;

    public MotocicletaTestDataBuilder() {
        this.id = 1L;
        this.valorMotocicleta = 10000000D;
        this.anioModelo = 2001;
        this.disponible = true;
    }

    public MotocicletaTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public MotocicletaTestDataBuilder conValorMotocicleta(Double valorMotocicleta){
        this.valorMotocicleta=valorMotocicleta;
        return this;
    }

    public MotocicletaTestDataBuilder conAnioModelo(int anioModelo){
        this.anioModelo=anioModelo;
        return this;
    }

    public MotocicletaTestDataBuilder noDisponible(){
        this.disponible=false;
        return this;
    }

    public Motocicleta build(){
        return new Motocicleta(
                this.id,
                this.valorMotocicleta,
                this.anioModelo,
                this.disponible
        );
    }
}
