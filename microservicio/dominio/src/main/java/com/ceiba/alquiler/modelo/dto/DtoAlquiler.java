package com.ceiba.alquiler.modelo.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class DtoAlquiler {
    private Long id;
    private Long personaId;
    private Long motocicletaID;
    private int cantidadDiasAlquiler;
    private LocalDate fechaDevolucion;
    private boolean planeaSalirDeLaCiudad;
    private boolean planeaLlevarParrillero;
}
