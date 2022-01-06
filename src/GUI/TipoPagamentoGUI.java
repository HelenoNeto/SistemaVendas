package GUI;

import Negocios.Fachada;
import Negocios.TipoPagamento;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static sistema.gas.SISTEMA_GAS._FuncionarioLogado;

public class TipoPagamentoGUI extends javax.swing.JDialog {

    private TipoPagamento tipoPagamento = null;
    private boolean consultar = false;
    public static boolean cancelou = false;

    public TipoPagamentoGUI(java.awt.Frame parent, boolean modal, boolean consultar) {
        super(parent, modal);
        initComponents();
        listarTipoPagamento();
        this.consultar = consultar;

        jTF_pesquisar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        limparTabela();
                        ArrayList listTipo = Fachada.getInstancia().consultarTipoPagamento(
                                "select * from tipo_pagamento where descricao like '" + jTF_pesquisar.getText() + "%' or id like '" + jTF_pesquisar.getText() + "'");
                        DefaultTableModel dtm = (DefaultTableModel) jT_tipo_pagamento.getModel();
                        int i = 0;
                        while (listTipo.size() > i) {
                            TipoPagamento tPagamento = (TipoPagamento) listTipo.get(i);
                            dtm.addRow(new Object[]{tPagamento.getId(), tPagamento.getDescricao()});
                            i++;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TipoPagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN
                        && jT_tipo_pagamento.getRowCount() > 0) {
                    jT_tipo_pagamento.addRowSelectionInterval(0, 0);
                    jT_tipo_pagamento.requestFocus();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();
        buttonGroupVinculo = new javax.swing.ButtonGroup();
        jTP_tipo_pagamento = new javax.swing.JTabbedPane();
        jP_consultar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_tipo_pagamento = new javax.swing.JTable();
        jB_novo = new javax.swing.JButton();
        jB_selecionado = new javax.swing.JButton();
        jB_fechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTF_pesquisar = new org.jdesktop.swingx.JXSearchField();
        jP_cadastrar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTF_codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTF_descricao = new javax.swing.JTextField();
        jB_salvar = new javax.swing.JButton();
        jB_editar = new javax.swing.JButton();
        jB_excluir = new javax.swing.JButton();
        jB_voltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jCB_gerarConta = new javax.swing.JCheckBox();
        jCB_gerarNenhum = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipo Pagamento");
        setResizable(false);

        jTP_tipo_pagamento.setEnabled(false);
        jTP_tipo_pagamento.setFocusable(false);

        jP_consultar.setFocusable(false);

        jT_tipo_pagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_tipo_pagamento.getTableHeader().setReorderingAllowed(false);
        jT_tipo_pagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_tipo_pagamentoMouseClicked(evt);
            }
        });
        jT_tipo_pagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_tipo_pagamentoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jT_tipo_pagamento);
        if (jT_tipo_pagamento.getColumnModel().getColumnCount() > 0) {
            jT_tipo_pagamento.getColumnModel().getColumn(0).setResizable(false);
            jT_tipo_pagamento.getColumnModel().getColumn(0).setPreferredWidth(50);
            jT_tipo_pagamento.getColumnModel().getColumn(1).setResizable(false);
            jT_tipo_pagamento.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        jB_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adiciona.png"))); // NOI18N
        jB_novo.setText("Novo");
        jB_novo.setFocusable(false);
        jB_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_novoActionPerformed(evt);
            }
        });

        jB_selecionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jB_selecionado.setText("Selecionado");
        jB_selecionado.setFocusable(false);
        jB_selecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_selecionadoActionPerformed(evt);
            }
        });

        jB_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_fechar.setText("Fechar");
        jB_fechar.setFocusable(false);
        jB_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_fecharActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        jTF_pesquisar.setPrompt("Buscar");

        javax.swing.GroupLayout jP_consultarLayout = new javax.swing.GroupLayout(jP_consultar);
        jP_consultar.setLayout(jP_consultarLayout);
        jP_consultarLayout.setHorizontalGroup(
            jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_consultarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jB_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jB_selecionado)
                .addGap(0, 0, 0)
                .addComponent(jB_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_consultarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_fechar, jB_novo, jB_selecionado});

        jP_consultarLayout.setVerticalGroup(
            jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTF_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jB_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jB_selecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jB_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jP_consultarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_fechar, jB_novo, jB_selecionado});

        jTP_tipo_pagamento.addTab("Consultar", jP_consultar);

        jP_cadastrar.setFocusable(false);

        jLabel2.setText("Código:");

        jTF_codigo.setEditable(false);
        jTF_codigo.setEnabled(false);
        jTF_codigo.setFocusable(false);

        jLabel3.setText("Descrição:");

        jB_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jB_salvar.setText("Salvar");
        jB_salvar.setFocusable(false);
        jB_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvarActionPerformed(evt);
            }
        });

        jB_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/wand.png"))); // NOI18N
        jB_editar.setText("Editar");
        jB_editar.setFocusable(false);
        jB_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_editarActionPerformed(evt);
            }
        });

        jB_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_closed.png"))); // NOI18N
        jB_excluir.setText("Excluir");
        jB_excluir.setFocusable(false);
        jB_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_excluirActionPerformed(evt);
            }
        });

        jB_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1315941262_sign-out.png"))); // NOI18N
        jB_voltar.setText("Voltar");
        jB_voltar.setFocusable(false);
        jB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_voltarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Outras Configurações"));

        buttonGroupVinculo.add(jCB_gerarConta);
        jCB_gerarConta.setText("Gerar uma conta?");
        jCB_gerarConta.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        buttonGroupVinculo.add(jCB_gerarNenhum);
        jCB_gerarNenhum.setText("Nenhum?");
        jCB_gerarNenhum.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCB_gerarConta)
                .addGap(52, 52, 52)
                .addComponent(jCB_gerarNenhum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCB_gerarConta)
                    .addComponent(jCB_gerarNenhum))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jP_cadastrarLayout = new javax.swing.GroupLayout(jP_cadastrar);
        jP_cadastrar.setLayout(jP_cadastrarLayout);
        jP_cadastrarLayout.setHorizontalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_cadastrarLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jB_salvar)
                        .addGap(0, 0, 0)
                        .addComponent(jB_editar)
                        .addGap(0, 0, 0)
                        .addComponent(jB_excluir)
                        .addGap(0, 0, 0)
                        .addComponent(jB_voltar)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addGroup(jP_cadastrarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTF_descricao)
                                    .addGroup(jP_cadastrarLayout.createSequentialGroup()
                                        .addComponent(jTF_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jP_cadastrarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_editar, jB_excluir, jB_salvar, jB_voltar});

        jP_cadastrarLayout.setVerticalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTF_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTF_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_salvar)
                    .addComponent(jB_editar)
                    .addComponent(jB_excluir)
                    .addComponent(jB_voltar))
                .addGap(5, 5, 5))
        );

        jP_cadastrarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_editar, jB_excluir, jB_salvar, jB_voltar});

        jTP_tipo_pagamento.addTab("Cadastrar", jP_cadastrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_tipo_pagamento)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_tipo_pagamento)
        );

        setSize(new java.awt.Dimension(566, 340));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_novoActionPerformed
        limparCampos();
        jTP_tipo_pagamento.setSelectedIndex(1);
        jTF_descricao.requestFocus();
        botoes(true, false, false);
    }//GEN-LAST:event_jB_novoActionPerformed

    private void jB_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarActionPerformed
        tipoPagamento = new TipoPagamento();
        tipoPagamento.setDescricao(jTF_descricao.getText().toUpperCase().trim());
        jCB_gerarConta.setActionCommand("C");
        jCB_gerarNenhum.setActionCommand("N");
        tipoPagamento.setTipo_vinculo(buttonGroupVinculo.getSelection().getActionCommand());
        tipoPagamento.setData_insercao(new Date());
        tipoPagamento.setExcluido(false);
        tipoPagamento.setId_usuario_insercao(_FuncionarioLogado.getId());
        try {
            Fachada.getInstancia().incluirTipoPagamento(tipoPagamento);
            if (consultar) {
                dispose();
            } else {
                limparCampos();
                JOptionPane.showMessageDialog(null, "Tipo de Pagamento inserido com sucesso!", "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE);
                listarTipoPagamento();
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! " + e.toString(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(TipoPagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jB_salvarActionPerformed

    private void jB_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_editarActionPerformed
        tipoPagamento.setDescricao(jTF_descricao.getText().toUpperCase().trim());
        jCB_gerarConta.setActionCommand("C");
        jCB_gerarNenhum.setActionCommand("N");
        tipoPagamento.setTipo_vinculo(buttonGroupVinculo.getSelection().getActionCommand());
        tipoPagamento.setData_edicao(new Date());
        tipoPagamento.setId_usuario_edicao(_FuncionarioLogado.getId());
        try {
            Fachada.getInstancia().editarTipoPagamento(tipoPagamento);
            if (consultar) {
                dispose();
            } else {
                limparCampos();
                JOptionPane.showMessageDialog(null, "Tipo de Pagamento editado com sucesso!", "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE);
                listarTipoPagamento();
            }
            jTP_tipo_pagamento.setSelectedIndex(0);
        } catch (HeadlessException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(TipoPagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_editarActionPerformed

    private void jT_tipo_pagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_tipo_pagamentoMouseClicked
        try {
            int row = jT_tipo_pagamento.getSelectedRow();
            int id_tipo_pagamento = (Integer) jT_tipo_pagamento.getModel().getValueAt(row, 0);
            ArrayList list = Fachada.getInstancia().consultarTipoPagamento("select * from tipo_pagamento where id = " + id_tipo_pagamento);
            tipoPagamento = (TipoPagamento) list.get(0);
            if (evt.getClickCount() == 2) {
                if (consultar) {
                    cancelou = false;
                    dispose();
                } else {
                    tipoPagamentoDoisClicks();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoPagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jT_tipo_pagamentoMouseClicked

    private void jB_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_excluirActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o tipo de pagamento?",
                "Alerta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            if (verificaPendencias()) {
                try {
                    tipoPagamento.setData_exclusao(new Date());
                    tipoPagamento.setId_usuario_exclusao(_FuncionarioLogado.getId());
                    Fachada.getInstancia().deletarTipoPagamento(tipoPagamento);
                    limparCampos();
                    JOptionPane.showMessageDialog(null, "Tipo de Pagamento excluído com sucesso!", "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    listarTipoPagamento();
                    jTP_tipo_pagamento.setSelectedIndex(0);
                } catch (HeadlessException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    JOptionPane.showMessageDialog(null, "Erro ao excluir. Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(TipoPagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao excluir. Erro: " + ex.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de pagamento vinculado a venda! Não é possível excluir o tipo de pagamento!", "Alerta do Sistema", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jB_excluirActionPerformed

    private void jB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_voltarActionPerformed
        jTP_tipo_pagamento.setSelectedIndex(0);
        limparCampos();
    }//GEN-LAST:event_jB_voltarActionPerformed

    private void jB_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_fecharActionPerformed
        if (consultar) {
            tipoPagamento = null;
            cancelou = true;
            dispose();
        } else {
            dispose();
        }
    }//GEN-LAST:event_jB_fecharActionPerformed

    private void jB_selecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_selecionadoActionPerformed
        try {
            int row = jT_tipo_pagamento.getSelectedRow();
            int id_tipo_pagamento = (Integer) jT_tipo_pagamento.getModel().getValueAt(row, 0);
            ArrayList list = Fachada.getInstancia().consultarTipoPagamento("select * from tipo_pagamento where id = " + id_tipo_pagamento);
            tipoPagamento = (TipoPagamento) list.get(0);
            if (consultar) {
                dispose();
            } else {
                tipoPagamentoDoisClicks();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoPagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_selecionadoActionPerformed

    private void jT_tipo_pagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_tipo_pagamentoKeyPressed
        try {
            int row = jT_tipo_pagamento.getSelectedRow();
            int id_tipo_pagamento = (Integer) jT_tipo_pagamento.getModel().getValueAt(row, 0);
            ArrayList list = Fachada.getInstancia().consultarTipoPagamento("select * from tipo_pagamento where id = " + id_tipo_pagamento);
            tipoPagamento = (TipoPagamento) list.get(0);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (consultar) {
                    cancelou = false;
                    dispose();
                } else {
                    tipoPagamentoDoisClicks();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoPagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jT_tipo_pagamentoKeyPressed
    public static void main(String args[]) {
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoPagamentoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TipoPagamentoGUI dialog = new TipoPagamentoGUI(new javax.swing.JFrame(), true, false);
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
    private javax.swing.ButtonGroup buttonGroupVinculo;
    private javax.swing.JButton jB_editar;
    private javax.swing.JButton jB_excluir;
    private javax.swing.JButton jB_fechar;
    private javax.swing.JButton jB_novo;
    private javax.swing.JButton jB_salvar;
    private javax.swing.JButton jB_selecionado;
    private javax.swing.JButton jB_voltar;
    private javax.swing.JCheckBox jCB_gerarConta;
    private javax.swing.JCheckBox jCB_gerarNenhum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jP_cadastrar;
    private javax.swing.JPanel jP_consultar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_codigo;
    private javax.swing.JTextField jTF_descricao;
    private org.jdesktop.swingx.JXSearchField jTF_pesquisar;
    private javax.swing.JTabbedPane jTP_tipo_pagamento;
    private javax.swing.JTable jT_tipo_pagamento;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    // End of variables declaration//GEN-END:variables

    private void listarTipoPagamento() {
        try {
            limparTabela();
            ArrayList list = Fachada.getInstancia().consultarTipoPagamento("select * from tipo_pagamento");
            int i = 0;
            DefaultTableModel dtm = (DefaultTableModel) jT_tipo_pagamento.getModel();
            while (list.size() > i) {
                TipoPagamento tp = (TipoPagamento) list.get(i);
                dtm.addRow(new Object[]{tp.getId(), tp.getDescricao()});
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoPagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limparTabela() {
        DefaultTableModel dtm = (DefaultTableModel) jT_tipo_pagamento.getModel();
        dtm.setRowCount(0);
    }

    private void tipoPagamentoDoisClicks() {
        limparCampos();
        jTP_tipo_pagamento.setSelectedIndex(1);
        jTF_codigo.setText(String.valueOf(tipoPagamento.getId()));
        jTF_descricao.setText(tipoPagamento.getDescricao());
        if (tipoPagamento.getTipo_vinculo().equals("N")) {
            jCB_gerarNenhum.setSelected(true);
            jCB_gerarConta.setSelected(false);
        } else {
            jCB_gerarConta.setSelected(true);
            jCB_gerarNenhum.setSelected(false);
        }
        botoes(false, true, true);
    }

    private void limparCampos() {
        jTF_descricao.setText("");
        jTF_codigo.setText("");
        jCB_gerarConta.setSelected(false);
        jCB_gerarNenhum.setSelected(true);
    }

    public TipoPagamento retornaObjeto() {
        if (!cancelou) {
            try {
                ArrayList list = Fachada.getInstancia().consultarTipoPagamento(
                        "select * from tipo_pagamento where id = " + tipoPagamento.getId());
                tipoPagamento = (TipoPagamento) list.get(0);
            } catch (SQLException ex) {
                Logger.getLogger(TipoPagamentoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tipoPagamento;
    }

    private boolean verificaPendencias() {
        return false;
    }

    private void botoes(boolean b, boolean b0, boolean b1) {
        jB_salvar.setEnabled(b);
        jB_editar.setEnabled(b0);
        jB_excluir.setEnabled(b1);
    }
}
