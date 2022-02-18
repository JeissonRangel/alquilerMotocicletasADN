package com.ceiba.motocicleta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoMotocicletaH2 implements DaoMotocicleta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "motocicleta", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "motocicleta", value = "buscaId")
    private static String sqlBuscarId;

    @SqlStatement(namespace = "motocicleta", value = "buscaDisponibles")
    private static String sqlBuscaDisponibles;

    public DaoMotocicletaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoMotocicleta> listar() {
        return null;
    }

    @Override
    public DtoMotocicleta buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<DtoMotocicleta> buscarDisponibles() {
        return null;
    }
}
