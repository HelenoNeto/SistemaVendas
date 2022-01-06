package Negocios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class FinanceiroParcelas {

    private Integer id;
    private Financeiro financeiro;
    private Integer lancamento;
    private Date data_vencimento;
    private String parcela;
    private Date data_pagamento;
    private BigDecimal valor;
    private BigDecimal valor_pago;
    private String Status;
    private ArrayList<FinanceiroRecPag> listaRecebimento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Financeiro getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(Financeiro financeiro) {
        this.financeiro = financeiro;
    }

    public Integer getLancamento() {
        return lancamento;
    }

    public void setLancamento(Integer lancamento) {
        this.lancamento = lancamento;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(BigDecimal valor_pago) {
        this.valor_pago = valor_pago;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public ArrayList<FinanceiroRecPag> getListaRecebimento() {
        return listaRecebimento;
    }

    public void setListaRecebimento(ArrayList<FinanceiroRecPag> listaRecebimento) {
        this.listaRecebimento = listaRecebimento;
    }

}
