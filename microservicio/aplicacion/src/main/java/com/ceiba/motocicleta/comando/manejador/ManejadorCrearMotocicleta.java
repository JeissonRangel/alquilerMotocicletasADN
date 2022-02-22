package com.ceiba.motocicleta.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.motocicleta.comando.ComandoMotocicleta;
import com.ceiba.motocicleta.comando.fabrica.FabricaMotocicleta;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.servicio.ServicioCrearMotocicleta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearMotocicleta implements ManejadorComandoRespuesta<ComandoMotocicleta, ComandoRespuesta<Long>> {
    private final FabricaMotocicleta fabricaMotocicleta;
    private final ServicioCrearMotocicleta servicioCrearMotocicleta;

    public ManejadorCrearMotocicleta(FabricaMotocicleta fabricaMotocicleta, ServicioCrearMotocicleta servicioCrearMotocicleta) {
        this.fabricaMotocicleta = fabricaMotocicleta;
        this.servicioCrearMotocicleta = servicioCrearMotocicleta;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoMotocicleta comandoMotocicleta){
        Motocicleta motocicleta = this.fabricaMotocicleta.crear(comandoMotocicleta);
        return new ComandoRespuesta<>(this.servicioCrearMotocicleta.ejecutar(motocicleta));
    }
}
