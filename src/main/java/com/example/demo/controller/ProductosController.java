package com.example.demo.controller;

import com.example.demo.Service.IService.IProductos_FinancierosService;
import com.example.demo.dto.ProductoDto;
import com.example.demo.entity.Productos_Financieros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producto")
public class ProductosController {

    @Autowired
    private IProductos_FinancierosService iProductos_financierosService;
    @PostMapping("/crear")
    public Productos_Financieros crear(@RequestBody ProductoDto producto){
        Productos_Financieros response = iProductos_financierosService.crear(producto);
        return response;
    }
    @PostMapping("/productos/{id}/activar")
    public void activarCuenta(@PathVariable Long id){
        iProductos_financierosService.activarCuenta(id);
    }

    @PostMapping("/productos/{id}/desactivar")
    public void desactivarCuenta(@PathVariable Long id){
        iProductos_financierosService.desactivarCuenta(id);
    }
}
