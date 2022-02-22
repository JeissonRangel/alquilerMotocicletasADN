package com.ceiba.motocicleta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

public class ServicioActualizarMotocicleta {

    private static final String LA_MOTOCICLETA_NO_EXISTE = "Esta motocicleta no existe en el sismtema";
    private final RepositorioMotocicleta repositorioMotocicleta;
    private final DaoMotocicleta daoMotocicleta;

    public ServicioActualizarMotocicleta(RepositorioMotocicleta repositorioMotocicleta, DaoMotocicleta daoMotocicleta) {
        this.repositorioMotocicleta = repositorioMotocicleta;
        this.daoMotocicleta = daoMotocicleta;
    }

    public void ejecutar(Motocicleta motocicleta){
        validarExistenciaMotocicleta(motocicleta);
        this.repositorioMotocicleta.actualizar(motocicleta);
    }

    private void validarExistenciaMotocicleta(Motocicleta motocicleta){
        Boolean existe = this.daoMotocicleta.existe(motocicleta.getId());
        if (!existe){
            throw new ExcepcionDuplicidad(LA_MOTOCICLETA_NO_EXISTE);
        }
    }
}
