/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.NotaEntradaProduto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class BancoNotaEntradaProduto implements IBancoNotaEntradaProduto {

    private static BancoNotaEntradaProduto instancia = null;

    public static BancoNotaEntradaProduto getInstancia() {
        if (instancia == null) {
            instancia = new BancoNotaEntradaProduto();
        }
        return instancia;
    }

    @Override
    public void incluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_fiscalProduto) {
        try {
            ConectaBDNotaEntradaProduto bDNotaEntradaProduto = new ConectaBDNotaEntradaProduto();
            bDNotaEntradaProduto.incluirNotaFiscalProdutoJDBC(nota_fiscalProduto);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList consultarNotaFiscalProdutoJDBC(int id_nota_fiscal) {
        try {
            ConectaBDNotaEntradaProduto bDNotaEntradaProduto = new ConectaBDNotaEntradaProduto();
            return bDNotaEntradaProduto.consultarNotaFiscalProdutoJDBC(id_nota_fiscal);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void excluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_fiscalProduto) {
        try {
            ConectaBDNotaEntradaProduto bDNotaEntradaProduto = new ConectaBDNotaEntradaProduto();
            bDNotaEntradaProduto.excluirNotaFiscalProdutoJDBC(nota_fiscalProduto);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList consultarNotaFiscalProdutoQueryJDBC(String query) {
        try {
            ConectaBDNotaEntradaProduto bDNotaEntradaProduto = new ConectaBDNotaEntradaProduto();
            return bDNotaEntradaProduto.consultarNotaFiscalProdutoQueryJDBC(query);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
