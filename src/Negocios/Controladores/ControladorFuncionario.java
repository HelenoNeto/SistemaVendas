package Negocios.Controladores;

import Dados.BancoFuncionario;
import Dados.IBancoFuncionario;
import Negocios.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorFuncionario implements IControladorFuncionario {

    @Override
    public void incluirFuncionario(Funcionario funcionario) throws SQLException {
        IBancoFuncionario bancoFuncionario = BancoFuncionario.getInstancia();
        bancoFuncionario.incluirFuncionario(funcionario);
    }

    @Override
    public void editarFuncionario(Funcionario funcionario) throws SQLException {
        IBancoFuncionario bancoFuncionario = BancoFuncionario.getInstancia();
        bancoFuncionario.editarFuncionario(funcionario);
    }

    @Override
    public ArrayList consultarFuncionario(String query) throws SQLException {
        IBancoFuncionario bancoFuncionario = BancoFuncionario.getInstancia();
        return bancoFuncionario.consultarFuncionario(query);
    }

    @Override
    public void excluirFuncionario(Funcionario funcionario) throws SQLException {
        IBancoFuncionario bancoFuncionario = BancoFuncionario.getInstancia();
        bancoFuncionario.excluirFuncionario(funcionario);
    }

    @Override
    public Funcionario consultarFuncionario(int id_funcionario) throws SQLException {
        IBancoFuncionario bancoFuncionario = BancoFuncionario.getInstancia();
        return bancoFuncionario.consultarFuncionario(id_funcionario);
    }

}
