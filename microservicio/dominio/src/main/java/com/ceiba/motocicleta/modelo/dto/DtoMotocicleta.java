package com.ceiba.motocicleta.modelo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class DtoMotocicleta {
    private Long id;
    private String nombre;
    private double valorMotocicleta;
    private int anioModelo;
    private boolean disponible;
}
