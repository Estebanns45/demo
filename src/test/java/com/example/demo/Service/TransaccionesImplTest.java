package com.example.demo.Service;

import com.example.demo.IRepository.IProductos_FinancierosRepository;
import com.example.demo.IRepository.ITransaccionesRepository;
import com.example.demo.dto.TransaccionesDto;
import com.example.demo.entity.Productos_Financieros;
import com.example.demo.entity.Transacciones;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@SpringBootTest
class TransaccionesImplTest {

    @Mock
    private ITransaccionesRepository iTransaccionesRepository;

    @Mock
    private IProductos_FinancierosRepository iProductos_financierosRepository;

    @InjectMocks
    private TransaccionesImpl servicio;

    @BeforeEach
    void setUp() {

    }

    @Test
    void consignacion() {
        TransaccionesDto transaccionesDto = new TransaccionesDto();
        transaccionesDto.setIdProductoFinanciero(1L);
        transaccionesDto.setMonto(100d);

        Productos_Financieros productoFinanciero = new Productos_Financieros();
        productoFinanciero.setId(1L);
        productoFinanciero.setSaldo(500);

        Mockito.when(iProductos_financierosRepository.findById(1L)).thenReturn(java.util.Optional.of(productoFinanciero));
        Transacciones transaccion = servicio.consignacion(transaccionesDto);

        ArgumentCaptor<Transacciones> transaccionCaptor = ArgumentCaptor.forClass(Transacciones.class);
        verify(iTransaccionesRepository).save(transaccionCaptor.capture());
        Transacciones transaccionGuardada = transaccionCaptor.getValue();
        assertEquals(transaccionesDto.getMonto(), transaccionGuardada.getMonto());

        ArgumentCaptor<Productos_Financieros> productoCaptor = ArgumentCaptor.forClass(Productos_Financieros.class);
        verify(iProductos_financierosRepository).save(productoCaptor.capture());
        Productos_Financieros productoFinancieroGuardado = productoCaptor.getValue();
        assertEquals(600, productoFinancieroGuardado.getSaldo());

        assertNotNull(transaccion);
        assertEquals(transaccionesDto.getMonto(), transaccion.getMonto());
        assertEquals(productoFinanciero, transaccion.getProductos_financieros());
    }

    @Test
    void retiro() {
    }

    @Test
    void transferencia() {
    }
}