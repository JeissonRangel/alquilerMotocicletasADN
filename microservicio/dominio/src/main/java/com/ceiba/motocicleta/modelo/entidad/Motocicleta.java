package com.ceiba.motocicleta.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Motocicleta {
    private static final String DEBE_INGRESAR_VALOR_MOTOCICLETA = "Debe ingresar el valor de la motocicleta";
    private static final String DEBE_INGRESAR_ANIO_MODELO = "Debe ingresar el año del modelo de la motocicleta";

    private Long id;
    private Double valorMotocicleta;
    private String anioModelo;
    private Boolean disponible;

    public Motocicleta(Long id, Double valorMotocicleta, String anioModelo, Boolean disponible) {
        validarObligatorio(valorMotocicleta,DEBE_INGRESAR_VALOR_MOTOCICLETA);
        validarObligatorio(anioModelo,DEBE_INGRESAR_ANIO_MODELO);
        this.id = id;
        this.valorMotocicleta = valorMotocicleta;
        this.anioModelo = anioModelo;
        this.disponible = disponible;
    }
}
