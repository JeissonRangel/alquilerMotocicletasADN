package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionNoMotocicletasDisponibles;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

import java.time.LocalDate;

public class ServicioCrearAlquiler {

    private static final String NO_HAY_MOTOCICLETAS_DISPONIBLES = "En este momento no hay motocicletas disponibles para alquilar";
    private final RepositorioAlquiler repositorioAlquiler;
    private final RepositorioMotocicleta repositorioMotocicleta;
    private final DaoMotocicleta daoMotocicleta;

    public ServicioCrearAlquiler(
            RepositorioAlquiler repositorioAlquiler,
            RepositorioMotocicleta repositorioMotocicleta,
            DaoMotocicleta daoMotocicleta)
    {
        this.repositorioAlquiler = repositorioAlquiler;
        this.repositorioMotocicleta = repositorioMotocicleta;
        this.daoMotocicleta = daoMotocicleta;
    }

    public Long ejecutar(Alquiler alquiler){
        validarDisponibilidadMotocicletas();
        LocalDate fechaDevolucion = calcularFechaDevolucion(alquiler);
        Long motocicletaId = traerIdMotocicletaDisponible();
        return this.repositorioAlquiler.crear(alquiler);
    }

    private void validarDisponibilidadMotocicletas(){
        Boolean motocicletasDisponibles = this.daoMotocicleta.validarDisponibilidad();
        if (!motocicletasDisponibles)
            throw new ExcepcionNoMotocicletasDisponibles(NO_HAY_MOTOCICLETAS_DISPONIBLES);
    }

    private Long traerIdMotocicletaDisponible(){
        Boolean disponibilidadActualizada = false;
        DtoMotocicleta motocicleta = this.daoMotocicleta.buscarDisponible();
        actualizarDisponibilidadMotocicleta(motocicleta.getId(),disponibilidadActualizada);
        return
    }

    private void actualizarDisponibilidadMotocicleta(Long motocicletaId, Boolean disponible){
        repositorioMotocicleta.actualizarDisponibilidadPorId(motocicletaId, disponible);
    }

    private LocalDate calcularFechaDevolucion(Alquiler alquiler){
        int diasASumar = alquiler.getCantidadDiasAlquiler();
        LocalDate fechaDevolucionCalculada = LocalDate.now().plusDays(diasASumar);
        return fechaDevolucionCalculada;
    }

}