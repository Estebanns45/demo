package com.example.demo.IRepository;

import com.example.demo.entity.Clientes;
import com.example.demo.entity.Productos_Financieros;
import com.example.demo.entity.Transacciones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductos_FinancierosRepository extends CrudRepository<Productos_Financieros, Long> {

    Optional<Productos_Financieros> findByNumero(String numero);
}