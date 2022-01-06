/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Grupo;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ConectaBDGrupo {

    private final ConectaBD bd = new ConectaBD();

    public void incluirGrupo(Grupo grupo) throws SQLException {
        String consultaSQL
                = "insert into grupo (descricao, excluido, data_insercao, id_usuario_insercao, vasilhame) values (?,?,?,?,?)";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, grupo.getDescricao());
            pstm.setBoolean(2, false);
            pstm.setDate(3, new Date(grupo.getData_insercao().getTime()));
            pstm.setInt(4, grupo.getId_usuario_insercao());
            pstm.setBoolean(5, grupo.isVasilhames());
            pstm.execute();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                grupo.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editarGrupo(Grupo grupo) throws SQLException {
        String consultaSQL
                = "update grupo set "
                + "descricao=?,"
                + "excluido = ?, data_edicao = ?, id_usuario_edicao = ?, "
                + "vasilhame = ? where id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, grupo.getDescricao());
            pstm.setBoolean(2, false);
            pstm.setDate(3, new Date(grupo.getData_edicao().getTime()));
            pstm.setInt(4, grupo.getId_usuario_edicao());
            pstm.setBoolean(5, grupo.isVasilhames());
            pstm.setInt(6, grupo.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList consultarGrupo(String query) throws SQLException {
        Grupo grupo;
        ArrayList lista = new ArrayList();
        String consultaSQL
                = query;
        try {
            Statement stm = bd.getConectacao().createStatement();
            ResultSet rs = stm.executeQuery(consultaSQL);
            while (rs.next()) {
                grupo = new Grupo();
                grupo.setDescricao(rs.getString("descricao"));
                grupo.setExcluido(rs.getBoolean("excluido"));
                grupo.setVasilhames(rs.getBoolean("vasilhame"));
                grupo.setId(rs.getInt("id"));
                lista.add(grupo);
            }
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;
    }

    public void excluirGrupo(Grupo grupo) throws SQLException {
        String consultaSQL
                = "delete from grupo where id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setInt(1, grupo.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int retornoAutoIncrementGrupo() throws SQLException {
        int autoIncrement;
        PreparedStatement st;
        st = bd.getConectacao().prepareStatement("SELECT Auto_increment FROM information_schema.tables WHERE table_name='grupo'  AND table_schema = DATABASE()");
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            autoIncrement = rs.getInt(1);
        } else {
            autoIncrement = 1;
        }
        return autoIncrement;
    }

    public void alterarGrupoExclusao(Grupo grupo) throws SQLException {
        String consultaSQL
                = "update grupo set excluido = ?, data_exclusao = ?, id_usuario_exclusao = ? where id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setBoolean(1, true);
            pstm.setDate(2, new Date(grupo.getData_exclusao().getTime()));
            pstm.setInt(3, grupo.getId_usuario_exclusao());
            pstm.setInt(4, grupo.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
