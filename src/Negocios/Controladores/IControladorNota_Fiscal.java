package Negocios.Controladores;

import Negocios.NotaEntrada;
import java.util.ArrayList;

public interface IControladorNota_Fiscal {

    public void incluirNotaFiscalJDBC(NotaEntrada nota_fiscal);

    public ArrayList<NotaEntrada> consultarNotaFiscalJDBC(String tipo, String dado);

    public ArrayList<NotaEntrada> consultarNotaFiscalQueryJDBC(String query);

    public void editaNotaFiscalJDBC(NotaEntrada nota_fiscal);

    public void excluirNotaFiscalJDBC(NotaEntrada nota_fiscal);
}
