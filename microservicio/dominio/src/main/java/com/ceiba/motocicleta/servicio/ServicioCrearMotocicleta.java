package com.ceiba.motocicleta.servicio;

import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

public class ServicioCrearMotocicleta {
    private final RepositorioMotocicleta repositorioMotocicleta;

    public ServicioCrearMotocicleta(RepositorioMotocicleta repositorioMotocicleta) {
        this.repositorioMotocicleta = repositorioMotocicleta;
    }

    public Long ejecutar(Motocicleta motocicleta){
        return this.repositorioMotocicleta.crear(motocicleta);
    }
}
