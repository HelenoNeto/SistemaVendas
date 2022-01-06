/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import Negocios.ConfiguracaoJurosParcelasReceber;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Heleno
 */
public class ConectaBDConfiguracaoJurosParcelasReceber {

    private final ConectaBD bd = new ConectaBD();

    public ConfiguracaoJurosParcelasReceber retornaConfiguracaoJurosParcelasReceber(String query) {
        ConfiguracaoJurosParcelasReceber cjpr = null;
        String consultaSQL = query;
        try {
            Statement stm = bd.getConectacao().createStatement();
            ResultSet rs = stm.executeQuery(consultaSQL);
            if (rs.next()) {
                cjpr = new ConfiguracaoJurosParcelasReceber();
                cjpr.setId(rs.getInt("id"));
                cjpr.setTipo_juros(rs.getString("Tipo_juros"));
                cjpr.setValor_juros(rs.getBigDecimal("Valor_juros"));
            }
        } catch (Exception e) {
            Logger.getLogger(ConectaBDConfiguracaoJurosParcelasReceber.class.getName()).log(Level.SEVERE, "Erro", e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return cjpr;
    }

    public ConfiguracaoJurosParcelasReceber incluirConfiguracaoJurosParcelasReceber(ConfiguracaoJurosParcelasReceber cjpr) {
        String consultaSQL
                = "insert into configuracao_juros_parcelas_receber (tipo_juros, valor_juros) values (?,?)";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, cjpr.getTipo_juros());
            pstm.setBigDecimal(2, cjpr.getValor_juros());
            pstm.executeUpdate();

            Statement stm = bd.getConectacao().createStatement();
            ResultSet rs = stm.executeQuery("select max(ID) as ID from configuracao_juros_parcelas_receber");
            rs.first();
            cjpr.setId(rs.getInt("Id"));
            return cjpr;
        } catch (Exception e) {
            Logger.getLogger(ConectaBDConfiguracaoJurosParcelasReceber.class.getName()).log(Level.SEVERE, "Erro", e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void editarConfiguracaoJurosParcelasReceber(ConfiguracaoJurosParcelasReceber cjpr) {
        String consultaSQL
                = "UPDATE configuracao_juros_parcelas_receber set tipo_juros = ?, valor_juros = ? WHERE id = ?";
        try {
            PreparedStatement pstm = bd.getConectacao().prepareStatement(consultaSQL);
            pstm.setString(1, cjpr.getTipo_juros());
            pstm.setBigDecimal(2, cjpr.getValor_juros());
            pstm.setInt(3, cjpr.getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ConectaBDConfiguracaoJurosParcelasReceber.class.getName()).log(Level.SEVERE, "Erro", e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
