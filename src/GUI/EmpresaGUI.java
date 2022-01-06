package GUI;

import Negocios.Empresa;
import Negocios.Fachada;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sistema.gas.cliente.gui.ClienteDialogGUI;

public class EmpresaGUI extends javax.swing.JFrame {

    String data_atual = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    Empresa e = null;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public EmpresaGUI() {
        initComponents();

        jTP_Emitente.setSelectedIndex(0);
        jP_Emitente.hasFocus();
        jTF_razao_social.requestFocus();

        Empresa emitentes = Fachada.getInstancia().consultarEmpresa("SELECT * FROM empresa WHERE id = (SELECT MAX(id) FROM empresa)");
        if (emitentes == null) {
            jB_salvar_editar.setText("Salvar");
            jTF_cnpj.setEnabled(true);
            jTF_ie.setText("");
            jTF_ie.setEnabled(true);

            jTF_cpf.setEnabled(false);
            jTF_rg.setEnabled(false);
        } else {
            mostrarEmitente();
            jB_salvar_editar.setText("Editar");
        }
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Utilitarios.Dir.imagens_internas + "icone.png"));

        jTF_data_cadastro.setText(data_atual);

        HashSet conj = new HashSet(jP_Emitente.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        jP_Emitente.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoDoc = new javax.swing.ButtonGroup();
        jTP_Emitente = new javax.swing.JTabbedPane();
        jP_Emitente = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTF_data_cadastro = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTF_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTF_razao_social = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTF_nome_fantasia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTF_endereco = new javax.swing.JTextField();
        jTF_numero = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTF_complemento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTF_bairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTF_municipio = new javax.swing.JTextField();
        jL_nome_municipio = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jL_uf = new javax.swing.JLabel();
        jB_procura_municipio = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTF_codigo_pais = new javax.swing.JTextField();
        jL_nome_pais = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTF_ie = new javax.swing.JTextField();
        jTF_rg = new javax.swing.JTextField();
        jRB_cnpj = new javax.swing.JRadioButton();
        jRB_cpf = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTF_cnpj = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jTF_cpf = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jB_salvar_editar = new javax.swing.JButton();
        jB_Cancelar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jTF_email = new javax.swing.JTextField();
        jTF_cep = new javax.swing.JFormattedTextField();
        jTF_telefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Empresa");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTP_Emitente.setBackground(new java.awt.Color(255, 255, 255));

        try {
            jTF_data_cadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Data cadastro:");

        jLabel14.setText("Codigo Interno:");

        jTF_id.setEditable(false);
        jTF_id.setFocusable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Razão social:");

        jTF_razao_social.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_razao_socialFocusLost(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fantasia:");

        jTF_nome_fantasia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_nome_fantasiaFocusLost(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("* Endereço:");

        jTF_endereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_enderecoFocusLost(evt);
            }
        });

        jTF_numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_numeroFocusLost(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Nº:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Complemento:");

        jTF_complemento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_complementoFocusLost(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Bairro:");

        jTF_bairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTF_bairroFocusLost(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Município:");

        jTF_municipio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_municipio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTF_municipioMouseClicked(evt);
            }
        });
        jTF_municipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_municipioKeyPressed(evt);
            }
        });

        jL_nome_municipio.setForeground(new java.awt.Color(255, 0, 0));
        jL_nome_municipio.setText("MUNICIPIO");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("UF: ");

        jL_uf.setForeground(new java.awt.Color(255, 0, 0));
        jL_uf.setText("UF");

        jB_procura_municipio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sport_raquet.png"))); // NOI18N
        jB_procura_municipio.setBorderPainted(false);
        jB_procura_municipio.setContentAreaFilled(false);
        jB_procura_municipio.setFocusable(false);
        jB_procura_municipio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_procura_municipioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jB_procura_municipioMouseExited(evt);
            }
        });
        jB_procura_municipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_procura_municipioActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("País:");

        jTF_codigo_pais.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTF_codigo_pais.setText("1058");

        jL_nome_pais.setForeground(new java.awt.Color(255, 0, 0));
        jL_nome_pais.setText("BRASIL");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("* CEP:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Telefone:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Documentos"));

        buttonGroupTipoDoc.add(jRB_cnpj);
        jRB_cnpj.setSelected(true);
        jRB_cnpj.setText("CNPJ");
        jRB_cnpj.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRB_cnpjItemStateChanged(evt);
            }
        });

        buttonGroupTipoDoc.add(jRB_cpf);
        jRB_cpf.setText("CPF");
        jRB_cpf.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRB_cpfItemStateChanged(evt);
            }
        });

        jLabel11.setText("CNPJ:");

        jLabel12.setText("IE:");

        try {
            jTF_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel13.setText("CPF:");

        try {
            jTF_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel17.setText("RG:");

        jLabel18.setText("Tipo de documento:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRB_cnpj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRB_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTF_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTF_ie, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTF_rg))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRB_cnpj)
                    .addComponent(jRB_cpf)
                    .addComponent(jLabel18))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTF_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTF_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTF_rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTF_ie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jB_salvar_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/disk.png"))); // NOI18N
        jB_salvar_editar.setText("Salvar");
        jB_salvar_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_salvar_editarActionPerformed(evt);
            }
        });

        jB_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        jB_Cancelar.setText("Cancelar");
        jB_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CancelarActionPerformed(evt);
            }
        });

        jLabel19.setText("Email:");

        try {
            jTF_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTF_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_salvar_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jB_Cancelar)
                .addGap(169, 169, 169))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTF_id, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTF_razao_social)
                    .addComponent(jTF_nome_fantasia)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTF_endereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTF_complemento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTF_codigo_pais, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jTF_municipio))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jL_nome_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jB_procura_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(jL_nome_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jL_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTF_email)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTF_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTF_codigo_pais, jTF_data_cadastro, jTF_id, jTF_municipio, jTF_numero});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jB_Cancelar, jB_salvar_editar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jTF_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTF_razao_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTF_nome_fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTF_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTF_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTF_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTF_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jL_nome_municipio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jL_uf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jB_procura_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTF_codigo_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_nome_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jTF_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTF_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_salvar_editar)
                    .addComponent(jB_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_procura_municipio, jL_nome_municipio, jL_uf, jLabel7, jTF_codigo_pais, jTF_data_cadastro, jTF_id, jTF_municipio, jTF_numero});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jB_Cancelar, jB_salvar_editar});

        javax.swing.GroupLayout jP_EmitenteLayout = new javax.swing.GroupLayout(jP_Emitente);
        jP_Emitente.setLayout(jP_EmitenteLayout);
        jP_EmitenteLayout.setHorizontalGroup(
            jP_EmitenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_EmitenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jP_EmitenteLayout.setVerticalGroup(
            jP_EmitenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_EmitenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTP_Emitente.addTab("Cadastro", jP_Emitente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_Emitente)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTP_Emitente, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(602, 518));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_salvar_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_salvar_editarActionPerformed
        try {
            if (jB_salvar_editar.getText().equals("Salvar")) {
                salvarEmitente();
            } else {
                editarEmitente();
            }
        } catch (ParseException ex) {
            Logger.getLogger(EmpresaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_salvar_editarActionPerformed

    private void jB_procura_municipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_procura_municipioActionPerformed
        MunicipiosDialog municipiosDialog = new MunicipiosDialog(this, true);
        municipiosDialog.setLocationRelativeTo(null);
        municipiosDialog.setVisible(true);
        if (municipiosDialog.importarMunicipio() != null) {
            jTF_municipio.setText(municipiosDialog.importarMunicipio().getCodigo_cidade());
            jL_nome_municipio.setText(municipiosDialog.importarMunicipio().getNome());
            jL_uf.setText(municipiosDialog.importarMunicipio().getUf());
            jTF_codigo_pais.requestFocus();
        }
    }//GEN-LAST:event_jB_procura_municipioActionPerformed

    private void jB_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jB_CancelarActionPerformed

    private void jTF_municipioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTF_municipioMouseClicked
        jB_procura_municipioActionPerformed(null);
    }//GEN-LAST:event_jTF_municipioMouseClicked

    private void jTF_razao_socialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_razao_socialFocusLost
        jTF_razao_social.setText(normalizaText(jTF_razao_social.getText()));
    }//GEN-LAST:event_jTF_razao_socialFocusLost

    private void jTF_nome_fantasiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_nome_fantasiaFocusLost
        jTF_nome_fantasia.setText(normalizaText(jTF_nome_fantasia.getText()));
    }//GEN-LAST:event_jTF_nome_fantasiaFocusLost

    private void jTF_enderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_enderecoFocusLost
        jTF_endereco.setText(normalizaText(jTF_endereco.getText()));
    }//GEN-LAST:event_jTF_enderecoFocusLost

    private void jTF_bairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_bairroFocusLost
        jTF_bairro.setText(normalizaText(jTF_bairro.getText()));
    }//GEN-LAST:event_jTF_bairroFocusLost

    private void jTF_municipioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_municipioKeyPressed
        jB_procura_municipioActionPerformed(null);
    }//GEN-LAST:event_jTF_municipioKeyPressed

    private void jTF_numeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_numeroFocusLost
        jTF_numero.setText(normalizaText(jTF_numero.getText()));
    }//GEN-LAST:event_jTF_numeroFocusLost

    private void jTF_complementoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_complementoFocusLost
        jTF_complemento.setText(normalizaText(jTF_complemento.getText()));
    }//GEN-LAST:event_jTF_complementoFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jB_procura_municipioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_procura_municipioMouseEntered
        jB_procura_municipio.setContentAreaFilled(true);
    }//GEN-LAST:event_jB_procura_municipioMouseEntered

    private void jB_procura_municipioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_procura_municipioMouseExited
        jB_procura_municipio.setContentAreaFilled(false);
    }//GEN-LAST:event_jB_procura_municipioMouseExited

    private void jRB_cnpjItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRB_cnpjItemStateChanged
        if (jRB_cnpj.isSelected()) {
            jTF_cnpj.setEnabled(true);
            jTF_ie.setText("");
            jTF_ie.setEnabled(true);

            jTF_cpf.setValue(null);
            jTF_rg.setText("");
            jTF_cpf.setEnabled(false);
            jTF_rg.setEnabled(false);
        } else if (jRB_cpf.isSelected()) {
            jTF_cpf.setEnabled(true);
            jTF_rg.setEnabled(true);

            jTF_cnpj.setValue(null);
            jTF_cnpj.setEnabled(false);
            jTF_ie.setText("ISENTO");
            jTF_ie.setEnabled(false);
        }
    }//GEN-LAST:event_jRB_cnpjItemStateChanged

    private void jRB_cpfItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRB_cpfItemStateChanged
        if (jRB_cnpj.isSelected()) {
            jTF_cnpj.setEnabled(true);
            jTF_ie.setText("");
            jTF_ie.setEnabled(true);

            jTF_cpf.setValue(null);
            jTF_cpf.setEnabled(false);
            jTF_rg.setEnabled(false);
        } else if (jRB_cpf.isSelected()) {
            jTF_cpf.setEnabled(true);
            jTF_rg.setEnabled(true);

            jTF_cnpj.setValue(null);
            jTF_cnpj.setEnabled(false);
            jTF_ie.setText("ISENTO");
            jTF_ie.setEnabled(false);
        }
    }//GEN-LAST:event_jRB_cpfItemStateChanged

    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmpresaGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipoDoc;
    private javax.swing.JButton jB_Cancelar;
    private javax.swing.JButton jB_procura_municipio;
    private javax.swing.JButton jB_salvar_editar;
    private javax.swing.JLabel jL_nome_municipio;
    private javax.swing.JLabel jL_nome_pais;
    private javax.swing.JLabel jL_uf;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_Emitente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRB_cnpj;
    private javax.swing.JRadioButton jRB_cpf;
    private javax.swing.JTextField jTF_bairro;
    private javax.swing.JFormattedTextField jTF_cep;
    private javax.swing.JFormattedTextField jTF_cnpj;
    private javax.swing.JTextField jTF_codigo_pais;
    private javax.swing.JTextField jTF_complemento;
    private javax.swing.JFormattedTextField jTF_cpf;
    private javax.swing.JFormattedTextField jTF_data_cadastro;
    private javax.swing.JTextField jTF_email;
    private javax.swing.JTextField jTF_endereco;
    private javax.swing.JTextField jTF_id;
    private javax.swing.JTextField jTF_ie;
    private javax.swing.JTextField jTF_municipio;
    private javax.swing.JTextField jTF_nome_fantasia;
    private javax.swing.JTextField jTF_numero;
    private javax.swing.JTextField jTF_razao_social;
    private javax.swing.JTextField jTF_rg;
    private javax.swing.JFormattedTextField jTF_telefone;
    private javax.swing.JTabbedPane jTP_Emitente;
    // End of variables declaration//GEN-END:variables

    public void salvarEmitente() throws ParseException {
        if (campoObrigatorioVazio()) {
        } else {
            jRB_cnpj.setActionCommand("CNPJ");
            jRB_cpf.setActionCommand("CPF");

            Empresa empresa = new Empresa();
            empresa.setData_cadastro(new Date());
            empresa.setRazao_social(jTF_razao_social.getText());
            empresa.setNome_fantasia(jTF_nome_fantasia.getText());
            empresa.setEndereco(jTF_endereco.getText());
            empresa.setNum_end(jTF_numero.getText());
            empresa.setBairro(jTF_bairro.getText());
            empresa.setComp_end(jTF_complemento.getText());
            empresa.setMunicipio(jL_nome_municipio.getText());
            empresa.setCod_municipio(jTF_municipio.getText());
            empresa.setUf(jL_uf.getText());
            empresa.setCep(jTF_cep.getText().replaceAll("[^0-9]", ""));
            empresa.setTelefone(jTF_telefone.getText().replaceAll("[^0-9]", ""));
            empresa.setTipo_documento(buttonGroupTipoDoc.getSelection().getActionCommand());
            empresa.setCod_pais(jTF_codigo_pais.getText());
            empresa.setPais(jL_nome_pais.getText());
            empresa.setCnpj(jTF_cnpj.getText().replaceAll("[^0-9]", ""));
            empresa.setIe(jTF_ie.getText());
            empresa.setCpf(jTF_cpf.getText().replaceAll("[^0-9]", ""));
            empresa.setRg(jTF_rg.getText().replaceAll("[^0-9]", ""));
            empresa.setEmail(jTF_email.getText());

            try {
                Fachada.getInstancia().incluirEmpresa(empresa);
                JOptionPane.showMessageDialog(null, "Empresa salva com sucesso!");
                jB_salvar_editar.setText("Editar");
                mostrarEmitente();
            } catch (HeadlessException exc) {
                JOptionPane.showMessageDialog(null, "não foi possivel salvar a empresa!");
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exc);
            }
        }
    }

    private void mostrarEmitente() {
        e = Fachada.getInstancia().consultarEmpresa("SELECT * FROM empresa WHERE ID = (SELECT MAX(id) FROM empresa)");
        jTF_id.setText(String.valueOf(e.getId()));
        jTF_bairro.setText(e.getBairro());
        jTF_cep.setText(e.getCep());
        jTF_complemento.setText(e.getComp_end());
        jTF_endereco.setText(e.getEndereco());

        if (e.getTipo_documento().equals("CNPJ")) {
            jRB_cnpj.setSelected(true);
        } else {
            jRB_cpf.setSelected(true);
        }

        jTF_cnpj.setText(e.getCnpj());
        jTF_ie.setText(e.getIe());
        jTF_cpf.setText(e.getCpf());
        jTF_rg.setText(e.getRg());

        jTF_municipio.setText(e.getCod_municipio());
        jTF_nome_fantasia.setText(e.getNome_fantasia());
        jTF_numero.setText(e.getNum_end());
        jTF_codigo_pais.setText(e.getCod_pais());
        jTF_razao_social.setText(e.getRazao_social());
        jTF_telefone.setText(e.getTelefone());
        jL_nome_municipio.setText(e.getMunicipio());
        jL_nome_pais.setText(e.getPais());
        jL_uf.setText(e.getUf());
        jTF_email.setText(e.getEmail());
    }

    public void editarEmitente() throws ParseException {
        jRB_cnpj.setActionCommand("CNPJ");
        jRB_cpf.setActionCommand("CPF");
        if (campoObrigatorioVazio()) {
        } else {
            e.setRazao_social(jTF_razao_social.getText());
            e.setNome_fantasia(jTF_nome_fantasia.getText());
            e.setEndereco(jTF_endereco.getText());
            e.setNum_end(jTF_numero.getText());
            e.setBairro(jTF_bairro.getText());
            e.setComp_end(jTF_complemento.getText());
            e.setMunicipio(jL_nome_municipio.getText());
            e.setCod_municipio(jTF_municipio.getText());
            e.setUf(jL_uf.getText());
            e.setCep(jTF_cep.getText().replaceAll("[^0-9]", ""));
            e.setTelefone(jTF_telefone.getText());
            e.setTipo_documento(buttonGroupTipoDoc.getSelection().getActionCommand());
            e.setCod_pais(jTF_codigo_pais.getText());
            e.setPais(jL_nome_pais.getText());
            e.setCnpj(jTF_cnpj.getText().replaceAll("[^0-9]", ""));
            e.setIe(jTF_ie.getText());
            e.setCpf(jTF_cpf.getText().replaceAll("[^0-9]", ""));
            e.setRg(jTF_rg.getText().replaceAll("[^0-9]", ""));
            e.setEmail(jTF_email.getText());
            try {
                Fachada.getInstancia().editarEmpresa(e);
                JOptionPane.showMessageDialog(null, "Empresa editada com sucesso!");
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possivel editar a empresa!");
                e.printStackTrace();
            }
        }
    }

    private String normalizaText(String text) {
        if (text.isEmpty()) {
            return text;
        } else {
            String textAux = text;
            textAux = Normalizer.normalize(textAux, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            textAux = textAux.replaceAll("\\.|,|\\(|\\)|;|:|~|\\^|//|-|&|\"|'|=|!|@|#|\\$|%|/|_|°|£|¢|¬|/(|)|\\[|\\]|\\<|\\>|º|¹|²|³|\\{|\\}|\\*|\\+|\\?", "");
            textAux = textAux.toUpperCase();
            textAux = textAux.replaceAll("\\s+", " ");
            textAux = textAux.replaceAll("^\\s+", "");
            textAux = textAux.replaceAll("\\s+$", "");
            return textAux;
        }
    }

    private String normalizaNum(String text) {
        if (text.isEmpty()) {
            return text;
        } else {
            String textAux = text;
            textAux = Normalizer.normalize(textAux, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            textAux = textAux.replaceAll("\\(|\\)|;|:|~|\\^|//|-|&|\"|'|=|!|@|#|\\$|%|/|_|°|£|¢|¬|/(|)|\\[|\\]|\\<|\\>|º|¹|²|³|\\{|\\}|\\*|\\+|\\?"/*
                     *
                     */, "");
            textAux = textAux.toUpperCase();
            textAux = textAux.replaceAll("[A-Z]", "");
            textAux = textAux.replaceAll("\\s+", " ");
            textAux = textAux.replaceAll("^\\s+", "");
            textAux = textAux.replaceAll("\\s+$", "");
            textAux = textAux.replaceAll(",", ".");
            //textAux = String.valueOf(Integer.valueOf(textAux));
            return textAux;
        }
    }

    private boolean campoObrigatorioVazio() {

        JTextField campos[] = {jTF_razao_social, jTF_endereco, jTF_numero, jTF_bairro, jTF_municipio, jTF_cep, jTF_ie, jTF_telefone, jTF_nome_fantasia};
        boolean temCampoVazio = false;

        for (JTextField jTextField : campos) {
            if (jTextField.getText().isEmpty()) {
                jTextField.setBackground(Color.yellow);
                temCampoVazio = true;
            } else {
                jTextField.setBackground(null);
            }
        }

        if (temCampoVazio) {
            JOptionPane.showMessageDialog(null, "CAMPO OBRIGATÓRIO EM BRANCO!", null, 2);
            return true;
        } else {
            return false;
        }
    }
}
