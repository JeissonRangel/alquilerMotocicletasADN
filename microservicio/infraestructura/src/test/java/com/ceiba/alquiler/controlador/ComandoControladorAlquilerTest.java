package com.ceiba.alquiler.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.ComandoAlquilerTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorAlquiler.class)
@ContextConfiguration(classes = ApplicationMock.class)
public class ComandoControladorAlquilerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deberia crear alquiler")
    void deberiaCrearAlquiler() throws Exception{
        ComandoAlquiler comandoAlquiler = new ComandoAlquilerTestDataBuilder().build();

        mockMvc.perform(post("/alquiler")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoAlquiler)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor':2}"));
    }

    @Test
    @DisplayName("Deberia actualizar un alquiler")
    void deberiaActualizarAlquiler() throws Exception{
        Long id = 1L;
        ComandoAlquiler comandoAlquiler = new ComandoAlquilerTestDataBuilder().build();

        mockMvc.perform(put("/alquiler/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoAlquiler)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar el alquiler")
    void deberiaEliminarAlquiler() throws Exception{
        Long id = 1L;

        mockMvc.perform(delete("/alquiler/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        
    }
}
