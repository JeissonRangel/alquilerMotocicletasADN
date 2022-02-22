package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.entidad.Factura;

import java.time.LocalDate;

public class FacturaTestDataBuilder {

    private Long id;
    private Long idAlquiler;
    private Double valorTotal;
    private Double seguroVehiculo;
    private Double polizaPersonal;
    private LocalDate fechaCompra;

    public FacturaTestDataBuilder() {
        id=1L;
        idAlquiler=1L;
        fechaCompra = LocalDate.now();
    }

    public FacturaTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public FacturaTestDataBuilder conValorTotal(Double valorTotal){
        this.valorTotal = valorTotal;
        return this;
    }
    public FacturaTestDataBuilder conSeguroVehiculo(Double seguroVehiculo){
        this.seguroVehiculo=seguroVehiculo;
        return this;
    }
    public FacturaTestDataBuilder conPolizaPersonal(Double polizaPersonal){
        this.polizaPersonal=polizaPersonal;
        return this;
    }

    public Factura build(){
        return new Factura(
                id,
                idAlquiler,
                valorTotal,
                seguroVehiculo,
                polizaPersonal,
                fechaCompra
        );
    }
}
