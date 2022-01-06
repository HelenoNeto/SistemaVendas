package Negocios;

import java.math.BigDecimal;

public class NotaEntradaProduto {

    private int id;
    private int id_nota_entrada;
    private String descricao_produto;
    private int id_produto;
    private BigDecimal quantidade;
    private BigDecimal preco_uni;
    private BigDecimal valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_nota_entrada() {
        return id_nota_entrada;
    }

    public void setId_nota_entrada(int id_nota_entrada) {
        this.id_nota_entrada = id_nota_entrada;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco_uni() {
        return preco_uni;
    }

    public void setPreco_uni(BigDecimal preco_uni) {
        this.preco_uni = preco_uni;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
