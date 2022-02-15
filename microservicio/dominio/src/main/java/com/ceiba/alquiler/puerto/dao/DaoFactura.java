package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoFactura;

import java.util.List;


public interface DaoFactura {

    List<DtoFactura> listar();

    DtoFactura buscarPorId(Long id);

}
