package Dados;

import Negocios.Financeiro;
import Negocios.FinanceiroParcelas;
import java.util.ArrayList;

public interface IBancoParcelasReceber {

    public void deletarParcelasReceberJDBC(FinanceiroParcelas parcelas_receber);

    public double somaValorParcelas(int id_contas);

    public ArrayList consultarParcelasReceberQuery(String query);

    public void incluirParcelas_receberJDBC(FinanceiroParcelas parcelas_receber);

    public void editarParcelas_receberJDBC(FinanceiroParcelas parcelas_receber);

    public ArrayList consultarParcelasReceber(Financeiro financeiro);
}
