package com.ceiba.motocicleta.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.motocicleta.comando.ComandoMotocicleta;
import com.ceiba.motocicleta.servicio.testdatabuilder.ComandoMotocicletaTestDataBuilder;
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
@WebMvcTest(ComandoControladorMotocicleta.class)
@ContextConfiguration(classes = ApplicationMock.class)
public class ComandoControladorMotocicletaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deberia crear una motocicleta")
    void deberiaCrearUnaMotocicleta() throws Exception{

        ComandoMotocicleta comandoMotocicleta = new ComandoMotocicletaTestDataBuilder().conId(2L).build();

        mockMvc.perform(post("/motocicleta")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoMotocicleta)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor':2}"));
    }

    @Test
    @DisplayName("Deberia actualizar una motocicleta")
    void deberiaActualizarMotocicleta() throws Exception{
        Long id = 1L;
        ComandoMotocicleta comandoMotocicleta = new ComandoMotocicletaTestDataBuilder().build();

        mockMvc.perform( put("/motocicleta/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoMotocicleta)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar la motocicleta")
    void deberiaEliminarMotocicleta() throws Exception{
        Long id = 1L;

        mockMvc.perform(delete("/motocicleta/{id}",id)
               .contentType(MediaType.APPLICATION_JSON)
               .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());

    }

}
