package Relatorios;

import Utilitarios.ClasseUtilitaria;
import Utilitarios.Dir;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
import net.sf.jasperreports.view.JasperViewer;
import sistema.gas.SISTEMA_GAS;
import static sistema.gas.SISTEMA_GAS._EMPRESA_LOGADA;

public class RelatorioVenda {

    private final Conexao_relatorios conexao = new Conexao_relatorios();

    public void relatorioVenda(int idVenda, int id_contas_receber) {
        try {
            conexao.conecta();
//            conexao.executeSQL("select vc.id as codigoVenda, date_format(vc.data_venda, '%d/%m/%Y') as dataVenda, "
//                    + "date_format(vc.data_venda, '%H:%i:%S') as horaVenda, vc.acrescimo, vc.desconto, vc.subtotal as subTotalVenda, "
//                    + "vc.tipo_acrescimo, vc.tipo_desconto, vc.total, e.razao_social as razaoEmpresa, e.nome_fantasia as nomeFantasiaEmpresa, "
//                    + "e.telefone as telefoneEmpresa, e.endereco as enderecoEmpresa, e.num_end as numEndEmpresa, e.bairro as bairroEmpresa, "
//                    + "e.municipio as municipioEmpresa, e.cep as cepEmpresa, e.cnpj as cnpjEmpresa, c.id as codigoCliente, c.nome as nomeCliente, "
//                    + "c.endereco as enderecoCliente, c.num_end as numEndCliente, c.bairro as bairroCliente, c.cep as cepCliente, "
//                    + "c.telefone as telefoneCliente, c.cnpj as cnpjCliente, c.cpf as cfpCliente, c.comp_end as compEndCliente, "
//                    + "c.municipio as municipioCliente, c.uf as ufCliente, p.codigo as codigoProduto, p.descricao as descricaoProduto, "
//                    + "vd.quantidade as quantidadeVenda, vd.valor_unitario as valorunitarioProduto, vd.valor_total as valorTotalProduto, "
//                    + "vd.qtd_vasilhame_pendente, f.id as codigoFuncionario, f.nome as nomeFuncionario, tp.id as codigoTipoPagamento, "
//                    + "tp.descricao as descricaoTipoPagamento from empresa e, venda_cabecalho vc "
//                    + "INNER JOIN venda_detalhe vd ON vc.id = vd.venda_cabecalho_id INNER JOIN cliente c ON vc.cliente_id = c.id "
//                    + "INNER JOIN funcionario f ON vc.funcionario_id = f.id INNER JOIN produto p ON vd.produto_id = p.id "
//                    + "INNER JOIN tipo_pagamento tp ON vc.tipo_pagamento_id = tp.id where vc.id = " + idVenda);
            File arquivoExtraido = new ClasseUtilitaria().estrairArquivo("/ireport/venda.jrxml", System.getenv("TMP"));
            File arquivoSubExtraido = new ClasseUtilitaria().estrairArquivo("/ireport/venda_parcelas_subreport.jasper", System.getenv("TMP"));
            File arquivoCompilado = new File(System.getenv("TMP") + "/ireport/venda.jasper");
            conexao.compilarJRxmlParaArquivo(arquivoExtraido.getAbsolutePath(), arquivoCompilado.getAbsolutePath());
//            JasperDesign desenho = JRXmlLoader.load(arquivoExtraido.getAbsolutePath());
            //compila o relatório 
//            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
//            JRResultSetDataSource jrRS = new JRResultSetDataSource(conexao.resultset);
            HashMap parametros = new HashMap();
            parametros.put("idVenda", idVenda);
            parametros.put("NomeFantasia", _EMPRESA_LOGADA.getNome_fantasia());
            parametros.put("SUBREPORT_DIR", System.getenv("TMP") + "/ireport/");
            parametros.put("id_contas_receber", id_contas_receber);
            parametros.put("tipoSistema", Dir.KEY_TIPO_SISTEMA);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, jrRS);
//            JasperExportManager.exportReportToPdfFile(jasperPrint, System.getenv("TMP") + "venda.pdf");
//            Desktop.getDesktop().open(new File(System.getenv("TMP") + "venda.pdf"));
//            File file = new File(System.getenv("TMP") + "venda.pdf");
            conexao.visualizarRelatorio(arquivoCompilado.getAbsolutePath(), parametros);
//            file.deleteOnExit();
            arquivoExtraido.delete();
            arquivoSubExtraido.delete();
            arquivoCompilado.delete();
        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "Deu erro=" + erro);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", erro);
        }
    }

    public void relatorioViaCliente(int idVenda) {
        try {
            conexao.conecta();
            conexao.executeSQL("select vc.data_venda, "
                    + "vc.id as codigoVenda, vd.produto_id, vd.quantidade, vd.valor_total, vd.valor_unitario, "
                    + "p.descricao, c.id as codigoCliente, c.nome "
                    + " from venda_cabecalho vc inner join venda_detalhe vd on vc.id = vd.venda_cabecalho_id "
                    + "inner join produto p on vd.produto_id = p.id "
                    + "inner join cliente c on vc.cliente_id = c.id "
                    + "where vc.id = " + idVenda);
            File arquivoExtraido = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_comprovante_venda_cliente.jrxml", System.getenv("TMP"));
            JasperDesign desenho = JRXmlLoader.load(arquivoExtraido.getAbsolutePath());
            //compila o relatório 
            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(conexao.resultset);
            HashMap parametros = new HashMap();
            parametros.put("NomeFantasia", _EMPRESA_LOGADA.getNome_fantasia());
            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, jrRS);
            JasperExportManager.exportReportToPdfFile(jasperPrint, System.getenv("TMP") + "venda_via_cliente.pdf");
            Desktop.getDesktop().open(new File(System.getenv("TMP") + "venda_via_cliente.pdf"));
            File file = new File(System.getenv("TMP") + "venda_via_cliente.pdf");
            file.deleteOnExit();
            arquivoExtraido.delete();
        } catch (IOException | SQLException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Deu erro=" + erro);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", erro);
        }
    }

    public void relatorioFechamentoVendas(Date dataInicial, Date dataFinal) throws IOException {
        try {
            SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fmtDateBrasil = new SimpleDateFormat("dd/MM/yyyy");
            conexao.conecta();
            String query = "select e.nome_fantasia as nomeEmpresa, vc.id as codigoVenda, c.id as codigoCliente, c.nome as nomeCliente, "
                    + "f.id as codigoVendedor, f.nome as nomeVendedor, tp.id as codigoTipoPagamento, tp.descricao as descricaoTipoPagamento,"
                    + "date_format(vc.data_venda, '%d/%m/%Y %H:%i:%S') as dataHoraVeda,"
                    + "vc.acrescimo, vc.desconto, vc.subtotal, vc.total, vc.tipo_acrescimo, "
                    + "vc.tipo_desconto "
                    + "from empresa e, venda_cabecalho vc inner join cliente c on vc.cliente_id = c.id "
                    + "inner join funcionario f on vc.funcionario_id = f.id "
                    + "inner join tipo_pagamento tp on vc.tipo_pagamento_id = tp.id "
                    + "where date_format(vc.data_venda, '%Y-%m-%d') between '" + fmtDate.format(dataInicial) + "' and '" + fmtDate.format(dataFinal) + "' "
                    + "and not vc.excluido order by vc.tipo_pagamento_id, vc.data_venda";
            conexao.executeSQL(query);
            HashMap param = new HashMap();
            param.put("periodo", fmtDateBrasil.format(dataInicial) + " à " + fmtDateBrasil.format(dataFinal));
            JRResultSetDataSource jrRS = new JRResultSetDataSource(conexao.resultset);
            JasperPrint jasperPrint = JasperFillManager.fillReport(Utilitarios.Dir.relatorios_antigos + "relatorio_vendas.jasper", param, jrRS);
//            JasperViewer viewer = new JasperViewer(jasperPrint, false);
//            ImageIcon imageIcon = new ImageIcon(Utilitarios.Dir.imagens_internas + "g3automacao.png");
//            viewer.setTitle("Relatorios - Relatório de Vendas");
//            viewer.setIconImage(imageIcon.getImage());
//            viewer.setVisible(true);
            JasperExportManager.exportReportToPdfFile(jasperPrint, System.getenv("TMP") + "arquivo.pdf");
            Desktop.getDesktop().open(new File(System.getenv("TMP") + "arquivo.pdf"));
            File file = new File(System.getenv("TMP") + "arquivo.pdf");
            file.deleteOnExit();
        } catch (SQLException | JRException erro) {
            JOptionPane.showMessageDialog(null, "ERROR=" + erro);
            Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, "Erro", erro);
        }
    }

    public void relatorioFechamentoVendasAnalitico(Date dataInicial, Date dataFinal) throws IOException {
        try {
            SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fmtDateBrasil = new SimpleDateFormat("dd/MM/yyyy");
            conexao.conecta();
            String query = "select vc.id as codigoVenda, c.id as codigoCliente, c.nome as nomeCliente, f.id as codigoVendedor, "
                    + "f.nome as nomeVendedor, tp.id as codigoTipoPagamento, tp.descricao as descricaoTipoPagamento, "
                    + "date_format(vc.data_venda, '%d/%m/%Y %H:%i:%S') as dataHoraVeda,vc.acrescimo, vc.desconto, vc.subtotal, "
                    + "vc.total, p.codigo, p.descricao descricaoProduto, vd.valor_unitario, vd.quantidade, vd.valor_total, vc.tipo_acrescimo, "
                    + "vc.tipo_desconto "
                    + "from venda_cabecalho vc inner join cliente c on vc.cliente_id = c.id "
                    + "inner join venda_detalhe vd on vc.id = vd.venda_cabecalho_id "
                    + "inner join produto p on vd.produto_id = p.id "
                    + "inner join funcionario f on vc.funcionario_id = f.id "
                    + "inner join tipo_pagamento tp on vc.tipo_pagamento_id = tp.id "
                    + "where "
                    + "date_format(vc.data_venda, '%Y-%m-%d') between '" + fmtDate.format(dataInicial) + "' and '" + fmtDate.format(dataFinal) + "' "
                    + "and not vc.excluido order by vc.tipo_pagamento_id;";
            conexao.executeSQL(query);
            HashMap param = new HashMap();
            param.put("periodo", fmtDateBrasil.format(dataInicial) + " à " + fmtDateBrasil.format(dataFinal));
            param.put("nomeEmpresa", SISTEMA_GAS._EMPRESA_LOGADA.getNome_fantasia());
            JRResultSetDataSource jrRS = new JRResultSetDataSource(conexao.resultset);
            JasperPrint jasperPrint = JasperFillManager.fillReport(Utilitarios.Dir.relatorios_antigos + "relatorio_vendas_analitico.jasper", param, jrRS);
//            JasperViewer viewer = new JasperViewer(jasperPrint, false);
//            ImageIcon imageIcon = new ImageIcon(Utilitarios.Dir.imagens_internas + "g3automacao.png");
//            viewer.setTitle("Relatorios - Relatório de Vendas");
//            viewer.setIconImage(imageIcon.getImage());
//            viewer.setVisible(true);
            JasperExportManager.exportReportToPdfFile(jasperPrint, System.getenv("TMP") + "arquivo.pdf");
            Desktop.getDesktop().open(new File(System.getenv("TMP") + "arquivo.pdf"));
            File file = new File(System.getenv("TMP") + "arquivo.pdf");
            file.deleteOnExit();
        } catch (SQLException | JRException erro) {
            JOptionPane.showMessageDialog(null, "ERROR=" + erro);
            Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, "Erro", erro);
        }
    }

    public void relatorioLucroDatas(Date dataInicial, Date dataFinal) {
        try {
            SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
            conexao.conecta();
            conexao.executeSQL("SELECT\n"
                    + "                concat(p.codigo, ' - ', p.descricao) AS produto                ,\n"
                    + "        ROUND(vd.valor_unitario_compra,2)            AS ValorCompraProduto     ,\n"
                    + "        ROUND(p.lucro,2)                             AS lucroProduto           ,\n"
                    + "        ((vd.valor_unitario-vd.valor_unitario_compra)/vd.valor_unitario_compra),\n"
                    + "        ROUND(vd.valor_unitario,2)                                                                          AS valorVendaProduto                        ,\n"
                    + "        ROUND(SUM(vd.quantidade),2)                                                                         AS quantidadeTotal                          ,\n"
                    + "        ROUND((vd.valor_unitario * SUM(vd.quantidade)), 2)                                                     valorTotalProduto                        ,\n"
                    + "        ROUND(vd.valor_total * (((vd.valor_unitario-vd.valor_unitario_compra)/vd.valor_unitario_compra)),2) AS lucroTotal\n"
                    + "FROM\n"
                    + "        venda_cabecalho vc\n"
                    + "INNER JOIN\n"
                    + "        venda_detalhe vd\n"
                    + "ON\n"
                    + "        vc.id = vd.venda_cabecalho_id\n"
                    + "INNER JOIN\n"
                    + "        produto p\n"
                    + "ON\n"
                    + "        vd.produto_id = p.id\n"
                    + "INNER JOIN\n"
                    + "        tipo_pagamento tp\n"
                    + "ON\n"
                    + "        vc.tipo_pagamento_id = tp.id\n"
                    + "INNER JOIN\n"
                    + "        funcionario f\n"
                    + "ON\n"
                    + "        vc.funcionario_id = f.id\n"
                    + "WHERE\n"
                    + "        date_format(vc.data_venda, '%Y-%m-%d') BETWEEN '" + fmtDate.format(dataInicial) + "' and '" + fmtDate.format(dataFinal) + "'\n"
                    + "GROUP BY\n"
                    + "        p.id,\n"
                    + "        vd.valor_unitario; ");
            File arquivoExtraido = new ClasseUtilitaria().estrairArquivo("/ireport/relatorio_lucro.jrxml", System.getenv("TMP"));
            JasperDesign desenho = JRXmlLoader.load(arquivoExtraido.getAbsolutePath());
            //compila o relatório 
            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(conexao.resultset);
            HashMap parametros = new HashMap();
            parametros.put("NomeFantasia", _EMPRESA_LOGADA.getNome_fantasia());
            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, jrRS);

            Object[] opcao = {"PDF", "Visualizador"};
            int c = JOptionPane.showOptionDialog(
                    null, "Escolha o tipo de impressão!", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opcao, opcao[1]);
            if (c == 0) {
                JasperExportManager.exportReportToPdfFile(jasperPrint, System.getenv("TMP") + "lucro.pdf");
                Desktop.getDesktop().open(new File(System.getenv("TMP") + "lucro.pdf"));
                File file = new File(System.getenv("TMP") + "lucro.pdf");
                file.deleteOnExit();
                arquivoExtraido.delete();
            } else if (c == 1) {
                JasperViewer viewer = new JasperViewer(jasperPrint, false);
                ImageIcon imageIcon = new ImageIcon(Utilitarios.Dir.imagens_internas + "g3automacao.png");
                viewer.setTitle("Relatorios - Relatório de lucro por período");
                viewer.setIconImage(imageIcon.getImage());
                viewer.setVisible(true);
            }
        } catch (IOException | SQLException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Deu erro=" + erro);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", erro);
        }
    }
}
