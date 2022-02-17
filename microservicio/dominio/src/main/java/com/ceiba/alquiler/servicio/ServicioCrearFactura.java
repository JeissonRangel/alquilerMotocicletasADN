package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Factura;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioFactura;

public class ServicioCrearFactura {
    private static final double VALOR_DIA_DE_ALQUILER = 20000;
    private static final String CONCEPTO_DE_FACTURA_SEGURO_VEHICULO = "Seguro Vehículo";
    private static final float PORCENTAJE_POLIZA_SIN_PARRILLERO = 0.12F;
    private static final float PORCENTAJE_POLIZA_CON_PARRILLERO = 0.24F;

    private final RepositorioFactura repositorioFactura;
    private final DtoAlquiler dtoAlquiler;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura, DtoAlquiler dtoAlquiler) {
        this.repositorioFactura = repositorioFactura;
        this.dtoAlquiler = dtoAlquiler;
    }

    public Long ejecutar(Factura factura){
        return repositorioFactura.crear(factura);
    };

    private Double calcularValorAlquilerPorDias(DtoAlquiler alquiler){
        return alquiler.getCantidadDiasAlquiler()*VALOR_DIA_DE_ALQUILER;
    }

}
