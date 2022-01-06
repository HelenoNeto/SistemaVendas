package Negocios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Financeiro {

    private Integer id;
    private Date data_emissao;
    private Cliente cliente;
    private String referente;
    private BigDecimal valor_total;
    private Integer numero_parcelas;
    private BigDecimal entrada;
    private String documento;
    private boolean excluido;
    private Date data_exclusao;
    private Integer id_usuario_exclusao;
    private Date data_edicao;
    private Integer id_usuario_edicao;
    private Integer id_usuario_insercao;
    private ArrayList<FinanceiroParcelas> listaParcelasReceber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Integer getNumero_parcelas() {
        return numero_parcelas;
    }

    public void setNumero_parcelas(Integer numero_parcelas) {
        this.numero_parcelas = numero_parcelas;
    }

    public BigDecimal getEntrada() {
        return entrada;
    }

    public void setEntrada(BigDecimal entrada) {
        this.entrada = entrada;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public Date getData_exclusao() {
        return data_exclusao;
    }

    public void setData_exclusao(Date data_exclusao) {
        this.data_exclusao = data_exclusao;
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

    public Integer getId_usuario_edicao() {
        return id_usuario_edicao;
    }

    public void setId_usuario_edicao(Integer id_usuario_edicao) {
        this.id_usuario_edicao = id_usuario_edicao;
    }

    public Integer getId_usuario_insercao() {
        return id_usuario_insercao;
    }

    public void setId_usuario_insercao(Integer id_usuario_insercao) {
        this.id_usuario_insercao = id_usuario_insercao;
    }

    public ArrayList<FinanceiroParcelas> getListaParcelasReceber() {
        return listaParcelasReceber;
    }

    public void setListaParcelasReceber(ArrayList<FinanceiroParcelas> listaParcelasReceber) {
        this.listaParcelasReceber = listaParcelasReceber;
    }

}
