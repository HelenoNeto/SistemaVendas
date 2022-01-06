/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Relatorios.RelatorioVenda;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Neto
 */
public class ConsultaVendasDataDialog extends javax.swing.JDialog {

    /*
     0 - Vendas
     1 - Lucro
     */
    public static Integer TIPO_RELATORIO;

    /**
     * Creates new form ConsultaVendasDataDialog
     *
     * @param parent
     * @param modal Insira o TIPO DE RELATÓRIO que deseja imprimir, setando a
     * variável TIPO_RELATORIO
     */
    public ConsultaVendasDataDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jXDP_dataInicial.setDate(new Date());
        jXDP_dataFinal.setDate(new Date());

        jP_filtro.setVisible(TIPO_RELATORIO == 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_filtro = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jXDP_dataInicial = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jXDP_dataFinal = new org.jdesktop.swingx.JXDatePicker();
        jB_confirmar = new javax.swing.JButton();
        jB_cancelar = new javax.swing.JButton();
        jP_filtro = new javax.swing.JPanel();
        jRB_sintetico = new javax.swing.JRadioButton();
        jRB_analitico = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Relatório");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Data início:");

        jLabel2.setText("Data fim:");

        jB_confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoConfirmar.png"))); // NOI18N
        jB_confirmar.setText("Confirmar");
        jB_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_confirmarActionPerformed(evt);
            }
        });

        jB_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoCancelar.png"))); // NOI18N
        jB_cancelar.setText("Cancelar");
        jB_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarActionPerformed(evt);
            }
        });

        jP_filtro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        buttonGroup_filtro.add(jRB_sintetico);
        jRB_sintetico.setSelected(true);
        jRB_sintetico.setText("Sintético");

        buttonGroup_filtro.add(jRB_analitico);
        jRB_analitico.setText("Analítico");

        javax.swing.GroupLayout jP_filtroLayout = new javax.swing.GroupLayout(jP_filtro);
        jP_filtro.setLayout(jP_filtroLayout);
        jP_filtroLayout.setHorizontalGroup(
            jP_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRB_sintetico)
                .addGap(18, 18, 18)
                .addComponent(jRB_analitico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_filtroLayout.setVerticalGroup(
            jP_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_filtroLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jP_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRB_sintetico)
                    .addComponent(jRB_analitico)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXDP_dataInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(jXDP_dataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jB_confirmar)
                        .addGap(0, 0, 0)
                        .addComponent(jB_cancelar)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addComponent(jP_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_cancelar, jB_confirmar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jXDP_dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jXDP_dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jP_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_confirmar)
                    .addComponent(jB_cancelar))
                .addGap(5, 5, 5))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_cancelar, jB_confirmar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_confirmarActionPerformed
        if (jXDP_dataInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Data inicial inválida!", "ALERTA DO SISTEMA", JOptionPane.WARNING_MESSAGE);
        } else if (jXDP_dataFinal.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Data final inválida!", "ALERTA DO SISTEMA", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                jRB_sintetico.setActionCommand("S");
                jRB_analitico.setActionCommand("A");
                relatorio(buttonGroup_filtro.getSelection().getActionCommand());
            } catch (IOException ex) {
                Logger.getLogger(ConsultaVendasDataDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jB_confirmarActionPerformed

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jB_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaVendasDataDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConsultaVendasDataDialog dialog = new ConsultaVendasDataDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_filtro;
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jP_filtro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRB_analitico;
    private javax.swing.JRadioButton jRB_sintetico;
    private org.jdesktop.swingx.JXDatePicker jXDP_dataFinal;
    private org.jdesktop.swingx.JXDatePicker jXDP_dataInicial;
    // End of variables declaration//GEN-END:variables

    private void relatorio(String tipo) throws IOException {
        if (TIPO_RELATORIO == 0) {
            switch (tipo) {
                case "S":
                    new RelatorioVenda().relatorioFechamentoVendas(jXDP_dataInicial.getDate(), jXDP_dataFinal.getDate());
                    break;
                case "A":
                    new RelatorioVenda().relatorioFechamentoVendasAnalitico(jXDP_dataInicial.getDate(), jXDP_dataFinal.getDate());
                    break;
            }
        } else if (TIPO_RELATORIO == 1) {
            new RelatorioVenda().relatorioLucroDatas(jXDP_dataInicial.getDate(), jXDP_dataFinal.getDate());
        }
    }
}
