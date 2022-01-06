/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.FinanceiroParcelas;
import Negocios.FinanceiroRecPag;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public interface IBancoParcelasReceberHistoricoRecebimento {

    public int retornarAutoIncrementHistoricoRecebimentoParcelasReceber();

    public void incluirHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento);

    public ArrayList consultarHistoricoRecebimentoParcelasReceberJDBC(String query);

    public void atualizarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento);
    
    public void deletarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroParcelas parcelas_receber);
}
