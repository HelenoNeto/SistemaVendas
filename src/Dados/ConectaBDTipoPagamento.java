/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.TipoPagamento;
import java.sql.Date;
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
public class ConectaBDTipoPagamento {

    private final ConectaBD bd = new ConectaBD();

    public void incluirTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        try {
            String consultaSQL = "insert into tipo_pagamento (descricao, tipo_vinculo, data_insercao, id_usuario_insercao, excluido) "
                    + "values (?,?,?,?,?)";
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, tipoPagamento.getDescricao());
            pstm.setString(2, tipoPagamento.getTipo_vinculo());
            pstm.setDate(3, new Date(tipoPagamento.getData_insercao().getTime()));
            pstm.setInt(4, tipoPagamento.getId_usuario_insercao());
            pstm.setBoolean(5, tipoPagamento.isExcluido());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                tipoPagamento.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList consultarTipoPagamento(String query) throws SQLException {
        ArrayList lista = new ArrayList();
        TipoPagamento tipoPagamento;
        PreparedStatement pstm = bd.getConectacao().prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            tipoPagamento = new TipoPagamento();
            tipoPagamento.setDescricao(rs.getString("descricao"));
            tipoPagamento.setId(rs.getInt("id"));
            tipoPagamento.setTipo_vinculo(rs.getString("tipo_vinculo"));
            tipoPagamento.setExcluido(rs.getBoolean("excluido"));
            lista.add(tipoPagamento);
        }
        rs.close();
        pstm.close();
        return lista;
    }

    public TipoPagamento consultarTipoPagamento(int id_tipo_pagamento) throws SQLException {
        TipoPagamento tipoPagamento = null;
        PreparedStatement pstm = bd.getConectacao().prepareStatement("SELECT * FROM tipo_pagamento WHERE id = " + id_tipo_pagamento);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            tipoPagamento = new TipoPagamento();
            tipoPagamento.setDescricao(rs.getString("descricao"));
            tipoPagamento.setId(rs.getInt("id"));
            tipoPagamento.setTipo_vinculo(rs.getString("tipo_vinculo"));
            tipoPagamento.setExcluido(rs.getBoolean("excluido"));
        }
        rs.close();
        pstm.close();
        return tipoPagamento;
    }

    public void deletarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        String consultaSQL = "update tipo_pagamento set excluido = ?, data_exclusao = ?, id_usuario_exclusao = ? WHERE id = ?";
        PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
        pstm.setBoolean(1, true);
        pstm.setDate(2, new Date(tipoPagamento.getData_exclusao().getTime()));
        pstm.setInt(3, tipoPagamento.getId_usuario_exclusao());
        pstm.setInt(4, tipoPagamento.getId());
        pstm.executeUpdate();
        pstm.close();
    }

    public void editarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        String consultaSQL
                = "UPDATE tipo_pagamento SET descricao = ?, tipo_vinculo = ?, "
                + "data_edicao = ?, id_usuario_edicao = ? WHERE id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, tipoPagamento.getDescricao());
            pstm.setString(2, tipoPagamento.getTipo_vinculo());
            pstm.setDate(3, new Date(tipoPagamento.getData_edicao().getTime()));
            pstm.setInt(4, tipoPagamento.getId_usuario_edicao());
            pstm.setInt(5, tipoPagamento.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
