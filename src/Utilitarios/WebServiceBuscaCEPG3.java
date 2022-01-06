package Utilitarios;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class WebServiceBuscaCEPG3 {

//    private String cep;
//    private String tipoLogradouro;
//    private String logradouroCompleto;
//    private String logradouro;
//    private String bairro;
//    private String cidade;
//    private String UF;
    public String cep;
    public String tipoLogradouro;
    public String logradouroCompleto;
    public String logradouro;
    public String bairro;
    public String cidade;
    public String UF;

    public void buscaCEP(String cep) {
        try {
            String url = "http://www.g3automacao.com.br/webservices/cep.php?CEP=" + cep.replace(" ", "").replace("-", "");
            URL u = new URL(url);
            Scanner sc = new Scanner(u.openStream());
            if (sc == null) {
            } else {
                if (sc.nextLine().contains("CEP Nao")) { //testa se o cep existe, se não manda mesagem
                    JOptionPane.showMessageDialog(null, "CEP Não encontrado.\nVerifique!");
                } else {
                    sc.nextLine(); //segunda linha inutil, eh o inicio da tabela html
                    String l = (sc.nextLine().substring(43).replace("</td>", "").replace(">", "")); //pega o endereco completo
                    if (l.isEmpty()) {
                    } else {
                        this.tipoLogradouro = (l.substring(0, l.indexOf(" "))); //separa e seta o tipo, rua, quadra, etc.
                        this.logradouro = (l.substring(l.indexOf(" ") + 1)); //o restante, edereco sem logradouro
                        this.logradouroCompleto = (l.substring(0, l.indexOf(" "))) + " " + (l.substring(l.indexOf(" ") + 1)); //endereco completo com logradouro
                    }
                    this.bairro = (sc.nextLine().substring(43).replace("</td>", "").replace(">", "")); //bairro
                    this.cidade = (sc.nextLine().substring(43).replace("</td>", "").replace(">", "")); //cidade
                    this.UF = (sc.nextLine().substring(42).replace("</td>", "")).replace(">", ""); //uf
                    this.cep = (sc.nextLine().substring(42).replace("</td>", "").replace(">", "")); //cep 
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(WebServiceBuscaCEPG3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WebServiceBuscaCEPG3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public String getCep() {
//        return cep;
//    }
//    public String getTipoLogradouro() {
//        return tipoLogradouro;
//    }
//    public String getLogradouro() {
//        return logradouro;
//    }
//    public String getBairro() {
//        return bairro;
//    }
//    public String getCidade() {
//        return cidade;
//    }
//    public String getUF() {
//        return UF;
//    }
//    public String getLogradouroCompleto() {
//        return logradouroCompleto;
//    }
}