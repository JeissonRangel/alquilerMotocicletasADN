package com.ceiba.motocicleta.puerto.repositorio;

import com.ceiba.motocicleta.modelo.entidad.Motocicleta;

public interface RepositorioMotocicleta {
    Long crear(Motocicleta motocicleta);
    void actualizar(Motocicleta motocicleta);
    void actualizarDisponibilidadPorId(Long id, Boolean disponible);
    void eliminar(Long id);
    Boolean validarDisponibilidad();
    Boolean existe(Long id);
}
