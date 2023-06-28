package model;

public class Aluno {
    private String nome; 
    private double nota1;
    private double nota2;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getMedia() {
        return (nota1 + nota2) / 2;
    }

    public String getStatus() {
        if (getMedia() >= 7.0) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }
    
	public String mensagemValidacao(String nome, double nota1, double nota2) {
		String mensagem = "";

		if (nome.trim().equals("")) {
			mensagem.concat("\nCampo do Nome Vazio! O mesmo deve ser preenchido.");
		}

		if (nota1 > 10) {
			mensagem.concat("\nCampo nota 01 com valor maior que limite. Valor máximo é 10!");
		}

		if (nota2 > 10) {
			mensagem.concat("\nCampo nota 02 com valor maior que limite. Valor máximo é 10!");
		}

		if (nota1 < 0) {
			mensagem.concat("\nCampo nota 01 com valor inferior ao limite. Valor minimo é 0!");
		}

		if (nota2 < 0) {
			mensagem.concat("\nCampo nota 02 com valor inferior ao limite. Valor minimo é 0!");
		}

		return mensagem;

	}
    
    
}
