package com.ceiba.alquiler.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoFactura;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/factura")
public class ComandoControladorFactura {
    private final ManejadorCrearFactura manejadorCrearFactura;

    @Autowired
    public ComandoControladorFactura(ManejadorCrearFactura manejadorCrearFactura) {
        this.manejadorCrearFactura = manejadorCrearFactura;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoFactura comandoFactura){
        return this.manejadorCrearFactura.ejecutar(comandoFactura);
    }
}
