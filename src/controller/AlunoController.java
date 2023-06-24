package controller;

import model.Aluno;
import model.AlunoTableModel;

import java.util.ArrayList;
import java.util.List;
 
public class AlunoController {
    private List<Aluno> alunos;
    private AlunoTableModel tableModel;

    public AlunoController() {
        alunos = new ArrayList<>();
        tableModel = new AlunoTableModel(alunos);
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        tableModel.setAlunos(alunos);
    }

    public AlunoTableModel getAlunoTableModel() {
        return tableModel;
    }
}
