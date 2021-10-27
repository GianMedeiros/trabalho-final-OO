package classes;

import javax.swing.JOptionPane;

public class Republica {
	
	Pessoa[] pessoas = new Pessoa[0];
	Despesa[] despesas = new Despesa[0];
	float totalDespesas = 0;
	int totalPessoas = 0;
	float rendimentoTotal = 0;
	
	public Republica() {
		
	}
	
	public void calculaDespesas(float novaDespesa) {
		
		totalDespesas = totalDespesas + novaDespesa;
	}
	
	public void calculaRendimento(float novoRendimento) {
		
		rendimentoTotal = rendimentoTotal + novoRendimento;
	}
	
	public float getTotalDespesas() {
		return totalDespesas;
	}

	public void setTotalPessoas() {
		this.totalPessoas = pessoas.length;
	}
	
	public int getTotalPessoas() {
		return totalPessoas;
	}
	
	public float getRendimentoTotal() {
		return rendimentoTotal;
	}
	
	public Pessoa[] getPessoas() {
		return pessoas;
	}


	public float cadastraDespesa() {
		
		String strDescricao = JOptionPane.showInputDialog("Informe a descricao da despesa:");
		String strCategoria = JOptionPane.showInputDialog("Informe a categoria da despesa:");
		String strValorDespesa = JOptionPane.showInputDialog("Informe o valor da despesa:");
		float vDespesa = Float.parseFloat(strValorDespesa);
		Despesa d = new Despesa(vDespesa, strDescricao, strCategoria);

		Despesa[] temp2 = new Despesa[despesas.length + 1];
		for (int i=0; i<despesas.length; i++) {
			temp2[i] = despesas[i];
		}
		
		temp2[despesas.length] = d;
		despesas = temp2;
		
		return vDespesa;
	}
	
	public float cadastraPessoa() {
		
		String strNome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
		String strEmail = JOptionPane.showInputDialog("Informe o email da pessoa:");
		String strRendimentos = JOptionPane.showInputDialog("Informe o valor total dos redimentos da pessoa:");
		float vRendimentos = Float.parseFloat(strRendimentos);
		Pessoa p = new Pessoa(strNome, strEmail, vRendimentos);
		
		Pessoa[] temp1 = new Pessoa[pessoas.length + 1];
		for (int i=0; i<pessoas.length; i++) {
			temp1[i] = pessoas[i];
		}
		
		temp1[pessoas.length] = p;
		pessoas = temp1;
		
		return vRendimentos;
	}
	
	public void imprimePessoas() {
		
		for (int i=0; i<pessoas.length; i++) {
			String resposta = "Nome da pessoa: " + pessoas[i].getNome() + "\n"
					+ "Email: " + pessoas[i].getEmail() + "\n"
					+ "Redimentos totais: " + pessoas[i].getRendimentos();
				
			JOptionPane.showMessageDialog(null, resposta);
	}
	
		String resposta2 = "Numero de moradores: " + totalPessoas + "\n"; 		
		JOptionPane.showMessageDialog(null, resposta2);
		
		String resposta3 = "Rendimento total da republica: " + rendimentoTotal + "\n"; 		
		JOptionPane.showMessageDialog(null, resposta3);
	}
	
	public void imprimeDespesas() {
		
		for (int i=0; i<despesas.length; i++) {
			String resposta = "Despesa '" + despesas[i].getDescricao() + "' "
					+ "da categoria '" + despesas[i].getCategoria() + "'\n"
					+ "valor: " + despesas[i].getValor() + "\n";
					
			JOptionPane.showMessageDialog(null, resposta);
		}
		
		String resposta2 = "Valor total das despesas: " + totalDespesas + "\n"; 		
		JOptionPane.showMessageDialog(null, resposta2);
	}


}
