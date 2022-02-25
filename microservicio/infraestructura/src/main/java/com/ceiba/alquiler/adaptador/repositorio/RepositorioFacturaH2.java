package com.ceiba.alquiler.adaptador.repositorio;

import com.ceiba.alquiler.modelo.entidad.Factura;
import com.ceiba.alquiler.puerto.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFacturaH2 implements RepositorioFactura {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "factura",value = "crear")
    private static String sqlCrear;

    public RepositorioFacturaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Factura factura) {
        return this.customNamedParameterJdbcTemplate.crear(factura,sqlCrear);
    }


}
