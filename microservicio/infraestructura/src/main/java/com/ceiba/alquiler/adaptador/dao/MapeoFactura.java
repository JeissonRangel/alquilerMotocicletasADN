package com.ceiba.alquiler.adaptador.dao;

import com.ceiba.alquiler.modelo.dto.DtoFactura;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class MapeoFactura implements RowMapper<DtoFactura>, MapperResult{

    @Override
    public DtoFactura mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idAlquiler = rs.getLong("idAlquiler");
        Double valorTotal = rs.getDouble("valorTotal");
        Double seguroVehiculo = rs.getDouble("seguroVehiculo");
        Double polizaPersonal = rs.getDouble("polizaPersonal");
        LocalDate fechaCompra = extraerLocalDate(rs,"fechaCompra");
        return null;
    }
}
