package splashscreen;

//import com.sun.awt.AWTUtilities;
import Utilitarios.Dir;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public final class SplashFrame extends javax.swing.JDialog {

    String restauraArquivo = null;
    Date data = new Date();
    String dia;
    Frame parent;
    SimpleDateFormat fmtDataBRhora = new SimpleDateFormat("ddMMyyyy-HHmmss");
    public String caminho_do_arquivo = Dir.dados;
    public String nomeArquivo = null;
    Process runtimeProcess;

    public SplashFrame(Frame parent, String destino) {

        super(parent, true);
        setUndecorated(true);

        initComponents();
        setTitle("Backup em andamento...");
        this.parent = parent;

        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Utilitarios.Dir.imagens_internas + "icone.png"));
        if (destino != null) {
            caminho_do_arquivo = destino;
        }
        setLocationRelativeTo(null);
    }

    public boolean startBackup() {
        atualizaDiaHoraAtual();
        nomeArquivo = "BACKUP_COMPLETO_" + dia + ".sql";
        if (backuDB(Dir.bin + "mysqldump.exe", Dir.KEY_USUARIO, Dir.KEY_SENHA, Dir.KEY_DATABASE, caminho_do_arquivo, nomeArquivo)) {
//            JOptionPane.showMessageDialog(this, "Backup realizado com SUCESSO!\n", "BACKUP", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Backup realizado com SUCESSO!");
            System.out.println("\"" + caminho_do_arquivo + nomeArquivo + "\"");
            dispose();
            return true;
        } else {
            dispose();
            return false;
        }
    }

    private void atualizaDiaHoraAtual() {
        dia = fmtDataBRhora.format(new Date());
    }

//    @SuppressWarnings("CallToThreadDumpStack")
//    public void dump() {
//
//        nomeArquivo = "BACKUP_COMPLETO_" + dia;
//
//        String comando = "cmd /c \"" + System.getProperty("user.dir") + "\\" + Dir.bin + "mysqldump\" --user=" + GTECHGESTAO.getUserName() + " --password=" + GTECHGESTAO.getPassword() + " --host=" + GTECHGESTAO.getNameHost() + " --databases " + GTECHGESTAO.getDataBase() + " > " + caminho_do_arquivo + "/" + nomeArquivo + ".sql";
//        String comando2 = "mysqldump --user=" + GTECHGESTAO.getUserName() + " --password=" + GTECHGESTAO.getPassword() + " --host=" + GTECHGESTAO.getNameHost() + " --databases " + GTECHGESTAO.getDataBase() + " > " + nomeArquivo + ".sql";
//        String osName = System.getProperty("os.name");
//        System.out.println(comando);
//        if (osName.startsWith("Win")) {
//            if (nomeArquivo == null ? "" != null : !nomeArquivo.equals("")) {
//                try {
//                    Process exec = Runtime.getRuntime().exec(comando);
//                    if (exec.waitFor() == 0) {
//                        this.setVisible(false);
//
//                        Object[] op = new Object[]{"Ok, (Fechar sistema)", "OK"};
//
//                        if (JOptionPane.showOptionDialog(parent, "Backup Realizado com suscesso!\n Destino: " + caminho_do_arquivo, "Aviso do Sistema", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]) == JOptionPane.YES_OPTION) {
//                            System.exit(0);
//                        }
//
//                    } else {
//                        JOptionPane.showMessageDialog(null, "ERRO: " + exec.exitValue() + " Alguns caminhos são inacessiveis! ", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Defina o local do backup", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } else {
//
//            if (nomeArquivo == null ? "" != null : !nomeArquivo.equals("")) {
//                try {
//                    Process exec = Runtime.getRuntime().exec(comando2);
//
//                    if (exec.waitFor() == 0) {
//                        JOptionPane.showMessageDialog(null, "Backup Realizado com suscesso ", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
//
//                    } else {
//                        JOptionPane.showMessageDialog(null, exec.exitValue(), "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                } catch (Exception e) {
//
//                    e.printStackTrace();
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Defina o local do backup", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
//            }
//        }
//    }
    public JProgressBar getProgressBar() {
        //este metodo nos permite obtener la barra de progreso desde el AplicationFrame
        return progressBar;
    }

    public JLabel getLabel() {
        //este metodo devuelve el label
        return label;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setToolTipText("Backup em andamento...");
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        label.setForeground(new java.awt.Color(51, 153, 255));
        label.setText("Aguarde...");

        progressBar.setMaximum(50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/java_image.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        progressBar.getAccessibleContext().setAccessibleName("progressBar");
        progressBar.getAccessibleContext().setAccessibleDescription("progressBar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Backup em andamento...");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
    }//GEN-LAST:event_jPanel1ComponentShown

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
    }//GEN-LAST:event_jPanel1FocusGained

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
//        try {
//            runtimeProcess.destroy();
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_jPanel1MouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SplashFrame().setVisible(true);
//            }
//        });
//    }
    private boolean backuDB(String binMysqlDump, String dbUserName, String dbPassword, String dbName, String path, String fileName) {

        File mysqlDump = new File(binMysqlDump);

        String executeCmd = "\"" + mysqlDump.getAbsolutePath() + "\""
                + " -h " + Dir.KEY_SERVHOST
                + " -u " + dbUserName
                + " -p" + dbPassword
                + " --add-drop-database"
                + " -B \"" + dbName + "\""
                + " -r  \"" + path
                + fileName + "\"";
        System.out.println(executeCmd);
        try {

            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup successfully");
                return true;
            } else {
                System.out.println("Could not create the backup");
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
