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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neto
 */
public class BancoVendaDetalhe implements IBancoVendaDetalhe {

    private static BancoVendaDetalhe instancia = null;

    public static BancoVendaDetalhe getInstancia() {
        if (instancia == null) {
            instancia = new BancoVendaDetalhe();
        }
        return instancia;
    }

    @Override
    public void incluirVendaDetalhe(VendaDetalhe vendaDetalhe) throws SQLException {
        ConectaBDVendaDetalhe conexao = new ConectaBDVendaDetalhe();
        conexao.incluirVendaDetalhe(vendaDetalhe);
    }

    @Override
    public ArrayList consultarVendaDetalhe(String query) throws SQLException {
        ConectaBDVendaDetalhe conexao = new ConectaBDVendaDetalhe();
        return conexao.consultarVendaDetalhe(query);
    }

    @Override
    public void excluirVendaDetalhe(VendaCabecalho vendaCabecalho) throws SQLException {
        ConectaBDVendaDetalhe conexao = new ConectaBDVendaDetalhe();
        conexao.excluirVendaDetalhe(vendaCabecalho);
    }

    @Override
    public void incluirListaVendaDetalhe(ArrayList<VendaDetalhe> listaVendaDetalhe) {
        try {
            ConectaBDVendaDetalhe conexao = new ConectaBDVendaDetalhe();
            conexao.incluirListaVendaDetalhe(listaVendaDetalhe);
        } catch (SQLException ex) {
            Logger.getLogger(BancoVendaDetalhe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public VendaDetalhe consultarVendaDetalhe_porIdVendaDetalhe(int id_venda_detalhe) throws SQLException {
        try {
            ConectaBDVendaDetalhe conexao = new ConectaBDVendaDetalhe();
            return conexao.consultarVendaDetalhe_porIdVendaDetalhe(id_venda_detalhe);
        } catch (SQLException ex) {
            Logger.getLogger(BancoVendaDetalhe.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
