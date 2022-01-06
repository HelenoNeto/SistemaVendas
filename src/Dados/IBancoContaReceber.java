package Dados;

import Negocios.Financeiro;
import java.util.ArrayList;

public interface IBancoContaReceber {

    public void deletarContasReceberJDBC(Financeiro contas_Receber);

    public void incluirContas_ReceberJDBC(Financeiro contas_Receber);

    public void editarContas_ReceberJDBC(Financeiro contas_Receber);

    public ArrayList consultarContaReceberQuery(String query);

    public void exclusaoLogicaContasReceberJDBC(Financeiro contas_Receber);

    public Financeiro consultarContaReceber(int id);
}
