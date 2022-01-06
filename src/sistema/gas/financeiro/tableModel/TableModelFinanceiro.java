/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.gas.financeiro.tableModel;

import Negocios.FinanceiroParcelas;
import Utilitarios.ClasseUtilitaria;
import Utilitarios.JTableModel;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Heleno
 */
public class TableModelFinanceiro extends AbstractTableModel {

    private List<FinanceiroParcelas> tDesmCab;
    private JTable tabela = null;

    // Construtor da classe recebe os dados a ser populado
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public TableModelFinanceiro(List<FinanceiroParcelas> mf, JTable jTable) {
        tabela = jTable;
        tDesmCab = new ArrayList<>(mf);
        fireTableStructureChanged();
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public TableModelFinanceiro(JTable jTable) {
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
        FinanceiroParcelas tp = tDesmCab.get(rowIndex);
        Object row = null;
        switch (columnIndex) {
            case 0:
                row = tp.getFinanceiro() == null ? 0 : tp.getFinanceiro().getId();
                break;
            case 1:
                row = tp.getId();
                break;
            case 2:
                row = tp.getLancamento();
                break;
            case 3:
                row = tp.getStatus();
                break;
            case 4:
                row = tp.getParcela();
                break;
            case 5:
                row = ClasseUtilitaria.fmtDataBR.format(tp.getData_vencimento());
                break;
            case 6:
                row = ClasseUtilitaria.fmtBig(tp.getValor(), 2);
                break;
            case 7:
                row = ClasseUtilitaria.fmtBig(tp.getValor_pago(), 2);
                break;
            case 8:
                row = ClasseUtilitaria.fmtBig(tp.getValor().subtract(tp.getValor_pago()), 2);
                break;
            case 9:
                row = tp.getData_pagamento() == null ? "" : ClasseUtilitaria.fmtDataBR.format(tp.getData_pagamento());
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

    /* Este método sobrescrito, permite voce editar o JTable, caso o método anterior
     tenha algumas colunas de algumas ou todas linhas editáveis setadas para true,
     ou que tenha como retorno o valor true para todas as linhas e colunas. */
    @Override
    public void setValueAt(Object value, int row, int col) {
        FinanceiroParcelas dado = tDesmCab.get(row);
        switch (col) {
            case 0:
                dado.getFinanceiro().setId(Integer.valueOf((String) value));
                break;
            case 1:
                dado.setId(Integer.parseInt((String) value));
                break;
            case 2:
                dado.setLancamento(Integer.parseInt((String) value));
                break;
            case 3:
                dado.setStatus((String) value);
                break;
            case 4:
                dado.setParcela((String) value);
                break;
            case 5: {
                try {
                    dado.setData_vencimento(ClasseUtilitaria.fmtDataBR.parse((String) value));
                } catch (ParseException ex) {
                    Logger.getLogger(TableModelFinanceiro.class.getName()).log(Level.SEVERE, null, ex);
                    dado.setData_vencimento(null);
                }
            }
            break;
            case 6:
                dado.setValor(ClasseUtilitaria.parseToBig((String) value));
                break;
            case 7:
                dado.setValor_pago(ClasseUtilitaria.parseToBig((String) value));
                break;
            case 9: {
                try {
                    dado.setData_pagamento(ClasseUtilitaria.fmtDataBR.parse((String) value));
                } catch (ParseException ex) {
                    Logger.getLogger(TableModelFinanceiro.class.getName()).log(Level.SEVERE, null, ex);
                    dado.setData_pagamento(null);
                }
            }
            break;
        }
        fireTableCellUpdated(row, col);
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
    public List<FinanceiroParcelas> getDataSet() {
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
    public FinanceiroParcelas getFinanceiroParcelas(int row) {
        return tDesmCab.get(row);
    }

    /* Este método criado por nós, serve para voce criar um
     ClienteBean e populá-lo fora do JTable e passar para este
     método que vai acrescentar os dados na última linha do JTable
     sem que haja a necessidade de se usar o método "setValueAt(...)" */
    public void addRow(FinanceiroParcelas mf) {
        if (!Contains(mf)) {
            tDesmCab.add(mf);
            JTableModel.ajustarColunas(tabela);
            fireTableDataChanged();
        }
    }

    /* Este método foi criado por nós para remover uma linha
     específica do JTable, de acordo com linha fornecida pelo
     parâmetro "int row" */
    public FinanceiroParcelas removeRow(int row) {
        FinanceiroParcelas mf = tDesmCab.get(row);
        tDesmCab.remove(row);
        fireTableDataChanged();
        return mf;
    }

    /* Este método criado por nós, acrescenta uma linha em branco
     no JTable, caso voce queira inserir dados diretamente no JTable
     tem que chamar este método antes. */
    public void addLinhaEmBranco() {
        tDesmCab.add(new FinanceiroParcelas());
        fireTableDataChanged();
    }

    public int getLinhaSelectionada() {
        return tabela.getSelectedRow();
    }

    public List<FinanceiroParcelas> getLista() {
        return tDesmCab;
    }

    public void removeAll() {
        tDesmCab.clear();
        fireTableDataChanged();
    }

    public boolean Contains(FinanceiroParcelas prod) {
        boolean contain = false;
        for (FinanceiroParcelas mfSet1 : tDesmCab) {
            if (mfSet1.equals(prod)) {
                contain = true;
            }
        }
        return contain;
    }

    public void addAll(ArrayList<FinanceiroParcelas> lista) {
        tDesmCab = lista;
        fireTableStructureChanged();
    }

    @Override
    public int getColumnCount() {
        return tabela.getColumnCount();
    }

    public BigDecimal getTotalParcelas() {
        BigDecimal totalPar = BigDecimal.ZERO;
        for (FinanceiroParcelas p : getDataSet()) {
            totalPar = totalPar.add(p.getValor());
        }
        return totalPar;
    }

}
