package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionNoMotocicletasDisponibles;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

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
        Long motocicletaId = traerIdMotocicletaDisponible();

        Alquiler alquilerCalculado = new Alquiler(
                alquiler.getId(),
                alquiler.getPersonaId(),
                motocicletaId,
                alquiler.getCantidadDiasAlquiler(),
                alquiler.getPlaneaSalirDeLaCiudad(),
                alquiler.getPlaneaLlevarParrillero()
        );

        return this.repositorioAlquiler.crear(alquilerCalculado);
    }

    private void validarDisponibilidadMotocicletas(){
        Boolean motocicletasDisponibles = this.repositorioMotocicleta.validarDisponibilidad();
        if (!motocicletasDisponibles)
            throw new ExcepcionNoMotocicletasDisponibles(NO_HAY_MOTOCICLETAS_DISPONIBLES);
    }

    private Long traerIdMotocicletaDisponible(){
        Boolean disponibilidadActualizada = false;
        Long motocicletaIdDisponible = this.daoMotocicleta.buscarDisponible().getId();
        actualizarDisponibilidadMotocicleta(motocicletaIdDisponible,disponibilidadActualizada);
        return motocicletaIdDisponible;
    }

    private void actualizarDisponibilidadMotocicleta(Long motocicletaId, Boolean disponible){
        repositorioMotocicleta.actualizarDisponibilidadPorId(motocicletaId, disponible);
    }

}