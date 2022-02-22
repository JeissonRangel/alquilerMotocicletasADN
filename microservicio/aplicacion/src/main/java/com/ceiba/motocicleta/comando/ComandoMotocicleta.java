package com.ceiba.motocicleta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMotocicleta {
    private Long id;
    private String nombre;
    private Double valorMotocicleta;
    private int anioModelo;
    private Boolean disponible;
}
