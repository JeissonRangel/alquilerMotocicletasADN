package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;

public class ServicioCrearAlquiler {
    private static final double VALOR_DIA_DE_ALQUILER = 20000;
    private static final String CONCEPTO_DE_FACTURA_SEGURO_VEHICULO = "Seguro Vehículo";
    private static final int PORCENTAJE_POLIZA = 12;

    private final RepositorioAlquiler repositorioAlquiler;
    private final RepositorioMotocicleta repositorioMotocicleta;
    private final DaoMotocicleta daoMotocicleta;

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler,
                                 RepositorioMotocicleta repositorioMotocicleta,
                                 DaoMotocicleta daoMotocicleta) {
        this.repositorioAlquiler = repositorioAlquiler;
        this.repositorioMotocicleta = repositorioMotocicleta;
        this.daoMotocicleta = daoMotocicleta;
    }
}
