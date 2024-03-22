package com.example.demo.Service;

import com.example.demo.IRepository.IClientesRepository;
import com.example.demo.IRepository.IProductos_FinancierosRepository;
import com.example.demo.Service.IService.IClientesService;
import com.example.demo.dto.ClienteDto;
import com.example.demo.entity.Clientes;
import com.example.demo.entity.Productos_Financieros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClienteImpl implements IClientesService {
    @Autowired
    private IClientesRepository iClientesRepository;

    @Autowired
    IProductos_FinancierosRepository iProductos_financierosRepository;

    @Override
    public Clientes crear(ClienteDto clienteDto) {
        if(!mayorEdad(clienteDto.getFecha_nacimiento())){
            throw new IllegalArgumentException("El cliente debe ser mayor de edad");
        }
        String nombre = clienteDto.getNombre();
        String apellido = clienteDto.getApellido();
        if(nombre == null || apellido == null || nombre.length() < 2 || apellido.length() <2 ){
            throw new IllegalArgumentException("El nombre o el apellido tienen menos de 2 carapteres");
        }

        String coElectronico = clienteDto.getCorreo_electronico();
        if (coElectronico == null || !validarCorreo(coElectronico)){
            throw new IllegalArgumentException("El correo no tiene un formato valido");
        }
        Clientes cliente = new Clientes();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setTipo_identificacion(clienteDto.getTipo_identificacion());
        cliente.setNumero_identificacion(clienteDto.getNumero_identificacion());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setFecha_nacimiento(cliente.getFecha_nacimiento());
        cliente.setFecha_creacion(clienteDto.getFecha_creacion());
        cliente.setCorreo_electronico(clienteDto.getCorreo_electronico());
        iClientesRepository.save(cliente);
        return null;
    }
    private boolean validarCorreo(String  correoElectronico){
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correoElectronico);
        return matcher.matches();
    }
    private boolean mayorEdad(LocalDateTime fechaNacimiento){
        LocalDateTime ahora = LocalDateTime.now();
        if ((ahora.getYear() - fechaNacimiento.getYear()) < 18) {
            return false;
        }
        else {
            return true;
        }
    }
        @Override
        public Clientes modificar(Long id, ClienteDto clientes) {
            Optional<Clientes> clienteExistenteOptional = iClientesRepository.findById(id);
            if (clienteExistenteOptional.isPresent()){
                Clientes clientesExistentes = clienteExistenteOptional.get();
                clientesExistentes.setNombre(clientes.getNombre());
                clientesExistentes.setTipo_identificacion(clientes.getTipo_identificacion());
                clientesExistentes.setNumero_identificacion(clientes.getNumero_identificacion());
                clientesExistentes.setApellido(clientes.getApellido());
                clientesExistentes.setFecha_nacimiento(clientes.getFecha_nacimiento());
                clientesExistentes.setFecha_creacion(clientes.getFecha_creacion());
                clientesExistentes.setCorreo_electronico(clientes.getCorreo_electronico());
                clientesExistentes.setFecha_modificacion(clientes.getFecha_modificacion());
                return iClientesRepository.save(clientesExistentes);
            }else {
                return null;
                }
        }
        @Override
        public Clientes borrar(Long id) {
            Optional<Clientes> clienteExistenteOptional = iClientesRepository.findById(id);
            if (clienteExistenteOptional.isPresent()){
                Clientes clienteExistente = clienteExistenteOptional.get();
                List<Productos_Financieros> productosCliente = clienteExistente.getProductosFinancieros();
                if (!productosCliente.isEmpty()){
                    throw new IllegalStateException("No se puede eliminar porque el cliente tiene productos asociados");
                }else {
                    iClientesRepository.deleteById(id);
                    return clienteExistente;
                }
            }else {
                throw new NoSuchElementException("El cliente con el Id proporcionado no existe");
            }
    }

}
