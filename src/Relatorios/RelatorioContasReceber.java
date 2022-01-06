/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Negocios.Financeiro;
import Negocios.FinanceiroParcelas;
import Utilitarios.ClasseUtilitaria;
import Utilitarios.CurrencyWriter;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Neto
 */
public class RelatorioContasReceber {

    private final Conexao_relatorios conexao = new Conexao_relatorios();

    public RelatorioContasReceber() {
    }

    public void relatorioContasReceber(String filtro, String busca, String codCliente, String dataInicial, String dataFinal, String tipo) {
        try {
            conexao.conecta();
            String query = null;
            switch (tipo) {
                case "geral":
                    query = "select e.nome_fantasia, e.cnpj, e.ie, cr.id as codigoConta, cr.data_emissao as dataEmissaoConta, "
                            + "cr.referente, cr.documento, cr.valor_total as totalConta, cr.numero_parcelas, "
                            + "cr.entrada entradaConta, c.id as codigoCliente, c.nome as nomeCliente, "
                            + "p.id as codigoParcela, p.lancamento, p.data_vencimento, p.parcela,"
                            + "phr.data_recebimento as dataPagamentoParcela, p.valor as valorParcela, "
                            + "sum(phr.valor_recebido) as valorPagoParcela, p.status as statusParcela from empresa e, contas_receber cr "
                            + "INNER JOIN parcelas_receber p ON cr.id = p.id_contas_receber INNER JOIN cliente c "
                            + "ON c.id = cr.id_cliente LEFT JOIN parcelas_receber_historico_recebimento phr "
                            + "ON p.id = phr.id_parcelas_receber WHERE p.status " + filtro + " and "
                            + "" + busca + " BETWEEN '" + dataInicial + "' and '" + dataFinal + "' "
                            + "and c.id like '" + codCliente + "' and not cr.excluido group by p.id_contas_receber";
                    break;
                case "areceber":
                    query = "select e.nome_fantasia, e.cnpj, e.ie, cr.id as codigoConta, cr.data_emissao as dataEmissaoConta, "
                            + "cr.referente, cr.documento, cr.valor_total as totalConta, cr.numero_parcelas, cr.entrada entradaConta, "
                            + "c.id as codigoCliente, c.nome as nomeCliente, p.id as codigoParcela, p.lancamento, p.data_vencimento, "
                            + "p.parcela, p.valor as valorParcela, p.status as statusParcela, p.valor_pago, "
                            + "p.data_pagamento as dataPagamentoParcela, p.valor_pago as valorPagoParcela "
                            + "from empresa e, contas_receber cr "
                            + "INNER JOIN parcelas_receber p ON cr.id = p.id_contas_receber INNER JOIN cliente c ON c.id = cr.id_cliente "
                            + "WHERE "
                            + "p.status " + filtro + " and " + busca + " "
                            + "BETWEEN '" + dataInicial + "' and '" + dataFinal + "' and c.id like '" + codCliente + "' and not cr.excluido";
                    break;
            }
            conexao.executeSQL(query);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(conexao.resultset);
            JasperPrint jasperPrint = JasperFillManager.fillReport(Utilitarios.Dir.relatorios_antigos + "relatorio_contas_receber.jasper", new HashMap(), jrRS);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            ImageIcon imageIcon = new ImageIcon(Utilitarios.Dir.imagens_internas + "g3automacao.png");
            viewer.setTitle("Relatorios - Relatório de Contas a Receber");
            viewer.setIconImage(imageIcon.getImage());
            viewer.setVisible(true);
        } catch (SQLException | JRException erro) {
            JOptionPane.showMessageDialog(null, "ERROR=" + erro);
            Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, "Erro", erro);
        }
    }

    public void reciboContasReceber(FinanceiroParcelas pr, Financeiro cr) {
        try {
            conexao.conecta();
            conexao.executeSQL("select * from empresa");
            File arquivoExtraido = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_recibo.jrxml", System.getenv("TMP"));
            JasperDesign desenho = JRXmlLoader.load(arquivoExtraido.getAbsolutePath());
            //compila o relatório 
            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(conexao.resultset);
            HashMap parametros = new HashMap();
            parametros.put("nome_fantasia", cr.getCliente().getNome());
            parametros.put("cnpj", cr.getCliente().getCnpj());
            parametros.put("valor", pr.getValor());

            CurrencyWriter cw = CurrencyWriter.getInstance();
            String extenso = cw.write(pr.getValor());
            parametros.put("extenso", extenso);

            parametros.put("referente", cr.getReferente());
            parametros.put("endereco", cr.getCliente().getEndereco());
            parametros.put("numero", cr.getCliente().getNum_end());
            parametros.put("municipio", cr.getCliente().getMunicipio());
            parametros.put("bairro", cr.getCliente().getBairro());
            parametros.put("telefone", cr.getCliente().getTelefone());
            parametros.put("conta", String.valueOf(cr.getId()));
            parametros.put("numeroParcela", pr.getParcela());
            conexao.visualizarRelatorio(relatorio, parametros, jrRS);
            arquivoExtraido.delete();
        } catch (JRException | SQLException ex) {
            Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
