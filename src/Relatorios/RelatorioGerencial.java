/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Utilitarios.ClasseUtilitaria;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import static sistema.gas.SISTEMA_GAS._EMPRESA_LOGADA;
import tutorialrelatorios.jdbc.ConnectionFactory;

/**
 *
 * @author Neto
 */
public class RelatorioGerencial {

    private final Conexao_relatorios conexao = new Conexao_relatorios();

    public void relatorioGerencial() {
        File arquivoSub1 = null, arquivoSub2 = null, arquivoSub3 = null, arquivoSub4 = null, arquivoPai = null, arquivoCompilado = null, arquivoSub5 = null;
        try {
            arquivoSub1 = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_gerencial_subreport_contas_receber.jasper", System.getenv("TMP"));
            arquivoSub2 = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_gerencial_subreport_lucro.jasper", System.getenv("TMP"));
            arquivoSub3 = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_gerencial_subreport_visita_cliente.jasper", System.getenv("TMP"));
            arquivoSub4 = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_gerencial_subreport_cliente_vasilhame_pendente.jasper", System.getenv("TMP"));
            arquivoSub5 = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_gerencial_subreport_estoque.jasper", System.getenv("TMP"));
            arquivoPai = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_gerencial.jrxml", System.getenv("TMP"));
            arquivoCompilado = new File(System.getenv("TMP") + "/ireport/relatorio_gerencial.jasper");
            conexao.compilarJRxmlParaArquivo(arquivoPai.getAbsolutePath(), arquivoCompilado.getAbsolutePath());
            try (InputStream inputStream = new FileInputStream(arquivoCompilado.getAbsolutePath())) {
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("SUBREPORT_DIR", System.getenv("TMP") + "/ireport/");
                tutorialrelatorios.util.ReportUtils.openReport("Relatório Gerencial", inputStream, parametros,
                        ConnectionFactory.getConnection());
            }
            arquivoPai.delete();
            arquivoSub1.delete();
            arquivoSub2.delete();
            arquivoSub3.delete();
            arquivoSub4.delete();
            arquivoSub5.delete();
            arquivoCompilado.delete();
        } catch (IOException | SQLException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Deu erro=" + erro);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", erro);
            arquivoPai.delete();
            arquivoSub1.delete();
            arquivoSub2.delete();
            arquivoSub3.delete();
            arquivoSub4.delete();
            arquivoSub5.delete();
            arquivoCompilado.delete();
        }
    }

    public void relatorioVisitaDeCliente() {
        try {
            File arquivoPai = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_visita_cliente.jrxml", System.getenv("TMP"));
            File arquivoCompilado = new File(System.getenv("TMP") + "/ireport/relatorio_visita_cliente.jasper");
            conexao.compilarJRxmlParaArquivo(arquivoPai.getAbsolutePath(), arquivoCompilado.getAbsolutePath());
            try (InputStream inputStream = new FileInputStream(arquivoCompilado.getAbsolutePath())) {
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("NomeFantasia", _EMPRESA_LOGADA.getNome_fantasia());

                tutorialrelatorios.util.ReportUtils.openReport("Relatório Visita de Cliente", inputStream, parametros,
                        ConnectionFactory.getConnection());
            }
            arquivoPai.delete();
            arquivoCompilado.delete();
        } catch (IOException | SQLException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Deu erro=" + erro);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", erro);
        }
    }

}
