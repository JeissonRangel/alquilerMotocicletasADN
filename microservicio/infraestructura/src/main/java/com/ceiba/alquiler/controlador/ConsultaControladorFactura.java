package com.ceiba.alquiler.controlador;

import com.ceiba.alquiler.consulta.ManejadorListarFacturas;
import com.ceiba.alquiler.modelo.dto.DtoFactura;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class ConsultaControladorFactura {
    private final ManejadorListarFacturas manejadorListarFacturas;

    public ConsultaControladorFactura(ManejadorListarFacturas manejadorListarFacturas) {
        this.manejadorListarFacturas = manejadorListarFacturas;
    }

    @GetMapping
    public List<DtoFactura> listar(){
        return this.manejadorListarFacturas.ejecutar();
    }
}
