/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

/**
 *
 * @author Administrador
 */
public class BancoLicenca implements IBancoLicenca {

    private static BancoLicenca instancia = null;

    public static BancoLicenca getInstancia() {
        if (instancia == null) {
            instancia = new BancoLicenca();
        }
        return instancia;
    }

}
