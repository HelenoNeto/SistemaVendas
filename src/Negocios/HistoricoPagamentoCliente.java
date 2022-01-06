/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class HistoricoPagamentoCliente {

    private Integer id_conta;
    private Date data_vencimento_parcela;
    private Date data_recebimento;
    private String hora_recebimento;
    private String referente;
    private BigDecimal valor_total;
    private BigDecimal valor_recebido;

    public Integer getId_conta() {
        return id_conta;
    }

    public void setId_conta(Integer id_conta) {
        this.id_conta = id_conta;
    }

    public Date getData_vencimento_parcela() {
        return data_vencimento_parcela;
    }

    public void setData_vencimento_parcela(Date data_vencimento_parcela) {
        this.data_vencimento_parcela = data_vencimento_parcela;
    }

    public Date getData_recebimento() {
        return data_recebimento;
    }

    public void setData_recebimento(Date data_recebimento) {
        this.data_recebimento = data_recebimento;
    }

    public String getHora_recebimento() {
        return hora_recebimento;
    }

    public void setHora_recebimento(String hora_recebimento) {
        this.hora_recebimento = hora_recebimento;
    }

    public String getReferente() {
        return referente;
    }

    public void setReferente(String referente) {
        this.referente = referente;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public BigDecimal getValor_recebido() {
        return valor_recebido;
    }

    public void setValor_recebido(BigDecimal valor_recebido) {
        this.valor_recebido = valor_recebido;
    }

}
