package com.ceiba.motocicleta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoMotocicletaH2 implements DaoMotocicleta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "motocicleta", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "motocicleta", value = "buscaPorId")
    private static String sqlBuscarPorId;

    @SqlStatement(namespace = "motocicleta", value = "buscaMotocicletaDisponible")
    private static String sqlBuscaDisponible;

    public DaoMotocicletaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoMotocicleta> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,new MapeoMotocicleta());
    }

    @Override
    public DtoMotocicleta buscarPorId(Long id) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, parametros, new MapeoMotocicleta());
    }

    @Override
    public DtoMotocicleta buscarDisponible() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("disponible",Boolean.TRUE);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscaDisponible, parametros,new MapeoMotocicleta());
    }

}
