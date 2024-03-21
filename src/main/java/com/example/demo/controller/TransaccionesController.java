package com.example.demo.controller;

import com.example.demo.Service.IService.ITransaccionesService;
import com.example.demo.dto.TransaccionesDto;
import com.example.demo.entity.Transacciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaccion")
public class TransaccionesController {
    @Autowired
    ITransaccionesService iTransaccionesService;

    @PostMapping("/consignacion")
    public Transacciones consignacion(@RequestBody TransaccionesDto transaccion) {
        return iTransaccionesService.consignacion(transaccion);
    }

    @PostMapping("/retiro")
    public Transacciones retiro(@RequestBody TransaccionesDto transaccion) {
        return iTransaccionesService.retiro(transaccion);
    }

    @PostMapping("/transferencia")
    public Transacciones transferencia(@RequestBody TransaccionesDto transaccion) {
        return iTransaccionesService.transferencia(transaccion);
    }

}
