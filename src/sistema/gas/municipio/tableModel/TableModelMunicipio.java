/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.municipio.tableModel;

import Negocios.Municipios;
import Utilitarios.JTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Heleno
 */
public class TableModelMunicipio extends AbstractTableModel {

    private List<Municipios> tDesmCab;
    private JTable tabela = null;

    // Construtor da classe recebe os dados a ser populado
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public TableModelMunicipio(List<Municipios> mf, JTable jTable) {
        tabela = jTable;
        tDesmCab = new ArrayList<>(mf);
        fireTableStructureChanged();
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public TableModelMunicipio(JTable jTable) {
        tabela = jTable;
        tDesmCab = new ArrayList<>();
        fireTableStructureChanged();
    }

    // Método sobrescrito que retorna o número de linhas do JTable, após populado
    @Override
    public int getRowCount() {
        return tDesmCab.size();
    }

    // Método sobrescrito que vai popular e retornar cada célula do JTable
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Municipios tp = tDesmCab.get(rowIndex);
        Object row = null;
        switch (columnIndex) {
            case 0:
                row = tp.getCodigo_cidade();
                break;
            case 1:
                row = tp.getNome();
                break;
            case 2:
                row = tp.getUf();
                break;
        }
        return row;
    }

    /* Este método sobrescrito, defini se o JTable será editável ou não.
     Voce pode definir qual coluna de qual linha será editável. Caso voce
     defina que o seu JTable seja editável, então é necessário definir também
     o método "setValueAt" que vem logo a seguir,  caso contrário, é só retornar
     false para todas as linhas e colunas, como definido abaixo. */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    // Este método sobrescrito defini que tipo de dado será retornado para cada coluna
    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
            case 1:
            case 2:
                return Integer.class;
            default:
                return String.class;
        }
    }

    /* Este método criado por nós, vai retornar o conjunto
     de dados inteiro do JTable, através de um List contendo
     Objetos ClienteBean populados. */
    public List<Municipios> getDataSet() {
        return tDesmCab;
    }

    /* Este método sobrescrito vai definir o nome das colunas
     que foi atribuído na constante "col" logo no início da classe */
    @Override
    public String getColumnName(int column) {
        return tabela.getColumnModel().getColumn(column).toString();
    }

    /* Este método foi criado por nós para retornar um objeto ClienteBean
     populado, de acordo com o número de linha do JTable fornecido pelo
     parâmetro "int row" */
    public Municipios getMunicipios(int row) {
        return tDesmCab.get(row);
    }

    /* Este método criado por nós, serve para voce criar um
     ClienteBean e populá-lo fora do JTable e passar para este
     método que vai acrescentar os dados na última linha do JTable
     sem que haja a necessidade de se usar o método "setValueAt(...)" */
    public void addRow(Municipios mf) {
        if (!Contains(mf)) {
            tDesmCab.add(mf);
            JTableModel.ajustarColunas(tabela);
            fireTableDataChanged();
        }
    }

    /* Este método foi criado por nós para remover uma linha
     específica do JTable, de acordo com linha fornecida pelo
     parâmetro "int row" */
    public Municipios removeRow(int row) {
        Municipios mf = tDesmCab.get(row);
        tDesmCab.remove(row);
        fireTableDataChanged();
        return mf;
    }

    public int getLinhaSelectionada() {
        return tabela.getSelectedRow();
    }

    public void removeAll() {
        tDesmCab.clear();
        fireTableDataChanged();
    }

    public boolean Contains(Municipios prod) {
        boolean contain = false;
        for (Municipios mfSet1 : tDesmCab) {
            if (mfSet1.equals(prod)) {
                contain = true;
            }
        }
        return contain;
    }

    public void addAll(ArrayList<Municipios> lista) {
        tDesmCab = lista;
        fireTableStructureChanged();
    }

    @Override
    public int getColumnCount() {
        return tabela.getColumnCount();
    }

}
