package com.example.demo.controller;

import com.example.demo.Service.IService.IClientesService;
import com.example.demo.dto.ClienteDto;
import com.example.demo.entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientesController {

    @Autowired
    private IClientesService iClientesService;

    @PostMapping("/crear")
    public Clientes crear(@RequestBody ClienteDto clientes){
        Clientes response = iClientesService.crear(clientes);
        return response;
    }

    @PutMapping("/modificar/{id}")
    public Clientes modificar(@PathVariable Long id, @RequestBody ClienteDto clientes){
        Clientes response = iClientesService.modificar(id, clientes);
        return response;
    }

    @GetMapping("/borrar/{id}")
    public Clientes modificar(@PathVariable Long id){
        Clientes response = iClientesService.borrar(id);
        return response;
    }
}
