/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Grupo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public interface IBancoGrupo {

    public void incluirGrupo(Grupo grupo) throws SQLException;

    public void editarGrupo(Grupo grupo) throws SQLException;

    public ArrayList consultarGrupo(String query) throws SQLException;

    public void excluirGrupo(Grupo grupo) throws SQLException;

    public int retornoAutoIncrementGrupo() throws SQLException;

    public void alterarGrupoExclusao(Grupo grupo) throws SQLException;
}
