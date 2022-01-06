/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.cliente.dados;

import Negocios.ClienteVasilhame;
import Negocios.ClienteVasilhameDetalhe;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DEV
 */
public interface IBancoClienteVasilhameDetalhe {

    public void incluirClienteVasilhameDetalhe(ClienteVasilhameDetalhe clienteVasilhameDetalhe) throws SQLException;

    public void editaClienteVasilhameDetalhe(ClienteVasilhameDetalhe clienteVasilhameDetalhe) throws SQLException;

    public ArrayList<ClienteVasilhameDetalhe> consultarClienteVasilhameDetalhe(String query) throws SQLException;

    public BigDecimal consultarTotalDevolvidoClienteVasilhameDetalhe(int id_cliente_vasilhame) throws SQLException;

    public void excluirClienteVasilhameDetalheUnico(ClienteVasilhameDetalhe clienteVasilhameDetalhe) throws SQLException;

    public void excluirClienteVasilhameDetalheVinculoCabecalho(ClienteVasilhame clienteVasilhame) throws SQLException;

}
