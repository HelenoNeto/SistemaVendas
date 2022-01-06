/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.ParcelasPagasCliente;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public class BancoParcelasPagasCliente implements IBancoParcelasPagasCliente {

    private static BancoParcelasPagasCliente instancia = null;

    public static BancoParcelasPagasCliente getInstancia() {
        if (instancia == null) {
            instancia = new BancoParcelasPagasCliente();
        }
        return instancia;
    }

    @Override
    public ArrayList<ParcelasPagasCliente> consultarParcelasPagasCliente(int idCliente) {
        ConectaBDParcelasPagasCliente conexao = new ConectaBDParcelasPagasCliente();
        return conexao.consultarParcelasPagasCliente(idCliente);
    }

}
