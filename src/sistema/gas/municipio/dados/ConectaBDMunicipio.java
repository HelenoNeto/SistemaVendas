/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.municipio.dados;

import Dados.ConectaBD;
import Negocios.Municipios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ConectaBDMunicipio implements IBancoMunicipio {

    private ConectaBD bd = new ConectaBD();
    private PreparedStatement pstm;
    private ResultSet rs;

    public static ConectaBDMunicipio getInstance() {
        return ConectaBDMunicipioHolder.INSTANCE;
    }

    @Override
    public ArrayList<Municipios> consultarMunicipiosTipo(String tipo, String dado) {
        ArrayList lista = new ArrayList();
        Municipios municipios;
        try {
            pstm = bd.getConectacao().prepareStatement("SELECT * FROM Municipios WHERE " + tipo + " LIKE '%" + dado + "%' ORDER BY " + tipo + "");
            rs = pstm.executeQuery();
            while (rs.next()) {
                municipios = new Municipios();
                municipios.setCodigo_cidade(rs.getString("CODIGO_CIDADE"));
                municipios.setCodigo_pais(rs.getString("CODIGO_PAIS"));
                municipios.setCodigo_uf(rs.getString("CODIGO_UF"));
                municipios.setNome(rs.getString("NOME"));
                municipios.setUf(rs.getString("UF"));
                municipios.setId(rs.getInt("ID"));
                lista.add(municipios);
            }
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    @Override
    public ArrayList<Municipios> consultarMunicipiosQuery(String query) {
        ArrayList lista = new ArrayList();
        Municipios municipios;
        try {
            pstm = bd.getConectacao().prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                municipios = new Municipios();
                municipios.setCodigo_cidade(rs.getString("CODIGO_CIDADE"));
                municipios.setCodigo_pais(rs.getString("CODIGO_PAIS"));
                municipios.setCodigo_uf(rs.getString("CODIGO_UF"));
                municipios.setNome(rs.getString("NOME"));
                municipios.setUf(rs.getString("UF"));
                municipios.setId(rs.getInt("ID"));
                lista.add(municipios);
            }
            pstm.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    private static class ConectaBDMunicipioHolder {

        private static final ConectaBDMunicipio INSTANCE = new ConectaBDMunicipio();
    }
}
