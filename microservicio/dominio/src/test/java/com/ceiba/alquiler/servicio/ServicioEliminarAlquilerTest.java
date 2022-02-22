package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ServicioEliminarAlquilerTest {

    @Mock
    private RepositorioAlquiler repositorioAlquiler;

    @InjectMocks
    private ServicioEliminarAlquiler servicioEliminarAlquiler;

    @Test
    @DisplayName("Deberia eliminar el alquiler")
    void deberiaEliminarElAlquiler(){
        Mockito.doNothing().when(repositorioAlquiler).eliminar(1L);

        servicioEliminarAlquiler.ejecutar(1L);

        Mockito.verify(repositorioAlquiler,Mockito.times(1)).eliminar(1L);
    }
}
