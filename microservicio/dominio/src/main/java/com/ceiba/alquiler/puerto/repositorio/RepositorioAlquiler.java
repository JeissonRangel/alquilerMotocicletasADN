package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;

public interface RepositorioAlquiler {
    Long crear(Alquiler alquiler);
    void actualizar(Alquiler alquiler);
}
