package com.ceiba.alquiler.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAlquiler implements ManejadorComando<Long> {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ManejadorEliminarAlquiler(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public void ejecutar(Long idAlquiler){
        this.servicioEliminarUsuario.ejecutar(idAlquiler);
    }
}
