package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MensagemGUI extends javax.swing.JDialog {

    private boolean fechamentoaut = true;
    private int tempoFechamento = 5000;

    public MensagemGUI(java.awt.Dialog parent, boolean modal, boolean fechaaut, int tempo) {
        super(parent, modal);
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Utilitarios.Dir.imagens_internas + "icone.png"));
        this.setUndecorated(true);
        this.tempoFechamento = tempo;
        this.fechamentoaut = fechaaut;

        //TODO : É necessário configurar a cor de cada Panel?
//        panelPrincipal.setBackground(new Color(255,255,255));
//        panelValor.setBackground(new Color(0,0,0));


        this.setPreferredSize(new Dimension(300, 80));
        this.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        panelValor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        panelValor.setBackground(new Color(255,255,255,0));
        panelValor.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Desconto OK");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelValor.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelPrincipal.add(panelValor, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(panelPrincipal, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (this.fechamentoaut) {
            try {
                Thread.sleep(this.tempoFechamento);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
    }//GEN-LAST:event_formWindowOpened
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelValor;
    // End of variables declaration//GEN-END:variables

    public void setMensagem(String mensagem) {
        jLabel2.setText(mensagem);
    }
}
