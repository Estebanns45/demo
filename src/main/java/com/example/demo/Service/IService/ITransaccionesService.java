package com.example.demo.Service.IService;

import com.example.demo.dto.TransaccionesDto;
import com.example.demo.entity.Transacciones;

public interface ITransaccionesService {
    Transacciones consignacion(TransaccionesDto transaccionesDto);

    Transacciones retiro(TransaccionesDto transaccionesDto);

    Transacciones transferencia(TransaccionesDto transaccionesDto);

}
