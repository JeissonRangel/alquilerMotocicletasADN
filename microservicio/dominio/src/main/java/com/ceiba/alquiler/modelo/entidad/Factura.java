package com.ceiba.alquiler.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;

@Getter
@Setter
public class Factura {

    private Long id;
    private Double valorTotal;
    private HashMap<String,Double> conceptosFactura;
    private LocalDate fechaCompra;

    public Factura(Long id, Double valorTotal, HashMap<String, Double> conceptosFactura, LocalDate fechaCompra) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.conceptosFactura = conceptosFactura;
        this.fechaCompra = fechaCompra;
    }
}
