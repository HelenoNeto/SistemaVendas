package Dados;

import Negocios.Cliente;
import Negocios.Financeiro;
import Negocios.Fachada;
import Negocios.FinanceiroParcelas;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistema.gas.cliente.dados.ConectaBDCliente;

public class ConectaBDContaReceber {

    private final ConectaBD bd = new ConectaBD();

    public ArrayList consultarContaReceberQuery(String query) {
        Financeiro contas_Receber;
        ArrayList lista = new ArrayList();
        try {
            try (PreparedStatement st = bd.getConectacao().prepareStatement(query)) {
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    contas_Receber = new Financeiro();
                    contas_Receber.setId(rs.getInt("id"));
                    contas_Receber.setData_emissao(rs.getDate("data_emissao"));
                    contas_Receber.setDocumento(rs.getString("documento"));
                    contas_Receber.setEntrada(rs.getBigDecimal("entrada"));
                    contas_Receber.setNumero_parcelas(rs.getInt("numero_parcelas"));
                    contas_Receber.setReferente(rs.getString("referente"));
                    contas_Receber.setValor_total(rs.getBigDecimal("valor_total"));
                    contas_Receber.setExcluido(rs.getBoolean("excluido"));
                    ArrayList<Cliente> listaCliente = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where id = " + rs.getInt("id_cliente"));
                    if (!listaCliente.isEmpty()) {
                        contas_Receber.setCliente(listaCliente.get(0));
                    }
                    ArrayList<FinanceiroParcelas> listaParcelasReceber = Fachada.getInstancia().consultarParcelasReceberQuery("select * from parcelas_receber where id_contas_receber = " + contas_Receber.getId());
                    if (!listaParcelasReceber.isEmpty()) {
                        contas_Receber.setListaParcelasReceber(listaParcelasReceber);
                    }
                    lista.add(contas_Receber);
                }
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public Financeiro consultarContaReceber(int id) {
        Financeiro financeiro = null;
        try {
            try (PreparedStatement st = bd.getConectacao().prepareStatement("select * from contas_receber where id = " + id)) {
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    financeiro = new Financeiro();
                    financeiro.setId(rs.getInt("id"));
                    financeiro.setData_emissao(rs.getDate("data_emissao"));
                    financeiro.setDocumento(rs.getString("documento"));
                    financeiro.setEntrada(rs.getBigDecimal("entrada"));
                    financeiro.setNumero_parcelas(rs.getInt("numero_parcelas"));
                    financeiro.setReferente(rs.getString("referente"));
                    financeiro.setValor_total(rs.getBigDecimal("valor_total"));
                    financeiro.setExcluido(rs.getBoolean("excluido"));
                    ArrayList<Cliente> listaCliente = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where id = " + rs.getInt("id_cliente"));
                    if (!listaCliente.isEmpty()) {
                        financeiro.setCliente(listaCliente.get(0));
                    }
                    ArrayList<FinanceiroParcelas> listaParcelasReceber = Fachada.getInstancia().consultarParcelasReceber(financeiro);
                    if (!listaParcelasReceber.isEmpty()) {
                        financeiro.setListaParcelasReceber(listaParcelasReceber);
                    }
                }
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return financeiro;
    }

    public void deletarContasReceberJDBC(Financeiro contas_Receber) {
        try {
            try (PreparedStatement st = bd.getConectacao().prepareStatement("DELETE FROM contas_Receber WHERE id = ?")) {
                st.setInt(1, contas_Receber.getId());
                st.execute();
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exclusaoLogicaContasReceberJDBC(Financeiro contas_Receber) {
        try {
            try (PreparedStatement st = bd.getConectacao().prepareStatement(
                    "UPDATE contas_Receber SET excluido = ?, data_exclusao = ?, id_usuario_exclusao = ? WHERE id = ?")) {
                st.setBoolean(1, true);
                st.setDate(2, new Date(contas_Receber.getData_exclusao().getTime()));
                st.setInt(3, contas_Receber.getId_usuario_exclusao());
                st.setInt(4, contas_Receber.getId());
                st.execute();
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void incluirContas_ReceberJDBC(Financeiro contas_Receber) throws SQLException {
        String consultaSQL
                = "INSERT INTO contas_receber (id_cliente,data_emissao,documento,entrada,"
                + "numero_parcelas,referente,valor_total, excluido, id_usuario_insercao) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, contas_Receber.getCliente().getId());
            if (contas_Receber.getData_emissao() != null) {
                pstm.setDate(2, new Date(contas_Receber.getData_emissao().getTime()));
            } else {
                pstm.setDate(2, null);
            }
            pstm.setString(3, contas_Receber.getDocumento());
            pstm.setBigDecimal(4, contas_Receber.getEntrada());
            if (contas_Receber.getNumero_parcelas() != null) {
                pstm.setInt(5, contas_Receber.getNumero_parcelas());
            } else {
                pstm.setNull(5, java.sql.Types.INTEGER);
            }
            pstm.setString(6, contas_Receber.getReferente());
            pstm.setBigDecimal(7, contas_Receber.getValor_total());
            pstm.setBoolean(8, false);
            pstm.setInt(9, contas_Receber.getId_usuario_insercao());
            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                contas_Receber.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editarContas_ReceberJDBC(Financeiro contas_Receber) throws SQLException {
        String consultaSQL
                = "update contas_receber SET id_cliente = ?, data_emissao = ?, "
                + "documento = ?, entrada = ?, numero_parcelas = ?, "
                + "referente = ?, valor_total = ?, data_edicao = ?, id_usuario_edicao = ? WHERE id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, contas_Receber.getCliente().getId());
            if (contas_Receber.getData_emissao() != null) {
                pstm.setDate(2, new Date(contas_Receber.getData_emissao().getTime()));
            } else {
                pstm.setDate(2, null);
            }
            pstm.setString(3, contas_Receber.getDocumento());
            pstm.setBigDecimal(4, contas_Receber.getEntrada());
            pstm.setInt(5, contas_Receber.getNumero_parcelas());
            pstm.setString(6, contas_Receber.getReferente());
            pstm.setBigDecimal(7, contas_Receber.getValor_total());
            pstm.setDate(8, new Date(contas_Receber.getData_edicao().getTime()));
            pstm.setInt(9, contas_Receber.getId_usuario_edicao());
            pstm.setInt(10, contas_Receber.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
