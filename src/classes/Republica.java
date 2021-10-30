package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Republica {
	
	List<Aluno> alunos;
	Despesa[] despesas = new Despesa[0];
	private float totalDespesas = 0;
	private float rendimentoTotal = 0;
	String nomeArquivoAlunos = "alunos.txt";
	
	public Republica() {
		alunos = new LinkedList<Aluno>();
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
	
	public float cadastraAluno() {
		
		String strNome = JOptionPane.showInputDialog("Informe o nome da aluno:");
		String strEmail = JOptionPane.showInputDialog("Informe o email da aluno:");
		String strRendimentos = JOptionPane.showInputDialog("Informe o valor total dos redimentos do aluno:");
		
		float vRendimentos = Float.parseFloat(strRendimentos);
		
		Aluno a = new Aluno(strNome, strEmail, vRendimentos);
		
		boolean resposta = alunos.add(a);
		if (resposta)
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
		
		return vRendimentos;
	}
	
	public void imprimeAlunos() {
		
		for (Aluno p: alunos) {
			String resposta = "Nome do aluno: " + p.getNome() + "\n"
					+ "Email: " + p.getEmail() + "\n"
					+ "Redimentos totais: " + p.getRendimentos();
				
			JOptionPane.showMessageDialog(null, resposta);
	}
	
		String resposta2 = "Numero de moradores: " + Aluno.getTotalAlunos()+ "\n"; 		
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
	
	public void gravarArquivoAluno() {
		// Metodo para adicionar aluno ao arquivo alunos.txt
		BufferedWriter buffer = null;
		FileWriter out = null;
		
		try {
			out = new FileWriter(nomeArquivoAlunos);
			buffer = new BufferedWriter(out);
			
			for (Aluno p : alunos) {
				buffer.write(p.toString());
				buffer.write('\n');
			}
			
			buffer.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void alteraArquivoDespesa(boolean modo, Despesa DespesaAlvo) {
		// Metodo para ou adicionar ou retirar despesa do arquivo despesa.txt
	}

	public void calculaDespesas(float novaDespesa) {
		
		totalDespesas += novaDespesa;
	}
	
	public void calculaRendimento(float novoRendimento) {
		
		rendimentoTotal += novoRendimento;
	}
	
	public float getTotalDespesas() {
		return totalDespesas;
	}
	
	public int getTotalAlunos() {
		return Aluno.getTotalAlunos();
	}
	
	public float getRendimentoTotal() {
		return rendimentoTotal;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}


}
