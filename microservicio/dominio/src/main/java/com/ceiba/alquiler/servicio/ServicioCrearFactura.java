package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Factura;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioFactura;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;

import java.time.LocalDate;
import java.util.HashMap;

public class ServicioCrearFactura {
    private static final double VALOR_DIA_DE_ALQUILER = 20000;
    private static final String CONCEPTO_DE_FACTURA_SEGURO_VEHICULO = "Seguro Vehículo";
    private static final String CONCEPTO_DE_FACTURA_POLIZA_PERSONAL = "Poliza personal";
    private static final float PORCENTAJE_POLIZA_VEHICULO = 0.3F;
    private static final float PORCENTAJE_POR_ANIO_POLIZA_VEHICULO = 0.03F;
    private static final float PORCENTAJE_POLIZA_SIN_PARRILLERO = 0.12F;
    private static final float PORCENTAJE_POLIZA_CON_PARRILLERO = 0.24F;

    private final RepositorioFactura repositorioFactura;
    private final DtoAlquiler dtoAlquiler;
    private final DaoAlquiler daoAlquiler;
    private final DaoMotocicleta daoMotocicleta;

    private HashMap<String, Double> conceptos = new HashMap<>();
    private int ANIO_ACTUAL = LocalDate.now().getYear();

    public ServicioCrearFactura(
            RepositorioFactura repositorioFactura,
            DtoAlquiler dtoAlquiler,
            DaoAlquiler daoAlquiler,
            DaoMotocicleta daoMotocicleta
    ) {
        this.repositorioFactura = repositorioFactura;
        this.dtoAlquiler = dtoAlquiler;
        this.daoAlquiler = daoAlquiler;
        this.daoMotocicleta = daoMotocicleta;
    }

    public Long ejecutar(Factura factura){
        DtoAlquiler alquilerFactura = buscarAlquilerPorId(factura);
        DtoMotocicleta motocicleta = buscarMotocicletaPorId(alquilerFactura);

        calcularConceptoPolizaPersonal(alquilerFactura);
        calcularValorConceptoPolizaVehiculo(alquilerFactura,motocicleta);

        Double valorAlquiler = calcularValorAlquilerPorDias(alquilerFactura);
        Double valorConceptos = calcularValorConceptos();
        factura.setConceptosFactura(this.conceptos);
        factura.setValorTotal(valorAlquiler+valorConceptos);

        return repositorioFactura.crear(factura);
    };

    private Double calcularValorConceptos(){
        Double total=0.0;
        for (Double valor: conceptos.values()) {
            total+=valor;
        }
        return total;
    }

    private DtoAlquiler buscarAlquilerPorId(Factura factura){
        return this.daoAlquiler.buscarPorId(factura.getIdAlquiler());
    }

    private DtoMotocicleta buscarMotocicletaPorId(DtoAlquiler alquiler){
        return this.daoMotocicleta.buscarPorId(alquiler.getMotocicletaID());
    }

    private Double calcularValorAlquilerPorDias(DtoAlquiler alquiler){
        int DIAS_A_ALQUILAR = alquiler.getCantidadDiasAlquiler();
        return DIAS_A_ALQUILAR*VALOR_DIA_DE_ALQUILER;
    }

    private void calcularConceptoPolizaPersonal(DtoAlquiler alquiler){
        if (alquiler.isPlaneaLlevarParrillero()){
            Double valorConcepto = VALOR_DIA_DE_ALQUILER*PORCENTAJE_POLIZA_CON_PARRILLERO*alquiler.getCantidadDiasAlquiler();
            this.conceptos.put(CONCEPTO_DE_FACTURA_POLIZA_PERSONAL,valorConcepto);
            return;
        }
        Double valorConcepto = VALOR_DIA_DE_ALQUILER*PORCENTAJE_POLIZA_SIN_PARRILLERO*alquiler.getCantidadDiasAlquiler();
        this.conceptos.put(CONCEPTO_DE_FACTURA_POLIZA_PERSONAL,valorConcepto);
    }

    private void calcularValorConceptoPolizaVehiculo(DtoAlquiler alquiler, DtoMotocicleta motocicleta){
        if (alquiler.isPlaneaSalirDeLaCiudad()){
            int diferenciaAnios = ANIO_ACTUAL- motocicleta.getAnioModelo();
            Double valorConceptoPorAnio = motocicleta.getValorMotocicleta()*diferenciaAnios*PORCENTAJE_POR_ANIO_POLIZA_VEHICULO;
            Double valorConcepto = motocicleta.getValorMotocicleta()*PORCENTAJE_POLIZA_VEHICULO;
            conceptos.put(CONCEPTO_DE_FACTURA_SEGURO_VEHICULO,valorConcepto+valorConceptoPorAnio);
        }
    }

}
