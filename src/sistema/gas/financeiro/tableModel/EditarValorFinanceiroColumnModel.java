package sistema.gas.financeiro.tableModel;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class EditarValorFinanceiroColumnModel extends DefaultTableColumnModel {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public EditarValorFinanceiroColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 120, fm, false, "Dt. Vcto."));
        addColumn(criaColuna(1, 100, fm, false, "Valor"));
        addColumn(criaColuna(2, 100, fm, false, "Status"));
    }

    private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + "  ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }

        TableColumn col = new TableColumn(columnIndex);
        col.setCellRenderer(new CellRendererEditarValorFinanceiro());
        col.setHeaderRenderer(null);
        col.setHeaderValue(titulo);
        col.setPreferredWidth(largura);
        if (!resizable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizable);
        return col;
    }
}
