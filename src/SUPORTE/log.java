package SUPORTE;

import SUPORTE.exceptions.ErroInternoException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class log {

    public static String mensagem;

    public static void execute(String nomeDaClasse, Exception geradora) {
        try {
            FileOutputStream outputFile;

            outputFile = new FileOutputStream("./log.txt", true);
            String instante = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            PrintWriter out = new PrintWriter(outputFile);
            out.println(instante + " ERROR >> " + nomeDaClasse + "\n");
            out.println("   " + geradora.getMessage() + "\n");
            geradora.printStackTrace(out);
            out.println(" <<\n\n");
            out.close();
            outputFile.close();
        } catch (IOException ex) {
            Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String execute(String nomeDaClasse, String mensagemAdicional, Exception e) {
        try {
            FileOutputStream outputFile;

            outputFile = new FileOutputStream("./log.txt", true);
            String instante = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            PrintWriter out = new PrintWriter(outputFile);
            mensagem = instante + " ERROR >> " + nomeDaClasse + "\n\n log:";

            out.println(mensagem);
            Logger.getLogger(nomeDaClasse).log(Level.SEVERE, null, e);
            e.printStackTrace(out);
            out.println(" <<\n\n");

            out.close();
            outputFile.close();
        } catch (IOException ex) {
            Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (mensagemAdicional + "\n" + e.getMessage() + "\n" + e.toString());
    }
}