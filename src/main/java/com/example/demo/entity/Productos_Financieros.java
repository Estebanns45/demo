package com.example.demo.entity;


import com.example.demo.dto.ProductoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "productos_financieros")
@AllArgsConstructor
public class Productos_Financieros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tipo_cuenta", length = 50, nullable = false)
    private String tipo_cuenta;

    @Column(name = "numero_cuenta", length = 50, nullable = false)
    private String  numero;

    @Column(name = "estado", length = 50, nullable = false)
    private Boolean estado;

    @Column(name = "saldo", length = 50, nullable = false)
    private Integer saldo;

    @Column(name = "excenta_gmf", length = 50, nullable = false)
    private String excenta_gmf;

    @Column(name = "fecha_creacion", length = 50, nullable = false)
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_modificacion", length = 50, nullable = false)
    private Date fecha_modificacion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Transacciones> transacciones;

    public Productos_Financieros() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProducto() {
        return tipo_cuenta;
    }

    public void setProducto(String producto) {
        this.tipo_cuenta = producto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getExcenta_gmf() {
        return excenta_gmf;
    }

    public void setExcenta_gmf(String excenta_gmf) {
        this.excenta_gmf = excenta_gmf;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }



//public Productos_Financieros(long id, String producto, String numero_cuenta, String estado, String saldo, String excenta_gmf, LocalDateTime fecha_creacion, Date fecha_modificacion, Clientes cliente) {
    //      this.id = id;
    //     this.producto = producto;
    //    this.numero_cuenta = numero_cuenta;
    //    this.estado = estado;
    //  this.saldo = saldo;
    //  this.excenta_gmf = excenta_gmf;
    //  this.fecha_creacion = fecha_creacion;
    //  this.fecha_modificacion = fecha_modificacion;
    //  this.cliente = cliente;
    // }
}
