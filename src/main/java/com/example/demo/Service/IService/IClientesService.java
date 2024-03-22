package com.example.demo.Service.IService;


import com.example.demo.dto.ClienteDto;
import com.example.demo.entity.Clientes;

public interface IClientesService {
    Clientes crear(ClienteDto clienteDto);
    Clientes modificar(Long id, ClienteDto clientes);
    Clientes borrar(Long id);
}
