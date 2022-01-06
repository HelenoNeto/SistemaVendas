/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios.Controladores;

import Dados.BancoVendaDetalhe;
import Dados.IBancoVendaDetalhe;
import Negocios.VendaCabecalho;
import Negocios.VendaDetalhe;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public class ControladorVendaDetalhe implements IControladorVendaDetalhe {

    @Override
    public void incluirVendaDetalhe(VendaDetalhe vendaDetalhe) throws SQLException {
        IBancoVendaDetalhe bancoVendaDetalhe = BancoVendaDetalhe.getInstancia();
        bancoVendaDetalhe.incluirVendaDetalhe(vendaDetalhe);
    }

    @Override
    public ArrayList consultarVendaDetalhe(String query) throws SQLException {
        IBancoVendaDetalhe bancoVendaDetalhe = BancoVendaDetalhe.getInstancia();
        return bancoVendaDetalhe.consultarVendaDetalhe(query);
    }

    @Override
    public void excluirVendaDetalhe(VendaCabecalho vendaCabecalho) throws SQLException {
        IBancoVendaDetalhe bancoVendaDetalhe = BancoVendaDetalhe.getInstancia();
        bancoVendaDetalhe.excluirVendaDetalhe(vendaCabecalho);
    }

    @Override
    public void incluirListaVendaDetalhe(ArrayList<VendaDetalhe> listaVendaDetalhe) {
        IBancoVendaDetalhe bancoVendaDetalhe = BancoVendaDetalhe.getInstancia();
        bancoVendaDetalhe.incluirListaVendaDetalhe(listaVendaDetalhe);
    }

    @Override
    public VendaDetalhe consultarVendaDetalhe_porIdVendaDetalhe(int id_venda_detalhe) throws SQLException {
        IBancoVendaDetalhe bancoVendaDetalhe = BancoVendaDetalhe.getInstancia();
        return bancoVendaDetalhe.consultarVendaDetalhe_porIdVendaDetalhe(id_venda_detalhe);
    }

}
