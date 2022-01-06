package Negocios.Controladores;

import Dados.BancoEmpresa;
import Dados.IBancoEmpresa;
import Negocios.Empresa;

public class ControladorEmpresa implements IControladorEmpresa {

    @Override
    public void incluirEmpresa(Empresa emitentes) {
        IBancoEmpresa bancoEmpresa = BancoEmpresa.getInstancia();
        bancoEmpresa.incluirEmpresa(emitentes);
    }

    @Override
    public Empresa consultarEmpresa(String query) {
        IBancoEmpresa bancoEmpresa = BancoEmpresa.getInstancia();
        return bancoEmpresa.consultarEmpresa(query);
    }

    @Override
    public void atualizarEmpresa(Empresa emitentes) {
        IBancoEmpresa bancoEmpresa = BancoEmpresa.getInstancia();
        bancoEmpresa.atualizarEmpresa(emitentes);
    }

}
