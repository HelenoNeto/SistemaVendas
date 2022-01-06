package Negocios.Controladores;

import Negocios.Empresa;

public interface IControladorEmpresa {

    public void incluirEmpresa(Empresa emitentes);

    public Empresa consultarEmpresa(String query);

    public void atualizarEmpresa(Empresa emitentes);
}
