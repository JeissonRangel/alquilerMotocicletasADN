package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.modelo.entidad.Factura;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioFactura;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.alquiler.servicio.testdatabuilder.DtoAlquilerTestDataBuilder;
import com.ceiba.alquiler.servicio.testdatabuilder.DtoMotocicletaTestDataBuilder;
import com.ceiba.alquiler.servicio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.motocicleta.modelo.dto.DtoMotocicleta;
import com.ceiba.motocicleta.modelo.entidad.Motocicleta;
import com.ceiba.motocicleta.puerto.dao.DaoMotocicleta;
import com.ceiba.motocicleta.servicio.testdatabuilder.MotocicletaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ServicioCrearFacturaTest {
    private static final double VALOR_DIA_DE_ALQUILER = 20000;
    private static final float PORCENTAJE_POLIZA_VEHICULO = 0.3F;
    private static final float PORCENTAJE_POR_ANIO_MODELO_POLIZA_VEHICULO = 0.03F;
    private static final float PORCENTAJE_POLIZA_SIN_PARRILLERO = 0.12F;
    private static final float PORCENTAJE_POLIZA_CON_PARRILLERO = 0.24F;

    private final int anioActual = LocalDate.now().getYear();

    @Mock
    private RepositorioFactura repositorioFactura;

    @Mock
    private DaoAlquiler daoAlquiler;

    private DtoAlquiler dtoAlquiler;

    @Mock
    private DaoMotocicleta daoMotocicleta;

    private DtoMotocicleta dtoMotocicleta = new DtoMotocicletaTestDataBuilder().build();

    private Alquiler alquiler = new AlquilerTestDataBuilder().build();

    @InjectMocks
    private ServicioCrearFactura servicioCrearFactura;

    @InjectMocks
    private Factura factura = new FacturaTestDataBuilder().build();

    @Test
    @DisplayName("Calcular valor total de factura de alquiler saliendo de la ciudad y llevando parrilero")
    void calcularFacturaSalirCiudadConParrillero() {

        dtoAlquiler = new DtoAlquilerTestDataBuilder().build();
        Mockito.doReturn(dtoAlquiler).when(daoAlquiler).buscarPorId(1L);
        Mockito.doReturn(dtoMotocicleta).when(daoMotocicleta).buscarPorId(1L);

        Double valorTotal = calcularValorTotalFactura();
        servicioCrearFactura.ejecutar(factura);

        assertEquals(valorTotal, factura.getValorTotal());
    }

    @Test
    @DisplayName("Calcular valor total de factura de alquiler sin salir de la ciudad llevando parrillero")
    void calcularFacturaSinSalirCiudadConParrillero(){

        dtoAlquiler = new DtoAlquilerTestDataBuilder().noPlaneaSalirCiudad().build();
        Mockito.doReturn(dtoAlquiler).when(daoAlquiler).buscarPorId(1L);
        Mockito.doReturn(dtoMotocicleta).when(daoMotocicleta).buscarPorId(1L);

        Double valorTotal = calcularValorTotalFactura();
        servicioCrearFactura.ejecutar(factura);

        assertEquals(valorTotal, factura.getValorTotal());
    }

    @Test
    @DisplayName("Calcular valor total de factura de alquiler saliendo de la ciudad sin llevar parrillero")
    void calcularFacturaSalirCiudadSinParrillero(){
        dtoAlquiler = new DtoAlquilerTestDataBuilder().noPlaneaLlevarParillero().build();
        Mockito.doReturn(dtoAlquiler).when(daoAlquiler).buscarPorId(1L);
        Mockito.doReturn(dtoMotocicleta).when(daoMotocicleta).buscarPorId(1L);

        Double valorTotal = calcularValorTotalFactura();
        servicioCrearFactura.ejecutar(factura);

        assertEquals(valorTotal,factura.getValorTotal());
    }

    @Test
    void calcularFacturaSinSalirCiudadSinParrillero(){
        dtoAlquiler = new DtoAlquilerTestDataBuilder().noPlaneaLlevarParillero().build();
        Mockito.doReturn(dtoAlquiler).when(daoAlquiler).buscarPorId(1L);
        Mockito.doReturn(dtoMotocicleta).when(daoMotocicleta).buscarPorId(1L);

        Double valorTotal = calcularValorTotalFactura();
        servicioCrearFactura.ejecutar(factura);

        assertEquals(valorTotal,factura.getValorTotal());
    }

    private Double calcularValorTotalFactura(){
        int diferenciaAnios = anioActual - dtoMotocicleta.getAnioModelo();
        Boolean parrillero = dtoAlquiler.isPlaneaLlevarParrillero();
        int diasAlquiler = dtoAlquiler.getCantidadDiasAlquiler();
        Double valorMotocicleta = dtoMotocicleta.getValorMotocicleta();
        Double seguroVehiculo = (valorMotocicleta * PORCENTAJE_POLIZA_VEHICULO) + (valorMotocicleta * PORCENTAJE_POR_ANIO_MODELO_POLIZA_VEHICULO * diferenciaAnios);
        Double polizaPersona = calcularConceptoPolizaPersonal(parrillero, diasAlquiler);
        Double valorDiasAlquilados = calcularValorPorDiasAlquilados(diasAlquiler);
        int valorTotal = (int)(valorDiasAlquilados + polizaPersona + seguroVehiculo);

        return (double)valorTotal;
    }

    private Double calcularValorPorDiasAlquilados(int diasAlquilados){
        return VALOR_DIA_DE_ALQUILER*diasAlquilados;
    }

    private Double calcularConceptoPolizaPersonal(Boolean parrillero, int diasAlquiler){
        Double valorConcepto=0D;

        if (parrillero){
            valorConcepto = VALOR_DIA_DE_ALQUILER*
                    PORCENTAJE_POLIZA_CON_PARRILLERO*
                    diasAlquiler;

            return valorConcepto;
        }
        valorConcepto = VALOR_DIA_DE_ALQUILER*
                PORCENTAJE_POLIZA_SIN_PARRILLERO*
                diasAlquiler;

        return valorConcepto;
    }
}
