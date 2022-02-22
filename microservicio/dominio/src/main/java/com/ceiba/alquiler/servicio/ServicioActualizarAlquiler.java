package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAlquiler {

    private static final String EL_ALQUILER_NO_EXISTE = "Este alquiler no existe en el sistema";
    private final RepositorioAlquiler repositorioAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ServicioActualizarAlquiler(
            RepositorioAlquiler repositorioAlquiler,
            DaoAlquiler daoAlquiler
    ) {
        this.repositorioAlquiler = repositorioAlquiler;
        this.daoAlquiler = daoAlquiler;
    }

    public void ejecutar(Alquiler alquiler){
        validarExistenciaPrevia(alquiler);
        this.repositorioAlquiler.actualizar(alquiler);
    }

    private void validarExistenciaPrevia(Alquiler alquiler){
        Boolean existe = this.daoAlquiler.existePorId(alquiler.getId());
        if (!existe){
            throw new ExcepcionDuplicidad(EL_ALQUILER_NO_EXISTE);
        }
    }

}
