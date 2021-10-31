package classes;

public class Despesa {
	
	private String descricaoDespesa;
	private double valor;
	private Categoria novaCat;
	private static double totalDespesas;
	
	public Despesa(String descriInf, String categoria, String subcategoria, double despesaInf) {	
		
		novaCat = new Categoria(categoria, subcategoria);
		this.descricaoDespesa = descriInf;
		this.valor = despesaInf;
		totalDespesas += despesaInf;
	}
	

	public String getCategoria() {
		return novaCat.getDescriCat();
	}
	
	public Categoria getNovaCat() {
		return novaCat;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricaoDespesa;
	}
	
	
	public static double getTotalDespesas() {
		return Despesa.totalDespesas;
	}	

	@Override
	public String toString() {
		return descricaoDespesa + ";" + novaCat.getDescriCat() + ";" + novaCat.subcategoria.getSubcategoria() + ";" + valor;
	}
	
}
