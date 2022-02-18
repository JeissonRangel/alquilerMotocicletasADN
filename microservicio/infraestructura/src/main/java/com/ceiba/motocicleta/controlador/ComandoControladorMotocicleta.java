package com.ceiba.motocicleta.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.motocicleta.comando.ComandoMotocicleta;
import com.ceiba.motocicleta.comando.manejador.ManejadorCrearMotocicleta;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/motocicleta")
public class ComandoControladorMotocicleta {
    private final ManejadorCrearMotocicleta manejadorCrearMotocicleta;

    public ComandoControladorMotocicleta(ManejadorCrearMotocicleta manejadorCrearMotocicleta) {
        this.manejadorCrearMotocicleta = manejadorCrearMotocicleta;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMotocicleta comandoMotocicleta){
        return manejadorCrearMotocicleta.ejecutar(comandoMotocicleta);
    }
}
