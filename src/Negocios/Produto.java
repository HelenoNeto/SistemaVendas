package Negocios;

import sistema.gas.unidadeProduto.negocios.UnidadeProduto;
import Utilitarios.ClasseUtilitaria;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {

    private Integer id;
    private Integer id_produto_vasilhame;
    private BigDecimal qtd_vasilhame;
    private Date data_cadastro;
    private Grupo grupo;
    private String codigo;
    private String descricao;
    private BigDecimal valor_venda;
    private BigDecimal valor_compra;
    private BigDecimal lucro;
    private BigDecimal qtd_estoque;
    private BigDecimal qtd_estoque_avaria;
    private boolean excluido;
    private Date data_edicao;
    private Date data_exclusao;
    private Integer id_usuario_insercao;
    private Integer id_usuario_edicao;
    private Integer id_usuario_exclusao;
    private UnidadeProduto unidadeProduto;

    public Produto() {

    }

    public Produto(Integer id_produto_vasilhame, BigDecimal qtd_vasilhame, Date data_cadastro, Grupo grupo, String codigo, String descricao, BigDecimal valor_venda, BigDecimal qtd_estoque, BigDecimal qtd_estoque_avaria, boolean excluido, Integer id_usuario_insercao, BigDecimal valor_compra, BigDecimal lucro) {
        this.id_produto_vasilhame = id_produto_vasilhame;
        this.qtd_vasilhame = qtd_vasilhame;
        this.data_cadastro = data_cadastro;
        this.grupo = grupo;
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor_venda = valor_venda;
        this.qtd_estoque = qtd_estoque;
        this.qtd_estoque_avaria = qtd_estoque_avaria;
        this.excluido = excluido;
        this.id_usuario_insercao = id_usuario_insercao;
        this.valor_compra = valor_compra;
        this.lucro = lucro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_produto_vasilhame() {
        return id_produto_vasilhame;
    }

    public void setId_produto_vasilhame(Integer id_produto_vasilhame) {
        this.id_produto_vasilhame = id_produto_vasilhame;
    }

    public BigDecimal getQtd_vasilhame() {
        return qtd_vasilhame;
    }

    public String getQtd_vasilhameFMT() {
        return ClasseUtilitaria.fmtBig(qtd_vasilhame, 4);
    }

    public void setQtd_vasilhame(BigDecimal qtd_vasilhame) {
        this.qtd_vasilhame = qtd_vasilhame;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor_venda() {
        return valor_venda;
    }

    public String getValor_vendaFMT() {
        return ClasseUtilitaria.fmtBig(valor_venda, 4);
    }

    public void setValor_venda(BigDecimal valor_venda) {
        this.valor_venda = valor_venda;
    }

    public BigDecimal getValor_compra() {
        return valor_compra;
    }

    public String getValor_compraFMT() {
        return ClasseUtilitaria.fmtBig(valor_compra, 2);
    }

    public void setValor_compra(BigDecimal valor_compra) {
        this.valor_compra = valor_compra;
    }

    public BigDecimal getLucro() {
        return lucro;
    }

    public String getLucroFMT() {
        return ClasseUtilitaria.fmtBig(lucro, 4);
    }

    public void setLucro(BigDecimal lucro) {
        this.lucro = lucro;
    }

    public BigDecimal getQtd_estoque() {
        return qtd_estoque;
    }

    public String getQtd_estoqueFMT() {
        return ClasseUtilitaria.fmtBig(qtd_estoque, 4);
    }

    public void setQtd_estoque(BigDecimal qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public BigDecimal getQtd_estoque_avaria() {
        return qtd_estoque_avaria;
    }

    public String getQtd_estoque_avariaFMT() {
        return ClasseUtilitaria.fmtBig(qtd_estoque_avaria, 4);
    }

    public void setQtd_estoque_avaria(BigDecimal qtd_estoque_avaria) {
        this.qtd_estoque_avaria = qtd_estoque_avaria;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
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

    public UnidadeProduto getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(UnidadeProduto unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    public String getDateFormat(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

}
