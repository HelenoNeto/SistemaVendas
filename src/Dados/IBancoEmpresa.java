/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.Empresa;

/**
 *
 * @author Administrador
 */
public interface IBancoEmpresa {

    public void incluirEmpresa(Empresa emitentes);

    public Empresa consultarEmpresa(String query);

    public void atualizarEmpresa(Empresa emitentes);
}
