/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.cliente.dados;

import Dados.ConectaBD;
import Negocios.ClienteVasilhame;
import Negocios.ClienteVasilhameDetalhe;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Heleno
 */
public class ConectaBDClienteVasilhameDetalhe implements IBancoClienteVasilhameDetalhe {

    private final ConectaBD bd = new ConectaBD();
    private String consultaSQL;
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;

    public static ConectaBDClienteVasilhameDetalhe getInstance() {
        return ConectaBDClienteVasilhameDetalheHolder.INSTANCE;
    }

    @Override
    public void incluirClienteVasilhameDetalhe(ClienteVasilhameDetalhe clienteVasilhameDetalhe) throws SQLException {
        consultaSQL
                = "insert into cliente_vasilhame_detalhe (id_cliente_vasilhame, data_hora_transacao, quantidade_devolvida) "
                + "values (?,?,?)";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, clienteVasilhameDetalhe.getId_cliente_vasilhame());
            pstm.setTimestamp(2, new Timestamp(clienteVasilhameDetalhe.getData_hora_transacao().getTime()));
            pstm.setBigDecimal(3, clienteVasilhameDetalhe.getQuantidade_devolvida());
            pstm.executeUpdate();

            ResultSet rs2 = pstm.getGeneratedKeys();
            if (rs2.next()) {
                clienteVasilhameDetalhe.setId(rs2.getInt(1));
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void editaClienteVasilhameDetalhe(ClienteVasilhameDetalhe clienteVasilhameDetalhe) throws SQLException {
        consultaSQL
                = "update cliente_vasilhame_detalhe set id_cliente_vasilhame = ?, data_hora_transacao = ?, quantidade_devolvida = ? where id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, clienteVasilhameDetalhe.getId_cliente_vasilhame());
            pstm.setTimestamp(2, new Timestamp(clienteVasilhameDetalhe.getData_hora_transacao().getTime()));
            pstm.setBigDecimal(3, clienteVasilhameDetalhe.getQuantidade_devolvida());
            pstm.setInt(4, clienteVasilhameDetalhe.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList<ClienteVasilhameDetalhe> consultarClienteVasilhameDetalhe(String query) throws SQLException {
        try {
            ArrayList<ClienteVasilhameDetalhe> lista = new ArrayList<>();
            consultaSQL = query;
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            ClienteVasilhameDetalhe clienteVasilhameDetalhe;
            while (rs.next()) {
                clienteVasilhameDetalhe = new ClienteVasilhameDetalhe();
                clienteVasilhameDetalhe.setData_hora_transacao(rs.getDate("data_hora_transacao"));
                clienteVasilhameDetalhe.setId(rs.getInt("id"));
                clienteVasilhameDetalhe.setId_cliente_vasilhame(rs.getInt("id_cliente_vasilhame"));
                clienteVasilhameDetalhe.setQuantidade_devolvida(rs.getBigDecimal("quantidade_devolvida"));
                lista.add(clienteVasilhameDetalhe);
            }
            return lista;
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            rs.close();
            pstm.close();
        }
    }

    @Override
    public BigDecimal consultarTotalDevolvidoClienteVasilhameDetalhe(int id_cliente_vasilhame) throws SQLException {
        try {
            BigDecimal qtdDevolvida = BigDecimal.ZERO;
            consultaSQL = "select IFNULL(sum(cvd.quantidade_devolvida), 0) from cliente_vasilhame_detalhe cvd where cvd.id_cliente_vasilhame = " + id_cliente_vasilhame;
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            if (rs.next()) {
                qtdDevolvida = rs.getBigDecimal(1);
            }
            return qtdDevolvida;
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            rs.close();
            pstm.close();
        }
    }

    @Override
    public void excluirClienteVasilhameDetalheUnico(ClienteVasilhameDetalhe clienteVasilhameDetalhe) throws SQLException {
        consultaSQL = "delete from cliente_vasilhame_detalhe where id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, clienteVasilhameDetalhe.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluirClienteVasilhameDetalheVinculoCabecalho(ClienteVasilhame clienteVasilhame) throws SQLException {
        consultaSQL
                = "delete from cliente_vasilhame_detalhe where id_cliente_vasilhame = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, clienteVasilhame.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static class ConectaBDClienteVasilhameDetalheHolder {

        private static final ConectaBDClienteVasilhameDetalhe INSTANCE = new ConectaBDClienteVasilhameDetalhe();
    }
}
