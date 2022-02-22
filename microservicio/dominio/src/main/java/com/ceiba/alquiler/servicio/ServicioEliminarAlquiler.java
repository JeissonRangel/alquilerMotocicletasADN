package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;

public class ServicioEliminarAlquiler {
    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioEliminarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public void ejecutar(Long id){
        this.repositorioAlquiler.eliminar(id);
    }
}
