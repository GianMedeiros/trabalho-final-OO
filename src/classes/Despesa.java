package classes;

public class Despesa {
	
	public String categoria;
	public String descricao;
	public float valor;
	
	
	public void cadastrarDespesa(String categoriaCadas, String descricaoCadas, float valorCadas) {
		
		this.categoria = categoriaCadas;
		this.descricao = descricaoCadas;
		this.valor = valorCadas;
		
		//M�todo respons�vel por cadastrar uma nova categoria.
		
	}	
	
	public boolean alterarArquivoDespesas(boolean modo) {
		
		//M�todo respons�vel por confirmar a adi��o ou remo��o de uma despesa.
		
		return modo;
	}
}
