package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transacciones")
@Getter
@Setter
public class Transacciones {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto", length = 50, nullable = false)
    private Double monto;

    @Column(name = "TipoTransaccion", length = 50)
    private String tipotransaccion;

    @Column(name = "consignacion")
    private Double consignacion;

    @Column(name = "retiro", length = 50)
    private Double retiro;

    @Column(name = "transferencia", length = 50)
    private Double transferencia;

    @Column(name = "numerocuentadestino", length = 50)
    private String numerocuentadestino;

    @ManyToOne
    @JoinColumn(name = "id_productos_financieros", nullable = false)
    private Productos_Financieros producto;

    public String getNumerocuentadestino() {
        return numerocuentadestino;
    }

    public void setNumerocuentadestino(String numerocuentacestino) {
        this.numerocuentadestino = numerocuentacestino;
    }

    public Transacciones() {
    }

    public String getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(String tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getConsignacion() {
        return consignacion;
    }

    public void setConsignacion(Double consignacion) {
        this.consignacion = consignacion;
    }

    public Double getRetiro() {
        return retiro;
    }

    public void setRetiro(Double retiro) {
        this.retiro = retiro;
    }

    public Double getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Double transferencia) {
        this.transferencia = transferencia;
    }

    public Productos_Financieros getProductos_financieros() {
        return producto;
    }

    public void setProductos_financieros(Productos_Financieros productos_financieros) {
        this.producto = productos_financieros;
    }

    public Transacciones(long id, Double monto, String tipotransaccion, Double consignacion, Double retiro, Double transferencia, String numerocuentadestino, Productos_Financieros productos_financieros) {
        this.id = id;
        this.monto = monto;
        this.tipotransaccion = tipotransaccion;
        this.consignacion = consignacion;
        this.retiro = retiro;
        this.transferencia = transferencia;
        this.numerocuentadestino = numerocuentadestino;
        this.producto = productos_financieros;
    }
}
