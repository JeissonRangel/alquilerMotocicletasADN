package com.ceiba.alquiler.adaptador.dao;

import com.ceiba.alquiler.modelo.dto.DtoFactura;
import com.ceiba.alquiler.puerto.dao.DaoFactura;

import java.util.List;

public class DaoFacturaH2 implements DaoFactura {
    @Override
    public List<DtoFactura> listar() {
        return null;
    }

    @Override
    public DtoFactura buscarPorId(Long id) {
        return null;
    }
}
