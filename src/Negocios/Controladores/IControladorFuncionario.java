package Negocios.Controladores;

import Negocios.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IControladorFuncionario {

    public void incluirFuncionario(Funcionario funcionario) throws SQLException;

    public void editarFuncionario(Funcionario funcionario) throws SQLException;

    public ArrayList consultarFuncionario(String query) throws SQLException;

    public Funcionario consultarFuncionario(int id_funcionario) throws SQLException;

    public void excluirFuncionario(Funcionario funcionario) throws SQLException;
}
