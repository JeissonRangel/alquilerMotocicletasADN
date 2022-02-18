package com.ceiba.motocicleta.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMotocicletaH2 implements RepositorioMotocicleta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "motocicleta",value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "motocicleta",value = "actualizar")
    private static String sqlActualizar;

    public RepositorioMotocicletaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Motocicleta motocicleta) {
        return this.customNamedParameterJdbcTemplate.crear(motocicleta,sqlCrear);
    }

    @Override
    public void actualizar(Motocicleta motocicleta) {
        this.customNamedParameterJdbcTemplate.actualizar(motocicleta,sqlActualizar);
    }
}
