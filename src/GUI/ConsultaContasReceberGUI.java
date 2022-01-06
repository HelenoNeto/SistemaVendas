package GUI;

import Dados.ConectaBDConfiguracaoJurosParcelasReceber;
import Negocios.*;
import Relatorios.RelatorioContasReceber;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sistema.gas.cliente.dados.ConectaBDCliente;

public class ConsultaContasReceberGUI extends javax.swing.JDialog {

    private FinanceiroParcelas par;
    private Financeiro contas;
    private SimpleDateFormat fmtdataBR = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat fmtdataUS = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat fmtHora = new SimpleDateFormat("HH:mm:ss");
    private Date dateNow;
    private Cliente cliente;
    private int atraso = 0;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ConsultaContasReceberGUI(java.awt.Frame parent, boolean modal, Financeiro contas_receber,
            FinanceiroParcelas parcelas_receber, boolean trava) {
        super(parent, modal);
        try {
            this.dateNow = fmtdataUS.parse(fmtdataUS.format(new Date()));
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaContasReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            initComponents();
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(Utilitarios.Dir.imagens_internas + "icone.png"));
            String dataV = fmtdataBR.format(parcelas_receber.getData_vencimento());
            String data_emissao = fmtdataBR.format(contas_receber.getData_emissao());
            String data_pg = fmtdataBR.format(dateNow);
            travaCampos(trava, jPanel1);
            jTF_data_emissao_r.setText(data_emissao);
            jTF_documento_r.setText(contas_receber.getDocumento());
            jTF_cod_cliente.setText(String.valueOf(contas_receber.getCliente().getId()));
            jTF_referente_r.setText(contas_receber.getReferente());
            jTF_parcela_r.setText(parcelas_receber.getParcela());
            jTF_lancamento_r.setText(String.valueOf(parcelas_receber.getLancamento()));
            jTF_vencimento_r.setText(dataV);
            jTF_valor_parc_r.setText(parcelas_receber.getValor().setScale(2, RoundingMode.HALF_UP).toString());
            jTF_valor_pago_r.setText(parcelas_receber.getValor_pago().setScale(2, RoundingMode.HALF_UP).toString());
            BigDecimal valor_parcela = parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago());
            if (parcelas_receber.getData_vencimento().before(new Date())) {
                long result;
                result = dateNow.getTime() - parcelas_receber.getData_vencimento().getTime();
                long diasematraso = (long) Math.ceil(result * 0.0000000116) - 1;
                System.out.println("Dias = " + diasematraso);
                if (parcelas_receber.getStatus().equals("NAO")) {
                    //Configuracao dos juros
                    ConectaBDConfiguracaoJurosParcelasReceber conexaoJuros = new ConectaBDConfiguracaoJurosParcelasReceber();
                    ConfiguracaoJurosParcelasReceber configuracaoJurosParcelasReceber = conexaoJuros.retornaConfiguracaoJurosParcelasReceber(""
                            + "select * from configuracao_juros_parcelas_receber where id = (select max(id) from configuracao_juros_parcelas_receber)");
                    if (configuracaoJurosParcelasReceber.getTipo_juros().equalsIgnoreCase("AM")) {
                        atraso = (int) (diasematraso / 30);
                    } else if (configuracaoJurosParcelasReceber.getTipo_juros().equalsIgnoreCase("AD")) {
                        atraso = (int) diasematraso;
                    } else if (configuracaoJurosParcelasReceber.getTipo_juros().equalsIgnoreCase("AA")) {
                        atraso = ((int) (diasematraso / 30)) / 12;
                    }
                    valor_parcela = valor_parcela.add(valor_parcela.multiply(new BigDecimal(atraso).multiply(configuracaoJurosParcelasReceber.getValor_juros())));
                    String[] opcoes = {"OK", "Cobrar sem juros!"};
                    if (JOptionPane.showOptionDialog(null, "Valor com juros: " + valor_parcela.setScale(2, RoundingMode.HALF_UP), "Pergunta do Sistema",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, opcoes, null) == JOptionPane.YES_OPTION) {
                        jL_juros.setText("JUROS " + configuracaoJurosParcelasReceber.getTipo_juros() + " (%)");
                        BigDecimal cem = new BigDecimal(100);
                        jTF_juros.setText(configuracaoJurosParcelasReceber.getValor_juros().multiply(cem).setScale(3, RoundingMode.HALF_UP).toString());
                        jTF_valor_pagar_r.setText(String.valueOf(valor_parcela.setScale(2, RoundingMode.HALF_UP)));
                    } else {
                        jTF_valor_pagar_r.setText(parcelas_receber.getValor().subtract(parcelas_receber.getValor_pago()).setScale(2, RoundingMode.HALF_UP).toString());
                    }
                } else {
                    jTF_valor_pagar_r.setText(valor_parcela.setScale(2, RoundingMode.HALF_UP).toString());
                }
            } else {
                jTF_valor_pagar_r.setText(valor_parcela.setScale(2, RoundingMode.HALF_UP).toString());
            }
            ArrayList lista = ConectaBDCliente.getInstance().consultarCliente("select * from cliente where id = " + contas_receber.getCliente().getId());
            cliente = (Cliente) lista.get(0);
            jTF_nome_cliente_cr.setText(cliente.getNome());
            jTF_data_pagamento_r.setText(data_pg);
            par = parcelas_receber;
            contas = contas_receber;

            if (parcelas_receber.getStatus().equalsIgnoreCase("PG") && !parcelas_receber.getParcela().equalsIgnoreCase("ENTRADA")) {
                jB_cancelar_recebimento.setEnabled(true);
            } else {
                jB_cancelar_recebimento.setEnabled(false);
            }

            jTF_cod_cliente.setEditable(false);
            jTF_lancamento_r.setEditable(false);
            jTF_documento_r.setEditable(false);
            jTF_nome_cliente_cr.setEditable(false);
            jTF_parcela_r.setEditable(false);
            jTF_referente_r.setEditable(false);
            jTF_valor_parc_r.setEditable(false);
            jTF_data_emissao_r.setEditable(false);
            jTF_data_pagamento_r.setEditable(false);
            jTF_vencimento_r.setEditable(false);
            jTF_valor_pago_r.setEditable(false);

            jTF_valor_pagar_r.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(ConsultaContasReceberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTF_lancamento_r = new javax.swing.JTextField();
        jTF_documento_r = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTF_nome_cliente_cr = new javax.swing.JTextField();
        jTF_cod_cliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTF_parcela_r = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTF_referente_r = new javax.swing.JTextField();
        jTF_data_emissao_r = new javax.swing.JFormattedTextField();
        jTF_data_pagamento_r = new javax.swing.JFormattedTextField();
        jTF_vencimento_r = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTF_valor_parc_r = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTF_valor_pago_r = new javax.swing.JTextField();
        jL_juros = new javax.swing.JLabel();
        jTF_juros = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTF_multa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTF_desconto_r = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTF_valor_pagar_r = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jB_cancelar_recebimento = new javax.swing.JButton();
        jB_salvar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jB_recibo = new javax.swing.JButton();
        jB_fechar = new javax.swing.JButton();
        jB_quitar_receber = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CONSULTAS PARCELAS RECEBER");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Parcelas Receber"));
        jPanel1.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Lançamento");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Data de Emissão");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Vencimento");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Data de Pag.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Documento");

        jTF_lancamento_r.setFocusable(false);
        jTF_lancamento_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_lancamento_rKeyPressed(evt);
            }
        });

        jTF_documento_r.setFocusable(false);
        jTF_documento_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_documento_rKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cliente");

        jTF_nome_cliente_cr.setFocusable(false);
        jTF_nome_cliente_cr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_nome_cliente_crKeyPressed(evt);
            }
        });

        jTF_cod_cliente.setFocusable(false);
        jTF_cod_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_cod_clienteKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cód. Parcela");

        jTF_parcela_r.setFocusable(false);
        jTF_parcela_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_parcela_rKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Referente");

        jTF_referente_r.setFocusable(false);
        jTF_referente_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_referente_rKeyPressed(evt);
            }
        });

        try {
            jTF_data_emissao_r.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_data_emissao_r.setFocusable(false);
        jTF_data_emissao_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_data_emissao_rKeyPressed(evt);
            }
        });

        try {
            jTF_data_pagamento_r.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_data_pagamento_r.setFocusable(false);
        jTF_data_pagamento_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_data_pagamento_rKeyPressed(evt);
            }
        });

        try {
            jTF_vencimento_r.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTF_vencimento_r.setFocusable(false);
        jTF_vencimento_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_vencimento_rKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Parcela Total");

        jTF_valor_parc_r.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTF_valor_parc_r.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_valor_parc_r.setText("0.00");
        jTF_valor_parc_r.setFocusable(false);
        jTF_valor_parc_r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_valor_parc_rActionPerformed(evt);
            }
        });
        jTF_valor_parc_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_valor_parc_rKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Valor Quitado");

        jTF_valor_pago_r.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_valor_pago_r.setText("0.00");
        jTF_valor_pago_r.setFocusable(false);
        jTF_valor_pago_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_valor_pago_rKeyPressed(evt);
            }
        });

        jL_juros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_juros.setText("Juros(%)");

        jTF_juros.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_juros.setText("0.00");
        jTF_juros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_jurosFocusGained(evt);
            }
        });
        jTF_juros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_jurosKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Multa (%)");

        jTF_multa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_multa.setText("0.00");
        jTF_multa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_multaFocusGained(evt);
            }
        });
        jTF_multa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_multaKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Desc. (%)");

        jTF_desconto_r.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_desconto_r.setText("0.00");
        jTF_desconto_r.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_desconto_rFocusGained(evt);
            }
        });
        jTF_desconto_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_desconto_rKeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Valor a Pagar");

        jTF_valor_pagar_r.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTF_valor_pagar_r.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_valor_pagar_r.setText("0.00");
        jTF_valor_pagar_r.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_valor_pagar_rFocusGained(evt);
            }
        });
        jTF_valor_pagar_r.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_valor_pagar_rKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTF_valor_parc_r, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTF_valor_pago_r, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jL_juros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTF_juros, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTF_multa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTF_desconto_r)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTF_valor_pagar_r)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTF_desconto_r, jTF_juros, jTF_multa});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTF_valor_pagar_r, jTF_valor_pago_r, jTF_valor_parc_r});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_valor_pago_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_valor_parc_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jL_juros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_juros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_multa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_desconto_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_valor_pagar_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jB_cancelar_recebimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoCancelar.png"))); // NOI18N
        jB_cancelar_recebimento.setText("Excluir valores Recebidos");
        jB_cancelar_recebimento.setFocusable(false);
        jB_cancelar_recebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_cancelar_recebimentoActionPerformed(evt);
            }
        });

        jB_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jB_salvar.setText("Editar");
        jB_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvarActionPerformed(evt);
            }
        });

        jB_recibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_impressora.png"))); // NOI18N
        jB_recibo.setText("Recibo");
        jB_recibo.setFocusable(false);
        jB_recibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_reciboActionPerformed(evt);
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

        jB_quitar_receber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/money_dollar.png"))); // NOI18N
        jB_quitar_receber.setText("Quitar");
        jB_quitar_receber.setFocusable(false);
        jB_quitar_receber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_quitar_receberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jB_quitar_receber, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_fechar, jB_quitar_receber, jB_recibo});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_recibo)
                    .addComponent(jB_quitar_receber)
                    .addComponent(jB_fechar))
                .addGap(4, 4, 4))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_fechar, jB_quitar_receber, jB_recibo});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_cancelar_recebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_cancelar_recebimento, jB_salvar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_cancelar_recebimento)
                    .addComponent(jB_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_cancelar_recebimento, jB_salvar});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTF_referente_r, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTF_cod_cliente)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTF_nome_cliente_cr, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTF_lancamento_r)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTF_data_emissao_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTF_vencimento_r, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTF_data_pagamento_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_documento_r, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jTF_parcela_r)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel8, jTF_data_emissao_r, jTF_data_pagamento_r, jTF_vencimento_r});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_documento_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_lancamento_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_data_emissao_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_data_pagamento_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_vencimento_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_cod_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_parcela_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_nome_cliente_cr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTF_referente_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(610, 370));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_lancamento_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_lancamento_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_data_emissao_r.requestFocus();

        }
}//GEN-LAST:event_jTF_lancamento_rKeyPressed

    private void jTF_documento_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_documento_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_cod_cliente.requestFocus();
        }
}//GEN-LAST:event_jTF_documento_rKeyPressed

    private void jTF_nome_cliente_crKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_nome_cliente_crKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_parcela_r.requestFocus();
        }
}//GEN-LAST:event_jTF_nome_cliente_crKeyPressed

    private void jTF_cod_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_cod_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_nome_cliente_cr.requestFocus();
        }
}//GEN-LAST:event_jTF_cod_clienteKeyPressed

    private void jTF_parcela_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_parcela_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_referente_r.requestFocus();
        }
}//GEN-LAST:event_jTF_parcela_rKeyPressed

    private void jTF_referente_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_referente_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_valor_parc_r.requestFocus();
        }
}//GEN-LAST:event_jTF_referente_rKeyPressed

    private void jTF_valor_parc_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_valor_parc_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_valor_pago_r.requestFocus();
            jTF_valor_pago_r.selectAll();
        }
}//GEN-LAST:event_jTF_valor_parc_rKeyPressed

    private void jTF_valor_pago_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_valor_pago_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_juros.requestFocus();
        }
}//GEN-LAST:event_jTF_valor_pago_rKeyPressed

    private void jTF_jurosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_jurosFocusGained
        jTF_juros.selectAll();
}//GEN-LAST:event_jTF_jurosFocusGained

    private void jTF_jurosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_jurosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_multa.requestFocus();
        }
}//GEN-LAST:event_jTF_jurosKeyPressed

    private void jTF_desconto_rFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_desconto_rFocusGained
        jTF_desconto_r.selectAll();
}//GEN-LAST:event_jTF_desconto_rFocusGained

    private void jTF_desconto_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_desconto_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_valor_pagar_r.requestFocus();
        }
}//GEN-LAST:event_jTF_desconto_rKeyPressed

    private void jTF_valor_pagar_rFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_valor_pagar_rFocusGained
        BigDecimal valorp = new BigDecimal(jTF_valor_pago_r.getText());
        BigDecimal valor = new BigDecimal(jTF_valor_parc_r.getText());
        BigDecimal juros = new BigDecimal(jTF_juros.getText());
        BigDecimal desc = new BigDecimal(jTF_desconto_r.getText());
        BigDecimal multa = new BigDecimal(jTF_multa.getText());
        valor = valor.subtract(valorp);
        System.out.println(atraso);
        BigDecimal valor_pagar = valor.add(valor.multiply((juros.divide(new BigDecimal(100)))).multiply(new BigDecimal(atraso))).subtract(valor.multiply(desc).divide(new BigDecimal(100))).add(valor.multiply(multa).divide(new BigDecimal(100)));
        jTF_valor_pagar_r.setText(valor_pagar.setScale(2, RoundingMode.HALF_UP).toString());
}//GEN-LAST:event_jTF_valor_pagar_rFocusGained

    private void jTF_valor_pagar_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_valor_pagar_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && jTF_valor_pagar_r.isEditable()) {
            pagarParcelaReceber();
        }
}//GEN-LAST:event_jTF_valor_pagar_rKeyPressed

    private void jB_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_fecharActionPerformed
        dispose();
}//GEN-LAST:event_jB_fecharActionPerformed

    private void jTF_data_emissao_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_data_emissao_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_vencimento_r.requestFocus();
        }
}//GEN-LAST:event_jTF_data_emissao_rKeyPressed

    private void jTF_data_pagamento_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_data_pagamento_rKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_documento_r.requestFocus();
        }
}//GEN-LAST:event_jTF_data_pagamento_rKeyPressed

    private void jB_quitar_receberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_quitar_receberActionPerformed
        pagarParcelaReceber();
    }//GEN-LAST:event_jB_quitar_receberActionPerformed

    private void jTF_multaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_multaFocusGained
        jTF_multa.selectAll();
    }//GEN-LAST:event_jTF_multaFocusGained

    private void jB_reciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_reciboActionPerformed
        this.setModal(false);
        new RelatorioContasReceber().reciboContasReceber(par, contas);
    }//GEN-LAST:event_jB_reciboActionPerformed

    private void jB_cancelar_recebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_cancelar_recebimentoActionPerformed
        Object[] ops = {"SIM", "NÃO"};
        int r = JOptionPane.showOptionDialog(
                null, "Tem certeza que deseja cancelar os valores recebidos da parcela referida?", "Pergunta do Sistema", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, ops, ops[1]);
        if (r == 0) {
            try {
                //deleta historico recebimento
                Fachada.getInstancia().deletarHistoricoRecebimentoParcelasReceberJDBC(par);
                par.setData_pagamento(null);
                par.setStatus("NAO");
                par.setValor_pago(BigDecimal.ZERO);
                Fachada.getInstancia().editarParcelas_receberJDBC(par);
                JOptionPane.showMessageDialog(rootPane, "Recebimento cancelado com sucesso!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                jB_cancelar_recebimento.setEnabled(false);

            } catch (HeadlessException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
                JOptionPane.showMessageDialog(rootPane, "Erro ao cancelar recebimento! Erro: " + e.toString(), "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jB_cancelar_recebimentoActionPerformed

    private void jTF_multaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_multaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTF_desconto_r.requestFocus();
        }
    }//GEN-LAST:event_jTF_multaKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jTF_vencimento_rKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_vencimento_rKeyPressed
    }//GEN-LAST:event_jTF_vencimento_rKeyPressed

    private void jB_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvarActionPerformed
        Object[] ops = {"SIM", "NÃO"};
        int r = JOptionPane.showOptionDialog(
                null, "Tem certeza que deseja editar a data de vencimento da parcela?", "Pergunta do Sistema", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, ops, ops[1]);
        if (r == 0) {
            if (jTF_vencimento_r.isEditable()) {
                try {
                    par.setValor_pago(BigDecimal.ZERO);
                    Fachada.getInstancia().editarParcelas_receberJDBC(par);
                    JOptionPane.showMessageDialog(rootPane, "Vencimento editado com sucesso!", "ALERTA DO SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                    jB_salvar.setEnabled(false);

                } catch (HeadlessException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
                    JOptionPane.showMessageDialog(rootPane, "Erro ao cancelar recebimento! Erro: " + e.toString(), "ALERTA DO SISTEMA", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                jTF_vencimento_r.setEditable(true);
                jTF_vencimento_r.requestFocus();
                jTF_vencimento_r.selectAll();
            }
        }
    }//GEN-LAST:event_jB_salvarActionPerformed

    private void jTF_valor_parc_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_valor_parc_rActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_valor_parc_rActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConsultaContasReceberGUI dialog = new ConsultaContasReceberGUI(new javax.swing.JFrame(), false, null, null, true);
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
    private javax.swing.JButton jB_cancelar_recebimento;
    private javax.swing.JButton jB_fechar;
    private javax.swing.JButton jB_quitar_receber;
    private javax.swing.JButton jB_recibo;
    private javax.swing.JButton jB_salvar;
    private javax.swing.JLabel jL_juros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTF_cod_cliente;
    private javax.swing.JFormattedTextField jTF_data_emissao_r;
    private javax.swing.JFormattedTextField jTF_data_pagamento_r;
    private javax.swing.JTextField jTF_desconto_r;
    private javax.swing.JTextField jTF_documento_r;
    private javax.swing.JTextField jTF_juros;
    private javax.swing.JTextField jTF_lancamento_r;
    private javax.swing.JTextField jTF_multa;
    private javax.swing.JTextField jTF_nome_cliente_cr;
    private javax.swing.JTextField jTF_parcela_r;
    private javax.swing.JTextField jTF_referente_r;
    private javax.swing.JTextField jTF_valor_pagar_r;
    private javax.swing.JTextField jTF_valor_pago_r;
    private javax.swing.JTextField jTF_valor_parc_r;
    private javax.swing.JFormattedTextField jTF_vencimento_r;
    // End of variables declaration//GEN-END:variables

    public void pagarParcelaReceber() {
        if (JOptionPane.showConfirmDialog(null, "Deseja realizar o pagamento da parcela?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            String status = "PG";
            BigDecimal restante = BigDecimal.ZERO;
            BigDecimal valorPagar = new BigDecimal(jTF_valor_pagar_r.getText());
            BigDecimal valorParcela = new BigDecimal(jTF_valor_parc_r.getText());
            FinanceiroRecPag parcelas_receber_historico_recebimento = null;
            try {
                if (Double.parseDouble(jTF_valor_pagar_r.getText()) + Double.parseDouble(jTF_valor_pago_r.getText()) == Double.parseDouble(jTF_valor_parc_r.getText())) {
                    par.setValor_pago(new BigDecimal(jTF_valor_parc_r.getText()));
                    status = "PG";
                    parcelas_receber_historico_recebimento = new FinanceiroRecPag();
                    parcelas_receber_historico_recebimento.setData_recebimento(dateNow);
                    parcelas_receber_historico_recebimento.setId_parcelas_receber(par.getId());
                    parcelas_receber_historico_recebimento.setValor_recebido(new BigDecimal(jTF_valor_pagar_r.getText()));
                    parcelas_receber_historico_recebimento.setHora_recebimento(fmtHora.format(new Date()));
                } else if (valorPagar.setScale(2, RoundingMode.HALF_DOWN).compareTo(valorParcela.setScale(2, RoundingMode.HALF_DOWN)) == -1) {
                    status = "PG PARCIAL";
                    BigDecimal valorPago = new BigDecimal(jTF_valor_pagar_r.getText()).add(new BigDecimal(jTF_valor_pago_r.getText()));
                    restante = new BigDecimal(jTF_valor_parc_r.getText()).subtract(valorPago);
                    par.setValor_pago(valorPago);
                    parcelas_receber_historico_recebimento = new FinanceiroRecPag();
                    parcelas_receber_historico_recebimento.setData_recebimento(dateNow);
                    parcelas_receber_historico_recebimento.setId_parcelas_receber(par.getId());
                    parcelas_receber_historico_recebimento.setValor_recebido(new BigDecimal(jTF_valor_pagar_r.getText()));
                    parcelas_receber_historico_recebimento.setHora_recebimento(fmtHora.format(new Date()));
                } else if (Double.parseDouble(jTF_valor_pagar_r.getText()) > Double.parseDouble(jTF_valor_parc_r.getText())) {
                    par.setValor_pago(new BigDecimal(jTF_valor_pagar_r.getText()));
                    parcelas_receber_historico_recebimento = new FinanceiroRecPag();
                    parcelas_receber_historico_recebimento.setData_recebimento(dateNow);
                    parcelas_receber_historico_recebimento.setId_parcelas_receber(par.getId());
                    parcelas_receber_historico_recebimento.setValor_recebido(new BigDecimal(jTF_valor_pagar_r.getText()));
                    parcelas_receber_historico_recebimento.setHora_recebimento(fmtHora.format(new Date()));
                }
                if (parcelas_receber_historico_recebimento != null) {
                    Fachada.getInstancia().incluirHistoricoRecebimentoParcelasReceberJDBC(parcelas_receber_historico_recebimento);
                    par.setData_pagamento(dateNow);
                    par.setStatus(status);

                    Fachada.getInstancia().editarParcelas_receberJDBC(par);
                    JOptionPane.showMessageDialog(null, "PARCELA PAGA!", "Pergunta do Sistema", JOptionPane.INFORMATION_MESSAGE);

                    if (JOptionPane.showConfirmDialog(null, "Deseja emitir um relatório de quitação?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        this.setModal(false);
                    }
                    dispose();
                }
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "<null>", e);
                JOptionPane.showMessageDialog(null, "ERRO: " + e.toString());
            }
        }
    }

    public void deletarParcelasReceber() {
        int i = 0;
        ArrayList lista = Fachada.getInstancia().consultarContaReceberQuery("select * from contas_receber where id = " + contas.getId());
        while (lista.size() > i) {
            FinanceiroParcelas p = (FinanceiroParcelas) lista.get(i);
            Fachada.getInstancia().deletarParcelasReceberJDBC(p);
            i++;
        }
    }

    private void travaCampos(boolean trava, JPanel panel) {
        for (Component c : panel.getComponents()) {
            if (c instanceof JPanel) {
                travaCampos(trava, (JPanel) c);
            }
            if (c instanceof JTextField) {
                ((JTextField) c).setEditable(trava);
            }
            if (c instanceof JButton) {
                ((JButton) c).setEnabled(trava);
            }
            jB_recibo.setEnabled(true);
            jB_fechar.setEnabled(true);
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
}
