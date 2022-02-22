package com.ceiba.alquiler.comando.fabrica;

import com.ceiba.alquiler.comando.ComandoFactura;
import com.ceiba.alquiler.modelo.entidad.Factura;

public class FabricaFactura {
    public Factura crear(ComandoFactura comandoFactura){
        return new Factura(
                comandoFactura.getId(),
                comandoFactura.getIdAlquiler(),
                comandoFactura.getValorTotal(),
                comandoFactura.getSeguroVehiculo(),
                comandoFactura.getPolizaPersonal(),
                comandoFactura.getFechaCompra()
        );
    }
}
