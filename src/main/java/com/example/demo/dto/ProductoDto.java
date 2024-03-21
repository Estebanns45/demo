package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
public class ProductoDto {

    private String tipo_cuenta;

    private String numero_cuenta;

    private Long idcliente;

    private Boolean estado;

    private String excenta_gmf;

    private LocalDateTime fecha_creacion;

    private Date fecha_modificacion;
    private Integer saldo;

    public Long getIdcliente() {
        return idcliente;
    }
    public String getExcenta_gmf() {
        return excenta_gmf;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }
    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }
    public Boolean getEstado() {
        return estado;
    }
    public String getProducto() {
        return tipo_cuenta;
    }
    public String getTipo_cuenta() {
        return tipo_cuenta;
    }
    public Integer getSaldo() {
        return saldo;
    }
}
