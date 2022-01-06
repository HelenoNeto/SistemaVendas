/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios.Controladores;

import Negocios.ParcelasPagasCliente;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public interface IControladorParcelasPagasCliente {

    public ArrayList<ParcelasPagasCliente> consultarParcelasPagasCliente(int idCliente);
}
