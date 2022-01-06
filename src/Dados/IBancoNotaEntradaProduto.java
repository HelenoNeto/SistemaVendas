/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.NotaEntradaProduto;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public interface IBancoNotaEntradaProduto {

    public void incluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_fiscalProduto);

    public ArrayList consultarNotaFiscalProdutoJDBC(int id_nota_fiscal);

    public void excluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_fiscalProduto);

    public ArrayList consultarNotaFiscalProdutoQueryJDBC(String query);
}
