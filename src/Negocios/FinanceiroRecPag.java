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
public class FinanceiroRecPag {

    private Integer id;
    private Integer id_parcelas_receber;
    private Date data_recebimento;
    private BigDecimal valor_recebido;
    private String hora_recebimento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_parcelas_receber() {
        return id_parcelas_receber;
    }

    public void setId_parcelas_receber(Integer id_parcelas_receber) {
        this.id_parcelas_receber = id_parcelas_receber;
    }

    public Date getData_recebimento() {
        return data_recebimento;
    }

    public void setData_recebimento(Date data_recebimento) {
        this.data_recebimento = data_recebimento;
    }

    public BigDecimal getValor_recebido() {
        return valor_recebido;
    }

    public void setValor_recebido(BigDecimal valor_recebido) {
        this.valor_recebido = valor_recebido;
    }

    public String getHora_recebimento() {
        return hora_recebimento;
    }

    public void setHora_recebimento(String hora_recebimento) {
        this.hora_recebimento = hora_recebimento;
    }

}
