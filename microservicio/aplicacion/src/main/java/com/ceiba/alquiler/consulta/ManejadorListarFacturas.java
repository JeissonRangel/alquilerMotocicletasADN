package com.ceiba.alquiler.consulta;

import com.ceiba.alquiler.modelo.dto.DtoFactura;
import com.ceiba.alquiler.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarFacturas {
    private final DaoFactura daoFactura;

    public ManejadorListarFacturas(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }

    public List<DtoFactura> ejecutar(){
        return this.daoFactura.listar();
    }
}
