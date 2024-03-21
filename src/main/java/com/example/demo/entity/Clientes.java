package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "clientes")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clientes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_identificacion", length = 50)
    private String tipo_identificacion;

    @Column(name = "numero_identificacion", length = 50)
    private String numero_identificacion;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "apellido", length = 50)
    private String apellido;

    @Column(name = "correo_electronico", length = 50)
    private String correo_electronico;

    @Column(name = "fecha_nacimiento", length = 50)
    private LocalDateTime fecha_nacimiento;

    @Column(name = "fecha_creacion", length = 50)
    private LocalDateTime fecha_creacion;

    public Clientes() {

    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion != null ? fecha_creacion : LocalDateTime.now();
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }


    @Column(name = "fecha_modificacion", length = 50)
    private Date fecha_modificacion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Productos_Financieros> productosFinancieros;



    public Clientes(Long id, String tipo_identificacion, String numero_identificacion, String nombre, String apellido, String correo_electronico, LocalDateTime fecha_nacimiento, LocalDateTime fecha_creacion, Date fecha_modificacion, List<Productos_Financieros> productosFinancieros) {
        this.id = id;
        this.tipo_identificacion = tipo_identificacion;
        this.numero_identificacion = numero_identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.productosFinancieros = productosFinancieros;
    }
}



