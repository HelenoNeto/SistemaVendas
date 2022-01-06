package GUI;

import Dados.ConectaBDProduto;
import Negocios.*;
import Relatorios.RelatorioContasReceber;
import Relatorios.RelatorioVenda;
import Utilitarios.ClasseUtilitaria;
import Utilitarios.Dir;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.EdgedBalloonStyle;
import org.jdesktop.swingx.JXSearchField;
import static sistema.gas.SISTEMA_GAS._FuncionarioLogado;
import sistema.gas.cliente.dados.ConectaBDCliente;
import sistema.gas.cliente.dados.ConectaBDClienteVasilhame;
import sistema.gas.cliente.gui.ClienteDialogGUI;
import sistema.gas.venda.tableModel.TableModelVenda;
import sistema.gas.venda.tableModel.TableModelVendaItens;
import sistema.gas.venda.tableModel.VendaColumnModel;
import sistema.gas.venda.tableModel.VendaItensColumnModel;

public final class VendaGUI extends javax.swing.JFrame {

    private VendaCabecalho vendaCabecalho;
    private final ArrayList<VendaDetalhe> listaDetalhe = new ArrayList<>();
    private Produto p = new Produto();
    private Cliente cliente = null;
    private TipoPagamento tipoPagamento;
    private Financeiro contas_receber;
    private Funcionario vendedor;
    private BigDecimal totalGeral = BigDecimal.ZERO;
    private BigDecimal subTotal = BigDecimal.ZERO;
    private BigDecimal acrescimo = BigDecimal.ZERO;
    private BigDecimal desconto = BigDecimal.ZERO;
    private final SimpleDateFormat fmtDateddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
    private boolean vasilhame_pendente;
    private BigDecimal qtd_vasilhame_pendente = BigDecimal.ZERO;
    private BigDecimal qtd_vasilhame_vazio = BigDecimal.ZERO;
    private boolean imprimirVasilhamePendente = false;
    private BalloonTip balloonTip;
    private TableModelVenda model;
    private TableModelVendaItens modelItens;

    public VendaGUI() {
        initComponents();

        TeclouBarraAction teclouBarraAction = new TeclouBarraAction();
        jT_itens_venda.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "teclouBarraAction");
        jT_itens_venda.getActionMap().put("teclouBarraAction", teclouBarraAction);

        botoes(false, false, false, false);
        jCB_filtro_codigo.setSelected(true);
        jXDP_data_filtro.setVisible(false);

        configuraJtable();
        eventosPesquisar();
        pesquisarVenda();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_filtro = new javax.swing.ButtonGroup();
        jTP_dav = new javax.swing.JTabbedPane();
        jpConsultar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_vendaCabecalho = new javax.swing.JTable();
        jB_cancelar = new javax.swing.JButton();
        jB_ok = new javax.swing.JButton();
        jB_novo = new javax.swing.JButton();
        jTF_pesquisar = new org.jdesktop.swingx.JXSearchField();
        jCB_filtro_codigo = new javax.swing.JRadioButton();
        jCB_filtro_cliente = new javax.swing.JRadioButton();
        jCB_data = new javax.swing.JRadioButton();
        jCB_vendedor = new javax.swing.JRadioButton();
        jXDP_data_filtro = new org.jdesktop.swingx.JXDatePicker();
        jpCadastrar = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTF_cod_produto = new javax.swing.JTextField();
        jTF_produto_nome = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTF_qntd = new javax.swing.JTextField();
        jTF_valor_unitario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jT_itens_venda = new javax.swing.JTable();
        jB_salvar = new javax.swing.JButton();
        jB_excluir = new javax.swing.JButton();
        jB_cancelar_cadastrar = new javax.swing.JButton();
        jTF_total = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jB_imprimir = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTF_desconto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTF_subTotal = new javax.swing.JTextField();
        jB_editar = new javax.swing.JButton();
        jL_tipoDesconto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTF_acrescimo = new javax.swing.JTextField();
        jL_tipoAcres = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtaObs = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jTF_cod_cliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTF_nome_cliente = new javax.swing.JTextField();
        labelTipoPagamento = new javax.swing.JLabel();
        jTF_cod_tipo_pagamento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTF_descricao_tipo_pagamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTF_cod_vendedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTF_nome_vendedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Venda");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTP_dav.setEnabled(false);
        jTP_dav.setFocusable(false);
        jTP_dav.setVerifyInputWhenFocusTarget(false);

        jpConsultar.setFocusable(false);

        jT_vendaCabecalho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jT_vendaCabecalho.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jT_vendaCabecalho.getTableHeader().setReorderingAllowed(false);
        jT_vendaCabecalho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_vendaCabecalhoMouseClicked(evt);
            }
        });
        jT_vendaCabecalho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_vendaCabecalhoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jT_vendaCabecalho);

        jB_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_cancelar.setText("Fechar");
        jB_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarActionPerformed(evt);
            }
        });

        jB_ok.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jB_ok.setText("Abrir");
        jB_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_okActionPerformed(evt);
            }
        });

        jB_novo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adiciona.png"))); // NOI18N
        jB_novo.setText("Novo");
        jB_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_novoActionPerformed(evt);
            }
        });

        jTF_pesquisar.setPrompt("Buscar");

        buttonGroup_filtro.add(jCB_filtro_codigo);
        jCB_filtro_codigo.setText("Código");
        jCB_filtro_codigo.setFocusable(false);
        jCB_filtro_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_filtro_codigoActionPerformed(evt);
            }
        });

        buttonGroup_filtro.add(jCB_filtro_cliente);
        jCB_filtro_cliente.setText("Cliente");
        jCB_filtro_cliente.setFocusable(false);
        jCB_filtro_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_filtro_clienteActionPerformed(evt);
            }
        });

        buttonGroup_filtro.add(jCB_data);
        jCB_data.setText("Data");
        jCB_data.setFocusable(false);
        jCB_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_dataActionPerformed(evt);
            }
        });

        buttonGroup_filtro.add(jCB_vendedor);
        jCB_vendedor.setText("Vendedor");
        jCB_vendedor.setFocusable(false);
        jCB_vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_vendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpConsultarLayout = new javax.swing.GroupLayout(jpConsultar);
        jpConsultar.setLayout(jpConsultarLayout);
        jpConsultarLayout.setHorizontalGroup(
            jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConsultarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpConsultarLayout.createSequentialGroup()
                        .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCB_filtro_codigo)
                            .addComponent(jCB_filtro_cliente))
                        .addGap(2, 2, 2)
                        .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCB_vendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCB_data, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXDP_data_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_pesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE))
                .addGap(5, 5, 5))
            .addGroup(jpConsultarLayout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jB_novo)
                .addGap(0, 0, 0)
                .addComponent(jB_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jB_cancelar)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        jpConsultarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_cancelar, jB_novo, jB_ok});

        jpConsultarLayout.setVerticalGroup(
            jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultarLayout.createSequentialGroup()
                .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpConsultarLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCB_filtro_codigo)
                            .addComponent(jCB_data))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCB_filtro_cliente)
                            .addComponent(jCB_vendedor))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpConsultarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXDP_data_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_ok)
                    .addComponent(jB_cancelar)
                    .addComponent(jB_novo))
                .addGap(5, 5, 5))
        );

        jpConsultarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_cancelar, jB_novo, jB_ok});

        jTP_dav.addTab("Consultar", jpConsultar);

        jpCadastrar.setFocusable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        jLabel10.setText("Código:");

        jTF_cod_produto.setToolTipText("Entre com o código ou pressione F1 para listar!");
        jTF_cod_produto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_cod_produtoFocusGained(evt);
            }
        });
        jTF_cod_produto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_cod_produtoKeyPressed(evt);
            }
        });

        jTF_produto_nome.setEditable(false);
        jTF_produto_nome.setForeground(new java.awt.Color(0, 0, 255));
        jTF_produto_nome.setFocusable(false);

        jLabel11.setText("Qntd:");

        jTF_qntd.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_qntd.setText("1,00");
        jTF_qntd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_qntdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_qntdFocusLost(evt);
            }
        });
        jTF_qntd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_qntdKeyPressed(evt);
            }
        });

        jTF_valor_unitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_valor_unitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_valor_unitarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_valor_unitarioFocusLost(evt);
            }
        });
        jTF_valor_unitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_valor_unitarioKeyPressed(evt);
            }
        });

        jT_itens_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jT_itens_venda.setToolTipText("Para editar item ( 2 clique ou [enter] )   ...  Para excluir [Delete]");
        jT_itens_venda.setName("Produtos"); // NOI18N
        jT_itens_venda.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jT_itens_venda.getTableHeader().setReorderingAllowed(false);
        jT_itens_venda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_itens_vendaMouseClicked(evt);
            }
        });
        jT_itens_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_itens_vendaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jT_itens_venda);

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

        jB_cancelar_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_cancelar_cadastrar.setText("Cancelar");
        jB_cancelar_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelar_cadastrarActionPerformed(evt);
            }
        });

        jTF_total.setEditable(false);
        jTF_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTF_total.setForeground(new java.awt.Color(0, 0, 255));
        jTF_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_total.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Total:");

        jB_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/printer.png"))); // NOI18N
        jB_imprimir.setText("Imprimir");
        jB_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_imprimirActionPerformed(evt);
            }
        });

        jLabel15.setText("Desconto:");

        jTF_desconto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTF_desconto.setForeground(new java.awt.Color(0, 153, 0));
        jTF_desconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_desconto.setText("0,00");
        jTF_desconto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTF_desconto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTF_descontoMouseClicked(evt);
            }
        });

        jLabel19.setText("SubTotal:");

        jTF_subTotal.setEditable(false);
        jTF_subTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTF_subTotal.setForeground(new java.awt.Color(255, 0, 51));
        jTF_subTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_subTotal.setFocusable(false);

        jB_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/wand.png"))); // NOI18N
        jB_editar.setText("Editar");
        jB_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_editarActionPerformed(evt);
            }
        });

        jLabel1.setText("Acrescimo:");

        jTF_acrescimo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTF_acrescimo.setForeground(new java.awt.Color(0, 153, 0));
        jTF_acrescimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_acrescimo.setText("0,00");
        jTF_acrescimo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_acrescimoFocusGained(evt);
            }
        });
        jTF_acrescimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTF_acrescimoMouseClicked(evt);
            }
        });

        jLabel14.setText("Valor unitário:");

        jtaObs.setColumns(20);
        jtaObs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtaObs.setLineWrap(true);
        jtaObs.setRows(5);
        jtaObs.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jtaObs);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTF_cod_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_qntd, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_valor_unitario))
                    .addComponent(jTF_produto_nome)))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 180, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_acrescimo)
                            .addComponent(jTF_desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jL_tipoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jL_tipoAcres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(296, 296, 296)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel13))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_subTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jTF_total)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jB_salvar)
                        .addGap(0, 0, 0)
                        .addComponent(jB_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jB_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jB_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jB_cancelar_cadastrar)
                        .addGap(200, 200, 200))))
            .addComponent(jScrollPane3)
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_cancelar_cadastrar, jB_editar, jB_excluir, jB_imprimir, jB_salvar});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jL_tipoAcres, jL_tipoDesconto});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTF_cod_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTF_qntd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_valor_unitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTF_produto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jL_tipoAcres, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTF_desconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jL_tipoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTF_acrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_salvar)
                    .addComponent(jB_excluir)
                    .addComponent(jB_imprimir)
                    .addComponent(jB_editar)
                    .addComponent(jB_cancelar_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTF_acrescimo, jTF_desconto});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTF_subTotal, jTF_total});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_cancelar_cadastrar, jB_editar, jB_excluir, jB_imprimir, jB_salvar});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jL_tipoAcres, jL_tipoDesconto});

        jLabel3.setText("Cliente:");

        jTF_cod_cliente.setToolTipText("Entre com o código ou pressione F1 para listar!");
        jTF_cod_cliente.setName("Cliente"); // NOI18N
        jTF_cod_cliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_cod_clienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_cod_clienteFocusLost(evt);
            }
        });
        jTF_cod_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_cod_clienteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_cod_clienteKeyTyped(evt);
            }
        });

        jLabel8.setText("-");

        jTF_nome_cliente.setEditable(false);
        jTF_nome_cliente.setFocusable(false);

        labelTipoPagamento.setText("Tipo Pagamento:");

        jTF_cod_tipo_pagamento.setToolTipText("Entre com o código ou pressione F1 para listar!");
        jTF_cod_tipo_pagamento.setName("Tipo de Pagamento"); // NOI18N
        jTF_cod_tipo_pagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_cod_tipo_pagamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_cod_tipo_pagamentoFocusLost(evt);
            }
        });
        jTF_cod_tipo_pagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_cod_tipo_pagamentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_cod_tipo_pagamentoKeyTyped(evt);
            }
        });

        jLabel9.setText("-");

        jTF_descricao_tipo_pagamento.setEditable(false);
        jTF_descricao_tipo_pagamento.setFocusable(false);

        jLabel2.setText("Vendedor:");

        jTF_cod_vendedor.setToolTipText("Entre com o código ou pressione F1 para listar!");
        jTF_cod_vendedor.setName("Vendedor"); // NOI18N
        jTF_cod_vendedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_cod_vendedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_cod_vendedorFocusLost(evt);
            }
        });
        jTF_cod_vendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_cod_vendedorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_cod_vendedorKeyTyped(evt);
            }
        });

        jLabel4.setText("-");

        jTF_nome_vendedor.setEditable(false);
        jTF_nome_vendedor.setFocusable(false);

        jLabel5.setText("Código:");

        jtfCodigo.setEditable(false);
        jtfCodigo.setFocusable(false);

        javax.swing.GroupLayout jpCadastrarLayout = new javax.swing.GroupLayout(jpCadastrar);
        jpCadastrar.setLayout(jpCadastrarLayout);
        jpCadastrarLayout.setHorizontalGroup(
            jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpCadastrarLayout.createSequentialGroup()
                        .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTipoPagamento)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_cod_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jTF_cod_tipo_pagamento)
                            .addComponent(jTF_cod_vendedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCadastrarLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_nome_cliente))
                            .addGroup(jpCadastrarLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_descricao_tipo_pagamento))
                            .addGroup(jpCadastrarLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_nome_vendedor))))
                    .addGroup(jpCadastrarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
        jpCadastrarLayout.setVerticalGroup(
            jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTF_cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTF_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipoPagamento)
                    .addComponent(jTF_cod_tipo_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTF_descricao_tipo_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jpCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTF_cod_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTF_nome_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTP_dav.addTab("Cadastrar", jpCadastrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_dav, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_dav, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        setSize(new java.awt.Dimension(953, 669));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_cancelar_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelar_cadastrarActionPerformed
        limpar();
        pesquisarVenda();
        jTP_dav.setSelectedComponent(jpConsultar);
    }//GEN-LAST:event_jB_cancelar_cadastrarActionPerformed

    private void jTF_cod_produtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_produtoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jTF_cod_produto.getText().isEmpty()) {
            try {
                String codigoProduto = jTF_cod_produto.getText().trim();
                ArrayList<Produto> listaProduto = ConectaBDProduto.getInstance().consultarProduto("select * from produto where codigo like '" + codigoProduto + "' and not excluido");
                if (!listaProduto.isEmpty()) {
                    p = listaProduto.get(0);
                    jTF_valor_unitario.setText(ClasseUtilitaria.fmtBig(p.getValor_venda(), 2));
                    jTF_produto_nome.setText(p.getDescricao());
                    jTF_qntd.setText("1,000");
                    jTF_qntd.requestFocus();
                    jTF_qntd.selectAll();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            ProdutoDialog produtoDialog = new ProdutoDialog(this, true, true);
            produtoDialog.setLocationRelativeTo(null);
            produtoDialog.setVisible(true);
            p = produtoDialog.getProduto();
            if (p != null) {
                jTF_cod_produto.setText(p.getCodigo());
                jTF_valor_unitario.setText(ClasseUtilitaria.fmtBig(p.getValor_venda(), 2));
                jTF_produto_nome.setText(p.getDescricao());
                jTF_qntd.setText("1,000");
                jTF_qntd.requestFocus();
                jTF_qntd.selectAll();
            }
        }
    }//GEN-LAST:event_jTF_cod_produtoKeyPressed

    private void jB_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_novoActionPerformed
        limpar();
        botoes(true, false, false, false);
        jTP_dav.setSelectedComponent(jpCadastrar);
    }//GEN-LAST:event_jB_novoActionPerformed

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        Janela_Principal.frameDavGui = null;
        dispose();
    }//GEN-LAST:event_jB_cancelarActionPerformed

    private void jTF_qntdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_qntdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jTF_qntd.getText().isEmpty()) {
            try {
                BigDecimal qtd = ClasseUtilitaria.parseToBig(jTF_qntd.getText());
                if (qtd.compareTo(BigDecimal.ZERO) > 0) {
                    if (p.getId_produto_vasilhame() != 0) {
                        verificaSeTemVasilhame();
                    }
                    if (vendeItem()) {
                        mostraTotais();
                        limparCamposProduto();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Quantidade inválida!", "ALERTA DO SISTEMA", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida!", "ALERTA DO SISTEMA", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTF_qntdKeyPressed
    private void jB_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarActionPerformed
        try {
            if (camposObrigatoriosPreenchidos()) {
                salvarVendaCabecalho();
                salvarVendaDetalhe();
                verificaTipoPagamento();
                listaDetalhe.clear();
                relatorioVendaEscolha();
                JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!");
                limpar();
                pesquisarVenda();
                jTP_dav.setSelectedComponent(jpConsultar);
            }
        } catch (Exception e) {
            Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, "Mensagem", e);
            JOptionPane.showMessageDialog(rootPane, "Mensagem" + "\n" + e + "\n" + e.getMessage());
        }
    }//GEN-LAST:event_jB_salvarActionPerformed

    private void jT_vendaCabecalhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_vendaCabecalhoMouseClicked
        if (evt.getClickCount() == 2) {
            evt.consume();
            limpar();
            vendaSelecionada();
        }
    }//GEN-LAST:event_jT_vendaCabecalhoMouseClicked

    private void jT_vendaCabecalhoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_vendaCabecalhoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
            limpar();
            vendaSelecionada();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jTF_pesquisar.requestFocus();
            jT_vendaCabecalho.clearSelection();
        }
    }//GEN-LAST:event_jT_vendaCabecalhoKeyPressed

    private void jB_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_okActionPerformed
        limpar();
        vendaSelecionada();
    }//GEN-LAST:event_jB_okActionPerformed

    private void jB_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_excluirActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja excluir a venda?", "PERGUNTA DO SISTEMA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            vendaCabecalho.setExcluido(true);
            vendaCabecalho.setData_exclusao(new Date());
            vendaCabecalho.setId_usuario_exclusao(_FuncionarioLogado.getId());
            Fachada.getInstancia().exclusaoLogicaVendaCabecalho(vendaCabecalho);
            for (VendaDetalhe vendaDetalhe : vendaCabecalho.getListaDetalhe()) {
                ConectaBDProduto.getInstance().adicionarEstoqueProduto(vendaDetalhe.getQuantidade(), vendaDetalhe.getProduto());
                if (vendaDetalhe.isVasilhame_pendente()) {
                    try {
                        ArrayList<Produto> listaProdutoVasilhame = ConectaBDProduto.getInstance().consultarProduto("select * from produto where id = " + vendaDetalhe.getProduto().getId_produto_vasilhame());
                        if (!listaProdutoVasilhame.isEmpty()) {
                            ConectaBDProduto.getInstance().adicionarEstoqueProduto(vendaDetalhe.getQtd_vasilhame_pendente(), listaProdutoVasilhame.get(0));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    try {
                        ArrayList<Produto> listaProdutoVasilhame = ConectaBDProduto.getInstance().consultarProduto("select * from produto where id = " + vendaDetalhe.getProduto().getId_produto_vasilhame());
                        if (!listaProdutoVasilhame.isEmpty()) {
                            ConectaBDProduto.getInstance().diminuirEstoqueProduto(vendaDetalhe.getQuantidade(), listaProdutoVasilhame.get(0));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            if (vendaCabecalho.getContas_Receber() != null) {
                verificaContaVinculada();
            }
            JOptionPane.showMessageDialog(rootPane, "Excluído com sucesso!");
            limpar();
            pesquisarVenda();
            jTP_dav.setSelectedComponent(jpConsultar);
        }
}//GEN-LAST:event_jB_excluirActionPerformed

    private void jT_itens_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_itens_vendaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            editaItemDaVenda();
        } else if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o produto da venda?", "PERGUNTA DO SISTEMA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int row = jT_itens_venda.getSelectedRow();
                DefaultTableModel dtm = (DefaultTableModel) jT_itens_venda.getModel();
                BigDecimal valorTotal = ClasseUtilitaria.parseToBig((String) jT_itens_venda.getModel().getValueAt(row, 5));

                subTotal = subTotal.subtract(valorTotal);
                totalGeral = totalGeral.subtract(valorTotal);

                jTF_subTotal.setText(ClasseUtilitaria.fmtBig(subTotal, 2));
                jTF_total.setText(ClasseUtilitaria.fmtBig(totalGeral, 2));
                dtm.removeRow(row);
            }
        }
    }//GEN-LAST:event_jT_itens_vendaKeyPressed

    private void jB_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_imprimirActionPerformed
        relatorioVendaEscolha();
    }//GEN-LAST:event_jB_imprimirActionPerformed

    private void jTF_qntdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_qntdFocusGained
        jTF_qntd.selectAll();
    }//GEN-LAST:event_jTF_qntdFocusGained

    private void jTF_valor_unitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_valor_unitarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_qntd.requestFocus();
        }
    }//GEN-LAST:event_jTF_valor_unitarioKeyPressed

    private void jB_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_editarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja editar a venda?", "PERGUNTA DO SISTEMA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            editarVenda();
            relatorioVendaEscolha();
            JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso!");
            limpar();
            pesquisarVenda();
            jTP_dav.setSelectedComponent(jpConsultar);
        }
    }//GEN-LAST:event_jB_editarActionPerformed

    private void jTF_acrescimoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_acrescimoFocusGained
    }//GEN-LAST:event_jTF_acrescimoFocusGained

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Janela_Principal.frameDavGui = null;
        if (jTP_dav.getSelectedIndex() == 1) {
            limpar();
            pesquisarVenda();
            jTP_dav.setSelectedComponent(jpConsultar);
        } else {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTF_valor_unitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_valor_unitarioFocusGained
        jTF_valor_unitario.selectAll();
    }//GEN-LAST:event_jTF_valor_unitarioFocusGained

    private void jT_itens_vendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_itens_vendaMouseClicked
        if (evt.getClickCount() == 2) {
            editaItemDaVenda();
        }
    }//GEN-LAST:event_jT_itens_vendaMouseClicked

    private void jTF_descontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTF_descontoMouseClicked
        calculaDesconto();
    }//GEN-LAST:event_jTF_descontoMouseClicked

    private void jTF_acrescimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTF_acrescimoMouseClicked
        calculaAcrescimoDav();
    }//GEN-LAST:event_jTF_acrescimoMouseClicked

    private void jTF_cod_tipo_pagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_tipo_pagamentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            TipoPagamentoGUI tipoPagamentoGUI = new TipoPagamentoGUI(this, true, true);
            tipoPagamentoGUI.setLocationRelativeTo(null);
            tipoPagamentoGUI.setVisible(true);
            tipoPagamento = tipoPagamentoGUI.retornaObjeto();
            if (tipoPagamento != null) {
                jTF_cod_tipo_pagamento.setText(String.valueOf(tipoPagamento.getId()));
                jTF_descricao_tipo_pagamento.setText(tipoPagamento.getDescricao());

                jTF_cod_vendedor.requestFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                tipoPagamento = Fachada.getInstancia().consultarTipoPagamento(Integer.valueOf(jTF_cod_tipo_pagamento.getText().trim()));
                if (tipoPagamento != null) {
                    jTF_descricao_tipo_pagamento.setText(tipoPagamento.getDescricao());
                    jTF_cod_vendedor.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTF_cod_tipo_pagamentoKeyPressed

    private void jTF_cod_tipo_pagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cod_tipo_pagamentoFocusLost
        if (!jTF_cod_tipo_pagamento.getText().isEmpty()) {
            try {
                jTF_cod_tipo_pagamento.setBackground(Color.white);
                jTF_descricao_tipo_pagamento.setBackground(Color.white);
                tipoPagamento = Fachada.getInstancia().consultarTipoPagamento(Integer.valueOf(jTF_cod_tipo_pagamento.getText().trim()));
                if (tipoPagamento != null) {
                    jTF_descricao_tipo_pagamento.setText(tipoPagamento.getDescricao());
                    jTF_cod_vendedor.requestFocus();
                } else {
                    jTF_cod_tipo_pagamento.setText("");
                    jTF_descricao_tipo_pagamento.setText("");
                    jTF_cod_vendedor.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jTF_cod_tipo_pagamento.setBackground(Color.yellow);
            jTF_descricao_tipo_pagamento.setBackground(Color.yellow);
        }
        if (balloonTip != null) {
            balloonTip.setVisible(false);
        }
    }//GEN-LAST:event_jTF_cod_tipo_pagamentoFocusLost

    private void jTF_cod_produtoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cod_produtoFocusGained
        jTF_cod_produto.selectAll();
    }//GEN-LAST:event_jTF_cod_produtoFocusGained

    private void jTF_cod_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jTF_cod_cliente.getText().isEmpty()) {
            try {
                cliente = ConectaBDCliente.getInstance().consultarCliente(Integer.valueOf(jTF_cod_cliente.getText().trim()));
                if (cliente != null) {
                    jTF_cod_cliente.setText(cliente.getId().toString());
                    jTF_nome_cliente.setText(cliente.getNome());
                    jTF_cod_tipo_pagamento.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            ClienteDialogGUI clienteDialogGUI = new ClienteDialogGUI(this, true, true);
            clienteDialogGUI.setLocationRelativeTo(null);
            clienteDialogGUI.setVisible(true);
            cliente = clienteDialogGUI.getCliente();
            if (cliente != null) {
                jTF_cod_cliente.setText(cliente.getId().toString());
                jTF_nome_cliente.setText(cliente.getNome());
                jTF_cod_tipo_pagamento.requestFocus();
            }
        }
    }//GEN-LAST:event_jTF_cod_clienteKeyPressed

    private void jTF_cod_vendedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cod_vendedorFocusGained
        if (vendedor == null) {
            if (balloonTip != null) {
                balloonTip.setVisible(false);
            }
            balloonTip = new BalloonTip(jTF_cod_vendedor,
                    "Pressione F1 para buscar um vendedor ou entre com o código.",
                    new EdgedBalloonStyle(Color.WHITE, Color.BLUE), false);
        }
        jTF_cod_vendedor.selectAll();
    }//GEN-LAST:event_jTF_cod_vendedorFocusGained

    private void jTF_cod_vendedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_vendedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !jTF_cod_vendedor.getText().isEmpty()) {
            try {
                vendedor = Fachada.getInstancia().consultarFuncionario(Integer.valueOf(jTF_cod_vendedor.getText().trim()));
                if (vendedor != null) {
                    jTF_cod_vendedor.setText(vendedor.getId().toString());
                    jTF_nome_vendedor.setText(vendedor.getNome());
                    jTF_cod_produto.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F1) {
            FuncionariosDialog funcionarios_Dialog = new FuncionariosDialog(this, true, true);
            funcionarios_Dialog.setLocationRelativeTo(null);
            funcionarios_Dialog.setVisible(true);
            vendedor = funcionarios_Dialog.getFuncionario();
            if (vendedor != null) {
                jTF_cod_vendedor.setText(vendedor.getId().toString());
                jTF_nome_vendedor.setText(vendedor.getNome());
                jTF_cod_produto.requestFocus();
            }
        }
    }//GEN-LAST:event_jTF_cod_vendedorKeyPressed

    private void jCB_filtro_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_filtro_codigoActionPerformed
        if (jCB_data.isSelected()) {
            jTF_pesquisar.setVisible(false);
            jXDP_data_filtro.setVisible(true);
        } else {
            jXDP_data_filtro.setDate(null);
            jTF_pesquisar.setVisible(true);
            jXDP_data_filtro.setVisible(false);
        }
    }//GEN-LAST:event_jCB_filtro_codigoActionPerformed

    private void jCB_filtro_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_filtro_clienteActionPerformed
        if (jCB_data.isSelected()) {
            jTF_pesquisar.setVisible(false);
            jXDP_data_filtro.setVisible(true);
        } else {
            jXDP_data_filtro.setDate(null);
            jTF_pesquisar.setVisible(true);
            jXDP_data_filtro.setVisible(false);
        }
    }//GEN-LAST:event_jCB_filtro_clienteActionPerformed

    private void jCB_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_dataActionPerformed
        if (jCB_data.isSelected()) {
            jTF_pesquisar.setVisible(false);
            jXDP_data_filtro.setVisible(true);
        } else {
            jXDP_data_filtro.setDate(null);
            jTF_pesquisar.setVisible(true);
            jXDP_data_filtro.setVisible(false);
        }
    }//GEN-LAST:event_jCB_dataActionPerformed

    private void jCB_vendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_vendedorActionPerformed
        if (jCB_data.isSelected()) {
            jTF_pesquisar.setVisible(false);
            jXDP_data_filtro.setVisible(true);
        } else {
            jXDP_data_filtro.setDate(null);
            jTF_pesquisar.setVisible(true);
            jXDP_data_filtro.setVisible(false);
        }
    }//GEN-LAST:event_jCB_vendedorActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jTF_cod_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cod_clienteFocusLost
        if (!jTF_cod_cliente.getText().isEmpty()) {
            try {
                jTF_cod_cliente.setBackground(Color.white);
                jTF_nome_cliente.setBackground(Color.white);
                Cliente cli = ConectaBDCliente.getInstance().consultarCliente(Integer.valueOf(jTF_cod_cliente.getText().trim()));
                if (cli != null) {
                    jTF_cod_cliente.setText(cli.getId().toString());
                    jTF_nome_cliente.setText(cli.getNome());
                    jTF_cod_tipo_pagamento.requestFocus();
                } else {
                    jTF_cod_cliente.setText("");
                    jTF_nome_cliente.setText("");
                    jTF_cod_tipo_pagamento.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jTF_cod_cliente.setBackground(Color.yellow);
            jTF_nome_cliente.setBackground(Color.yellow);
        }
        if (balloonTip != null) {
            balloonTip.setVisible(false);
        }
    }//GEN-LAST:event_jTF_cod_clienteFocusLost

    private void jTF_cod_vendedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cod_vendedorFocusLost
        if (!jTF_cod_vendedor.getText().isEmpty()) {
            try {
                jTF_cod_vendedor.setBackground(Color.white);
                jTF_nome_vendedor.setBackground(Color.white);
                vendedor = Fachada.getInstancia().consultarFuncionario(Integer.valueOf(jTF_cod_vendedor.getText().trim()));
                if (vendedor != null) {
                    jTF_cod_vendedor.setText(vendedor.getId().toString());
                    jTF_nome_vendedor.setText(vendedor.getNome());
                } else {
                    jTF_cod_vendedor.setText("");
                    jTF_nome_vendedor.setText("");
                }
                jTF_cod_produto.requestFocus();
            } catch (SQLException ex) {
                Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jTF_cod_vendedor.setBackground(Color.yellow);
            jTF_nome_vendedor.setBackground(Color.yellow);
        }
        if (balloonTip != null) {
            balloonTip.setVisible(false);
        }
    }//GEN-LAST:event_jTF_cod_vendedorFocusLost

    private void jTF_qntdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_qntdFocusLost
        replaceVirgulaPorPonto(jTF_qntd);
    }//GEN-LAST:event_jTF_qntdFocusLost

    private void jTF_valor_unitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_valor_unitarioFocusLost
        replaceVirgulaPorPonto(jTF_valor_unitario);
    }//GEN-LAST:event_jTF_valor_unitarioFocusLost

    private void jTF_cod_clienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cod_clienteFocusGained
        if (cliente == null) {
            if (balloonTip != null) {
                balloonTip.setVisible(false);
            }
            balloonTip = new BalloonTip(jTF_cod_cliente,
                    "Pressione F1 para buscar um cliente ou entre com o código.",
                    new EdgedBalloonStyle(Color.WHITE, Color.BLUE), false);
        }
    }//GEN-LAST:event_jTF_cod_clienteFocusGained

    private void jTF_cod_tipo_pagamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cod_tipo_pagamentoFocusGained
        if (tipoPagamento == null) {
            if (balloonTip != null) {
                balloonTip.setVisible(false);
            }
            balloonTip = new BalloonTip(jTF_cod_tipo_pagamento,
                    "Pressione F1 para buscar o Tipo de Pagamento ou entre com o código.",
                    new EdgedBalloonStyle(Color.WHITE, Color.BLUE), false);
        }
    }//GEN-LAST:event_jTF_cod_tipo_pagamentoFocusGained

    private void jTF_cod_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_clienteKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTF_cod_clienteKeyTyped

    private void jTF_cod_tipo_pagamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_tipo_pagamentoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTF_cod_tipo_pagamentoKeyTyped

    private void jTF_cod_vendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_vendedorKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTF_cod_vendedorKeyTyped

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
            java.util.logging.Logger.getLogger(VendaGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VendaGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_filtro;
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_cancelar_cadastrar;
    private javax.swing.JButton jB_editar;
    private javax.swing.JButton jB_excluir;
    private javax.swing.JButton jB_imprimir;
    private javax.swing.JButton jB_novo;
    private javax.swing.JButton jB_ok;
    private javax.swing.JButton jB_salvar;
    private javax.swing.JRadioButton jCB_data;
    private javax.swing.JRadioButton jCB_filtro_cliente;
    private javax.swing.JRadioButton jCB_filtro_codigo;
    private javax.swing.JRadioButton jCB_vendedor;
    private javax.swing.JLabel jL_tipoAcres;
    private javax.swing.JLabel jL_tipoDesconto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTF_acrescimo;
    private javax.swing.JTextField jTF_cod_cliente;
    private javax.swing.JTextField jTF_cod_produto;
    private javax.swing.JTextField jTF_cod_tipo_pagamento;
    private javax.swing.JTextField jTF_cod_vendedor;
    private javax.swing.JTextField jTF_desconto;
    private javax.swing.JTextField jTF_descricao_tipo_pagamento;
    private javax.swing.JTextField jTF_nome_cliente;
    private javax.swing.JTextField jTF_nome_vendedor;
    private org.jdesktop.swingx.JXSearchField jTF_pesquisar;
    private javax.swing.JTextField jTF_produto_nome;
    private javax.swing.JTextField jTF_qntd;
    private javax.swing.JTextField jTF_subTotal;
    private javax.swing.JTextField jTF_total;
    private javax.swing.JTextField jTF_valor_unitario;
    private javax.swing.JTabbedPane jTP_dav;
    private javax.swing.JTable jT_itens_venda;
    private javax.swing.JTable jT_vendaCabecalho;
    private org.jdesktop.swingx.JXDatePicker jXDP_data_filtro;
    private javax.swing.JPanel jpCadastrar;
    private javax.swing.JPanel jpConsultar;
    private javax.swing.JTextArea jtaObs;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JLabel labelTipoPagamento;
    // End of variables declaration//GEN-END:variables

    public void limpar() {
        jtfCodigo.setText("");
        jTF_cod_cliente.setText("");
        jTF_cod_produto.setText("");
        jTF_nome_cliente.setText("");
        jTF_produto_nome.setText("");
        jTF_qntd.setText("1");
        jTF_valor_unitario.setText("0,00");
        jTF_subTotal.setText("0,00");
        jTF_total.setText("0,00");
        jTF_desconto.setText("0,00");
        jTF_acrescimo.setText("0,00");
        jL_tipoDesconto.setText("");
        jTF_cod_tipo_pagamento.setText("");
        jTF_descricao_tipo_pagamento.setText("");
        jTF_cod_vendedor.setText("");
        jTF_nome_vendedor.setText("");
        jtaObs.setText("");
        totalGeral = BigDecimal.ZERO;
        subTotal = BigDecimal.ZERO;
    }

    private void botoes(boolean s, boolean e, boolean ex, boolean i) {
        jB_salvar.setEnabled(s);
        jB_editar.setEnabled(e);
        jB_excluir.setEnabled(ex);
        jB_imprimir.setEnabled(i);
    }

    private void calculaDesconto() {
        jTF_subTotal.requestFocus();
        DavDescontoDialogGUI davDescontoDialogGUI = new DavDescontoDialogGUI(this, true, ClasseUtilitaria.parseToBig(jTF_total.getText()));
        davDescontoDialogGUI.setLocationRelativeTo(null);
        davDescontoDialogGUI.setVisible(true);
        jL_tipoDesconto.setText(davDescontoDialogGUI.retornaTipoDesconto());
        if (null == davDescontoDialogGUI.retornaTipoDesconto()) {
            jTF_desconto.setText("0,00");
        } else {
            switch (davDescontoDialogGUI.retornaTipoDesconto()) {
                case "P": {
                    jTF_desconto.setText(davDescontoDialogGUI.retornaValorDesconto());
                    BigDecimal total = ClasseUtilitaria.parseToBig(jTF_subTotal.getText());
                    BigDecimal desc = ClasseUtilitaria.parseToBig(jTF_desconto.getText());
                    BigDecimal total_com_desconto = total.subtract((total.multiply(desc)).divide(ClasseUtilitaria.parseToBig(100)));
                    totalGeral = total_com_desconto;
                    jTF_total.setText(ClasseUtilitaria.fmtBig(total_com_desconto, 2));
                    break;
                }
                case "V": {
                    jTF_desconto.setText(davDescontoDialogGUI.retornaValorDesconto());
                    BigDecimal total = ClasseUtilitaria.parseToBig(jTF_subTotal.getText());
                    BigDecimal desc = ClasseUtilitaria.parseToBig(jTF_desconto.getText());
                    BigDecimal total_com_desconto = total.subtract(desc);
                    totalGeral = total_com_desconto;
                    jTF_total.setText(ClasseUtilitaria.fmtBig(total_com_desconto, 2));
                    break;
                }
                default:
                    break;
            }
        }
        desconto = ClasseUtilitaria.parseToBig(jTF_desconto.getText());
        jTF_subTotal.requestFocus();
        jTF_total.setText(ClasseUtilitaria.fmtBig((jTF_total.getText()), 2));
    }

    private void calculaAcrescimoDav() {
        jTF_subTotal.requestFocus();
        DavAcrescimoDialogGUI davDescontoDialogGUI = new DavAcrescimoDialogGUI(this, true);
        davDescontoDialogGUI.setLocationRelativeTo(null);
        davDescontoDialogGUI.setVisible(true);
        jL_tipoDesconto.setText(davDescontoDialogGUI.retornaTipoAcrescimo());
        if (null == davDescontoDialogGUI.retornaTipoAcrescimo()) {
            jTF_acrescimo.setText("0,00");
        } else {
            switch (davDescontoDialogGUI.retornaTipoAcrescimo()) {
                case "P": {
                    BigDecimal total = ClasseUtilitaria.parseToBig(jTF_subTotal.getText());
                    if (Double.parseDouble(jTF_subTotal.getText()) > Double.parseDouble(jTF_total.getText())) {
                        total = ClasseUtilitaria.parseToBig(jTF_total.getText());
                    }
                    jTF_acrescimo.setText(davDescontoDialogGUI.retornaValorAcrescimo());
                    BigDecimal acresc = ClasseUtilitaria.parseToBig(jTF_acrescimo.getText());
                    BigDecimal total_com_acrescimo = total.add((total.multiply(acresc.divide(ClasseUtilitaria.parseToBig(100)))));
                    totalGeral = total_com_acrescimo;
                    jTF_total.setText(ClasseUtilitaria.fmtBig(total_com_acrescimo, 2));
                    jL_tipoAcres.setText(davDescontoDialogGUI.retornaTipoAcrescimo());
                    break;
                }
                case "V": {
                    BigDecimal total = ClasseUtilitaria.parseToBig(jTF_subTotal.getText());
                    if (Double.parseDouble(jTF_subTotal.getText()) > Double.parseDouble(jTF_total.getText())) {
                        total = ClasseUtilitaria.parseToBig(jTF_total.getText());
                    }
                    jTF_acrescimo.setText(davDescontoDialogGUI.retornaValorAcrescimo());
                    BigDecimal acresc = ClasseUtilitaria.parseToBig(jTF_acrescimo.getText());
                    BigDecimal total_com_acrescimo = total.add(acresc);
                    totalGeral = total_com_acrescimo;
                    jTF_total.setText(ClasseUtilitaria.fmtBig(total_com_acrescimo, 2));
                    jL_tipoAcres.setText(davDescontoDialogGUI.retornaTipoAcrescimo());
                    break;
                }
                default:
                    break;
            }
        }
        acrescimo = ClasseUtilitaria.parseToBig(jTF_acrescimo.getText());
        BigDecimal total = ClasseUtilitaria.parseToBig(jTF_total.getText());
        jTF_total.setText(ClasseUtilitaria.fmtBig(total, 2));
    }

    private boolean vendeItem() {
        boolean inseriu = false;
        if (verificaItemJaIncluso()) {
            BigDecimal quantidade = ClasseUtilitaria.parseToBig(jTF_qntd.getText());
            BigDecimal valorUnitario = ClasseUtilitaria.parseToBig(jTF_valor_unitario.getText());
            BigDecimal totalProduto = valorUnitario.multiply(quantidade);
            // id_venda_cabecalho, Produto produto,  codigoProduto,  descricaoProduto,  unidadeProduto,  quantidade,  valorUniCompra, valor_unitario,  valor_total, boolean vasilhame_pendente,  qtd_vasilhame_pendente
            VendaDetalhe vendaDetalhe = new VendaDetalhe(
                    0,
                    p,
                    p.getCodigo(),
                    p.getDescricao(),
                    p.getUnidadeProduto().getNome(),
                    quantidade,
                    p.getValor_compra(),
                    valorUnitario,
                    totalProduto,
                    vasilhame_pendente,
                    qtd_vasilhame_pendente);
            vendaDetalhe.setQtd_vasilhame_vazio(qtd_vasilhame_vazio);
            vendaDetalhe.setId(0);
            modelItens.addRow(vendaDetalhe);

            totalGeral = totalGeral.add(totalProduto);
            subTotal = subTotal.add(totalProduto);
            inseriu = true;
        }
        return inseriu;
    }

    private void mostraTotais() {
        jTF_subTotal.setText(ClasseUtilitaria.fmtBig(subTotal, 2));
        jTF_total.setText(ClasseUtilitaria.fmtBig(totalGeral, 2));
    }

    private void limparCamposProduto() {
        jTF_cod_produto.setText("");
        jTF_qntd.setText("");
        jTF_valor_unitario.setText("");
        jTF_produto_nome.setText("");
        jTF_cod_produto.requestFocus();

        vasilhame_pendente = false;
        qtd_vasilhame_pendente = BigDecimal.ZERO;
        qtd_vasilhame_vazio = BigDecimal.ZERO;
    }

    private void salvarVendaCabecalho() {
        try {
            vendaCabecalho = new VendaCabecalho(tipoPagamento, vendedor, cliente, null, new Date(), jL_tipoDesconto.getText(), ClasseUtilitaria.parseToBig(jTF_desconto.getText()), jL_tipoAcres.getText(), ClasseUtilitaria.parseToBig(jTF_acrescimo.getText()), subTotal, totalGeral, false, _FuncionarioLogado.getId());
            vendaCabecalho.setObs(jtaObs.getText());
            Fachada.getInstancia().incluirVendaCabecalho(vendaCabecalho);
        } catch (SQLException ex) {
            Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void salvarVendaDetalhe() {
        for (VendaDetalhe vendaDetalhe : modelItens.getDataSet()) {
            try {

                vendaDetalhe.setId_venda_cabecalho(vendaCabecalho.getId());
                Fachada.getInstancia().incluirVendaDetalhe(vendaDetalhe);

                /*
                 Verifica se cliente ficou com vasilhame pendente
                 */
                if (vendaDetalhe.isVasilhame_pendente()) {
                    ClienteVasilhame clienteVasilhame = new ClienteVasilhame();
                    clienteVasilhame.setData_hora_transacao(new Date());
                    clienteVasilhame.setId_venda_detalhe(vendaDetalhe.getId());
                    clienteVasilhame.setId_produto_vasilhame(p.getId_produto_vasilhame());
                    clienteVasilhame.setQuantidade(vendaDetalhe.getQtd_vasilhame_pendente());
                    clienteVasilhame.setStatus("P");
                    ConectaBDClienteVasilhame.getInstance().incluirClienteVasilhame(clienteVasilhame);

                    /*
                     Se vasilhame não retornou não faz nada com o estoque do vasilhame
                     */
//                    ArrayList<Produto> listaProdutoVasilhame = Fachada.getInstancia().consultarProduto("select * from produto where id = " + clienteVasilhame.getId_produto_vasilhame());
//                    Produto produtoVasilhame = listaProdutoVasilhame.get(0);
//                    Fachada.getInstancia().diminuirEstoqueProduto(qtdVasilhamePendente.multiply(p.getQtd_vasilhame()), produtoVasilhame);
                }

                /*
                 Baixa em estoque
                 */
                ConectaBDProduto.getInstance().diminuirEstoqueProduto(vendaDetalhe.getQuantidade(), p);

                /*
                 Incrementa os vasilhames vazios
                 */
                if (vendaDetalhe.getQtd_vasilhame_vazio().compareTo(BigDecimal.ZERO) > 0) {
                    ArrayList<Produto> listaProdutoVasilhame = ConectaBDProduto.getInstance().consultarProduto("select * from produto where id = " + p.getId_produto_vasilhame());
                    Produto produtoVasilhame = listaProdutoVasilhame.get(0);
                    ConectaBDProduto.getInstance().adicionarEstoqueProduto(vendaDetalhe.getQtd_vasilhame_vazio(), produtoVasilhame);
                }
            } catch (SQLException ex) {
                Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean camposObrigatoriosPreenchidos() {
        boolean temCampoVazio;
        ArrayList<String> nomes = new ArrayList<>();
        JTextField campos[] = {jTF_cod_cliente, jTF_cod_tipo_pagamento, jTF_cod_vendedor};
        for (JTextField jTextField : campos) {
            if (jTextField.getText().isEmpty()) {
                jTextField.setBackground(Color.yellow);
                nomes.add(jTextField.getName());
            } else {
                jTextField.setBackground(Color.white);
            }
        }
        temCampoVazio = jT_itens_venda.getRowCount() <= 0;
        nomes.add(jT_itens_venda.getRowCount() <= 0 ? jT_itens_venda.getName() : "");
        if (temCampoVazio) {
            JOptionPane.showMessageDialog(null, "CAMPO(S) OBRIGATÓRIO(S) VAZIO(S)!\nCampos: " + nomes, null, 2);
            return false;
        } else {
            return true;
        }
    }

    private void verificaSeTemVasilhame() {
        if (JOptionPane.showConfirmDialog(rootPane, "Cliente devolveu os vasilhames?",
                "PERGUNTA DO SISTEMA", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            vasilhame_pendente = true;
            JLabel label = new JLabel("Quantidade:");
            final JTextField text = new JTextField(jTF_qntd.getText());
            text.addAncestorListener(new AncestorListener() {

                @Override
                public void ancestorAdded(AncestorEvent event) {
                    text.requestFocusInWindow();
                    text.selectAll();
                }

                @Override
                public void ancestorRemoved(AncestorEvent event) {
                }

                @Override
                public void ancestorMoved(AncestorEvent event) {
                }
            });
            if (JOptionPane.showConfirmDialog(null,
                    new Object[]{label, text}, "Vasilhames não devolvidos",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
                if (ClasseUtilitaria.parseToBig(jTF_qntd.getText()).compareTo(ClasseUtilitaria.parseToBig(text.getText())) < 0) {
                    JOptionPane.showMessageDialog(rootPane, "Quantidade inválida!");
                } else {
                    qtd_vasilhame_pendente = ClasseUtilitaria.parseToBig(text.getText());
                    qtd_vasilhame_vazio = ClasseUtilitaria.parseToBig(jTF_qntd.getText()).subtract(qtd_vasilhame_pendente);
                }
            }
        } else {
            qtd_vasilhame_vazio = ClasseUtilitaria.parseToBig(jTF_qntd.getText());
        }
    }

    private void pesquisarVenda() {
        try {
            jCB_data.setActionCommand("data_venda");
            jCB_filtro_cliente.setActionCommand("cliente_id");
            jCB_filtro_codigo.setActionCommand("id");
            jCB_vendedor.setActionCommand("funcionario_id");

            String porId = (jTF_pesquisar.getText().isEmpty() || !jCB_filtro_codigo.isSelected()) ? "%" : (jTF_pesquisar.getText().isEmpty() && jCB_filtro_codigo.isSelected()) ? "%" : jTF_pesquisar.getText();
            String porCliente = jCB_filtro_cliente.isSelected() ? jTF_pesquisar.getText() : "%";
            String porVendedor = (jCB_vendedor.isSelected() && jTF_pesquisar.getText().isEmpty()) ? "%" : (jCB_vendedor.isSelected() && !jTF_pesquisar.getText().isEmpty()) ? jTF_pesquisar.getText() : "%";
            String porData = (jXDP_data_filtro.getDate() != null && !jXDP_data_filtro.toString().isEmpty()) ? new SimpleDateFormat("yyyy-MM-dd").format(jXDP_data_filtro.getDate()) : "%";

            String query = "select * from venda_cabecalho where DATE_FORMAT(data_venda,'%Y-%m-%d') like '" + porData + "' AND "
                    + "cliente_id in (select id from cliente where nome like '%" + porCliente + "%' OR id like '" + porCliente + "') AND funcionario_id in "
                    + "(select id from funcionario where nome like '%" + porVendedor + "%' OR id like '" + porVendedor + "') AND id like '" + porId + "' and not excluido ORDER BY id DESC LIMIT 100";
            System.out.println(query);
            ArrayList<VendaCabecalho> listaCabecalho = Fachada.getInstancia().consultarVendaCabecalho(query);
            model.addAll(listaCabecalho);
        } catch (SQLException ex) {
            Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verificaTipoPagamento() {
        try {
            if (tipoPagamento.getTipo_vinculo().equals("C")) {
                contas_receber = new Financeiro();
                contas_receber.setCliente(cliente);
                contas_receber.setData_emissao(new Date());
                contas_receber.setDocumento(vendaCabecalho.getId().toString());
                contas_receber.setEntrada(BigDecimal.ZERO);
                contas_receber.setExcluido(false);
                contas_receber.setId_usuario_insercao(_FuncionarioLogado.getId());
                contas_receber.setReferente("Venda Nº: " + vendaCabecalho.getId());
                contas_receber.setValor_total(totalGeral);
                Fachada.getInstancia().incluirContas_ReceberJDBC(contas_receber);

                FinalVendaParcelas finalVendaParcelas = new FinalVendaParcelas(this, true, contas_receber);
                finalVendaParcelas.setLocationRelativeTo(null);
                finalVendaParcelas.setVisible(true);

                vendaCabecalho.setContas_Receber(contas_receber);
            } else {
                vendaCabecalho.setContas_Receber(null);
            }
            vendaCabecalho.setData_edicao(new Date());
            vendaCabecalho.setExcluido(false);
            vendaCabecalho.setId_usuario_edicao(_FuncionarioLogado.getId());
            Fachada.getInstancia().editarVendaCabecalho(vendaCabecalho);
        } catch (SQLException ex) {
            Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editaItemDaVenda() {
        try {
            int row = jT_itens_venda.getSelectedRow();
            int idProduto = (Integer) jT_itens_venda.getModel().getValueAt(row, 0);
            DefaultTableModel dtm = (DefaultTableModel) jT_itens_venda.getModel();
            p = ConectaBDProduto.getInstance().consultarProduto_porId(idProduto);
            if (p != null) {
                jTF_cod_produto.setText(p.getCodigo());
                BigDecimal qtd = ClasseUtilitaria.parseToBig((String) jT_itens_venda.getModel().getValueAt(row, 3));
                BigDecimal valorUnitario = ClasseUtilitaria.parseToBig((String) jT_itens_venda.getModel().getValueAt(row, 4));
                BigDecimal valorTotal = ClasseUtilitaria.parseToBig((String) jT_itens_venda.getModel().getValueAt(row, 5));

                jTF_qntd.setText(ClasseUtilitaria.fmtBig(qtd, 3));
                jTF_valor_unitario.setText(ClasseUtilitaria.fmtBig(valorUnitario, 2));
                jTF_produto_nome.setText(p.getDescricao());

                subTotal = subTotal.subtract(valorTotal);
                totalGeral = totalGeral.subtract(valorTotal);

                jTF_subTotal.setText(ClasseUtilitaria.fmtBig(subTotal, 2));
                jTF_total.setText(ClasseUtilitaria.fmtBig(totalGeral, 2));

                jTF_qntd.requestFocus();

                dtm.removeRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao editar item. Erro: " + ex.getMessage(), "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void vendaSelecionada() {
        int row = jT_vendaCabecalho.getSelectedRow();
        if (row > -1) {
            this.vendaCabecalho = model.getVendaCabecalho(row);
            if (this.vendaCabecalho != null) {
                cliente = vendaCabecalho.getCliente();
                jtfCodigo.setText(vendaCabecalho.getId().toString());
                jTF_cod_cliente.setText(cliente.getId().toString());
                jTF_nome_cliente.setText(cliente.getNome());
                tipoPagamento = vendaCabecalho.getTipoPagamento();
                jTF_cod_tipo_pagamento.setText(String.valueOf(tipoPagamento.getId()));
                jTF_descricao_tipo_pagamento.setText(tipoPagamento.getDescricao());
                vendedor = vendaCabecalho.getVendedor();
                jTF_cod_vendedor.setText(vendedor.getId().toString());
                jTF_nome_vendedor.setText(vendedor.getNome());
                jtaObs.setText(vendaCabecalho.getObs());
                subTotal = vendaCabecalho.getSubtotal();
                totalGeral = vendaCabecalho.getTotal();

                modelItens.addAll(vendaCabecalho.getListaDetalhe());

                jTF_acrescimo.setText(ClasseUtilitaria.fmtBig(vendaCabecalho.getAcrescimo(), 2));
                jTF_desconto.setText(ClasseUtilitaria.fmtBig(vendaCabecalho.getDesconto(), 2));
                jL_tipoAcres.setText(vendaCabecalho.getTipo_acrescimo());
                jL_tipoDesconto.setText(vendaCabecalho.getTipo_desconto());
                jTF_subTotal.setText(ClasseUtilitaria.fmtBig(subTotal, 2));
                jTF_total.setText(ClasseUtilitaria.fmtBig(totalGeral, 2));
                botoes(false, true, true, true);

                jTP_dav.setSelectedIndex(1);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma venda selecionada!", "ALERTA DO SISTEMA", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void editarVenda() {
        try {
            //Volta Estoque
            for (VendaDetalhe vendaDetalhe : vendaCabecalho.getListaDetalhe()) {
                ConectaBDProduto.getInstance().adicionarEstoqueProduto(vendaDetalhe.getQuantidade(), vendaDetalhe.getProduto());
                ArrayList<ClienteVasilhame> listaVasilhames = ConectaBDClienteVasilhame.getInstance().consultarClienteVasilhame("select * from cliente_vasilhame where id_venda_detalhe = " + vendaDetalhe.getId());
                /*
                 Se Vasilhames pendentes = true then não mexe no estoque do vasilhame
                 */
                if (!listaVasilhames.isEmpty()) {
                    ClienteVasilhame cv = listaVasilhames.get(0);
                    ArrayList<Produto> listaProduto = ConectaBDProduto.getInstance().consultarProduto("select * from produto where id = " + cv.getId_produto_vasilhame());
                    if (vendaDetalhe.getQuantidade().compareTo(vendaDetalhe.getQtd_vasilhame_pendente()) > 0) {
                        BigDecimal qtd_vazio = vendaDetalhe.getQuantidade().subtract(vendaDetalhe.getQtd_vasilhame_pendente());
                        ConectaBDProduto.getInstance().diminuirEstoqueProduto(qtd_vazio, listaProduto.get(0));
                    }
                    ConectaBDClienteVasilhame.getInstance().excluirClienteVasilhamePorVenda(vendaDetalhe);
                }
            }
            //Excluir Detalhe
            Fachada.getInstancia().excluirVendaDetalhe(vendaCabecalho);
            //Incluir Novo Detalhe
            salvarVendaDetalhe();
            if (vendaCabecalho.getContas_Receber() != null) {
                verificaContaVinculada();
            }
            verificaTipoPagamento();

            vendaCabecalho.setAcrescimo(acrescimo);
            vendaCabecalho.setCliente(cliente);
            vendaCabecalho.setData_edicao(new Date());
            vendaCabecalho.setDesconto(desconto);
            vendaCabecalho.setExcluido(false);
            vendaCabecalho.setId_usuario_edicao(_FuncionarioLogado.getId());
            vendaCabecalho.setSubtotal(subTotal);
            vendaCabecalho.setTipoPagamento(tipoPagamento);
            vendaCabecalho.setTipo_acrescimo(jL_tipoAcres.getText());
            vendaCabecalho.setTipo_desconto(jL_tipoDesconto.getText());
            vendaCabecalho.setTotal(totalGeral);
            vendaCabecalho.setVendedor(vendedor);
            vendaCabecalho.setObs(jtaObs.getText());
            Fachada.getInstancia().editarVendaCabecalho(vendaCabecalho);
            listaDetalhe.clear();
        } catch (SQLException ex) {
            Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verificaContaVinculada() {
        ArrayList<Financeiro> listaContasReceber = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where id = " + vendaCabecalho.getContas_Receber().getId());
        if (!listaContasReceber.isEmpty()) {
            contas_receber = listaContasReceber.get(0);
            contas_receber.setExcluido(true);
            contas_receber.setData_exclusao(new Date());
            contas_receber.setId_usuario_exclusao(_FuncionarioLogado.getId());
            Fachada.getInstancia().exclusaoLogicaContasReceberJDBC(contas_receber);
        }
    }

    private void relatorioVenda() {
        int idContaReceber = 0;
        if (vendaCabecalho.getContas_Receber() != null) {
            idContaReceber = vendaCabecalho.getContas_Receber().getId();
        }
        new RelatorioVenda().relatorioVenda(vendaCabecalho.getId(), idContaReceber);
    }

    private void relatorioViaCliente() {
        new RelatorioVenda().relatorioViaCliente(vendaCabecalho.getId());
    }

    private void relatorioVendaEscolha() {
        String[] list = {"A4", "CUPOM"};
        JComboBox jcb = new JComboBox(list);
        Object[] opcao = {"Relatório de venda", "Cancelar"};
        int c = JOptionPane.showOptionDialog(
                this, jcb, "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opcao, opcao[0]);
        if (c == 0) {
            if (jcb.getSelectedIndex() == 0) {
                relatorioVenda();
                if (vendaCabecalho.getContas_Receber() != null) {
                    //Carrega Parcelas
                    vendaCabecalho.getContas_Receber().setListaParcelasReceber(Fachada.getInstancia().consultarParcelasReceberQuery("SELECT * FROM PARCELAS_RECEBER WHERE ID_CONTAS_RECEBER = " + vendaCabecalho.getContas_Receber().getId()));
                    for (FinanceiroParcelas pr : vendaCabecalho.getContas_Receber().getListaParcelasReceber()) {
                        if (pr.getStatus().equals("PG")) {
                            if (JOptionPane.showConfirmDialog(null, "Deseja imprimir um recibo da parcela " + pr.getParcela() + "?", "PERGUNTA DO SISTEMA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                                new RelatorioContasReceber().reciboContasReceber(pr, vendaCabecalho.getContas_Receber());
                            }
                        }
                    }
                }
            } else {
                try {
                    imprimirCupom(vendaCabecalho);
                } catch (IOException ex) {
                    Logger.getLogger(VendaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
        }
    }

    private void eventosPesquisar() {
        jTF_pesquisar.setSearchMode(JXSearchField.SearchMode.REGULAR);
        jTF_pesquisar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pesquisarVenda();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN && jT_vendaCabecalho.getRowCount() > 0) {
                    jT_vendaCabecalho.addRowSelectionInterval(0, 0);
                    jT_vendaCabecalho.requestFocus();
                }
            }
        });

        jXDP_data_filtro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarVenda();
            }
        });
    }

    private void configuraJtable() {
        configuraTableModel();
        if (!Dir.KEY_TIPO_SISTEMA.equals("G")) {
            jT_itens_venda.getColumnModel().getColumn(6).setMinWidth(0);
            jT_itens_venda.getColumnModel().getColumn(6).setMaxWidth(0);
            jT_itens_venda.getColumnModel().getColumn(6).setPreferredWidth(0);
            jT_itens_venda.getColumnModel().getColumn(7).setMinWidth(0);
            jT_itens_venda.getColumnModel().getColumn(7).setMaxWidth(0);
            jT_itens_venda.getColumnModel().getColumn(7).setPreferredWidth(0);
            jT_itens_venda.getColumnModel().getColumn(8).setMinWidth(0);
            jT_itens_venda.getColumnModel().getColumn(8).setMaxWidth(0);
            jT_itens_venda.getColumnModel().getColumn(8).setPreferredWidth(0);
        }
    }

    private boolean verificaItemJaIncluso() {
        boolean retorno = true;
        BigDecimal qtdTabela = BigDecimal.ZERO, qtdInserida = ClasseUtilitaria.parseToBig(jTF_qntd.getText());
        if (p != null) {
            int row = 0;
            for (int i = 0; i < jT_itens_venda.getRowCount(); i++) {
                int idProduto = (Integer) jT_itens_venda.getModel().getValueAt(i, 0);
                if (idProduto == p.getId()) {
                    retorno = false;
                    row = i;
                    qtdTabela = ClasseUtilitaria.parseToBig((String) jT_itens_venda.getModel().getValueAt(i, 3));
                    break;
                }
            }
            if (!retorno) {
                Object[] opcao = {"Editar", "Inserir Novo"};
                int c = JOptionPane.showOptionDialog(
                        this, "Produto já inserido, escolha a opção!", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, opcao, opcao[0]);
                if (c == 0) {
                    BigDecimal qtdTotal = qtdTabela.add(qtdInserida);
                    jT_itens_venda.addRowSelectionInterval(row, row);
                    editaItemDaVenda();
                    jTF_qntd.setText(ClasseUtilitaria.fmtBig(qtdTotal, 3));
                } else {
                    retorno = true;
                }
            }
        }
        return retorno;
    }

    private class TeclouBarraAction extends AbstractAction {

        public TeclouBarraAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            teclouBarra();
        }
    }

    private void teclouBarra() {
        if (this.getFocusOwner() == jT_itens_venda) {
            AbstractTableModel modeloCabecalho = (AbstractTableModel) jT_itens_venda.getModel();
            int viewRow = jT_itens_venda.getSelectedRow();
            int modelRow = jT_itens_venda.convertRowIndexToModel(viewRow);
            Object selecionado = modeloCabecalho.getValueAt(modelRow, 9);
            if (selecionado != null) {
                if (selecionado.toString().equals("")) {
                    modeloCabecalho.setValueAt("X", modelRow, 9);
                } else {
                    modeloCabecalho.setValueAt("", modelRow, 9);
                }
            } else {
                modeloCabecalho.setValueAt("X", modelRow, 9);
            }
        }
    }

    private void replaceVirgulaPorPonto(JTextField jTextField) {
        jTextField.setText(jTextField.getText().replace(",", "."));
    }

    public final void imprimirCupom(VendaCabecalho vendaCabecalho) throws FileNotFoundException, IOException {
        try {
            GUI.CupomNaoFiscal.cupomCompleto(vendaCabecalho);
//            GUI.CupomNaoFiscal.abreCupom(vendaCabecalho);
//            vendeItem(vendaCabecalho.getListaDetalhe());
//            if (imprimirVasilhamePendente) {
//                GUI.CupomNaoFiscal.vasilhamesPendentes(vendaCabecalho);
//            }
//            GUI.CupomNaoFiscal.fechaCupom(vendaCabecalho, "VOLTE SEMPRE!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao imprimir cupom: Verifique a comunicação com a impressora!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public final void vendeItem(ArrayList<VendaDetalhe> vendaDetalhes) throws FileNotFoundException, InterruptedException {
        for (VendaDetalhe dd : vendaDetalhes) {
            if (dd.isVasilhame_pendente()) {
                imprimirVasilhamePendente = true;
            }
            GUI.CupomNaoFiscal.vendeItem(dd.getProduto().getCodigo(), dd.getProduto().getDescricao(), ClasseUtilitaria.fmtBig(dd.getQuantidade(), 3), ClasseUtilitaria.fmtBig(dd.getValor_unitario(), 2), ClasseUtilitaria.fmtBig(dd.getValor_total(), 2));
            Thread.sleep(200);
        }
    }

    private void configuraTableModel() {
        //Vendas
        jT_vendaCabecalho.setModel(new TableModelVenda(jT_vendaCabecalho));
        jT_vendaCabecalho.setSelectionModel(new DefaultListSelectionModel() {

            @Override
            public String toString() {
                return "jT_vendaCabecalho";
            }
        });

        jT_vendaCabecalho.setAutoCreateColumnsFromModel(false);
        jT_vendaCabecalho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        FontMetrics fm = jT_vendaCabecalho.getFontMetrics(jT_vendaCabecalho.getFont());
        jT_vendaCabecalho.setColumnModel(new VendaColumnModel(fm));
        jT_vendaCabecalho.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        model = (TableModelVenda) jT_vendaCabecalho.getModel();

        //Itens
        jT_itens_venda.setModel(new TableModelVendaItens(jT_itens_venda));
        jT_itens_venda.setSelectionModel(new DefaultListSelectionModel() {

            @Override
            public String toString() {
                return "jT_itens_venda";
            }
        });

        jT_itens_venda.setAutoCreateColumnsFromModel(false);
        jT_itens_venda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        FontMetrics fm1 = jT_itens_venda.getFontMetrics(jT_itens_venda.getFont());
        jT_itens_venda.setColumnModel(new VendaItensColumnModel(fm1));
        jT_itens_venda.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        modelItens = (TableModelVendaItens) jT_itens_venda.getModel();
    }
}
