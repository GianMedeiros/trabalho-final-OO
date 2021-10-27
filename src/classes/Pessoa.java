package classes;

public class Pessoa {
	
	String nome;
	String email;
	float rendimentos;
	
	public Pessoa(String nomeInf, String emailInf, float rendInf) {
		
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
	

}
