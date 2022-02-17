package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

public class ServicioCrearAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;
    private final RepositorioMotocicleta repositorioMotocicleta;
    private final DaoMotocicleta daoMotocicleta;

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler,
                                 RepositorioMotocicleta repositorioMotocicleta,
                                 DaoMotocicleta daoMotocicleta) {
        this.repositorioAlquiler = repositorioAlquiler;
        this.repositorioMotocicleta = repositorioMotocicleta;
        this.daoMotocicleta = daoMotocicleta;
    }

    public Long ejecutar(Alquiler alquiler){
        return this.repositorioAlquiler.crear(alquiler);
    };

}
