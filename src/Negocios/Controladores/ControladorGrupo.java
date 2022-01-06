package Negocios.Controladores;

import Dados.BancoGrupo;
import Dados.IBancoGrupo;
import Negocios.Grupo;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorGrupo implements IControladorGrupo {

    @Override
    public void incluirGrupo(Grupo grupo) throws SQLException {
        IBancoGrupo iBancoGrupo = BancoGrupo.getInstancia();
        iBancoGrupo.incluirGrupo(grupo);
    }

    @Override
    public void editarGrupo(Grupo grupo) throws SQLException {
        IBancoGrupo iBancoGrupo = BancoGrupo.getInstancia();
        iBancoGrupo.editarGrupo(grupo);
    }

    @Override
    public ArrayList consultarGrupo(String query) throws SQLException {
        IBancoGrupo iBancoGrupo = BancoGrupo.getInstancia();
        return iBancoGrupo.consultarGrupo(query);
    }

    @Override
    public void excluirGrupo(Grupo grupo) throws SQLException {
        IBancoGrupo iBancoGrupo = BancoGrupo.getInstancia();
        iBancoGrupo.excluirGrupo(grupo);
    }

    @Override
    public int retornoAutoIncrementGrupo() throws SQLException {
        IBancoGrupo iBancoGrupo = BancoGrupo.getInstancia();
        return iBancoGrupo.retornoAutoIncrementGrupo();
    }

    @Override
    public void alterarGrupoExclusao(Grupo grupo) throws SQLException {
        IBancoGrupo iBancoGrupo = BancoGrupo.getInstancia();
        iBancoGrupo.alterarGrupoExclusao(grupo);
    }
}
