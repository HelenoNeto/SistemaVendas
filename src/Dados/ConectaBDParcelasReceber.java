package Dados;

import Negocios.Fachada;
import Negocios.Financeiro;
import Negocios.FinanceiroParcelas;
import Negocios.FinanceiroRecPag;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectaBDParcelasReceber {

    private final ConectaBD bd = new ConectaBD();

    public ArrayList consultarParcelasReceberQuery(String query) {
        ArrayList lista = new ArrayList();
        FinanceiroParcelas parcelas_receber;
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                parcelas_receber = new FinanceiroParcelas();
                parcelas_receber.setData_pagamento(rs.getDate("data_pagamento"));
                parcelas_receber.setData_vencimento(rs.getDate("data_vencimento"));
                parcelas_receber.setFinanceiro(Fachada.getInstancia().consultarContaReceber(rs.getInt("id_contas_receber")));
                parcelas_receber.setLancamento(rs.getInt("lancamento"));
                parcelas_receber.setStatus(rs.getString("status"));
                parcelas_receber.setParcela(rs.getString("parcela"));
                parcelas_receber.setValor(rs.getBigDecimal("valor"));
                parcelas_receber.setValor_pago(rs.getBigDecimal("valor_pago"));
                parcelas_receber.setId(rs.getInt("id"));
                ArrayList<FinanceiroRecPag> listaRecebimento = Fachada.getInstancia().consultarHistoricoRecebimentoParcelasReceberJDBC("select * from parcelas_receber_historico_recebimento where id_parcelas_receber = " + parcelas_receber.getId());
                if (!listaRecebimento.isEmpty()) {
                    parcelas_receber.setListaRecebimento(listaRecebimento);
                }
                lista.add(parcelas_receber);
            }
            pstm.close();
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList consultarParcelasReceber(Financeiro financeiro) {
        ArrayList lista = new ArrayList();
        FinanceiroParcelas parcelas_receber;
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement("select * from parcelas_receber where id_contas_receber = " + financeiro.getId());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                parcelas_receber = new FinanceiroParcelas();
                parcelas_receber.setData_pagamento(rs.getDate("data_pagamento"));
                parcelas_receber.setData_vencimento(rs.getDate("data_vencimento"));
                parcelas_receber.setFinanceiro(financeiro);
                parcelas_receber.setLancamento(rs.getInt("lancamento"));
                parcelas_receber.setStatus(rs.getString("status"));
                parcelas_receber.setParcela(rs.getString("parcela"));
                parcelas_receber.setValor(rs.getBigDecimal("valor"));
                parcelas_receber.setValor_pago(rs.getBigDecimal("valor_pago"));
                parcelas_receber.setId(rs.getInt("id"));
                ArrayList<FinanceiroRecPag> listaRecebimento = Fachada.getInstancia().consultarHistoricoRecebimentoParcelasReceberJDBC("select * from parcelas_receber_historico_recebimento where id_parcelas_receber = " + parcelas_receber.getId());
                if (!listaRecebimento.isEmpty()) {
                    parcelas_receber.setListaRecebimento(listaRecebimento);
                }
                lista.add(parcelas_receber);
            }
            pstm.close();
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public void deletarParcelasReceberJDBC(FinanceiroParcelas parcelas_receber) {
        try {
            try (PreparedStatement pstm = bd.getConectacao().prepareStatement("DELETE FROM parcelas_receber WHERE id = ?")) {
                pstm.setInt(1, parcelas_receber.getId());
                pstm.execute();
            }
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double somaValorParcelas(int id_contas) throws SQLException {
        double soma;
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement("SELECT SUM(valor_pagar) as soma FROM parcelas_receber WHERE id_contas_receber = " + id_contas + "");
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                soma = rs.getDouble(1);
            } else {
                soma = 0;
            }
            pstm.close();
            return soma;
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public void incluirParcelas_receberJDBC(FinanceiroParcelas parcelas_receber) throws SQLException {
        String consultaSQL
                = "INSERT INTO parcelas_receber (data_pagamento,data_vencimento,"
                + "id_contas_receber,lancamento,status,parcela,valor,valor_pago) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            if (parcelas_receber.getData_pagamento() != null) {
                pstm.setDate(1, new Date(parcelas_receber.getData_pagamento().getTime()));
            } else {
                pstm.setDate(1, null);
            }
            if (parcelas_receber.getData_vencimento() != null) {
                pstm.setDate(2, new Date(parcelas_receber.getData_vencimento().getTime()));
            } else {
                pstm.setDate(2, null);
            }
            pstm.setInt(3, parcelas_receber.getFinanceiro().getId());
            pstm.setInt(4, parcelas_receber.getLancamento());
            pstm.setString(5, parcelas_receber.getStatus());
            pstm.setString(6, parcelas_receber.getParcela());
            pstm.setBigDecimal(7, parcelas_receber.getValor());
            pstm.setBigDecimal(8, parcelas_receber.getValor_pago());
            pstm.executeUpdate();
            ResultSet rs2 = pstm.getGeneratedKeys();
            if (rs2.next()) {
                parcelas_receber.setId(rs2.getInt(1));
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editarParcelas_receberJDBC(FinanceiroParcelas parcelas_receber) throws SQLException {
        String consultaSQL
                = "UPDATE parcelas_receber SET data_pagamento = ?, data_vencimento = ?, "
                + "id_contas_receber = ?, lancamento = ?, status = ?, parcela = ?, "
                + "valor = ?, valor_pago = ? "
                + "WHERE id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            if (parcelas_receber.getData_pagamento() != null) {
                pstm.setDate(1, new Date(parcelas_receber.getData_pagamento().getTime()));
            } else {
                pstm.setDate(1, null);
            }
            if (parcelas_receber.getData_vencimento() != null) {
                pstm.setDate(2, new Date(parcelas_receber.getData_vencimento().getTime()));
            } else {
                pstm.setDate(2, null);
            }
            pstm.setInt(3, parcelas_receber.getFinanceiro().getId());
            pstm.setInt(4, parcelas_receber.getLancamento());
            pstm.setString(5, parcelas_receber.getStatus());
            pstm.setString(6, parcelas_receber.getParcela());
            pstm.setBigDecimal(7, parcelas_receber.getValor());
            pstm.setBigDecimal(8, parcelas_receber.getValor_pago());
            pstm.setInt(9, parcelas_receber.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
