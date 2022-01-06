/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.cliente.dados;

import Dados.ConectaBD;
import Negocios.ClienteVasilhame;
import Negocios.ClienteVasilhameDetalhe;
import Negocios.VendaDetalhe;
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
public class ConectaBDClienteVasilhame implements IBancoClienteVasilhame {

    private final ConectaBD bd = new ConectaBD();
    private String consultaSQL;
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;

    public static ConectaBDClienteVasilhame getInstance() {
        return ConectaBDClienteVasilhameHolder.INSTANCE;
    }

    @Override
    public void incluirClienteVasilhame(ClienteVasilhame clienteVasilhame) throws SQLException {
        consultaSQL
                = "insert into cliente_vasilhame (id_venda_detalhe, id_produto_vasilhame, quantidade, data_hora_transacao, status) "
                + "values (?,?,?,?,?)";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, clienteVasilhame.getId_venda_detalhe());
            pstm.setInt(2, clienteVasilhame.getId_produto_vasilhame());
            pstm.setBigDecimal(3, clienteVasilhame.getQuantidade());
            pstm.setTimestamp(4, new Timestamp(clienteVasilhame.getData_hora_transacao().getTime()));
            pstm.setString(5, clienteVasilhame.getStatus());
            pstm.executeUpdate();

            ResultSet rs2 = pstm.getGeneratedKeys();
            if (rs2.next()) {
                clienteVasilhame.setId(rs2.getInt(1));
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void editaClienteVasilhame(ClienteVasilhame clienteVasilhame) throws SQLException {
        consultaSQL
                = "update cliente_vasilhame set id_venda_detalhe = ?, id_produto_vasilhame = ?, quantidade = ?, "
                + "data_hora_transacao = ?, status = ? where id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, clienteVasilhame.getId_venda_detalhe());
            pstm.setInt(2, clienteVasilhame.getId_produto_vasilhame());
            pstm.setBigDecimal(3, clienteVasilhame.getQuantidade());
            pstm.setTimestamp(4, new Timestamp(clienteVasilhame.getData_hora_transacao().getTime()));
            pstm.setString(5, clienteVasilhame.getStatus());
            pstm.setInt(6, clienteVasilhame.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ArrayList<ClienteVasilhame> consultarClienteVasilhame(String query) throws SQLException {
        try {
            ArrayList<ClienteVasilhame> lista = new ArrayList<>();
            consultaSQL = query;
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            ClienteVasilhame clienteVasilhame;
            while (rs.next()) {
                clienteVasilhame = new ClienteVasilhame();
                clienteVasilhame.setData_hora_transacao(rs.getTimestamp("data_hora_transacao"));
                clienteVasilhame.setId(rs.getInt("id"));
                clienteVasilhame.setId_venda_detalhe(rs.getInt("id_venda_detalhe"));
                clienteVasilhame.setId_produto_vasilhame(rs.getInt("id_produto_vasilhame"));
                clienteVasilhame.setQuantidade(rs.getBigDecimal("quantidade"));
                clienteVasilhame.setStatus(rs.getString("status"));
                ArrayList<ClienteVasilhameDetalhe> listaClienteVasilhameDetalhe = ConectaBDClienteVasilhameDetalhe.getInstance().consultarClienteVasilhameDetalhe("select * from cliente_vasilhame_detalhe where id_cliente_vasilhame = " + clienteVasilhame.getId());
                clienteVasilhame.setListaClienteVasilhameDetalhe(listaClienteVasilhameDetalhe);
                lista.add(clienteVasilhame);
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
    public void excluirClienteVasilhame(ClienteVasilhame clienteVasilhame) throws SQLException {
        consultaSQL
                = "delete from cliente_vasilhame where id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, clienteVasilhame.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluirClienteVasilhamePorVenda(VendaDetalhe vendaDetalhe) throws SQLException {
        consultaSQL
                = "delete from cliente_vasilhame where id_venda_detalhe = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, vendaDetalhe.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static class ConectaBDClienteVasilhameHolder {

        private static final ConectaBDClienteVasilhame INSTANCE = new ConectaBDClienteVasilhame();
    }
}
