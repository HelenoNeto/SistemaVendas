package sistema.gas.municipio.tableModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class CellRendererMunicipio extends DefaultTableCellRenderer {

    public CellRendererMunicipio() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(javax.swing.JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

        Color corFundoZebrado = new Color(240, 240, 240);
        Color corFundoNormal = new Color(255, 255, 230);

        label.setFont(new java.awt.Font("Tahoma", 0, 12));

        if ((row % 2) == 0) {
            label.setBackground(corFundoNormal);
        } else {
            label.setBackground(corFundoZebrado);
        }

        if (isSelected) {
            label.setBackground(Color.BLACK);
        }

        switch (column) {
            case 0:
                label.setHorizontalAlignment(RIGHT);
                break;
            case 2:
                label.setHorizontalAlignment(CENTER);
                break;
            default:
                label.setHorizontalAlignment(LEFT);
                break;
        }

        return label;
    }
}
