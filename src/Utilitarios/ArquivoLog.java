/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ArquivoLog {

    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    BufferedWriter bufferedWritter;

    public ArquivoLog(String erros) {
        escreveLog(erros);
    }

    public final void escreveLog(String erro) {
        try {
            arquivo = new File("Exceptions.log");
            fileReader = new FileReader(arquivo);
            bufferedReader = new BufferedReader(fileReader);
            Vector texto = new Vector();
            while (bufferedReader.ready()) {
                texto.add(bufferedReader.readLine());
            }
            fileWriter = new FileWriter(arquivo);
            bufferedWritter = new BufferedWriter(fileWriter);
            for (int i = 0; i < texto.size(); i++) {
                bufferedWritter.write(texto.get(i).toString());
                bufferedWritter.newLine();
            }
            bufferedWritter.write(erro);
            bufferedReader.close();
            bufferedWritter.close();
        } catch (FileNotFoundException ex) {
            try {
                arquivo.createNewFile();
                escreveLog(erro);
            } catch (IOException ex1) {
                System.exit(0);
            }
        } catch (IOException exception) {
            System.exit(0);
        }
    }
}
