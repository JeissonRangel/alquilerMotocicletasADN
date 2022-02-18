package com.ceiba.motocicleta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoMotocicleta implements RowMapper<DtoMotocicleta>, MapperResult {

    @Override
    public DtoMotocicleta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Double valorMotocicleta = resultSet.getDouble("valorMotocicleta");
        String anioModelo = resultSet.getString("anioModelo");
        Boolean disponible = resultSet.getBoolean("disponible");
        return new DtoMotocicleta(id,valorMotocicleta,anioModelo,disponible);
    }
}
