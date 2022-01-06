package Dados;

import Negocios.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectaBDFuncionario {

    private final ConectaBD bd = new ConectaBD();

    public void incluirFuncionario(Funcionario funcionario) throws SQLException {
        String consultaSQL
                = "insert into funcionario (nome, endereco, num_end, comp_end, bairro, cep, "
                + "codigo_municipio, municipio, uf, telefone, celular, email, obs, data_cadastro, "
                + "cpf, rg, login, senha, excluido, id_usuario_insercao)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getEndereco());
            pstm.setString(3, funcionario.getNum_end());
            pstm.setString(4, funcionario.getComp_end());
            pstm.setString(5, funcionario.getBairro());
            pstm.setString(6, funcionario.getCep());
            pstm.setString(7, funcionario.getCodigo_municipio());
            pstm.setString(8, funcionario.getMunicipio());
            pstm.setString(9, funcionario.getUf());
            pstm.setString(10, funcionario.getTelefone());
            pstm.setString(11, funcionario.getCelular());
            pstm.setString(12, funcionario.getEmail());
            pstm.setString(13, funcionario.getObs());
            if (funcionario.getData_cadastro() != null) {
                pstm.setTimestamp(14, new Timestamp(funcionario.getData_cadastro().getTime()));
            } else {
                pstm.setNull(14, java.sql.Types.TIMESTAMP);
            }
            pstm.setString(15, funcionario.getCpf());
            pstm.setString(16, funcionario.getRg());
            pstm.setString(17, funcionario.getUsuario());
            pstm.setString(18, funcionario.getSenha());
            pstm.setBoolean(19, false);
            pstm.setInt(20, funcionario.getId_usuario_insercao());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editarFuncionario(Funcionario funcionario) throws SQLException {
        String consultaSQL
                = "update funcionario set nome = ?,  endereco = ?,  num_end = ?,  "
                + "comp_end = ?,  bairro = ?,  cep = ?,  codigo_municipio = ?,  municipio = ?,  "
                + "uf = ?,  telefone = ?,  celular = ?,  email = ?,  obs = ?,  cpf = ?,  rg = ?,  "
                + "login = ?,  senha = ?,  excluido = ?,  data_edicao = ?,  id_usuario_edicao = ? where id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getEndereco());
            pstm.setString(3, funcionario.getNum_end());
            pstm.setString(4, funcionario.getComp_end());
            pstm.setString(5, funcionario.getBairro());
            pstm.setString(6, funcionario.getCep());
            pstm.setString(7, funcionario.getCodigo_municipio());
            pstm.setString(8, funcionario.getMunicipio());
            pstm.setString(9, funcionario.getUf());
            pstm.setString(10, funcionario.getTelefone());
            pstm.setString(11, funcionario.getCelular());
            pstm.setString(12, funcionario.getEmail());
            pstm.setString(13, funcionario.getObs());
            pstm.setString(14, funcionario.getCpf());
            pstm.setString(15, funcionario.getRg());
            pstm.setString(16, funcionario.getUsuario());
            pstm.setString(17, funcionario.getSenha());
            pstm.setBoolean(18, false);
            if (funcionario.getData_edicao() != null) {
                pstm.setDate(19, new Date(funcionario.getData_edicao().getTime()));
            } else {
                pstm.setNull(19, java.sql.Types.DATE);
            }
            pstm.setInt(20, funcionario.getId_usuario_edicao());
            pstm.setInt(21, funcionario.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao consultar unidade produto.\nErro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList consultarFuncionario(String query) throws SQLException {
        Funcionario f;
        ArrayList lista = new ArrayList();
        String consultaSQL = query;
        try {
            Statement stm = bd.getConectacao().createStatement();
            ResultSet rs = stm.executeQuery(consultaSQL);
            while (rs.next()) {
                f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("num_end"), rs.getString("comp_end"), rs.getString("bairro"), rs.getString("cep"), rs.getString("codigo_municipio"), rs.getString("municipio"), rs.getString("uf"), rs.getString("telefone"), rs.getString("celular"), rs.getString("email"), rs.getString("obs"), rs.getDate("data_cadastro"), rs.getString("cpf"), rs.getString("rg"), rs.getString("login"), rs.getString("senha"), rs.getBoolean("excluido"), rs.getDate("data_edicao"), rs.getDate("data_exclusao"), rs.getInt("id_usuario_insercao"), rs.getInt("id_usuario_edicao"), rs.getInt("id_usuario_exclusao"));
                lista.add(f);
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao consultar unidade produto.\nErro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }

    public Funcionario consultarFuncionario(int id_funcionario) throws SQLException {
        Funcionario f = null;
        String consultaSQL = "SELECT * FROM FUNCIONARIO WHERE ID = " + id_funcionario;
        try {
            Statement stm = bd.getConectacao().createStatement();
            ResultSet rs = stm.executeQuery(consultaSQL);
            while (rs.next()) {
                f = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("num_end"), rs.getString("comp_end"), rs.getString("bairro"), rs.getString("cep"), rs.getString("codigo_municipio"), rs.getString("municipio"), rs.getString("uf"), rs.getString("telefone"), rs.getString("celular"), rs.getString("email"), rs.getString("obs"), rs.getDate("data_cadastro"), rs.getString("cpf"), rs.getString("rg"), rs.getString("login"), rs.getString("senha"), rs.getBoolean("excluido"), rs.getDate("data_edicao"), rs.getDate("data_exclusao"), rs.getInt("id_usuario_insercao"), rs.getInt("id_usuario_edicao"), rs.getInt("id_usuario_exclusao"));
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao consultar unidade produto.\nErro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return f;
    }

    public void excluirFuncionario(Funcionario funcionario) throws SQLException {
        String consultaSQL
                = "update funcionario set excluido = ?, data_exclusao = ?, id_usuario_exclusao = ? where id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setBoolean(1, true);
            pstm.setDate(2, new Date(funcionario.getData_exclusao().getTime()));
            pstm.setInt(3, funcionario.getId_usuario_exclusao());
            pstm.setInt(4, funcionario.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
