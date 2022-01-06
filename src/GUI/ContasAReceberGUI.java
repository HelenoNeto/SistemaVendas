package GUI;

import Negocios.*;
import Utilitarios.ClasseUtilitaria;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import static sistema.gas.SISTEMA_GAS._FuncionarioLogado;
import sistema.gas.cliente.dados.ConectaBDCliente;
import sistema.gas.cliente.gui.ClienteDialogGUI;

public class ContasAReceberGUI extends javax.swing.JFrame {

    private Financeiro cr = null;
    private FinanceiroParcelas pr = null;
    private final SimpleDateFormat fmtHora = new SimpleDateFormat("HH:mm:ss");
    private Cliente cliente;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ContasAReceberGUI() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Utilitarios.Dir.imagens_internas + "icone.png"));
        jCB_aReceber.setSelected(true);
        liberaDatasDePesquisas(false, true, true, false, jCB_data_vencimento);

        jTF_data_emissao_CR.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        botaoSalvar(false);

        jTF_nomeClienteBusca.setEditable(false);
        jTF_razaoCRNovo.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        buttonGroup_mostrar = new javax.swing.ButtonGroup();
        buttonGroup_data = new javax.swing.ButtonGroup();
        jTP_Contas_Receber = new javax.swing.JTabbedPane();
        jP_consultar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_contasReceber = new javax.swing.JTable();
        jB_abrirConta = new javax.swing.JButton();
        jB_cancelar = new javax.swing.JButton();
        jB_novoCR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCB_quitadas = new javax.swing.JCheckBox();
        jCB_abertas = new javax.swing.JCheckBox();
        jCB_pg_parcial = new javax.swing.JCheckBox();
        jCB_aReceber = new javax.swing.JCheckBox();
        jCB_geral = new javax.swing.JCheckBox();
        jCB_recebidas = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jXDP_dataInicialCR = new org.jdesktop.swingx.JXDatePicker();
        jXDP_dataFinalCR = new org.jdesktop.swingx.JXDatePicker();
        jCB_data_pagamento = new javax.swing.JCheckBox();
        jCB_data_vencimento = new javax.swing.JCheckBox();
        jCB_data_emissao = new javax.swing.JCheckBox();
        jB_dataNow = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTF_codClienteBusca = new javax.swing.JTextField();
        jTF_nomeClienteBusca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jB_pesquisarContasReceber = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTF_documentoCR = new javax.swing.JTextField();
        jB_pesquisar2CRDoc = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTF_id_parcela = new javax.swing.JTextField();
        jB_pesquisarIdParcela = new javax.swing.JButton();
        jCB_canceladas = new javax.swing.JCheckBox();
        jCB_data_exclusao = new javax.swing.JCheckBox();
        jB_quitarTotal = new javax.swing.JButton();
        jB_abrirParcela = new javax.swing.JButton();
        jB_quitarValor = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTF_valorPagarConta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jL_somaCR = new javax.swing.JTextField();
        jTF_pago = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jP_cadastrar = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTF_codClienteNovo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTF_referente_CR = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTF_total_CR = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTF_parcelas_CR = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTF_entrada_CR = new javax.swing.JTextField();
        jTF_data_emissao_CR = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jTF_documento_CR = new javax.swing.JTextField();
        jB_gerar_parc_CR = new javax.swing.JButton();
        jTF_data_p_venc_CR = new javax.swing.JFormattedTextField();
        jB_data3 = new javax.swing.JButton();
        jTF_razaoCRNovo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jT_gerar_parcelas_CR = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jB_cancelar_CR = new javax.swing.JButton();
        jB_editar = new javax.swing.JButton();
        jB_salvar_CR = new javax.swing.JButton();
        jB_cancelarConta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jL_codigo_receber = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONTAS A RECEBER");
        setResizable(false);

        jTP_Contas_Receber.setEnabled(false);
        jTP_Contas_Receber.setFocusable(false);

        jP_consultar.setBackground(new java.awt.Color(255, 255, 255));

        jT_contasReceber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id conta", "Id parcela", "Lançamento", "Status", "Parcela", "Vencimento", "Valor", "Valor Pago", "Restante", "Data pgto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_contasReceber.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jT_contasReceber.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jT_contasReceber.getTableHeader().setReorderingAllowed(false);
        jT_contasReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_contasReceberMouseClicked(evt);
            }
        });
        jT_contasReceber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jT_contasReceberFocusLost(evt);
            }
        });
        jT_contasReceber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_contasReceberKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jT_contasReceber);
        if (jT_contasReceber.getColumnModel().getColumnCount() > 0) {
            jT_contasReceber.getColumnModel().getColumn(0).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(0).setPreferredWidth(70);
            jT_contasReceber.getColumnModel().getColumn(1).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(1).setPreferredWidth(70);
            jT_contasReceber.getColumnModel().getColumn(2).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(2).setPreferredWidth(70);
            jT_contasReceber.getColumnModel().getColumn(3).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(3).setPreferredWidth(90);
            jT_contasReceber.getColumnModel().getColumn(4).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(4).setPreferredWidth(80);
            jT_contasReceber.getColumnModel().getColumn(5).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(5).setPreferredWidth(100);
            jT_contasReceber.getColumnModel().getColumn(6).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(6).setPreferredWidth(120);
            jT_contasReceber.getColumnModel().getColumn(7).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(7).setPreferredWidth(120);
            jT_contasReceber.getColumnModel().getColumn(8).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(8).setPreferredWidth(100);
            jT_contasReceber.getColumnModel().getColumn(9).setResizable(false);
            jT_contasReceber.getColumnModel().getColumn(9).setPreferredWidth(100);
        }

        jB_abrirConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jB_abrirConta.setText("Abrir Conta [F2]");
        jB_abrirConta.setFocusable(false);
        jB_abrirConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_abrirContaActionPerformed(evt);
            }
        });

        jB_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_cancelar.setText("Fechar");
        jB_cancelar.setFocusable(false);
        jB_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarActionPerformed(evt);
            }
        });

        jB_novoCR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        jB_novoCR.setText("Nova Conta");
        jB_novoCR.setFocusable(false);
        jB_novoCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_novoCRActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("MOSTRAR"));
        jPanel2.setFocusable(false);

        jCB_quitadas.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroup_mostrar.add(jCB_quitadas);
        jCB_quitadas.setText("QUITADAS");
        jCB_quitadas.setActionCommand("PG");
        jCB_quitadas.setFocusable(false);
        jCB_quitadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_quitadasActionPerformed(evt);
            }
        });

        jCB_abertas.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroup_mostrar.add(jCB_abertas);
        jCB_abertas.setText("ABERTAS");
        jCB_abertas.setActionCommand("NAO");
        jCB_abertas.setFocusable(false);
        jCB_abertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_abertasActionPerformed(evt);
            }
        });

        jCB_pg_parcial.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroup_mostrar.add(jCB_pg_parcial);
        jCB_pg_parcial.setText("PARCIAIS");
        jCB_pg_parcial.setActionCommand("PG PARCIAL");
        jCB_pg_parcial.setFocusable(false);
        jCB_pg_parcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_pg_parcialActionPerformed(evt);
            }
        });

        jCB_aReceber.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroup_mostrar.add(jCB_aReceber);
        jCB_aReceber.setText("A RECEBER");
        jCB_aReceber.setActionCommand("NAOANDPGPARCIAL");
        jCB_aReceber.setFocusable(false);
        jCB_aReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_aReceberActionPerformed(evt);
            }
        });

        jCB_geral.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroup_mostrar.add(jCB_geral);
        jCB_geral.setText("GERAL");
        jCB_geral.setActionCommand("%");
        jCB_geral.setFocusable(false);
        jCB_geral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_geralActionPerformed(evt);
            }
        });

        jCB_recebidas.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroup_mostrar.add(jCB_recebidas);
        jCB_recebidas.setText("RECEBIDAS");
        jCB_recebidas.setActionCommand("PGANDPGPARCIAL");
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCB_quitadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCB_abertas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCB_pg_parcial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCB_aReceber, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jCB_geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCB_recebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jCB_geral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCB_aReceber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCB_recebidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCB_quitadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCB_abertas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCB_pg_parcial)
                .addGap(56, 56, 56))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("FILTROS"));
        jPanel3.setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Período", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 255))); // NOI18N

        jCB_data_pagamento.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup_data.add(jCB_data_pagamento);
        jCB_data_pagamento.setSelected(true);
        jCB_data_pagamento.setText("Data De Pagamento");
        jCB_data_pagamento.setActionCommand("p.data_pagamento");
        jCB_data_pagamento.setFocusable(false);

        jCB_data_vencimento.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup_data.add(jCB_data_vencimento);
        jCB_data_vencimento.setText("Vencimento");
        jCB_data_vencimento.setActionCommand("p.data_vencimento");
        jCB_data_vencimento.setFocusable(false);

        jCB_data_emissao.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup_data.add(jCB_data_emissao);
        jCB_data_emissao.setText("Emissão");
        jCB_data_emissao.setActionCommand("c.data_emissao");
        jCB_data_emissao.setFocusable(false);

        jB_dataNow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dateHJ.png"))); // NOI18N
        jB_dataNow.setToolTipText("Clique para usar a Data de HOJE");
        jB_dataNow.setFocusable(false);
        jB_dataNow.setMaximumSize(new java.awt.Dimension(20, 20));
        jB_dataNow.setMinimumSize(new java.awt.Dimension(20, 20));
        jB_dataNow.setPreferredSize(new java.awt.Dimension(20, 20));
        jB_dataNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_dataNowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCB_data_pagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCB_data_vencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCB_data_emissao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jXDP_dataInicialCR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXDP_dataFinalCR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jB_dataNow, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCB_data_emissao)
                    .addComponent(jCB_data_vencimento)
                    .addComponent(jCB_data_pagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXDP_dataInicialCR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXDP_dataFinalCR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jB_dataNow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 255))); // NOI18N

        jTF_codClienteBusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_codClienteBuscaFocusLost(evt);
            }
        });
        jTF_codClienteBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_codClienteBuscaKeyPressed(evt);
            }
        });

        jTF_nomeClienteBusca.setFocusable(false);
        jTF_nomeClienteBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTF_nomeClienteBuscaMouseClicked(evt);
            }
        });
        jTF_nomeClienteBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_nomeClienteBuscaKeyPressed(evt);
            }
        });

        jLabel3.setText("Código");

        jLabel16.setText("Nome(Razão Social)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTF_codClienteBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTF_nomeClienteBusca)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_codClienteBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_nomeClienteBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jB_pesquisarContasReceber.setBackground(new java.awt.Color(153, 204, 255));
        jB_pesquisarContasReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sport_raquet.png"))); // NOI18N
        jB_pesquisarContasReceber.setBorderPainted(false);
        jB_pesquisarContasReceber.setContentAreaFilled(false);
        jB_pesquisarContasReceber.setFocusable(false);
        jB_pesquisarContasReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_pesquisarContasReceberMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jB_pesquisarContasReceberMouseExited(evt);
            }
        });
        jB_pesquisarContasReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisarContasReceberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_pesquisarContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jB_pesquisarContasReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PESQUISA ESPECÍFICA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 255))); // NOI18N
        jPanel10.setFocusable(false);

        jLabel24.setText("Documento:");

        jTF_documentoCR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTF_documentoCRMouseClicked(evt);
            }
        });
        jTF_documentoCR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_documentoCRKeyPressed(evt);
            }
        });

        jB_pesquisar2CRDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sport_raquet.png"))); // NOI18N
        jB_pesquisar2CRDoc.setBorderPainted(false);
        jB_pesquisar2CRDoc.setContentAreaFilled(false);
        jB_pesquisar2CRDoc.setFocusable(false);
        jB_pesquisar2CRDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_pesquisar2CRDocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jB_pesquisar2CRDocMouseExited(evt);
            }
        });
        jB_pesquisar2CRDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisar2CRDocActionPerformed(evt);
            }
        });

        jLabel14.setText("Parcela:");

        jTF_id_parcela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTF_id_parcelaMouseClicked(evt);
            }
        });
        jTF_id_parcela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_id_parcelaKeyPressed(evt);
            }
        });

        jB_pesquisarIdParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sport_raquet.png"))); // NOI18N
        jB_pesquisarIdParcela.setBorderPainted(false);
        jB_pesquisarIdParcela.setContentAreaFilled(false);
        jB_pesquisarIdParcela.setFocusable(false);
        jB_pesquisarIdParcela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_pesquisarIdParcelaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jB_pesquisarIdParcelaMouseExited(evt);
            }
        });
        jB_pesquisarIdParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisarIdParcelaActionPerformed(evt);
            }
        });

        jCB_canceladas.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup_mostrar.add(jCB_canceladas);
        jCB_canceladas.setText("CANCELADAS");
        jCB_canceladas.setActionCommand("canceladas");
        jCB_canceladas.setFocusable(false);
        jCB_canceladas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_canceladasActionPerformed(evt);
            }
        });

        jCB_data_exclusao.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup_data.add(jCB_data_exclusao);
        jCB_data_exclusao.setText("Por data de Cancelamento");
        jCB_data_exclusao.setActionCommand("c.DATA_EXCLUSAO");
        jCB_data_exclusao.setFocusable(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCB_canceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCB_data_exclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTF_id_parcela, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_pesquisarIdParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTF_documentoCR, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_pesquisar2CRDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTF_documentoCR, jTF_id_parcela});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_pesquisar2CRDoc, jB_pesquisarIdParcela});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jTF_id_parcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jB_pesquisarIdParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jTF_documentoCR))
                    .addComponent(jB_pesquisar2CRDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCB_canceladas)
                    .addComponent(jCB_data_exclusao))
                .addGap(25, 25, 25))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTF_documentoCR, jTF_id_parcela});

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_pesquisar2CRDoc, jB_pesquisarIdParcela});

        jB_quitarTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cifrão.PNG"))); // NOI18N
        jB_quitarTotal.setText("Quitar Conta Total");
        jB_quitarTotal.setFocusable(false);
        jB_quitarTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_quitarTotalActionPerformed(evt);
            }
        });

        jB_abrirParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jB_abrirParcela.setText("Abrir Parcela [enter]");
        jB_abrirParcela.setFocusable(false);
        jB_abrirParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_abrirParcelaActionPerformed(evt);
            }
        });

        jB_quitarValor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cifrão.PNG"))); // NOI18N
        jB_quitarValor.setText("Quitar Conta Por Valor");
        jB_quitarValor.setFocusable(false);
        jB_quitarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_quitarValorActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setText("Valor:");

        jTF_valorPagarConta.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jTF_valorPagarConta.setForeground(new java.awt.Color(0, 0, 255));
        jTF_valorPagarConta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_valorPagarConta.setText("0.00");
        jTF_valorPagarConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_valorPagarContaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_valorPagarContaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total:");

        jL_somaCR.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jL_somaCR.setForeground(new java.awt.Color(0, 0, 255));
        jL_somaCR.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jL_somaCR.setText("0.00");

        jTF_pago.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jTF_pago.setForeground(new java.awt.Color(0, 0, 255));
        jTF_pago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_pago.setText("0.00");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("Pago:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jL_somaCR, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jTF_valorPagarConta)
                    .addComponent(jTF_pago)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_valorPagarConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_somaCR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)))
        );

        javax.swing.GroupLayout jP_consultarLayout = new javax.swing.GroupLayout(jP_consultar);
        jP_consultar.setLayout(jP_consultarLayout);
        jP_consultarLayout.setHorizontalGroup(
            jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jP_consultarLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addGroup(jP_consultarLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_novoCR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jP_consultarLayout.createSequentialGroup()
                                .addComponent(jB_abrirParcela)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jP_consultarLayout.createSequentialGroup()
                                        .addComponent(jB_quitarTotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jB_quitarValor))
                                    .addGroup(jP_consultarLayout.createSequentialGroup()
                                        .addComponent(jB_abrirConta, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jB_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(22, 22, 22)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_consultarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_abrirConta, jB_abrirParcela, jB_cancelar, jB_novoCR, jB_quitarTotal, jB_quitarValor});

        jP_consultarLayout.setVerticalGroup(
            jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jP_consultarLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_consultarLayout.createSequentialGroup()
                        .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_abrirParcela)
                            .addComponent(jB_abrirConta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jB_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_quitarTotal)
                            .addComponent(jB_novoCR)
                            .addComponent(jB_quitarValor)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_consultarLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_consultarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_abrirConta, jB_abrirParcela, jB_cancelar, jB_novoCR, jB_quitarTotal, jB_quitarValor});

        jTP_Contas_Receber.addTab("Consultar", jP_consultar);

        jP_cadastrar.setFocusable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setText("Data emissão");

        jTF_codClienteNovo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_codClienteNovoFocusGained(evt);
            }
        });
        jTF_codClienteNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_codClienteNovoKeyPressed(evt);
            }
        });

        jLabel2.setText("COD. Cliente (F1)");

        jLabel4.setText("Razão social / Nome");

        jLabel6.setText("Referente");

        jTF_referente_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_referente_CRKeyPressed(evt);
            }
        });

        jLabel9.setText("Primeiro Venc.");

        jLabel10.setText("Valor total");

        jTF_total_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_total_CRKeyPressed(evt);
            }
        });

        jLabel11.setText("Nº parcelas");

        jTF_parcelas_CR.setText("1");
        jTF_parcelas_CR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_parcelas_CRFocusGained(evt);
            }
        });
        jTF_parcelas_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_parcelas_CRKeyPressed(evt);
            }
        });

        jLabel12.setText("Entrada");

        jTF_entrada_CR.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_entrada_CR.setText("0,00");
        jTF_entrada_CR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_entrada_CRFocusGained(evt);
            }
        });
        jTF_entrada_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_entrada_CRKeyPressed(evt);
            }
        });

        try {
            jTF_data_emissao_CR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_data_emissao_CR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_data_emissao_CRFocusGained(evt);
            }
        });
        jTF_data_emissao_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_data_emissao_CRKeyPressed(evt);
            }
        });

        jLabel7.setText("Documento");

        jTF_documento_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_documento_CRKeyPressed(evt);
            }
        });

        jB_gerar_parc_CR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jB_gerar_parc_CR.setText("Gerar");
        jB_gerar_parc_CR.setFocusable(false);
        jB_gerar_parc_CR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_gerar_parc_CRActionPerformed(evt);
            }
        });

        try {
            jTF_data_p_venc_CR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_data_p_venc_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_data_p_venc_CRKeyPressed(evt);
            }
        });

        jB_data3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/date.gif"))); // NOI18N
        jB_data3.setFocusable(false);
        jB_data3.setMaximumSize(new java.awt.Dimension(20, 20));
        jB_data3.setMinimumSize(new java.awt.Dimension(20, 20));
        jB_data3.setPreferredSize(new java.awt.Dimension(20, 20));
        jB_data3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_data3ActionPerformed(evt);
            }
        });

        jT_gerar_parcelas_CR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lançamento", "Valor", "Data Venc", "Parcelas", "Valor pago", "Data pgto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_gerar_parcelas_CR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_gerar_parcelas_CRMouseClicked(evt);
            }
        });
        jT_gerar_parcelas_CR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_gerar_parcelas_CRKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jT_gerar_parcelas_CR);

        jB_cancelar_CR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_cancelar_CR.setText("Dispensar");
        jB_cancelar_CR.setFocusable(false);
        jB_cancelar_CR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelar_CRActionPerformed(evt);
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

        jB_salvar_CR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jB_salvar_CR.setText("Salvar");
        jB_salvar_CR.setFocusable(false);
        jB_salvar_CR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvar_CRActionPerformed(evt);
            }
        });

        jB_cancelarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_closed.png"))); // NOI18N
        jB_cancelarConta.setText("Cancelar conta");
        jB_cancelarConta.setToolTipText("Exclui Toda a Conta");
        jB_cancelarConta.setFocusable(false);
        jB_cancelarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_salvar_CR, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jB_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jB_cancelarConta)
                .addGap(0, 0, 0)
                .addComponent(jB_cancelar_CR)
                .addGap(199, 199, 199))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_cancelarConta, jB_cancelar_CR, jB_editar, jB_salvar_CR});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_editar)
                    .addComponent(jB_salvar_CR)
                    .addComponent(jB_cancelar_CR)
                    .addComponent(jB_cancelarConta))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_cancelarConta, jB_cancelar_CR, jB_editar, jB_salvar_CR});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTF_data_p_venc_CR, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jB_data3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jTF_data_emissao_CR, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTF_codClienteNovo)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jTF_razaoCRNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jTF_total_CR)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(24, 24, 24)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jTF_parcelas_CR))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jTF_entrada_CR, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jB_gerar_parc_CR)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTF_referente_CR, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTF_documento_CR, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addComponent(jTF_data_emissao_CR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(jTF_referente_CR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(jTF_documento_CR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_codClienteNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_razaoCRNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTF_total_CR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTF_parcelas_CR)
                                .addComponent(jTF_entrada_CR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jB_gerar_parc_CR, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jB_data3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTF_data_p_venc_CR, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_gerar_parc_CR, jTF_entrada_CR});

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Código:");

        jL_codigo_receber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_codigo_receber.setText("1");

        javax.swing.GroupLayout jP_cadastrarLayout = new javax.swing.GroupLayout(jP_cadastrar);
        jP_cadastrar.setLayout(jP_cadastrarLayout);
        jP_cadastrarLayout.setHorizontalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jP_cadastrarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jL_codigo_receber, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jP_cadastrarLayout.setVerticalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_cadastrarLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_codigo_receber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTP_Contas_Receber.addTab("Cadastrar", jP_cadastrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_Contas_Receber)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_Contas_Receber)
        );

        setSize(new java.awt.Dimension(966, 668));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        dispose();
}//GEN-LAST:event_jB_cancelarActionPerformed

    private void jB_pesquisar2CRDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisar2CRDocActionPerformed
        consultarDocumentoContasReceber();
}//GEN-LAST:event_jB_pesquisar2CRDocActionPerformed

    private void jB_cancelar_CRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelar_CRActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Cancelar operações e voltar para janela de consulta?", "Confirme",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            limpar();
            limparTabelaParcelasReceber();
            jTP_Contas_Receber.setSelectedIndex(0);
        }
}//GEN-LAST:event_jB_cancelar_CRActionPerformed

    private void jB_gerar_parc_CRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_gerar_parc_CRActionPerformed
        limparTabelaParcelasReceber();
        String dia = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        if (Double.parseDouble(jTF_entrada_CR.getText()) > 0) {
            DefaultTableModel dtm = (DefaultTableModel) jT_gerar_parcelas_CR.getModel();
            dtm.addRow(new Object[]{
                jT_gerar_parcelas_CR.getRowCount() + 1,
                ClasseUtilitaria.fmtBig(ClasseUtilitaria.parseToBig(jTF_entrada_CR.getText()), 2),
                dia,
                "ENTRADA",
                ClasseUtilitaria.fmtBig(ClasseUtilitaria.parseToBig(jTF_entrada_CR.getText()), 2),
                dia});
        }
        gerarParcelas();
    }//GEN-LAST:event_jB_gerar_parc_CRActionPerformed

    private void jTF_entrada_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_entrada_CRKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && jB_gerar_parc_CR.isVisible() && jB_gerar_parc_CR.isEnabled()) {
            limparTabelaParcelasReceber();
            String dia = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            if (Double.parseDouble(jTF_entrada_CR.getText()) > 0) {
                DefaultTableModel dtm = (DefaultTableModel) jT_gerar_parcelas_CR.getModel();
                dtm.addRow(new Object[]{
                    jT_gerar_parcelas_CR.getRowCount() + 1,
                    ClasseUtilitaria.fmtBig(ClasseUtilitaria.parseToBig(jTF_entrada_CR.getText()), 2),
                    dia,
                    "ENTRADA",
                    ClasseUtilitaria.fmtBig(ClasseUtilitaria.parseToBig(jTF_entrada_CR.getText()), 2),
                    dia});
            }
            gerarParcelas();
        }
    }//GEN-LAST:event_jTF_entrada_CRKeyPressed

    private void jTF_codClienteBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_codClienteBuscaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jTF_codClienteBusca.getText().isEmpty()) {
            try {
                ArrayList lista = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where id = " + jTF_codClienteBusca.getText());
                try {
                    Cliente c = (Cliente) lista.get(0);
                    jTF_nomeClienteBusca.setText(c.getNome());
                    jTF_nomeClienteBusca.requestFocus();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado!",
                            "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                    jTF_codClienteBusca.requestFocus();
                    jTF_codClienteBusca.selectAll();
                }
            } catch (Exception ex) {
                Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                consultarContasReceber();
            } catch (ParseException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F1 || (evt.getKeyCode() == KeyEvent.VK_ENTER && jTF_codClienteBusca.getText().isEmpty())) {
            ClienteDialogGUI clienteDialogGUI = new ClienteDialogGUI(this, true, true);
            clienteDialogGUI.setLocationRelativeTo(null);
            clienteDialogGUI.setVisible(true);
            Cliente cliente = clienteDialogGUI.getCliente();
            if (cliente != null) {
                jTF_codClienteBusca.setText(cliente.getId().toString());
                jTF_nomeClienteBusca.setText(cliente.getNome());
                jB_pesquisarContasReceber.requestFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN && jT_contasReceber.getRowCount() > 0) {
            jT_contasReceber.addRowSelectionInterval(0, 0);
            jT_contasReceber.requestFocus();
        }
    }//GEN-LAST:event_jTF_codClienteBuscaKeyPressed

        private void jB_novoCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_novoCRActionPerformed
            liberaCamposEditaveis(true);
            jB_cancelarConta.setEnabled(false);
            limparTabelaParcelasReceber();
            limparTabelaContas();
            jTP_Contas_Receber.setSelectedIndex(1);
            limpar();
            botaoSalvar(true);
        }//GEN-LAST:event_jB_novoCRActionPerformed

        private void jB_salvar_CRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvar_CRActionPerformed
            int i = 0;
            BigDecimal decimalTotalGeral = ClasseUtilitaria.parseToBig(0);
            while (jT_gerar_parcelas_CR.getRowCount() > i) {
                BigDecimal decimalTotalParcela = ClasseUtilitaria.parseToBig(String.valueOf(jT_gerar_parcelas_CR.getModel().getValueAt(i, 1)));
                decimalTotalGeral = decimalTotalGeral.add(decimalTotalParcela.setScale(2, RoundingMode.HALF_DOWN));
                i++;
            }
            BigDecimal decimalTotalConta = ClasseUtilitaria.parseToBig(jTF_total_CR.getText());
            if (decimalTotalConta.compareTo(decimalTotalGeral.setScale(2, RoundingMode.HALF_DOWN)) < 0 || decimalTotalConta.compareTo(decimalTotalGeral.setScale(2, RoundingMode.HALF_DOWN)) > 0) {
                JOptionPane.showMessageDialog(null, "Valores da tabela diferem do total da conta!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
            } else {
                salvarContaReceber();
                salvarParcelasReceber();
                limpar();
            }
        }//GEN-LAST:event_jB_salvar_CRActionPerformed

        private void jTF_data_emissao_CRFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_data_emissao_CRFocusGained
            jTF_data_emissao_CR.selectAll();
        }//GEN-LAST:event_jTF_data_emissao_CRFocusGained

        private void jTF_data_emissao_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_data_emissao_CRKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                jTF_codClienteNovo.requestFocus();
            }
        }//GEN-LAST:event_jTF_data_emissao_CRKeyPressed

        private void jTF_codClienteNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_codClienteNovoKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    ArrayList lista = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where id = " + jTF_codClienteNovo.getText());
                    try {
                        if (!lista.isEmpty()) {
                            cliente = (Cliente) lista.get(0);
                            jTF_razaoCRNovo.setText(cliente.getNome());
                            jTF_referente_CR.requestFocus();
                        }
                    } catch (Exception e) {
                        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado! ERRO: " + e.toString(),
                                "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                        jTF_codClienteBusca.requestFocus();
                        jTF_codClienteBusca.selectAll();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (evt.getKeyCode() == KeyEvent.VK_F1) {
                ClienteDialogGUI clienteDialogGUI = new ClienteDialogGUI(this, true, true);
                clienteDialogGUI.setLocationRelativeTo(null);
                clienteDialogGUI.setVisible(true);
                cliente = clienteDialogGUI.getCliente();
                if (cliente != null) {
                    jTF_codClienteNovo.setText(cliente.getId().toString());
                    jTF_razaoCRNovo.setText(cliente.getNome());
                    jTF_referente_CR.requestFocus();
                }
            }
        }//GEN-LAST:event_jTF_codClienteNovoKeyPressed

        private void jTF_referente_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_referente_CRKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                jTF_documento_CR.requestFocus();
            }
        }//GEN-LAST:event_jTF_referente_CRKeyPressed

        private void jTF_total_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_total_CRKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                jTF_parcelas_CR.requestFocus();
            }
        }//GEN-LAST:event_jTF_total_CRKeyPressed

        private void jTF_parcelas_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_parcelas_CRKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                jTF_entrada_CR.requestFocus();
            }
        }//GEN-LAST:event_jTF_parcelas_CRKeyPressed

        private void jTF_codClienteNovoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_codClienteNovoFocusGained
            jTF_codClienteNovo.selectAll();
        }//GEN-LAST:event_jTF_codClienteNovoFocusGained

        private void jTF_parcelas_CRFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_parcelas_CRFocusGained
            jTF_parcelas_CR.selectAll();
        }//GEN-LAST:event_jTF_parcelas_CRFocusGained

        private void jTF_entrada_CRFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_entrada_CRFocusGained
            jTF_entrada_CR.selectAll();
        }//GEN-LAST:event_jTF_entrada_CRFocusGained

        private void jTF_documento_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_documento_CRKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (cr != null) {
                    if (!cr.getDocumento().equalsIgnoreCase(jTF_documento_CR.getText())) {
                        List listContas = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where documento like '" + jTF_documento_CR.getText() + "'");
                        if (listContas.isEmpty()) {
                            jTF_data_p_venc_CR.requestFocus();
                        } else {
                            JOptionPane.showMessageDialog(null, "Número de documento já consta no banco de dados!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                            jTF_documento_CR.requestFocus();
                        }
                    } else {
                        jTF_data_p_venc_CR.requestFocus();
                    }
                } else {
                    List listContas = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where documento like '" + jTF_documento_CR.getText() + "'");
                    if (listContas.isEmpty()) {
                        jTF_data_p_venc_CR.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de documento já consta no banco de dados!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                        jTF_documento_CR.requestFocus();
                    }
                }
            }
        }//GEN-LAST:event_jTF_documento_CRKeyPressed

        private void jTF_documentoCRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_documentoCRKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                consultarDocumentoContasReceber();
            }
        }//GEN-LAST:event_jTF_documentoCRKeyPressed

        private void jT_contasReceberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_contasReceberMouseClicked
            if (evt.getClickCount() >= 2) {
                if (jCB_canceladas.isSelected()) {
                    JOptionPane.showMessageDialog(null, "A conta não pode ser aberta por ter sido excluida/cancelada pelo usuario");
                } else {
                    try {
                        parcelaReceberSelecionada();
                    } catch (Exception ex) {
                        Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, "Falha ao abrir parcela.", ex);
                        JOptionPane.showMessageDialog(rootPane, "Falha ao abrir parcela." + "\n" + ex + "\n" + ex.getMessage());
                    }
                }
            }
        }//GEN-LAST:event_jT_contasReceberMouseClicked

        private void jB_abrirContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_abrirContaActionPerformed
            int linhas_selecionada = jT_contasReceber.getSelectedRowCount();
            if (linhas_selecionada == 1) {
                try {
                    contaReceberSelecionada();
                } catch (Exception ex) {
                    Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }//GEN-LAST:event_jB_abrirContaActionPerformed

        private void jTF_nomeClienteBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_nomeClienteBuscaKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    consultarContasReceber();
                } catch (ParseException | SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
}//GEN-LAST:event_jTF_nomeClienteBuscaKeyPressed

        private void jB_pesquisarContasReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisarContasReceberActionPerformed
            try {
                consultarContasReceber();
            } catch (ParseException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//GEN-LAST:event_jB_pesquisarContasReceberActionPerformed

        private void jTF_data_p_venc_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_data_p_venc_CRKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                jTF_total_CR.requestFocus();
            }
        }//GEN-LAST:event_jTF_data_p_venc_CRKeyPressed

    private void jB_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_editarActionPerformed
        try {
            editarContaReceber();
            //editarParcelas
            JOptionPane.showMessageDialog(null, "CONTA EDITADA COM SUCESSO!",
                    "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
            jTF_documentoCR.setText("");
            limparTabelaContas();
        } catch (HeadlessException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar! Erro: " + erro.toString(),
                    "Alerta do Sistema", JOptionPane.ERROR_MESSAGE, null);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", erro);
        }
    }//GEN-LAST:event_jB_editarActionPerformed

    private void jT_gerar_parcelas_CRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_gerar_parcelas_CRKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            evt.consume();
//            DefaultTableModel dtm = (DefaultTableModel) jT_gerar_parcelas_CR.getModel();
//            int r = jT_gerar_parcelas_CR.getSelectedRow();
//            double valor = Double.parseDouble((String) jT_gerar_parcelas_CR.getModel().getValueAt(r, 1));
//            double restante = Double.parseDouble(jTF_total_CR.getText()) - valor;
//            double valorParcelas = restante / (Double.parseDouble(jTF_parcelas_CR.getText()) - 1);
//            int i = 0;
//            while (i < jT_gerar_parcelas_CR.getRowCount()) {
//                if (i != r) {
//                    dtm.setValueAt(String.valueOf(valorParcelas), i, 1);
//                }
//                i++;
//            }
//        }
    }//GEN-LAST:event_jT_gerar_parcelas_CRKeyPressed

    private void jB_quitarTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_quitarTotalActionPerformed
        if (!jTF_codClienteBusca.getText().isEmpty() && !jTF_nomeClienteBusca.getText().isEmpty()) {
            String[] opcoes = {"Sim", "Não"};
            if (JOptionPane.showOptionDialog(this, "Deseja quitar toda a conta do cliente: " + jTF_nomeClienteBusca.getText().toUpperCase() + ". Agora?", "Pergunta do Sistema",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opcoes, null) == JOptionPane.YES_OPTION) {
                ArrayList arrayListContasReceber = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where id_cliente like '" + jTF_codClienteBusca.getText() + "'");
                int iConta = 0;
                while (arrayListContasReceber.size() > iConta) {
                    Financeiro contas_Receber = (Financeiro) arrayListContasReceber.get(iConta);
                    int iParcelas = 0;
                    while (contas_Receber.getListaParcelasReceber().size() > iParcelas) {
                        FinanceiroParcelas parcelas_receber = (FinanceiroParcelas) contas_Receber.getListaParcelasReceber().get(iParcelas);
                        if (!parcelas_receber.getStatus().equals("PG")) {
                            parcelas_receber.setData_pagamento(new Date());
                            parcelas_receber.setStatus("PG");
                            parcelas_receber.setValor_pago(parcelas_receber.getValor());
                            try {
                                Fachada.getInstancia().editarParcelas_receberJDBC(parcelas_receber);
                                FinanceiroRecPag parcelas_receber_historico_recebimento = new FinanceiroRecPag();
                                parcelas_receber_historico_recebimento.setData_recebimento(new Date());
                                parcelas_receber_historico_recebimento.setId_parcelas_receber(parcelas_receber.getId());
                                parcelas_receber_historico_recebimento.setValor_recebido(parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()));
                                parcelas_receber_historico_recebimento.setHora_recebimento(fmtHora.format(new Date()));
                                Fachada.getInstancia().incluirHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
                            } catch (Exception e) {
                                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
                                JOptionPane.showMessageDialog(rootPane, "Não foi possível quitar as contas!", "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        iParcelas++;
                    }
                    iConta++;
                }
                limparTabelaContas();
                JOptionPane.showMessageDialog(rootPane, "Contas quitadas com sucessso!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhum cliente selecionado! (SELECIONE UM CLIENTE)", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jB_quitarTotalActionPerformed

    private void jB_pesquisarContasReceberMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_pesquisarContasReceberMouseEntered
        jB_pesquisarContasReceber.setContentAreaFilled(true);
    }//GEN-LAST:event_jB_pesquisarContasReceberMouseEntered

    private void jB_pesquisarContasReceberMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_pesquisarContasReceberMouseExited
        jB_pesquisarContasReceber.setContentAreaFilled(false);
    }//GEN-LAST:event_jB_pesquisarContasReceberMouseExited

    private void jB_pesquisar2CRDocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_pesquisar2CRDocMouseEntered
        jB_pesquisar2CRDoc.setContentAreaFilled(true);
    }//GEN-LAST:event_jB_pesquisar2CRDocMouseEntered

    private void jB_pesquisar2CRDocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_pesquisar2CRDocMouseExited
        jB_pesquisar2CRDoc.setContentAreaFilled(false);
    }//GEN-LAST:event_jB_pesquisar2CRDocMouseExited

    private void jT_gerar_parcelas_CRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_gerar_parcelas_CRMouseClicked
        if (evt.getClickCount() > 1) {// && jB_gerar_parc_CR.isEnabled() && jB_gerar_parc_CR.isVisible()
            Object[] opcao = {"SIM", "NÃO"};
            int op = JOptionPane.showOptionDialog(
                    this, "Deseja editar as parcelas?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, opcao, opcao[1]);
            if (op == 0) {
                entraModoEdicao();
            }
        }
    }//GEN-LAST:event_jT_gerar_parcelas_CRMouseClicked

    private void jB_abrirParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_abrirParcelaActionPerformed
        int linhas_selecionada = jT_contasReceber.getSelectedRowCount();
        if (linhas_selecionada == 1) {
            try {
                parcelaReceberSelecionada();
            } catch (Exception ex) {
                Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, "Falha ao abrir parcela.", ex);
                JOptionPane.showMessageDialog(rootPane, "Falha ao abrir parcela." + "\n" + ex + "\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jB_abrirParcelaActionPerformed

    private void jB_quitarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_quitarValorActionPerformed
        if (!jTF_valorPagarConta.getText().isEmpty()) {
            quitarValor();
        }
    }//GEN-LAST:event_jB_quitarValorActionPerformed

    private void jTF_valorPagarContaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_valorPagarContaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_valorPagarContaKeyPressed

    private void jTF_valorPagarContaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_valorPagarContaKeyTyped
        if (evt.getKeyChar() == ',') {
            evt.setKeyChar('.');
        }
    }//GEN-LAST:event_jTF_valorPagarContaKeyTyped

    private void jTF_nomeClienteBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTF_nomeClienteBuscaMouseClicked
        ClienteDialogGUI clienteDialogGUI = new ClienteDialogGUI(this, true, true);
        clienteDialogGUI.setLocationRelativeTo(null);
        clienteDialogGUI.setVisible(true);
        Cliente c = clienteDialogGUI.getCliente();
        if (c != null) {
            jTF_codClienteBusca.setText(c.getId().toString());
            jTF_nomeClienteBusca.setText(c.getNome());
            jB_pesquisarContasReceber.requestFocus();
        }
    }//GEN-LAST:event_jTF_nomeClienteBuscaMouseClicked

    private void jB_pesquisarIdParcelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_pesquisarIdParcelaMouseEntered
        jB_pesquisarIdParcela.setContentAreaFilled(true);
    }//GEN-LAST:event_jB_pesquisarIdParcelaMouseEntered

    private void jB_pesquisarIdParcelaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_pesquisarIdParcelaMouseExited
        jB_pesquisarIdParcela.setContentAreaFilled(false);
    }//GEN-LAST:event_jB_pesquisarIdParcelaMouseExited

    private void jB_pesquisarIdParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisarIdParcelaActionPerformed

        limparTabelaContas();
        consultarParcelaPeloId();
    }//GEN-LAST:event_jB_pesquisarIdParcelaActionPerformed

    private void jTF_id_parcelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_id_parcelaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ArrayList<FinanceiroParcelas> arrayList = Fachada.getInstancia().consultarParcelasReceberQuery("select * from parcelas_receber where id_parcelas_receber = " + jTF_id_parcela.getText());
            if (!arrayList.isEmpty()) {
                FinanceiroParcelas parcelas_receber = arrayList.get(0);
                ArrayList<Financeiro> lista = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where id_contas_receber = " + parcelas_receber.getFinanceiro().getId() + " and NOT excluido");
                if (parcelas_receber.getStatus().equals("PG")) {
                    JOptionPane.showMessageDialog(null, "A PARCELA SELECIONADA JA ESTÁ PAGA!(A TELA ABRIRÁ EM MODO CONSULTA)",
                            "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                    ConsultaContasReceberGUI dialog = new ConsultaContasReceberGUI(this, true, lista.get(0), parcelas_receber, false);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                } else {
                    ConsultaContasReceberGUI dialog = new ConsultaContasReceberGUI(this, true, lista.get(0), parcelas_receber, true);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                    if (!jTF_codClienteBusca.getText().isEmpty()) {
                        try {
                            consultarContasReceber();
                        } catch (ParseException | SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (!jTF_documentoCR.getText().isEmpty()) {
                        consultarDocumentoContasReceber();
                    } else if (!jTF_id_parcela.getText().isEmpty()) {
                        limparTabelaContas();
                        consultarParcelaPeloId();
                    }
                }
            }
        }
    }//GEN-LAST:event_jTF_id_parcelaKeyPressed

    private void jT_contasReceberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_contasReceberKeyPressed
        if (jCB_canceladas.isSelected()) {
            JOptionPane.showMessageDialog(null, "A conta não pode ser aberta por ter sido excluida/cancelada pelo usuario");
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                int linhas_selecionada = jT_contasReceber.getSelectedRowCount();
                if (linhas_selecionada == 1) {
                    try {
                        parcelaReceberSelecionada();
                    } catch (Exception ex) {
                        Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, "Falha ao abrir parcela.", ex);
                        JOptionPane.showMessageDialog(rootPane, "Falha ao abrir parcela." + "\n" + ex + "\n" + ex.getMessage());
                    }
                }
                evt.consume();
            } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
                int linhas_selecionada = jT_contasReceber.getSelectedRowCount();
                if (linhas_selecionada == 1) {
                    try {
                        contaReceberSelecionada();
                    } catch (Exception ex) {
                        Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_jT_contasReceberKeyPressed

    private void jB_data3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_data3ActionPerformed

    }//GEN-LAST:event_jB_data3ActionPerformed

    private void jT_contasReceberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_contasReceberFocusLost
        if (jT_contasReceber.getSelectedRowCount() > 0) {
            int row = jT_contasReceber.getSelectedRow();
            jT_contasReceber.removeRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_jT_contasReceberFocusLost

    private void jCB_geralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_geralActionPerformed
        liberaDatasDePesquisas(true, true, true, false, jCB_data_emissao);
    }//GEN-LAST:event_jCB_geralActionPerformed

    private void jB_cancelarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarContaActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja cancelar a conta?", "CONFIRMAÇÃO", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                cr.setData_exclusao(new Date());
                cr.setId_usuario_exclusao(_FuncionarioLogado.getId());
                cr.setExcluido(true);
                Fachada.getInstancia().exclusaoLogicaContasReceberJDBC(cr);
                JOptionPane.showMessageDialog(null, "CONTA CANCELADA COM SUCESSO!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                limpar();
                jTP_Contas_Receber.setSelectedIndex(0);
                limparTabelaContas();
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar cancelar! Erro: " + e.toString(), "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
            }
        } else {
            //TODO: NÃO FAZ NADA!
        }
    }//GEN-LAST:event_jB_cancelarContaActionPerformed

    private void jCB_aReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_aReceberActionPerformed
        liberaDatasDePesquisas(false, true, true, false, jCB_data_vencimento);
    }//GEN-LAST:event_jCB_aReceberActionPerformed

    private void jCB_recebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_recebidasActionPerformed
        liberaDatasDePesquisas(true, false, true, false, jCB_data_pagamento);
    }//GEN-LAST:event_jCB_recebidasActionPerformed

    private void jCB_quitadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_quitadasActionPerformed
        liberaDatasDePesquisas(true, true, true, false, jCB_data_emissao);
    }//GEN-LAST:event_jCB_quitadasActionPerformed

    private void jCB_abertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_abertasActionPerformed
        liberaDatasDePesquisas(false, true, true, false, jCB_data_emissao);
    }//GEN-LAST:event_jCB_abertasActionPerformed

    private void jCB_pg_parcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_pg_parcialActionPerformed
        liberaDatasDePesquisas(true, true, true, false, jCB_data_emissao);
    }//GEN-LAST:event_jCB_pg_parcialActionPerformed

    private void jCB_canceladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_canceladasActionPerformed
        liberaDatasDePesquisas(true, true, true, true, jCB_data_exclusao);
    }//GEN-LAST:event_jCB_canceladasActionPerformed

    private void jTF_id_parcelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTF_id_parcelaMouseClicked
        jCB_geral.setSelected(true);
        jCB_data_emissao.setSelected(true);
        jXDP_dataInicialCR.setDate(null);
        jXDP_dataFinalCR.setDate(null);
    }//GEN-LAST:event_jTF_id_parcelaMouseClicked

    private void jTF_documentoCRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTF_documentoCRMouseClicked
        jCB_geral.setSelected(true);
        jCB_data_emissao.setSelected(true);
        jXDP_dataInicialCR.setDate(null);
        jXDP_dataFinalCR.setDate(null);
    }//GEN-LAST:event_jTF_documentoCRMouseClicked

    private void jTF_codClienteBuscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_codClienteBuscaFocusLost
        if (jTF_codClienteBusca.getText().isEmpty()) {
            jTF_nomeClienteBusca.setText("");
        }
    }//GEN-LAST:event_jTF_codClienteBuscaFocusLost

    private void jB_dataNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_dataNowActionPerformed
        jXDP_dataInicialCR.setDate(new Date());
        jXDP_dataFinalCR.setDate(new Date());
    }//GEN-LAST:event_jB_dataNowActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContasAReceberGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_data;
    private javax.swing.ButtonGroup buttonGroup_mostrar;
    private javax.swing.JButton jB_abrirConta;
    private javax.swing.JButton jB_abrirParcela;
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_cancelarConta;
    private javax.swing.JButton jB_cancelar_CR;
    private javax.swing.JButton jB_data3;
    private javax.swing.JButton jB_dataNow;
    private javax.swing.JButton jB_editar;
    private javax.swing.JButton jB_gerar_parc_CR;
    private javax.swing.JButton jB_novoCR;
    private javax.swing.JButton jB_pesquisar2CRDoc;
    private javax.swing.JButton jB_pesquisarContasReceber;
    private javax.swing.JButton jB_pesquisarIdParcela;
    private javax.swing.JButton jB_quitarTotal;
    private javax.swing.JButton jB_quitarValor;
    private javax.swing.JButton jB_salvar_CR;
    private javax.swing.JCheckBox jCB_aReceber;
    private javax.swing.JCheckBox jCB_abertas;
    private javax.swing.JCheckBox jCB_canceladas;
    private javax.swing.JCheckBox jCB_data_emissao;
    private javax.swing.JCheckBox jCB_data_exclusao;
    private javax.swing.JCheckBox jCB_data_pagamento;
    private javax.swing.JCheckBox jCB_data_vencimento;
    private javax.swing.JCheckBox jCB_geral;
    private javax.swing.JCheckBox jCB_pg_parcial;
    private javax.swing.JCheckBox jCB_quitadas;
    private javax.swing.JCheckBox jCB_recebidas;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jL_codigo_receber;
    private javax.swing.JTextField jL_somaCR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_cadastrar;
    private javax.swing.JPanel jP_consultar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTF_codClienteBusca;
    private javax.swing.JTextField jTF_codClienteNovo;
    private javax.swing.JFormattedTextField jTF_data_emissao_CR;
    private javax.swing.JFormattedTextField jTF_data_p_venc_CR;
    private javax.swing.JTextField jTF_documentoCR;
    private javax.swing.JTextField jTF_documento_CR;
    private javax.swing.JTextField jTF_entrada_CR;
    private javax.swing.JTextField jTF_id_parcela;
    private javax.swing.JTextField jTF_nomeClienteBusca;
    private javax.swing.JTextField jTF_pago;
    private javax.swing.JTextField jTF_parcelas_CR;
    private javax.swing.JTextField jTF_razaoCRNovo;
    private javax.swing.JTextField jTF_referente_CR;
    private javax.swing.JTextField jTF_total_CR;
    private javax.swing.JTextField jTF_valorPagarConta;
    private javax.swing.JTabbedPane jTP_Contas_Receber;
    private javax.swing.JTable jT_contasReceber;
    private javax.swing.JTable jT_gerar_parcelas_CR;
    private org.jdesktop.swingx.JXDatePicker jXDP_dataFinalCR;
    private org.jdesktop.swingx.JXDatePicker jXDP_dataInicialCR;
    // End of variables declaration//GEN-END:variables

    public void gerarParcelas() {
        BigDecimal valor_Parcela;
        BigDecimal valorPago = BigDecimal.ZERO;
        DefaultTableModel dtm = (DefaultTableModel) jT_gerar_parcelas_CR.getModel();
        boolean temEntrada = false;
        if (Double.parseDouble(jTF_entrada_CR.getText()) > 0) {
            temEntrada = true;
            valor_Parcela = ClasseUtilitaria.parseToBig(jTF_total_CR.getText()).subtract(ClasseUtilitaria.parseToBig(jTF_entrada_CR.getText())).divide(ClasseUtilitaria.parseToBig(jTF_parcelas_CR.getText()));
        } else {
            valor_Parcela = ClasseUtilitaria.parseToBig(jTF_total_CR.getText()).divide(ClasseUtilitaria.parseToBig(jTF_parcelas_CR.getText())).setScale(2);
        }
        boolean primeiraData = true;
        Date data_cadastro = null;
        try {
            data_cadastro = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(jTF_data_p_venc_CR.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = 0;
        int parcelas = Integer.parseInt(jTF_parcelas_CR.getText());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data_cadastro);
        while (parcelas > i) {
            if (primeiraData) {
                dtm.addRow(new Object[]{jT_gerar_parcelas_CR.getRowCount() + 1, valor_Parcela.setScale(2, RoundingMode.HALF_UP), jTF_data_p_venc_CR.getText(), "1/" + jTF_parcelas_CR.getText(), valorPago.setScale(2, RoundingMode.HALF_UP), ""});
                i++;
                primeiraData = false;
            } else {
                SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
                calendar.add(Calendar.MONTH, 1);
                data_cadastro = calendar.getTime();
                String data_formatada = in.format(data_cadastro);
                int linha = jT_gerar_parcelas_CR.getRowCount();
                if (temEntrada) {
                    linha--;
                }
                dtm.addRow(new Object[]{jT_gerar_parcelas_CR.getRowCount() + 1, valor_Parcela.setScale(2, RoundingMode.HALF_UP), data_formatada, linha + 1 + "/" + jTF_parcelas_CR.getText(), valorPago.setScale(2, RoundingMode.HALF_UP), ""});
                i++;
            }
        }
    }

    public void limparTabelaParcelasReceber() {
        DefaultTableModel tableData = (DefaultTableModel) jT_gerar_parcelas_CR.getModel();
        tableData.setRowCount(0);
        jT_gerar_parcelas_CR.setModel(tableData);
    }

    public void limparTabelaContas() {

        DefaultTableModel tableData = (DefaultTableModel) jT_contasReceber.getModel();
        tableData.setRowCount(0);
        jT_contasReceber.setModel(tableData);

    }

    public void limpar() {
        jTF_codClienteNovo.setText("");
        jTF_razaoCRNovo.setText("");
        jTF_referente_CR.setText("");
        jTF_data_p_venc_CR.setText("");
        jTF_total_CR.setText("");
        jTF_parcelas_CR.setText("1");
        jTF_entrada_CR.setText("0.00");
        jTF_documento_CR.setText("");
        jL_somaCR.setText("0.00");
        jTF_valorPagarConta.setText("0.00");
    }

    public final void botaoSalvar(boolean b) {
        jB_salvar_CR.setEnabled(b);
    }

    public void consultarDocumentoContasReceber() {
        limparTabelaContas();
        ArrayList lista;
        if (jCB_canceladas.isSelected()) {
            lista = Fachada.getInstancia().consultarContaReceberQuery("SELECT * FROM CONTAS_RECEBER WHERE DOCUMENTO LIKE '" + jTF_documentoCR.getText() + "' and excluido = 1");
        } else {
            lista = Fachada.getInstancia().consultarContaReceberQuery("SELECT * FROM CONTAS_RECEBER WHERE DOCUMENTO LIKE '" + jTF_documentoCR.getText() + "' and excluido = 0");
        }
        int i = 0;
        Financeiro contas_Receber;
        FinanceiroParcelas parcelas_receber;
        DefaultTableModel dtm = (DefaultTableModel) jT_contasReceber.getModel();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NENHUMA CONTA ENCONTRADA!",
                    "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
            jTF_documentoCR.requestFocus();
            jTF_documentoCR.selectAll();
            jL_somaCR.setText("0.00");
            jTF_valorPagarConta.setText("0.00");
        } else {
            while (lista.size() > i) {
                jCB_abertas.setActionCommand("NAO");
                jCB_pg_parcial.setActionCommand("PG PARCIAL");
                jCB_quitadas.setActionCommand("PG");
                jCB_canceladas.setActionCommand("%");
                jCB_aReceber.setActionCommand("%");
                jCB_geral.setActionCommand("%");
                contas_Receber = (Financeiro) lista.get(i);
                int iParcelasReceber = 0;
                BigDecimal valor_total = BigDecimal.ZERO;
                while (contas_Receber.getListaParcelasReceber().size() > iParcelasReceber) {
                    parcelas_receber = (FinanceiroParcelas) contas_Receber.getListaParcelasReceber().get(iParcelasReceber);
                    SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
                    String data_venc = in.format(parcelas_receber.getData_vencimento());
                    String data_emissao = in.format(contas_Receber.getData_emissao());
                    String data_pagamento = "";
                    if (parcelas_receber.getData_pagamento() != null) {
                        String dateofmoney = in.format(parcelas_receber.getData_pagamento());
                        data_pagamento = dateofmoney;
                    }
                    if (parcelas_receber.getStatus().equals("NAO") && !parcelas_receber.getParcela().equalsIgnoreCase("ENTRADA") && !parcelas_receber.getStatus().equals("PG PARCIAL")) {
                        valor_total = valor_total.add(parcelas_receber.getValor());
                    } else if (parcelas_receber.getStatus().equals("PG PARCIAL")) {
                        valor_total = valor_total.add(parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()));
                    }
                    dtm.addRow(new Object[]{contas_Receber.getId(), parcelas_receber.getId(),
                        parcelas_receber.getLancamento(), parcelas_receber.getStatus(), parcelas_receber.getParcela(),
                        data_venc, parcelas_receber.getValor().setScale(2, RoundingMode.HALF_UP), parcelas_receber.getValor_pago().setScale(2, RoundingMode.HALF_UP),
                        parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()).setScale(2, RoundingMode.HALF_UP),
                        data_pagamento, data_emissao, contas_Receber.getReferente()});
                    iParcelasReceber++;
                }
                jL_somaCR.setText(valor_total.setScale(2, RoundingMode.HALF_UP).toString());
                jTF_valorPagarConta.setText(valor_total.setScale(2, RoundingMode.HALF_UP).toString());
                i++;
            }
        }

    }

    public void parcelaReceberSelecionada() throws Exception {

        jL_somaCR.setText("0.00");
        int i = jT_contasReceber.getSelectedRow();
        String status = (String) jT_contasReceber.getModel().getValueAt(i, 3);
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "NENHUMA CONTA SELECIONADA!",
                    "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            if (status.equals("PG")) {
                JOptionPane.showMessageDialog(null, "A PARCELA SELECIONADA JA ESTÁ PAGA!(A TELA ABRIRÁ EM MODO CONSULTA)",
                        "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                int la = (Integer) jT_contasReceber.getModel().getValueAt(i, 0);
                int id_parcelas_receber = (Integer) jT_contasReceber.getModel().getValueAt(i, 1);
                ArrayList lista = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where id = " + la);
                Financeiro contas_Receber = (Financeiro) lista.get(0);
                ArrayList listaParcela = Fachada.getInstancia().consultarParcelasReceberQuery("select * from parcelas_receber where id = " + id_parcelas_receber);
                FinanceiroParcelas par = (FinanceiroParcelas) listaParcela.get(0);
                ConsultaContasReceberGUI dialog = new ConsultaContasReceberGUI(this, false, contas_Receber, par, false);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            } else {
                int id_contas_R = (Integer) jT_contasReceber.getModel().getValueAt(i, 0);
                int id_parcelas_receber = (Integer) jT_contasReceber.getModel().getValueAt(i, 1);
                ArrayList lista = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where id = " + id_contas_R);
                Financeiro contas_Receber = (Financeiro) lista.get(0);
                ArrayList listaParcela = Fachada.getInstancia().consultarParcelasReceberQuery("select * from parcelas_receber where id = " + id_parcelas_receber);
                FinanceiroParcelas par = (FinanceiroParcelas) listaParcela.get(0);
                ConsultaContasReceberGUI dialog = new ConsultaContasReceberGUI(this, true, contas_Receber, par, true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
            consultar();
        }
    }

    private void consultar() {
        if (!jTF_codClienteBusca.getText().isEmpty()) {
            try {
                consultarContasReceber();
            } catch (ParseException | SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!jTF_documentoCR.getText().isEmpty()) {
            consultarDocumentoContasReceber();
        } else if (!jTF_id_parcela.getText().isEmpty()) {
            limparTabelaContas();
            consultarParcelaPeloId();
        }
    }

    public void consultarContasReceber() throws ParseException, SQLException, ClassNotFoundException {
        limparTabelaContas();
        DefaultTableModel dtm = (DefaultTableModel) jT_contasReceber.getModel();
        dtm.setRowCount(0);
        SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal somatorioParcelas = BigDecimal.ZERO, pagas = BigDecimal.ZERO;

        String data_inicial;
        String data_final;
        String status = buttonGroup_mostrar.getSelection().getActionCommand();
        String operador = "LIKE";
        String complemento;
        String idCliente = jTF_codClienteBusca.getText().isEmpty() ? "%" : jTF_codClienteBusca.getText();
        String clausulaComDatas;
        try {
            data_inicial = out.format(jXDP_dataInicialCR.getDate());
        } catch (Exception e) {
            data_inicial = "2000-01-01";
        }
        try {
            data_final = out.format(jXDP_dataFinalCR.getDate());
        } catch (Exception e) {
            data_final = "3000-01-01";
        }
        if (out.parse(data_inicial).after(out.parse(data_final))) {
            JOptionPane.showMessageDialog(null, "Período inválido.");
            jXDP_dataInicialCR.requestFocus();
        }
        clausulaComDatas = buttonGroup_data.getSelection().getActionCommand() + " BETWEEN '" + data_inicial + "' AND '" + data_final + "' AND";
        if (status.equalsIgnoreCase("NAOANDPGPARCIAL")) {
            status = "PG";
            operador = "<>";
            complemento = " and c.excluido = 0";
        } else if (status.equalsIgnoreCase("PGANDPGPARCIAL")) {
            status = "NAO";
            operador = "<>";
            complemento = " and c.excluido = 0";
        } else if (status.equalsIgnoreCase("canceladas")) {
            status = "%";
            complemento = "and c.excluido = 1";
        } else {
            complemento = "and c.excluido = 0";
        }

        ArrayList<FinanceiroParcelas> listaParcelasReceber;
        listaParcelasReceber = Fachada.getInstancia().consultarParcelasReceberQuery(""
                + "SELECT * FROM parcelas_receber p, contas_receber c, cliente cli "
                + "WHERE " + clausulaComDatas + " p.status " + operador + " '" + status + "' "
                + "and c.id = p.id_contas_receber and "
                + "c.id_cliente = cli.id and cli.id like '" + idCliente + "' " + complemento);
        for (FinanceiroParcelas parcelas_receber : listaParcelasReceber) {
            String data_ven_par = parcelas_receber.getData_vencimento() == null ? "" : in.format(parcelas_receber.getData_vencimento());
            String data_emissao = "";
            String dataPG = "";
            if (parcelas_receber.getData_pagamento() != null) {
                dataPG = in.format(parcelas_receber.getData_pagamento());
            }
            if (parcelas_receber.getStatus().equals("NAO") && !parcelas_receber.getParcela().equalsIgnoreCase("ENTRADA") && !parcelas_receber.getStatus().equals("PG PARCIAL")) {
                somatorioParcelas = somatorioParcelas.add(parcelas_receber.getValor());
            } else if (parcelas_receber.getStatus().equals("PG PARCIAL")) {
                somatorioParcelas = somatorioParcelas.add(parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()));
                pagas = pagas.add(parcelas_receber.getValor_pago());
            } else {
                pagas = pagas.add(parcelas_receber.getValor());
            }
            dtm.addRow(new Object[]{parcelas_receber.getFinanceiro().getId(), parcelas_receber.getId(),
                parcelas_receber.getLancamento(), parcelas_receber.getStatus(), parcelas_receber.getParcela(),
                data_ven_par, parcelas_receber.getValor().setScale(2, RoundingMode.HALF_UP), parcelas_receber.getValor_pago().setScale(2, RoundingMode.HALF_UP),
                parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()).setScale(2, RoundingMode.HALF_UP),
                dataPG, data_emissao, ""});
        }
        String valor = somatorioParcelas.setScale(2, RoundingMode.HALF_UP).toString();
        String valorPagas = pagas.setScale(2, RoundingMode.HALF_UP).toString();
        jL_somaCR.setText(valor);
        jTF_pago.setText(valorPagas);
        jTF_valorPagarConta.setText(valor);
    }

    public void salvarContaReceber() {
        Financeiro contas_Receber = new Financeiro();
        contas_Receber.setCliente(cliente);
        Date Emissao = null;
        Date venc = null;
        try {
            Emissao = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(jTF_data_emissao_CR.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            venc = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(jTF_data_p_venc_CR.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        contas_Receber.setData_emissao(Emissao);
        contas_Receber.setNumero_parcelas(Integer.parseInt(jTF_parcelas_CR.getText()));
        contas_Receber.setValor_total(ClasseUtilitaria.parseToBig(jTF_total_CR.getText()));
        contas_Receber.setEntrada(ClasseUtilitaria.parseToBig(jTF_entrada_CR.getText()));
        contas_Receber.setDocumento(jTF_documento_CR.getText());
        contas_Receber.setReferente(jTF_referente_CR.getText());
        contas_Receber.setId_usuario_insercao(_FuncionarioLogado.getId());
        try {
            Fachada.getInstancia().incluirContas_ReceberJDBC(contas_Receber);
            this.cr = contas_Receber;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void salvarParcelasReceber() {
        FinanceiroParcelas parcelas_receber = new FinanceiroParcelas();
        int i = 0;
        Date date = null;
        Date date1 = null;
        while (i < jT_gerar_parcelas_CR.getRowCount()) {
            int lanc = Integer.valueOf(String.valueOf(jT_gerar_parcelas_CR.getModel().getValueAt(i, 0)));
            BigDecimal valor = (BigDecimal) jT_gerar_parcelas_CR.getModel().getValueAt(i, 1);
            String data_venc = String.valueOf(jT_gerar_parcelas_CR.getModel().getValueAt(i, 2));
            String formato = "dd/MM/yyyy";
            try {
                date = new SimpleDateFormat(formato).parse(data_venc);
            } catch (ParseException ex) {
                Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            }
            String parc = String.valueOf(jT_gerar_parcelas_CR.getModel().getValueAt(i, 3));
            BigDecimal valor_pg = (BigDecimal) jT_gerar_parcelas_CR.getModel().getValueAt(i, 4);
            parcelas_receber.setLancamento(lanc);
            parcelas_receber.setValor(valor);
            parcelas_receber.setData_vencimento(date);
            parcelas_receber.setData_pagamento(date1);
            parcelas_receber.setParcela(parc);
            parcelas_receber.setValor_pago(valor_pg);
            parcelas_receber.setFinanceiro(cr);
            FinanceiroRecPag parcelas_receber_historico_recebimento = null;
            if (parc.equals("ENTRADA")) {
                parcelas_receber.setStatus("PG");
                parcelas_receber.setData_pagamento(new Date());
                parcelas_receber_historico_recebimento = new FinanceiroRecPag();
                parcelas_receber_historico_recebimento.setData_recebimento(new Date());
                parcelas_receber_historico_recebimento.setValor_recebido(valor);
                parcelas_receber_historico_recebimento.setHora_recebimento(fmtHora.format(new Date()));
            } else {
                parcelas_receber.setStatus("NAO");
            }
            Fachada.getInstancia().incluirParcelas_receberJDBC(parcelas_receber);
            if (parcelas_receber_historico_recebimento != null) {
                parcelas_receber_historico_recebimento.setId_parcelas_receber(parcelas_receber.getId());
                Fachada.getInstancia().incluirHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
            }
            i++;
        }
        jTP_Contas_Receber.setSelectedIndex(0);
        JOptionPane.showMessageDialog(null, "CONTA SALVA COM SUCESSO!",
                "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
        if (JOptionPane.showConfirmDialog(null, "Deseja gerar um recibo vinculado a esta conta?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            ArrayList listaCLiente;
            try {
                listaCLiente = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where id = " + jTF_codClienteNovo.getText());
                Cliente cliente = (Cliente) listaCLiente.get(0);
                //relatorio
            } catch (Exception ex) {
                Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void editarContaReceber() {
        cr.setCliente(cliente);
        Date Emissao = null;
        Date venc = null;
        try {
            Emissao = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(jTF_data_emissao_CR.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            venc = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(jTF_data_p_venc_CR.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        cr.setData_emissao(Emissao);
        cr.setNumero_parcelas(Integer.parseInt(jTF_parcelas_CR.getText()));
        cr.setValor_total(ClasseUtilitaria.parseToBig(jTF_total_CR.getText()));
        cr.setEntrada(ClasseUtilitaria.parseToBig(jTF_entrada_CR.getText()));
        cr.setDocumento(jTF_documento_CR.getText());
        cr.setReferente(jTF_referente_CR.getText());
        cr.setData_edicao(new Date());
        cr.setId_usuario_edicao(_FuncionarioLogado.getId());
        try {
            Fachada.getInstancia().editarContas_ReceberJDBC(cr);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
        }
    }

    public void editarParcelasReceber() {
        int i = 0;
        Date date = null;
        Date date1 = null;
        while (i < jT_gerar_parcelas_CR.getRowCount()) {
            int lanc = (Integer) jT_gerar_parcelas_CR.getModel().getValueAt(i, 0);
            BigDecimal valor = ClasseUtilitaria.parseToBig((Double) jT_gerar_parcelas_CR.getModel().getValueAt(i, 1));
            String data_venc = (String) (jT_gerar_parcelas_CR.getModel().getValueAt(i, 2));
            String formato = "dd/MM/yyyy";
            try {
                date = new SimpleDateFormat(formato).parse(data_venc);
            } catch (ParseException ex) {
                Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            String parc = (String) jT_gerar_parcelas_CR.getModel().getValueAt(i, 3);
            BigDecimal valor_pg = ClasseUtilitaria.parseToBig((String) jT_gerar_parcelas_CR.getModel().getValueAt(i, 4));
            FinanceiroParcelas parcelas_receber = new FinanceiroParcelas();
            parcelas_receber.setLancamento(lanc);
            parcelas_receber.setValor(valor);
            parcelas_receber.setData_vencimento(date);
            parcelas_receber.setParcela(parc);
            parcelas_receber.setValor_pago(valor_pg);
            parcelas_receber.setFinanceiro(cr);
            if (parc.equals("ENTRADA")) {
                parcelas_receber.setStatus("PG");
                parcelas_receber.setData_pagamento(date1);
            } else {
                parcelas_receber.setStatus("NAO");
            }
            Fachada.getInstancia().incluirParcelas_receberJDBC(parcelas_receber);
            i++;
        }
        if (JOptionPane.showConfirmDialog(null, "Deseja gerar um recibo vinculado a esta conta?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            ArrayList listaCLiente;
            try {
                listaCLiente = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where id = " + jTF_codClienteNovo.getText());
                Cliente c = (Cliente) listaCLiente.get(0);
                //relatorio
            } catch (Exception ex) {
                Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        limpar();
        jTP_Contas_Receber.setSelectedIndex(0);
    }

    private void excluirParcelas() {
        List list = Fachada.getInstancia().consultarParcelasReceberQuery("select * from parcelas_receber where id_contas_receber = " + cr.getId());
        int i = 0;
        while (list.size() > i) {
            FinanceiroParcelas parcelas_receber = (FinanceiroParcelas) list.get(i);
            Fachada.getInstancia().deletarParcelasReceberJDBC(parcelas_receber);
            i++;
        }
    }

    private DefaultFormatterFactory formato(String mask) {
        MaskFormatter comFoco = null;
        try {
            comFoco = new MaskFormatter(mask);
        } catch (ParseException pe) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", pe);
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);
        return factory;

    }

    private void quitarValor() {
        BigDecimal dinheiro = ClasseUtilitaria.parseToBig(jTF_valorPagarConta.getText());
        if (dinheiro.doubleValue() > 0.00 && !jTF_codClienteBusca.getText().isEmpty() && !jTF_nomeClienteBusca.getText().isEmpty()) {
            try {
                quitarValor2(dinheiro);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " VALOR INVÁLIDO ", "", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, " Selecione uma conta para efetuar o pagamento", "", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void quitarValor2(BigDecimal dinheiroPago) {
        try {
            BigDecimal valorPagoStatic = dinheiroPago;
            String[] opcoes = {"Sim", "Não"};
            if (JOptionPane.showOptionDialog(this, "Deseja quitar R$" + dinheiroPago.setScale(2, RoundingMode.DOWN) + " na conta do cliente: " + jTF_nomeClienteBusca.getText() + ". Agora?", "Pergunta do Sistema",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]) == JOptionPane.YES_OPTION) {
                try {
                    ArrayList<Financeiro> arrayListContasReceber = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where id_cliente = '" + jTF_codClienteBusca.getText() + "' and excluido = 0");
                    String relacaoDePagos = "";
                    for (Financeiro contas_Receber : arrayListContasReceber) {
                        ArrayList<FinanceiroParcelas> arrayListParcelasReceber = Fachada.getInstancia().consultarParcelasReceberQuery("select * from parcelas_receber where (pago like 'NAO' or pago like 'PG PARCIAL') and id_contas_receber = " + contas_Receber.getId());
                        for (FinanceiroParcelas parcelas_receber : arrayListParcelasReceber) {
                            if (!parcelas_receber.getStatus().equals("PG") && (dinheiroPago.compareTo(BigDecimal.ZERO)) > 0) {
                                parcelas_receber.setData_pagamento(new Date());
                                try {
                                    FinanceiroRecPag parcelas_receber_historico_recebimento = new FinanceiroRecPag();
                                    parcelas_receber_historico_recebimento.setData_recebimento(new Date());
                                    parcelas_receber_historico_recebimento.setId_parcelas_receber(parcelas_receber.getId());

                                    if ((dinheiroPago.subtract(parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()))).compareTo(BigDecimal.ZERO) >= 0) {
                                        parcelas_receber_historico_recebimento.setValor_recebido(parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()));
                                        parcelas_receber.setStatus("PG");
                                        parcelas_receber.setValor_pago(parcelas_receber.getValor());
                                        dinheiroPago = dinheiroPago.subtract(parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()));
                                    } else {
                                        parcelas_receber_historico_recebimento.setValor_recebido(dinheiroPago);
                                        parcelas_receber.setStatus("PG PARCIAL");
                                        parcelas_receber.setValor_pago(parcelas_receber.getValor_pago().add(dinheiroPago));
                                        dinheiroPago = dinheiroPago.subtract(parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()));
                                    }

                                    parcelas_receber_historico_recebimento.setHora_recebimento(fmtHora.format(new Date()));
                                    Fachada.getInstancia().editarParcelas_receberJDBC(parcelas_receber);

                                    Fachada.getInstancia().incluirHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
                                    relacaoDePagos += (parcelas_receber.getId() + "  ");
                                } catch (Exception exc) {
                                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exc);
                                    JOptionPane.showMessageDialog(rootPane, "Não foi possível quitar as contas!", "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                    if (JOptionPane.showConfirmDialog(null, "Deseja imprimir o Comprovante?",
                            "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        //relatorio
                    }
                    JOptionPane.showMessageDialog(rootPane, "Contas quitadas com sucessso!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exc) {
                    Logger.getLogger(this.getName()).log(Level.SEVERE, null, exc);
                }
                consultarContasReceber();
            } else {
                jTF_valorPagarConta.requestFocus();
                jTF_valorPagarConta.selectAll();
            }
        } catch (Exception ex) {
            Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void consultarParcelaPeloId() {
        if (!jTF_id_parcela.getText().isEmpty()) {
            ArrayList<FinanceiroParcelas> arrayList = Fachada.getInstancia().consultarParcelasReceberQuery("select * from parcelas_receber where id_parcelas_receber = " + jTF_id_parcela.getText());
            DefaultTableModel dtm = (DefaultTableModel) jT_contasReceber.getModel();
            BigDecimal valor_total = BigDecimal.ZERO;
            if (!arrayList.isEmpty()) {
                FinanceiroParcelas parcelas_receber = arrayList.get(0);
                ArrayList<Financeiro> lista = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where id_contas_receber = " + parcelas_receber.getFinanceiro().getId() + " and NOT excluido");
                SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
                String data_venc = in.format(parcelas_receber.getData_vencimento());
                String data_emissao = in.format(lista.get(0).getData_emissao());
                String data_pagamento = "";
                if (parcelas_receber.getData_pagamento() != null) {
                    String dateofmoney = in.format(parcelas_receber.getData_pagamento());
                    data_pagamento = dateofmoney;
                }
                if (parcelas_receber.getStatus().equals("NAO") && !parcelas_receber.getParcela().equalsIgnoreCase("ENTRADA") && !parcelas_receber.getStatus().equals("PG PARCIAL")) {
                    valor_total = valor_total.add(parcelas_receber.getValor());
                } else if (parcelas_receber.getStatus().equals("PG PARCIAL")) {
                    valor_total = valor_total.add(parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()));
                }
                dtm.addRow(new Object[]{lista.get(0).getId(), parcelas_receber.getId(),
                    parcelas_receber.getLancamento(), parcelas_receber.getStatus(), parcelas_receber.getParcela(),
                    data_venc, parcelas_receber.getValor().setScale(2, RoundingMode.HALF_UP), parcelas_receber.getValor_pago().setScale(2, RoundingMode.HALF_UP),
                    parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()).setScale(2, RoundingMode.HALF_UP), data_pagamento,
                    data_emissao, lista.get(0).getReferente()});
                jL_somaCR.setText(valor_total.setScale(2, RoundingMode.HALF_UP).toString());
                jTF_valorPagarConta.setText(valor_total.setScale(2, RoundingMode.HALF_UP).toString());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhum código inserido!");
        }

    }

    private void contaReceberSelecionada() throws Exception {
        //TODO: PAREI COM EDIÇÃO DE CONTAS AQUI
        limparTabelaParcelasReceber();
        limpar();
        jB_cancelarConta.setEnabled(true);
        jTP_Contas_Receber.setSelectedIndex(1);
        DefaultTableModel dtm = (DefaultTableModel) jT_gerar_parcelas_CR.getModel();
        int row = jT_contasReceber.getSelectedRow();
        int id_conta = (Integer) jT_contasReceber.getModel().getValueAt(row, 0);
        ArrayList arrayList = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where id = " + id_conta);
        cr = (Financeiro) arrayList.get(0);
        cliente = cr.getCliente();
        jL_codigo_receber.setText(String.valueOf(cr.getId()));
        SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
        String data = in.format(cr.getData_emissao());
        jTF_data_emissao_CR.setText(data);
        jTF_codClienteNovo.setText(String.valueOf(cr.getCliente().getId()));
        jTF_razaoCRNovo.setText(cliente.getNome());
        jTF_referente_CR.setText(cr.getReferente());
        jTF_documento_CR.setText(cr.getDocumento());
        jTF_total_CR.setText(cr.getValor_total().setScale(2, RoundingMode.DOWN).toString());
        jTF_parcelas_CR.setText(String.valueOf(cr.getNumero_parcelas()));
        jTF_entrada_CR.setText(cr.getEntrada().setScale(2, RoundingMode.DOWN).toString());
        ArrayList arrayListParcelas = cr.getListaParcelasReceber();
        Boolean b = true;
        int i = 0;
        while (arrayListParcelas.size() > i) {
            pr = (FinanceiroParcelas) arrayListParcelas.get(i);
            String datavencimento = in.format(pr.getData_vencimento());
            if (i == 0) {
                jTF_data_p_venc_CR.setText(datavencimento);
            }
            String data_pagamento = "";
            if (pr.getData_pagamento() != null) {
                data_pagamento = in.format(pr.getData_pagamento());
                b = false;
            }
            dtm.addRow(new Object[]{
                pr.getLancamento(),
                pr.getValor().setScale(2, RoundingMode.HALF_UP),
                datavencimento,
                pr.getParcela(),
                pr.getValor_pago().setScale(2, RoundingMode.HALF_UP),
                data_pagamento});
            i++;
        }
        liberaCamposEditaveis(b);
    }

    private void liberaCamposEditaveis(boolean b) {
        for (Component comp : jPanel4.getComponents()) {
            if (comp instanceof JTextField && ((JTextField) comp).isEditable()) {
                ((JTextField) comp).setEditable(b);
            }
            if (comp instanceof JFormattedTextField) {
                ((JFormattedTextField) comp).setEditable(b);
            }
        }
        jB_gerar_parc_CR.setEnabled(b);
        jB_data3.setEnabled(b);
    }

    private void liberaDatasDePesquisas(boolean jCB_data_pagamentoLiberado, boolean jCB_data_vencimentoLiberado, boolean jCB_data_emissaoLiberado, boolean jCB_data_exclusaoLiberado, JCheckBox jCB_padrao) {
        jCB_data_pagamento.setEnabled(jCB_data_pagamentoLiberado);
        jCB_data_vencimento.setEnabled(jCB_data_vencimentoLiberado);
        jCB_data_emissao.setEnabled(jCB_data_emissaoLiberado);
        jCB_data_exclusao.setVisible(jCB_data_exclusaoLiberado);
        jCB_padrao.setSelected(true);
    }

    private class TableRowHeaderCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            setFont(new java.awt.Font("Lucida Sans", 0, 12));
            setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
            setBackground(new Color(244, 242, 228));

            setValue((String) value);

            return this;
        }
    }

    private static void mostreBoletoNaTela(File arquivoBoleto) {
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            desktop.open(arquivoBoleto);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        boolean contemParcelaPaga = false;
        for (int i = 0; i < jT_gerar_parcelas_CR.getRowCount(); i++) {
            if (!jT_gerar_parcelas_CR.getModel().getValueAt(i, 3).toString().equalsIgnoreCase("ENTRADA")) {
                Date date = null;
                BigDecimal valorParc = (BigDecimal) jT_gerar_parcelas_CR.getModel().getValueAt(i, 1);
                BigDecimal valorPago = (BigDecimal) jT_gerar_parcelas_CR.getModel().getValueAt(i, 4);
                String data_venc = (String) (jT_gerar_parcelas_CR.getModel().getValueAt(i, 2));
                String formato = "dd/MM/yyyy";
                try {
                    date = new SimpleDateFormat(formato).parse(data_venc);
                } catch (ParseException ex) {
                    Logger.getLogger(ContasAReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                FinanceiroParcelas par = new FinanceiroParcelas();
                par.setData_vencimento(date);
                par.setValor(valorParc);
                par.setStatus(valorPago.compareTo(valorParc) >= 0 ? "PG" : valorPago.compareTo(BigDecimal.ZERO) == 0 ? "NAO" : "PG PARCIAL");

                listaParcelas.add(par);
                if (!contemParcelaPaga) {
                    contemParcelaPaga = par.getStatus().equals("NAO");
                }
            }
        }
        EditaValorVencimentoParcelasReceberDialog dialog = new EditaValorVencimentoParcelasReceberDialog(null, true, listaParcelas, ClasseUtilitaria.parseToBig(jTF_total_CR.getText()), ClasseUtilitaria.parseToBig(jTF_entrada_CR.getText()), contemParcelaPaga);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        DefaultTableModel dtm = (DefaultTableModel) jT_gerar_parcelas_CR.getModel();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if (dialog.importaEntrada() > 0) {
            int index = 1;
            for (int i = 0; i < dialog.importaListaParcelas().size(); i++) {
                dtm.setValueAt(format.format(dialog.importaListaParcelas().get(i).getData_vencimento()), index, 2);
                dtm.setValueAt(dialog.importaListaParcelas().get(i).getValor(), index, 1);
                index++;
            }
        } else {
            int index = 0;
            for (int i = 0; i < dialog.importaListaParcelas().size(); i++) {
                dtm.setValueAt(format.format(dialog.importaListaParcelas().get(i).getData_vencimento()), index, 2);
                dtm.setValueAt(dialog.importaListaParcelas().get(i).getValor(), index, 1);
                index++;
            }
        }
    }
}
