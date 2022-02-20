package com.ceiba.dominio.excepcion;

public class ExcepcionNoMotocicletasDisponibles extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionNoMotocicletasDisponibles(String mensaje){
        super(mensaje);
    }
}
