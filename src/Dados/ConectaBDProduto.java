package Dados;

import sistema.gas.unidadeProduto.dados.ConectaBDUnidadeProduto;
import Negocios.Fachada;
import Negocios.Grupo;
import Negocios.Produto;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectaBDProduto implements IBancoProduto {

    private final ConectaBD bd = new ConectaBD();
    private String consultaSQL;
    private PreparedStatement pstm;
    private ResultSet rs;

    public static ConectaBDProduto getInstance() {
        return ConectaBDProdutoHolder.INSTANCE;
    }

    @Override
    public void salvarProduto(Produto produto) throws SQLException {
        consultaSQL = "REPLACE produto SET id=?,id_produto_vasilhame=?, qtd_vasilhame=?, data_cadastro=?, "
                + "id_grupo=?, codigo=?, descricao=?, valor_venda=?, qtd_estoque=?, qtd_estoque_avaria=?, "
                + "excluido=?, id_usuario_insercao=?, valor_compra=?, lucro=?, id_unidade_produto=?";

        pstm = bd.getConectacao().prepareStatement(consultaSQL);
        int i = 1;
        pstm.setInt(i++, produto.getId());
        if (produto.getId_produto_vasilhame() != null) {
            pstm.setInt(i++, produto.getId_produto_vasilhame());
        } else {
            pstm.setNull(i++, java.sql.Types.INTEGER);
        }
        pstm.setBigDecimal(i++, produto.getQtd_vasilhame());
        pstm.setTimestamp(i++, new Timestamp(produto.getData_cadastro().getTime()));
        pstm.setInt(i++, produto.getGrupo().getId());
        pstm.setString(i++, produto.getCodigo());
        pstm.setString(i++, produto.getDescricao());
        pstm.setBigDecimal(i++, produto.getValor_venda());
        pstm.setBigDecimal(i++, produto.getQtd_estoque());
        pstm.setBigDecimal(i++, produto.getQtd_estoque_avaria());
        pstm.setBoolean(i++, produto.isExcluido());
        pstm.setInt(i++, produto.getId_usuario_insercao());
        pstm.setBigDecimal(i++, produto.getValor_compra());
        pstm.setBigDecimal(i++, produto.getLucro());
        pstm.setInt(i++, produto.getUnidadeProduto().getId());
        pstm.executeUpdate();
    }

    @Override
    public ArrayList consultarProduto(String query) throws SQLException {
        ArrayList<Produto> lista = new ArrayList();
        Produto produto;
        try (PreparedStatement st = bd.getConectacao().prepareStatement(query)) {
            rs = st.executeQuery();
            while (rs.next()) {
                ArrayList<Grupo> listaGrupo = Fachada.getInstancia().consultarGrupo("select * from grupo where id = " + rs.getInt("id_grupo"));
                produto = new Produto(rs.getInt("id_produto_vasilhame"), rs.getBigDecimal("qtd_vasilhame"),
                        rs.getTimestamp("data_cadastro"), listaGrupo.get(0), rs.getString("codigo"), rs.getString("descricao"),
                        rs.getBigDecimal("valor_venda"), rs.getBigDecimal("qtd_estoque"), rs.getBigDecimal("qtd_estoque_avaria"),
                        rs.getBoolean("excluido"), rs.getInt("id_usuario_insercao"), rs.getBigDecimal("valor_compra"), rs.getBigDecimal("lucro"));
                produto.setId(rs.getInt("id"));
                produto.setUnidadeProduto(ConectaBDUnidadeProduto.getInstance().consultarPorId(rs.getInt("id_unidade_produto")));
                lista.add(produto);
            }
        }
        return lista;
    }

    @Override
    public Produto consultarProduto_porId(int id) throws SQLException {
        Produto produto = null;
        try (PreparedStatement st = bd.getConectacao().prepareStatement("select * from produto where id = " + id)) {
            rs = st.executeQuery();
            if (rs.next()) {
                ArrayList<Grupo> listaGrupo = Fachada.getInstancia().consultarGrupo("select * from grupo where id = " + rs.getInt("id_grupo"));
                produto = new Produto(rs.getInt("id_produto_vasilhame"), rs.getBigDecimal("qtd_vasilhame"),
                        rs.getTimestamp("data_cadastro"), listaGrupo.get(0), rs.getString("codigo"), rs.getString("descricao"),
                        rs.getBigDecimal("valor_venda"), rs.getBigDecimal("qtd_estoque"), rs.getBigDecimal("qtd_estoque_avaria"),
                        rs.getBoolean("excluido"), rs.getInt("id_usuario_insercao"), rs.getBigDecimal("valor_compra"), rs.getBigDecimal("lucro"));
                produto.setId(rs.getInt("id"));
                produto.setUnidadeProduto(ConectaBDUnidadeProduto.getInstance().consultarPorId(rs.getInt("id_unidade_produto")));
            }
        }
        return produto;
    }

    @Override
    public Produto consultarProduto_porCodigo(String codigo) throws SQLException {
        Produto produto = null;
        try (PreparedStatement st = bd.getConectacao().prepareStatement("select * from produto where codigo like '" + codigo + "'")) {
            rs = st.executeQuery();
            if (rs.next()) {
                ArrayList<Grupo> listaGrupo = Fachada.getInstancia().consultarGrupo("select * from grupo where id = " + rs.getInt("id_grupo"));
                produto = new Produto(rs.getInt("id_produto_vasilhame"), rs.getBigDecimal("qtd_vasilhame"),
                        rs.getTimestamp("data_cadastro"), listaGrupo.get(0), rs.getString("codigo"), rs.getString("descricao"),
                        rs.getBigDecimal("valor_venda"), rs.getBigDecimal("qtd_estoque"), rs.getBigDecimal("qtd_estoque_avaria"),
                        rs.getBoolean("excluido"), rs.getInt("id_usuario_insercao"), rs.getBigDecimal("valor_compra"), rs.getBigDecimal("lucro"));
                produto.setId(rs.getInt("id"));
                produto.setUnidadeProduto(ConectaBDUnidadeProduto.getInstance().consultarPorId(rs.getInt("id_unidade_produto")));
            }
        }
        return produto;
    }

    @Override
    public void excluirProduto(Produto produto) throws SQLException {
        consultaSQL
                = "update produto set excluido = ?, data_exclusao = ?, id_usuario_exclusao = ? where id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setBoolean(1, true);
            pstm.setDate(2, new Date(produto.getData_exclusao().getTime()));
            pstm.setInt(3, produto.getId_usuario_exclusao());
            pstm.setInt(4, produto.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void adicionarEstoqueProduto(BigDecimal quantidade, Produto produto) {
        consultaSQL
                = "update produto set qtd_estoque = qtd_estoque + ? where id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setBigDecimal(1, quantidade);
            pstm.setInt(2, produto.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void diminuirEstoqueProduto(BigDecimal quantidade, Produto produto) {
        consultaSQL
                = "update produto set qtd_estoque = qtd_estoque - ? where id = ?";
        try {
            pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setBigDecimal(1, quantidade);
            pstm.setInt(2, produto.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static class ConectaBDProdutoHolder {

        private static final ConectaBDProduto INSTANCE = new ConectaBDProduto();
    }
}
