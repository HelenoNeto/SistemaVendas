/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Grupo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class BancoGrupo implements IBancoGrupo {

    private static BancoGrupo instancia = null;

    public static BancoGrupo getInstancia() {
        if (instancia == null) {
            instancia = new BancoGrupo();
        }
        return instancia;
    }

    @Override
    public void incluirGrupo(Grupo grupo) {
        try {
            ConectaBDGrupo conectaBDGrupo = new ConectaBDGrupo();
            conectaBDGrupo.incluirGrupo(grupo);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void editarGrupo(Grupo grupo) {
        try {
            ConectaBDGrupo conectaBDGrupo = new ConectaBDGrupo();
            conectaBDGrupo.editarGrupo(grupo);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList consultarGrupo(String query) {
        try {
            ConectaBDGrupo conectaBDGrupo = new ConectaBDGrupo();
            return conectaBDGrupo.consultarGrupo(query);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void excluirGrupo(Grupo grupo) {
        try {
            ConectaBDGrupo conectaBDGrupo = new ConectaBDGrupo();
            conectaBDGrupo.excluirGrupo(grupo);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public int retornoAutoIncrementGrupo() {
        try {
            ConectaBDGrupo conectaBDGrupo = new ConectaBDGrupo();
            return conectaBDGrupo.retornoAutoIncrementGrupo();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    @Override
    public void alterarGrupoExclusao(Grupo grupo) {
        try {
            ConectaBDGrupo conectaBDGrupo = new ConectaBDGrupo();
            conectaBDGrupo.alterarGrupoExclusao(grupo);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
