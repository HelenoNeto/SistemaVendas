/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios.Controladores;

import Negocios.TipoPagamento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public interface IControladorTipoPagamento {

    public void incluirTipoPagamento(TipoPagamento tipoPagamento) throws SQLException;

    public ArrayList consultarTipoPagamento(String query) throws SQLException;

    public TipoPagamento consultarTipoPagamento(int id_tipo_pagamento) throws SQLException;

    public void deletarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException;

    public void editarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException;
}
