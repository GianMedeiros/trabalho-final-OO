package classes;

public class Despesa {
	
	String descricao;
	float valor;
	Categoria novaCat;
	
	public Despesa(float despesaInf, String descriInf, String categoria, String subcategoria) {	
		
		novaCat = new Categoria(categoria, subcategoria);
		this.descricao = descriInf;
		this.valor = despesaInf;	
	}
	

	public String getCategoria() {
		return novaCat.getDescriCat();
	}
	
	public Categoria getNovaCat() {
		return novaCat;
	}
	
	public float getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
