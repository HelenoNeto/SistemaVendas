/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.municipio.dados;

import Negocios.Municipios;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public interface IBancoMunicipio {

    public ArrayList<Municipios> consultarMunicipiosTipo(String tipo, String dado);

    public ArrayList<Municipios> consultarMunicipiosQuery(String query);
}
