package classes;

public class Aluno {
	
	private String nome;
	private String email;
	private float rendimentos;
	private static int totalAlunos;
	
	public Aluno(String nomeInf, String emailInf, float rendInf) {
		// Metodo construtor da classe Aluno
		
		totalAlunos++;
		this.nome = nomeInf;
		this.email = emailInf;
		this.rendimentos = rendInf;
		
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public float getRendimentos() {	
		return rendimentos;
	}
	
	public void setRendimentos(float rendimentos) {
		// Funcao para alterar o rendimento da aluno
		
		this.rendimentos = rendimentos;
	}
	
	public static int getTotalAlunos() {
		return Aluno.totalAlunos;
	}
	
	public static void alterarTotalAlunos(boolean modo) {
		if(modo) {
			Aluno.totalAlunos++;
		} else {
			Aluno.totalAlunos--;
		}
	}

	@Override
	public String toString() {
		return nome + ';' + email + ';' + rendimentos;
	}

}
