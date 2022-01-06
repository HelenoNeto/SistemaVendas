package GUI;

import Negocios.Fachada;
import Negocios.Fornecedor;
import Negocios.NotaEntrada;
import Negocios.NotaEntradaProduto;
import Negocios.Produto;
import SUPORTE.exceptions.ErroInternoException;
import Utilitarios.ClasseUtilitaria;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXSearchField;
import sistema.gas.SISTEMA_GAS;
import Dados.ConectaBDProduto;

public class NotaEntradaDialog extends javax.swing.JFrame {

    private BigDecimal total_nota = BigDecimal.ZERO;
    private NotaEntradaProduto notaProduto = new NotaEntradaProduto();
    private NotaEntrada nota = new NotaEntrada();
    private Produto produto;
    private Fornecedor fornecedor;

    public NotaEntradaDialog() {
        initComponents();
        jTF_pesquisa_nota_fiscal.requestFocus();

        jT_notas.getColumnModel().getColumn(0).setPreferredWidth(40);
        jT_notas.getColumnModel().getColumn(1).setPreferredWidth(40);
        jT_notas.getColumnModel().getColumn(2).setPreferredWidth(40);
        jT_notas.getColumnModel().getColumn(3).setPreferredWidth(450);
        jT_notas.getColumnModel().getColumn(4).setPreferredWidth(80);

        jTF_entrada.setDate(new Date());

        jTF_pesquisa_nota_fiscal.setSearchMode(JXSearchField.SearchMode.REGULAR);
        jTF_pesquisa_nota_fiscal.setFindAction(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisar();
            }

        });

        jTP_notas.setEnabled(false);

        jTF_pesquisa_nota_fiscal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    pesquisar();
                } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                    jT_notas.addRowSelectionInterval(0, 0);
                    jT_notas.requestFocus();
                }
            }
        });

        listarNotas_fiscais();

        botaoSalvar(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTP_notas = new javax.swing.JTabbedPane();
        jP_consultar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_notas = new javax.swing.JTable();
        jC_tipo_pesq = new javax.swing.JComboBox();
        jB_novo = new javax.swing.JButton();
        jB_OK = new javax.swing.JButton();
        jB_cancelar = new javax.swing.JButton();
        jTF_pesquisa_nota_fiscal = new org.jdesktop.swingx.JXSearchField();
        jP_cadastrar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTF_codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTF_fornecedor_cod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jL_nome_fornecedor = new javax.swing.JLabel();
        jTF_emissao = new org.jdesktop.swingx.JXDatePicker();
        jTF_entrada = new org.jdesktop.swingx.JXDatePicker();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTF_codigo_produto = new javax.swing.JTextField();
        jL_descricao_produto = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTF_quantidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTF_preco_uni = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTF_lucro = new javax.swing.JTextField();
        jTF_valor_venda = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jT_nota_produto = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jTF_valor_total = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jB_salvar = new javax.swing.JButton();
        jB_exlcuirProdutos = new javax.swing.JButton();
        jB_fechar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jL_codigo = new javax.swing.JLabel();
        jB_excluirNota = new javax.swing.JButton();
        jB_editar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Notas de Entrada");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTP_notas.setEnabled(false);
        jTP_notas.setFocusable(false);

        jP_consultar.setFocusable(false);

        jT_notas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Emissão", "Fornecedor", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_notas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jT_notas.getTableHeader().setReorderingAllowed(false);
        jT_notas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_notasMouseClicked(evt);
            }
        });
        jT_notas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_notasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jT_notas);
        if (jT_notas.getColumnModel().getColumnCount() > 0) {
            jT_notas.getColumnModel().getColumn(0).setMinWidth(0);
            jT_notas.getColumnModel().getColumn(0).setPreferredWidth(0);
            jT_notas.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jC_tipo_pesq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CODIGO", "FORNECEDOR", "EMISSAO" }));
        jC_tipo_pesq.setFocusable(false);
        jC_tipo_pesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_tipo_pesqActionPerformed(evt);
            }
        });

        jB_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adiciona.png"))); // NOI18N
        jB_novo.setText("Novo");
        jB_novo.setFocusable(false);
        jB_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_novoActionPerformed(evt);
            }
        });

        jB_OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/accept.png"))); // NOI18N
        jB_OK.setText("Seleção");
        jB_OK.setFocusable(false);
        jB_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_OKActionPerformed(evt);
            }
        });

        jB_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_cancelar.setText("Cancelar");
        jB_cancelar.setFocusable(false);
        jB_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelarActionPerformed(evt);
            }
        });

        jTF_pesquisa_nota_fiscal.setToolTipText("Buscar");
        jTF_pesquisa_nota_fiscal.setPrompt("Buscar");

        javax.swing.GroupLayout jP_consultarLayout = new javax.swing.GroupLayout(jP_consultar);
        jP_consultar.setLayout(jP_consultarLayout);
        jP_consultarLayout.setHorizontalGroup(
            jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_consultarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                            .addGroup(jP_consultarLayout.createSequentialGroup()
                                .addComponent(jC_tipo_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_pesquisa_nota_fiscal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jP_consultarLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jB_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB_cancelar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jP_consultarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_OK, jB_cancelar, jB_novo});

        jP_consultarLayout.setVerticalGroup(
            jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_consultarLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jC_tipo_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_pesquisa_nota_fiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_consultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_OK)
                    .addComponent(jB_cancelar)
                    .addComponent(jB_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jP_consultarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_OK, jB_cancelar, jB_novo});

        jTP_notas.addTab("Consultar", jP_consultar);

        jP_cadastrar.setFocusable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nota:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Emissão:");

        jTF_codigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_codigo.setName("NOTA"); // NOI18N
        jTF_codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_codigoFocusLost(evt);
            }
        });
        jTF_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_codigoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fornecedor(F1):");

        jTF_fornecedor_cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_fornecedor_cod.setName("FORNECEDOR"); // NOI18N
        jTF_fornecedor_cod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_fornecedor_codFocusLost(evt);
            }
        });
        jTF_fornecedor_cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_fornecedor_codKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Entrada:");

        jL_nome_fornecedor.setForeground(new java.awt.Color(0, 0, 255));

        jTF_emissao.setName("EMISSÃO"); // NOI18N

        jTF_entrada.setName("ENTRADA"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTF_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jTF_emissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTF_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTF_fornecedor_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jL_nome_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_fornecedor_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jL_nome_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTF_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTF_emissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Código(F1):");

        jTF_codigo_produto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_codigo_produto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_codigo_produtoFocusGained(evt);
            }
        });
        jTF_codigo_produto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_codigo_produtoKeyPressed(evt);
            }
        });

        jL_descricao_produto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_descricao_produto.setForeground(new java.awt.Color(0, 51, 204));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Quant:");

        jTF_quantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_quantidade.setText("1");
        jTF_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_quantidadeKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Preço Uni:");

        jTF_preco_uni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_preco_uni.setText("0.00");
        jTF_preco_uni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_preco_uniFocusGained(evt);
            }
        });
        jTF_preco_uni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_preco_uniKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Lucro:");

        jTF_lucro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_lucro.setText("0.00");
        jTF_lucro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_lucroFocusGained(evt);
            }
        });
        jTF_lucro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_lucroKeyPressed(evt);
            }
        });

        jTF_valor_venda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTF_valor_venda.setText("0.00");
        jTF_valor_venda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_valor_vendaFocusGained(evt);
            }
        });
        jTF_valor_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_valor_vendaKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("V. Venda:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(jTF_codigo_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jL_descricao_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_preco_uni, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_lucro, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_valor_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(jTF_codigo_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_descricao_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jTF_valor_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jTF_lucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jTF_preco_uni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jTF_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jT_nota_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Produto", "Valor compra", "Quantidade", "Total", "Lucro", "Valor Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_nota_produto.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jT_nota_produto.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jT_nota_produto);
        if (jT_nota_produto.getColumnModel().getColumnCount() > 0) {
            jT_nota_produto.getColumnModel().getColumn(0).setMinWidth(0);
            jT_nota_produto.getColumnModel().getColumn(0).setPreferredWidth(0);
            jT_nota_produto.getColumnModel().getColumn(0).setMaxWidth(0);
            jT_nota_produto.getColumnModel().getColumn(1).setResizable(false);
            jT_nota_produto.getColumnModel().getColumn(1).setPreferredWidth(150);
            jT_nota_produto.getColumnModel().getColumn(2).setResizable(false);
            jT_nota_produto.getColumnModel().getColumn(2).setPreferredWidth(350);
            jT_nota_produto.getColumnModel().getColumn(3).setResizable(false);
            jT_nota_produto.getColumnModel().getColumn(3).setPreferredWidth(120);
            jT_nota_produto.getColumnModel().getColumn(4).setResizable(false);
            jT_nota_produto.getColumnModel().getColumn(4).setPreferredWidth(120);
            jT_nota_produto.getColumnModel().getColumn(5).setResizable(false);
            jT_nota_produto.getColumnModel().getColumn(5).setPreferredWidth(120);
            jT_nota_produto.getColumnModel().getColumn(6).setResizable(false);
            jT_nota_produto.getColumnModel().getColumn(6).setPreferredWidth(120);
            jT_nota_produto.getColumnModel().getColumn(7).setResizable(false);
            jT_nota_produto.getColumnModel().getColumn(7).setPreferredWidth(120);
        }

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTF_valor_total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTF_valor_total.setForeground(new java.awt.Color(0, 0, 204));
        jTF_valor_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_valor_total.setText("0.00");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 255));
        jLabel17.setText("Total nota:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTF_valor_total, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_valor_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jB_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jB_salvar.setText("Salvar");
        jB_salvar.setFocusable(false);
        jB_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvarActionPerformed(evt);
            }
        });

        jB_exlcuirProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_closed.png"))); // NOI18N
        jB_exlcuirProdutos.setText("Excluir Prod");
        jB_exlcuirProdutos.setFocusable(false);
        jB_exlcuirProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_exlcuirProdutosActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Código interno:");

        jL_codigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jL_codigo.setForeground(new java.awt.Color(0, 0, 204));

        jB_excluirNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bin_closed.png"))); // NOI18N
        jB_excluirNota.setText("Excluir Nota");
        jB_excluirNota.setFocusable(false);
        jB_excluirNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_excluirNotaActionPerformed(evt);
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

        javax.swing.GroupLayout jP_cadastrarLayout = new javax.swing.GroupLayout(jP_cadastrar);
        jP_cadastrar.setLayout(jP_cadastrarLayout);
        jP_cadastrarLayout.setHorizontalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_cadastrarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jP_cadastrarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jL_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_cadastrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jB_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_exlcuirProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_excluirNota, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        jP_cadastrarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_editar, jB_excluirNota, jB_exlcuirProdutos, jB_fechar, jB_salvar});

        jP_cadastrarLayout.setVerticalGroup(
            jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_cadastrarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jL_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jP_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_exlcuirProdutos)
                    .addComponent(jB_salvar)
                    .addComponent(jB_excluirNota)
                    .addComponent(jB_fechar)
                    .addComponent(jB_editar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_cadastrarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_editar, jB_excluirNota, jB_exlcuirProdutos, jB_fechar, jB_salvar});

        jTP_notas.addTab("Cadastrar", jP_cadastrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTP_notas, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTP_notas, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(851, 579));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jC_tipo_pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_tipo_pesqActionPerformed
        pesquisar();
}//GEN-LAST:event_jC_tipo_pesqActionPerformed

    private void jB_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_novoActionPerformed
        limpar();
        limparTabelaProduto();
        jTP_notas.setSelectedIndex(1);
        botaoSalvar(true);
        jB_editar.setEnabled(false);
        jB_excluirNota.setEnabled(false);
}//GEN-LAST:event_jB_novoActionPerformed

    private void jB_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_OKActionPerformed
        try {
            NotaEntradaSelecionado();
            botaoSalvar(false);
        } catch (ErroInternoException ex) {
            Logger.getLogger(NotaEntradaDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jB_OKActionPerformed

    private void jB_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelarActionPerformed
        dispose();
}//GEN-LAST:event_jB_cancelarActionPerformed

    private void jB_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarActionPerformed
        if (camposVazios() == true) {
            String campos_vazios[] = new String[6];
            campos_vazios[0] = "Campos vazios: ";
            if (jTF_codigo.getText().trim().isEmpty()) {
                campos_vazios[1] = jTF_codigo.getName() + " ";
            }
            if (jTF_fornecedor_cod.getText().trim().isEmpty()) {
                campos_vazios[2] = jTF_fornecedor_cod.getName() + "; ";
            }
            if (jTF_entrada.getDate() == null) {
                campos_vazios[3] = jTF_entrada.getName() + "; ";
            }
            if (jTF_emissao.getDate() == null) {
                campos_vazios[4] = jTF_emissao.getName() + "; ";
            }
            if (jT_nota_produto.getRowCount() == 0) {
                campos_vazios[5] = "Nenhum produto adicionado!";
            }
            JOptionPane.showMessageDialog(null, campos_vazios);
        } else {
            NotaEntrada nota_fiscal = new NotaEntrada();
            nota_fiscal.setCodigo(jTF_codigo.getText());
            Date date = jTF_emissao.getDate();
            nota_fiscal.setData_emissao(date);
            date = jTF_entrada.getDate();
            nota_fiscal.setData_entrada(date);
            nota_fiscal.setFornecedor(fornecedor);
            nota_fiscal.setTotal(ClasseUtilitaria.parseToBig(jTF_valor_total.getText()));
            if (!jTF_codigo.getText().isEmpty() && !jTF_fornecedor_cod.getText().isEmpty()) {
                try {
                    Fachada.getInstancia().incluirNotaFiscalJDBC(nota_fiscal);
                } catch (Exception e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta do Sistema", JOptionPane.ERROR_MESSAGE);
                }

                boolean alteraEstoque = true;
                int i = 0;
                while (jT_nota_produto.getRowCount() > i) {
                    try {
                        int id_produto = (Integer) jT_nota_produto.getModel().getValueAt(i, 0);
                        String descricao_produto = (String) jT_nota_produto.getModel().getValueAt(i, 2);
                        BigDecimal preco_uni = ClasseUtilitaria.parseToBig((String) jT_nota_produto.getModel().getValueAt(i, 3));
                        BigDecimal quant = ClasseUtilitaria.parseToBig((String) jT_nota_produto.getModel().getValueAt(i, 4));
                        BigDecimal valor_total = ClasseUtilitaria.parseToBig((String) jT_nota_produto.getModel().getValueAt(i, 5));
                        BigDecimal lucro = ClasseUtilitaria.parseToBig((String) jT_nota_produto.getModel().getValueAt(i, 6));
                        BigDecimal valor_venda = ClasseUtilitaria.parseToBig((String) jT_nota_produto.getModel().getValueAt(i, 7));

                        NotaEntradaProduto nota_fiscalProduto = new NotaEntradaProduto();
                        nota_fiscalProduto.setId_nota_entrada(nota_fiscal.getId());
                        nota_fiscalProduto.setId_produto(id_produto);
                        nota_fiscalProduto.setDescricao_produto(descricao_produto);
                        nota_fiscalProduto.setPreco_uni(preco_uni);
                        nota_fiscalProduto.setQuantidade(quant);
                        nota_fiscalProduto.setValor(valor_total);
                        Fachada.getInstancia().incluirNotaFiscalProdutoJDBC(nota_fiscalProduto);
                        Produto p = ConectaBDProduto.getInstance().consultarProduto_porId(id_produto);
                        if (alteraEstoque == true) {
                            p.setQtd_estoque(p.getQtd_estoque().add(quant));
                            if (p.getId_produto_vasilhame() != 0) {
                                Produto produtoVasilhame = ConectaBDProduto.getInstance().consultarProduto_porId(p.getId_produto_vasilhame());
                                BigDecimal qtdVasilhames = p.getQtd_vasilhame().multiply(quant);
                                ConectaBDProduto.getInstance().diminuirEstoqueProduto(qtdVasilhames, produtoVasilhame);
                            }
                        }
                        p.setValor_compra(preco_uni);
                        p.setValor_venda(valor_venda);
                        p.setLucro(lucro);
                        p.setId_usuario_edicao(SISTEMA_GAS._FuncionarioLogado.getId());
                        p.setData_edicao(new Date());
                        ConectaBDProduto.getInstance().salvarProduto(p);
                        i++;
                    } catch (SQLException ex) {
                        Logger.getLogger(NotaEntradaDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(null, "Nota salva!!", "CONFIRMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                jTP_notas.setSelectedIndex(0);
                limpar();
                listarNotas_fiscais();
                limparTabelaProduto();
            } else {
                JOptionPane.showMessageDialog(null, "Codigo da Nota ou Fornecedor não cadastrado",
                        "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                if (jTF_codigo.getText().isEmpty()) {
                    jTF_codigo.requestFocus();
                    jTF_codigo.setBackground(Color.red);
                } else if (jTF_fornecedor_cod.getText().isEmpty()) {
                    jTF_fornecedor_cod.requestFocus();
                    jTF_fornecedor_cod.setBackground(Color.red);
                }
            }
        }
}//GEN-LAST:event_jB_salvarActionPerformed

    private void jB_exlcuirProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_exlcuirProdutosActionPerformed
        cancelarProduto();
}//GEN-LAST:event_jB_exlcuirProdutosActionPerformed

    private void jB_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_fecharActionPerformed
        limpar();
        limparTabelaProduto();
        jTP_notas.setSelectedIndex(0);
}//GEN-LAST:event_jB_fecharActionPerformed

    private void jT_notasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_notasMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                NotaEntradaSelecionado();
            } catch (ErroInternoException ex) {
                Logger.getLogger(NotaEntradaDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jT_notasMouseClicked

    private void jTF_fornecedor_codKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_fornecedor_codKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            FornecedorDialog listarFornecedorDialog = new FornecedorDialog(this, true, true);
            listarFornecedorDialog.setLocationRelativeTo(null);
            listarFornecedorDialog.setVisible(true);
            fornecedor = listarFornecedorDialog.getFornecedor();
            if (fornecedor != null) {
                jTF_fornecedor_cod.setText(fornecedor.getId() + "");
                jL_nome_fornecedor.setText(fornecedor.getRazao_social());
                jTF_emissao.requestFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                fornecedor = Fachada.getInstancia().consultarFornecedor(Integer.valueOf(jTF_fornecedor_cod.getText()));
                if (fornecedor != null) {
                    jTF_fornecedor_cod.setText(String.valueOf(fornecedor.getId()));
                    jL_nome_fornecedor.setText(fornecedor.getRazao_social());
                    jTF_emissao.requestFocus();
                }
            } catch (NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(null, "FORNECEDOR NAO ENCONTRADO!",
                        "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                jTF_fornecedor_cod.selectAll();
            }
        }
    }//GEN-LAST:event_jTF_fornecedor_codKeyPressed

    private void jTF_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_codigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_fornecedor_cod.requestFocus();
        }
    }//GEN-LAST:event_jTF_codigoKeyPressed

    private void jB_excluirNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_excluirNotaActionPerformed
        Object[] op = {"Sim!", "Não!"};
        if (JOptionPane.showOptionDialog(this, "Deseja excluir a nota?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, op, op[1]) == JOptionPane.YES_OPTION) {
            try {
                Fachada.getInstancia().excluirNotaFiscalJDBC(nota);
                ArrayList listaProduto = Fachada.getInstancia().consultarNotaFiscalProdutoJDBC(nota.getId());
                int iProduto = 0;
                while (listaProduto.size() > iProduto) {
                    notaProduto = (NotaEntradaProduto) listaProduto.get(iProduto);
                    Fachada.getInstancia().excluirNotaFiscalProdutoJDBC(notaProduto);
                    iProduto++;
                }
                //TODO: ATUALIZA ESTOQUE NO CANCELAMENTO
                retornaEstoque();
                limpar();
                limparProduto();
                limparTabela();
                limparTabelaProduto();
                listarNotas_fiscais();
                JOptionPane.showMessageDialog(null, "Nota de Entrada Excluída com Sucesso!", "DELEÇÃO DE NOTA", JOptionPane.INFORMATION_MESSAGE);
                jTP_notas.setSelectedComponent(jP_consultar);
            } catch (ErroInternoException | HeadlessException exception) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
                JOptionPane.showMessageDialog(null, "Não foi possível Excluir a Nota!", "DELEÇÃO DE NOTA", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jB_excluirNotaActionPerformed

    private void jTF_preco_uniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_preco_uniKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jTF_preco_uni.getText().isEmpty()) {
                jTF_preco_uni.setText("0.00");
            } else if (ClasseUtilitaria.parseToBig(jTF_preco_uni.getText()).compareTo(BigDecimal.ZERO) <= 0) {
                jTF_preco_uni.setBackground(Color.yellow);
                jTF_preco_uni.requestFocus();
                jTF_preco_uni.selectAll();
                JOptionPane.showMessageDialog(rootPane, "Valor Inválido!", "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
            } else {
                jTF_preco_uni.setBackground(jTF_codigo.getBackground());
                jTF_lucro.requestFocus();
            }
        }
}//GEN-LAST:event_jTF_preco_uniKeyPressed

    private void jTF_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_quantidadeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jTF_quantidade.getText().isEmpty()) {
                jTF_quantidade.requestFocus();
                jTF_quantidade.setBackground(Color.YELLOW);
            } else if (ClasseUtilitaria.parseToBig(jTF_quantidade.getText()).compareTo(BigDecimal.ZERO) <= 0) {
                jTF_quantidade.setBackground(Color.YELLOW);
                JOptionPane.showMessageDialog(rootPane, "Quantidade inválida!", "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
            } else {
                jTF_quantidade.setBackground(null);
                jTF_preco_uni.requestFocus();
                jTF_preco_uni.selectAll();
            }

        }

        if (evt.getKeyCode()
                == KeyEvent.VK_F1) {
            String total = JOptionPane.showInputDialog("Total: ");
            BigDecimal big = ClasseUtilitaria.parseToBig(String.valueOf(Double.parseDouble(total) / Double.parseDouble(jTF_quantidade.getText())));
            jTF_preco_uni.setText(big.setScale(4, RoundingMode.DOWN).toString());

        }
}//GEN-LAST:event_jTF_quantidadeKeyPressed

    private void jTF_codigo_produtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_codigo_produtoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            ProdutoDialog consultaProdutos = new ProdutoDialog(this, true, true);
            consultaProdutos.setLocationRelativeTo(null);
            consultaProdutos.setVisible(true);
            produto = consultaProdutos.getProduto();
            if (produto != null) {
                jTF_codigo_produto.setText(produto.getCodigo());
                jL_descricao_produto.setText(produto.getDescricao());
                jTF_valor_venda.setText(ClasseUtilitaria.fmtBig(produto.getValor_venda(), 2));
                jTF_preco_uni.setText(ClasseUtilitaria.fmtBig(produto.getValor_compra(), 2));
                jTF_lucro.setText(ClasseUtilitaria.fmtBig(produto.getLucro(), 2));
                jTF_quantidade.setText("1,000");
                jTF_quantidade.requestFocus();
                jTF_quantidade.selectAll();
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                produto = ConectaBDProduto.getInstance().consultarProduto_porCodigo(jTF_codigo_produto.getText());
                if (produto == null) {
                    JOptionPane.showMessageDialog(null, "NENHUM PRODUTO ENCONTRADO!",
                            "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                    jTF_codigo_produto.requestFocus();
                } else {
                    jL_descricao_produto.setText(produto.getDescricao());
                    jTF_preco_uni.setText(ClasseUtilitaria.fmtBig(produto.getValor_compra(), 2));
                    jTF_valor_venda.setText(ClasseUtilitaria.fmtBig(produto.getValor_venda(), 2));
                    jTF_lucro.setText(ClasseUtilitaria.fmtBig(produto.getLucro(), 2));
                    jTF_quantidade.setText("1");
                    jTF_quantidade.requestFocus();
                    jTF_quantidade.selectAll();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}//GEN-LAST:event_jTF_codigo_produtoKeyPressed

    private void jTF_codigo_produtoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_codigo_produtoFocusGained
        jTF_codigo_produto.selectAll();
}//GEN-LAST:event_jTF_codigo_produtoFocusGained

    private void jTF_lucroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_lucroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jTF_lucro.getText().isEmpty()) {
                jTF_lucro.setText("0,00");
                BigDecimal compra = ClasseUtilitaria.parseToBig(jTF_preco_uni.getText());
                BigDecimal lucro = ClasseUtilitaria.parseToBig(jTF_lucro.getText());
                BigDecimal venda = compra.add((compra.multiply((lucro.divide(ClasseUtilitaria.parseToBig("100"))))));
                jTF_valor_venda.setText(ClasseUtilitaria.fmtBig(venda, 2));
                jTF_valor_venda.requestFocus();
            } else if (ClasseUtilitaria.parseToBig(jTF_lucro.getText()).compareTo(BigDecimal.ZERO) <= 0) {
                jTF_lucro.setBackground(Color.yellow);
                jTF_lucro.requestFocus();
                jTF_lucro.selectAll();
                JOptionPane.showMessageDialog(rootPane, "Valor Inválido!", "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
            } else {
                jTF_lucro.setBackground(null);
                BigDecimal compra = ClasseUtilitaria.parseToBig(jTF_preco_uni.getText());
                BigDecimal lucro = ClasseUtilitaria.parseToBig(jTF_lucro.getText());
                BigDecimal venda = compra.add((compra.multiply((lucro.divide(ClasseUtilitaria.parseToBig("100"))))));
                jTF_valor_venda.setText(ClasseUtilitaria.fmtBig(venda, 2));
                jTF_valor_venda.requestFocus();
            }
        }
    }//GEN-LAST:event_jTF_lucroKeyPressed

    private void jTF_valor_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_valor_vendaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BigDecimal preco_uni = ClasseUtilitaria.parseToBig(jTF_preco_uni.getText());
            BigDecimal venda = ClasseUtilitaria.parseToBig(jTF_valor_venda.getText());
            BigDecimal lucro = ((venda.subtract(preco_uni)).divide(preco_uni, 3, RoundingMode.DOWN)).multiply(ClasseUtilitaria.parseToBig(100));
            jTF_lucro.setText(String.valueOf(lucro));
            BigDecimal total_produto = preco_uni.multiply(ClasseUtilitaria.parseToBig(jTF_quantidade.getText()));
            total_nota = ClasseUtilitaria.parseToBig(jTF_valor_total.getText());
            total_nota = total_nota.add(total_produto);
            jTF_valor_total.setText(ClasseUtilitaria.fmtBig(total_nota, 2));
            DefaultTableModel dtm = (DefaultTableModel) jT_nota_produto.getModel();
            dtm.addRow(new Object[]{
                produto.getId(),
                produto.getCodigo(),
                produto.getDescricao(),
                ClasseUtilitaria.fmtBig(preco_uni, 2),
                ClasseUtilitaria.fmtBig(ClasseUtilitaria.parseToBig(jTF_quantidade.getText()), 3),
                ClasseUtilitaria.fmtBig(total_produto, 2),
                ClasseUtilitaria.fmtBig(lucro, 2),
                ClasseUtilitaria.fmtBig(venda, 2)
            });
            limparProduto();
        }
    }//GEN-LAST:event_jTF_valor_vendaKeyPressed

    private void jB_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_editarActionPerformed
        if (camposVazios() == true) {
            String campos_vazios[] = new String[6];
            campos_vazios[0] = "Campos vazios: ";
            if (jTF_codigo.getText().trim().isEmpty()) {
                campos_vazios[1] = jTF_codigo.getName() + " ";
            }
            if (jTF_fornecedor_cod.getText().trim().isEmpty()) {
                campos_vazios[2] = jTF_fornecedor_cod.getName();
            }
            if (jTF_entrada.getDate() == null) {
                campos_vazios[3] = jTF_entrada.getName();
            }
            if (jTF_emissao.getDate() == null) {
                campos_vazios[4] = jTF_emissao.getName();
            }
            if (jT_nota_produto.getRowCount() == 0) {
                campos_vazios[5] = "Nenhum produto adicionado!";
            }
            JOptionPane.showMessageDialog(null, campos_vazios);
        } else {
            try {
                editarNotaEntrada();
                excluirNotaProduto();
                editarNotaProduto();

                JOptionPane.showMessageDialog(null, "Nota editada com sucesso!",
                        "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                jTP_notas.setSelectedIndex(0);
                limpar();
                listarNotas_fiscais();
                limparTabelaProduto();
            } catch (ErroInternoException | HeadlessException | NumberFormatException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
            }
        }
    }//GEN-LAST:event_jB_editarActionPerformed

    private void jTF_codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_codigoFocusLost
        if (jTF_codigo.getText().isEmpty()) {
            jTF_codigo.setBackground(Color.yellow);
        } else {
            jTF_codigo.setBackground(null);
        }
    }//GEN-LAST:event_jTF_codigoFocusLost

    private void jTF_fornecedor_codFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_fornecedor_codFocusLost
        if (jTF_fornecedor_cod.getText().isEmpty()) {
            jTF_fornecedor_cod.setBackground(Color.yellow);
        } else {
            jTF_fornecedor_cod.setBackground(null);
        }
    }//GEN-LAST:event_jTF_fornecedor_codFocusLost

    private void jT_notasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_notasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                NotaEntradaSelecionado();
            } catch (ErroInternoException ex) {
                Logger.getLogger(NotaEntradaDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jT_notasKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        dispose();
    }//GEN-LAST:event_formWindowClosed

    private void jTF_preco_uniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_preco_uniFocusGained
        jTF_preco_uni.selectAll();
    }//GEN-LAST:event_jTF_preco_uniFocusGained

    private void jTF_lucroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_lucroFocusGained
        jTF_lucro.selectAll();
    }//GEN-LAST:event_jTF_lucroFocusGained

    private void jTF_valor_vendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_valor_vendaFocusGained
        jTF_valor_venda.selectAll();
    }//GEN-LAST:event_jTF_valor_vendaFocusGained

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotaEntradaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NotaEntradaDialog().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_OK;
    private javax.swing.JButton jB_cancelar;
    private javax.swing.JButton jB_editar;
    private javax.swing.JButton jB_excluirNota;
    private javax.swing.JButton jB_exlcuirProdutos;
    private javax.swing.JButton jB_fechar;
    private javax.swing.JButton jB_novo;
    private javax.swing.JButton jB_salvar;
    private javax.swing.JComboBox jC_tipo_pesq;
    private javax.swing.JLabel jL_codigo;
    private javax.swing.JLabel jL_descricao_produto;
    private javax.swing.JLabel jL_nome_fornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_cadastrar;
    private javax.swing.JPanel jP_consultar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTF_codigo;
    private javax.swing.JTextField jTF_codigo_produto;
    private org.jdesktop.swingx.JXDatePicker jTF_emissao;
    private org.jdesktop.swingx.JXDatePicker jTF_entrada;
    private javax.swing.JTextField jTF_fornecedor_cod;
    private javax.swing.JTextField jTF_lucro;
    private org.jdesktop.swingx.JXSearchField jTF_pesquisa_nota_fiscal;
    private javax.swing.JTextField jTF_preco_uni;
    private javax.swing.JTextField jTF_quantidade;
    private javax.swing.JTextField jTF_valor_total;
    private javax.swing.JTextField jTF_valor_venda;
    private javax.swing.JTabbedPane jTP_notas;
    private javax.swing.JTable jT_nota_produto;
    private javax.swing.JTable jT_notas;
    // End of variables declaration//GEN-END:variables

    public void limpar() {
        jTF_codigo.setText("");
        jTF_emissao.setDate(null);
        jTF_fornecedor_cod.setText("");
        jL_nome_fornecedor.setText("");
        jTF_pesquisa_nota_fiscal.setText("");
        jTF_valor_total.setText("0.00");
        total_nota = BigDecimal.ZERO;

        jL_codigo.setText("0");
    }

    public void limparProduto() {
        jTF_codigo_produto.setText("");
        jTF_preco_uni.setText("0,00");
        jTF_quantidade.setText("1,00");
        jL_descricao_produto.setText("");
        jTF_lucro.setText("0,00");
        jTF_valor_venda.setText("0,00");
        jTF_codigo_produto.requestFocus();
    }

    public void limparTabelaProduto() {
        limparProduto();
        DefaultTableModel tableData = (DefaultTableModel) jT_nota_produto.getModel();
        tableData.setRowCount(0);
        jT_nota_produto.setModel(tableData);
        jTF_codigo.requestFocus();
    }

    public void limparTabela() {
        DefaultTableModel tableData = (DefaultTableModel) jT_notas.getModel();
        tableData.setRowCount(0);
        jT_notas.setModel(tableData);
        jTF_pesquisa_nota_fiscal.requestFocus();
    }

    public final void listarNotas_fiscais() {
        limparTabela();
        int i = 0;
        ArrayList lista = Fachada.getInstancia().consultarNotaFiscalJDBC("data_emissao", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        DefaultTableModel dtm = (DefaultTableModel) jT_notas.getModel();
        while (i < lista.size()) {
            NotaEntrada nTemp = (NotaEntrada) lista.get(i);
            dtm.addRow(new Object[]{
                nTemp.getId(),
                nTemp.getCodigo(),
                ClasseUtilitaria.fmtDataBR.format(nTemp.getData_emissao()),
                nTemp.getFornecedor().getRazao_social(),
                ClasseUtilitaria.fmtBig(nTemp.getTotal(), 2)
            });
            i++;
        }
    }

    public final void botaoSalvar(boolean b) {
        jB_salvar.setEnabled(b);
    }

    public void pesquisar() {
        String tipo = jC_tipo_pesq.getSelectedItem().toString();
        int i = 0;
        String pesquisa = jTF_pesquisa_nota_fiscal.getText();
        ArrayList listaNotas;
        if (tipo.equalsIgnoreCase("FORNECEDOR")) {
            listaNotas = Fachada.getInstancia().consultarNotaFiscalQueryJDBC(""
                    + " select nf.* from nota_entrada nf inner join fornecedor f on nf.id_fornecedor=f.id_fornecedor"
                    + " where"
                    + " (f.razao_social like '" + pesquisa + "%' or f.razao_social like '% " + pesquisa + "%')"
                    + " or"
                    + " (f.nome_fantasia like '" + pesquisa + "%' or f.nome_fantasia like '% " + pesquisa + "%') limit 50");
        } else {
            listaNotas = Fachada.getInstancia().consultarNotaFiscalJDBC(tipo, pesquisa);
        }

        DefaultTableModel dtm = (DefaultTableModel) jT_notas.getModel();
        limparTabela();
        while (i < listaNotas.size()) {
            NotaEntrada nTemp = (NotaEntrada) listaNotas.get(i);
            dtm.addRow(new Object[]{
                nTemp.getId(),
                nTemp.getCodigo(),
                ClasseUtilitaria.fmtDataBR.format(nTemp.getData_emissao()),
                nTemp.getFornecedor().getRazao_social().toUpperCase(),
                nTemp.getTotal()
            });
            i++;
        }
    }

    public void NotaEntradaSelecionado() throws ErroInternoException {
        limparTabelaProduto();
        int i = jT_notas.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "NENHUMA NOTA SELECIONADA!",
                    "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
        } else {
            jB_salvar.setEnabled(false);
            jB_editar.setEnabled(true);
            jB_excluirNota.setEnabled(true);

            int id = (Integer) jT_notas.getModel().getValueAt(i, 0);
            ArrayList lista = Fachada.getInstancia().consultarNotaFiscalJDBC("ID", String.valueOf(id));
            nota = (NotaEntrada) lista.get(0);
            jL_codigo.setText(String.valueOf(nota.getId()));
            jTF_codigo.setText(nota.getCodigo());
            jTF_emissao.setDate(nota.getData_emissao());
            jTF_entrada.setDate(nota.getData_entrada());
            jTF_fornecedor_cod.setText(String.valueOf(nota.getFornecedor().getId()));
            jL_nome_fornecedor.setText(nota.getFornecedor().getRazao_social());
            jTF_valor_total.setText(nota.getTotal().setScale(2, RoundingMode.DOWN).toString());

            ArrayList listaProduto = Fachada.getInstancia().consultarNotaFiscalProdutoJDBC(id);
            int iProduto = 0;
            while (listaProduto.size() > iProduto) {
                try {
                    notaProduto = (NotaEntradaProduto) listaProduto.get(iProduto);
                    Produto p = ConectaBDProduto.getInstance().consultarProduto_porId(notaProduto.getId_produto());
                    DefaultTableModel dtm = (DefaultTableModel) jT_nota_produto.getModel();
                    dtm.addRow(new Object[]{
                        p.getId(),
                        p.getCodigo(),
                        notaProduto.getDescricao_produto(),
                        ClasseUtilitaria.fmtBig(notaProduto.getPreco_uni(), 2),
                        ClasseUtilitaria.fmtBig(notaProduto.getQuantidade(), 3),
                        ClasseUtilitaria.fmtBig(notaProduto.getValor(), 2),
                        ClasseUtilitaria.fmtBig(p.getLucro(), 2),
                        ClasseUtilitaria.fmtBig(p.getValor_venda(), 2)
                    });
                    iProduto++;
                } catch (SQLException ex) {
                    Logger.getLogger(NotaEntradaDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            jTP_notas.setSelectedIndex(1);
        }
    }

    public void cancelarProduto() {
        try {
            int i = jT_nota_produto.getSelectedRow();
            DefaultTableModel dtm = (DefaultTableModel) jT_nota_produto.getModel();
            if (i == -1) {
                JOptionPane.showMessageDialog(null, "NENHUM PRODUTO SELECIONADO!",
                        "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
            } else {
                //MODIFICAR O VALOR DA COMPRA
                BigDecimal s = ClasseUtilitaria.parseToBig((String) jT_nota_produto.getModel().getValueAt(i, 5));
                BigDecimal t = ClasseUtilitaria.parseToBig(jTF_valor_total.getText());
                total_nota = t.subtract(s);
                jTF_valor_total.setText(total_nota.setScale(2, RoundingMode.DOWN).toString());

                //TIRAR O PRODUTO DA VENDA
                dtm.removeRow(i);
                JOptionPane.showMessageDialog(null, "PRODUTO CANCELADO COM SUCESSO",
                        "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
                jTF_codigo_produto.requestFocus();
            }
        } catch (HeadlessException | NumberFormatException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL CANCELAR O PRODUTO. TENTE NOVAMENTE!",
                    "Alerta do Sistema", JOptionPane.INFORMATION_MESSAGE, null);
        }

    }

    private void retornaEstoque() throws ErroInternoException {
        int i = 0;
        while (jT_nota_produto.getRowCount() > i) {
            try {
                int id_produto = (Integer) jT_nota_produto.getModel().getValueAt(i, 0);
                BigDecimal quant = ClasseUtilitaria.parseToBig((String) jT_nota_produto.getModel().getValueAt(i, 4));
                Produto p = ConectaBDProduto.getInstance().consultarProduto_porId(id_produto);
                if (p.getId_produto_vasilhame() != 0) {
                    Produto produtoVasilhame = ConectaBDProduto.getInstance().consultarProduto_porId(p.getId_produto_vasilhame());
                    BigDecimal qtdVasilhames = p.getQtd_vasilhame().multiply(quant);
                    ConectaBDProduto.getInstance().adicionarEstoqueProduto(qtdVasilhames, produtoVasilhame);
                }
                ConectaBDProduto.getInstance().diminuirEstoqueProduto(quant, p);
                i++;
            } catch (NumberFormatException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void editarNotaEntrada() {
        nota.setCodigo(jTF_codigo.getText());
        Date date;
        date = jTF_emissao.getDate();
        nota.setData_emissao(date);
        date = jTF_entrada.getDate();
        nota.setData_entrada(date);
        nota.setFornecedor(fornecedor);
        nota.setTotal(ClasseUtilitaria.parseToBig(jTF_valor_total.getText()));
        Fachada.getInstancia().editaNotaFiscalJDBC(nota);
    }

    private void excluirNotaProduto() throws ErroInternoException {
        ArrayList listNotaProduto = Fachada.getInstancia().consultarNotaFiscalProdutoJDBC(nota.getId());
        int i = 0;
        while (listNotaProduto.size() > i) {
            try {
                NotaEntradaProduto nota_fiscalProduto = (NotaEntradaProduto) listNotaProduto.get(i);
                Produto p = ConectaBDProduto.getInstance().consultarProduto_porId(nota_fiscalProduto.getId_produto());
                if (p.getId_produto_vasilhame() != 0) {
                    Produto produtoVasilhame = ConectaBDProduto.getInstance().consultarProduto_porId(p.getId_produto_vasilhame());
                    BigDecimal qtdVasilhames = produtoVasilhame.getQtd_vasilhame().multiply(nota_fiscalProduto.getQuantidade());
                    ConectaBDProduto.getInstance().adicionarEstoqueProduto(qtdVasilhames, produtoVasilhame);
                }
                p.setQtd_estoque(p.getQtd_estoque().subtract(nota_fiscalProduto.getQuantidade()));
                ConectaBDProduto.getInstance().salvarProduto(p);
                Fachada.getInstancia().excluirNotaFiscalProdutoJDBC(nota_fiscalProduto);
                i++;
            } catch (SQLException ex) {
                Logger.getLogger(NotaEntradaDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void editarNotaProduto() throws ErroInternoException {
        int i = 0;
        while (jT_nota_produto.getRowCount() > i) {
            try {
                int id_produto = (Integer) jT_nota_produto.getModel().getValueAt(i, 0);
                String descricao_produto = (String) jT_nota_produto.getModel().getValueAt(i, 2);
                BigDecimal preco_uni = (BigDecimal) jT_nota_produto.getModel().getValueAt(i, 3);
                BigDecimal quant = (BigDecimal) jT_nota_produto.getModel().getValueAt(i, 4);
                BigDecimal valor = (BigDecimal) jT_nota_produto.getModel().getValueAt(i, 5);
                BigDecimal lucro = (BigDecimal) jT_nota_produto.getModel().getValueAt(i, 6);
                BigDecimal valor_venda = (BigDecimal) jT_nota_produto.getModel().getValueAt(i, 7);
                NotaEntradaProduto nota_fiscalProduto = new NotaEntradaProduto();
                nota_fiscalProduto.setId_nota_entrada(nota.getId());
                nota_fiscalProduto.setId_produto(id_produto);
                nota_fiscalProduto.setDescricao_produto(descricao_produto);
                nota_fiscalProduto.setPreco_uni(preco_uni);
                nota_fiscalProduto.setQuantidade(quant);
                nota_fiscalProduto.setValor(valor);
                Fachada.getInstancia().incluirNotaFiscalProdutoJDBC(nota_fiscalProduto);
                Produto p = ConectaBDProduto.getInstance().consultarProduto_porId(id_produto);
                p.setQtd_estoque(p.getQtd_estoque().add(quant));
                if (p.getId_produto_vasilhame() != 0) {
                    Produto produtoVasilhame = ConectaBDProduto.getInstance().consultarProduto_porId(p.getId_produto_vasilhame());
                    BigDecimal qtdVasilhames = produtoVasilhame.getQtd_vasilhame().multiply(quant);
                    ConectaBDProduto.getInstance().diminuirEstoqueProduto(qtdVasilhames, produtoVasilhame);
                }
                p.setValor_compra(preco_uni);
                p.setValor_venda(valor_venda);
                p.setLucro(lucro);
                ConectaBDProduto.getInstance().salvarProduto(p);
                i++;
            } catch (SQLException ex) {
                Logger.getLogger(NotaEntradaDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean camposVazios() {
        return jTF_codigo.getText().trim().isEmpty() || jTF_fornecedor_cod.getText().trim().isEmpty() || jTF_entrada == null || jTF_emissao == null || jT_nota_produto.getRowCount() == 0;
    }

}
