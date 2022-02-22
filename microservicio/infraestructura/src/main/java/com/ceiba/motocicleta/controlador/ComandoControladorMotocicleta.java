package com.ceiba.motocicleta.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.motocicleta.comando.ComandoMotocicleta;
import com.ceiba.motocicleta.comando.manejador.ManejadorActualizarMotocicleta;
import com.ceiba.motocicleta.comando.manejador.ManejadorCrearMotocicleta;
import com.ceiba.motocicleta.comando.manejador.ManejadorEliminarMotocicleta;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/motocicleta")
public class ComandoControladorMotocicleta {
    private final ManejadorCrearMotocicleta manejadorCrearMotocicleta;
    private final ManejadorActualizarMotocicleta manejadorActualizarMotocicleta;
    private final ManejadorEliminarMotocicleta manejadorEliminarMotocicleta;

    public ComandoControladorMotocicleta(
            ManejadorCrearMotocicleta manejadorCrearMotocicleta,
            ManejadorActualizarMotocicleta manejadorActualizarMotocicleta,
            ManejadorEliminarMotocicleta manejadorEliminarMotocicleta) {
        this.manejadorCrearMotocicleta = manejadorCrearMotocicleta;
        this.manejadorActualizarMotocicleta = manejadorActualizarMotocicleta;
        this.manejadorEliminarMotocicleta = manejadorEliminarMotocicleta;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMotocicleta comandoMotocicleta){
        return manejadorCrearMotocicleta.ejecutar(comandoMotocicleta);
    }

    @PutMapping(value = "/{id}")
    public void actualizar(@RequestBody ComandoMotocicleta comandoMotocicleta, @PathVariable Long id){
        comandoMotocicleta.setId(id);
        manejadorActualizarMotocicleta.ejecutar(comandoMotocicleta);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarMotocicleta.ejecutar(id);
    }
}
