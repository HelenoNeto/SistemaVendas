/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Utilitarios.ClasseUtilitaria;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Neto
 */
public class VendaCabecalho {

    private Integer id;
    private TipoPagamento tipoPagamento;
    private Funcionario vendedor;
    private Cliente cliente;
    private Financeiro contas_Receber;
    private Date data_hora_venda;
    private String tipo_desconto;
    private BigDecimal desconto;
    private String tipo_acrescimo;
    private BigDecimal acrescimo;
    private BigDecimal subtotal;
    private BigDecimal total;
    private boolean excluido;
    private Integer id_usuario_insercao;
    private Integer id_usuario_edicao;
    private Integer id_usuario_exclusao;
    private Date data_edicao;
    private Date data_exclusao;
    private ArrayList<VendaDetalhe> listaDetalhe;
    private String obs;

    public VendaCabecalho(TipoPagamento tipoPagamento, Funcionario vendedor, Cliente cliente, Financeiro contas_Receber,
            Date data_hora_venda, String tipo_desconto, BigDecimal desconto, String tipo_acrescimo, BigDecimal acrescimo,
            BigDecimal subtotal, BigDecimal total, boolean excluido, Integer id_usuario_insercao) {
        this.tipoPagamento = tipoPagamento;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.contas_Receber = contas_Receber;
        this.data_hora_venda = data_hora_venda;
        this.tipo_desconto = tipo_desconto;
        this.desconto = desconto;
        this.tipo_acrescimo = tipo_acrescimo;
        this.acrescimo = acrescimo;
        this.subtotal = subtotal;
        this.total = total;
        this.excluido = excluido;
        this.id_usuario_insercao = id_usuario_insercao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Financeiro getContas_Receber() {
        return contas_Receber;
    }

    public void setContas_Receber(Financeiro contas_Receber) {
        this.contas_Receber = contas_Receber;
    }

    public Date getData_hora_venda() {
        return data_hora_venda;
    }

    public String getData_hora_vendaFMT() {
        return ClasseUtilitaria.fmtDataHoraBR.format(data_hora_venda);
    }

    public void setData_hora_venda(Date data_hora_venda) {
        this.data_hora_venda = data_hora_venda;
    }

    public String getTipo_desconto() {
        return tipo_desconto;
    }

    public void setTipo_desconto(String tipo_desconto) {
        this.tipo_desconto = tipo_desconto;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public String getDescontoFMT() {
        return ClasseUtilitaria.fmtBig(desconto, 2);
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getTipo_acrescimo() {
        return tipo_acrescimo;
    }

    public void setTipo_acrescimo(String tipo_acrescimo) {
        this.tipo_acrescimo = tipo_acrescimo;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public String getAcrescimoFMT() {
        return ClasseUtilitaria.fmtBig(acrescimo, 2);
    }

    public void setAcrescimo(BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public String getSubtotalFMT() {
        return ClasseUtilitaria.fmtBig(subtotal, 2);
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getTotalFMT() {
        return ClasseUtilitaria.fmtBig(total, 2);
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public Integer getId_usuario_insercao() {
        return id_usuario_insercao;
    }

    public void setId_usuario_insercao(Integer id_usuario_insercao) {
        this.id_usuario_insercao = id_usuario_insercao;
    }

    public Integer getId_usuario_edicao() {
        return id_usuario_edicao;
    }

    public void setId_usuario_edicao(Integer id_usuario_edicao) {
        this.id_usuario_edicao = id_usuario_edicao;
    }

    public Integer getId_usuario_exclusao() {
        return id_usuario_exclusao;
    }

    public void setId_usuario_exclusao(Integer id_usuario_exclusao) {
        this.id_usuario_exclusao = id_usuario_exclusao;
    }

    public Date getData_edicao() {
        return data_edicao;
    }

    public void setData_edicao(Date data_edicao) {
        this.data_edicao = data_edicao;
    }

    public Date getData_exclusao() {
        return data_exclusao;
    }

    public void setData_exclusao(Date data_exclusao) {
        this.data_exclusao = data_exclusao;
    }

    public ArrayList<VendaDetalhe> getListaDetalhe() {
        return listaDetalhe;
    }

    public void setListaDetalhe(ArrayList<VendaDetalhe> listaDetalhe) {
        this.listaDetalhe = listaDetalhe;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

}
