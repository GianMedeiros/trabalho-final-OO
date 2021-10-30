package classes;

public class Despesa {
	
	String descricao;
	double valor;
	Categoria novaCat;
	
	public Despesa(double despesaInf, String descriInf, String categoria) {	
		
		novaCat = new Categoria(categoria);
		this.descricao = descriInf;
		this.valor = despesaInf;	
	}
	

	public String getCategoria() {
		return novaCat.getDescriCat();
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}