package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionNoMotocicletasDisponibles;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

import java.time.LocalDate;

public class ServicioCrearAlquiler {

    private final String NO_HAY_MOTOCICLETAS_DISPONIBLES = "En este momento no hay motocicletas disponibles para alquilar";
    private final RepositorioAlquiler repositorioAlquiler;
    private final RepositorioMotocicleta repositorioMotocicleta;
    private final DaoMotocicleta daoMotocicleta;

    private LocalDate FECHA_DEVOLUCION = LocalDate.now();

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
        calcularFechaDevolucion(alquiler);
        asignarMotocicletaDisponible(alquiler);
        return this.repositorioAlquiler.crear(alquiler);
    };

    private void validarDisponibilidadMotocicletas(){
        Boolean MOTOCICLETAS_DISPONIBLES = this.daoMotocicleta.validarDisponibilidad();

        if (!MOTOCICLETAS_DISPONIBLES)
            throw new ExcepcionNoMotocicletasDisponibles(NO_HAY_MOTOCICLETAS_DISPONIBLES);
    }

    private void asignarMotocicletaDisponible(Alquiler alquiler){
        Boolean DISPONIBILIDAD_ACTUALIZADA = false;
        DtoMotocicleta motocicleta = this.daoMotocicleta.buscarDisponible();
        alquiler.setMotocicletaID(motocicleta.getId());
        actualizarDisponibilidadMotocicleta(motocicleta.getId(),DISPONIBILIDAD_ACTUALIZADA);
    }

    private void actualizarDisponibilidadMotocicleta(Long motocicletaId, Boolean disponible){
        repositorioMotocicleta.actualizarDisponibilidadPorId(motocicletaId, disponible);
    }

    private void calcularFechaDevolucion(Alquiler alquiler){
        int DIAS_A_SUMAR = alquiler.getCantidadDiasAlquiler();
        FECHA_DEVOLUCION.plusDays(DIAS_A_SUMAR);
        alquiler.setFechaDevolucion(FECHA_DEVOLUCION);
    }

}
