/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.cliente.dados;

import Negocios.ClienteVasilhame;
import Negocios.VendaDetalhe;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DEV
 */
public interface IBancoClienteVasilhame {

    public void incluirClienteVasilhame(ClienteVasilhame clienteVasilhame) throws SQLException;

    public void editaClienteVasilhame(ClienteVasilhame clienteVasilhame) throws SQLException;

    public ArrayList<ClienteVasilhame> consultarClienteVasilhame(String query) throws SQLException;

    public void excluirClienteVasilhame(ClienteVasilhame clienteVasilhame) throws SQLException;

    public void excluirClienteVasilhamePorVenda(VendaDetalhe vendaDetalhe) throws SQLException;

}
