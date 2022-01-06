/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.VendaCabecalho;
import Negocios.VendaDetalhe;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public interface IBancoVendaDetalhe {

    public void incluirVendaDetalhe(VendaDetalhe vendaDetalhe) throws SQLException;

    public void incluirListaVendaDetalhe(ArrayList<VendaDetalhe> listaVendaDetalhe);

    public ArrayList consultarVendaDetalhe(String query) throws SQLException;

    public void excluirVendaDetalhe(VendaCabecalho vendaCabecalho) throws SQLException;

    public VendaDetalhe consultarVendaDetalhe_porIdVendaDetalhe(int id_venda_detalhe) throws SQLException;

}
