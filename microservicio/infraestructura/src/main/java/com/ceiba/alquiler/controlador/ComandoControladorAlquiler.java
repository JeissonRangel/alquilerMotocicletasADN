package com.ceiba.alquiler.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/alquiler")
public class ComandoControladorAlquiler {
    private final ManejadorCrearAlquiler manejadorCrearAlquiler;

    @Autowired
    public ComandoControladorAlquiler(ManejadorCrearAlquiler manejadorCrearAlquiler) {
        this.manejadorCrearAlquiler = manejadorCrearAlquiler;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAlquiler comandoAlquiler){
        return manejadorCrearAlquiler.ejecutar(comandoAlquiler);
    }

}
