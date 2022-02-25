package com.ceiba.alquiler.modelo.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoFactura {
    private Long id;
    private Long idAlquiler;
    private Double valorTotal;
    private Double seguroVehiculo;
    private Double polizaPersonal;
    private LocalDate fechaCompra;
}
