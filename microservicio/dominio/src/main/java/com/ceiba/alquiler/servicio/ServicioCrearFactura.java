package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Factura;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioFactura;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;

import java.time.LocalDate;

public class ServicioCrearFactura {
    private static final double VALOR_DIA_DE_ALQUILER = 20000;
    private static final float PORCENTAJE_POLIZA_VEHICULO = 0.3F;
    private static final float PORCENTAJE_POR_ANIO_MODELO_POLIZA_VEHICULO = 0.03F;
    private static final float PORCENTAJE_POLIZA_SIN_PARRILLERO = 0.12F;
    private static final float PORCENTAJE_POLIZA_CON_PARRILLERO = 0.24F;

    private final RepositorioFactura repositorioFactura;
    private final DaoAlquiler daoAlquiler;
    private final DaoMotocicleta daoMotocicleta;

    private final int anioActual = LocalDate.now().getYear();

    public ServicioCrearFactura(
            RepositorioFactura repositorioFactura,
            DaoAlquiler daoAlquiler,
            DaoMotocicleta daoMotocicleta
    ) {
        this.repositorioFactura = repositorioFactura;
        this.daoAlquiler = daoAlquiler;
        this.daoMotocicleta = daoMotocicleta;
    }

    public Long ejecutar(Factura factura){

        LocalDate fechaCompra = LocalDate.now();
        DtoAlquiler alquilerFactura = buscarAlquilerPorId(factura);
        DtoMotocicleta motocicleta = buscarMotocicletaPorId(alquilerFactura);
        int diasAlquiler = alquilerFactura.getCantidadDiasAlquiler();

        if (alquilerFactura.isPlaneaSalirDeLaCiudad()){
            factura.setSeguroVehiculo(calcularValorConceptoSeguroVehiculo(motocicleta));
        }

        factura.setPolizaPersonal(calcularConceptoPolizaPersonal(alquilerFactura));

        Double sumatoriaConceptos = factura.getPolizaPersonal()+
                factura.getSeguroVehiculo()+
                calcularValorAlquilerPorDias(diasAlquiler);

        factura.setValorTotal(sumatoriaConceptos);

        factura.setFechaCompra(fechaCompra);

        return repositorioFactura.crear(factura);
    };

    private DtoAlquiler buscarAlquilerPorId(Factura factura){
        return this.daoAlquiler.buscarPorId(factura.getIdAlquiler());
    }

    private DtoMotocicleta buscarMotocicletaPorId(DtoAlquiler alquiler){
        return this.daoMotocicleta.buscarPorId(alquiler.getMotocicletaId());
    }

    private Double calcularValorAlquilerPorDias(int diasAlquiler){

        Double valorConcepto = diasAlquiler*VALOR_DIA_DE_ALQUILER;

        return valorConcepto;
    }

    private Double calcularConceptoPolizaPersonal(DtoAlquiler alquiler){
        Double valorConcepto=0D;

        if (alquiler.isPlaneaLlevarParrillero()){
            valorConcepto = VALOR_DIA_DE_ALQUILER*
                    PORCENTAJE_POLIZA_CON_PARRILLERO*
                    alquiler.getCantidadDiasAlquiler();

            return valorConcepto;
        }
        valorConcepto = VALOR_DIA_DE_ALQUILER*
                PORCENTAJE_POLIZA_SIN_PARRILLERO*
                alquiler.getCantidadDiasAlquiler();

        return valorConcepto;
    }

    private Double calcularValorConceptoSeguroVehiculo(DtoMotocicleta motocicleta){

        Double valorConcepto=0D;

        Double valorVehiculo = motocicleta.getValorMotocicleta();

        int diferenciaAnios= anioActual - motocicleta.getAnioModelo();

        Double valorConceptoPorAnioModelo = (valorVehiculo * PORCENTAJE_POR_ANIO_MODELO_POLIZA_VEHICULO) * diferenciaAnios;

        valorConcepto = (valorVehiculo * PORCENTAJE_POLIZA_VEHICULO) + valorConceptoPorAnioModelo;

        return valorConcepto;
    }

}
