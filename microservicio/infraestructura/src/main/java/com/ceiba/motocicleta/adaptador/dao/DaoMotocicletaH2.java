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

    @SqlStatement(namespace = "motocicleta", value = "buscaId")
    private static String sqlBuscarId;

    @SqlStatement(namespace = "motocicleta", value = "buscaMotocicletaDisponible")
    private static String sqlBuscaDisponible;

    @SqlStatement(namespace = "motocicleta", value = "validarDisponibilidad")
    private static String sqlValidarDisponibilidad;

    @SqlStatement(namespace = "motocicleta", value = "existe")
    private static String sqlExiste;

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
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarId, parametros, new MapeoMotocicleta());
    }

    @Override
    public DtoMotocicleta buscarDisponible() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("disponible",Boolean.TRUE);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscaDisponible, parametros,new MapeoMotocicleta());
    }

    @Override
    public Boolean validarDisponibilidad() {
        int CANTIDAD_DE_DISPONIBLES = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlValidarDisponibilidad, new MapeoMotocicleta()).size();
        return CANTIDAD_DE_DISPONIBLES > 0;
    }

    @Override
    public Boolean existe(Long id) {
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id",id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,parametros,Boolean.class);
    }
}
