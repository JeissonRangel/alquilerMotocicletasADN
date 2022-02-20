package com.ceiba.motocicleta.puerto.dao;

import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;

import java.util.List;

public interface DaoMotocicleta {
    List<DtoMotocicleta> listar();
    DtoMotocicleta buscarPorId(Long id);
    DtoMotocicleta buscarDisponible();
    Boolean validarDisponibilidad();
}
