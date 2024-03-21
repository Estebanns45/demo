package com.example.demo.Service.IService;

import com.example.demo.dto.ProductoDto;
import com.example.demo.entity.Productos_Financieros;

public interface IProductos_FinancierosService {
    Productos_Financieros crear (ProductoDto productoDto);
    void activarCuenta(Long id);
    void desactivarCuenta(Long id);

}
