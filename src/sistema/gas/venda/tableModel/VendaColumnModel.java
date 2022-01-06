package sistema.gas.venda.tableModel;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class VendaColumnModel extends DefaultTableColumnModel {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public VendaColumnModel(FontMetrics fm) {
        int i = 0;
        addColumn(criaColuna(i++, 60, fm, true, "Código"));
        addColumn(criaColuna(i++, 130, fm, true, "Data"));
        addColumn(criaColuna(i++, 100, fm, true, "Vendedor"));
        addColumn(criaColuna(i++, 200, fm, true, "Cliente"));
        addColumn(criaColuna(i++, 100, fm, true, "Tipo Pagamento"));
        addColumn(criaColuna(i++, 80, fm, true, "Subtotal"));
        addColumn(criaColuna(i++, 80, fm, true, "Desconto"));
        addColumn(criaColuna(i++, 80, fm, true, "Acréscimo"));
        addColumn(criaColuna(i++, 80, fm, true, "Total"));
    }

    private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + "  ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }

        TableColumn col = new TableColumn(columnIndex);
        col.setCellRenderer(new CellRendererVenda());
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
