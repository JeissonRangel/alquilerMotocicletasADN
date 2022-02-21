package com.ceiba.alquiler.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;

import static  com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@Setter
public class Factura {
    private static final String DEBE_INGRESAR_UN_ID_ALQUILER = "Debe ingresar un id de alquiler";

    private Long id;
    private Long idAlquiler;
    private Double valorTotal;
    private HashMap<String,Double> conceptosFactura;
    private LocalDate fechaCompra;

    public Factura(
            Long id,
            Long idAlquiler,
            Double valorTotal,
            HashMap<String, Double> conceptosFactura,
            LocalDate fechaCompra
    ) {
        validarObligatorio(idAlquiler,DEBE_INGRESAR_UN_ID_ALQUILER);

        this.id = id;
        this.idAlquiler = idAlquiler;
        this.valorTotal = valorTotal;
        this.conceptosFactura = conceptosFactura;
        this.fechaCompra = fechaCompra;
    }
}
