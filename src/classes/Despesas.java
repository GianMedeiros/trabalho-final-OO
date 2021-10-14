package classes;

public class Despesas {
	
	public String categoria;
	public String descricao;
	public float valor;
	
	
	public void cadastrarDespesa(String categoriaCadas, String descricaoCadas, float valorCadas) {
		
		this.categoria = categoriaCadas;
		this.descricao = descricaoCadas;
		this.valor = valorCadas;
		
		//Método responsável por cadastrar uma nova categoria.
		
	}	
	
	public boolean alterarArquivoDespesas(boolean modo) {
		
		//Método responsável por confirmar a adição ou remoção de uma despesa.
		
		return modo;
	}
}
