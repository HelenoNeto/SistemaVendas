/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Utilitarios.ClasseUtilitaria;
import java.math.BigDecimal;

/**
 *
 * @author Neto
 */
public class VendaDetalhe {

    private Integer id;
    private Integer id_venda_cabecalho;
    private Produto produto;
    private String codigoProduto;
    private String descricaoProduto;
    private String unidadeProduto;
    private BigDecimal quantidade;
    private BigDecimal valorUniCompra;
    private BigDecimal valor_unitario;
    private BigDecimal valor_total;
    private boolean vasilhame_pendente;
    private BigDecimal qtd_vasilhame_pendente;
    private BigDecimal qtd_vasilhame_vazio;

    public VendaDetalhe() {

    }

    public VendaDetalhe(Integer id_venda_cabecalho, Produto produto, String codigoProduto, String descricaoProduto, String unidadeProduto, BigDecimal quantidade, BigDecimal valorUniCompra, BigDecimal valor_unitario, BigDecimal valor_total, boolean vasilhame_pendente, BigDecimal qtd_vasilhame_pendente) {
        this.id_venda_cabecalho = id_venda_cabecalho;
        this.produto = produto;
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.unidadeProduto = unidadeProduto;
        this.quantidade = quantidade;
        this.valorUniCompra = valorUniCompra;
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
        this.vasilhame_pendente = vasilhame_pendente;
        this.qtd_vasilhame_pendente = qtd_vasilhame_pendente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_venda_cabecalho() {
        return id_venda_cabecalho;
    }

    public void setId_venda_cabecalho(Integer id_venda_cabecalho) {
        this.id_venda_cabecalho = id_venda_cabecalho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public String getQuantidadeFMT() {
        return ClasseUtilitaria.fmtBig(quantidade, 4);
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor_unitario() {
        return valor_unitario;
    }

    public String getValor_unitarioFMT() {
        return ClasseUtilitaria.fmtBig(valor_unitario, 2);
    }

    public void setValor_unitario(BigDecimal valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public String getValor_totalFMT() {
        return ClasseUtilitaria.fmtBig(valor_total, 2);
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public boolean isVasilhame_pendente() {
        return vasilhame_pendente;
    }

    public void setVasilhame_pendente(boolean vasilhame_pendente) {
        this.vasilhame_pendente = vasilhame_pendente;
    }

    public BigDecimal getQtd_vasilhame_pendente() {
        return qtd_vasilhame_pendente;
    }

    public void setQtd_vasilhame_pendente(BigDecimal qtd_vasilhame_pendente) {
        this.qtd_vasilhame_pendente = qtd_vasilhame_pendente;
    }

    public BigDecimal getQtd_vasilhame_vazio() {
        return qtd_vasilhame_vazio;
    }

    public void setQtd_vasilhame_vazio(BigDecimal qtd_vasilhame_vazio) {
        this.qtd_vasilhame_vazio = qtd_vasilhame_vazio;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(String unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    public BigDecimal getValorUniCompra() {
        return valorUniCompra;
    }

    public void setValorUniCompra(BigDecimal valorUniCompra) {
        this.valorUniCompra = valorUniCompra;
    }

}
