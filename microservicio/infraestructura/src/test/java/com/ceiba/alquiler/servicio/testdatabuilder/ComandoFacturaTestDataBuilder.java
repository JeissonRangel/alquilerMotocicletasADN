package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoFactura;

import java.time.LocalDate;

public class ComandoFacturaTestDataBuilder {
    private Long id;
    private Long idAlquiler;
    private Double valorTotal;
    private Double seguroVehiculo;
    private Double polizaPersonal;
    private LocalDate fechaCompra;

    public ComandoFacturaTestDataBuilder() {
        this.id = 1L;
        this.idAlquiler = 1L;
        this.valorTotal = 1000D;
        this.seguroVehiculo = 200D;
        this.polizaPersonal = 300D;
        this.fechaCompra = LocalDate.now();
    }

    public ComandoFacturaTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public ComandoFactura build(){
        return new ComandoFactura(
                id,
                idAlquiler,
                valorTotal,
                seguroVehiculo,
                polizaPersonal,
                fechaCompra
        );
    }
}
