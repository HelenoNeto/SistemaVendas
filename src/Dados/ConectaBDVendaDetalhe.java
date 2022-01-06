/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Produto;
import Negocios.VendaCabecalho;
import Negocios.VendaDetalhe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Neto
 */
public class ConectaBDVendaDetalhe {

    private final ConectaBD bd = new ConectaBD();

    public void incluirVendaDetalhe(VendaDetalhe vendaDetalhe) throws SQLException {
        PreparedStatement pstm = null;
        try {
            String consultaSQL = "REPLACE venda_detalhe SET "
                    + "id=?, "
                    + "produto_id=?, "
                    + "venda_cabecalho_id=?, "
                    + "codigo_produto=?,"
                    + "descricao_produto=?,"
                    + "unidade_produto=?,"
                    + "valor_unitario_compra=?,"
                    + "quantidade=?, "
                    + "valor_unitario=?, "
                    + "valor_total=?,"
                    + "vasilhame_pendente=?, "
                    + "qtd_vasilhame_pendente=?";
            pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, vendaDetalhe.getId());
            pstm.setInt(2, vendaDetalhe.getProduto().getId());
            pstm.setInt(3, vendaDetalhe.getId_venda_cabecalho());
            pstm.setString(4, vendaDetalhe.getCodigoProduto());
            pstm.setString(5, vendaDetalhe.getDescricaoProduto());
            pstm.setString(6, vendaDetalhe.getUnidadeProduto());
            pstm.setBigDecimal(7, vendaDetalhe.getValorUniCompra());
            pstm.setBigDecimal(8, vendaDetalhe.getQuantidade());
            pstm.setBigDecimal(9, vendaDetalhe.getValor_unitario());
            pstm.setBigDecimal(10, vendaDetalhe.getValor_total());
            pstm.setBoolean(11, vendaDetalhe.isVasilhame_pendente());
            pstm.setBigDecimal(12, vendaDetalhe.getQtd_vasilhame_pendente());
            pstm.executeUpdate();

            ResultSet rs2 = pstm.getGeneratedKeys();
            if (rs2.next()) {
                vendaDetalhe.setId(rs2.getInt(1));
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        } finally {
            pstm.close();
        }
    }

    public void incluirListaVendaDetalhe(ArrayList<VendaDetalhe> listaVendaDetalhe) throws SQLException {
        try {
            for (VendaDetalhe vendaDetalhe : listaVendaDetalhe) {
                incluirVendaDetalhe(vendaDetalhe);
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList consultarVendaDetalhe(String query) throws SQLException {
        ArrayList lista = new ArrayList();
        VendaDetalhe vendaDetalhe;
        PreparedStatement pstm = bd.getConectacao().prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Produto produto = ConectaBDProduto.getInstance().consultarProduto_porId(rs.getInt("produto_id"));
            vendaDetalhe = new VendaDetalhe(
                    rs.getInt("venda_cabecalho_id"),
                    produto,
                    rs.getString("codigo_produto"),
                    rs.getString("descricao_produto"),
                    rs.getString("unidade_produto"),
                    rs.getBigDecimal("quantidade"),
                    rs.getBigDecimal("valor_unitario_compra"),
                    rs.getBigDecimal("valor_unitario"),
                    rs.getBigDecimal("valor_total"),
                    rs.getBoolean("vasilhame_pendente"),
                    rs.getBigDecimal("qtd_vasilhame_pendente"));
            vendaDetalhe.setId(rs.getInt("id"));
            lista.add(vendaDetalhe);
        }
        rs.close();
        pstm.close();
        return lista;
    }

    public VendaDetalhe consultarVendaDetalhe_porIdVendaDetalhe(int id_venda_detalhe) throws SQLException {
        try {
            VendaDetalhe vendaDetalhe = null;
            String consultaSQL = "select * from venda_detalhe where id = " + id_venda_detalhe;
            try (PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL)) {
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    Produto produto = ConectaBDProduto.getInstance().consultarProduto_porId(rs.getInt("produto_id"));
                    vendaDetalhe = new VendaDetalhe(
                            rs.getInt("venda_cabecalho_id"),
                            produto,
                            rs.getString("codigo_produto"),
                            rs.getString("descricao_produto"),
                            rs.getString("unidade_produto"),
                            rs.getBigDecimal("quantidade"),
                            rs.getBigDecimal("valor_unitario_compra"),
                            rs.getBigDecimal("valor_unitario"),
                            rs.getBigDecimal("valor_total"),
                            rs.getBoolean("vasilhame_pendente"),
                            rs.getBigDecimal("qtd_vasilhame_pendente"));
                    vendaDetalhe.setId(rs.getInt("id"));
                }
                rs.close();
            }
            return vendaDetalhe;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void excluirVendaDetalhe(VendaCabecalho vendaCabecalho) throws SQLException {
        String consultaSQL = "delete from venda_detalhe where venda_cabecalho_id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, vendaCabecalho.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

}
