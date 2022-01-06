/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Empresa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class BancoEmpresa implements IBancoEmpresa {

    private static BancoEmpresa instancia = null;

    public static BancoEmpresa getInstancia() {
        if (instancia == null) {
            instancia = new BancoEmpresa();
        }
        return instancia;
    }

    @Override
    public void incluirEmpresa(Empresa emitentes) {
        try {
            ConectaBDEmpresa conexao = new ConectaBDEmpresa();
            conexao.incluirEmpresa(emitentes);
        } catch (SQLException ex) {
            Logger.getLogger(BancoEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Empresa consultarEmpresa(String query) {
        try {
            ConectaBDEmpresa conexao = new ConectaBDEmpresa();
            return conexao.consultarEmpresa(query);
        } catch (SQLException ex) {
            Logger.getLogger(BancoEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void atualizarEmpresa(Empresa emitentes) {
        try {
            ConectaBDEmpresa conexao = new ConectaBDEmpresa();
            conexao.atualizarEmitentesJDBC(emitentes);
        } catch (SQLException ex) {
            Logger.getLogger(BancoEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
