/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.TipoPagamento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public interface IBancoTipoPagamento {

    public void incluirTipoPagamento(TipoPagamento tipoPagamento) throws SQLException;

    public ArrayList consultarTipoPagamento(String query) throws SQLException;

    public TipoPagamento consultarTipoPagamento(int id_tipo_pagamento) throws SQLException;

    public void deletarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException;

    public void editarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException;
}
