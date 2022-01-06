/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.awt.FontMetrics;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Administrador
 */
public class JTableModel {

    public static void ajustarColunas(JTable tabela) {
        tabela.setAutoResizeMode(0);
        FontMetrics fm = tabela.getGraphics().getFontMetrics();
        int row = tabela.getRowCount();
        int column = tabela.getColumnCount();
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                String columnName = String.valueOf(tabela.getValueAt(i, j));
                TableColumn col = tabela.getColumnModel().getColumn(j);
                col.setMinWidth(fm.stringWidth(columnName) + 10);
            }
        }
    }
}