/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios.Controladores;

import Dados.BancoParcelasReceberHistoricoRecebimento;
import Dados.IBancoParcelasReceberHistoricoRecebimento;
import Negocios.FinanceiroParcelas;
import Negocios.FinanceiroRecPag;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class ControladorParcelasReceberHistoricoRecebimento implements IControladorParcelasReceberHistoricoRecebimento {

    @Override
    public int retornarAutoIncrementHistoricoRecebimentoParcelasReceber() {
        IBancoParcelasReceberHistoricoRecebimento iBancoParcelasReceberHistoricoRecebimento = BancoParcelasReceberHistoricoRecebimento.getInstancia();
        return iBancoParcelasReceberHistoricoRecebimento.retornarAutoIncrementHistoricoRecebimentoParcelasReceber();
    }

    @Override
    public void incluirHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento) {
        IBancoParcelasReceberHistoricoRecebimento iBancoParcelasReceberHistoricoRecebimento = BancoParcelasReceberHistoricoRecebimento.getInstancia();
        iBancoParcelasReceberHistoricoRecebimento.incluirHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
    }

    @Override
    public ArrayList consultarHistoricoRecebimentoParcelasReceberJDBC(String query) {
        IBancoParcelasReceberHistoricoRecebimento iBancoParcelasReceberHistoricoRecebimento = BancoParcelasReceberHistoricoRecebimento.getInstancia();
        return iBancoParcelasReceberHistoricoRecebimento.consultarHistoricoRecebimentoParcelasReceberJDBC(query);
    }

    @Override
    public void atualizarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento) {
        IBancoParcelasReceberHistoricoRecebimento iBancoParcelasReceberHistoricoRecebimento = BancoParcelasReceberHistoricoRecebimento.getInstancia();
        iBancoParcelasReceberHistoricoRecebimento.atualizarHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
    }

    @Override
    public void deletarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroParcelas parcelas_receber) {
        IBancoParcelasReceberHistoricoRecebimento iBancoParcelasReceberHistoricoRecebimento = BancoParcelasReceberHistoricoRecebimento.getInstancia();
        iBancoParcelasReceberHistoricoRecebimento.deletarHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber);
    }
}