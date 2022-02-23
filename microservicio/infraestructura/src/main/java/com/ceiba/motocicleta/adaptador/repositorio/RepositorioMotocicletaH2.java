package com.ceiba.motocicleta.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.motocicleta.adaptador.dao.MapeoMotocicleta;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositorioMotocicletaH2 implements RepositorioMotocicleta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "motocicleta",value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "motocicleta",value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "motocicleta", value = "actualizarDisponibilidadPorId")
    private static String sqlActualizarDisponibilidadPorId;

    @SqlStatement(namespace = "motocicleta",value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "motocicleta", value = "validarDisponibilidad")
    private static String sqlValidarDisponibilidad;

    @SqlStatement(namespace = "motocicleta", value = "existe")
    private static String sqlExiste;

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

    @Override
    public void actualizarDisponibilidadPorId(Long id, Boolean disponible) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id",id);
        parametros.put("disponible",disponible);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarDisponibilidadPorId,parametros);
    }

    @Override
    public void eliminar(Long id) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id",id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,parametros);
    }

    @Override
    public Boolean validarDisponibilidad() {
        int numeroMotocicletasDisponibles = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlValidarDisponibilidad, new MapeoMotocicleta()).size();
        return numeroMotocicletasDisponibles > 0;
    }

    @Override
    public Boolean existe(Long id) {
        Map<String,Object> parametros = new HashMap<>();
        parametros.put("id",id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,parametros,Boolean.class);
    }

}
