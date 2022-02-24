package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;

public class DtoMotocicletaTestDataBuilder {
    private Long id;
    private String nombre;
    private double valorMotocicleta;
    private int anioModelo;
    private boolean disponible;

    public DtoMotocicletaTestDataBuilder() {
        this.id = 1L;
        this.nombre = "YAMAHA R1M";
        this.valorMotocicleta = 1560D;
        this.anioModelo=2020;
        this.disponible=true;
    }

    public DtoMotocicletaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public DtoMotocicleta build(){
        return new DtoMotocicleta(
                id,
                nombre,
                valorMotocicleta,
                anioModelo,
                disponible
        );
    }
}
