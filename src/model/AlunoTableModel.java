package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AlunoTableModel extends AbstractTableModel {
    private List<Aluno> alunos;
    private String[] colunas = {"Nome", "Nota 1", "Nota 2", "Média", "Status"};

    public AlunoTableModel(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = alunos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return aluno.getNome();
            case 1:
                return aluno.getNota1();
            case 2:
                return aluno.getNota2();
            case 3:
                return aluno.getMedia();
            case 4:
                return aluno.getStatus();
            default:
                return null;
        }
    }
}
