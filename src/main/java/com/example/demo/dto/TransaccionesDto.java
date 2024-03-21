package com.example.demo.dto;

public class TransaccionesDto {


    private Long idProductoFinanciero;
    private Double monto;

    private String numeroCuentaDestino;



    private Long idProductoFinancieroDestino;


    public Long getIdProductoFinanciero() {
        return idProductoFinanciero;
    }

    public void setIdProductoFinanciero(Long idProductoFinanciero) {
        this.idProductoFinanciero = idProductoFinanciero;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }


    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(String numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public Long getIdProductoFinancieroDestino() {
        return idProductoFinancieroDestino;
    }

    public void setIdProductoFinancieroDestino(Long idProductoFinancieroDestino) {
        this.idProductoFinancieroDestino = idProductoFinancieroDestino;
    }
}
