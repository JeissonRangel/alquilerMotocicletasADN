package com.ceiba.alquiler.modelo.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Map;


public class DtoFactura {
    private Long id;
    private Long idAlquiler;
    private double valorTotal;
    private Map<Integer,String> conceptosFactura;
    private LocalDate fechaCompra;
}
