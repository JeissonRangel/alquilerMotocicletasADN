package com.ceiba.alquiler.comando.fabrica;

import com.ceiba.alquiler.ComandoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import org.springframework.stereotype.Component;

@Component
public class FabricaAlquiler {
    public Alquiler crear(ComandoAlquiler comandoAlquiler){
        return new Alquiler(
                comandoAlquiler.getId(),
                comandoAlquiler.getPersonaId(),
                comandoAlquiler.getCantidadDiasAlquiler(),
                comandoAlquiler.isPlaneaSalirDeLaCiudad(),
                comandoAlquiler.isPlaneaLlevarParrillero()
        );
    }
}
