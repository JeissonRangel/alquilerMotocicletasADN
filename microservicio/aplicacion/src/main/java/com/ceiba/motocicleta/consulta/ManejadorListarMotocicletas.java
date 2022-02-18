package com.ceiba.motocicleta.consulta;

import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMotocicletas {
    private final DaoMotocicleta daoMotocicleta;

    public ManejadorListarMotocicletas(DaoMotocicleta daoMotocicleta) {
        this.daoMotocicleta = daoMotocicleta;
    }

    public List<DtoMotocicleta> ejecutar(){
        return this.daoMotocicleta.listar();
    };
}
