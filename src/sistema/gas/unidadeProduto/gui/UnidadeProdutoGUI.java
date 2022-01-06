package sistema.gas.unidadeProduto.gui;

import sistema.gas.unidadeProduto.dados.ConectaBDUnidadeProduto;
import sistema.gas.unidadeProduto.negocios.UnidadeProduto;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UnidadeProdutoGUI extends javax.swing.JDialog {

    private UnidadeProduto uP = null;
    private final boolean consultar;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UnidadeProdutoGUI(java.awt.Frame parent, boolean modal, boolean consultar) {
        super(parent, modal);
        initComponents();
        this.consultar = consultar;
        jB_salvar.setEnabled(false);
        jB_editar.setEnabled(false);
        jB_excluir.setEnabled(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Utilitarios.Dir.imagens_internas + "icone.png"));
        jL_codigo.setForeground(Color.BLUE);
        jRB_sim.setSelected(true);
        jT_unidadeProduto.getColumnModel().getColumn(0).setPreferredWidth(15);
        jT_unidadeProduto.getColumnModel().getColumn(1).setPreferredWidth(150);
        jT_unidadeProduto.getColumnModel().getColumn(2).setPreferredWidth(20);
        listarUnidadeProduto();
        botaoSalvar(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_fracionar = new javax.swing.ButtonGroup();
        jTP_unidadeProduto = new javax.swing.JTabbedPane();
        jP_consultar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_unidadeProduto = new javax.swing.JTable();
        jC_tipo_pesq = new javax.swing.JComboBox();
        jTF_pesquisar = new javax.swing.JTextField();
        jB_pesquisar = new javax.swing.JButton();
        jB_novo = new javax.swing.JButton();
        jbSelecao = new javax.swing.JButton();
        jB_cancelar = new javax.swing.JButton();
        jP_cadastrar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jL_codigo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTF_nome = new javax.swing.JTextField();
        jB_salvar = new javax.swing.JButton();
        jB_excluir = new javax.swing.JButton();
        jB_editar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jRB_sim = new javax.swing.JRadioButton();
        jRB_nao = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jTF_descricao = new javax.swing.JTextField();
        jB_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Unidade Produto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jT_unidadeProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Fracionar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_unidadeProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_unidadeProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jT_unidadeProduto);

        jC_tipo_pesq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NOME", "CODIGO" }));
        jC_tipo_pesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_tipo_pesqActionPerformed(evt);
            }
        });

        jTF_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_pesquisarKeyPressed(evt);
            }
        });

        jB_pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sport_raquet.png"))); // NOI18N
        jB_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisarActionPerformed(evt);
            }
        });

        jB_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adiciona.png"))); // NOI18N
        jB_novo.setText("Novo");
        jB_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_novoActionPerformed(evt);
            }
        });

        jbSelecao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jbSelecao.setText("Seleção");
        jbSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSelecaoActionPerformed(evt);
            }
        });

        jB_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_cancelar.setText("Fechar");
        jB_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_consultarLayout = new javax.swing.GroupLayout(jP_consultar);
        jP_consultar.setLayout(jP_consultarLayout);
        jP_consultarLayout.setHorizontalGroup(
            jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jP_consultarLayout.createSequentialGroup()
                        .addComponent(jC_tipo_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB_pesquisar)))
                .addGap(5, 5, 5))
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jB_novo)
                .addGap(0, 0, 0)
                .addComponent(jbSelecao)
                .addGap(0, 0, 0)
                .addComponent(jB_cancelar)
                .addGap(0, 72, Short.MAX_VALUE))
        );

        jP_consultarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_cancelar, jB_novo, jbSelecao});

        jP_consultarLayout.setVerticalGroup(
            jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_pesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jC_tipo_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTF_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbSelecao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jB_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        jP_consultarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_cancelar, jB_novo, jbSelecao});

        jTP_unidadeProduto.addTab("Consultar", jP_consultar);

        jLabel1.setText("Código:");

        jL_codigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setText("Nome:");

        jTF_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_nomeFocusLost(evt);
            }
        });
        jTF_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_nomeKeyPressed(evt);
            }
        });

        jB_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jB_salvar.setText("Salvar");
        jB_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvarActionPerformed(evt);
            }
        });

        jB_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_closed.png"))); // NOI18N
        jB_excluir.setText("Excluir");
        jB_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_excluirActionPerformed(evt);
            }
        });

        jB_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/wand.png"))); // NOI18N
        jB_editar.setText("Editar");
        jB_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_editarActionPerformed(evt);
            }
        });

        jLabel4.setText("Pode Fracionar:");

        buttonGroup_fracionar.add(jRB_sim);
        jRB_sim.setText("SIM");

        buttonGroup_fracionar.add(jRB_nao);
        jRB_nao.setText("NAO");

        jLabel5.setText("Descrição:");

        jTF_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_descricaoKeyPressed(evt);
            }
        });

        jB_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_sair.setText("Sair");
        jB_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_cadastrarLayout = new javax.swing.GroupLayout(jP_cadastrar);
        jP_cadastrar.setLayout(jP_cadastrarLayout);
        jP_cadastrarLayout.setHorizontalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_cadastrarLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)))
                    .addGroup(jP_cadastrarLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTF_descricao)
                    .addComponent(jTF_nome)
                    .addGroup(jP_cadastrarLayout.createSequentialGroup()
                        .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jL_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                                .addComponent(jRB_sim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRB_nao)))
                        .addGap(0, 197, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_cadastrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jB_salvar)
                .addGap(0, 0, 0)
                .addComponent(jB_editar)
                .addGap(0, 0, 0)
                .addComponent(jB_excluir)
                .addGap(0, 0, 0)
                .addComponent(jB_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jP_cadastrarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_editar, jB_excluir, jB_sair, jB_salvar});

        jP_cadastrarLayout.setVerticalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jL_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTF_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRB_sim)
                    .addComponent(jRB_nao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_excluir)
                    .addComponent(jB_salvar)
                    .addComponent(jB_editar)
                    .addComponent(jB_sair))
                .addContainerGap())
        );

        jP_cadastrarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_editar, jB_excluir, jB_sair, jB_salvar});

        jTP_unidadeProduto.addTab("Cadastrar", jP_cadastrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_unidadeProduto)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_unidadeProduto)
        );

        setSize(new java.awt.Dimension(432, 360));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_novoActionPerformed
        jTP_unidadeProduto.setSelectedIndex(1);
        jB_salvar.setEnabled(true);
        jB_editar.setEnabled(false);
        jB_excluir.setEnabled(false);
        limpar();
        botaoSalvar(true);
}//GEN-LAST:event_jB_novoActionPerformed

    private void jTF_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_nomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        }
    }//GEN-LAST:event_jTF_nomeKeyPressed

    private void jC_tipo_pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_tipo_pesqActionPerformed
    }//GEN-LAST:event_jC_tipo_pesqActionPerformed

    private void jTF_pesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_pesquisarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisarUnidade();
        }
    }//GEN-LAST:event_jTF_pesquisarKeyPressed

    private void jB_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisarActionPerformed
    }//GEN-LAST:event_jB_pesquisarActionPerformed

    private void jTF_descricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_descricaoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_descricaoKeyPressed

    private void jB_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarActionPerformed
        uP = new UnidadeProduto();
        uP.setDescricao(jTF_descricao.getText());
        uP.setNome(jTF_nome.getText());
        jRB_sim.setActionCommand("S");
        jRB_nao.setActionCommand("N");
        uP.setPodeFracionar(jRB_sim.isSelected());
        try {
            ConectaBDUnidadeProduto.getInstance().salvar(uP);
            JOptionPane.showMessageDialog(null, "Incluído com Sucesso!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
            if (consultar) {
                dispose();
            } else {
                limpar();
                listarUnidadeProduto();
            }
            jTP_unidadeProduto.setSelectedIndex(0);
        } catch (HeadlessException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar!", "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_salvarActionPerformed

    private void jTF_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_nomeFocusLost
        int length_nome = jTF_nome.getText().length();
        if (length_nome > 6) {
            JOptionPane.showMessageDialog(null, "Nome não pode conter mais que 6(seis) caracteres!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
            jTF_nome.setText("");
        } else {
            jTF_descricao.requestFocus();
        }
    }//GEN-LAST:event_jTF_nomeFocusLost

    private void jB_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_sairActionPerformed
        uP = null;
        limpar();
        listarUnidadeProduto();
        jTP_unidadeProduto.setSelectedIndex(0);
    }//GEN-LAST:event_jB_sairActionPerformed

    private void jT_unidadeProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_unidadeProdutoMouseClicked
        if (evt.getClickCount() == 2) {
            if (consultar) {
                dispose();
            } else {
                jB_salvar.setEnabled(false);
                jB_editar.setEnabled(true);
                jB_excluir.setEnabled(true);
                int row = jT_unidadeProduto.getSelectedRow();
                Integer id = (Integer) jT_unidadeProduto.getModel().getValueAt(row, 0);
                ArrayList arrayList = ConectaBDUnidadeProduto.getInstance().consultarPorTipo("ID", String.valueOf(id));
                uP = (UnidadeProduto) arrayList.get(0);
                jTP_unidadeProduto.setSelectedIndex(1);
                jTF_descricao.setText(uP.getDescricao());
                jTF_nome.setText(uP.getNome());
                jL_codigo.setText(String.valueOf(uP.getId()));

                jRB_sim.setSelected(uP.isPodeFracionar());
                jRB_nao.setSelected(!uP.isPodeFracionar());
            }
        }
    }//GEN-LAST:event_jT_unidadeProdutoMouseClicked

    private void jB_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_editarActionPerformed
        uP.setDescricao(jTF_descricao.getText());
        uP.setId(Integer.parseInt(jL_codigo.getText()));
        uP.setNome(jTF_nome.getText());
        jRB_sim.setActionCommand("S");
        jRB_nao.setActionCommand("N");
        uP.setPodeFracionar(jRB_sim.isSelected());
        try {
            ConectaBDUnidadeProduto.getInstance().salvar(uP);
            JOptionPane.showMessageDialog(null, "Editado com Sucesso!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
            if (consultar) {
                dispose();
            } else {
                limpar();
                listarUnidadeProduto();
                jTP_unidadeProduto.setSelectedIndex(0);
            }
        } catch (HeadlessException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao editar!", "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_editarActionPerformed

    private void jB_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_excluirActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(null, "Excluir?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                    == JOptionPane.YES_OPTION) {
                ConectaBDUnidadeProduto.getInstance().deletar(uP);
                JOptionPane.showMessageDialog(null, "Excluído com Sucesso!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                limpar();
                listarUnidadeProduto();
                jTP_unidadeProduto.setSelectedIndex(0);
            }
        } catch (HeadlessException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao excluir!", "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jB_excluirActionPerformed

    private void jbSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelecaoActionPerformed
        jB_salvar.setEnabled(false);
        jB_editar.setEnabled(true);
        jB_excluir.setEnabled(true);
        int row = jT_unidadeProduto.getSelectedRow();
        Integer id = (Integer) jT_unidadeProduto.getModel().getValueAt(row, 0);
        ArrayList arrayList = ConectaBDUnidadeProduto.getInstance().consultarPorTipo("ID", String.valueOf(id));
        uP = (UnidadeProduto) arrayList.get(0);
        jTP_unidadeProduto.setSelectedIndex(1);
        jTF_descricao.setText(uP.getDescricao());
        jTF_nome.setText(uP.getNome());
        jL_codigo.setText(String.valueOf(uP.getId()));

        jRB_sim.setSelected(jRB_sim.isSelected());
        jRB_nao.setSelected(!jRB_sim.isSelected());
    }//GEN-LAST:event_jbSelecaoActionPerformed

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        uP = null;
        dispose();
    }//GEN-LAST:event_jB_cancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        uP = null;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UnidadeProdutoGUI dialog = new UnidadeProdutoGUI(new javax.swing.JFrame(), true, false);
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
    private javax.swing.ButtonGroup buttonGroup_fracionar;
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_editar;
    private javax.swing.JButton jB_excluir;
    private javax.swing.JButton jB_novo;
    private javax.swing.JButton jB_pesquisar;
    private javax.swing.JButton jB_sair;
    private javax.swing.JButton jB_salvar;
    private javax.swing.JComboBox jC_tipo_pesq;
    private javax.swing.JLabel jL_codigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jP_cadastrar;
    private javax.swing.JPanel jP_consultar;
    private javax.swing.JRadioButton jRB_nao;
    private javax.swing.JRadioButton jRB_sim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_descricao;
    private javax.swing.JTextField jTF_nome;
    private javax.swing.JTextField jTF_pesquisar;
    private javax.swing.JTabbedPane jTP_unidadeProduto;
    private javax.swing.JTable jT_unidadeProduto;
    private javax.swing.JButton jbSelecao;
    // End of variables declaration//GEN-END:variables

    public void limparTabela() {
        DefaultTableModel tableData = (DefaultTableModel) jT_unidadeProduto.getModel();
        tableData.setRowCount(0);
        jT_unidadeProduto.setModel(tableData);
        jTF_pesquisar.requestFocus();
    }

    public final void botaoSalvar(boolean b) {
        jB_salvar.setEnabled(b);
    }

    private void limpar() {
        jTF_nome.setText("");
        jTF_descricao.setText("");
        jL_codigo.setText("");
    }

    private void listarUnidadeProduto() {
        limparTabela();
        ArrayList arrayList = ConectaBDUnidadeProduto.getInstance().consultarPorTipo("ID", "%%");
        int i = 0;
        DefaultTableModel dtm = (DefaultTableModel) jT_unidadeProduto.getModel();
        while (arrayList.size() > i) {
            UnidadeProduto unidadeProduto = (UnidadeProduto) arrayList.get(i);
            dtm.addRow(new Object[]{unidadeProduto.getId(), unidadeProduto.getNome(), (unidadeProduto.isPodeFracionar() ? "SIM" : "NÃO")});
            i++;
        }
    }

    private void pesquisarUnidade() {
        limparTabela();
        String dado = jC_tipo_pesq.getSelectedItem().toString();
        if (jC_tipo_pesq.getSelectedItem().equals("CODIGO")) {
            dado = "ID";
        }
        ArrayList arrayList = ConectaBDUnidadeProduto.getInstance().consultarPorTipo(dado, jTF_pesquisar.getText() + "%");
        int i = 0;
        DefaultTableModel dtm = (DefaultTableModel) jT_unidadeProduto.getModel();
        while (arrayList.size() > i) {
            UnidadeProduto unidadeProduto = (UnidadeProduto) arrayList.get(i);
            dtm.addRow(new Object[]{unidadeProduto.getId(), unidadeProduto.getNome(), (unidadeProduto.isPodeFracionar() ? "SIM" : "NÃO")});
            i++;
        }
    }

    public UnidadeProduto getUnidadeProduto() {
        return uP;
    }
}
