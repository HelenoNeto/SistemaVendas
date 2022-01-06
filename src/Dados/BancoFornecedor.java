/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Fornecedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public class BancoFornecedor implements IbancoFornecedor {

    private static BancoFornecedor instancia = null;

    public static BancoFornecedor getInstancia() {
        if (instancia == null) {
            instancia = new BancoFornecedor();
        }
        return instancia;
    }

    @Override
    public Fornecedor incluirFornecedor(Fornecedor fornecedor) throws SQLException {
        ConectaBDFornecedor conexao = new ConectaBDFornecedor();
        return conexao.incluirFornecedor(fornecedor);
    }

    @Override
    public void editarFornecedor(Fornecedor fornecedor) throws SQLException {
        ConectaBDFornecedor conexao = new ConectaBDFornecedor();
        conexao.editarFornecedor(fornecedor);
    }

    @Override
    public Fornecedor consultarFornecedor(int id) throws SQLException {
        ConectaBDFornecedor conexao = new ConectaBDFornecedor();
        return conexao.consultarFornecedor(id);
    }

    @Override
    public ArrayList<Fornecedor> consultarFornecedor(String coluna, String dado) throws SQLException {
        ConectaBDFornecedor conexao = new ConectaBDFornecedor();
        return conexao.consultarFornecedor(coluna, dado);
    }

    @Override
    public void excluirFornecedor(Fornecedor fornecedor) throws SQLException {
        ConectaBDFornecedor conexao = new ConectaBDFornecedor();
        conexao.excluirFornecedor(fornecedor);
    }

}
