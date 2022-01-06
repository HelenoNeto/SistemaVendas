package Negocios.Controladores;

import Negocios.NotaEntradaProduto;
import java.util.ArrayList;

public interface IControladorNotaProduto {

    public void incluirNotaFiscalProdutoJDBC(NotaEntradaProduto NotaEntradaProduto);

    public ArrayList consultarNotaFiscalProdutoJDBC(int id_nota_fiscal);

    public void excluirNotaFiscalProdutoJDBC(NotaEntradaProduto NotaEntradaProduto);

    public ArrayList consultarNotaFiscalProdutoQueryJDBC(String query);
}
