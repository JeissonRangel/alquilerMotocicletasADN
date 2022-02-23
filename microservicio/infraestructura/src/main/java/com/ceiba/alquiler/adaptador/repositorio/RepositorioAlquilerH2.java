package com.ceiba.alquiler.adaptador.repositorio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositorioAlquilerH2 implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alquiler", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="alquiler",value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "alquiler",value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "alquiler", value = "existePorId")
    private static String sqlExistePorId;

    public RepositorioAlquilerH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Alquiler alquiler) {
        return this.customNamedParameterJdbcTemplate.crear(alquiler, sqlCrear);
    }

    @Override
    public void actualizar(Alquiler alquiler) {
        this.customNamedParameterJdbcTemplate.actualizar(alquiler,sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id",id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,parametros);
    }

    @Override
    public Boolean existePorId(Long id) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id",id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,parametros,Boolean.class);
    }
