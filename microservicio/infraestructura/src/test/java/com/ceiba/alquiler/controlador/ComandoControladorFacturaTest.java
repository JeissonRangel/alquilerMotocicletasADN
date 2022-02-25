package com.ceiba.alquiler.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.alquiler.adaptador.dao.DaoAlquilerH2;
import com.ceiba.alquiler.comando.ComandoFactura;
import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.ComandoFacturaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorFactura.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorFacturaTest {

    @Mock
    private DaoAlquilerH2 daoAlquilerH2;

    @Mock
    private DtoAlquiler dtoAlquiler;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deberia crear factura")
    void deberiaCrearFactura() throws Exception{
        ComandoFactura comandoFactura = new ComandoFacturaTestDataBuilder().conId(2L).conIdAlquiler(1L).build();
        Mockito.doReturn(dtoAlquiler).when(daoAlquilerH2).buscarPorId(1L);

        mockMvc.perform(post("/factura")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoFactura)))
                        .andExpect(status().isOk())
                        .andExpect(content().json("{'valor':2}"));

    }
}
