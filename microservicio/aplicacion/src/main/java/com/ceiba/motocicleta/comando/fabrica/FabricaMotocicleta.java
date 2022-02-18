package com.ceiba.motocicleta.comando.fabrica;

import com.ceiba.motocicleta.comando.ComandoMotocicleta;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import org.springframework.stereotype.Component;

@Component
public class FabricaMotocicleta {
    public Motocicleta crear(ComandoMotocicleta comandoMotocicleta){
        return new Motocicleta(
                comandoMotocicleta.getId(),
                comandoMotocicleta.getValorMotocicleta(),
                comandoMotocicleta.getAnioModelo(),
                comandoMotocicleta.getDisponible());
    }
}
