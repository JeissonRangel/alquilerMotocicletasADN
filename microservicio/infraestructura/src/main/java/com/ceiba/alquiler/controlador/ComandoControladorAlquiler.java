package com.ceiba.alquiler.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorActualizarAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorEliminarAlquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/alquiler")
public class ComandoControladorAlquiler {
    private final ManejadorCrearAlquiler manejadorCrearAlquiler;
    private final ManejadorActualizarAlquiler manejadorActualizarAlquiler;
    private final ManejadorEliminarAlquiler manejadorEliminarAlquiler;

    @Autowired
    public ComandoControladorAlquiler(
            ManejadorCrearAlquiler manejadorCrearAlquiler,
            ManejadorActualizarAlquiler manejadorActualizarAlquiler,
            ManejadorEliminarAlquiler manejadorEliminarAlquiler
    ) {
        this.manejadorCrearAlquiler = manejadorCrearAlquiler;
        this.manejadorActualizarAlquiler = manejadorActualizarAlquiler;
        this.manejadorEliminarAlquiler = manejadorEliminarAlquiler;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAlquiler comandoAlquiler){
        return this.manejadorCrearAlquiler.ejecutar(comandoAlquiler);
    }

    @PutMapping(value = "/{id}")
    public void actualizar(@RequestBody ComandoAlquiler comandoAlquiler, @PathVariable Long id){
        comandoAlquiler.setId(id);
        manejadorActualizarAlquiler.ejecutar(comandoAlquiler);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarAlquiler.ejecutar(id);
    }

}
