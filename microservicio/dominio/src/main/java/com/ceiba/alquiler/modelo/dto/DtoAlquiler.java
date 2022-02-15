package com.ceiba.alquiler.modelo.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;


@Getter
@AllArgsConstructor
public class DtoAlquiler {
    private Long id;
    private Long personaId;
    private int cantidadDiasAlquiler;
    private boolean planeaSalirDeLaCiudad;
    private boolean planeaLlevarParrillero;
}
