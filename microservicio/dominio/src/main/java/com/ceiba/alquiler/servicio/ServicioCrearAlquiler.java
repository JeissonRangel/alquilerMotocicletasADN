package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

import java.time.LocalDate;

public class ServicioCrearAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;
    private final RepositorioMotocicleta repositorioMotocicleta;
    private final DaoMotocicleta daoMotocicleta;

    private LocalDate FECHA_ACTUAL = LocalDate.now();

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler,
                                 RepositorioMotocicleta repositorioMotocicleta,
                                 DaoMotocicleta daoMotocicleta) {
        this.repositorioAlquiler = repositorioAlquiler;
        this.repositorioMotocicleta = repositorioMotocicleta;
        this.daoMotocicleta = daoMotocicleta;
    }

    public Long ejecutar(Alquiler alquiler){
        calcularFechaDevolucion(alquiler);
        return this.repositorioAlquiler.crear(alquiler);
    };

    private LocalDate calcularFechaDevolucion(Alquiler alquiler){
        return FECHA_ACTUAL.plusDays(alquiler.getCantidadDiasAlquiler());
    }
}
