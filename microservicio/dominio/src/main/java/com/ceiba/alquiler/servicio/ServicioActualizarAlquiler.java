package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAlquiler {

    private static final String EL_ALQUILER_NO_EXISTE = "Este alquiler no existe en el sistema";
    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioActualizarAlquiler(
            RepositorioAlquiler repositorioAlquiler
    ) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public void ejecutar(Alquiler alquiler){
        validarExistenciaPrevia(alquiler);
        this.repositorioAlquiler.actualizar(alquiler);
    }

    private void validarExistenciaPrevia(Alquiler alquiler){
        Boolean existe = this.repositorioAlquiler.existePorId(alquiler.getId());
        if (!existe){
            throw new ExcepcionDuplicidad(EL_ALQUILER_NO_EXISTE);
        }
    }

}
