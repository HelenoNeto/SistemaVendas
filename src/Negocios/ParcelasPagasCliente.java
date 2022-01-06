/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Neto
 */
public class ParcelasPagasCliente {

    Integer id_parcela;
    Date dataVencimento;
    Date dataPagamento;
    String horaRecebimento;
    BigDecimal valor;
    BigDecimal valorPago;

    public Integer getId_parcela() {
        return id_parcela;
    }

    public void setId_parcela(Integer id_parcela) {
        this.id_parcela = id_parcela;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getHoraRecebimento() {
        return horaRecebimento;
    }

    public void setHoraRecebimento(String horaRecebimento) {
        this.horaRecebimento = horaRecebimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

}
