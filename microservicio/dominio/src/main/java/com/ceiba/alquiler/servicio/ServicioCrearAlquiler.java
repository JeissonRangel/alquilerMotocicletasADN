package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

import java.time.LocalDate;

public class ServicioCrearAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;

    private LocalDate FECHA_ACTUAL = LocalDate.now();

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public Long ejecutar(Alquiler alquiler){
        alquiler.setFechaDevolucion(calcularFechaDevolucion(alquiler));
        return this.repositorioAlquiler.crear(alquiler);
    };

    private LocalDate calcularFechaDevolucion(Alquiler alquiler){
        return FECHA_ACTUAL.plusDays((long) alquiler.getCantidadDiasAlquiler());
    }
}
