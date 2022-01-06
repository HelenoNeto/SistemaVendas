package Negocios.Controladores;

import Dados.BancoNotaEntradaProduto;
import Dados.IBancoNotaEntradaProduto;
import Negocios.NotaEntradaProduto;
import java.util.ArrayList;

public class ControladorNotaFiscalProduto implements IControladorNotaProduto {

    @Override
    public void incluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_fiscalProduto) {
        IBancoNotaEntradaProduto bancoNotaEntrada = BancoNotaEntradaProduto.getInstancia();
        bancoNotaEntrada.incluirNotaFiscalProdutoJDBC(nota_fiscalProduto);
    }

    @Override
    public ArrayList consultarNotaFiscalProdutoJDBC(int id_nota_fiscal) {
        IBancoNotaEntradaProduto bancoNotaEntrada = BancoNotaEntradaProduto.getInstancia();
        return bancoNotaEntrada.consultarNotaFiscalProdutoJDBC(id_nota_fiscal);
    }

    @Override
    public void excluirNotaFiscalProdutoJDBC(NotaEntradaProduto nota_fiscalProduto) {
        IBancoNotaEntradaProduto bancoNotaEntrada = BancoNotaEntradaProduto.getInstancia();
        bancoNotaEntrada.excluirNotaFiscalProdutoJDBC(nota_fiscalProduto);
    }

    @Override
    public ArrayList consultarNotaFiscalProdutoQueryJDBC(String query) {
        IBancoNotaEntradaProduto bancoNotaEntrada = BancoNotaEntradaProduto.getInstancia();
        return bancoNotaEntrada.consultarNotaFiscalProdutoQueryJDBC(query);
    }
}
