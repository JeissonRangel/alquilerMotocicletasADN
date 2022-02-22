package com.ceiba.motocicleta.servicio.testdatabuilder;

import com.ceiba.motocicleta.comando.ComandoMotocicleta;

public class ComandoMotocicletaTestDataBuilder {

    private Long id;
    private String nombre;
    private Double valorMotocicleta;
    private int anioModelo;
    private Boolean disponible;

    public ComandoMotocicletaTestDataBuilder() {
        id = 1L;
        nombre = "YAMAHA R1M";
        valorMotocicleta = 1000000D;
        anioModelo = 2020;
        disponible = true;
    }

    public ComandoMotocicletaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoMotocicletaTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ComandoMotocicletaTestDataBuilder sinValorMotocicleta(){
        this.valorMotocicleta = null;
        return this;
    }

    public ComandoMotocicletaTestDataBuilder conAnioModelo(int anioModelo){
        this.anioModelo = anioModelo;
        return this;
    }

    public ComandoMotocicletaTestDataBuilder noDisponible(){
        this.disponible = false;
        return this;
    }

    public ComandoMotocicleta build(){
        return new ComandoMotocicleta(
                id,
                nombre,
                valorMotocicleta,
                anioModelo,
                disponible
        );
    }
}
