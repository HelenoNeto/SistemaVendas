package sistema.gas.venda.tableModel;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class VendaItensColumnModel extends DefaultTableColumnModel {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public VendaItensColumnModel(FontMetrics fm) {
        int i = 0;
        addColumn(criaColuna(i++, 60, fm, false, "Código"));
        addColumn(criaColuna(i++, 250, fm, false, "Descrição"));
        addColumn(criaColuna(i++, 80, fm, false, "Unidade"));
        addColumn(criaColuna(i++, 80, fm, false, "Quantidade"));
        addColumn(criaColuna(i++, 80, fm, false, "Valor Uni."));
        addColumn(criaColuna(i++, 80, fm, false, "Total"));
        addColumn(criaColuna(i++, 100, fm, false, "Debito de vasilhame?"));
        addColumn(criaColuna(i++, 110, fm, false, "Qtd. Vas. Pend."));
        addColumn(criaColuna(i++, 110, fm, false, "Qtd. Vas. Vazio"));
    }

    private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + "  ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }

        TableColumn col = new TableColumn(columnIndex);
        col.setCellRenderer(new CellRendererVendaItens());
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
