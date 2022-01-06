package Negocios;

import Negocios.Controladores.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Fachada {

    private static Fachada instancia = null;
    private ControladorFuncionario fFuncionario = null;
    private ControladorContas_Receber fContas_Receber = null;
    private ControladorParcelas_Receber fParcelas_Receber = null;
    private ControladorEmpresa fEmpresa = null;
    private ControladorGrupo fGrupo = null;
    private ControladorTipoPagamento fTipoPagamento = null;
    private ControladorParcelasReceberHistoricoRecebimento fParcelasReceberHistoricoRecebimento = null;
    private ControladorVendaDetalhe fVendaDetalhe = null;
    private ControladorVendaCabecalho fVendaCabecalho = null;
    private ControladorParcelasPagasCliente fParcelasPagasCliente = null;
    private ControladorFornecedor fFornecedor = null;
    private ControladorNota_fiscal fNotaEntrada = null;
    private ControladorNotaFiscalProduto fNotaFiscalProduto = null;

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    private Fachada() {
        fFuncionario = new ControladorFuncionario();
        fContas_Receber = new ControladorContas_Receber();
        fParcelas_Receber = new ControladorParcelas_Receber();
        fEmpresa = new ControladorEmpresa();
        fGrupo = new ControladorGrupo();
        fTipoPagamento = new ControladorTipoPagamento();
        fParcelasReceberHistoricoRecebimento = new ControladorParcelasReceberHistoricoRecebimento();
        fVendaDetalhe = new ControladorVendaDetalhe();
        fVendaCabecalho = new ControladorVendaCabecalho();
        fParcelasPagasCliente = new ControladorParcelasPagasCliente();
        fFornecedor = new ControladorFornecedor();
        fNotaEntrada = new ControladorNota_fiscal();
        fNotaFiscalProduto = new ControladorNotaFiscalProduto();
    }

    //FACHADA FUNCIONARIO
    public void incluirFuncionario(Funcionario funcionario) throws SQLException {
        fFuncionario.incluirFuncionario(funcionario);
    }

    public void editarFuncionario(Funcionario funcionario) throws SQLException {
        fFuncionario.editarFuncionario(funcionario);
    }

    public ArrayList consultarFuncionario(String query) throws SQLException {
        return fFuncionario.consultarFuncionario(query);
    }

    public Funcionario consultarFuncionario(int id_funcionario) throws SQLException {
        return fFuncionario.consultarFuncionario(id_funcionario);
    }

    public void excluirFuncionario(Funcionario funcionario) throws SQLException {
        fFuncionario.excluirFuncionario(funcionario);
    }

    //FACHADA CONTAS A RECEBER
    public void deletarContasReceberJDBC(Financeiro contas_Receber) {
        fContas_Receber.deletarContasReceberJDBC(contas_Receber);
    }

    public void incluirContas_ReceberJDBC(Financeiro contas_Receber) {
        fContas_Receber.incluirContas_ReceberJDBC(contas_Receber);
    }

    public void editarContas_ReceberJDBC(Financeiro contas_Receber) {
        fContas_Receber.editarContas_ReceberJDBC(contas_Receber);
    }

    public ArrayList consultarContaReceberQuery(String query) {
        return fContas_Receber.consultarContaReceberQuery(query);
    }

    public void exclusaoLogicaContasReceberJDBC(Financeiro contas_Receber) {
        fContas_Receber.exclusaoLogicaContasReceberJDBC(contas_Receber);
    }

    public Financeiro consultarContaReceber(int id) {
        return fContas_Receber.consultarContaReceber(id);
    }

    //FACHADA PARCELAS_RECEBER
    public void deletarParcelasReceberJDBC(FinanceiroParcelas parcelas_receber) {
        fParcelas_Receber.deletarParcelasReceberJDBC(parcelas_receber);
    }

    public double somaValorParcelas(int id_contas) {
        return fParcelas_Receber.somaValorParcelas(id_contas);
    }

    public void incluirParcelas_receberJDBC(FinanceiroParcelas parcelas_receber) {
        fParcelas_Receber.incluirParcelas_receberJDBC(parcelas_receber);
    }

    public void editarParcelas_receberJDBC(FinanceiroParcelas parcelas_receber) {
        fParcelas_Receber.editarParcelas_receberJDBC(parcelas_receber);
    }

    public ArrayList consultarParcelasReceberQuery(String query) {
        return fParcelas_Receber.consultarParcelasReceberQuery(query);
    }

    public ArrayList consultarParcelasReceber(Financeiro financeiro) {
        return fParcelas_Receber.consultarParcelasReceber(financeiro);
    }

    //FACHADA EMITENTE
    public void incluirEmpresa(Empresa emitentes) {
        fEmpresa.incluirEmpresa(emitentes);
    }

    public Empresa consultarEmpresa(String query) {
        return fEmpresa.consultarEmpresa(query);
    }

    public void editarEmpresa(Empresa emitentes) {
        fEmpresa.atualizarEmpresa(emitentes);
    }

    //FACHADA GRUPO
    public void incluirGrupo(Grupo grupo) throws SQLException {
        fGrupo.incluirGrupo(grupo);
    }

    public void editarGrupo(Grupo grupo) throws SQLException {
        fGrupo.editarGrupo(grupo);
    }

    public ArrayList consultarGrupo(String query) throws SQLException {
        return fGrupo.consultarGrupo(query);
    }

    public void excluirGrupo(Grupo grupo) throws SQLException {
        fGrupo.excluirGrupo(grupo);
    }

    public int retornoAutoIncrementGrupo() throws SQLException {
        return fGrupo.retornoAutoIncrementGrupo();
    }

    public void alterarGrupoExclusao(Grupo grupo) throws SQLException {
        fGrupo.alterarGrupoExclusao(grupo);
    }

    //FACHADA PARCELAS RECEBER HISTORICO RECEBIMENTO
    public int retornarAutoIncrementHistoricoRecebimentoParcelasReceber() {
        return fParcelasReceberHistoricoRecebimento.retornarAutoIncrementHistoricoRecebimentoParcelasReceber();
    }

    public void incluirHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento) {
        fParcelasReceberHistoricoRecebimento.incluirHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
    }

    public ArrayList consultarHistoricoRecebimentoParcelasReceberJDBC(String query) {
        return fParcelasReceberHistoricoRecebimento.consultarHistoricoRecebimentoParcelasReceberJDBC(query);
    }

    public void atualizarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento) {
        fParcelasReceberHistoricoRecebimento.atualizarHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
    }

    public void deletarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroParcelas parcelas_receber) {
        fParcelasReceberHistoricoRecebimento.deletarHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber);
    }

    //Fachada tipo de pagamento
    public void incluirTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        fTipoPagamento.incluirTipoPagamento(tipoPagamento);
    }

    public ArrayList consultarTipoPagamento(String query) throws SQLException {
        return fTipoPagamento.consultarTipoPagamento(query);
    }

    public TipoPagamento consultarTipoPagamento(int id_tipo_pagamento) throws SQLException {
        return fTipoPagamento.consultarTipoPagamento(id_tipo_pagamento);
    }

    public void deletarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        fTipoPagamento.deletarTipoPagamento(tipoPagamento);
    }

    public void editarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        fTipoPagamento.editarTipoPagamento(tipoPagamento);
    }

    //Fachada Venda Cabecalho
    public VendaCabecalho incluirVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        return fVendaCabecalho.incluirVendaCabecalho(vendaCabecalho);
    }

    public void editarVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        fVendaCabecalho.editarVendaCabecalho(vendaCabecalho);
    }

    public ArrayList consultarVendaCabecalho(String query) throws SQLException {
        return fVendaCabecalho.consultarVendaCabecalho(query);
    }

    public void excluirVendaCabecalho(VendaCabecalho vendaCabecalho) {
        fVendaCabecalho.excluirVendaCabecalho(vendaCabecalho);
    }

    public void exclusaoLogicaVendaCabecalho(VendaCabecalho vendaCabecalho) {
        fVendaCabecalho.exclusaoLogicaVendaCabecalho(vendaCabecalho);
    }

    //Fachada Venda Detalhe
    public void incluirVendaDetalhe(VendaDetalhe vendaDetalhe) throws SQLException {
        fVendaDetalhe.incluirVendaDetalhe(vendaDetalhe);
    }

    public void incluirListaVendaDetalhe(ArrayList<VendaDetalhe> listaVendaDetalhe) {
        fVendaDetalhe.incluirListaVendaDetalhe(listaVendaDetalhe);
    }

    public ArrayList consultarVendaDetalhe(String query) throws SQLException {
        return fVendaDetalhe.consultarVendaDetalhe(query);
    }

    public void excluirVendaDetalhe(VendaCabecalho vendaCabecalho) throws SQLException {
        fVendaDetalhe.excluirVendaDetalhe(vendaCabecalho);
    }

    public VendaDetalhe consultarVendaDetalhe_porIdVendaDetalhe(int id_venda_detalhe) throws SQLException {
        return fVendaDetalhe.consultarVendaDetalhe_porIdVendaDetalhe(id_venda_detalhe);
    }

    //Fachada ParcelasPagasCliente
    public ArrayList<ParcelasPagasCliente> consultarParcelasPagasCliente(int idCliente) {
        return fParcelasPagasCliente.consultarParcelasPagasCliente(idCliente);
    }

    //Fachada Fornecedor
    public Fornecedor incluirFornecedor(Fornecedor fornecedor) throws SQLException {
        return fFornecedor.incluirFornecedor(fornecedor);
    }

    public void editarFornecedor(Fornecedor fornecedor) throws SQLException {
        fFornecedor.editarFornecedor(fornecedor);
    }

    public Fornecedor consultarFornecedor(int id) throws SQLException {
        return fFornecedor.consultarFornecedor(id);
    }

    public ArrayList<Fornecedor> consultarFornecedor(String coluna, String dado) throws SQLException {
        return fFornecedor.consultarFornecedor(coluna, dado);
    }

    public void excluirFornecedor(Fornecedor fornecedor) throws SQLException {
        fFornecedor.excluirFornecedor(fornecedor);
    }

    //FACHADA NOTA_FISCAL
    public void incluirNotaFiscalJDBC(NotaEntrada nota_fiscal) {
        fNotaEntrada.incluirNotaFiscalJDBC(nota_fiscal);
    }

    public ArrayList<NotaEntrada> consultarNotaFiscalJDBC(String tipo, String dado) {
        return fNotaEntrada.consultarNotaFiscalJDBC(tipo, dado);
    }

    public ArrayList<NotaEntrada> consultarNotaFiscalQueryJDBC(String query) {
        return fNotaEntrada.consultarNotaFiscalQueryJDBC(query);
    }

    public void editaNotaFiscalJDBC(NotaEntrada nota_fiscal) {
        fNotaEntrada.editaNotaFiscalJDBC(nota_fiscal);
    }

    public void excluirNotaFiscalJDBC(NotaEntrada nota_fiscal) {
        fNotaEntrada.excluirNotaFiscalJDBC(nota_fiscal);
    }

    //FACHADA NOTA FISCAL PRODUTO
    public void incluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_fiscalProduto) {
        fNotaFiscalProduto.incluirNotaFiscalProdutoJDBC(nota_fiscalProduto);
    }

    public ArrayList consultarNotaFiscalProdutoJDBC(int id_nota_fiscal) {
        return fNotaFiscalProduto.consultarNotaFiscalProdutoJDBC(id_nota_fiscal);
    }

    public void excluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_fiscalProduto) {
        fNotaFiscalProduto.excluirNotaFiscalProdutoJDBC(nota_fiscalProduto);
    }

    public ArrayList consultarNotaFiscalProdutoQueryJDBC(String query) {
        return fNotaFiscalProduto.consultarNotaFiscalProdutoQueryJDBC(query);
    }

}
