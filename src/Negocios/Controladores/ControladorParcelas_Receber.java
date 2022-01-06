package Negocios.Controladores;

import Dados.BancoParcelasReceber;
import Dados.IBancoParcelasReceber;
import Negocios.Financeiro;
import Negocios.FinanceiroParcelas;
import java.util.ArrayList;

public class ControladorParcelas_Receber implements IControladorParcelas_Receber {

    @Override
    public void deletarParcelasReceberJDBC(FinanceiroParcelas parcelas_receber) {
        IBancoParcelasReceber ibpr = BancoParcelasReceber.getInstancia();
        ibpr.deletarParcelasReceberJDBC(parcelas_receber);
    }

    @Override
    public double somaValorParcelas(int id_contas) {
        IBancoParcelasReceber bancoParcelasReceber = BancoParcelasReceber.getInstancia();
        return bancoParcelasReceber.somaValorParcelas(id_contas);
    }

    @Override
    public void incluirParcelas_receberJDBC(FinanceiroParcelas parcelas_receber) {
        IBancoParcelasReceber bancoParcelasReceber = BancoParcelasReceber.getInstancia();
        bancoParcelasReceber.incluirParcelas_receberJDBC(parcelas_receber);
    }

    @Override
    public void editarParcelas_receberJDBC(FinanceiroParcelas parcelas_receber) {
        IBancoParcelasReceber bancoParcelasReceber = BancoParcelasReceber.getInstancia();
        bancoParcelasReceber.editarParcelas_receberJDBC(parcelas_receber);
    }

    @Override
    public ArrayList consultarParcelasReceberQuery(String query) {
        IBancoParcelasReceber bancoParcelasReceber = BancoParcelasReceber.getInstancia();
        return bancoParcelasReceber.consultarParcelasReceberQuery(query);
    }

    @Override
    public ArrayList consultarParcelasReceber(Financeiro financeiro) {
        IBancoParcelasReceber bancoParcelasReceber = BancoParcelasReceber.getInstancia();
        return bancoParcelasReceber.consultarParcelasReceber(financeiro);
    }
}
