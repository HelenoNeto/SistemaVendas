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
public interface IBancoFuncionario {

    public void incluirFuncionario(Funcionario funcionario) throws SQLException;

    public void editarFuncionario(Funcionario funcionario) throws SQLException;

    public ArrayList consultarFuncionario(String query) throws SQLException;

    public Funcionario consultarFuncionario(int id_funcionario) throws SQLException;

    public void excluirFuncionario(Funcionario funcionario) throws SQLException;
}
