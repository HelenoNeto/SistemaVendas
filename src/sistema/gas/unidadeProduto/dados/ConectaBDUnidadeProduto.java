package sistema.gas.unidadeProduto.dados;

import Dados.ConectaBD;
import sistema.gas.unidadeProduto.negocios.UnidadeProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectaBDUnidadeProduto implements IBancoUnidadeProduto {

    private final ConectaBD bd = new ConectaBD();
    private ResultSet rs;

    public static ConectaBDUnidadeProduto getInstance() {
        return ConectaBDUnidadeProdutoHolder.INSTANCE;
    }

    @Override
    public void salvar(UnidadeProduto unidadeProduto) {
        try {
            try (PreparedStatement st = bd.getConectacao().prepareStatement("REPLACE unidade_produto SET ID=?, NOME=?, PODE_FRACIONAR=?, DESCRICAO=?, COMENTARIO=?", PreparedStatement.RETURN_GENERATED_KEYS)) {
                st.setInt(1, unidadeProduto.getId());
                st.setString(2, unidadeProduto.getNome());
                st.setBoolean(3, unidadeProduto.isPodeFracionar());
                st.setString(4, unidadeProduto.getDescricao());
                st.setString(5, unidadeProduto.getComentario());
                st.executeUpdate();

                ResultSet rs2 = st.getGeneratedKeys();
                if (rs2.next()) {
                    unidadeProduto.setId(rs2.getInt(1));
                }
            }
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro ao salvar unidade produto.\nErro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList<UnidadeProduto> consultarPorTipo(String tipo, String dado) {
        ArrayList lista = new ArrayList();
        UnidadeProduto unidadeProduto;
        try {
            try (PreparedStatement st = bd.getConectacao().prepareStatement("SELECT * FROM unidade_Produto WHERE " + tipo + " LIKE '" + dado + "' ORDER BY " + tipo + "")) {
                rs = st.executeQuery();
                while (rs.next()) {
                    unidadeProduto = new UnidadeProduto();
                    unidadeProduto.setId(rs.getInt("ID"));
                    unidadeProduto.setNome(rs.getString("NOME"));
                    unidadeProduto.setDescricao(rs.getString("DESCRICAO"));
                    unidadeProduto.setComentario(rs.getString("COMENTARIO"));
                    unidadeProduto.setPodeFracionar(rs.getBoolean("PODE_FRACIONAR"));
                    lista.add(unidadeProduto);
                }
            }
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro ao consultar unidade produto.\nErro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    @Override
    public UnidadeProduto consultarPorId(int id) {
        UnidadeProduto unidadeProduto = null;
        try {
            try (PreparedStatement st = bd.getConectacao().prepareStatement("SELECT * FROM unidade_Produto WHERE id=" + id)) {
                rs = st.executeQuery();
                if (rs.next()) {
                    unidadeProduto = new UnidadeProduto();
                    unidadeProduto.setId(rs.getInt("ID"));
                    unidadeProduto.setNome(rs.getString("NOME"));
                    unidadeProduto.setDescricao(rs.getString("DESCRICAO"));
                    unidadeProduto.setComentario(rs.getString("COMENTARIO"));
                    unidadeProduto.setPodeFracionar(rs.getBoolean("PODE_FRACIONAR"));
                }
            }
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro ao consultar unidade produto.\nErro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return unidadeProduto;
    }

    @Override
    public void deletar(UnidadeProduto unidadeProduto) {
        try {
            try (PreparedStatement st = bd.getConectacao().prepareStatement("DELETE FROM unidade_Produto WHERE ID = ?")) {
                st.setInt(1, unidadeProduto.getId());
                st.execute();
            }
        } catch (SQLException erro) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "Erro ao deletar unidade produto.\nErro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static class ConectaBDUnidadeProdutoHolder {

        private static final ConectaBDUnidadeProduto INSTANCE = new ConectaBDUnidadeProduto();
    }
}
