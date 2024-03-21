package com.example.demo.IRepository;

import com.example.demo.dto.ClienteDto;
import com.example.demo.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface IClientesRepository extends CrudRepository<Clientes, Long> {

}
