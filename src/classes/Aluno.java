package classes;

public class Aluno {
	
	private String nome;
	private String email;
	private double rendimentos;
	private static int totalAlunos;
	private static double totalRendimentos;
	
	public Aluno(String nomeInf, String emailInf, double rendInf) {
		// Metodo construtor da classe Aluno
		
		this.nome = nomeInf;
		this.email = emailInf;
		this.rendimentos = rendInf;
		totalAlunos++;
		totalRendimentos += rendInf;
		
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public double getRendimentos() {	
		return rendimentos;
	}
	
	public void setRendimentos(double rendimentos) {
		// Funcao para alterar o rendimento da aluno
		
		this.rendimentos = rendimentos;
	}
	
	public static int getTotalAlunos() {
		return Aluno.totalAlunos;
	}
	
	public static double getTotalRendimentos() {
		return Aluno.totalRendimentos;
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
		return nome + ";" + email + ";" + rendimentos;
	}

}
