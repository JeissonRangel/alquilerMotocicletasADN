package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;

import java.util.List;

public interface DaoAlquiler {
    List<DtoAlquiler> listar();
    DtoAlquiler buscarPorId(Long id);
}
