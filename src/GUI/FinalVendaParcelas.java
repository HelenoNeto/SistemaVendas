package GUI;

import Negocios.*;
import Utilitarios.ClasseUtilitaria;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import static sistema.gas.SISTEMA_GAS._FuncionarioLogado;
import sistema.gas.financeiro.tableModel.FinanceiroColumnModel;
import sistema.gas.financeiro.tableModel.TableModelFinanceiro;

public class FinalVendaParcelas extends javax.swing.JDialog {

    private Cliente cliente;
    private Financeiro cr;
    private ArrayList<String> listaParcelasFds = new ArrayList<>();
    private TableModelFinanceiro model;

    public FinalVendaParcelas(java.awt.Frame parent, boolean modal, Financeiro contas_Receber) {
        super(parent, modal);
        try {
            initComponents();
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(Utilitarios.Dir.imagens_internas + "icone.png"));
            this.cr = contas_Receber;
            carregaDados();
            configuraTableModel();
        } catch (Exception ex) {
            Logger.getLogger(FinalVendaParcelas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTF_cod_cliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTF_emissao = new javax.swing.JFormattedTextField();
        jTF_nome_cliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTF_referente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTF_parcelas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTF_entrada = new javax.swing.JTextField();
        jB_gerar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTF_documento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTF_numero_de_dias = new javax.swing.JTextField();
        jCB_mesmo_dia_mes = new javax.swing.JCheckBox();
        jTF_p_venc = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtParcelas = new javax.swing.JTable();
        jB_salvar = new javax.swing.JButton();
        jB_cancelar1 = new javax.swing.JButton();
        jL_observacao = new javax.swing.JLabel();
        jL_cor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar Parcelas");
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setText("DataEmissão");

        jTF_cod_cliente.setEditable(false);
        jTF_cod_cliente.setFocusable(false);
        jTF_cod_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_cod_clienteKeyPressed(evt);
            }
        });

        jLabel2.setText("Cliente");

        jTF_emissao.setEditable(false);
        jTF_emissao.setFocusable(false);
        jTF_emissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_emissaoFocusGained(evt);
            }
        });
        jTF_emissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_emissaoKeyPressed(evt);
            }
        });

        jTF_nome_cliente.setEditable(false);
        jTF_nome_cliente.setFocusable(false);

        jLabel6.setText("Referente");

        jTF_referente.setEditable(false);
        jTF_referente.setFocusable(false);
        jTF_referente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_referenteKeyPressed(evt);
            }
        });

        jLabel9.setText("Primeiro Venc.");

        jLabel10.setText("V. Total");

        jtfTotal.setEditable(false);
        jtfTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfTotal.setText("0,00");
        jtfTotal.setFocusable(false);
        jtfTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTotalKeyPressed(evt);
            }
        });

        jLabel11.setText("Nº Parcelas");

        jTF_parcelas.setText("1");
        jTF_parcelas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_parcelasFocusGained(evt);
            }
        });
        jTF_parcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_parcelasKeyPressed(evt);
            }
        });

        jLabel12.setText("Entrada");

        jTF_entrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_entrada.setText("0,00");
        jTF_entrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_entradaFocusGained(evt);
            }
        });
        jTF_entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_entradaKeyPressed(evt);
            }
        });

        jB_gerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jB_gerar.setText("Gerar");
        jB_gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_gerarActionPerformed(evt);
            }
        });

        jLabel7.setText("Documento");

        jTF_documento.setEditable(false);
        jTF_documento.setFocusable(false);
        jTF_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_documentoKeyPressed(evt);
            }
        });

        jLabel3.setText("N° de Dias");

        jTF_numero_de_dias.setText("30");
        jTF_numero_de_dias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_numero_de_diasKeyPressed(evt);
            }
        });

        jCB_mesmo_dia_mes.setText("Mesmo dia do Mês");
        jCB_mesmo_dia_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_mesmo_dia_mesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTF_emissao, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jTF_cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jTF_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTF_referente, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTF_documento)
                                .addGap(5, 5, 5))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTF_p_venc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCB_mesmo_dia_mes)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTF_numero_de_dias, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jTF_parcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(182, 182, 182))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jTF_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                        .addComponent(jB_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(19, 19, 19))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addComponent(jTF_emissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(jTF_cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(0, 0, 0)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTF_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTF_referente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTF_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel6)))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12))
                            .addComponent(jLabel3))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_parcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_numero_de_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jB_gerar)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jCB_mesmo_dia_mes)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(0, 0, 0)
                            .addComponent(jTF_p_venc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );

        jtParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4"
            }
        ));
        jtParcelas.getTableHeader().setReorderingAllowed(false);
        jtParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtParcelasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtParcelas);

        jB_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jB_salvar.setText("Salvar");
        jB_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvarActionPerformed(evt);
            }
        });

        jB_cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_cancelar1.setText("Cancelar");
        jB_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelar1ActionPerformed(evt);
            }
        });

        jL_observacao.setText("    ");

        jL_cor.setText("   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jL_cor, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jB_cancelar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jL_observacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(5, 5, 5))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_cancelar1, jB_salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_salvar)
                    .addComponent(jB_cancelar1)
                    .addComponent(jL_observacao)
                    .addComponent(jL_cor))
                .addGap(5, 5, 5))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_cancelar1, jB_salvar});

        setSize(new java.awt.Dimension(841, 472));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_cod_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        }
    }//GEN-LAST:event_jTF_cod_clienteKeyPressed

    private void jTF_emissaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_emissaoFocusGained
        jTF_emissao.selectAll();
}//GEN-LAST:event_jTF_emissaoFocusGained

    private void jTF_emissaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_emissaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_cod_cliente.requestFocus();
        }
}//GEN-LAST:event_jTF_emissaoKeyPressed

    private void jTF_referenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_referenteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_documento.requestFocus();
        }
}//GEN-LAST:event_jTF_referenteKeyPressed

    private void jtfTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTotalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_parcelas.requestFocus();
        }
}//GEN-LAST:event_jtfTotalKeyPressed

    private void jTF_parcelasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_parcelasFocusGained
        jTF_parcelas.selectAll();
}//GEN-LAST:event_jTF_parcelasFocusGained

    private void jTF_parcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_parcelasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_entrada.requestFocus();
        }
}//GEN-LAST:event_jTF_parcelasKeyPressed

    private void jTF_entradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_entradaFocusGained
        jTF_entrada.selectAll();
}//GEN-LAST:event_jTF_entradaFocusGained

    private void jTF_entradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_entradaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            nextFocus();
        }
}//GEN-LAST:event_jTF_entradaKeyPressed

    private void jB_gerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_gerarActionPerformed
        gerarParcelas();
}//GEN-LAST:event_jB_gerarActionPerformed

    private void jTF_documentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_documentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            List listContas = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where documento like '" + jTF_documento.getText() + "'");
            if (listContas.isEmpty()) {
                jTF_p_venc.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Número de documento já consta no banco de dados!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                jTF_documento.requestFocus();
            }
        }
}//GEN-LAST:event_jTF_documentoKeyPressed

    private void jB_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarActionPerformed
        if (jtParcelas.getRowCount() > 0) {
            if (verificaValorParcelas_Conta()) {
                salvar();
            } else {
                JOptionPane.showMessageDialog(null, "Total das parcelas não bate com total da conta. Verifique!", "ALERTA DO SISTEMA", JOptionPane.WARNING_MESSAGE);
                EditaValorVencimentoParcelasReceberDialog dialog = new EditaValorVencimentoParcelasReceberDialog(null, true, (ArrayList<FinanceiroParcelas>) model.getDataSet(), ClasseUtilitaria.parseToBig(jtfTotal.getText()), ClasseUtilitaria.parseToBig(jTF_entrada.getText()), false);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                if (dialog.importaListaParcelas() != null) {
                    model.fireTableDataChanged();
                }
            }
        }
}//GEN-LAST:event_jB_salvarActionPerformed

    private void jB_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelar1ActionPerformed
        dispose();
}//GEN-LAST:event_jB_cancelar1ActionPerformed

    private void jTF_numero_de_diasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_numero_de_diasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtfTotal.requestFocus();
        }
    }//GEN-LAST:event_jTF_numero_de_diasKeyPressed

    private void jtParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtParcelasMouseClicked
        if (evt.getClickCount() >= 2) {
            Object[] opcao = {"SIM", "NÃO"};
            int c = JOptionPane.showOptionDialog(
                    this, "Deseja editar as parcelas?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opcao, opcao[1]);
            if (c == 0) {
                try {
                    entraModoEdicao();
                } catch (Exception e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
                }
            }
        }
    }//GEN-LAST:event_jtParcelasMouseClicked

    private void jCB_mesmo_dia_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_mesmo_dia_mesActionPerformed
        if (jCB_mesmo_dia_mes.isSelected()) {
            jTF_numero_de_dias.setEnabled(false);
        } else {
            jTF_numero_de_dias.setEnabled(true);
        }
    }//GEN-LAST:event_jCB_mesmo_dia_mesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FinalVendaParcelas dialog = new FinalVendaParcelas(null, true, null);
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
    private javax.swing.JButton jB_cancelar1;
    private javax.swing.JButton jB_gerar;
    private javax.swing.JButton jB_salvar;
    private javax.swing.JCheckBox jCB_mesmo_dia_mes;
    private javax.swing.JLabel jL_cor;
    private javax.swing.JLabel jL_observacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTF_cod_cliente;
    private javax.swing.JTextField jTF_documento;
    private javax.swing.JFormattedTextField jTF_emissao;
    private javax.swing.JTextField jTF_entrada;
    private javax.swing.JTextField jTF_nome_cliente;
    private javax.swing.JTextField jTF_numero_de_dias;
    private org.jdesktop.swingx.JXDatePicker jTF_p_venc;
    private javax.swing.JTextField jTF_parcelas;
    private javax.swing.JTextField jTF_referente;
    private javax.swing.JTable jtParcelas;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables

    public void gerarParcelas() {
        model.removeAll();
        FinanceiroParcelas financeiroParcelas;
        if (ClasseUtilitaria.parseToBig(jTF_entrada.getText()).compareTo(BigDecimal.ZERO) > 0) {
            financeiroParcelas = new FinanceiroParcelas();
            financeiroParcelas.setData_pagamento(new Date());
            financeiroParcelas.setData_vencimento(new Date());
            financeiroParcelas.setLancamento(1);
            financeiroParcelas.setParcela("ENTRADA");
            financeiroParcelas.setStatus("PG");
            financeiroParcelas.setValor(ClasseUtilitaria.parseToBig(jTF_entrada.getText()));
            financeiroParcelas.setValor_pago(ClasseUtilitaria.parseToBig(jTF_entrada.getText()));
            model.addRow(financeiroParcelas);
        }
        listaParcelasFds.clear();
        BigDecimal valor_Parcela;
        boolean temEntrada = false;
        if (ClasseUtilitaria.parseToBig(jTF_entrada.getText()).compareTo(BigDecimal.ZERO) > 0) {
            valor_Parcela = (ClasseUtilitaria.parseToBig(jtfTotal.getText()).subtract(ClasseUtilitaria.parseToBig(jTF_entrada.getText()))).divide(ClasseUtilitaria.parseToBig(jTF_parcelas.getText()), 6, RoundingMode.HALF_DOWN);
            temEntrada = true;
        } else {
            valor_Parcela = ClasseUtilitaria.parseToBig(jtfTotal.getText()).divide(ClasseUtilitaria.parseToBig(jTF_parcelas.getText()));
        }
        boolean primeiraData = true;
        int i = 0;
        Date data_cadastro = jTF_p_venc.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data_cadastro);
        int parcelas = Integer.parseInt(jTF_parcelas.getText());
        while (parcelas > i) {
            if (primeiraData) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(data_cadastro);
                financeiroParcelas = new FinanceiroParcelas();
                financeiroParcelas.setData_pagamento(null);
                financeiroParcelas.setData_vencimento(data_cadastro);
                financeiroParcelas.setLancamento(model.getRowCount() + 1);
                financeiroParcelas.setParcela("1/" + jTF_parcelas.getText());
                financeiroParcelas.setStatus("NAO");
                financeiroParcelas.setValor(valor_Parcela);
                financeiroParcelas.setValor_pago(BigDecimal.ZERO);
                model.addRow(financeiroParcelas);
                i++;
                primeiraData = false;
            } else {
                if (jCB_mesmo_dia_mes.isSelected()) {
                    calendar.add(Calendar.MONTH, 1);
                    data_cadastro = calendar.getTime();
                } else {
                    calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(jTF_numero_de_dias.getText()));
                    data_cadastro = calendar.getTime();
                }
                int linha = jtParcelas.getRowCount();
                if (temEntrada) {
                    linha--;
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(data_cadastro);
                int day = cal.get(Calendar.DAY_OF_WEEK);
                if (retornaDiaDaSemana(day).equalsIgnoreCase("sábado") || retornaDiaDaSemana(day).equalsIgnoreCase("domingo")) {
                    listaParcelasFds.add(i + 1 + "");
                }
                financeiroParcelas = new FinanceiroParcelas();
                financeiroParcelas.setData_pagamento(null);
                financeiroParcelas.setData_vencimento(data_cadastro);
                financeiroParcelas.setLancamento(model.getRowCount() + 1);
                financeiroParcelas.setParcela(linha + 1 + "/" + jTF_parcelas.getText());
                financeiroParcelas.setStatus("NAO");
                financeiroParcelas.setValor(valor_Parcela);
                financeiroParcelas.setValor_pago(BigDecimal.ZERO);
                model.addRow(financeiroParcelas);
                i++;
            }
        }
        if (!listaParcelasFds.isEmpty()) {
            jL_cor.setOpaque(true);
            jL_cor.setBackground(Color.red);

            jL_observacao.setText("Parcelas para fim de semana: " + listaParcelasFds.toString());
        } else {
            jL_cor.setOpaque(false);
            jL_cor.setBackground(null);

            jL_observacao.setText("");
        }
    }

    public void salvar() {
        cr.setEntrada(ClasseUtilitaria.parseToBig(jTF_entrada.getText()));
        cr.setNumero_parcelas(Integer.valueOf(jTF_parcelas.getText()));
        cr.setData_edicao(new Date());
        cr.setId_usuario_edicao(_FuncionarioLogado.getId());
        Fachada.getInstancia().editarContas_ReceberJDBC(cr);
        for (FinanceiroParcelas parcela : model.getDataSet()) {
            parcela.setFinanceiro(cr);

            if (parcela.getParcela().equalsIgnoreCase("ENTRADA")) {
                parcela.setStatus("PG");
                parcela.setData_pagamento(new Date());
            } else {
                parcela.setStatus("NAO");
            }
            Fachada.getInstancia().incluirParcelas_receberJDBC(parcela);
            salvarPagamento(parcela);
        }
        MensagemGUI mensagemGUI = new MensagemGUI(null, true, true, 1500);
        mensagemGUI.setMensagem("Conta salva com sucesso!");
        mensagemGUI.setLocationRelativeTo(null);
        mensagemGUI.setVisible(true);
        dispose();
    }

    public static String repeat(String texto, int quantidade) {
        StringBuffer retorno = new StringBuffer();
        for (int j = 0; j < quantidade; j++) {
            retorno.append(texto);
        }
        return retorno.toString();
    }

    private void entraModoEdicao() {
        ArrayList<FinanceiroParcelas> listaParcelas = new ArrayList<>();
        for (int i = 0; i < jtParcelas.getRowCount(); i++) {
            if (!jtParcelas.getModel().getValueAt(i, 3).toString().equalsIgnoreCase("ENTRADA")) {
                Date date = null;
                BigDecimal valor = ClasseUtilitaria.parseToBig((String) jtParcelas.getModel().getValueAt(i, 1));
                String data_venc = (String) (jtParcelas.getModel().getValueAt(i, 2));
                String formato = "dd/MM/yyyy";
                try {
                    date = new SimpleDateFormat(formato).parse(data_venc);
                } catch (ParseException ex) {
                    Logger.getLogger(FinalVendaParcelas.class.getName()).log(Level.SEVERE, null, ex);
                }
                FinanceiroParcelas p = new FinanceiroParcelas();
                p.setData_vencimento(date);
                p.setValor(valor);
                listaParcelas.add(p);

            }
        }
        EditaValorVencimentoParcelasReceberDialog dialog = new EditaValorVencimentoParcelasReceberDialog(null, true, listaParcelas, ClasseUtilitaria.parseToBig(jtfTotal.getText()), ClasseUtilitaria.parseToBig(jTF_entrada.getText()), false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        DefaultTableModel dtm = (DefaultTableModel) jtParcelas.getModel();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (dialog.importaEntrada() > 0) {
            int index = 1;
            for (int i = 0; i < dialog.importaListaParcelas().size(); i++) {
                dtm.setValueAt(format.format(dialog.importaListaParcelas().get(i).getData_vencimento()), index, 2);
                dtm.setValueAt(String.valueOf(dialog.importaListaParcelas().get(i).getValor()), index, 1);
                index++;
            }
        } else if (dialog.importaEntrada() == 0) {
            int index = 0;
            for (int i = 0; i < dialog.importaListaParcelas().size(); i++) {
                dtm.setValueAt(format.format(dialog.importaListaParcelas().get(i).getData_vencimento()), index, 2);
                dtm.setValueAt(String.valueOf(dialog.importaListaParcelas().get(i).getValor()), index, 1);
                index++;
            }
        }
    }

    public String retornaDiaDaSemana(int _diaSemana) {
        String diaSemana = null;
        switch (_diaSemana) {
            case 1: {
                diaSemana = "Domingo";
                break;
            }
            case 2: {
                diaSemana = "Segunda-feira";
                break;
            }
            case 3: {
                diaSemana = "Terça-feira";
                break;
            }
            case 4: {
                diaSemana = "Quarta-feira";
                break;
            }
            case 5: {
                diaSemana = "Quinta-feira";
                break;
            }
            case 6: {
                diaSemana = "Sexta-feira";
                break;
            }
            case 7: {
                diaSemana = "Sábado";
                break;
            }
        }
        return diaSemana;
    }

    private boolean verificaValorParcelas_Conta() {
        BigDecimal totalConta = ClasseUtilitaria.parseToBig(jtfTotal.getText());
        return model.getTotalParcelas().setScale(4, RoundingMode.HALF_UP).compareTo(totalConta.setScale(4, RoundingMode.HALF_UP)) == 0;
    }

    private void carregaDados() {
        SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
        String data = in.format(this.cr.getData_emissao());
        jTF_emissao.setText(data);

        this.cliente = this.cr.getCliente();
        jTF_cod_cliente.setText(this.cliente.getId().toString());
        jTF_nome_cliente.setText(this.cliente.getNome());

        jTF_referente.setText(this.cr.getReferente());
        jTF_documento.setText(this.cr.getDocumento());
        jTF_entrada.setText(ClasseUtilitaria.fmtBig(this.cr.getEntrada(), 2));
        jtfTotal.setText(ClasseUtilitaria.fmtBig(this.cr.getValor_total().add(this.cr.getEntrada()), 2));
        Date dataVencimento = null;
        try {
            dataVencimento = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(jTF_emissao.getText());
            dataVencimento.setDate(dataVencimento.getDate() + 30);
        } catch (ParseException ex) {
            Logger.getLogger(FinalVendaParcelas.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTF_p_venc.setDate(dataVencimento);
    }

    private void configuraTableModel() {
        jtParcelas.setModel(new TableModelFinanceiro(jtParcelas));
        jtParcelas.setSelectionModel(new DefaultListSelectionModel() {

            @Override
            public String toString() {
                return "gridFinanceiro";
            }
        });

        jtParcelas.setAutoCreateColumnsFromModel(false);
        jtParcelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        FontMetrics fm = jtParcelas.getFontMetrics(jtParcelas.getFont());
        jtParcelas.setColumnModel(new FinanceiroColumnModel(fm));
        jtParcelas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        model = (TableModelFinanceiro) jtParcelas.getModel();
    }

    private void salvarPagamento(FinanceiroParcelas parcela) {
        if (parcela.getStatus().equals("PG")) {
            FinanceiroRecPag recPag = new FinanceiroRecPag();
            recPag.setData_recebimento(new Date());
            recPag.setHora_recebimento(ClasseUtilitaria.fmtHora24.format(new Date()));
            recPag.setId_parcelas_receber(parcela.getId());
            recPag.setValor_recebido(parcela.getValor_pago());
            Fachada.getInstancia().incluirHistoricoRecebimentoParcelasReceberJDBC(recPag);
        }
    }
}
