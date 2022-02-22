package com.ceiba.alquiler.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static  com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@Setter
public class Factura {

    private Long id;
    private Long idAlquiler;
    private Double valorTotal;
    private Double seguroVehiculo;
    private Double polizaPersonal;
    private LocalDate fechaCompra;

    public Factura(
            Long id,
            Long idAlquiler,
            Double valorTotal,
            Double seguroVehiculo,
            Double polizaPersonal,
            LocalDate fechaCompra
    ) {
        this.id = id;
        this.idAlquiler = idAlquiler;
        this.valorTotal = valorTotal;
        this.seguroVehiculo = seguroVehiculo;
        this.polizaPersonal = polizaPersonal;
        this.fechaCompra = fechaCompra;
    }
}
