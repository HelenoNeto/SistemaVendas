package sistema.gas.unidadeProduto.dados;

import sistema.gas.unidadeProduto.negocios.UnidadeProduto;
import java.util.ArrayList;

public interface IBancoUnidadeProduto {

    public void salvar(UnidadeProduto unidadeProduto);

    public ArrayList<UnidadeProduto> consultarPorTipo(String tipo, String dado);

    public UnidadeProduto consultarPorId(int id);

    public void deletar(UnidadeProduto unidadeProduto);

}
