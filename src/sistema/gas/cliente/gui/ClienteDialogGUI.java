/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.cliente.gui;

import GUI.DetalharVendaDialog;
import GUI.MunicipiosDialog;
import sistema.gas.municipio.dados.ConectaBDMunicipio;
import Negocios.*;
import Utilitarios.Dir;
import Utilitarios.JTableModel;
import Utilitarios.WebServiceBuscaCEPG3;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.jdesktop.swingx.JXSearchField;
import static sistema.gas.SISTEMA_GAS._FuncionarioLogado;
import sistema.gas.cliente.dados.ConectaBDCliente;
import sistema.gas.cliente.dados.ConectaBDClienteVasilhame;
import sistema.gas.cliente.dados.ConectaBDClienteVasilhameDetalhe;

/**
 *
 * @author Administrador
 */
public class ClienteDialogGUI extends javax.swing.JDialog {

    /**
     * Creates new form ClienteDialogGUI
     */
    private Cliente cliente;
    private final String dia = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    private final SimpleDateFormat fmtDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final SimpleDateFormat fmtData = new SimpleDateFormat("dd/MM/yyyy");
    private boolean ok;
    private final boolean consultar;

    public ClienteDialogGUI(java.awt.Frame parent, boolean modal, boolean consultar) {
        super(parent, modal);
        initComponents();
        pessoaFisica(false);
        this.consultar = consultar;

        jTF_cep.setFormatterFactory(formato("#####-###"));
        jTF_cep.setFocusLostBehavior(JFormattedTextField.COMMIT);

        jTF_data_nasc.setFormatterFactory(formato("##/##/####"));
        jTF_data_nasc.setFocusLostBehavior(JFormattedTextField.COMMIT);

        jTF_telefone.setFormatterFactory(formato("(##)####-####"));
        jTF_telefone.setFocusLostBehavior(JFormattedTextField.COMMIT);

        jTF_celular.setFormatterFactory(formato("(##)####-####"));
        jTF_celular.setFocusLostBehavior(JFormattedTextField.COMMIT);

        travaCamposCliente(false);
        jcbFiltros.setSelectedIndex(0);
        jTF_observacao.setLineWrap(true);
        jTF_observacao.setWrapStyleWord(true);

        botoes(false, false, false, false);

        HashSet conj = new HashSet(jP_cadastrar.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        jP_cadastrar.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        jTF_dia.setText(dia);

        listarClientes();
        jTF_codigo.setBackground(null);

        jTF_textoBusca.setSearchMode(JXSearchField.SearchMode.REGULAR);
        jTF_textoBusca.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    consultarCliente();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jT_clientes.addRowSelectionInterval(0, 0);
                    jT_clientes.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                consultarCliente();
            }
        });

        jTF_textoBusca.setFindAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                consultarCliente();
            }
        });

        jT_clienteVasilhame.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    int col = jT_clienteVasilhame.columnAtPoint(e.getPoint());
                    int row = jT_clienteVasilhame.rowAtPoint(e.getPoint());
                    if (col != -1 && row != -1) {
                        jT_clienteVasilhame.setColumnSelectionInterval(col, col);
                        jT_clienteVasilhame.setRowSelectionInterval(row, row);
                    }
                }
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                if (isLeftButton(evt)) {
                    if (evt.getClickCount() == 2) {
                    }
                } else if (isMiddleButton(evt)) {
                } else if (isRightButton(evt)) {
                    final JPopupMenu menu = new JPopupMenu();
                    JMenuItem baixa = new JMenuItem("Dar baixa", new ImageIcon(getClass().getResource("/imagens/ok.png")));
                    JMenuItem abrirDetalhe = new JMenuItem("Detalhar", new ImageIcon(getClass().getResource("/imagens/wand.png")));
                    JMenuItem fechar = new JMenuItem("Fechar", new ImageIcon(getClass().getResource("/imagens/cross.png")));

                    baixa.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            try {
                                int idClienteVasilhame = (Integer) jT_clienteVasilhame.getModel().getValueAt(jT_clienteVasilhame.getSelectedRow(), 0);
                                ArrayList<ClienteVasilhame> listaClienteVasilhame = ConectaBDClienteVasilhame.getInstance().consultarClienteVasilhame("select * from cliente_vasilhame where id = " + idClienteVasilhame);
                                BaixaVasilhameClienteDialog dialog = new BaixaVasilhameClienteDialog(null, true, listaClienteVasilhame.get(0));
                                dialog.setLocationRelativeTo(null);
                                dialog.setVisible(true);
                            } catch (SQLException ex) {
                                Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                    abrirDetalhe.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            AbrirVendaDetalhada();
                        }

                        private void AbrirVendaDetalhada() {
                            try {
                                int idClienteVasilhame = (Integer) jT_clienteVasilhame.getModel().getValueAt(jT_clienteVasilhame.getSelectedRow(), 0);
                                ArrayList<ClienteVasilhame> listaClienteVasilhame = ConectaBDClienteVasilhame.getInstance().consultarClienteVasilhame("select * from cliente_vasilhame where id = " + idClienteVasilhame);
                                if (!listaClienteVasilhame.isEmpty()) {
                                    VendaDetalhe vendaDetalhe = Fachada.getInstancia().consultarVendaDetalhe_porIdVendaDetalhe(listaClienteVasilhame.get(0).getId_venda_detalhe());
                                    if (vendaDetalhe != null) {
                                        ArrayList<VendaCabecalho> listaVendaCabecalhos = Fachada.getInstancia().consultarVendaCabecalho("select * from venda_cabecalho where id = " + vendaDetalhe.getId_venda_cabecalho());
                                        if (!listaVendaCabecalhos.isEmpty()) {
                                            DetalharVendaDialog detalharVendaDialog = new DetalharVendaDialog(null, true, listaVendaCabecalhos.get(0));
                                            detalharVendaDialog.setLocationRelativeTo(null);
                                            detalharVendaDialog.setVisible(true);
                                        } else {
                                            JOptionPane.showMessageDialog(rootPane, "Venda não encontrada!");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Itens não encontrados!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Vasilhames pendentes não encontrados!");
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                    fechar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            menu.setVisible(false);
                        }
                    });

                    menu.add(baixa);
                    menu.add(abrirDetalhe);
                    menu.add(fechar);
                    menu.show(jT_clienteVasilhame, evt.getX(), evt.getY());
                }
            }

            private boolean isLeftButton(MouseEvent event) {
                return event.getButton() == MouseEvent.BUTTON1;
            }

            private boolean isMiddleButton(MouseEvent event) {
                return event.getButton() == MouseEvent.BUTTON2;
            }

            private boolean isRightButton(MouseEvent event) {
                return event.getButton() == MouseEvent.BUTTON3;
            }
        });

        if (Dir.KEY_TIPO_SISTEMA.equals("G")) {
            jTP_dados_cliente.add("Vasilhames", jP_vasilhames);
        } else {
            jTP_dados_cliente.remove(jP_vasilhames);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_filtroSelecao = new javax.swing.ButtonGroup();
        buttonGroup_tipo_pessoa = new javax.swing.ButtonGroup();
        jTP_cliente = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jB_novo = new javax.swing.JButton();
        jB_selecao = new javax.swing.JButton();
        jB_fechar = new javax.swing.JButton();
        jCB_filtroDesativados = new javax.swing.JCheckBox();
        jCB_filtroAtivInativGeral = new javax.swing.JCheckBox();
        jCB_filtroAtivados = new javax.swing.JCheckBox();
        jTF_textoBusca = new org.jdesktop.swingx.JXSearchField();
        jcbFiltros = new javax.swing.JComboBox<>();
        jP_cadastrar = new javax.swing.JPanel();
        jTP_dados_cliente = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTF_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTF_dia = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jTF_RazaoSocialOuNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTF_fantasiaOuApelido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTF_endereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTF_numero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTF_complemento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTF_bairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTF_cep = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jTF_codigo_municipio = new javax.swing.JTextField();
        jB_buscar_municipio = new javax.swing.JButton();
        jTF_municipio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTF_uf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTF_data_nasc = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jTF_telefone = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jTF_celular = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jTF_email = new javax.swing.JTextField();
        jB_buscaCepON = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTF_qtd_dias = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jP_documentos = new javax.swing.JPanel();
        jCB_fisica = new javax.swing.JCheckBox();
        jCB_juridica = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTF_cpf = new javax.swing.JFormattedTextField();
        jTF_rg = new javax.swing.JFormattedTextField();
        jTF_cnpj = new javax.swing.JFormattedTextField();
        jTF_ie = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        jTF_im = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        jTF_orgao_rg = new javax.swing.JFormattedTextField();
        jB_buscaCnpjON = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTF_observacao = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jT_historico_vendas_dav = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jL_total_compras = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jT_historico_contas_pendentes = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jL_total_contas = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jT_historico_pagamentos = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jL_total_pagamentos = new javax.swing.JLabel();
        jP_vasilhames = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jT_clienteVasilhame = new javax.swing.JTable();
        jB_salvar = new javax.swing.JButton();
        jB_editar = new javax.swing.JButton();
        jB_excluir = new javax.swing.JButton();
        jB_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro Clientes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTP_cliente.setEnabled(false);
        jTP_cliente.setFocusable(false);

        jPanel1.setFocusable(false);

        jT_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Fantasia", "Documento", "Municipio", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_clientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jT_clientes.getTableHeader().setReorderingAllowed(false);
        jT_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_clientesMouseClicked(evt);
            }
        });
        jT_clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_clientesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jT_clientes);
        if (jT_clientes.getColumnModel().getColumnCount() > 0) {
            jT_clientes.getColumnModel().getColumn(0).setPreferredWidth(70);
            jT_clientes.getColumnModel().getColumn(1).setPreferredWidth(250);
            jT_clientes.getColumnModel().getColumn(2).setPreferredWidth(250);
            jT_clientes.getColumnModel().getColumn(3).setPreferredWidth(120);
            jT_clientes.getColumnModel().getColumn(4).setPreferredWidth(150);
            jT_clientes.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jB_novo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adiciona.png"))); // NOI18N
        jB_novo.setText("Novo");
        jB_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_novoActionPerformed(evt);
            }
        });

        jB_selecao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_selecao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jB_selecao.setText("Seleção");
        jB_selecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_selecaoActionPerformed(evt);
            }
        });

        jB_fechar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit1.png"))); // NOI18N
        jB_fechar.setText("Fechar");
        jB_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_fecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jB_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jB_selecao)
                .addGap(0, 0, 0)
                .addComponent(jB_fechar)
                .addGap(204, 204, 204))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_fechar, jB_novo, jB_selecao});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jB_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jB_selecao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_fechar, jB_novo, jB_selecao});

        buttonGroup_filtroSelecao.add(jCB_filtroDesativados);
        jCB_filtroDesativados.setText("Desativados");
        jCB_filtroDesativados.setFocusable(false);
        jCB_filtroDesativados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jCB_filtroDesativados.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jCB_filtroDesativados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_filtroDesativadosActionPerformed(evt);
            }
        });

        buttonGroup_filtroSelecao.add(jCB_filtroAtivInativGeral);
        jCB_filtroAtivInativGeral.setText("Geral");
        jCB_filtroAtivInativGeral.setFocusable(false);
        jCB_filtroAtivInativGeral.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jCB_filtroAtivInativGeral.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jCB_filtroAtivInativGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_filtroAtivInativGeralActionPerformed(evt);
            }
        });

        buttonGroup_filtroSelecao.add(jCB_filtroAtivados);
        jCB_filtroAtivados.setSelected(true);
        jCB_filtroAtivados.setText("Ativos");
        jCB_filtroAtivados.setFocusable(false);
        jCB_filtroAtivados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jCB_filtroAtivados.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jCB_filtroAtivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_filtroAtivadosActionPerformed(evt);
            }
        });

        jTF_textoBusca.setPrompt("Buscar");

        jcbFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome", "Município", "Fantasia", "CPF", "RG" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jcbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_textoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCB_filtroAtivados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCB_filtroDesativados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCB_filtroAtivInativGeral))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCB_filtroDesativados)
                    .addComponent(jCB_filtroAtivInativGeral)
                    .addComponent(jCB_filtroAtivados)
                    .addComponent(jTF_textoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTP_cliente.addTab("Consultar", jPanel1);

        jP_cadastrar.setFocusable(false);

        jTP_dados_cliente.setFocusable(false);

        jPanel2.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Código:");

        jTF_codigo.setEditable(false);
        jTF_codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTF_codigo.setForeground(new java.awt.Color(0, 0, 255));
        jTF_codigo.setBorder(null);
        jTF_codigo.setFocusable(false);

        jLabel2.setText("Data:");

        jTF_dia.setEditable(false);
        try {
            jTF_dia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_dia.setFocusable(false);
        jTF_dia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
        });

        jLabel3.setText("Nome:");

        jTF_RazaoSocialOuNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_RazaoSocialOuNomeKeyTyped(evt);
            }
        });

        jLabel4.setText("Fantasia:");

        jTF_fantasiaOuApelido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_fantasiaOuApelidoKeyTyped(evt);
            }
        });

        jLabel5.setText("Endereço:");

        jTF_endereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_enderecoKeyTyped(evt);
            }
        });

        jLabel6.setText("-");

        jTF_numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_numeroFocusLost(evt);
            }
        });
        jTF_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_numeroKeyTyped(evt);
            }
        });

        jLabel7.setText("Complemento:");

        jTF_complemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_complementoKeyTyped(evt);
            }
        });

        jLabel8.setText("Bairro:");

        jTF_bairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_bairroKeyTyped(evt);
            }
        });

        jLabel9.setText("Cep:");

        try {
            jTF_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_cep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_cepFocusGained(evt);
            }
        });
        jTF_cep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_cepKeyTyped(evt);
            }
        });

        jLabel10.setText("Município:");

        jTF_codigo_municipio.setEditable(false);
        jTF_codigo_municipio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_codigo_municipioFocusGained(evt);
            }
        });
        jTF_codigo_municipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
        });

        jB_buscar_municipio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Add.png"))); // NOI18N
        jB_buscar_municipio.setBorderPainted(false);
        jB_buscar_municipio.setContentAreaFilled(false);
        jB_buscar_municipio.setFocusable(false);
        jB_buscar_municipio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_buscar_municipioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jB_buscar_municipioMouseExited(evt);
            }
        });
        jB_buscar_municipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_buscar_municipioActionPerformed(evt);
            }
        });

        jTF_municipio.setEditable(false);

        jLabel11.setText("UF:");

        jTF_uf.setEditable(false);

        jLabel12.setText("Data Nasc.:");

        try {
            jTF_data_nasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_data_nasc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
        });

        jLabel14.setText("Telefone:");

        try {
            jTF_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
        });

        jLabel15.setText("Celular:");

        try {
            jTF_celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
        });

        jLabel16.setText("Email:");

        jTF_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
        });

        jB_buscaCepON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/btn-busca-mini.png"))); // NOI18N
        jB_buscaCepON.setContentAreaFilled(false);
        jB_buscaCepON.setFocusable(false);
        jB_buscaCepON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_buscaCepONActionPerformed(evt);
            }
        });

        jLabel13.setText("Quantidade dias visita:");

        jTF_qtd_dias.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_qtd_dias.setText("0");
        jTF_qtd_dias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_qtd_diasFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel10))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTF_complemento, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jTF_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTF_numero))
                        .addComponent(jTF_fantasiaOuApelido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jTF_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTF_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTF_RazaoSocialOuNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jTF_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTF_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jB_buscaCepON, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jTF_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTF_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTF_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTF_uf)
                                .addComponent(jTF_codigo_municipio, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jB_buscar_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTF_municipio))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addGap(182, 182, 182)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTF_data_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jTF_qtd_dias, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTF_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTF_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTF_RazaoSocialOuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTF_fantasiaOuApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTF_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTF_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTF_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_buscaCepON, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTF_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jTF_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jTF_codigo_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTF_municipio)
                    .addComponent(jB_buscar_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_data_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTF_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTF_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTF_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTF_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTF_qtd_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 52, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_buscaCepON, jTF_cep});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_buscar_municipio, jTF_codigo_municipio});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTP_dados_cliente.addTab("Dados Gerais", jPanel2);

        jPanel3.setFocusable(false);

        jP_documentos.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento"));
        jP_documentos.setFocusable(false);

        buttonGroup_tipo_pessoa.add(jCB_fisica);
        jCB_fisica.setText("Pessoa Física");
        jCB_fisica.setFocusable(false);
        jCB_fisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_fisicaActionPerformed(evt);
            }
        });

        buttonGroup_tipo_pessoa.add(jCB_juridica);
        jCB_juridica.setSelected(true);
        jCB_juridica.setText("Jurídica");
        jCB_juridica.setFocusable(false);
        jCB_juridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_juridicaActionPerformed(evt);
            }
        });

        jLabel17.setText("CPF:");

        jLabel18.setText("RG:");

        jLabel19.setText("CNPJ:");

        jLabel20.setText("IE:");

        jTF_cpf.setEditable(false);
        jTF_cpf.setBackground(new java.awt.Color(255, 255, 255));
        try {
            jTF_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***.***.***-**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_cpf.setName("cpf"); // NOI18N
        jTF_cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_cpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_cpfFocusLost(evt);
            }
        });
        jTF_cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_cpfKeyTyped(evt);
            }
        });

        jTF_rg.setEditable(false);
        jTF_rg.setBackground(new java.awt.Color(255, 255, 255));
        jTF_rg.setName("rg"); // NOI18N
        jTF_rg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_rgFocusLost(evt);
            }
        });
        jTF_rg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_rgKeyTyped(evt);
            }
        });

        jTF_cnpj.setEditable(false);
        jTF_cnpj.setBackground(new java.awt.Color(255, 255, 255));
        try {
            jTF_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**.***.***/****-**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_cnpj.setName("cnpj"); // NOI18N
        jTF_cnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_cnpjFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_cnpjFocusLost(evt);
            }
        });
        jTF_cnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_cnpjKeyTyped(evt);
            }
        });

        jTF_ie.setEditable(false);
        jTF_ie.setBackground(new java.awt.Color(255, 255, 255));
        jTF_ie.setToolTipText("Inscrição Estadual");
        jTF_ie.setName("ie"); // NOI18N
        jTF_ie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_ieFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_ieFocusLost(evt);
            }
        });
        jTF_ie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_ieKeyTyped(evt);
            }
        });

        jLabel23.setText("IM:");

        jTF_im.setEditable(false);
        jTF_im.setBackground(new java.awt.Color(255, 255, 255));
        jTF_im.setToolTipText("Inscrição Municipal");
        jTF_im.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_imKeyTyped(evt);
            }
        });

        jLabel24.setText("Orgão:");

        jTF_orgao_rg.setEditable(false);
        jTF_orgao_rg.setBackground(new java.awt.Color(255, 255, 255));
        jTF_orgao_rg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                transfereFocusEnter(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTF_orgao_rgKeyTyped(evt);
            }
        });

        jB_buscaCnpjON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/btn-busca-mini.png"))); // NOI18N
        jB_buscaCnpjON.setContentAreaFilled(false);
        jB_buscaCnpjON.setFocusable(false);
        jB_buscaCnpjON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_buscaCnpjONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_documentosLayout = new javax.swing.GroupLayout(jP_documentos);
        jP_documentos.setLayout(jP_documentosLayout);
        jP_documentosLayout.setHorizontalGroup(
            jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_documentosLayout.createSequentialGroup()
                .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_documentosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_cpf)
                            .addComponent(jTF_rg, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTF_orgao_rg, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_documentosLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jCB_fisica, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTF_im, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jP_documentosLayout.createSequentialGroup()
                        .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_cnpj)
                            .addComponent(jTF_ie, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jCB_juridica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB_buscaCnpjON, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jP_documentosLayout.setVerticalGroup(
            jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_documentosLayout.createSequentialGroup()
                .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCB_fisica)
                    .addComponent(jCB_juridica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jTF_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_buscaCnpjON, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jTF_rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_ie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jTF_im, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_documentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jTF_orgao_rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_documentosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_buscaCnpjON, jTF_cnpj});

        jTF_observacao.setColumns(20);
        jTF_observacao.setRows(5);
        jScrollPane2.setViewportView(jTF_observacao);

        jLabel21.setText("Obs.:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_documentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jP_documentos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTP_dados_cliente.addTab("Documento", jPanel3);

        jPanel4.setFocusable(false);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras"));
        jPanel8.setFocusable(false);

        jT_historico_vendas_dav.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Tipo Pagamento", "SubTotal", "Desconto", "Acréscimo", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_historico_vendas_dav.setToolTipText("Para visualizar o detalhe da compra, utilize dois cliks na linha!");
        jT_historico_vendas_dav.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jT_historico_vendas_dav.setFocusable(false);
        jT_historico_vendas_dav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_historico_vendas_davMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jT_historico_vendas_dav);
        if (jT_historico_vendas_dav.getColumnModel().getColumnCount() > 0) {
            jT_historico_vendas_dav.getColumnModel().getColumn(0).setResizable(false);
            jT_historico_vendas_dav.getColumnModel().getColumn(0).setPreferredWidth(60);
            jT_historico_vendas_dav.getColumnModel().getColumn(1).setResizable(false);
            jT_historico_vendas_dav.getColumnModel().getColumn(1).setPreferredWidth(120);
            jT_historico_vendas_dav.getColumnModel().getColumn(2).setResizable(false);
            jT_historico_vendas_dav.getColumnModel().getColumn(2).setPreferredWidth(200);
            jT_historico_vendas_dav.getColumnModel().getColumn(3).setResizable(false);
            jT_historico_vendas_dav.getColumnModel().getColumn(3).setPreferredWidth(80);
            jT_historico_vendas_dav.getColumnModel().getColumn(4).setResizable(false);
            jT_historico_vendas_dav.getColumnModel().getColumn(4).setPreferredWidth(80);
            jT_historico_vendas_dav.getColumnModel().getColumn(5).setResizable(false);
            jT_historico_vendas_dav.getColumnModel().getColumn(5).setPreferredWidth(80);
            jT_historico_vendas_dav.getColumnModel().getColumn(6).setResizable(false);
            jT_historico_vendas_dav.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        jLabel26.setText("Total:");

        jL_total_compras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jL_total_compras.setText("0.00");
        jL_total_compras.setFocusable(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel27.setText("Para visualizar o detalhe da compra, entre com dois cliks na linha desejada");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jL_total_compras, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jL_total_compras)
                    .addComponent(jLabel27)))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Contas Pendentes"));
        jPanel9.setFocusable(false);

        jT_historico_contas_pendentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data Venc", "Valor Total", "Valor Pago", "Restante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_historico_contas_pendentes.setFocusable(false);
        jScrollPane4.setViewportView(jT_historico_contas_pendentes);
        if (jT_historico_contas_pendentes.getColumnModel().getColumnCount() > 0) {
            jT_historico_contas_pendentes.getColumnModel().getColumn(0).setResizable(false);
            jT_historico_contas_pendentes.getColumnModel().getColumn(1).setResizable(false);
            jT_historico_contas_pendentes.getColumnModel().getColumn(2).setResizable(false);
            jT_historico_contas_pendentes.getColumnModel().getColumn(3).setResizable(false);
            jT_historico_contas_pendentes.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel25.setText("Total:");

        jL_total_contas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jL_total_contas.setText("0.00");
        jL_total_contas.setFocusable(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jL_total_contas, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jL_total_contas)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTP_dados_cliente.addTab("Histórico", jPanel4);

        jPanel10.setFocusable(false);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Histórico de Pagamentos"));
        jPanel11.setFocusable(false);

        jT_historico_pagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data Venc", "Data Pg", "Hora Rec", "Valor", "Valor Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_historico_pagamentos.setToolTipText("Para visualizar o detalhe da compra, utilize dois cliks na linha!");
        jT_historico_pagamentos.setFocusable(false);
        jT_historico_pagamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_historico_pagamentosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jT_historico_pagamentos);
        if (jT_historico_pagamentos.getColumnModel().getColumnCount() > 0) {
            jT_historico_pagamentos.getColumnModel().getColumn(0).setResizable(false);
            jT_historico_pagamentos.getColumnModel().getColumn(1).setResizable(false);
            jT_historico_pagamentos.getColumnModel().getColumn(2).setResizable(false);
            jT_historico_pagamentos.getColumnModel().getColumn(3).setResizable(false);
            jT_historico_pagamentos.getColumnModel().getColumn(4).setResizable(false);
            jT_historico_pagamentos.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel28.setText("Total Pagamentos:");

        jL_total_pagamentos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jL_total_pagamentos.setText("0.00");
        jL_total_pagamentos.setFocusable(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 486, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jL_total_pagamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jL_total_pagamentos))
                .addContainerGap())
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTP_dados_cliente.addTab("Pagamentos", jPanel10);

        jT_clienteVasilhame.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Data", "Qtd. Pendente", "Qtd. Devolvida", "Restante", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_clienteVasilhame.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jT_clienteVasilhame);
        if (jT_clienteVasilhame.getColumnModel().getColumnCount() > 0) {
            jT_clienteVasilhame.getColumnModel().getColumn(0).setMinWidth(0);
            jT_clienteVasilhame.getColumnModel().getColumn(0).setPreferredWidth(0);
            jT_clienteVasilhame.getColumnModel().getColumn(0).setMaxWidth(0);
            jT_clienteVasilhame.getColumnModel().getColumn(1).setPreferredWidth(70);
            jT_clienteVasilhame.getColumnModel().getColumn(2).setPreferredWidth(80);
            jT_clienteVasilhame.getColumnModel().getColumn(3).setPreferredWidth(90);
            jT_clienteVasilhame.getColumnModel().getColumn(4).setPreferredWidth(80);
            jT_clienteVasilhame.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        javax.swing.GroupLayout jP_vasilhamesLayout = new javax.swing.GroupLayout(jP_vasilhames);
        jP_vasilhames.setLayout(jP_vasilhamesLayout);
        jP_vasilhamesLayout.setHorizontalGroup(
            jP_vasilhamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_vasilhamesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                .addContainerGap())
        );
        jP_vasilhamesLayout.setVerticalGroup(
            jP_vasilhamesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_vasilhamesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTP_dados_cliente.addTab("Vasilhames", jP_vasilhames);

        jB_salvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jB_salvar.setText("Salvar");
        jB_salvar.setFocusable(false);
        jB_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvarActionPerformed(evt);
            }
        });

        jB_editar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/wand.png"))); // NOI18N
        jB_editar.setText("Editar");
        jB_editar.setFocusable(false);
        jB_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_editarActionPerformed(evt);
            }
        });

        jB_excluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/wand.png"))); // NOI18N
        jB_excluir.setText("Excluir");
        jB_excluir.setFocusable(false);
        jB_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_excluirActionPerformed(evt);
            }
        });

        jB_voltar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jB_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_voltar.setText("Voltar");
        jB_voltar.setFocusable(false);
        jB_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_cadastrarLayout = new javax.swing.GroupLayout(jP_cadastrar);
        jP_cadastrar.setLayout(jP_cadastrarLayout);
        jP_cadastrarLayout.setHorizontalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTP_dados_cliente)
                .addGap(5, 5, 5))
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jB_salvar)
                .addGap(0, 0, 0)
                .addComponent(jB_editar)
                .addGap(0, 0, 0)
                .addComponent(jB_excluir)
                .addGap(0, 0, 0)
                .addComponent(jB_voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_cadastrarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_editar, jB_excluir, jB_salvar, jB_voltar});

        jP_cadastrarLayout.setVerticalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jTP_dados_cliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_salvar)
                    .addComponent(jB_editar)
                    .addComponent(jB_voltar)
                    .addComponent(jB_excluir))
                .addGap(5, 5, 5))
        );

        jP_cadastrarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_editar, jB_excluir, jB_salvar, jB_voltar});

        jTP_cliente.addTab("Cadastrar", jP_cadastrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_cliente)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_cliente)
        );

        setSize(new java.awt.Dimension(761, 502));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jT_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_clientesMouseClicked
        if (evt.getClickCount() == 2) {
            clienteSelecionado();
            jB_editar.setEnabled(true);
        }
    }//GEN-LAST:event_jT_clientesMouseClicked

    private void jB_buscar_municipioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_buscar_municipioMouseEntered
        jB_buscar_municipio.setContentAreaFilled(true);
    }//GEN-LAST:event_jB_buscar_municipioMouseEntered

    private void jB_buscar_municipioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_buscar_municipioMouseExited
        jB_buscar_municipio.setContentAreaFilled(false);
    }//GEN-LAST:event_jB_buscar_municipioMouseExited

    private void jB_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_novoActionPerformed
        try {
            cliente = null;
            jTP_cliente.setSelectedIndex(1);
            jTP_dados_cliente.setSelectedIndex(0);
            travaCamposCliente(true);
            botoes(true, false, false, true);
            limpar();
            limparTabelasHistorico();
        } catch (Exception ex) {
            Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_novoActionPerformed

    private void jB_selecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_selecaoActionPerformed
        clienteSelecionado();
    }//GEN-LAST:event_jB_selecaoActionPerformed

    private void jB_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_fecharActionPerformed
        cliente = null;
        dispose();
    }//GEN-LAST:event_jB_fecharActionPerformed

    private void jB_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarActionPerformed
        try {
            if (campoObrigatorioVazio()) {
                //MOSTRA MSG
            } else {
                Cliente c = new Cliente();
                c.setNome(jTF_RazaoSocialOuNome.getText().toUpperCase().trim());
                c.setApelido(jTF_fantasiaOuApelido.getText().toUpperCase().trim());
                c.setEndereco(jTF_endereco.getText().toUpperCase().trim());
                c.setNum_end(jTF_numero.getText());
                c.setBairro(jTF_bairro.getText().toUpperCase().trim());
                c.setCod_municipio(jTF_codigo_municipio.getText());
                c.setMunicipio(jTF_municipio.getText().toUpperCase().trim());
                c.setCep(jTF_cep.getText().replaceAll("[^0-9]", ""));
                c.setUf(jTF_uf.getText());
                c.setCelular(jTF_celular.getText().replaceAll("[^0-9]", ""));
                c.setData_nasc(jTF_data_nasc.getText().replaceAll("[^0-9]", "").isEmpty() ? null : new SimpleDateFormat("dd/MM/yyyy").parse(jTF_data_nasc.getText()));
                c.setObs(jTF_observacao.getText());
                c.setData_cadastro(new Date());
                c.setId_usuario_insercao(_FuncionarioLogado.getId());
                c.setTelefone(jTF_telefone.getText().replaceAll("[^0-9]", ""));
                c.setComp_end(jTF_complemento.getText().toUpperCase().trim());
                c.setEmail(jTF_email.getText());
                c.setOrgao_rg(jTF_orgao_rg.getText());
                if (jCB_fisica.isSelected()) {
                    c.setCpf(jTF_cpf.getText().replaceAll("[^0-9]", ""));
                    c.setRg(jTF_rg.getText().replaceAll("[^0-9]", ""));
                    c.setTipo_pessoa("F");
                    c.setIe("ISENTO");
                } else if (jCB_juridica.isSelected()) {
                    c.setCnpj(jTF_cnpj.getText().replaceAll("[^0-9]", ""));
                    c.setIe(jTF_ie.getText().replaceAll("[^0-9]", ""));
                    c.setTipo_pessoa("J");
                }
                c.setExcluido(false);
                c.setQuantidade_dias_visita(Integer.valueOf(jTF_qtd_dias.getText()));

                try {
                    ConectaBDCliente.getInstance().incluirCliente(c);
                    cliente = c;
                    if (consultar) {
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Salvo com sucesso!",
                                "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                        limpar();
                        listarClientes();
                        jTP_cliente.setSelectedIndex(0);
                    }
                } catch (HeadlessException ex) {
                    Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL SALVAR O CLIENTE!",
                            "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                } catch (Exception ex) {
                    Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, "Mensagem", e);
            JOptionPane.showMessageDialog(rootPane, "Mensagem" + "\n" + e + "\n" + e.getMessage());
        }
    }//GEN-LAST:event_jB_salvarActionPerformed

    private void jB_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_editarActionPerformed
        try {
            cliente.setNome(jTF_RazaoSocialOuNome.getText().toUpperCase().trim());
            cliente.setApelido(jTF_fantasiaOuApelido.getText().toUpperCase().trim());
            cliente.setEndereco(jTF_endereco.getText().toUpperCase().trim());
            cliente.setNum_end(jTF_numero.getText());
            cliente.setBairro(jTF_bairro.getText().toUpperCase().trim());
            cliente.setCod_municipio(jTF_codigo_municipio.getText());
            cliente.setMunicipio(jTF_municipio.getText().toUpperCase().trim());
            cliente.setUf(jTF_uf.getText());
            cliente.setCep(jTF_cep.getText().replaceAll("[^0-9]", ""));
            cliente.setCelular(jTF_celular.getText().replaceAll("[^0-9]", ""));
            cliente.setData_nasc(jTF_data_nasc.getText().replaceAll("[^0-9]", "").isEmpty() ? null : new SimpleDateFormat("dd/MM/yyyy").parse(jTF_data_nasc.getText()));
            cliente.setTelefone(jTF_telefone.getText().replaceAll("[^0-9]", ""));
            cliente.setComp_end(jTF_complemento.getText().toUpperCase().trim());
            cliente.setEmail(jTF_email.getText());
            cliente.setObs(jTF_observacao.getText());
            cliente.setData_edicao(new Date());
            cliente.setId_usuario_edicao(_FuncionarioLogado.getId());
            if (jCB_fisica.isSelected()) {
                cliente.setCpf(jTF_cpf.getText().replaceAll("[^0-9]", ""));
                cliente.setRg(jTF_rg.getText().replaceAll("[^0-9]", ""));
                cliente.setTipo_pessoa("F");
                jTF_cnpj.setText("");
                jTF_ie.setText("ISENTO");
                cliente.setIe(jTF_ie.getText());
            } else if (jCB_juridica.isSelected()) {
                cliente.setCnpj(jTF_cnpj.getText().replaceAll("[^0-9]", ""));
                cliente.setIe(jTF_ie.getText().replaceAll("[^0-9]", ""));
                cliente.setTipo_pessoa("J");
                jTF_cpf.setText("");
                jTF_rg.setText("");
            }
            cliente.setExcluido(false);
            cliente.setQuantidade_dias_visita(Integer.valueOf(jTF_qtd_dias.getText()));

            try {
                ConectaBDCliente.getInstance().editarCliente(cliente);
                if (consultar) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "CLIENTE EDITADO COM SUCESSO!",
                            "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                    limpar();
                    listarClientes();
                    jTP_cliente.setSelectedIndex(0);
                    jTF_textoBusca.setText("");
                    jTF_textoBusca.requestFocus();
                }
            } catch (HeadlessException ex) {
                Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL EDITAR O CLIENTE!",
                        "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
            } catch (Exception ex) {
                Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_editarActionPerformed

    private void jT_clientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_clientesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            clienteSelecionado();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jTF_textoBusca.requestFocus();
            jTF_textoBusca.setText("");
        }
    }//GEN-LAST:event_jT_clientesKeyPressed

    private void jB_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_voltarActionPerformed
        limpar();
        listarClientes();
        limparTabelasHistorico();
        jTP_cliente.setSelectedIndex(0);
        jcbFiltros.setSelectedIndex(0);
        jTF_textoBusca.setText("");
        cliente = null;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jTF_textoBusca.requestFocus();
            }
        });
    }//GEN-LAST:event_jB_voltarActionPerformed

    private void jCB_fisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_fisicaActionPerformed
        pessoaFisica(true);
        jTF_cpf.requestFocus();
        jTF_ie.setText("ISENTO");
    }//GEN-LAST:event_jCB_fisicaActionPerformed

    private void jCB_juridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_juridicaActionPerformed
        pessoaFisica(false);
    }//GEN-LAST:event_jCB_juridicaActionPerformed

    private void jB_buscar_municipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_buscar_municipioActionPerformed
        MunicipiosDialog municipiosDialog = new MunicipiosDialog(null, true);
        municipiosDialog.setLocationRelativeTo(null);
        municipiosDialog.setVisible(true);
        if (municipiosDialog.importarMunicipio() != null) {
            jTF_codigo_municipio.setText(municipiosDialog.importarMunicipio().getCodigo_cidade());
            jTF_municipio.setText(municipiosDialog.importarMunicipio().getNome());
            jTF_uf.setText(municipiosDialog.importarMunicipio().getUf());
            jTF_data_nasc.requestFocus();
        }
    }//GEN-LAST:event_jB_buscar_municipioActionPerformed

    private void jTF_codigo_municipioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_codigo_municipioFocusGained
        jTF_data_nasc.requestFocus();
        if (jTF_codigo_municipio.getText().isEmpty()) {
            MunicipiosDialog municipiosDialog = new MunicipiosDialog(null, true);
            municipiosDialog.setLocationRelativeTo(null);
            municipiosDialog.setVisible(true);
            if (municipiosDialog.importarMunicipio() != null) {
                jTF_codigo_municipio.setText(municipiosDialog.importarMunicipio().getCodigo_cidade());
                jTF_municipio.setText(municipiosDialog.importarMunicipio().getNome());
                jTF_uf.setText(municipiosDialog.importarMunicipio().getUf());
                jTF_codigo_municipio.setBackground(Color.white);
            }
        } else {
            ArrayList list = ConectaBDMunicipio.getInstance().consultarMunicipiosTipo("codigo", jTF_codigo_municipio.getText());
            if (!list.isEmpty()) {
                Municipios municipios = (Municipios) list.get(0);
                jTF_codigo_municipio.setText(municipios.getCodigo_cidade());
                jTF_municipio.setText(municipios.getNome());
                jTF_uf.setText(municipios.getUf());
                jTF_codigo_municipio.setBackground(Color.white);
            } else {
                jTF_municipio.setText("Código Inválido!");
                jTF_codigo_municipio.setBackground(Color.red);
            }
        }
    }//GEN-LAST:event_jTF_codigo_municipioFocusGained

    private void jTF_cpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cpfFocusGained
//        jTF_cpf.setFormatterFactory(formato("***.***.***-**"));
    }//GEN-LAST:event_jTF_cpfFocusGained

    private void jTF_cnpjFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cnpjFocusGained
//        jTF_cnpj.setFormatterFactory(formato("**.***.***/****-**"));
    }//GEN-LAST:event_jTF_cnpjFocusGained

    private void jTF_numeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_numeroFocusLost
//        ValidaNumero(jTF_numero);
    }//GEN-LAST:event_jTF_numeroFocusLost

    private void jT_historico_vendas_davMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_historico_vendas_davMouseClicked
        if (evt.getClickCount() == 2) {
        }
    }//GEN-LAST:event_jT_historico_vendas_davMouseClicked

    private void jT_historico_pagamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_historico_pagamentosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_historico_pagamentosMouseClicked

    private void jTF_cpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cpfFocusLost
        verificaCadastroCpf(jTF_cpf);
    }//GEN-LAST:event_jTF_cpfFocusLost

    private void jTF_rgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_rgFocusLost
        verificaCadastroCpf(jTF_rg);
    }//GEN-LAST:event_jTF_rgFocusLost

    private void jTF_cnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cnpjFocusLost
        verificaCadastro(jTF_cnpj);
    }//GEN-LAST:event_jTF_cnpjFocusLost

    private boolean verificaCadastro(JTextField textField) {
        textField.setText(textField.getText().replaceAll("[^0-9]", ""));
        if ("ie".equals(textField.getName())) {
            if (textField.getText().isEmpty()) {
                textField.setText("ISENTO");
            }
        }

        String txt = textField.getText().replaceAll("[\\.\\-/]", "").trim();
        if (!txt.isEmpty() && !"ISENTO".equals(txt)) {
            try {
                String documento = textField.getText().replaceAll("[^0-9]", "");
                String busca = textField.getName().equals("cnpj") ? "cpf_cnpj" : "inscricao_estadual";
                ArrayList list = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where " + busca + " like '" + documento + "'");
                if (!list.isEmpty()) {
                    //achou algo
                    Cliente c = (Cliente) list.get(0);
                    if (c != null && !c.getId().equals(Integer.valueOf(jTF_codigo.getText()))) {
                        // verifica se é o mesmo
                        ok = false;
                        textField.setBackground(Color.yellow);
                        JOptionPane.showMessageDialog(rootPane, "Já existe um cliente com esse documento. Cliente: " + c.getId() + " - " + c.getNome());
                    } else {
                        ok = true;
                        textField.setBackground(Color.white);
                    }
                } else {
                    textField.setBackground(Color.white);
                    ok = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ok;
    }
    private void jTF_ieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_ieFocusLost
        verificaCadastro(jTF_ie);
    }//GEN-LAST:event_jTF_ieFocusLost

    private void jB_buscaCnpjONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_buscaCnpjONActionPerformed
        switch (JOptionPane.showOptionDialog(this, "", "TIPO DE CONSULTA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"FAZENDA", "SINTEGRA", "CANCELAR"}, 0)) {
            case 0: {
                try {
                    Process processo = Runtime.getRuntime().exec(Dir.bin + "ConsultarCNPJ.exe  " + jTF_cnpj.getText());
                    if (processo.waitFor() == 0) {
                        System.out.println("executou captha");
                    } else {
                        System.out.println("erro captha");
                    }
                    try (FileReader fileReader = new FileReader(new File(Dir.raiz + "dadosEmpresa.txt")); BufferedReader buffer = new BufferedReader(fileReader)) {
                        String tipo = buffer.readLine(), dataAbertura = buffer.readLine();
                        setarSeNaoForVazio(jTF_RazaoSocialOuNome, buffer.readLine());
                        setarSeNaoForVazio(jTF_fantasiaOuApelido, buffer.readLine());
                        setarSeNaoForVazio(jTF_endereco, buffer.readLine());
                        setarSeNaoForVazio(jTF_numero, buffer.readLine());
                        setarSeNaoForVazio(jTF_complemento, buffer.readLine());
                        setarSeNaoForVazio(jTF_cep, buffer.readLine());
                        setarSeNaoForVazio(jTF_bairro, buffer.readLine());
                        ArrayList lista = new ConectaBDMunicipio().consultarMunicipiosQuery("SELECT * FROM municipios where nome like '" + buffer.readLine() + "'  and uf like '" + buffer.readLine() + "'");
                        Municipios m = null;
                        try {
                            m = (Municipios) lista.get(0);
                        } catch (Exception e) {
                        }
                        if (m != null) {
                            setarSeNaoForVazio(jTF_municipio, m.getNome());
                            setarSeNaoForVazio(jTF_uf, m.getUf());
                            setarSeNaoForVazio(jTF_codigo_municipio, m.getCodigo_cidade());
                        }
                        JOptionPane.showMessageDialog(null, "TIPO: " + tipo
                                + "\nData Abertura: " + dataAbertura
                                + "\nSituação: " + buffer.readLine());
                    }
                    new File(Dir.raiz + "dadosEmpresa.txt").delete();
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 1: {
                try {
                    Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                    StringSelection ss = new StringSelection(jTF_cnpj.getText().replaceAll("[^0-9]", ""));
                    clip.setContents(ss, ss);
                    Process processo = Runtime.getRuntime().exec(Dir.bin + "ConsultaSINTEGRA_PE.exe  " + jTF_cnpj.getText());
                    if (processo.waitFor() == 0) {
                    } else {
                        System.out.println("Erro");
                    }
                    try (FileReader fileReader = new FileReader(new File(Dir.raiz + "dadosEmpresaSintegra.txt"));
                            BufferedReader buffer = new BufferedReader(fileReader)) {
                        for (int i = 1; i < 10; i++) {
                            buffer.readLine();
                        }
                        String txt = "";
                        while (buffer.ready()) {
                            txt += buffer.readLine();
                        }
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtCnpj = txt.substring(0, 14);
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtIe = txt.substring(0, txt.indexOf("Raz"));
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtRazao = txt.substring(0, txt.indexOf("ENDE"));
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtLogradouro = txt.substring(0, txt.indexOf("mero") - 3);
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtNumero = txt.substring(0, txt.indexOf("Com"));
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtComplemento = txt.substring(0, txt.indexOf("Bairro"));
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtBairro = txt.substring(0, txt.indexOf("Mun"));
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtMunicipio = txt.substring(0, txt.indexOf("UF:"));
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtUF = txt.substring(0, txt.indexOf("CEP"));
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtCEP = txt.substring(0, txt.indexOf("Tele"));
                        txt = txt.substring(txt.indexOf(": ") + 2);
                        String txtTelefone = txt.substring(0, txt.indexOf("INFO"));
                        setarSeNaoForVazio(jTF_RazaoSocialOuNome, txtRazao);
                        setarSeNaoForVazio(jTF_ie, txtIe);
                        setarSeNaoForVazio(jTF_fantasiaOuApelido, "");
                        setarSeNaoForVazio(jTF_endereco, txtLogradouro);
                        setarSeNaoForVazio(jTF_numero, txtNumero);
                        setarSeNaoForVazio(jTF_complemento, txtComplemento);
                        setarSeNaoForVazio(jTF_cep, txtCEP);
                        setarSeNaoForVazio(jTF_bairro, txtBairro);
                        setarSeNaoForVazio(jTF_telefone, txtTelefone);
                        ArrayList lista = new ConectaBDMunicipio().consultarMunicipiosQuery("SELECT * FROM municipios where nome like '" + txtMunicipio.trim() + "'  and uf like '" + txtUF.trim() + "'");
                        Municipios m = null;
                        try {
                            m = (Municipios) lista.get(0);
                        } catch (Exception e) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
                        }
                        if (m != null) {
                            setarSeNaoForVazio(jTF_municipio, m.getNome());
                            setarSeNaoForVazio(jTF_uf, m.getUf());
                            setarSeNaoForVazio(jTF_codigo_municipio, m.getCodigo_cidade());
                        }
                    }
                    new File(Dir.raiz + "dadosEmpresaSintegra.txt").delete();
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            default: {
                JOptionPane.showMessageDialog(this, "Consulta Cancelada, os dados deverão ser preenchidos manualmente.");
                break;
            }
        }
    }//GEN-LAST:event_jB_buscaCnpjONActionPerformed

    private void jB_buscaCepONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_buscaCepONActionPerformed
        if (jTF_cep.getText().equals("     -   ")) {
        } else {
            WebServiceBuscaCEPG3 endereco = new WebServiceBuscaCEPG3();
            endereco.buscaCEP(jTF_cep.getText());
            setarSeNaoForVazio(jTF_endereco, endereco.logradouroCompleto);
            setarSeNaoForVazio(jTF_bairro, endereco.bairro);
            setarSeNaoForVazio(jTF_uf, endereco.UF);
            setarSeNaoForVazio(jTF_municipio, endereco.cidade);
            ArrayList lista = new ConectaBDMunicipio().consultarMunicipiosQuery("SELECT * FROM municipios where nome like '" + jTF_municipio.getText() + "'  and uf like '" + jTF_uf.getText() + "'");
            try {
                Municipios municipios = (Municipios) lista.get(0);
                setarSeNaoForVazio(jTF_codigo_municipio, municipios.getCodigo_cidade());
                setarSeNaoForVazio(jTF_municipio, municipios.getNome());
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
            }

        }
    }//GEN-LAST:event_jB_buscaCepONActionPerformed
    private void jTF_cepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_cepFocusGained
        jTF_cep.setSelectionStart(0);
        jTF_cep.setSelectionEnd(jTF_cep.getText().length());
    }//GEN-LAST:event_jTF_cepFocusGained

    private void jTF_RazaoSocialOuNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_RazaoSocialOuNomeKeyTyped
        jTF_RazaoSocialOuNome.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_RazaoSocialOuNomeKeyTyped

    private void jTF_fantasiaOuApelidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_fantasiaOuApelidoKeyTyped
        jTF_fantasiaOuApelido.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_fantasiaOuApelidoKeyTyped

    private void jTF_enderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_enderecoKeyTyped
        jTF_endereco.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_enderecoKeyTyped

    private void jTF_numeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_numeroKeyTyped
        jTF_numero.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_numeroKeyTyped

    private void jTF_complementoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_complementoKeyTyped
        jTF_complemento.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_complementoKeyTyped

    private void jTF_bairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_bairroKeyTyped
        jTF_bairro.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_bairroKeyTyped

    private void jTF_cepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cepKeyTyped
        jTF_cep.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_cepKeyTyped

    private void jTF_cpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cpfKeyTyped
        jTF_cpf.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_cpfKeyTyped

    private void jTF_rgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_rgKeyTyped
        jTF_rg.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_rgKeyTyped

    private void jTF_orgao_rgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_orgao_rgKeyTyped
        jTF_orgao_rg.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_orgao_rgKeyTyped

    private void jTF_cnpjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cnpjKeyTyped
        jTF_cnpj.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_cnpjKeyTyped

    private void jTF_ieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_ieKeyTyped
        jTF_ie.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_ieKeyTyped

    private void jTF_imKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_imKeyTyped
        jTF_im.setForeground(Color.BLACK);
    }//GEN-LAST:event_jTF_imKeyTyped

    private void jCB_filtroDesativadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_filtroDesativadosActionPerformed
        consultarCliente();
    }//GEN-LAST:event_jCB_filtroDesativadosActionPerformed

    private void jCB_filtroAtivInativGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_filtroAtivInativGeralActionPerformed
        consultarCliente();
    }//GEN-LAST:event_jCB_filtroAtivInativGeralActionPerformed

    private void jCB_filtroAtivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_filtroAtivadosActionPerformed
        consultarCliente();
    }//GEN-LAST:event_jCB_filtroAtivadosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cliente = null;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void transfereFocusEnter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transfereFocusEnter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (evt.getComponent() instanceof JTextField && evt.getComponent().getBackground() == Color.yellow
                    && !((JTextField) evt.getComponent()).getText().isEmpty()) {
                evt.getComponent().setBackground(Color.white);
            }
            evt.getComponent().transferFocus();
        }
    }//GEN-LAST:event_transfereFocusEnter

    private void jTF_ieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_ieFocusGained
        jTF_ie.selectAll();
    }//GEN-LAST:event_jTF_ieFocusGained

    private void jB_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_excluirActionPerformed
        try {
            cliente.setId_usuario_exclusao(_FuncionarioLogado.getId());
            cliente.setExcluido(true);
            ConectaBDCliente.getInstance().excluirCliente(cliente);
            JOptionPane.showMessageDialog(rootPane, "Cliente excluído com sucesso!");
            limpar();
            listarClientes();
            jTP_cliente.setSelectedIndex(0);
            jTF_textoBusca.setText("");
            jTF_textoBusca.requestFocus();
        } catch (HeadlessException | SQLException ex) {
            Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_excluirActionPerformed

    private void jTF_qtd_diasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_qtd_diasFocusLost
        jTF_qtd_dias.setText(jTF_qtd_dias.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_jTF_qtd_diasFocusLost

    /**
     * @param args the command line arguments
     */
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteDialogGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClienteDialogGUI dialog = new ClienteDialogGUI(new javax.swing.JFrame(), true, false);
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
    private javax.swing.ButtonGroup buttonGroup_filtroSelecao;
    private javax.swing.ButtonGroup buttonGroup_tipo_pessoa;
    private javax.swing.JButton jB_buscaCepON;
    private javax.swing.JButton jB_buscaCnpjON;
    private javax.swing.JButton jB_buscar_municipio;
    private javax.swing.JButton jB_editar;
    private javax.swing.JButton jB_excluir;
    private javax.swing.JButton jB_fechar;
    private javax.swing.JButton jB_novo;
    private javax.swing.JButton jB_salvar;
    private javax.swing.JButton jB_selecao;
    private javax.swing.JButton jB_voltar;
    private javax.swing.JCheckBox jCB_filtroAtivInativGeral;
    private javax.swing.JCheckBox jCB_filtroAtivados;
    private javax.swing.JCheckBox jCB_filtroDesativados;
    private javax.swing.JCheckBox jCB_fisica;
    private javax.swing.JCheckBox jCB_juridica;
    private javax.swing.JLabel jL_total_compras;
    private javax.swing.JLabel jL_total_contas;
    private javax.swing.JLabel jL_total_pagamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_cadastrar;
    private javax.swing.JPanel jP_documentos;
    private javax.swing.JPanel jP_vasilhames;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTF_RazaoSocialOuNome;
    private javax.swing.JTextField jTF_bairro;
    private javax.swing.JFormattedTextField jTF_celular;
    private javax.swing.JFormattedTextField jTF_cep;
    private javax.swing.JFormattedTextField jTF_cnpj;
    private javax.swing.JTextField jTF_codigo;
    private javax.swing.JTextField jTF_codigo_municipio;
    private javax.swing.JTextField jTF_complemento;
    private javax.swing.JFormattedTextField jTF_cpf;
    private javax.swing.JFormattedTextField jTF_data_nasc;
    private javax.swing.JFormattedTextField jTF_dia;
    private javax.swing.JTextField jTF_email;
    private javax.swing.JTextField jTF_endereco;
    private javax.swing.JTextField jTF_fantasiaOuApelido;
    private javax.swing.JFormattedTextField jTF_ie;
    private javax.swing.JFormattedTextField jTF_im;
    private javax.swing.JTextField jTF_municipio;
    private javax.swing.JTextField jTF_numero;
    private javax.swing.JTextArea jTF_observacao;
    private javax.swing.JFormattedTextField jTF_orgao_rg;
    private javax.swing.JTextField jTF_qtd_dias;
    private javax.swing.JFormattedTextField jTF_rg;
    private javax.swing.JFormattedTextField jTF_telefone;
    private org.jdesktop.swingx.JXSearchField jTF_textoBusca;
    private javax.swing.JTextField jTF_uf;
    private javax.swing.JTabbedPane jTP_cliente;
    private javax.swing.JTabbedPane jTP_dados_cliente;
    private javax.swing.JTable jT_clienteVasilhame;
    private final javax.swing.JTable jT_clientes = new javax.swing.JTable();
    private javax.swing.JTable jT_historico_contas_pendentes;
    private javax.swing.JTable jT_historico_pagamentos;
    private javax.swing.JTable jT_historico_vendas_dav;
    private javax.swing.JComboBox<String> jcbFiltros;
    // End of variables declaration//GEN-END:variables

    private void botoes(boolean s, boolean e, boolean ex, boolean v) {
        jB_salvar.setEnabled(s);
        jB_editar.setEnabled(e);
        jB_excluir.setEnabled(ex);
        jB_voltar.setEnabled(v);
    }

    public void limparTabela() {
        DefaultTableModel tableData = (DefaultTableModel) jT_clientes.getModel();
        tableData.setRowCount(0);
        jT_clientes.setModel(tableData);
    }

    public final List listarClientes() {
        final List listaAuto = new ArrayList();
        try {
            limparTabela();
            ArrayList lista = ConectaBDCliente.getInstance().consultarCliente(
                    "select * from cliente where excluido = " + jCB_filtroDesativados.isSelected() + " order by nome");
            final ArrayList lista2 = lista;
            SwingWorker worker = new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    preencheTabela(jT_clientes, lista2, listaAuto);
                    return null;
                }

                @Override
                protected void done() {
//                    JTableModel.ajustarColunas(jT_clientes);
                }
            };
            worker.execute();
            jTF_textoBusca.setText("");
        } catch (Exception ex) {
            Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaAuto;
    }

    private void preencheTabela(JTable tabela, ArrayList lista, List listaAutoComplete) throws InterruptedException {
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
        Double cont = 1.00;
        int i = 0, qtd = lista.size();
        while (i < lista.size()) {
            Cliente cTemp = (Cliente) lista.get(i);
            if (!cTemp.getNome().isEmpty()) {
                listaAutoComplete.add(cTemp.getNome());
            }
            if (!cTemp.getApelido().isEmpty()) {
                listaAutoComplete.add(cTemp.getApelido());
            }
            dtm.addRow(new Object[]{cTemp.getId(), cTemp.getNome(), cTemp.getApelido(), cTemp.getTipo_pessoa().equalsIgnoreCase("F") ? cTemp.getCpf() : cTemp.getCnpj(), cTemp.getMunicipio(), cTemp.getTelefone()});
            cont++;
            i++;
        }
    }

    private void consultarCliente() {
        /*
        Código, Nome, Município, Fantasia, CPF, RG
         */
        String coluna = (jcbFiltros.getSelectedIndex() == 0
                ? "id"
                : jcbFiltros.getSelectedIndex() == 1
                ? "apelido"
                : jcbFiltros.getSelectedIndex() == 2
                ? "municipio"
                : jcbFiltros.getSelectedIndex() == 3
                ? "fantasia"
                : jcbFiltros.getSelectedIndex() == 4
                ? "cpf"
                : "rg");

        List lista;
        try {
            String query;
            if (coluna.equals("nome")) {
                query = "select * from cliente where (NOME like '%" + jTF_textoBusca.getText().substring(0, jTF_textoBusca.getSelectionStart()) + "%' or apelido like '%" + jTF_textoBusca.getText().substring(0, jTF_textoBusca.getSelectionStart()) + "%') and excluido is " + jCB_filtroDesativados.isSelected() + " order by nome";
            } else {
                query = "select * from cliente where " + coluna + " like '%" + jTF_textoBusca.getText().substring(0, jTF_textoBusca.getSelectionStart()) + "%' and excluido is " + jCB_filtroDesativados.isSelected() + " order by nome";
            }
            if (jCB_filtroAtivInativGeral.isSelected() && coluna.equals("nome")) {
                query = "select * from cliente where (NOME like '%" + jTF_textoBusca.getText().substring(0, jTF_textoBusca.getSelectionStart()) + "%' or apelido like '%" + jTF_textoBusca.getText().substring(0, jTF_textoBusca.getSelectionStart()) + "%') order by nome";
            } else if (jCB_filtroAtivInativGeral.isSelected()) {
                query = "select * from cliente where " + coluna + " like '%" + jTF_textoBusca.getText().substring(0, jTF_textoBusca.getSelectionStart()) + "%' order by nome";
            }
            lista = ConectaBDCliente.getInstance().consultarCliente(query);
            preencheTabelaBusca(lista);
            JTableModel.ajustarColunas(jT_clientes);
        } catch (InterruptedException | SQLException ex) {
            Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void preencheTabelaBusca(List lista) throws InterruptedException {
        DefaultTableModel dtm = (DefaultTableModel) jT_clientes.getModel();
        limparTabela();
        int i = 0;// int qtd = lista.size();
        while (i < lista.size()) {
            Cliente cTemp = (Cliente) lista.get(i);
            dtm.addRow(new Object[]{cTemp.getId(), cTemp.getNome(), cTemp.getApelido(), cTemp.getTipo_pessoa().equalsIgnoreCase("F") ? cTemp.getCpf() : cTemp.getCnpj(), cTemp.getMunicipio(), cTemp.getTelefone()});
            i++;
        }
    }

    private void clienteSelecionado() {
        limpar();
        limparTabelasHistorico();
        int i = jT_clientes.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "NENHUM CLIENTE SELECIONADO!",
                    "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            try {
                int id_cliente = (Integer) jT_clientes.getModel().getValueAt(i, 0);
                List lista = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where id = " + id_cliente);
                cliente = (Cliente) lista.get(0);
                if (consultar) {
                    dispose();
                } else {
                    if (pessoaFisica(cliente.getTipo_pessoa().equalsIgnoreCase("F"))) {
                        jTF_cpf.setText(cliente.getCpf());
                        jTF_rg.setText(cliente.getRg());
                        jCB_fisica.setSelected(true);
                        jTF_ie.setText(cliente.getIe());
                    } else {
                        jTF_ie.setText(cliente.getIe());
                        jTF_cnpj.setText(cliente.getCnpj().replace(".", "").replace("-", "").replace("/", ""));
                        jCB_juridica.setSelected(true);
                    }
                    jTF_codigo.setText(cliente.getId().toString());
                    jTF_RazaoSocialOuNome.setText(cliente.getNome());
                    jTF_telefone.setText(cliente.getTelefone());
                    jTF_fantasiaOuApelido.setText(cliente.getApelido());
                    jTF_endereco.setText(cliente.getEndereco());
                    jTF_numero.setText(cliente.getNum_end());
                    jTF_bairro.setText(cliente.getBairro());
                    jTF_cep.setText(cliente.getCep());
                    jTF_data_nasc.setText(cliente.getData_nasc() != null ? new SimpleDateFormat("dd/MM/yyyy").format(cliente.getData_nasc()) : "");
                    jTF_orgao_rg.setText(cliente.getOrgao_rg());
                    jTF_celular.setText(cliente.getCelular());
                    jTF_codigo_municipio.setText(cliente.getCod_municipio());
                    jTF_municipio.setText(cliente.getMunicipio());
                    jTF_uf.setText(cliente.getUf());
                    jTF_complemento.setText(cliente.getComp_end());
                    jTF_email.setText(cliente.getEmail());
                    jTF_observacao.setText(cliente.getObs());
                    jTF_qtd_dias.setText(cliente.getQuantidade_dias_visita().toString());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String data_cadastro = simpleDateFormat.format(cliente.getData_cadastro());
                    jTF_dia.setText(data_cadastro);

                    comprasDoCliente();
                    contasPendentes();
                    pagamentos();
                    vasilhamesVinculados();

                    jTP_cliente.setSelectedIndex(1);
                    jTP_dados_cliente.setSelectedIndex(0);
                    jP_cadastrar.hasFocus();
                    botoes(false, true, true, true);
                    travaCamposCliente(true);
                }
            } catch (Exception ex) {
                Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param fisica
     */
    private boolean pessoaFisica(boolean fisica) {
        jCB_fisica.setSelected(fisica);

        jTF_cpf.setEnabled(fisica);
        jTF_rg.setEnabled(fisica);
        jTF_orgao_rg.setEnabled(fisica);

        jTF_cnpj.setEnabled(!fisica);
        jTF_ie.setEnabled(!fisica);
        jTF_im.setEnabled(!fisica);

        if (fisica) {
            jTF_cnpj.setBackground(null);
            jTF_ie.setBackground(null);
            jTF_im.setBackground(null);
            jTF_cpf.setBackground(Color.white);
            jTF_rg.setBackground(Color.white);
            jTF_orgao_rg.setBackground(Color.white);
        } else {
            jTF_cnpj.setBackground(Color.white);
            jTF_ie.setBackground(Color.white);
            jTF_im.setBackground(Color.white);
            jTF_cpf.setBackground(null);
            jTF_rg.setBackground(null);
            jTF_orgao_rg.setBackground(null);
        }
        return fisica;
    }

    private void limpar() {
        for (Component field : jPanel5.getComponents()) {
            if (field instanceof JTextField) {
                ((JTextField) field).setText("");
            }
        }
        for (Component ch : jP_documentos.getComponents()) {
            if (ch instanceof JTextField) {
                ((JTextField) ch).setText("");
            }
        }
        jTF_observacao.setText("");
        jTF_dia.setText(dia);

        jTF_cpf.setText("");
        jTF_rg.setText("");
        jTF_cnpj.setText("");
        jTF_ie.setText("");
        jCB_fisica.setText("");
        jCB_juridica.setText("");
        jTF_im.setText("");
        jTF_orgao_rg.setText("");
        jTF_qtd_dias.setText("0");
    }

    private void travaCamposCliente(boolean b) {
        for (Component c : jPanel5.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setEditable(b);
                ((JTextField) c).setForeground(Color.BLACK);
            } else if (c instanceof JCheckBox) {
                ((JCheckBox) c).setEnabled(b);
            } else if (c instanceof JButton) {
                ((JButton) c).setEnabled(b);
            }
        }

        for (Component c : jP_documentos.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setEditable(b);
            } else if (c instanceof JCheckBox) {
                ((JCheckBox) c).setEnabled(b);
            }
        }

        for (Component c : jPanel3.getComponents()) {
            if (c instanceof JComboBox) {
                ((JComboBox) c).setEnabled(b);
            }
            jTF_observacao.setEnabled(b);
        }
    }

    private DefaultFormatterFactory formato(String mask) {
        MaskFormatter comFoco = null;
        try {
            comFoco = new MaskFormatter(mask);
            comFoco.setValidCharacters("0123456789"); // adicione os caracteres validos  
        } catch (ParseException pe) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", pe);
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);
        return factory;
    }

    private boolean campoObrigatorioVazio() {
        boolean temCampoVazio = false;
        JTextField campos[] = {jTF_RazaoSocialOuNome, jTF_endereco, jTF_numero, jTF_codigo_municipio};
        for (JTextField jTextField : campos) {
            if (jTextField.getText().isEmpty()) {
                jTextField.setBackground(Color.yellow);
                temCampoVazio = true;
            } else {
                jTextField.setBackground(Color.white);
            }
        }

        if (temCampoVazio) {
            JOptionPane.showMessageDialog(null, "CAMPO(s) OBRIGATÓRIO(s) EM BRANCO!", null, 2);
            return true;
        } else {
            return false;
        }
    }

    public void ValidaNumero(JTextField Numero) {
        long valor;
        if (Numero.getText().length() != 0) {
            try {
                valor = Long.parseLong(Numero.getText());
                Numero.setBackground(null);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Esse Campo só aceita números", "Validação", JOptionPane.INFORMATION_MESSAGE);
                Numero.setBackground(Color.yellow);
                jTP_cliente.grabFocus();
            }
        }
    }

    private void limparTabelasHistorico() {
        DefaultTableModel dtm = (DefaultTableModel) jT_historico_vendas_dav.getModel();
        DefaultTableModel dtmContas = (DefaultTableModel) jT_historico_contas_pendentes.getModel();
        DefaultTableModel dtmPag = (DefaultTableModel) jT_historico_pagamentos.getModel();
        dtm.setRowCount(0);
        dtmContas.setRowCount(0);
        dtmPag.setRowCount(0);
    }

    private void setarSeNaoForVazio(JTextField textFild, String str) {
        if (str != null && !str.isEmpty()) {
            textFild.setText(str.replace(".", "").toUpperCase());
            textFild.setForeground(Color.BLUE);
        } else {
            textFild.setForeground(Color.BLACK);
        }
    }

    private boolean verificaCadastroCpf(JTextField textField) {
        String txt = textField.getText().replaceAll("[\\.\\-/]", "").trim();
        if (!txt.isEmpty()) {
            try {
                String busca = textField.getName().equals("cpf") ? "cpf" : "rg";
                ArrayList list = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where " + busca + " like "
                        + "'" + textField.getText() + "' or " + busca + " like '" + textField.getText().replaceAll("[^0-9]", "") + "'");
                if (!list.isEmpty()) {
                    //achou algo
                    Cliente c = (Cliente) list.get(0);
                    if (c != null && (!jTF_codigo.getText().isEmpty() && !c.getId().equals(Integer.valueOf(jTF_codigo.getText())))) {
                        //se o q achou comparado com o q ta modificando existir
                        ok = false;
                        textField.setBackground(Color.yellow);
                        JOptionPane.showMessageDialog(rootPane, "Já existe um cliente com esse documento. Cliente: " + c.getId() + " - " + c.getNome());
                    } else {
                        ok = true;
                        textField.setBackground(Color.white);
                    }
                } else {
                    //nao encontrou
                    ok = true;
                    textField.setBackground(Color.white);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ok;
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void vasilhamesVinculados() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jT_clienteVasilhame.getModel();
            dtm.setRowCount(0);
            ArrayList<ClienteVasilhame> listaClienteVasilhame = ConectaBDClienteVasilhame.getInstance().consultarClienteVasilhame(
                    "select cv.id, cv.id_produto_vasilhame, cv.id_venda_detalhe, cv.quantidade, cv.data_hora_transacao, "
                    + "cv.status from cliente c inner join venda_cabecalho vc ON c.id = vc.cliente_id "
                    + "INNER JOIN venda_detalhe vd ON vc.id = vd.venda_cabecalho_id INNER JOIN "
                    + "cliente_vasilhame cv ON vd.id = cv.id_venda_detalhe WHERE c.id = " + cliente.getId());
            for (ClienteVasilhame clienteVasilhame : listaClienteVasilhame) {
                BigDecimal qtdTotalDevolvida = ConectaBDClienteVasilhameDetalhe.getInstance().consultarTotalDevolvidoClienteVasilhameDetalhe(clienteVasilhame.getId());
                dtm.addRow(new Object[]{
                    clienteVasilhame.getId(),
                    fmtDataHora.format(clienteVasilhame.getData_hora_transacao()),
                    clienteVasilhame.getQuantidade().setScale(2, RoundingMode.HALF_DOWN),
                    qtdTotalDevolvida.setScale(2, RoundingMode.HALF_DOWN),
                    clienteVasilhame.getQuantidade().subtract(qtdTotalDevolvida).setScale(2, RoundingMode.HALF_DOWN),
                    clienteVasilhame.getStatus()
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void comprasDoCliente() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jT_historico_vendas_dav.getModel();
            dtm.setRowCount(0);
            ArrayList<VendaCabecalho> listaVendas = Fachada.getInstancia().consultarVendaCabecalho(
                    "select * from venda_cabecalho where cliente_id = " + cliente.getId() + " and not excluido");
            BigDecimal totalCompras = BigDecimal.ZERO;
            for (VendaCabecalho vc : listaVendas) {
                dtm.addRow(new Object[]{
                    vc.getId(),
                    fmtDataHora.format(vc.getData_hora_venda()),
                    vc.getTipoPagamento().getDescricao(),
                    vc.getSubtotal().setScale(2, RoundingMode.HALF_DOWN),
                    vc.getAcrescimo().setScale(2, RoundingMode.HALF_DOWN),
                    vc.getDesconto().setScale(2, RoundingMode.HALF_DOWN),
                    vc.getTotal().setScale(2, RoundingMode.HALF_DOWN)
                });
                totalCompras = totalCompras.add(vc.getTotal());
            }
            jL_total_compras.setText(totalCompras.setScale(2, RoundingMode.HALF_DOWN).toString());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDialogGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void contasPendentes() {
        DefaultTableModel dtm = (DefaultTableModel) jT_historico_contas_pendentes.getModel();
        dtm.setRowCount(0);
        ArrayList<FinanceiroParcelas> listaParcelasReceber = Fachada.getInstancia().consultarParcelasReceberQuery(
                "select pr.* from cliente c inner join contas_receber cr on c.id = cr.id_cliente inner join parcelas_receber pr on "
                + "cr.id = pr.id_contas_receber and pr.status not like 'PG' and pr.data_vencimento <= curdate() and cr.id_cliente = " + cliente.getId());
        BigDecimal totalPendente = BigDecimal.ZERO;
        for (FinanceiroParcelas pr : listaParcelasReceber) {
            dtm.addRow(new Object[]{
                pr.getId(),
                fmtData.format(pr.getData_vencimento()),
                pr.getValor().setScale(2, RoundingMode.HALF_DOWN),
                pr.getValor_pago().setScale(2, RoundingMode.HALF_DOWN),
                pr.getValor().subtract(pr.getValor_pago()).setScale(2, RoundingMode.HALF_DOWN)
            });
            totalPendente = totalPendente.add(pr.getValor().subtract(pr.getValor_pago()));
        }
        jL_total_contas.setText(totalPendente.setScale(2, RoundingMode.HALF_DOWN).toString());
    }

    private void pagamentos() {
        DefaultTableModel dtm = (DefaultTableModel) jT_historico_pagamentos.getModel();
        dtm.setRowCount(0);
        ArrayList<ParcelasPagasCliente> lista = Fachada.getInstancia().consultarParcelasPagasCliente(cliente.getId());
        BigDecimal totalPago = BigDecimal.ZERO;
        for (ParcelasPagasCliente parcelasPagasCliente : lista) {
            dtm.addRow(new Object[]{
                parcelasPagasCliente.getId_parcela(),
                fmtData.format(parcelasPagasCliente.getDataVencimento()),
                fmtData.format(parcelasPagasCliente.getDataPagamento()),
                parcelasPagasCliente.getHoraRecebimento(),
                parcelasPagasCliente.getValor().setScale(2, RoundingMode.HALF_DOWN),
                parcelasPagasCliente.getValorPago().setScale(2, RoundingMode.HALF_DOWN)
            });
            totalPago = totalPago.add(parcelasPagasCliente.getValorPago());
        }
        jL_total_pagamentos.setText(totalPago.setScale(2, RoundingMode.HALF_DOWN).toString());
    }
}
