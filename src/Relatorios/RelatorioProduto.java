/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Utilitarios.ClasseUtilitaria;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import static sistema.gas.SISTEMA_GAS._EMPRESA_LOGADA;

/**
 *
 * @author Neto
 */
public class RelatorioProduto {

    private final Conexao_relatorios conexao = new Conexao_relatorios();

    public void relatorioEstoque() throws IOException {
        try {
            conexao.conecta();
            conexao.executeSQL("select p.codigo, p.descricao, p.qtd_estoque, p.valor_compra, p.valor_venda from produto p where not p.excluido");
            //gerando o jasper design
            File arquivoPai = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_estoque.jrxml", System.getenv("TMP"));
            JasperDesign desenho = JRXmlLoader.load(arquivoPai.getAbsolutePath());
            //compila o relatório 
            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(conexao.resultset);
            HashMap parametros = new HashMap();
            parametros.put("NomeFantasia", _EMPRESA_LOGADA.getNome_fantasia());
            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, jrRS);
            JasperExportManager.exportReportToPdfFile(jasperPrint, System.getenv("TMP") + "estoque.pdf");
            Desktop.getDesktop().open(new File(System.getenv("TMP") + "estoque.pdf"));
            File file = new File(System.getenv("TMP") + "estoque.pdf");
            file.deleteOnExit();
            arquivoPai.delete();
        } catch (SQLException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Deu erro=" + erro);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", erro);
        }
    }

}
