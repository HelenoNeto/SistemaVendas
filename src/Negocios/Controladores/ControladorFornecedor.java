/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios.Controladores;

import Dados.BancoFornecedor;
import Dados.IbancoFornecedor;
import Negocios.Fornecedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public class ControladorFornecedor implements IControladorFornecedor {

    @Override
    public Fornecedor incluirFornecedor(Fornecedor fornecedor) throws SQLException {
        IbancoFornecedor controllerFornecedor = BancoFornecedor.getInstancia();
        return controllerFornecedor.incluirFornecedor(fornecedor);
    }

    @Override
    public void editarFornecedor(Fornecedor fornecedor) throws SQLException {
        IbancoFornecedor controllerFornecedor = BancoFornecedor.getInstancia();
        controllerFornecedor.editarFornecedor(fornecedor);
    }

    @Override
    public Fornecedor consultarFornecedor(int id) throws SQLException {
        IbancoFornecedor controllerFornecedor = BancoFornecedor.getInstancia();
        return controllerFornecedor.consultarFornecedor(id);
    }

    @Override
    public ArrayList<Fornecedor> consultarFornecedor(String coluna, String dado) throws SQLException {
        IbancoFornecedor controllerFornecedor = BancoFornecedor.getInstancia();
        return controllerFornecedor.consultarFornecedor(coluna, dado);
    }

    @Override
    public void excluirFornecedor(Fornecedor fornecedor) throws SQLException {
        IbancoFornecedor controllerFornecedor = BancoFornecedor.getInstancia();
        controllerFornecedor.excluirFornecedor(fornecedor);
    }

}
