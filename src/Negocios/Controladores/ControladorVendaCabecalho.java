/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios.Controladores;

import Dados.BancoVendaCabecalho;
import Dados.IBancoVendaCabecalho;
import Negocios.VendaCabecalho;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public class ControladorVendaCabecalho implements IControladorVendaCabecalho {

    @Override
    public VendaCabecalho incluirVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        IBancoVendaCabecalho bancoVendaCabecalho = BancoVendaCabecalho.getInstancia();
        return bancoVendaCabecalho.incluirVendaCabecalho(vendaCabecalho);
    }

    @Override
    public void editarVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException {
        IBancoVendaCabecalho bancoVendaCabecalho = BancoVendaCabecalho.getInstancia();
        bancoVendaCabecalho.editarVendaCabecalho(vendaCabecalho);
    }

    @Override
    public ArrayList consultarVendaCabecalho(String query) throws SQLException {
        IBancoVendaCabecalho bancoVendaCabecalho = BancoVendaCabecalho.getInstancia();
        return bancoVendaCabecalho.consultarVendaCabecalho(query);
    }

    @Override
    public void excluirVendaCabecalho(VendaCabecalho vendaCabecalho) {
        IBancoVendaCabecalho bancoVendaCabecalho = BancoVendaCabecalho.getInstancia();
        bancoVendaCabecalho.excluirVendaCabecalho(vendaCabecalho);
    }

    @Override
    public void exclusaoLogicaVendaCabecalho(VendaCabecalho vendaCabecalho) {
        IBancoVendaCabecalho bancoVendaCabecalho = BancoVendaCabecalho.getInstancia();
        bancoVendaCabecalho.exclusaoLogicaVendaCabecalho(vendaCabecalho);
    }

}
