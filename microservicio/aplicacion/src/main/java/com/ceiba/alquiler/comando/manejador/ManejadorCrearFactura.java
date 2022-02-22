package com.ceiba.alquiler.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoFactura;
import com.ceiba.alquiler.comando.fabrica.FabricaFactura;
import com.ceiba.alquiler.modelo.entidad.Factura;
import com.ceiba.alquiler.servicio.ServicioCrearFactura;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFactura implements ManejadorComandoRespuesta<ComandoFactura, ComandoRespuesta<Long>> {

    private final FabricaFactura fabricaFactura;
    private final ServicioCrearFactura servicioCrearFactura;

    public ManejadorCrearFactura(FabricaFactura fabricaFactura, ServicioCrearFactura servicioCrearFactura) {
        this.fabricaFactura = fabricaFactura;
        this.servicioCrearFactura = servicioCrearFactura;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoFactura comandoFactura) {
        Factura factura = this.fabricaFactura.crear(comandoFactura);
        return new ComandoRespuesta<>(this.servicioCrearFactura.ejecutar(factura));
    }
}
