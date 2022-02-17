package com.ceiba.alquiler.adaptador.dao;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoAlquiler implements RowMapper<DtoAlquiler>, MapperResult {
    @Override
    public DtoAlquiler mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long idPersona = resultSet.getLong("personaId");
        Long motocicletaId = resultSet.getLong("motocicletaId");
        int cantidadDiasAlquiler = resultSet.getInt("cantidadDiasAlquiler");
        LocalDate fechaDevolucion = extraerLocalDate(resultSet, "fechaDevolucion");
        Boolean planeaSalirDeLaCiudad = resultSet.getBoolean("planeaSalirDeLaCiudad");
        Boolean planeaLlevarParrillero = resultSet.getBoolean("planeaLlevarParrillero");

        return null;
    }
}
