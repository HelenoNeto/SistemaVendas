package GUI;

import Dados.ConectaBDProduto;
import Negocios.Cliente;
import Negocios.Produto;
import Negocios.VendaCabecalho;
import Negocios.VendaDetalhe;
import SUPORTE.exceptions.DadoInvalidoException;
import Utilitarios.ClasseUtilitaria;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import Utilitarios.Dir;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.gas.SISTEMA_GAS;

public class CupomNaoFiscal {

    private static final String tracos = "------------------------------------------";

    public static void abreCupom(VendaCabecalho vendaCabecalho) throws FileNotFoundException {

        FileOutputStream outputFile;

        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        try (PrintWriter out = new PrintWriter(outputFile)) {
            out.println(tracos);
            out.println("           " + SISTEMA_GAS._EMPRESA_LOGADA.getNome_fantasia() + ((SISTEMA_GAS._EMPRESA_LOGADA.getTelefone() != null && !SISTEMA_GAS._EMPRESA_LOGADA.getTelefone().isEmpty()) ? " - " + SISTEMA_GAS._EMPRESA_LOGADA.getTelefone() : ""));
            out.println(tracos);
            out.println("                VENDA");
            out.println(tracos);
            out.println("DOCUMENTO: " + vendaCabecalho.getId());
            out.println("     NOME: " + ClasseUtilitaria.decompose(vendaCabecalho.getCliente().getNome()));
            out.println(" CPF/CNPJ: " + vendaCabecalho.getCliente().getCpf());
            out.println(" ENDERECO: " + ClasseUtilitaria.decompose(vendaCabecalho.getCliente().getEndereco()) + ", " + vendaCabecalho.getCliente().getNum_end()
                    + " - " + ClasseUtilitaria.decompose(vendaCabecalho.getCliente().getBairro()) + " - " + vendaCabecalho.getCliente().getCep() + " - "
                    + ClasseUtilitaria.decompose(vendaCabecalho.getCliente().getMunicipio()) + " - " + vendaCabecalho.getCliente().getUf());
            out.println(tracos);
            out.println(" CODIGO              DESCRICAO                      ");
            out.println(" QTDE      X      VALOR UNIT          TOTAL");
            out.println(tracos);
            out.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void vendeItem(String cod, String descricao, String quantidade,
            String valorUni, String valorTotal) throws FileNotFoundException {
        FileOutputStream outputFile;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        try (
                PrintWriter out = new PrintWriter(outputFile)) {
            out.println(cod + "    " + descricao);
            out.println("    " + quantidade + "    X    " + valorUni + "             " + valorTotal);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void relatorioEstoque() throws FileNotFoundException {
        FileOutputStream outputFile;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        try (
                PrintWriter out = new PrintWriter(outputFile)) {
            out.println(tracos);
            out.println("           " + SISTEMA_GAS._EMPRESA_LOGADA.getNome_fantasia() + ((SISTEMA_GAS._EMPRESA_LOGADA.getTelefone() != null && !SISTEMA_GAS._EMPRESA_LOGADA.getTelefone().isEmpty()) ? " - " + SISTEMA_GAS._EMPRESA_LOGADA.getTelefone() : ""));
            out.println(tracos);
            out.println("                VENDA");
            out.println(tracos);
            out.println("Código Descrição        Est.  V.Comp.  V.Venda");
            ArrayList<Produto> listaEstoque = ConectaBDProduto.getInstance().consultarProduto("select * from produto p where not p.excluido");
            for (Produto p : listaEstoque) {
                out.println(p.getCodigo() + "  " + (p.getDescricao().length() > 17 ? p.getDescricao().substring(0, 17) : p.getDescricao()) + "  " + p.getQtd_estoque() + "  " + p.getValor_compra() + "  " + p.getValor_venda());
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void fechaCupom(VendaCabecalho vendaCabecalho, String mensagem) throws IOException, FileNotFoundException {
        FileOutputStream outputFile;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        try (PrintWriter out = new PrintWriter(outputFile)) {
            out.println(tracos);
            out.println("    TIPO PGTO:                  " + vendaCabecalho.getTipoPagamento().getDescricao().toUpperCase());
            out.println("     SUBTOTAL:                  R$ " + ClasseUtilitaria.fmtBig(vendaCabecalho.getSubtotal(), 2));
            out.println("  DESCONTO(-):                  " + verificar(vendaCabecalho.getDesconto(), vendaCabecalho.getTipo_desconto()));
            out.println(" ACRESCIMO(+):                  " + verificar(vendaCabecalho.getAcrescimo(), vendaCabecalho.getTipo_acrescimo()));
            out.println("        TOTAL:                  R$ " + ClasseUtilitaria.fmtBig(vendaCabecalho.getTotal(), 2));
            out.println(tracos);
            out.println("     VENDEDOR: " + ClasseUtilitaria.decompose(vendaCabecalho.getVendedor().getNome()));
            out.println(tracos);
            out.println(ClasseUtilitaria.fmtDataBR.format(new Date()) + "        " + ClasseUtilitaria.fmtHora24.format(new Date()));
            out.println(ClasseUtilitaria.decompose(mensagem));
            out.println(tracos);
            out.println("\n\n\n\n\n\n\n");
        } catch (DadoInvalidoException ex) {
            Logger.getLogger(CupomNaoFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
        outputFile.close();
    }

    public static void vasilhamesPendentes(VendaCabecalho vendaCabecalho) throws IOException, FileNotFoundException {
        FileOutputStream outputFile;
        BigDecimal qtdTotal = BigDecimal.ZERO;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        try (PrintWriter out = new PrintWriter(outputFile)) {
            out.println(tracos);
            out.println("-----------Vasilhames Pendentes-----------");
            out.println("Codigo   Descricao          QTD");
            for (VendaDetalhe vp : vendaCabecalho.getListaDetalhe()) {
                if (vp.isVasilhame_pendente()) {
                    out.println(vp.getProduto().getCodigo() + "       " + vp.getProduto().getDescricao() + "      " + ClasseUtilitaria.fmtBig(vp.getQtd_vasilhame_pendente(), 2));
                    qtdTotal = qtdTotal.add(vp.getQtd_vasilhame_pendente());
                }
            }
            out.println("                              Total: " + ClasseUtilitaria.fmtBig(qtdTotal, 2));
        }
        outputFile.close();
    }

    public static void cancelarProduto(String valor) throws FileNotFoundException {
        FileOutputStream outputFile;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        try (
                PrintWriter out = new PrintWriter(outputFile)) {
            out.println("Item cancelado *********************** " + valor);
        }
    }

    public static void cancelaCupom() throws IOException, FileNotFoundException {
        FileOutputStream outputFile;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        try (
                PrintWriter out = new PrintWriter(outputFile)) {
            out.println("**********************************************");
            out.println("   CUPOM CANCELADO");
            out.println("**********************************************");
            out.println("\n\n\n\n\n\n\n**********************************************");
        }
        outputFile.close();
    }

    public static void assinaCupom(String nome, String documento, int id) throws IOException, FileNotFoundException {
        FileOutputStream outputFile;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        try (
                PrintWriter out = new PrintWriter(outputFile)) {
            out.println(tracos);
            out.println("     NOME: " + ClasseUtilitaria.decompose(nome));
            out.println("      CPF: " + documento);
            out.println("DOCUMENTO: " + id);
            out.println(tracos);
            out.println("\n\n\n\n\n\n\n");
        } catch (DadoInvalidoException ex) {
            Logger.getLogger(CupomNaoFiscal.class.getName()).log(Level.SEVERE, null, ex);
        }
        outputFile.close();
    }

    public static void quitarConta(String nome, String cpf, int id) throws IOException, FileNotFoundException, DadoInvalidoException {
        FileOutputStream outputFile;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        PrintWriter out = new PrintWriter(outputFile);
        out.println(tracos);
        out.println("     NOME: " + ClasseUtilitaria.decompose(nome));
        out.println("      CPF: " + cpf);
        out.println("DOCUMENTO: " + id);
        out.println("\n\n   __________________________________");
        out.println("                 Assinatura");
        out.println(tracos);
        out.println("\n\n\n\n\n\n\n*");
        outputFile.close();
    }

    private static String verificar(BigDecimal valor, String tipoDesconto) {
        return tipoDesconto == null ? "R$ " + ClasseUtilitaria.fmtBig(valor, 2) : (tipoDesconto.equals("V") ? "R$ " + ClasseUtilitaria.fmtBig(valor, 2) : (tipoDesconto.equals("P")) ? ClasseUtilitaria.fmtBig(valor, 2) + "% " : "R$ 0,00");
    }

    public static void visitaDeClientes(ArrayList<Cliente> listaClienteVisitas) throws IOException, FileNotFoundException {
        FileOutputStream outputFile;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        try (PrintWriter out = new PrintWriter(outputFile)) {
            out.println("-----------Visita de Clientes-----------");
            out.println("Cliente    Endereço");
            for (Cliente clientes : listaClienteVisitas) {
                out.println(clientes.getNome() + "-" + clientes.getEndereco());
            }
            out.println("Total de clientes: " + listaClienteVisitas.size());
            out.println(tracos);
        }
        outputFile.close();
    }

    public static void cupomCompleto(VendaCabecalho vendaCabecalho) throws FileNotFoundException {
        FileOutputStream outputFile;
        outputFile = new FileOutputStream(Dir.KEY_PORTA_IMPRESSORA);
        String cupom = "";
        try (PrintWriter out = new PrintWriter(outputFile)) {
            cupom += (tracos + "\n");
            cupom += ("           " + SISTEMA_GAS._EMPRESA_LOGADA.getNome_fantasia() + ((SISTEMA_GAS._EMPRESA_LOGADA.getTelefone() != null && !SISTEMA_GAS._EMPRESA_LOGADA.getTelefone().isEmpty()) ? " - " + SISTEMA_GAS._EMPRESA_LOGADA.getTelefone() : "") + "\n");
            cupom += (tracos + "\n");
            cupom += ("                ORCAMENTO" + "\n");
            cupom += (tracos + "\n");
            cupom += ("DOCUMENTO: " + vendaCabecalho.getId() + "\n");
            cupom += ("     NOME: " + ClasseUtilitaria.decompose(vendaCabecalho.getCliente().getNome()) + "\n");
            cupom += (" TELEFONE: " + (((vendaCabecalho.getCliente().getTelefone() != null && !vendaCabecalho.getCliente().getTelefone().isEmpty()) && (vendaCabecalho.getCliente().getCelular() != null && !vendaCabecalho.getCliente().getCelular().isEmpty()))
                    ? vendaCabecalho.getCliente().getTelefone() + "/" + vendaCabecalho.getCliente().getCelular()
                    : (vendaCabecalho.getCliente().getTelefone() != null && !vendaCabecalho.getCliente().getTelefone().isEmpty())
                    ? vendaCabecalho.getCliente().getTelefone()
                    : (vendaCabecalho.getCliente().getCelular() != null && !vendaCabecalho.getCliente().getCelular().isEmpty())
                    ? vendaCabecalho.getCliente().getCelular()
                    : "") + "\n");
            cupom += (" CPF/CNPJ: " + vendaCabecalho.getCliente().getCpf() == null && vendaCabecalho.getCliente().getCnpj() != null ? vendaCabecalho.getCliente().getCnpj() : vendaCabecalho.getCliente().getCpf() != null ? vendaCabecalho.getCliente().getCpf() : "" + "\n");
            cupom += (" ENDERECO: " + ClasseUtilitaria.decompose(vendaCabecalho.getCliente().getEndereco()) + ", " + ClasseUtilitaria.decompose(vendaCabecalho.getCliente().getNum_end())
                    + " - " + ClasseUtilitaria.decompose(vendaCabecalho.getCliente().getBairro()) + " - " + vendaCabecalho.getCliente().getCep() + " - "
                    + ClasseUtilitaria.decompose(vendaCabecalho.getCliente().getMunicipio()) + " - " + vendaCabecalho.getCliente().getUf() + "\n");
            cupom += (tracos + "\n");
            cupom += (" CODIGO              DESCRICAO          " + "\n");
            cupom += (" QTDE      X      VALOR UNIT        TOTAL" + "\n");
            cupom += (tracos + "\n");
            //imprimi itens
            for (VendaDetalhe vd : vendaCabecalho.getListaDetalhe()) {
                cupom += (vd.getProduto().getCodigo() + "    " + ClasseUtilitaria.decompose(vd.getProduto().getDescricao()) + "\n");
                cupom += ("    " + ClasseUtilitaria.fmtBig(vd.getQuantidade(), 3) + "    X    " + ClasseUtilitaria.fmtBig(vd.getValor_unitario(), 2) + "             " + ClasseUtilitaria.fmtBig(vd.getValor_total(), 2) + "\n");
            }
            cupom += (tracos + "\n");
            cupom += ("Tipo pagamento:                  " + vendaCabecalho.getTipoPagamento().getDescricao().toUpperCase() + "\n");
            cupom += ("      SUBTOTAL:                  R$ " + ClasseUtilitaria.fmtBig(vendaCabecalho.getSubtotal(), 2) + "\n");
            cupom += ("   DESCONTO(-):                  " + verificar(vendaCabecalho.getDesconto(), vendaCabecalho.getTipo_desconto()) + "\n");
            cupom += ("  ACRESCIMO(+):                  " + verificar(vendaCabecalho.getAcrescimo(), vendaCabecalho.getTipo_acrescimo()) + "\n");
            cupom += ("         TOTAL:                  R$ " + ClasseUtilitaria.fmtBig(vendaCabecalho.getTotal(), 2) + "\n");
            cupom += (tracos + "\n");
            cupom += ("     VENDEDOR: " + ClasseUtilitaria.decompose(vendaCabecalho.getVendedor().getNome()) + "\n");
            cupom += (tracos + "\n");
            cupom += (ClasseUtilitaria.fmtDataBR.format(new Date()) + "        " + ClasseUtilitaria.fmtHora24.format(new Date()) + "\n");
            cupom += (ClasseUtilitaria.decompose("VOLTE SEMPRE!") + "\n");
            cupom += (tracos + "\n");
            cupom += ("\n\n\n\n\n\n\n" + "\n");
            out.print(cupom);
            out.close();
        } catch (DadoInvalidoException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
