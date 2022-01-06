package Dados;

import Negocios.Financeiro;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BancoContaReceber implements IBancoContaReceber {

    private static BancoContaReceber instancia = null;

    public static BancoContaReceber getInstancia() {
        if (instancia == null) {
            instancia = new BancoContaReceber();
        }
        return instancia;
    }

    @Override
    public void deletarContasReceberJDBC(Financeiro contas_Receber) {
        try {
            ConectaBDContaReceber conexao = new ConectaBDContaReceber();
            conexao.deletarContasReceberJDBC(contas_Receber);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void incluirContas_ReceberJDBC(Financeiro contas_Receber) {
        try {
            ConectaBDContaReceber conexao = new ConectaBDContaReceber();
            conexao.incluirContas_ReceberJDBC(contas_Receber);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void editarContas_ReceberJDBC(Financeiro contas_Receber) {
        try {
            ConectaBDContaReceber conexao = new ConectaBDContaReceber();
            conexao.editarContas_ReceberJDBC(contas_Receber);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList consultarContaReceberQuery(String query) {
        try {
            ConectaBDContaReceber conexao = new ConectaBDContaReceber();
            return conexao.consultarContaReceberQuery(query);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void exclusaoLogicaContasReceberJDBC(Financeiro contas_Receber) {
        try {
            ConectaBDContaReceber conexao = new ConectaBDContaReceber();
            conexao.exclusaoLogicaContasReceberJDBC(contas_Receber);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Financeiro consultarContaReceber(int id) {
        ConectaBDContaReceber conexao = new ConectaBDContaReceber();
        return conexao.consultarContaReceber(id);
    }

}
