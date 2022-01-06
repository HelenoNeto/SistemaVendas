/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.NotaEntrada;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class BancoNotaEntrada implements IBancoNotaEntrada {

    private static BancoNotaEntrada instancia = null;

    public static BancoNotaEntrada getInstancia() {
        if (instancia == null) {
            instancia = new BancoNotaEntrada();
        }
        return instancia;
    }

    @Override
    public void incluirNotaFiscalJDBC(NotaEntrada nota_fiscal) {
        try {
            ConectaBDNotaEntrada bDNotaEntrada = new ConectaBDNotaEntrada();
            bDNotaEntrada.incluirNotaFiscalJDBC(nota_fiscal);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList<NotaEntrada> consultarNotaFiscalJDBC(String tipo, String dado) {
        ConectaBDNotaEntrada bDNotaEntrada = new ConectaBDNotaEntrada();
        return bDNotaEntrada.consultarNotaFiscalJDBC(tipo, dado);
    }

    @Override
    public ArrayList<NotaEntrada> consultarNotaFiscalQueryJDBC(String query) {
        ConectaBDNotaEntrada bDNotaEntrada = new ConectaBDNotaEntrada();
        return bDNotaEntrada.consultarNotaFiscalQueryJDBC(query);
    }

    @Override
    public void editaNotaFiscalJDBC(NotaEntrada nota_fiscal) {
        try {
            ConectaBDNotaEntrada bDNotaEntrada = new ConectaBDNotaEntrada();
            bDNotaEntrada.editaNotaFiscalJDBC(nota_fiscal);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluirNotaFiscalJDBC(NotaEntrada nota_fiscal) {
        try {
            ConectaBDNotaEntrada bDNotaEntrada = new ConectaBDNotaEntrada();
            bDNotaEntrada.excluirNotaFiscalJDBC(nota_fiscal);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
