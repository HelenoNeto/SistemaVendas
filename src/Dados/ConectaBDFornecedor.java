/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Fornecedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ConectaBDFornecedor {

    private final ConectaBD bd = new ConectaBD();

    public Fornecedor incluirFornecedor(Fornecedor fornecedor) throws SQLException {
        String consultaSQL
                = "insert into FORNECEDOR (RAZAO_SOCIAL, EXCLUIDO) values (?,?)";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, fornecedor.getRazao_social());
            pstm.setBoolean(2, fornecedor.isExcluido());
            pstm.execute();
            ResultSet rs2 = pstm.getGeneratedKeys();
            if (rs2.next()) {
                fornecedor.setId(rs2.getInt(1));
                return fornecedor;
            } else {
                return null;
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void editarFornecedor(Fornecedor fornecedor) throws SQLException {
        String consultaSQL
                = "update grupo set "
                + "RAZAO_SOCIAL=?, EXCLUIDO = ? where id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, fornecedor.getRazao_social());
            pstm.setBoolean(2, fornecedor.isExcluido());
            pstm.setInt(3, fornecedor.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Fornecedor consultarFornecedor(int id) throws SQLException {
        Fornecedor fornecedor = null;
        String consultaSQL = "SELECT ID, RAZAO_SOCIAL, EXCLUIDO FROM FORNECEDOR WHERE ID = " + id;
        try {
            Statement stm = bd.getConectacao().createStatement();
            ResultSet rs = stm.executeQuery(consultaSQL);
            if (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt(1));
                fornecedor.setRazao_social(rs.getString(2));
                fornecedor.setExcluido(rs.getBoolean(3));
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return fornecedor;
    }

    public ArrayList<Fornecedor> consultarFornecedor(String coluna, String dado) throws SQLException {
        ArrayList<Fornecedor> lista = new ArrayList<>();
        Fornecedor fornecedor;
        String consultaSQL = "SELECT ID, RAZAO_SOCIAL, EXCLUIDO FROM FORNECEDOR WHERE " + coluna + " LIKE '" + dado + "'";
        try {
            Statement stm = bd.getConectacao().createStatement();
            ResultSet rs = stm.executeQuery(consultaSQL);
            while (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt(1));
                fornecedor.setRazao_social(rs.getString(2));
                fornecedor.setExcluido(rs.getBoolean(3));
                lista.add(fornecedor);
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }

    public void excluirFornecedor(Fornecedor fornecedor) throws SQLException {
        String consultaSQL
                = "DELETE FROM GRUPO WHERE ID = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, fornecedor.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

}
