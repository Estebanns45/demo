package com.example.demo.Service;

import com.example.demo.IRepository.IClientesRepository;
import com.example.demo.IRepository.IProductos_FinancierosRepository;
import com.example.demo.Service.IService.IProductos_FinancierosService;
import com.example.demo.dto.ProductoDto;
import com.example.demo.entity.Clientes;
import com.example.demo.entity.Productos_Financieros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class ProductoImpl implements IProductos_FinancierosService {
    @Autowired
    private IProductos_FinancierosRepository iProductos_financierosRepository;
    @Autowired
    private IClientesRepository iClientesRepository;
    @Override
    public Productos_Financieros crear(ProductoDto productoDto) {
        Long idCliente = productoDto.getIdcliente();
        Optional<Clientes> clienteExistenteOptional = iClientesRepository.findById(idCliente);
        if (clienteExistenteOptional.isPresent()) {
            final String AHORROS = "ahorros";
            final String CORRIENTE = "corriente";
               if (!AHORROS.equalsIgnoreCase(productoDto.getProducto()) && !CORRIENTE.equalsIgnoreCase(productoDto.getProducto())) {
                   throw new IllegalArgumentException("El tipo de cuenta debe ser 'cuenta corriente' o 'cuenta de ahorros'");
               }
            if (!AHORROS.equals(productoDto.getProducto()) && productoDto.getSaldo() <= 0) {
                throw new IllegalArgumentException("La cuenta de ahorros no puede tener un saldo menor a $0");
            }
                Productos_Financieros productosFinancieros = new Productos_Financieros();
                productosFinancieros.setExcenta_gmf(productoDto.getExcenta_gmf());
                productosFinancieros.setId(productoDto.getIdcliente());
                productosFinancieros.setFecha_creacion(productoDto.getFecha_creacion());
                productosFinancieros.setFecha_modificacion(productoDto.getFecha_modificacion());
                productosFinancieros.setSaldo(productoDto.getSaldo());
                productosFinancieros.setEstado(true);
                String numeroCuenta = generarNumeroCuenta(productoDto.getProducto());
                productosFinancieros.setNumero(String.valueOf(Double.valueOf(numeroCuenta)));
                Clientes cliente = clienteExistenteOptional.get();
                productosFinancieros.setCliente(cliente);
                iProductos_financierosRepository.save(productosFinancieros);
                return null;
        } else {
            throw new IllegalArgumentException("El cliente asociado no se encuentra en la base de datos");
        }

    }
    @Override
    public void activarCuenta(Long id){
        cambiarEstadoCuenta(id, true);
        }
    @Override
    public void desactivarCuenta(Long id){
        Optional<Productos_Financieros> estadoCuenta = iProductos_financierosRepository.findById(id);
        if(estadoCuenta.isPresent()){
            Productos_Financieros producto = estadoCuenta.get();
            if (producto.getSaldo() == 0){
                producto.setEstado(false);
                iProductos_financierosRepository.save(producto);
            } else {
                throw new IllegalArgumentException("La cuenta no puede ser desactivada porqué tiene un saldo distinto de 0");
            }
        }else {
            throw new IllegalArgumentException("Producto financiero no encontrado");
        }
        }
    private String generarNumeroCuenta(String tipoProducto){
        String inicial;
        if ("ahorros".equalsIgnoreCase((tipoProducto))){
            inicial="53";
        } else if ("corriente".equalsIgnoreCase(tipoProducto)) {
            inicial="33";
        } else {
            throw new IllegalArgumentException("Tipo de producto no valido");
        }
        Random random = new Random();
        StringBuilder sufijo = new StringBuilder();
        for (int i=0; i < 8 ; i++){
            sufijo.append(random.nextInt(10));
        }
        return inicial + sufijo.toString();
    }
    private void cambiarEstadoCuenta(Long id, boolean nuevoEstado){
        Optional<Productos_Financieros> estadoCuenta = iProductos_financierosRepository.findById(id);
        if (estadoCuenta.isPresent()){
            Productos_Financieros producto = estadoCuenta.get();
            producto.setEstado(nuevoEstado);
            iProductos_financierosRepository.save(producto);
        }else {
            throw new IllegalArgumentException("Producto financiero no encontrado");
        }
    }
}
