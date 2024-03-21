package com.example.demo.Service;

import com.example.demo.IRepository.IProductos_FinancierosRepository;
import com.example.demo.IRepository.ITransaccionesRepository;
import com.example.demo.Service.IService.ITransaccionesService;
import com.example.demo.dto.ProductoDto;
import com.example.demo.dto.TransaccionesDto;
import com.example.demo.entity.Productos_Financieros;
import com.example.demo.entity.Transacciones;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionesImpl implements ITransaccionesService {

    @Autowired
    private ITransaccionesRepository iTransaccionesRepository;

    @Autowired
    private IProductos_FinancierosRepository iProductos_financierosRepository;


    @Override
    public Transacciones consignacion(TransaccionesDto transaccionesDto) {
        Productos_Financieros productoFinanciero = iProductos_financierosRepository.findById(transaccionesDto.getIdProductoFinanciero())
                .orElseThrow(() -> new IllegalArgumentException("Producto financiero no encontrado"));
        Transacciones transaccion = new Transacciones();
        transaccion.setMonto(transaccionesDto.getMonto());
        transaccion.setProductos_financieros(productoFinanciero);
        productoFinanciero.setSaldo((int) (productoFinanciero.getSaldo() + transaccionesDto.getMonto()));
        iTransaccionesRepository.save(transaccion);
        iProductos_financierosRepository.save(productoFinanciero);
        return transaccion;
    }
    @Override
    public Transacciones retiro(TransaccionesDto transaccionesDto) {
        Productos_Financieros productoFinanciero = iProductos_financierosRepository.findById(transaccionesDto.getIdProductoFinanciero())
                .orElseThrow(() -> new IllegalArgumentException("Producto financiero no encontrado"));
        if (productoFinanciero.getSaldo() < transaccionesDto.getMonto()) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar el retiro");
        }
        Transacciones transaccion = new Transacciones();
        transaccion.setMonto(transaccionesDto.getMonto());
        transaccion.setProductos_financieros(productoFinanciero);
        productoFinanciero.setSaldo((int) (productoFinanciero.getSaldo() - transaccionesDto.getMonto()));
        iTransaccionesRepository.save(transaccion);
        iProductos_financierosRepository.save(productoFinanciero);
        return transaccion;
    }
    @Override
    public Transacciones transferencia(TransaccionesDto transaccionesDto) {
        Optional<Productos_Financieros> emisorOptional = iProductos_financierosRepository.findById(transaccionesDto.getIdProductoFinanciero());
        Productos_Financieros emisor = emisorOptional.orElseThrow(() -> new IllegalArgumentException("Producto financiero de emisor no encontrado"));
        if (emisor.getSaldo() < transaccionesDto.getMonto()) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar la transferencia");
        }
        emisor.setSaldo((int) (emisor.getSaldo() - transaccionesDto.getMonto()));
        iProductos_financierosRepository.save(emisor);
        Transacciones transaccionEmisor = new Transacciones();
        transaccionEmisor.setMonto(transaccionesDto.getMonto());
        transaccionEmisor.setTransferencia(transaccionesDto.getMonto());
        transaccionEmisor.setNumerocuentadestino(transaccionesDto.getNumeroCuentaDestino());
        transaccionEmisor.setProductos_financieros(emisor);
        iTransaccionesRepository.save(transaccionEmisor);
        Optional<Productos_Financieros> receptorOptional = iProductos_financierosRepository.findByNumero(transaccionesDto.getNumeroCuentaDestino());
        Productos_Financieros receptor = receptorOptional.orElseThrow(() -> new IllegalArgumentException("Producto financiero de receptor no encontrado"));
        receptor.setSaldo((int) (receptor.getSaldo() + transaccionesDto.getMonto()));
        iProductos_financierosRepository.save(receptor);
        Transacciones transaccionReceptor = new Transacciones();
        transaccionReceptor.setMonto(transaccionesDto.getMonto());
        transaccionReceptor.setTipotransaccion("TRANSFERENCIA");
        transaccionReceptor.setTransferencia(transaccionesDto.getMonto());
        transaccionReceptor.setNumerocuentadestino(transaccionesDto.getNumeroCuentaDestino());
        transaccionReceptor.setProductos_financieros(receptor);
        iTransaccionesRepository.save(transaccionReceptor);
        return transaccionEmisor;
    }

}