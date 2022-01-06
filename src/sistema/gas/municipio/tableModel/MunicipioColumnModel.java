package sistema.gas.municipio.tableModel;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class MunicipioColumnModel extends DefaultTableColumnModel {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MunicipioColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 60, fm, false, "Código"));
        addColumn(criaColuna(1, 200, fm, false, "Nome"));
        addColumn(criaColuna(2, 30, fm, false, "UF"));
    }

    private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + "  ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }

        TableColumn col = new TableColumn(columnIndex);
        col.setCellRenderer(new CellRendererMunicipio());
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
