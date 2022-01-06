package sistema.gas;

import GUI.AutenticacaoDialog;
import GUI.FuncionariosDialog;
import Negocios.Empresa;
import Negocios.Fachada;
import Negocios.Funcionario;
import Utilitarios.Dir;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class SISTEMA_GAS {

    public static Funcionario _FuncionarioLogado;
    public static Empresa _EMPRESA_LOGADA;
    private static String versao;
    public static boolean temInternet;

    public static void main(String[] args) {
        temInternet = testeDeInternet(1500);
        if (true) {//versao java
            if (System.getProperty("os.name").startsWith("Win")) {
                String vjava = System.getProperty("java.version");
                System.out.println(" Raiz: \"" + Dir.raizProp + "\"");
                System.out.println(" JRE " + vjava);
            }
        }

        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SISTEMA_GAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        int versao_final = 0;
        String versao_geral = "1";
        String versoes_unidas = "0";
        versao = versao_final + "." + versao_geral + "." + versoes_unidas;

        //TODO: APENAS UMA APLICAÇÃO SERÁ EXECUTADA POR VEZ! //FIM
        System.out.print(" =parametros de conexao:\n"
                + "     SH: " + Dir.KEY_SERVHOST + "\n"
                + "     DB: " + Dir.KEY_DATABASE + "\n"
                + "     US: " + Dir.KEY_USUARIO + "\n"
                + "     PW: " + (Dir.KEY_SENHA == null || Dir.KEY_SENHA.isEmpty() ? "NÃO RECONHECIDA" : siglaDaSenha(Dir.KEY_SENHA)) + "\n"
                + "     ..");
        try {
            ArrayList<Funcionario> listaFuncionarioUsuario = Fachada.getInstancia().consultarFuncionario("select * from funcionario where not excluido");
            System.out.println(". OK. sistema conectado.");
            if (listaFuncionarioUsuario.isEmpty()) {
                FuncionariosDialog funcionarios_Dialog = new FuncionariosDialog(null, true, true);
                funcionarios_Dialog.setLocationRelativeTo(null);
                funcionarios_Dialog.setVisible(true);
            } else {
                new AutenticacaoDialog().showLoginDialog();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String getVersao() {
        return versao;
    }

    public static boolean testeDeInternet(int tempoMaximo) {
        System.out.print(" =testando internet... time=" + tempoMaximo + "(milis)  ..");
        int processo;
        SwingWorker sw = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    URL conn = new URL("http://www.google.com.br");
                    conn.openStream();
                    setProgress(1);
                } catch (IOException e) {
                    setProgress(0);
                }
                return null;
            }
        };
        sw.execute();
        try {
            Thread.sleep(tempoMaximo);
        } catch (InterruptedException ex) {
            Logger.getLogger(AutenticacaoDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        processo = sw.getProgress();
        System.out.println(".  status=" + processo);
        if (processo == 0) {
            sw.cancel(true);
            temInternet = false;
            return temInternet;
        }
        temInternet = true;
        return temInternet;
    }

    private static String siglaDaSenha(String pw) {
        switch (pw) {
            case "root":
                return "PNN";
            default:
                return pw;
        }
    }
}
