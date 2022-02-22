package com.ceiba.motocicleta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.motocicleta.comando.ComandoMotocicleta;
import com.ceiba.motocicleta.comando.fabrica.FabricaMotocicleta;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.servicio.ServicioActualizarMotocicleta;

public class ManejadorActualizarMotocicleta implements ManejadorComando<ComandoMotocicleta> {

    private final FabricaMotocicleta fabricaMotocicleta;
    private final ServicioActualizarMotocicleta servicioActualizarMotocicleta;

    public ManejadorActualizarMotocicleta(FabricaMotocicleta fabricaMotocicleta, ServicioActualizarMotocicleta servicioActualizarMotocicleta) {
        this.fabricaMotocicleta = fabricaMotocicleta;
        this.servicioActualizarMotocicleta = servicioActualizarMotocicleta;
    }

    @Override
    public void ejecutar(ComandoMotocicleta comandoMotocicleta) {
        Motocicleta motocicleta = this.fabricaMotocicleta.crear(comandoMotocicleta);
        this.servicioActualizarMotocicleta.ejecutar(motocicleta);
    }
}
