package sistema.gas.financeiro.tableModel;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class FinanceiroColumnModel extends DefaultTableColumnModel {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public FinanceiroColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 100, fm, false, "Id. Conta"));
        addColumn(criaColuna(1, 100, fm, false, "Id. Parcela"));
        addColumn(criaColuna(2, 100, fm, false, "Lançamento"));
        addColumn(criaColuna(3, 100, fm, false, "Status"));
        addColumn(criaColuna(4, 100, fm, false, "Parcela"));
        addColumn(criaColuna(5, 120, fm, false, "Dt. Vcto."));
        addColumn(criaColuna(6, 100, fm, false, "Valor"));
        addColumn(criaColuna(7, 100, fm, false, "Valor PG."));
        addColumn(criaColuna(8, 100, fm, false, "Restante"));
        addColumn(criaColuna(9, 120, fm, false, "Dt. Pgto."));
    }

    private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + "  ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }

        TableColumn col = new TableColumn(columnIndex);
        col.setCellRenderer(new CellRendererFinanceiro());
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
