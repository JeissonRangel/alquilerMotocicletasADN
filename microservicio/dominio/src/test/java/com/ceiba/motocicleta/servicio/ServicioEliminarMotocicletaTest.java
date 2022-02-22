package com.ceiba.motocicleta.servicio;

import com.ceiba.motocicleta.puerto.repositorio.RepositorioMotocicleta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ServicioEliminarMotocicletaTest {

    @Mock
    private RepositorioMotocicleta repositorioMotocicleta;

    @InjectMocks
    private ServicioEliminarMotocicleta servicioEliminarMotocicleta;

    @Test
    @DisplayName("Deberia eliminar la motocicleta")
    void deberiaEliminarLaMotocicleta(){
        Mockito.doNothing().when(repositorioMotocicleta).eliminar(1L);

        servicioEliminarMotocicleta.ejecutar(1L);

        Mockito.verify(repositorioMotocicleta,Mockito.times(1)).eliminar(1L);
    }
}
