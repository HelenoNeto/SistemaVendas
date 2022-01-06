/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios.Controladores;

import Negocios.VendaCabecalho;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public interface IControladorVendaCabecalho {

    public VendaCabecalho incluirVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException;

    public void editarVendaCabecalho(VendaCabecalho vendaCabecalho) throws SQLException;

    public ArrayList consultarVendaCabecalho(String query) throws SQLException;

    public void excluirVendaCabecalho(VendaCabecalho vendaCabecalho);

    public void exclusaoLogicaVendaCabecalho(VendaCabecalho vendaCabecalho);

}
