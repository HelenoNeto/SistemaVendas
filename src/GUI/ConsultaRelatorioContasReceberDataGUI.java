package GUI;

import Relatorios.RelatorioContasReceber;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

public class ConsultaRelatorioContasReceberDataGUI extends javax.swing.JFrame {

    private final SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");

    public ConsultaRelatorioContasReceberDataGUI() {
        initComponents();
        jCB_recebidas.setSelected(true);
        jCB_data_pagamento.setSelected(true);
        jTF_cod_cliente.setEnabled(false);
        jCB_data_vencimento.setEnabled(false);

        jTF_cod_cliente.setVisible(false);
        jTF_cod_cliente.setText("");
        jTF_nome_cliente.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup_tipo_busca = new javax.swing.ButtonGroup();
        buttonGroupFiltro = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jB_confirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jB_fechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCB_geral = new javax.swing.JCheckBox();
        jCB_aReceber = new javax.swing.JCheckBox();
        jCB_recebidas = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jCB_data_pagamento = new javax.swing.JCheckBox();
        jCB_data_vencimento = new javax.swing.JCheckBox();
        jCB_data_emissao = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTF_nome_cliente = new javax.swing.JTextField();
        jTF_cod_cliente = new javax.swing.JTextField();
        jCB_cliente = new javax.swing.JCheckBox();
        dataInicial = new org.jdesktop.swingx.JXDatePicker();
        dataFinal = new org.jdesktop.swingx.JXDatePicker();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Contas a Receber");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jB_confirmar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jB_confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jB_confirmar.setText("Confirmar");
        jB_confirmar.setFocusable(false);
        jB_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_confirmarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("BUSCA RELATÓRIO CONTAS RECEBER");

        jB_fechar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jB_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_fechar.setText("Fechar");
        jB_fechar.setFocusable(false);
        jB_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_fecharActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("MOSTRAR:"));

        buttonGroupFiltro.add(jCB_geral);
        jCB_geral.setText("Geral");
        jCB_geral.setFocusable(false);
        jCB_geral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_geralActionPerformed(evt);
            }
        });

        buttonGroupFiltro.add(jCB_aReceber);
        jCB_aReceber.setText("A Receber");
        jCB_aReceber.setFocusable(false);
        jCB_aReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_aReceberActionPerformed(evt);
            }
        });

        buttonGroupFiltro.add(jCB_recebidas);
        jCB_recebidas.setSelected(true);
        jCB_recebidas.setText("Recebidas");
        jCB_recebidas.setFocusable(false);
        jCB_recebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_recebidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCB_recebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCB_aReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCB_geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(85, 85, 85))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCB_geral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCB_aReceber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCB_recebidas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("BUSCAR POR:"));

        buttonGroup_tipo_busca.add(jCB_data_pagamento);
        jCB_data_pagamento.setSelected(true);
        jCB_data_pagamento.setText("Data Pagamento");
        jCB_data_pagamento.setFocusable(false);

        buttonGroup_tipo_busca.add(jCB_data_vencimento);
        jCB_data_vencimento.setText("Data Vencimento");
        jCB_data_vencimento.setFocusable(false);

        buttonGroup_tipo_busca.add(jCB_data_emissao);
        jCB_data_emissao.setText("Data Emissão");
        jCB_data_emissao.setFocusable(false);

        jLabel2.setText("Periodo:");

        jLabel3.setText("até");

        jTF_nome_cliente.setEditable(false);
        jTF_nome_cliente.setFocusable(false);

        jTF_cod_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_cod_clienteKeyPressed(evt);
            }
        });

        jCB_cliente.setText("Cliente");
        jCB_cliente.setFocusable(false);
        jCB_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTF_cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCB_cliente)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jCB_data_pagamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCB_data_vencimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCB_data_emissao))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jCB_cliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCB_data_emissao)
                    .addComponent(jCB_data_vencimento)
                    .addComponent(jCB_data_pagamento))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jB_confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_confirmar, jB_fechar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_confirmar)
                    .addComponent(jB_fechar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_confirmar, jB_fechar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(506, 264));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_confirmarActionPerformed
        gerarRelatorio();
    }//GEN-LAST:event_jB_confirmarActionPerformed

    private void jB_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_jB_fecharActionPerformed

    private void jCB_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_clienteActionPerformed
        if (jCB_cliente.isSelected()) {
            jTF_cod_cliente.setVisible(true);
            jTF_cod_cliente.requestFocus();
        } else {
            jTF_cod_cliente.setVisible(false);
            jTF_cod_cliente.setText("");
            jTF_nome_cliente.setText("");
        }
    }//GEN-LAST:event_jCB_clienteActionPerformed

    private void jTF_cod_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {

        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        }
    }//GEN-LAST:event_jTF_cod_clienteKeyPressed

    private void jCB_geralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_geralActionPerformed
        liberaTipoDataBusca(true, true, true);
        jCB_data_emissao.setSelected(true);
    }//GEN-LAST:event_jCB_geralActionPerformed

    private void jCB_aReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_aReceberActionPerformed
        liberaTipoDataBusca(false, true, true);
        jCB_data_vencimento.setSelected(true);
    }//GEN-LAST:event_jCB_aReceberActionPerformed

    private void jCB_recebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_recebidasActionPerformed
        liberaTipoDataBusca(true, false, true);
        jCB_data_pagamento.setSelected(true);
    }//GEN-LAST:event_jCB_recebidasActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultaRelatorioContasReceberDataGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupFiltro;
    private javax.swing.ButtonGroup buttonGroup_tipo_busca;
    private org.jdesktop.swingx.JXDatePicker dataFinal;
    private org.jdesktop.swingx.JXDatePicker dataInicial;
    private javax.swing.JButton jB_confirmar;
    private javax.swing.JButton jB_fechar;
    private javax.swing.JCheckBox jCB_aReceber;
    private javax.swing.JCheckBox jCB_cliente;
    private javax.swing.JCheckBox jCB_data_emissao;
    private javax.swing.JCheckBox jCB_data_pagamento;
    private javax.swing.JCheckBox jCB_data_vencimento;
    private javax.swing.JCheckBox jCB_geral;
    private javax.swing.JCheckBox jCB_recebidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTF_cod_cliente;
    private javax.swing.JTextField jTF_nome_cliente;
    // End of variables declaration//GEN-END:variables

    private void liberaTipoDataBusca(boolean dataPag, boolean dataVenc, boolean dataEmiss) {
        jCB_data_pagamento.setEnabled(dataPag);
        jCB_data_vencimento.setEnabled(dataVenc);
        jCB_data_emissao.setEnabled(dataEmiss);
    }

    private void gerarRelatorio() {
        jCB_geral.setActionCommand(" like '%'");
        jCB_aReceber.setActionCommand(" not like 'PG'");
        jCB_recebidas.setActionCommand(" not like 'NAO'");

        jCB_data_emissao.setActionCommand("cr.data_emissao");
        jCB_data_pagamento.setActionCommand("phr.data_recebimento");
        jCB_data_vencimento.setActionCommand("p.data_vencimento");

        String tipo = jCB_geral.isSelected() ? "geral" : jCB_aReceber.isSelected() ? "areceber" : "recebidas";
        new RelatorioContasReceber().relatorioContasReceber(buttonGroupFiltro.getSelection().getActionCommand(),
                buttonGroup_tipo_busca.getSelection().getActionCommand(), jTF_cod_cliente.getText().isEmpty() ? "%" : jTF_cod_cliente.getText(),
                fmtDate.format(dataInicial.getDate()), fmtDate.format(dataFinal.getDate()), tipo);
    }
}
