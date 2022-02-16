package com.ceiba.alquiler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAlquiler {
    private Long id;
    private Long personaId;
    private int cantidadDiasAlquiler;
    private boolean planeaSalirDeLaCiudad;
    private boolean planeaLlevarParrillero;
}
