package com.ceiba.alquiler.adaptador.repositorio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAlquilerH2 implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alquiler", value="crear")
    private static String sqlCrear;

    public RepositorioAlquilerH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Alquiler alquiler) {
        return this.customNamedParameterJdbcTemplate.crear(alquiler, sqlCrear);
    }

    @Override
    public void actualizar(Alquiler alquiler) {
    }
}
