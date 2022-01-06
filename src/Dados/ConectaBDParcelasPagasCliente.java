/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.ParcelasPagasCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Neto
 */
public class ConectaBDParcelasPagasCliente {

    private final ConectaBD bd = new ConectaBD();

    public ArrayList<ParcelasPagasCliente> consultarParcelasPagasCliente(int idCliente) {
        ArrayList lista = new ArrayList();
        ParcelasPagasCliente parcelasPagasCliente;
        try {
            try (PreparedStatement pstm = bd.getConectacao().prepareStatement("select pr.id, pr.data_vencimento, "
                    + "prh.data_recebimento, prh.hora_recebimento, pr.valor,prh.valor_recebido "
                    + "from cliente c inner join contas_receber cr on c.id = cr.id_cliente "
                    + "inner join parcelas_receber pr on cr.id = pr.id_contas_receber "
                    + "inner join parcelas_receber_historico_recebimento prh on pr.id = prh.id_parcelas_receber "
                    + "where pr.status not like 'NAO' and cr.id_cliente = " + idCliente)) {
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    parcelasPagasCliente = new ParcelasPagasCliente();
                    parcelasPagasCliente.setId_parcela(rs.getInt("id"));
                    parcelasPagasCliente.setDataVencimento(rs.getDate("data_vencimento"));
                    parcelasPagasCliente.setDataPagamento(rs.getDate("data_recebimento"));
                    parcelasPagasCliente.setHoraRecebimento(rs.getString("hora_recebimento"));
                    parcelasPagasCliente.setValor(rs.getBigDecimal("valor"));
                    parcelasPagasCliente.setValorPago(rs.getBigDecimal("valor_recebido"));
                    lista.add(parcelasPagasCliente);
                }
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
}
