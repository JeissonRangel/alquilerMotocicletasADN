package com.ceiba.motocicleta.controlador;

import com.ceiba.motocicleta.consulta.ManejadorListarMotocicletas;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/motocicleta")
public class ConsultaControladorMotocicleta {
    private final ManejadorListarMotocicletas manejadorListarMotocicletas;

    public ConsultaControladorMotocicleta(ManejadorListarMotocicletas manejadorListarMotocicletas) {
        this.manejadorListarMotocicletas = manejadorListarMotocicletas;
    }

    @GetMapping
    public List<DtoMotocicleta> listar(){
        return this.manejadorListarMotocicletas.ejecutar();
    }


}
