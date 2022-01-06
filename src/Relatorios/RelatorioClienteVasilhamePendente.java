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

/**
 *
 * @author Neto
 */
public class RelatorioClienteVasilhamePendente {

    private final Conexao_relatorios conexao = new Conexao_relatorios();

    public RelatorioClienteVasilhamePendente() {
    }

    public void relatorio() {
        try {
            conexao.conecta();
            conexao.executeSQL("select e.nome_fantasia, e.ie, e.cnpj, c.id as codigoCliente, c.nome as nomeCliente, cv.quantidade as qtd_emprestimo, "
                    + "(select IFNULL(sum(cvd.quantidade_devolvida), 0) from cliente_vasilhame_detalhe cvd where cvd.id_cliente_vasilhame = cv.id) as qtd_devolvida, "
                    + "cv.quantidade - (select IFNULL(sum(cvd.quantidade_devolvida), 0) from cliente_vasilhame_detalhe cvd where cvd.id_cliente_vasilhame = cv.id) as qtd_restante "
                    + "from empresa e, cliente c inner join venda_cabecalho vc ON c.id = vc.cliente_id "
                    + "INNER JOIN venda_detalhe vd ON "
                    + "vc.id = vd.venda_cabecalho_id "
                    + "INNER JOIN cliente_vasilhame cv "
                    + "ON vd.id = cv.id_venda_detalhe WHERE cv.status like 'P'");
            File arquivoExtraido = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_cliente_vasilhame_pendente.jrxml", System.getenv("TMP"));
            JasperDesign desenho = JRXmlLoader.load(arquivoExtraido.getAbsolutePath());
            //compila o relatório 
            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(conexao.resultset);
            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, new HashMap<String, Object>(), jrRS);
            JasperExportManager.exportReportToPdfFile(jasperPrint, System.getenv("TMP") + "vasilhame_pendente.pdf");
            Desktop.getDesktop().open(new File(System.getenv("TMP") + "vasilhame_pendente.pdf"));
            File file = new File(System.getenv("TMP") + "vasilhame_pendente.pdf");
            file.deleteOnExit();
            arquivoExtraido.delete();
        } catch (IOException | SQLException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Deu erro=" + erro);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", erro);
        }
    }

}
