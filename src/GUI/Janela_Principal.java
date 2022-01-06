package GUI;

import Backup.BackupDialog;
import Relatorios.RelatorioClienteVasilhamePendente;
import Relatorios.RelatorioGerencial;
import Relatorios.RelatorioProduto;
import Utilitarios.Dir;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import sistema.gas.cliente.dados.ConectaBDCliente;
import sistema.gas.cliente.gui.ClienteDialogGUI;
import sistema.gas.unidadeProduto.gui.UnidadeProdutoGUI;

public final class Janela_Principal extends javax.swing.JFrame {

    private BufferedImage bi;
    private static final DateFormat FORMATO = new SimpleDateFormat("dd/MM/yy - HH:mm");
    static VendaGUI frameDavGui;

    public Janela_Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        botaoPrincipalCliente = new javax.swing.JButton();
        botaoPrincipalProduto = new javax.swing.JButton();
        botaoPrincipalOrcamento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jL_Logo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_cadastros = new javax.swing.JMenu();
        jMItem_cliente = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMItem_funcionarios = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMItem_grupo = new javax.swing.JMenuItem();
        jMItem_produto = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMItem_tipo_pagamento = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu_financeiro = new javax.swing.JMenu();
        jMenuItem_contas_receber = new javax.swing.JMenuItem();
        jMenu_relatorios = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setOpaque(false);

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setOpaque(false);

        botaoPrincipalCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botaoPrincipalCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1313596796_user-group-new.png"))); // NOI18N
        botaoPrincipalCliente.setText("Clientes");
        botaoPrincipalCliente.setFocusable(false);
        botaoPrincipalCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPrincipalClienteActionPerformed(evt);
            }
        });

        botaoPrincipalProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botaoPrincipalProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1313596714_shopping-cart.png"))); // NOI18N
        botaoPrincipalProduto.setText("Produtos");
        botaoPrincipalProduto.setFocusable(false);
        botaoPrincipalProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPrincipalProdutoActionPerformed(evt);
            }
        });

        botaoPrincipalOrcamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botaoPrincipalOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1313597002_xls.png"))); // NOI18N
        botaoPrincipalOrcamento.setText("Venda");
        botaoPrincipalOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPrincipalOrcamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoPrincipalCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoPrincipalProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(botaoPrincipalOrcamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(botaoPrincipalCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoPrincipalProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoPrincipalOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(331, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu_cadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/folder1_txt_maior.png"))); // NOI18N
        jMenu_cadastros.setText("CADASTROS");
        jMenu_cadastros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMItem_cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMItem_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMItem_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user_add.png"))); // NOI18N
        jMItem_cliente.setText("Clientes");
        jMItem_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMItem_clienteActionPerformed(evt);
            }
        });
        jMenu_cadastros.add(jMItem_cliente);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/empresa.png"))); // NOI18N
        jMenuItem11.setText("Empresa");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu_cadastros.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pedidos.png"))); // NOI18N
        jMenuItem12.setText("Entradas");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu_cadastros.add(jMenuItem12);

        jMItem_funcionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMItem_funcionarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMItem_funcionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/funcionarios.png"))); // NOI18N
        jMItem_funcionarios.setText("Funcionários/Usuários");
        jMItem_funcionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMItem_funcionariosActionPerformed(evt);
            }
        });
        jMenu_cadastros.add(jMItem_funcionarios);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jMenu1.setText("Produtos");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMItem_grupo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMItem_grupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMItem_grupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/grupo.png"))); // NOI18N
        jMItem_grupo.setText("Grupo");
        jMItem_grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMItem_grupoActionPerformed(evt);
            }
        });
        jMenu1.add(jMItem_grupo);

        jMItem_produto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMItem_produto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMItem_produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok.png"))); // NOI18N
        jMItem_produto.setText("Produto");
        jMItem_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMItem_produtoActionPerformed(evt);
            }
        });
        jMenu1.add(jMItem_produto);

        jMenuItem13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/kcmmidi.png"))); // NOI18N
        jMenuItem13.setText("Unidade Produto");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenu_cadastros.add(jMenu1);

        jMenuItem7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit1.png"))); // NOI18N
        jMenuItem7.setText("Saída Temporária");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu_cadastros.add(jMenuItem7);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/text_align_justify.png"))); // NOI18N
        jMenu6.setText("Tabelas Auxiliares");
        jMenu6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMItem_tipo_pagamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMItem_tipo_pagamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMItem_tipo_pagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tipoPagamento.png"))); // NOI18N
        jMItem_tipo_pagamento.setText("Tipo Pagamento");
        jMItem_tipo_pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMItem_tipo_pagamentoActionPerformed(evt);
            }
        });
        jMenu6.add(jMItem_tipo_pagamento);

        jMenuItem10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fornecedores.png"))); // NOI18N
        jMenuItem10.setText("Fornecedor");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenu_cadastros.add(jMenu6);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jMenuItem1.setText("Fechar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu_cadastros.add(jMenuItem1);

        jMenuBar1.add(jMenu_cadastros);

        jMenu_financeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/png_icone_financeiro.png"))); // NOI18N
        jMenu_financeiro.setText("FINANCEIRO");
        jMenu_financeiro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMenuItem_contas_receber.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem_contas_receber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem_contas_receber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/contas_receber.png"))); // NOI18N
        jMenuItem_contas_receber.setText("Contas Receber");
        jMenuItem_contas_receber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_contas_receberActionPerformed(evt);
            }
        });
        jMenu_financeiro.add(jMenuItem_contas_receber);

        jMenuBar1.add(jMenu_financeiro);

        jMenu_relatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1313517162_pdf.png"))); // NOI18N
        jMenu_relatorios.setText("RELATÓRIOS");
        jMenu_relatorios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio_16X16.png"))); // NOI18N
        jMenuItem2.setText("Vasilhames pendentes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu_relatorios.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio_16X16.png"))); // NOI18N
        jMenuItem3.setText("Contas a receber");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu_relatorios.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio_16X16.png"))); // NOI18N
        jMenuItem4.setText("Vendas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu_relatorios.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio_16X16.png"))); // NOI18N
        jMenuItem5.setText("Gerencial");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu_relatorios.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio_16X16.png"))); // NOI18N
        jMenuItem6.setText("Lucro");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu_relatorios.add(jMenuItem6);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio_16X16.png"))); // NOI18N
        jMenuItem8.setText("Visita de Clientes");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu_relatorios.add(jMenuItem8);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio_16X16.png"))); // NOI18N
        jMenuItem9.setText("Estoque");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu_relatorios.add(jMenuItem9);

        jMenuBar1.add(jMenu_relatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(jL_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(403, 403, 403)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(257, 257, 257))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jL_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private ActionListener hhMMss() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String formato = "hh:mm:ss";
                    Date agora = new java.util.Date();
                    SimpleDateFormat formata = new SimpleDateFormat(formato);
                    Point p = jL_Logo.getLocationOnScreen();
                    JToolTip tip = jL_Logo.createToolTip();
                    tip.setTipText(formata.format(agora));
                    PopupFactory popupFactory = PopupFactory.getSharedInstance();
                    Popup popup = popupFactory.getPopup(jL_Logo, tip, p.x + 10, p.y + 10);
                    popup.show();
                } catch (IllegalArgumentException exx) {
                    System.out.println("Erro: \n" + exx.getMessage());
                }
            }
        };
    }

    public void efeitoFadeIn(Janela_Principal.FadingIn gFadingIn) {
        this.setGlassPane(gFadingIn);
        gFadingIn.setVisible(true);
        gFadingIn.setOpaque(false);
        gFadingIn.beginFade();
    }
    private void jMItem_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMItem_clienteActionPerformed
        botaoPrincipalClienteActionPerformed(evt);
}//GEN-LAST:event_jMItem_clienteActionPerformed

    private void jMItem_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMItem_produtoActionPerformed
        botaoPrincipalProdutoActionPerformed(evt);
}//GEN-LAST:event_jMItem_produtoActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new EmpresaGUI().setVisible(true);
}//GEN-LAST:event_jMenuItem11ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        saindoDoSistema();
    }//GEN-LAST:event_formWindowClosing

    private void jMItem_funcionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMItem_funcionariosActionPerformed
        FuncionariosDialog funcionarios_Dialog = new FuncionariosDialog(this, true, false);
        funcionarios_Dialog.setLocationRelativeTo(null);
        funcionarios_Dialog.setVisible(true);
    }//GEN-LAST:event_jMItem_funcionariosActionPerformed

    private void jMenuItem_contas_receberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_contas_receberActionPerformed
        new ContasAReceberGUI().setVisible(true);
    }//GEN-LAST:event_jMenuItem_contas_receberActionPerformed

    private void jMItem_grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMItem_grupoActionPerformed
        GrupoDialogGUI g = new GrupoDialogGUI(this, true, false);
        g.setLocationRelativeTo(null);
        g.setVisible(true);
    }//GEN-LAST:event_jMItem_grupoActionPerformed

    private void jMItem_tipo_pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMItem_tipo_pagamentoActionPerformed
        TipoPagamentoGUI tipoPagamentoGUI = new TipoPagamentoGUI(this, true, false);
        tipoPagamentoGUI.setLocationRelativeTo(null);
        tipoPagamentoGUI.setVisible(true);
    }//GEN-LAST:event_jMItem_tipo_pagamentoActionPerformed

    private void botaoPrincipalOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPrincipalOrcamentoActionPerformed
        new VendaGUI().setVisible(true);
    }//GEN-LAST:event_botaoPrincipalOrcamentoActionPerformed

    private void botaoPrincipalProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPrincipalProdutoActionPerformed
        ProdutoDialog produtoDialog = new ProdutoDialog(this, true, false);
        produtoDialog.setLocationRelativeTo(null);
        produtoDialog.setVisible(true);
    }//GEN-LAST:event_botaoPrincipalProdutoActionPerformed

    private void botaoPrincipalClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPrincipalClienteActionPerformed
        ClienteDialogGUI clienteDialogGUI = new ClienteDialogGUI(this, true, false);
        clienteDialogGUI.setLocationRelativeTo(null);
        clienteDialogGUI.setVisible(true);
    }//GEN-LAST:event_botaoPrincipalClienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (Dir.KEY_TIPO_SISTEMA.equals("G")) {
            jMenuBar1.setBackground(new Color(240, 240, 240));
            getContentPane().setBackground(new Color(255, 255, 255));
            jPanel1.setBackground(new Color(255, 255, 255));
            jPanel5.setBackground(new Color(153, 204, 255));
        } else {
            jMenuBar1.setBackground(Color.darkGray);
            tela();
        }
        efeitoFadeIn(new Janela_Principal.FadingIn());
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(BorderLayout.CENTER, jL_Logo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.setMaximumSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize());
        this.setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize());
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        jMenu_cadastros.setToolTipText("Click para realizar cadastros.");
        jMenu_financeiro.setToolTipText("Click para realizar operações financeiras.");
        botaoPrincipalCliente.setToolTipText("Cadastro de Cliente.");
        botaoPrincipalProduto.setToolTipText("Cadastro de Produto.");
        botaoPrincipalOrcamento.setToolTipText("Faça um Orçamento.");

        if (Dir.KEY_TIPO_SISTEMA.equals("G")) {
            jMenuItem2.setVisible(true);
            jMenuItem8.setVisible(true);
            jMenuItem5.setVisible(true);
        } else {
            jMenuItem2.setVisible(false);
            jMenuItem8.setVisible(false);
            jMenuItem5.setVisible(false);
        }

        Timer t = new Timer(60000, new ClockAction());
        t.setInitialDelay(0);
        t.setRepeats(true);
        t.start();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        saindoDoSistema();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new RelatorioClienteVasilhamePendente().relatorio();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new ConsultaRelatorioContasReceberDataGUI().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ConsultaVendasDataDialog.TIPO_RELATORIO = 0;
        ConsultaVendasDataDialog consultaVendasDataDialog = new ConsultaVendasDataDialog(this, false);
        consultaVendasDataDialog.setLocationRelativeTo(null);
        consultaVendasDataDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new RelatorioGerencial().relatorioGerencial();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ConsultaVendasDataDialog.TIPO_RELATORIO = 1;
        ConsultaVendasDataDialog dialog = new ConsultaVendasDataDialog(this, false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        dispose();
        new AutenticacaoDialog().showLoginDialog();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        String[] list = {"A4", "CUPOM"};
        JComboBox jcb = new JComboBox(list);
        Object[] opcao = {"Relatório de venda"};
        int c = JOptionPane.showOptionDialog(
                this, jcb, "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opcao, opcao[0]);
        if (c == 0) {
            if (jcb.getSelectedIndex() == 0) {
                new RelatorioGerencial().relatorioVisitaDeCliente();
            } else {
                try {
                    GUI.CupomNaoFiscal.visitaDeClientes(ConectaBDCliente.getInstance().consultarClienteVisita());
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(Janela_Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            System.out.println("Cancelou!");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Object[] opcao = {"A4", "CUPOM"};
        int c = JOptionPane.showOptionDialog(
                this, "Escolha o tipo de impressão:", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opcao, opcao[0]);
        if (c == 0) {
            try {
                new RelatorioProduto().relatorioEstoque();
            } catch (IOException ex) {
                Logger.getLogger(Janela_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (c == 1) {
            try {
                CupomNaoFiscal.relatorioEstoque();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Janela_Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        FornecedorDialog fornecedorDialog = new FornecedorDialog(this, true, false);
        fornecedorDialog.setLocationRelativeTo(null);
        fornecedorDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new NotaEntradaDialog().setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        UnidadeProdutoGUI dialog = new UnidadeProdutoGUI(this, true, false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Janela_Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoPrincipalCliente;
    private javax.swing.JButton botaoPrincipalOrcamento;
    private javax.swing.JButton botaoPrincipalProduto;
    private javax.swing.JLabel jL_Logo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMItem_cliente;
    private javax.swing.JMenuItem jMItem_funcionarios;
    private javax.swing.JMenuItem jMItem_grupo;
    private javax.swing.JMenuItem jMItem_produto;
    private javax.swing.JMenuItem jMItem_tipo_pagamento;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItem_contas_receber;
    private javax.swing.JMenu jMenu_cadastros;
    private javax.swing.JMenu jMenu_financeiro;
    private javax.swing.JMenu jMenu_relatorios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

    public void tela() {
        File arquivo = new File(Dir.imagens_internas + "logo.JPG");
        try {
            bi = ImageIO.read(arquivo); //carrega a imagem real num buffer  
        } catch (IOException ex) {
            Logger.getLogger(Janela_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //adiciona a acao de resized  
        jL_Logo.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                atualizarJLabel();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(BorderLayout.CENTER, jL_Logo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void atualizarJLabel() {
        if (jL_Logo.getSize().width == 0 || jL_Logo.getSize().height == 0) {
            return;
        }
        BufferedImage aux = new BufferedImage(jL_Logo.getSize().width, jL_Logo.getSize().height, bi.getType());//cria um buffer auxiliar com o tamanho desejado  
        Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao  
        AffineTransform at = AffineTransform.getScaleInstance((double) jL_Logo.getSize().width / bi.getWidth(), (double) jL_Logo.getSize().height / bi.getHeight());//cria a transformacao  
        g.drawRenderedImage(bi, at);//pinta e transforma a imagem real no auxiliar  
        jL_Logo.setIcon(new ImageIcon(aux));// seta no jlabel  
    }

    /**
     * Método para atualizar a hora no formulário. Não é thread-safe, portanto,
     * se o utilizado fora da thread da AWT, deve-se utilizar um dos comandos da
     * EventQueue (invokeLater ou invokeAndWait).
     *
     * @param date
     */
    public void setHora(Date date) {
        if (Dir.KEY_TIPO_SISTEMA.equals("G")) {
            setTitle("HJSN SISTEMAS - SISTEMA GÁS - JANELA PRINCIPAL - " + FORMATO.format(date));
        } else {
            setTitle("HJSN SISTEMAS - JANELA PRINCIPAL - " + FORMATO.format(date));
        }
    }

    private void saindoDoSistema() {
        Object[] op = {"SIM, fazendo BACKUP", "Sim", "Não!"};
        int opEscolhida = JOptionPane.showOptionDialog(this, "Deseja sair do programa?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
        if (opEscolhida == 0) {
            //fazer backup
            BackupDialog backupDialog;
            if (opEscolhida == 0) {
                backupDialog = new BackupDialog(this, true, null);
                backupDialog.setLocationRelativeTo(null);
                backupDialog.setVisible(true);
            }
        } else if (opEscolhida == 1) {
            System.exit(0);
        }
    }

    /**
     * Action que contém o código que atuará na nossa thread. Basicamente, ele
     * chama o método setHora de segundo em segundo, passando a data atual. Roda
     * diretamente na thread da AWT.
     */
    private class ClockAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Só podemos chamar setHora diretamente dessa  
            // forma, pois esse Runnable é uma InnerClass não  
            // estática.  
            setHora(new Date());
        }
    }

    public class FadingIn extends JPanel implements ActionListener {

        private float opacity = 1f;
        private javax.swing.Timer fadeTimer;

        public void beginFade() {
            fadeTimer = new javax.swing.Timer(50, this);
            fadeTimer.setInitialDelay(0);
            fadeTimer.start();
        }

        public void beginFade(float opacity) {
            this.opacity = opacity;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            opacity -= .03;
            if (opacity < 0) {
                opacity = 0f;
                fadeTimer.stop();
                fadeTimer = null;
            }
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
