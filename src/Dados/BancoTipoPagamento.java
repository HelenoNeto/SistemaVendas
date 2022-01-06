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
public class BancoTipoPagamento implements IBancoTipoPagamento {

    private static BancoTipoPagamento instancia = null;

    public static BancoTipoPagamento getInstancia() {
        if (instancia == null) {
            instancia = new BancoTipoPagamento();
        }
        return instancia;
    }

    @Override
    public void incluirTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        ConectaBDTipoPagamento conexao = new ConectaBDTipoPagamento();
        conexao.incluirTipoPagamento(tipoPagamento);
    }

    @Override
    public ArrayList consultarTipoPagamento(String query) throws SQLException {
        ConectaBDTipoPagamento conexao = new ConectaBDTipoPagamento();
        return conexao.consultarTipoPagamento(query);
    }

    @Override
    public void deletarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        ConectaBDTipoPagamento conexao = new ConectaBDTipoPagamento();
        conexao.deletarTipoPagamento(tipoPagamento);
    }

    @Override
    public void editarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        ConectaBDTipoPagamento conexao = new ConectaBDTipoPagamento();
        conexao.editarTipoPagamento(tipoPagamento);
    }

    @Override
    public TipoPagamento consultarTipoPagamento(int id_tipo_pagamento) throws SQLException {
        ConectaBDTipoPagamento conexao = new ConectaBDTipoPagamento();
        return conexao.consultarTipoPagamento(id_tipo_pagamento);
    }

}
