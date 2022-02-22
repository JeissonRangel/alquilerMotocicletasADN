package com.ceiba.alquiler.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoFactura {
    private Long id;
    private Long idAlquiler;
    private Double valorTotal;
    private Double seguroVehiculo;
    private Double polizaPersonal;
    private LocalDate fechaCompra;
}
