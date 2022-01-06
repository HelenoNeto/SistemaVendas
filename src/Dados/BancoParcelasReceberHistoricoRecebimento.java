/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.FinanceiroParcelas;
import Negocios.FinanceiroRecPag;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class BancoParcelasReceberHistoricoRecebimento implements IBancoParcelasReceberHistoricoRecebimento {

    private static BancoParcelasReceberHistoricoRecebimento instancia = null;

    public static BancoParcelasReceberHistoricoRecebimento getInstancia() {
        if (instancia == null) {
            instancia = new BancoParcelasReceberHistoricoRecebimento();
        }
        return instancia;
    }

    @Override
    public int retornarAutoIncrementHistoricoRecebimentoParcelasReceber() {
        try {
            ConectaBDHistoricoRecebimentoParcelasReceber cbdhrpr = new ConectaBDHistoricoRecebimentoParcelasReceber();
            return cbdhrpr.retornarAutoIncrementHistoricoRecebimentoParcelasReceber();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    @Override
    public void incluirHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento) {
        try {
            ConectaBDHistoricoRecebimentoParcelasReceber cbdhrpr = new ConectaBDHistoricoRecebimentoParcelasReceber();
            cbdhrpr.incluirHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList consultarHistoricoRecebimentoParcelasReceberJDBC(String query) {
        try {
            ConectaBDHistoricoRecebimentoParcelasReceber cbdhrpr = new ConectaBDHistoricoRecebimentoParcelasReceber();
            return cbdhrpr.consultarHistoricoRecebimentoParcelasReceberJDBC(query);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void atualizarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento) {
        try {
            ConectaBDHistoricoRecebimentoParcelasReceber cbdhrpr = new ConectaBDHistoricoRecebimentoParcelasReceber();
            cbdhrpr.atualizarHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deletarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroParcelas parcelas_receber) {
        try {
            ConectaBDHistoricoRecebimentoParcelasReceber cbdhrpr = new ConectaBDHistoricoRecebimentoParcelasReceber();
            cbdhrpr.deletarHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
