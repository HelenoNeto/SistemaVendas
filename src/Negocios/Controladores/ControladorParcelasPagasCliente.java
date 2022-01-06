/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios.Controladores;

import Dados.BancoParcelasPagasCliente;
import Dados.IBancoParcelasPagasCliente;
import Negocios.ParcelasPagasCliente;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public class ControladorParcelasPagasCliente implements IControladorParcelasPagasCliente {

    @Override
    public ArrayList<ParcelasPagasCliente> consultarParcelasPagasCliente(int idCliente) {
        IBancoParcelasPagasCliente bancoParcelasPagasCliente = BancoParcelasPagasCliente.getInstancia();
        return bancoParcelasPagasCliente.consultarParcelasPagasCliente(idCliente);
    }

}
