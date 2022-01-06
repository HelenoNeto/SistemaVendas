/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.cliente.dados;

import Negocios.Cliente;
import Negocios.HistoricoPagamentoCliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DEV
 */
public interface IBancoCliente {

    public void incluirCliente(Cliente cliente) throws SQLException;

    public ArrayList consultarCliente(String query) throws SQLException;

    public Cliente consultarCliente(int id_cliente) throws SQLException;

    public ArrayList<Cliente> consultarClienteVisita() throws SQLException;

    public void editarCliente(Cliente cliente) throws SQLException;

    public void excluirCliente(Cliente cliente) throws SQLException;

    public ArrayList<HistoricoPagamentoCliente> consultarHistoricoPagamentosClienteJDBC(int id_cliente) throws SQLException;

}
