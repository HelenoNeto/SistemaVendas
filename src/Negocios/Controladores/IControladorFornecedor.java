/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios.Controladores;

import Negocios.Fornecedor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public interface IControladorFornecedor {

    public Fornecedor incluirFornecedor(Fornecedor fornecedor) throws SQLException;

    public void editarFornecedor(Fornecedor fornecedor) throws SQLException;

    public Fornecedor consultarFornecedor(int id) throws SQLException;

    public ArrayList<Fornecedor> consultarFornecedor(String coluna, String dado) throws SQLException;

    public void excluirFornecedor(Fornecedor fornecedor) throws SQLException;

}
