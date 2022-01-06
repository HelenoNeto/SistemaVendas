package Dados;

import Negocios.Produto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IBancoProduto {

    public void salvarProduto(Produto produto) throws SQLException;

    public ArrayList consultarProduto(String query) throws SQLException;

    public void excluirProduto(Produto produto) throws SQLException;

    public void adicionarEstoqueProduto(BigDecimal quantidade, Produto produto);

    public void diminuirEstoqueProduto(BigDecimal quantidade, Produto produto);

    public Produto consultarProduto_porId(int id) throws SQLException;

    public Produto consultarProduto_porCodigo(String codigo) throws SQLException;
}
