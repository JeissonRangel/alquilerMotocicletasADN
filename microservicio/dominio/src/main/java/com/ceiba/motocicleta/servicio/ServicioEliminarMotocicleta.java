package com.ceiba.motocicleta.servicio;

import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

public class ServicioEliminarMotocicleta {

    private final RepositorioMotocicleta repositorioMotocicleta;

    public ServicioEliminarMotocicleta(RepositorioMotocicleta repositorioMotocicleta) {
        this.repositorioMotocicleta = repositorioMotocicleta;
    }

    public void ejecutar(Long id){
        this.repositorioMotocicleta.eliminar(id);
    }
}
