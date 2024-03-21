package com.example.demo.Service;

import com.example.demo.IRepository.IClientesRepository;
import com.example.demo.IRepository.IProductos_FinancierosRepository;
import com.example.demo.dto.ProductoDto;
import com.example.demo.entity.Productos_Financieros;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductoImplTest {
    @Mock
    IProductos_FinancierosRepository iProductos_financierosRepository;
    @Mock
    IClientesRepository iClientesRepository;
    @InjectMocks
    ProductoImpl producto;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void crear() {


        //Mockito.when(iClientesRepository.findById(clientEntity.getId())).thenReturn(true);
    }

    @Test
    void activarCuenta() {
    }

    @Test
    void desactivarCuenta() {
    }
}