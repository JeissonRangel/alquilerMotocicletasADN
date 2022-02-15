package com.ceiba.alquiler.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
public class Factura {

    private Long id;
    private double valorTotal;
    private Map<Integer,String> conceptosFactura;
    private LocalDate fechaCompra;

    public Factura(Long id, double valorTotal, Map<Integer, String> conceptosFactura, LocalDate fechaCompra) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.conceptosFactura = conceptosFactura;
        this.fechaCompra = fechaCompra;
    }
}
