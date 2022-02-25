package com.ceiba.alquiler.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static  com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@Setter
public class Factura {

    private Long id; // NOSONAR
    private Long idAlquiler; // NOSONAR
    private Double valorTotal; // NOSONAR
    private Double seguroVehiculo; // NOSONAR
    private Double polizaPersonal; // NOSONAR
    private LocalDate fechaCompra; // NOSONAR

    public Factura(
            Long id,
            Long idAlquiler,
            Double valorTotal,
            Double seguroVehiculo,
            Double polizaPersonal,
            LocalDate fechaCompra) {
        this.id = id; // NOSONAR
        this.idAlquiler = idAlquiler; // NOSONAR
        this.valorTotal = valorTotal; // NOSONAR
        this.seguroVehiculo = seguroVehiculo; // NOSONAR
        this.polizaPersonal = polizaPersonal; // NOSONAR
        this.fechaCompra = fechaCompra; // NOSONAR
    }
}
