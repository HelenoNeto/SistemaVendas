package Relatorios;

import Utilitarios.Dir;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;

public class Conexao_relatorios {

    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://" + Dir.KEY_SERVHOST + "/" + Dir.KEY_DATABASE;
    final private String usuario = Dir.KEY_USUARIO;
    final private String senha = Dir.KEY_SENHA;
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;

    public boolean conecta() {
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + Driver);
            result = false;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Deu erro na conexão "
                    + "com a fonte de dados: " + Fonte);
            result = false;
        }
        return result;
    }

    public void desconecta() {
        boolean result = true;
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null, "banco fechado");
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possivel "
                    + "fechar o banco de dados: " + fecha);
            result = false;
        }
    }

    public Connection getConexao() {
        return conexao;
    }

    public void executeSQL(String sql) throws SQLException {
        try {
            statement = conexao.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (Exception sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi possível "
                    + "executar o comando sql," + sqlex + ", o sql passado foi " + sql);
            throw new SQLException(sqlex);
        }
    }

    JasperReport compilarJRxml(String caminho_arquivo_jrxml) throws JRException {
        return JasperCompileManager.compileReport(caminho_arquivo_jrxml);
    }

    void compilarJRxmlParaArquivo(String caminho_arquivo_jrxml_origem, String caminho_arquivo_jasper_destino) throws JRException {
        JasperCompileManager.compileReportToFile(caminho_arquivo_jrxml_origem, caminho_arquivo_jasper_destino);
    }

    JasperReport compilarJRxml(JasperDesign jasperDesign) throws JRException {
        return JasperCompileManager.compileReport(jasperDesign);
    }

    JasperReport compilarJRxml(InputStream inputStreamJRxml) throws JRException {
        return JasperCompileManager.compileReport(inputStreamJRxml);
    }

    void visualizarRelatorio(JasperReport relatorio, HashMap parametros, JRResultSetDataSource jrRS) throws JRException {
        JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, jrRS);
        view(jasperPrint);
    }

    void visualizarRelatorio(JasperReport relatorio, HashMap parametros, JRBeanCollectionDataSource jrRS) throws JRException {
        JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, jrRS);
        view(jasperPrint);
    }

    private void view(JasperPrint jasperPrint) throws JRException {
        JDialog dialog = new JDialog();
        JasperViewer viewer = new JasperViewer(jasperPrint, false);
        dialog.setTitle("HJSN SISTEMAS - Relatorios - RECIBO");
        dialog.add(viewer.getContentPane());
        dialog.setSize(viewer.getSize());
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setVisible(true);
        viewer.setFitWidthZoomRatio();
    }

    void visualizarRelatorio(String relatorio_compilado, Map<String, Object> parametros) throws JRException {
        JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio_compilado, parametros, conexao);
        view(jasperPrint);
    }
}
