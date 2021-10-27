package classes;

public class Despesa {
	
	String descricao;
	float valor;
	Categoria novaCat;
	
	public Despesa(float despesaInf, String descriInf, String categoria) {	
		
		novaCat = new Categoria(categoria);
		this.descricao = descriInf;
		this.valor = despesaInf;	
	}
	

	public String getCategoria() {
		return novaCat.getDescriCat();
	}
	
	public float getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
