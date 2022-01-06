/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Heleno
 */
public class Pontecon {

    private static String SERVHOST = getSERVHOST();
    private static String DATABASE = getDATABASE();
    private static String USUARIO = getUSUARIO();
    private static String SENHA = getSENHA();
    private static String LINHA_CONFIGURACAO = getLINHA_CONFIGURACAO();
    private static final String PASTA_BACKUP = getPASTA_BACKUP();
    private static String versao;

    public static String getVersao() {
        return versao;
    }

    public static String getSERVHOST() {
        pontecon();
        return SERVHOST;
    }

    public static String getDATABASE() {
        return DATABASE;
    }

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getSENHA() {
        return SENHA;
    }

    public static String getLINHA_CONFIGURACAO() {
        return LINHA_CONFIGURACAO;
    }

    public static String getPASTA_BACKUP() {
        pontecon();
        return PASTA_BACKUP;
    }

    public static void pontecon() {
        try {
            String pontecon;
            try (FileReader reader = new FileReader("pontecon.cfg"); BufferedReader leitor = new BufferedReader(reader)) {
                pontecon = leitor.readLine();
                SERVHOST = (pontecon.split("SERVHOST=")[1]);
                pontecon = leitor.readLine();
                DATABASE = (pontecon.split("DATABASE=")[1]);
                pontecon = leitor.readLine();
                USUARIO = (pontecon.split("USUARIO=")[1]);
                pontecon = leitor.readLine();
                SENHA = (pontecon.split("SENHA=")[1]);
                pontecon = leitor.readLine();
                LINHA_CONFIGURACAO = (pontecon.split("LINHA_CONFIGURACAO=")[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
