package com.ceiba.motocicleta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.motocicleta.servicio.ServicioEliminarMotocicleta;

public class ManejadorEliminarMotocicleta implements ManejadorComando<Long> {
    private final ServicioEliminarMotocicleta servicioEliminarMotocicleta;

    public ManejadorEliminarMotocicleta(ServicioEliminarMotocicleta servicioEliminarMotocicleta) {
        this.servicioEliminarMotocicleta = servicioEliminarMotocicleta;
    }

    public void ejecutar(Long idMotocicleta){
        this.servicioEliminarMotocicleta.ejecutar(idMotocicleta);
    }
}
