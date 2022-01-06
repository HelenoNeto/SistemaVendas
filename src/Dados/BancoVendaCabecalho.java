/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.VendaCabecalho;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neto
 */
public class BancoVendaCabecalho implements IBancoVendaCabecalho {

    private static BancoVendaCabecalho instancia = null;

    public static BancoVendaCabecalho getInstancia() {
        if (instancia == null) {
            instancia = new BancoVendaCabecalho();
        }
        return instancia;
    }

    @Override
    public VendaCabecalho incluirVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        ConectaBDVendaCabecalho conexao = new ConectaBDVendaCabecalho();
        return conexao.incluirVendaCabecalho(vendaCabecalho);
    }

    @Override
    public void editarVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        ConectaBDVendaCabecalho conexao = new ConectaBDVendaCabecalho();
        conexao.editarVendaCabecalho(vendaCabecalho);
    }

    @Override
    public ArrayList consultarVendaCabecalho(String query) throws SQLException {
        ConectaBDVendaCabecalho conexao = new ConectaBDVendaCabecalho();
        return conexao.consultarVendaCabecalho(query);
    }

    @Override
    public void excluirVendaCabecalho(VendaCabecalho vendaCabecalho) {
        try {
            ConectaBDVendaCabecalho conexao = new ConectaBDVendaCabecalho();
            conexao.excluirVendaCabecalho(vendaCabecalho);
        } catch (SQLException ex) {
            Logger.getLogger(BancoVendaCabecalho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void exclusaoLogicaVendaCabecalho(VendaCabecalho vendaCabecalho) {
        try {
            ConectaBDVendaCabecalho conexao = new ConectaBDVendaCabecalho();
            conexao.exclusaoLogicaVendaCabecalho(vendaCabecalho);
        } catch (SQLException ex) {
            Logger.getLogger(BancoVendaCabecalho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
