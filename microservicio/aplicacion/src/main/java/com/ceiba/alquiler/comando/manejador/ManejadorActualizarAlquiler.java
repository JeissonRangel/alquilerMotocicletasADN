package com.ceiba.alquiler.comando.manejador;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.comando.fabrica.FabricaAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.servicio.ServicioActualizarAlquiler;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarAlquiler implements ManejadorComando<ComandoAlquiler> {
    private final FabricaAlquiler fabricaAlquiler;
    private final ServicioActualizarAlquiler servicioActualizarAlquiler;

    public ManejadorActualizarAlquiler(FabricaAlquiler fabricaAlquiler, ServicioActualizarAlquiler servicioActualizarAlquiler) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioActualizarAlquiler = servicioActualizarAlquiler;
    }

    @Override
    public void ejecutar(ComandoAlquiler comandoAlquiler) {
        Alquiler alquiler = this.fabricaAlquiler.crear(comandoAlquiler);
        this.servicioActualizarAlquiler.ejecutar(alquiler);
    }
}
