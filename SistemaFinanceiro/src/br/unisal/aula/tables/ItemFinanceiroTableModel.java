package br.unisal.aula.tables;

import br.unisal.aula.models.ItemFinanceiro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ItemFinanceiroTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_DESCRICAO = 1;
    private static final int COL_TIPO = 2;
    private static final int COL_VALOR = 3;
    private static final int COL_CATEGORIA = 4;
    private static final int COL_DATA = 5;
    private final String[] colunas = new String[]{"Id", "Descrição", "Tipo", "Valor", "Categoria", "Data"};
    private List<ItemFinanceiro> linhas;

    public ItemFinanceiroTableModel(List<ItemFinanceiro> linhas) {
        this.linhas = linhas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ItemFinanceiro item = linhas.get(rowIndex);
        switch (columnIndex) {
            case COL_ID:
                return item.getId();
            case COL_DESCRICAO:
                return item.getDescricao();
            case COL_CATEGORIA:
                return item.getCategoria();
            case COL_DATA:
                return item.getData();
            case COL_TIPO:
                return item.getTipo();
            case COL_VALOR:
                return item.getValor();
            default:
                break;
        }
        return null;
    }
    
    public void adicionar(ItemFinanceiro item){
        linhas.add(item);
        int ultimaLinha = getRowCount() - 1;
        fireTableRowsInserted(ultimaLinha, ultimaLinha);
    }
    
    public void atualizar(int indiceLinha, ItemFinanceiro item){
        linhas.set(indiceLinha, item);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }
    
    public void excluir(int indiceLinha){
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    public ItemFinanceiro getItem(int indiceLinha){
        return linhas.get(indiceLinha);
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
