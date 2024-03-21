package com.example.demo.IRepository;

import com.example.demo.entity.Productos_Financieros;
import com.example.demo.entity.Transacciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ITransaccionesRepository extends CrudRepository<Transacciones,Long> {

}
