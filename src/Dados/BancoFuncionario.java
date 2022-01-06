/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class BancoFuncionario implements IBancoFuncionario {

    private static BancoFuncionario instancia = null;

    public static BancoFuncionario getInstancia() {
        if (instancia == null) {
            instancia = new BancoFuncionario();
        }
        return instancia;
    }

    @Override
    public void incluirFuncionario(Funcionario funcionario) throws SQLException {
        ConectaBDFuncionario conexao = new ConectaBDFuncionario();
        conexao.incluirFuncionario(funcionario);
    }

    @Override
    public void editarFuncionario(Funcionario funcionario) throws SQLException {
        ConectaBDFuncionario conexao = new ConectaBDFuncionario();
        conexao.editarFuncionario(funcionario);
    }

    @Override
    public ArrayList consultarFuncionario(String query) throws SQLException {
        ConectaBDFuncionario conexao = new ConectaBDFuncionario();
        return conexao.consultarFuncionario(query);
    }

    @Override
    public void excluirFuncionario(Funcionario funcionario) throws SQLException {
        ConectaBDFuncionario conexao = new ConectaBDFuncionario();
        conexao.excluirFuncionario(funcionario);
    }

    @Override
    public Funcionario consultarFuncionario(int id_funcionario) throws SQLException {
        ConectaBDFuncionario conexao = new ConectaBDFuncionario();
        return conexao.consultarFuncionario(id_funcionario);
    }

}
