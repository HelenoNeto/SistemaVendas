/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Fachada;
import Negocios.NotaEntrada;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ConectaBDNotaEntrada {

    private final ConectaBD bd = new ConectaBD();

    public void incluirNotaFiscalJDBC(NotaEntrada nota_fiscal) throws SQLException {
        String consultaSQL = "insert into nota_entrada (codigo, data_emissao, data_entrada, id_fornecedor, total) values (?,?,?,?,?)";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, nota_fiscal.getCodigo());
            pstm.setDate(2, new Date(nota_fiscal.getData_emissao().getTime()));
            pstm.setDate(3, new Date(nota_fiscal.getData_entrada().getTime()));
            pstm.setInt(4, nota_fiscal.getFornecedor().getId());
            pstm.setBigDecimal(5, nota_fiscal.getTotal());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                nota_fiscal.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<NotaEntrada> consultarNotaFiscalJDBC(String tipo, String dado) {
        tipo = tipo.toUpperCase();
        ArrayList lista = new ArrayList();
        NotaEntrada nota_fiscal;
        String consultaSQL;
        try {
            if (dado.equals("%") || dado.equals("")) {
                consultaSQL = "SELECT * FROM nota_entrada ORDER BY " + tipo;
            } else if (tipo.equals("id")) {
                consultaSQL = "SELECT * FROM nota_entrada WHERE id = " + dado + " ORDER BY id ";
            } else {
                consultaSQL = "SELECT * FROM nota_entrada WHERE " + tipo + " LIKE '" + dado + "%' OR " + tipo + " LIKE '% " + dado + "%' ORDER BY " + tipo;
            }
            try (PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL)) {
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    nota_fiscal = new NotaEntrada();
                    nota_fiscal.setCodigo(rs.getString("codigo"));
                    nota_fiscal.setData_emissao(rs.getDate("data_emissao"));
                    nota_fiscal.setData_entrada(rs.getDate("data_entrada"));
                    nota_fiscal.setFornecedor(Fachada.getInstancia().consultarFornecedor(rs.getInt("id_fornecedor")));
                    nota_fiscal.setTotal(rs.getBigDecimal("total"));
                    nota_fiscal.setId(rs.getInt("id"));
                    lista.add(nota_fiscal);
                }
            }
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList<NotaEntrada> consultarNotaFiscalQueryJDBC(String query) {

        ArrayList lista = new ArrayList();
        NotaEntrada nota_fiscal;
        try {
            try (PreparedStatement pstm = bd.getConectacao().prepareStatement(query)) {
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    nota_fiscal = new NotaEntrada();
                    nota_fiscal.setCodigo(rs.getString("codigo"));
                    nota_fiscal.setData_emissao(rs.getDate("data_emissao"));
                    nota_fiscal.setData_entrada(rs.getDate("data_entrada"));
                    nota_fiscal.setFornecedor(Fachada.getInstancia().consultarFornecedor(rs.getInt("id_fornecedor")));
                    nota_fiscal.setTotal(rs.getBigDecimal("total"));
                    nota_fiscal.setId(rs.getInt("id"));
                    lista.add(nota_fiscal);
                }
            }
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public void editaNotaFiscalJDBC(NotaEntrada nota_fiscal) throws SQLException {
        String consultaSQL = "UPDATE nota_entrada SET codigo = ?, data_emissao = ?, data_entrada = ?, id_fornecedor = ?, total = ? WHERE id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, nota_fiscal.getCodigo());
            pstm.setDate(2, new Date(nota_fiscal.getData_emissao().getTime()));
            pstm.setDate(3, new Date(nota_fiscal.getData_entrada().getTime()));
            pstm.setInt(4, nota_fiscal.getFornecedor().getId());
            pstm.setBigDecimal(5, nota_fiscal.getTotal());
            pstm.setInt(6, nota_fiscal.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluirNotaFiscalJDBC(NotaEntrada nota_fiscal) throws SQLException {
        String consultaSQL = "delete from nota_entrada where id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, nota_fiscal.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int retornoAutoIncrementNotaFiscalJDBC() throws SQLException {
        int autoIncrement;
        PreparedStatement st = bd.getConectacao().prepareStatement("SELECT Auto_increment FROM information_schema.tables WHERE table_name='nota_entrada' AND table_schema = DATABASE()");
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            autoIncrement = rs.getInt(1);
        } else {
            autoIncrement = 1;
        }
        return autoIncrement;
    }
}
