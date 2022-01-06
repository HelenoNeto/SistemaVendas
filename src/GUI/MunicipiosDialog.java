package GUI;

import Negocios.Municipios;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import sistema.gas.municipio.dados.ConectaBDMunicipio;
import sistema.gas.municipio.tableModel.MunicipioColumnModel;
import sistema.gas.municipio.tableModel.TableModelMunicipio;

public class MunicipiosDialog extends javax.swing.JDialog {

    private TableModelMunicipio model;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MunicipiosDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Utilitarios.Dir.imagens_internas + "icone.png"));
        configuraTableModel();
        listarMunicipios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jT_municipios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTF_busca = new javax.swing.JTextField();
        jB_pesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Municípios");

        jT_municipios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "UF", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_municipios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_municipiosMouseClicked(evt);
            }
        });
        jT_municipios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_municipiosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jT_municipios);
        if (jT_municipios.getColumnModel().getColumnCount() > 0) {
            jT_municipios.getColumnModel().getColumn(0).setResizable(false);
            jT_municipios.getColumnModel().getColumn(1).setResizable(false);
            jT_municipios.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setText("Consultar:");

        jTF_busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTF_buscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTF_buscaKeyReleased(evt);
            }
        });

        jB_pesquisar.setText("...");
        jB_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_pesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTF_busca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTF_busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_pesquisar))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_buscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_buscaKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                if (jT_municipios.getRowCount() > 0) {
                    jT_municipios.addRowSelectionInterval(0, 0);
                    jT_municipios.requestFocus();
                }
                break;
            case KeyEvent.VK_ENTER:
                pesquisar();
                break;
            case KeyEvent.VK_ESCAPE:
                dispose();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jTF_buscaKeyPressed

    private void jB_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_pesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_jB_pesquisarActionPerformed

    private void jT_municipiosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_municipiosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
            dispose();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }//GEN-LAST:event_jT_municipiosKeyPressed

    private void jT_municipiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_municipiosMouseClicked
        if (evt.getClickCount() == 2) {
            dispose();
        }
    }//GEN-LAST:event_jT_municipiosMouseClicked

    private void jTF_buscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTF_buscaKeyReleased
        pesquisar();
    }//GEN-LAST:event_jTF_buscaKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MunicipiosDialog dialog = new MunicipiosDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jB_pesquisar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_busca;
    private javax.swing.JTable jT_municipios;
    // End of variables declaration//GEN-END:variables

    private void listarMunicipios() {
        ArrayList<Municipios> lista = ConectaBDMunicipio.getInstance().consultarMunicipiosTipo("codigo", "%%");
        model.addAll(lista);
    }

    public void pesquisar() {
        ArrayList<Municipios> lista = ConectaBDMunicipio.getInstance().consultarMunicipiosTipo("nome", jTF_busca.getText());
        model.addAll(lista);
    }

    public Municipios importarMunicipio() {
        int rowSelected = model.getLinhaSelectionada();
        if (rowSelected > -1) {
            return model.getMunicipios(rowSelected);
        }
        return null;
    }

    private void configuraTableModel() {
        jT_municipios.setModel(new TableModelMunicipio(jT_municipios));
        jT_municipios.setSelectionModel(new DefaultListSelectionModel() {

            @Override
            public String toString() {
                return "jT_municipios";
            }
        });

        jT_municipios.setAutoCreateColumnsFromModel(false);
        jT_municipios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        FontMetrics fm = jT_municipios.getFontMetrics(jT_municipios.getFont());
        jT_municipios.setColumnModel(new MunicipioColumnModel(fm));
        jT_municipios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        model = (TableModelMunicipio) jT_municipios.getModel();
    }
}
