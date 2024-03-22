package com.example.demo.dto;

import com.example.demo.entity.Productos_Financieros;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.example.demo.dto.ClienteDto;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class ClienteDto {

    private String tipo_identificacion;

    private String numero_identificacion;

    private String nombre;

    private String apellido;
    private LocalDateTime fecha_nacimiento;

    private LocalDateTime fecha_creacion;

    private String correo_electronico;

    private Date fecha_modificacion;


    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }
    public String getCorreo_electronico() {
        return correo_electronico;
    }
    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }
    public String getTipo_identificacion() {
        return tipo_identificacion;
    }
    public String getNumero_identificacion() {
        return numero_identificacion;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public LocalDateTime getFecha_nacimiento() {
        return fecha_nacimiento;
    }
}
