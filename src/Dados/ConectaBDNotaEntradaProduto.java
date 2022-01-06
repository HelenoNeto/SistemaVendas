/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.NotaEntradaProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ConectaBDNotaEntradaProduto {

    private final ConectaBD bd = new ConectaBD();

    public void incluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_entrada_produto) throws SQLException {
        String consultaSQL
                = "insert into nota_entrada_produto (descricao_produto, id_nota_entrada, id_produto, preco_uni, "
                + "quantidade, total) values (?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, nota_entrada_produto.getDescricao_produto());
            pstm.setInt(2, nota_entrada_produto.getId_nota_entrada());
            pstm.setInt(3, nota_entrada_produto.getId_produto());
            pstm.setBigDecimal(4, nota_entrada_produto.getPreco_uni());
            pstm.setBigDecimal(5, nota_entrada_produto.getQuantidade());
            pstm.setBigDecimal(6, nota_entrada_produto.getValor());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                nota_entrada_produto.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList consultarNotaFiscalProdutoJDBC(int id_nota_fiscal) {
        ArrayList lista = new ArrayList();
        NotaEntradaProduto nota_entrada_produto;
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement("SELECT * FROM nota_entrada_produto WHERE id_nota_entrada =" + id_nota_fiscal);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                nota_entrada_produto = new NotaEntradaProduto();
                nota_entrada_produto.setDescricao_produto(rs.getString("DESCRICAO_PRODUTO"));
                nota_entrada_produto.setId_nota_entrada(rs.getInt("id_nota_entrada"));
                nota_entrada_produto.setId_produto(rs.getInt("ID_PRODUTO"));
                nota_entrada_produto.setPreco_uni(rs.getBigDecimal("preco_uni"));
                nota_entrada_produto.setQuantidade(rs.getBigDecimal("quantidade"));
                nota_entrada_produto.setValor(rs.getBigDecimal("total"));
                nota_entrada_produto.setId(rs.getInt("id"));
                lista.add(nota_entrada_produto);
            }
            pstm.close();
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }

    public ArrayList consultarNotaFiscalProdutoQueryJDBC(String query) {
        ArrayList lista = new ArrayList();
        NotaEntradaProduto nota_entrada_produto;
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                nota_entrada_produto = new NotaEntradaProduto();
                nota_entrada_produto.setDescricao_produto(rs.getString("DESCRICAO_PRODUTO"));
                nota_entrada_produto.setId_nota_entrada(rs.getInt("id_nota_entrada"));
                nota_entrada_produto.setId_produto(rs.getInt("ID_PRODUTO"));
                nota_entrada_produto.setPreco_uni(rs.getBigDecimal("preco_uni"));
                nota_entrada_produto.setQuantidade(rs.getBigDecimal("quantidade"));
                nota_entrada_produto.setValor(rs.getBigDecimal("valor"));
                nota_entrada_produto.setId(rs.getInt("id"));
                lista.add(nota_entrada_produto);
            }
            pstm.close();
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }

    public void excluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_entrada_produto) throws SQLException {
        String consultaSQL = "delete from nota_entrada_produto where id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, nota_entrada_produto.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
