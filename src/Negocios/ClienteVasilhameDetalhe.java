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
 * @author Heleno
 */
public class ClienteVasilhameDetalhe {

    private Integer id;
    private Integer id_cliente_vasilhame;
    private Date data_hora_transacao;
    private BigDecimal quantidade_devolvida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_cliente_vasilhame() {
        return id_cliente_vasilhame;
    }

    public void setId_cliente_vasilhame(Integer id_cliente_vasilhame) {
        this.id_cliente_vasilhame = id_cliente_vasilhame;
    }

    public Date getData_hora_transacao() {
        return data_hora_transacao;
    }

    public void setData_hora_transacao(Date data_hora_transacao) {
        this.data_hora_transacao = data_hora_transacao;
    }

    public BigDecimal getQuantidade_devolvida() {
        return quantidade_devolvida;
    }

    public void setQuantidade_devolvida(BigDecimal quantidade_devolvida) {
        this.quantidade_devolvida = quantidade_devolvida;
    }

}
