package Utilitarios;

import sistema.gas.RegistroWin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Retorna o caminho da arvore de diretorios.
 *
 * @author Daniel
 */
public final class Dir {

    public static final String HTML_ModeloEmailNFE = pegaHTML("http://www.g3automacao.com.br/webservices/NFe/modelo.html");
    //REGISTRO DO WINDOWS
    public static final int HCU = RegistroWin.HKEY_CURRENT_USER;
    public static final String SK_HJSN_CONFIG = "SOFTWARE\\HJSN Sistemas\\Configuração";
    public static String KEY_SERVHOST = criarChaveRegistoSeNaoExistir(SK_HJSN_CONFIG, "SERVHOST", "servidor");
    public static String KEY_DATABASE = criarChaveRegistoSeNaoExistir(SK_HJSN_CONFIG, "DATABASE", "hjsn");
    public static String KEY_USUARIO = criarChaveRegistoSeNaoExistir(SK_HJSN_CONFIG, "USUARIO", "user_hjsn");
    public static String KEY_SENHA = criarChaveRegistoSeNaoExistir(SK_HJSN_CONFIG, "SENHA", "#hjsn#");
    public static final int SCL = Integer.parseInt(criarChaveRegistoSeNaoExistir(SK_HJSN_CONFIG, "SCL", "4"));
    public static String KEY_PASTA_BACKUP = criarChaveRegistoSeNaoExistir(SK_HJSN_CONFIG, "PASTA_BACKUP", "dir\\dados\\");
    public static boolean KEY_AUTOCOMPLETA = Boolean.parseBoolean(criarChaveRegistoSeNaoExistir(SK_HJSN_CONFIG, "AUTOCOMPLETA", "true"));
    public static String KEY_PORTA_IMPRESSORA = criarChaveRegistoSeNaoExistir(SK_HJSN_CONFIG, "PORTA_IMPRESSORA", "");
    public static String KEY_TIPO_SISTEMA = criarChaveRegistoSeNaoExistir(SK_HJSN_CONFIG, "TIPO_SISTEMA", "G");
    //DIRETORIOS DO SISTEMA
    public static final String raiz = criarPastasSeNaoExistir(".\\");
    public static final String raizProp = System.getProperty("user.dir") + "\\";
    public static final String suporte = criarPastasSeNaoExistir("dir\\suporte\\");
    public static final String bin = criarPastasSeNaoExistir("dir\\sis\\bin\\");
    public static final String pdf = criarPastasSeNaoExistir("dir\\pdf\\");
    public static final String nfe = criarPastasSeNaoExistir("dir\\sis\\nfe\\");
    public static final String dados = criarPastasSeNaoExistir("dir\\dados\\");
    public static final String QRCodes = criarPastasSeNaoExistir("dir\\imagens\\QRCodes\\");
    public static final String imagens_clientes = criarPastasSeNaoExistir("dir\\imagens\\imagens_clientes\\");
    public static final String imagens_produtos = criarPastasSeNaoExistir("dir\\imagens\\imagens_produtos\\");
    public static final String imagens_internas = criarPastasSeNaoExistir("dir\\sis\\imagens_internas\\");
    public static final String NfeTempFiles = criarPastasSeNaoExistir("dir\\sis\\nfe\\xml\\tempFiles\\");
    public static final String NfeAutorizadas = criarPastasSeNaoExistir("dir\\sis\\nfe\\xml\\autorizadas\\");
    public static final String NfeDenegadas = criarPastasSeNaoExistir("dir\\sis\\nfe\\xml\\denegadas\\");
    public static final String NfeCanceladas = criarPastasSeNaoExistir("dir\\sis\\nfe\\xml\\canceladas\\");
    public static final String NfeInutilizadas = criarPastasSeNaoExistir("dir\\sis\\nfe\\xml\\inutilizadas\\");
    public static final String NfeShema = criarPastasSeNaoExistir("dir\\sis\\nfe\\schema\\");
    public static final String NfeXML_ENTRADA = criarPastasSeNaoExistir("dir\\sis\\nfe\\XML_ENTRADA\\");
    public static final String relatorios_antigos = criarPastasSeNaoExistir("dir\\sis\\relatorios_antigos\\");
    //AQUIVOS OBRIGATORIOS DO SISTEMA
    public static final String[] arquivos_obrigatorios = verificarArquivosObrigatorios(new String[]{
        raiz + "HJSN.jar", // <-EXEMPLO 
        suporte + "acesso_remoto TeamViewer.exe", // acesso remoto 
        suporte + "acesso_remoto AMMY.exe",//acesso remoto 
        suporte + "acesso_remoto ShowMyPC.exe",//acesso remoto 
        suporte + "G3AtendimentoOnline.exe",//atendimento online
        bin + "CnpjDll.dll",
        bin + "ConsultarCNPJ.exe",
        bin + "mysql.exe",
        bin + "mysqldump.exe",
        bin + "layout_boleto.pdf",
        bin + "layout_boletoCarne3PorPagina.pdf",
        imagens_internas + "g3automacao.png",//icone de titulo e da barra
        imagens_internas + "logo.jpg",//PLANO DE FUNDO JANELA PRINCIPAL
        imagens_internas + "gestao_ico.ico",// icone g3
        imagens_produtos + "padraoBranco.jpg",// padrao do paf
        nfe + "token.cfg",
        NfeShema + "enviNFe_v2.00.xsd",
        raiz + "lib", // TODA PASTA LIB ULTIMO
    });

    public static void setKEY_DATABASE(String valor) {
        Dir.KEY_DATABASE = setKeyValue(SK_HJSN_CONFIG, "DATABASE", valor);
    }

    public static void setKEY_PASTA_BACKUP(String valor) {
        Dir.KEY_PASTA_BACKUP = setKeyValue(SK_HJSN_CONFIG, "PASTA_BACKUP", valor);
    }

    public static void setKEY_SENHA(String valor) {
        Dir.KEY_SENHA = setKeyValue(SK_HJSN_CONFIG, "SENHA", valor);
    }

    public static void setKEY_SERVHOST(String valor) {
        Dir.KEY_SERVHOST = setKeyValue(SK_HJSN_CONFIG, "SERVHOST", valor);
    }

    public static void setKEY_USUÁRIO(String valor) {
        Dir.KEY_USUARIO = setKeyValue(SK_HJSN_CONFIG, "USUARIO", valor);
    }

    public static void setKEY_PORTA_IMPRESSORA(String valor) {
        Dir.KEY_PORTA_IMPRESSORA = setKeyValue(SK_HJSN_CONFIG, "PORTA_IMPRESSORA", valor);
    }

    public static void setKEY_TIPO_SISTEMA(String valor) {
        Dir.KEY_TIPO_SISTEMA = setKeyValue(SK_HJSN_CONFIG, "TIPO_SISTEMA", valor);
    }

    private static String setKeyValue(String localConfig, String key, String value) {
        try {
            RegistroWin.writeStringValue(RegistroWin.HKEY_CURRENT_USER, localConfig, key, value);
            return value;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Dir.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro com Registro:\n" + ex.getMessage());
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(Dir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static String[] verificarArquivosObrigatorios(String[] arquivos_obrigatorios) {
        for (String caminho_arquivo : arquivos_obrigatorios) {
            File pasta = null;
            try {
                pasta = new File(caminho_arquivo);
            } catch (Exception e) {
            }
            if (pasta == null || !pasta.exists()) {
                try {
                    System.out.println(" =msg: Arquivo ausente:\"" + pasta.getAbsolutePath().toString() + "\"");
                } catch (Exception e) {
                    Logger.getLogger(Dir.class.getName()).log(Level.SEVERE, "", e);
                    JOptionPane.showMessageDialog(null, "ERRO: CAMINHOS DOS ARQUIVOS INVÁLIDOS");
                }
            }
        }
        return arquivos_obrigatorios;
    }

    private static String criarPastasSeNaoExistir(String caminhoDaPasta) {
        File pasta = new File(caminhoDaPasta);
        if (!pasta.exists()) {
            pasta.mkdirs();
            System.out.println("caminho criado: \"" + pasta.getAbsolutePath() + "\"");
            JOptionPane.showMessageDialog(null, " =mensagem: Caminho criado, verificar arquivos: \"" + pasta.getAbsolutePath() + "\"");
        }
        return caminhoDaPasta;
    }

    private static String criarChaveRegistoSeNaoExistir(String SK, String valueName, String value) {
        try {
            RegistroWin.createKey(HCU, SK);
            String VALOR_CHAVE = RegistroWin.readString(HCU, SK, valueName);
            if (VALOR_CHAVE == null) {
                RegistroWin.writeStringValue(HCU, SK, valueName, value);
                System.out.println(" =mensagem: REGISTRO CRIADO: \"" + valueName + "=" + value + "\"");
                return value;
            } else {
                return VALOR_CHAVE;
            }
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(Dir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void copiarArquivo(File origem, File destino) throws IOException {
        if (destino.exists()) {
            destino.delete();
        }
        FileChannel origemChannel = null;
        FileChannel destinoChannel = null;
        try {
            origemChannel = new FileInputStream(origem).getChannel();
            destinoChannel = new FileOutputStream(destino).getChannel();
            origemChannel.transferTo(0, origemChannel.size(),
                    destinoChannel);
        } finally {
            if (origemChannel != null && origemChannel.isOpen()) {
                origemChannel.close();
            }
            if (destinoChannel != null && destinoChannel.isOpen()) {
                destinoChannel.close();
            }
        }
    }

    private static String pegaHTML(String urlSite) {
        String html = "";
        try {
            URL url = new URL(urlSite);
            Scanner sc = new Scanner(url.openStream());
            if (sc != null) {
                while (sc.hasNextLine()) {
                    html += sc.nextLine();
                }
            }
        } catch (IOException ex) {
            System.out.println("Entrei no catch");
            html = "     Prezado Cliente, <nome_do_cliente>\n"
                    + " em anexo consta o arquivo eletrônico (XML) e o DANFE (PDF) correspondente a \n"
                    + " NF-e número: <numero_da_nota>  da série: <serie_da_nota>\n"
                    + "\n"
                    + " Chave de acesso da Nota Fiscal Eletronica: <chave_de_acesso>\n"
                    + " Protocolo de autorização NFe: <protocolo_de_autorizacao>\n"
                    + "\n"
                    + "*Este email foi enviado automaticamente pelo sistema de Notas Fiscais Eletrônicas - GTECH-GESTAO. Favor não responder! \n"
                    + "G3 INFORMÁTICA - www.g3automacao.com.br";
        }
        return html;
    }
}
