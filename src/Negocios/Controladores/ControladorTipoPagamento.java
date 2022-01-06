package Negocios.Controladores;

import Dados.BancoTipoPagamento;
import Dados.IBancoTipoPagamento;
import Negocios.TipoPagamento;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorTipoPagamento implements IControladorTipoPagamento {

    @Override
    public void incluirTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        IBancoTipoPagamento bancoTipoPagamento = BancoTipoPagamento.getInstancia();
        bancoTipoPagamento.incluirTipoPagamento(tipoPagamento);
    }

    @Override
    public ArrayList consultarTipoPagamento(String query) throws SQLException {
        IBancoTipoPagamento bancoTipoPagamento = BancoTipoPagamento.getInstancia();
        return bancoTipoPagamento.consultarTipoPagamento(query);
    }

    @Override
    public void deletarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        IBancoTipoPagamento bancoTipoPagamento = BancoTipoPagamento.getInstancia();
        bancoTipoPagamento.deletarTipoPagamento(tipoPagamento);
    }

    @Override
    public void editarTipoPagamento(TipoPagamento tipoPagamento) throws SQLException {
        IBancoTipoPagamento bancoTipoPagamento = BancoTipoPagamento.getInstancia();
        bancoTipoPagamento.editarTipoPagamento(tipoPagamento);
    }

    @Override
    public TipoPagamento consultarTipoPagamento(int id_tipo_pagamento) throws SQLException {
        IBancoTipoPagamento bancoTipoPagamento = BancoTipoPagamento.getInstancia();
        return bancoTipoPagamento.consultarTipoPagamento(id_tipo_pagamento);
    }
}
