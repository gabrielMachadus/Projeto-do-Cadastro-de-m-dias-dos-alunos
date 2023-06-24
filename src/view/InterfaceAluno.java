package view;

import controller.AlunoController;
import model.Aluno;
import model.AlunoTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceAluno extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldNota01;
    private JTextField textFieldNota02;
    private JButton buttonSalvar;
    private JButton buttonNovo;
    private JTable tabelaAlunos;

    private AlunoController alunoController;

    public InterfaceAluno() {
        alunoController = new AlunoController();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        constraints.insets = new Insets(10, 10, 10, 10);

        // Label e campo de texto para o nome
        JLabel labelNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        panel.add(labelNome, constraints);

        textFieldNome = new JTextField(20);
        textFieldNome.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(textFieldNome, constraints);

        // Label e campo de texto para a nota 1
        JLabel labelNota01 = new JLabel("Nota 1:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(labelNota01, constraints);

        textFieldNota01 = new JTextField(5);
        textFieldNota01.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        panel.add(textFieldNota01, constraints);

        // Label e campo de texto para a nota 2
        JLabel labelNota02 = new JLabel("Nota 2:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(labelNota02, constraints);

        textFieldNota02 = new JTextField(5);
        textFieldNota02.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(textFieldNota02, constraints);

        // Botões Salvar e Novo
        buttonSalvar = new JButton("Salvar");
        buttonSalvar.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        panel.add(buttonSalvar, constraints);

        buttonNovo = new JButton("Novo");
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        panel.add(buttonNovo, constraints);

        // Tabela de alunos
        AlunoTableModel tableModel = alunoController.getAlunoTableModel();
        tabelaAlunos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, constraints);

        add(panel);
        pack();

        // Listener para o botão Salvar
        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                double nota1 = Double.parseDouble(textFieldNota01.getText());
                double nota2 = Double.parseDouble(textFieldNota02.getText());
                boolean valido = validarCampos(nome, nota1, nota2);
                if(valido) {
                	Aluno aluno = new Aluno(nome, nota1, nota2);
                    alunoController.adicionarAluno(aluno);

                    textFieldNome.setText("");
                    textFieldNota01.setText("");
                    textFieldNota02.setText("");
                    
                    buttonNovo.setEnabled(true);
                    buttonSalvar.setEnabled(false);
                    textFieldNome.setEnabled(false);
                    textFieldNota01.setEnabled(false);
                    textFieldNota02.setEnabled(false);
                    JOptionPane.showMessageDialog(scrollPane, "Cadastrado com sucesso!");
                }else {
                	JOptionPane.showMessageDialog(scrollPane, "Inconsistencias encontradas nas informações! "
                			+ "Ajuste os valores informados!");
                }
                
            }

			private boolean validarCampos(String nome, double nota1, double nota2) {
				if(nome.trim().equals("") || nota1 > 10 || nota2  > 10 || nota1 < 0 || nota2  < 0) {
					return false;
				}
				return true;
			}

			
        });

        // Listener para o botão Novo
        buttonNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNome.setText("");
                textFieldNota01.setText("");
                textFieldNota02.setText("");
                
                textFieldNome.setEnabled(true);
                textFieldNota01.setEnabled(true);
                textFieldNota02.setEnabled(true);
                
                buttonNovo.setEnabled(false);
                buttonSalvar.setEnabled(true);
                
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceAluno();
            }
        });
    }
}
