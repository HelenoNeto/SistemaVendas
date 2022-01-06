/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Heleno
 */
public class ClienteVasilhame {

    private Integer id;
    private Integer id_venda_detalhe;
    private Integer id_produto_vasilhame;
    private ArrayList<ClienteVasilhameDetalhe> listaClienteVasilhameDetalhe;
    private BigDecimal quantidade;
    private Date data_hora_transacao;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_venda_detalhe() {
        return id_venda_detalhe;
    }

    public void setId_venda_detalhe(Integer id_venda_detalhe) {
        this.id_venda_detalhe = id_venda_detalhe;
    }

    public Integer getId_produto_vasilhame() {
        return id_produto_vasilhame;
    }

    public void setId_produto_vasilhame(Integer id_produto_vasilhame) {
        this.id_produto_vasilhame = id_produto_vasilhame;
    }

    public ArrayList<ClienteVasilhameDetalhe> getListaClienteVasilhameDetalhe() {
        return listaClienteVasilhameDetalhe;
    }

    public void setListaClienteVasilhameDetalhe(ArrayList<ClienteVasilhameDetalhe> listaClienteVasilhameDetalhe) {
        this.listaClienteVasilhameDetalhe = listaClienteVasilhameDetalhe;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData_hora_transacao() {
        return data_hora_transacao;
    }

    public void setData_hora_transacao(Date data_hora_transacao) {
        this.data_hora_transacao = data_hora_transacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
