package Negocios.Controladores;

import Dados.BancoNotaEntrada;
import Dados.IBancoNotaEntrada;
import Negocios.NotaEntrada;
import java.util.ArrayList;

public class ControladorNota_fiscal implements IControladorNota_Fiscal {

    @Override
    public void incluirNotaFiscalJDBC(NotaEntrada nota_fiscal) {
        IBancoNotaEntrada bancoNotaEntrada = BancoNotaEntrada.getInstancia();
        bancoNotaEntrada.incluirNotaFiscalJDBC(nota_fiscal);
    }

    @Override
    public ArrayList<NotaEntrada> consultarNotaFiscalJDBC(String tipo, String dado) {
        IBancoNotaEntrada bancoNotaEntrada = BancoNotaEntrada.getInstancia();
        return bancoNotaEntrada.consultarNotaFiscalJDBC(tipo, dado);
    }

    @Override
    public ArrayList<NotaEntrada> consultarNotaFiscalQueryJDBC(String query) {
        IBancoNotaEntrada bancoNotaEntrada = BancoNotaEntrada.getInstancia();
        return bancoNotaEntrada.consultarNotaFiscalQueryJDBC(query);
    }

    @Override
    public void editaNotaFiscalJDBC(NotaEntrada nota_fiscal) {
        IBancoNotaEntrada bancoNotaEntrada = BancoNotaEntrada.getInstancia();
        bancoNotaEntrada.editaNotaFiscalJDBC(nota_fiscal);
    }

    @Override
    public void excluirNotaFiscalJDBC(NotaEntrada nota_fiscal) {
        IBancoNotaEntrada bancoNotaEntrada = BancoNotaEntrada.getInstancia();
        bancoNotaEntrada.excluirNotaFiscalJDBC(nota_fiscal);
    }
}
