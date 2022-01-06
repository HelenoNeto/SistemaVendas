package Dados;

import Negocios.Financeiro;
import Negocios.FinanceiroParcelas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BancoParcelasReceber implements IBancoParcelasReceber {

    private static BancoParcelasReceber instancia = null;

    public static BancoParcelasReceber getInstancia() {
        if (instancia == null) {
            instancia = new BancoParcelasReceber();
        }
        return instancia;
    }

    @Override
    public void deletarParcelasReceberJDBC(FinanceiroParcelas parcelas_receber) {
        try {
            ConectaBDParcelasReceber conexao = new ConectaBDParcelasReceber();
            conexao.deletarParcelasReceberJDBC(parcelas_receber);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public double somaValorParcelas(int id_contas) {
        try {
            ConectaBDParcelasReceber bDParcelasReceber = new ConectaBDParcelasReceber();
            return bDParcelasReceber.somaValorParcelas(id_contas);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    @Override
    public void incluirParcelas_receberJDBC(FinanceiroParcelas parcelas_receber) {
        try {
            ConectaBDParcelasReceber bDParcelasReceber = new ConectaBDParcelasReceber();
            bDParcelasReceber.incluirParcelas_receberJDBC(parcelas_receber);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void editarParcelas_receberJDBC(FinanceiroParcelas parcelas_receber) {
        try {
            ConectaBDParcelasReceber bDParcelasReceber = new ConectaBDParcelasReceber();
            bDParcelasReceber.editarParcelas_receberJDBC(parcelas_receber);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList consultarParcelasReceberQuery(String query) {
        try {
            ConectaBDParcelasReceber bDParcelasReceber = new ConectaBDParcelasReceber();
            return bDParcelasReceber.consultarParcelasReceberQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public ArrayList consultarParcelasReceber(Financeiro financeiro) {
        ConectaBDParcelasReceber bDParcelasReceber = new ConectaBDParcelasReceber();
        return bDParcelasReceber.consultarParcelasReceber(financeiro);
    }
}
