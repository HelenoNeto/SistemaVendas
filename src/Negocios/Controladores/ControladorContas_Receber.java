package Negocios.Controladores;

import Dados.BancoContaReceber;
import Dados.IBancoContaReceber;
import Negocios.Financeiro;
import java.util.ArrayList;

public class ControladorContas_Receber implements IControladorContas_Receber {

    @Override
    public void deletarContasReceberJDBC(Financeiro contas_Receber) {
        IBancoContaReceber bancoContaReceber = BancoContaReceber.getInstancia();
        bancoContaReceber.deletarContasReceberJDBC(contas_Receber);
    }

    @Override
    public void incluirContas_ReceberJDBC(Financeiro contas_Receber) {
        IBancoContaReceber bancoContaReceber = BancoContaReceber.getInstancia();
        bancoContaReceber.incluirContas_ReceberJDBC(contas_Receber);
    }

    @Override
    public void editarContas_ReceberJDBC(Financeiro contas_Receber) {
        IBancoContaReceber bancoContaReceber = BancoContaReceber.getInstancia();
        bancoContaReceber.editarContas_ReceberJDBC(contas_Receber);
    }

    @Override
    public ArrayList consultarContaReceberQuery(String query) {
        IBancoContaReceber bancoContaReceber = BancoContaReceber.getInstancia();
        return bancoContaReceber.consultarContaReceberQuery(query);
    }

    @Override
    public void exclusaoLogicaContasReceberJDBC(Financeiro contas_Receber) {
        IBancoContaReceber bancoContaReceber = BancoContaReceber.getInstancia();
        bancoContaReceber.exclusaoLogicaContasReceberJDBC(contas_Receber);
    }

    @Override
    public Financeiro consultarContaReceber(int id) {
        IBancoContaReceber bancoContaReceber = BancoContaReceber.getInstancia();
        return bancoContaReceber.consultarContaReceber(id);
    }
}
