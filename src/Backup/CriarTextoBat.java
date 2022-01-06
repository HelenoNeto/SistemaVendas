/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Backup;

import Utilitarios.Dir;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

class CriarTextoBat {

    public void escreve(String corpo) {
        FileWriter arquivo;
        try {
            arquivo = new FileWriter(new File(Dir.bin + "restore.bat"));
            arquivo.write(corpo);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Gravar(String texto) {
        String conteudo = texto;
        try {
            // o true significa q o arquivo será constante  
            File file = new File(Dir.bin + "restore.bat");
            if(file.exists()){
                file.delete();
            }
            FileWriter x = new FileWriter(file, true);
            conteudo += "\n\r"; // criando nova linha e recuo no arquivo              
            x.write(conteudo); // armazena o texto no objeto x, que aponta para o arquivo             
            x.close(); // cria o arquivo              
//            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        } // em caso de erro apreenta mensagem abaixo  
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
}