package com.ceiba.motocicleta.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@Setter
public class Motocicleta {
    private static final String DEBE_INGRESA_NOMBRE_MOTOCICLETA = "Debe ingresar el nombre de la motocicleta";
    private static final String LONGITUD_DE_NOMBRE_DEBE_SER_MINIMO = "El nombre de la motocicleta debe tener al menos 4 letras";
    private static final String VALOR_MOTOCICLETA_NO_PERMITIDO = "Ingrese un valor de motocicleta valido";
    private static final String DEBE_INGRESAR_ANIO_MODELO_VALIDO = "Debe ingresar un año de modelo valido";
    private static final int LONGITUD_MINIMA_NOMBRE = 4;

    private Long id; // NOSONAR
    private String nombre; // NOSONAR
    private Double valorMotocicleta; // NOSONAR
    private int anioModelo; // NOSONAR
    private Boolean disponible; // NOSONAR

    public Motocicleta(Long id, String nombre, Double valorMotocicleta, int anioModelo) {
        validarObligatorio(nombre,DEBE_INGRESA_NOMBRE_MOTOCICLETA);
        validarLongitud(nombre,LONGITUD_MINIMA_NOMBRE, LONGITUD_DE_NOMBRE_DEBE_SER_MINIMO);
        validarPositivo(valorMotocicleta, VALOR_MOTOCICLETA_NO_PERMITIDO);
        validarPositivo((double) anioModelo,DEBE_INGRESAR_ANIO_MODELO_VALIDO);
        this.id = id;
        this.nombre = nombre;
        this.valorMotocicleta = valorMotocicleta;
        this.anioModelo = anioModelo;
        this.disponible = true;
    }
}
