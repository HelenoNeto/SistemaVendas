/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.FinanceiroParcelas;
import Negocios.FinanceiroRecPag;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class ConectaBDHistoricoRecebimentoParcelasReceber {

    private final ConectaBD bd = new ConectaBD();

    public int retornarAutoIncrementHistoricoRecebimentoParcelasReceber() throws SQLException {
        int autoIncrement;
        String consultaSQL = "SELECT Auto_increment FROM information_schema.tables WHERE table_name='parcelas_receber_historico_recebimento'  AND table_schema = DATABASE()";
        Statement stm = bd.getConectacao().createStatement();
        ResultSet rs = stm.executeQuery(consultaSQL);
        if (rs.next()) {
            autoIncrement = rs.getInt(1);
        } else {
            autoIncrement = 1;
        }

        rs.close();
        stm.close();
        return autoIncrement;
    }

    public void incluirHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento) throws SQLException {
        String consultaSQL = "insert into parcelas_receber_historico_recebimento(id_parcelas_receber, data_recebimento, valor_recebido, hora_recebimento) values (?,?,?,?)";
        PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, parcelas_receber_historico_recebimento.getId_parcelas_receber());
        pstm.setDate(2, new Date(parcelas_receber_historico_recebimento.getData_recebimento().getTime()));
        pstm.setBigDecimal(3, parcelas_receber_historico_recebimento.getValor_recebido());
        pstm.setString(4, parcelas_receber_historico_recebimento.getHora_recebimento());
        pstm.executeUpdate();

        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            parcelas_receber_historico_recebimento.setId(rs.getInt(1));
        }

    }

    public ArrayList consultarHistoricoRecebimentoParcelasReceberJDBC(String query) throws SQLException {
        ArrayList lista = new ArrayList();
        FinanceiroRecPag parcelas_receber_historico_recebimento;
        PreparedStatement pstm = bd.getConectacao().prepareStatement(query);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            parcelas_receber_historico_recebimento = new FinanceiroRecPag();
            parcelas_receber_historico_recebimento.setData_recebimento(rs.getDate("data_recebimento"));
            parcelas_receber_historico_recebimento.setId(rs.getInt("Id"));
            parcelas_receber_historico_recebimento.setId_parcelas_receber(rs.getInt("Id_parcelas_receber"));
            parcelas_receber_historico_recebimento.setValor_recebido(rs.getBigDecimal("Valor_recebido"));
            parcelas_receber_historico_recebimento.setHora_recebimento(rs.getString("Hora_recebimento"));
            lista.add(parcelas_receber_historico_recebimento);
        }
        rs.close();
        pstm.close();
        return lista;
    }

    public void atualizarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroRecPag parcelas_receber_historico_recebimento) throws SQLException {
        String consultaSQL = "UPDATE parcelas_receber_historico_recebimento set id_parcelas_receber = ?, data_recebimento = ?, "
                + "valor_recebido = ?, hora_recebimento = ? where id = ?";
        PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
        pstm.setInt(1, parcelas_receber_historico_recebimento.getId_parcelas_receber());
        pstm.setDate(2, new Date(parcelas_receber_historico_recebimento.getData_recebimento().getTime()));
        pstm.setBigDecimal(3, parcelas_receber_historico_recebimento.getValor_recebido());
        pstm.setString(4, parcelas_receber_historico_recebimento.getHora_recebimento());
        pstm.setInt(5, parcelas_receber_historico_recebimento.getId());
        pstm.executeUpdate();

        pstm.close();
    }

    public void deletarHistoricoRecebimentoParcelasReceberJDBC(FinanceiroParcelas parcelas_receber) throws SQLException {
        String consultaSQL = "delete from parcelas_receber_historico_recebimento where id_parcelas_receber = ?";
        PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
        pstm.setInt(1, parcelas_receber.getId());
        pstm.executeUpdate();
        pstm.close();
    }
}
