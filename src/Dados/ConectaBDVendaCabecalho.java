/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Cliente;
import Negocios.Financeiro;
import Negocios.Fachada;
import Negocios.Funcionario;
import Negocios.TipoPagamento;
import Negocios.VendaCabecalho;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.gas.cliente.dados.ConectaBDCliente;

/**
 *
 * @author Neto
 */
public class ConectaBDVendaCabecalho {

    private final ConectaBD bd = new ConectaBD();
    private String consultaSQL;
    private PreparedStatement pstm;
    private ResultSet rs;

    public VendaCabecalho incluirVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        try {
            consultaSQL = "insert into venda_cabecalho (tipo_pagamento_id, funcionario_id, cliente_id, data_venda, tipo_desconto, desconto,"
                    + "tipo_acrescimo, acrescimo, subtotal, total, excluido, id_usuario_insercao, id_contas_receber, obs) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, vendaCabecalho.getTipoPagamento().getId());
            pstm.setInt(2, vendaCabecalho.getVendedor().getId());
            pstm.setInt(3, vendaCabecalho.getCliente().getId());
            pstm.setTimestamp(4, new Timestamp(vendaCabecalho.getData_hora_venda().getTime()));
            pstm.setString(5, vendaCabecalho.getTipo_desconto());
            pstm.setBigDecimal(6, vendaCabecalho.getDesconto());
            pstm.setString(7, vendaCabecalho.getTipo_acrescimo());
            pstm.setBigDecimal(8, vendaCabecalho.getAcrescimo());
            pstm.setBigDecimal(9, vendaCabecalho.getSubtotal());
            pstm.setBigDecimal(10, vendaCabecalho.getTotal());
            pstm.setBoolean(11, vendaCabecalho.isExcluido());
            pstm.setInt(12, vendaCabecalho.getId_usuario_insercao());
            if (vendaCabecalho.getContas_Receber() != null) {
                pstm.setInt(13, vendaCabecalho.getContas_Receber().getId());
            } else {
                pstm.setNull(13, java.sql.Types.INTEGER);
            }
            pstm.setString(14, vendaCabecalho.getObs());
            pstm.executeUpdate();
            ResultSet rs2 = pstm.getGeneratedKeys();
            if (rs2.next()) {
                vendaCabecalho.setId(rs2.getInt(1));
            }
            return vendaCabecalho;
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            pstm.close();
        }
    }

    public void editarVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        consultaSQL
                = "UPDATE venda_cabecalho SET tipo_pagamento_id = ?,  funcionario_id = ?,  "
                + "cliente_id = ?,  data_venda = ?,  tipo_desconto = ?,  desconto = ?, "
                + "tipo_acrescimo = ?,  acrescimo = ?,  subtotal = ?,  total = ?, "
                + "data_edicao = ?, id_usuario_edicao = ?, id_contas_receber = ?, obs = ?  "
                + "WHERE id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, vendaCabecalho.getTipoPagamento().getId());
            pstm.setInt(2, vendaCabecalho.getVendedor().getId());
            pstm.setInt(3, vendaCabecalho.getCliente().getId());
            pstm.setTimestamp(4, new Timestamp(vendaCabecalho.getData_hora_venda().getTime()));
            pstm.setString(5, vendaCabecalho.getTipo_desconto());
            pstm.setBigDecimal(6, vendaCabecalho.getDesconto());
            pstm.setString(7, vendaCabecalho.getTipo_acrescimo());
            pstm.setBigDecimal(8, vendaCabecalho.getAcrescimo());
            pstm.setBigDecimal(9, vendaCabecalho.getSubtotal());
            pstm.setBigDecimal(10, vendaCabecalho.getTotal());
            pstm.setDate(11, new Date(vendaCabecalho.getData_edicao().getTime()));
            pstm.setInt(12, vendaCabecalho.getId_usuario_edicao());
            if (vendaCabecalho.getContas_Receber() != null) {
                pstm.setInt(13, vendaCabecalho.getContas_Receber().getId());
            } else {
                pstm.setNull(13, java.sql.Types.INTEGER);
            }
            pstm.setString(14, vendaCabecalho.getObs());
            pstm.setInt(15, vendaCabecalho.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList consultarVendaCabecalho(String query) throws SQLException {
        ArrayList lista = new ArrayList();
        VendaCabecalho vendaCabecalho;
        consultaSQL = query;
        pstm = bd.getConectacao().prepareStatement(consultaSQL);
        rs = pstm.executeQuery();
        while (rs.next()) {
            ArrayList<TipoPagamento> listaTipoPagamento = Fachada.getInstancia().consultarTipoPagamento("select * from tipo_pagamento where id = " + rs.getInt("tipo_pagamento_id"));
            ArrayList<Funcionario> listaFuncionario = Fachada.getInstancia().consultarFuncionario("select * from funcionario where id = " + rs.getInt("funcionario_id"));
            ArrayList<Cliente> listaCliente = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where id = " + rs.getInt("cliente_id"));
            Financeiro financeiro = Fachada.getInstancia().consultarContaReceber(rs.getInt("id_contas_receber"));
            vendaCabecalho = new VendaCabecalho(listaTipoPagamento.isEmpty() ? null : listaTipoPagamento.get(0),
                    listaFuncionario.isEmpty() ? null : listaFuncionario.get(0), listaCliente.isEmpty() ? null : listaCliente.get(0),
                    financeiro == null ? null : financeiro, rs.getTimestamp("data_venda"), rs.getString("tipo_desconto"),
                    rs.getBigDecimal("desconto"), rs.getString("tipo_acrescimo"), rs.getBigDecimal("acrescimo"), rs.getBigDecimal("subtotal"),
                    rs.getBigDecimal("total"), rs.getBoolean("excluido"), rs.getInt("id_usuario_insercao"));
            vendaCabecalho.setListaDetalhe(Fachada.getInstancia().consultarVendaDetalhe("select * from venda_detalhe where venda_cabecalho_id = " + rs.getInt("id")));
            vendaCabecalho.setObs(rs.getString("obs"));
            vendaCabecalho.setId(rs.getInt("id"));
            lista.add(vendaCabecalho);
        }
        rs.close();
        pstm.close();
        return lista;
    }

    public void excluirVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        consultaSQL
                = "delete from venda_cabecalho where id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, vendaCabecalho.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exclusaoLogicaVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        consultaSQL
                = "update venda_cabecalho set excluido = ?, data_exclusao = ?, id_usuario_exclusao = ? where id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setBoolean(1, vendaCabecalho.isExcluido());
            pstm.setDate(2, new Date(vendaCabecalho.getData_exclusao().getTime()));
            pstm.setInt(3, vendaCabecalho.getId_usuario_exclusao());
            pstm.setInt(4, vendaCabecalho.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

}
