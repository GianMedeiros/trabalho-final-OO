package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Republica {
	
	List<Aluno> alunos;
	Despesa[] despesas = new Despesa[0];
	private double totalDespesas = 0;
	String nomeArquivoAlunos = "alunos.txt";
	
	public Republica() {
		alunos = new LinkedList<Aluno>();
	}

	public double cadastraDespesa() {
		
		String strDescricao = JOptionPane.showInputDialog("Informe a descricao da despesa:");
		String strCategoria = JOptionPane.showInputDialog("Informe a categoria da despesa:");
		String strValorDespesa = JOptionPane.showInputDialog("Informe o valor da despesa:");
		double vDespesa = Double.parseDouble(strValorDespesa);
		Despesa d = new Despesa(vDespesa, strDescricao, strCategoria);

		Despesa[] temp2 = new Despesa[despesas.length + 1];
		for (int i=0; i<despesas.length; i++) {
			temp2[i] = despesas[i];
		}
		
		temp2[despesas.length] = d;
		despesas = temp2;
		
		return vDespesa;
	}
	
	public void cadastraAluno(boolean info, String strNome, String strEmail, String strRendimentos) {
		
		
		if (!info) {
			strNome = JOptionPane.showInputDialog("Informe o nome da aluno:");
			strEmail = JOptionPane.showInputDialog("Informe o email da aluno:");
			strRendimentos = JOptionPane.showInputDialog("Informe o valor total dos redimentos do aluno:");
		}
		
		double vRendimentos = Double.parseDouble(strRendimentos);
		
		Aluno a = new Aluno(strNome, strEmail, vRendimentos);
		
		boolean resposta = alunos.add(a);
		if (resposta) {
			
			if(!info) {
				
				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
				gravarArquivoAluno();
				JOptionPane.showMessageDialog(null, "arquivo atualizado!!");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Erro em cadastrar aluno!!");
		}
		
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
		
		String resposta3 = "Rendimento total da republica: " + Aluno.getTotalRendimentos() + "\n"; 		
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
	
	public boolean gravarArquivoAluno() {
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
			return true;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"erro ao gravar o aluno no arquivo" + e.getMessage());
			return false;
		}
		
	}
	
	public boolean lerArquivoAluno() {
		
		BufferedReader buffer = null;
		FileReader in = null;
		
		String linha = null;
		
		try {
			in = new FileReader(nomeArquivoAlunos);
			buffer = new BufferedReader(in);
		
			do {
				linha = buffer.readLine();
				
				if (linha != null) {
					String[] registro = linha.split(";");
					cadastraAluno(true, registro[0], registro[1], registro[2]);
				}
			} while (linha != null);
			
			buffer.close();
			
			return true;
		} catch (IOException ex) {
			String mensagem = "Erro na leitura de arquivo alunos.txt: " + ex.getMessage();
			JOptionPane.showMessageDialog(null, mensagem);
			ex.printStackTrace();
		}
		
		
		
		return false;
	}
	
	public void alteraArquivoDespesa(boolean modo, Despesa DespesaAlvo) {
		// Metodo para ou adicionar ou retirar despesa do arquivo despesa.txt
	}

	public void calculaDespesas(double novaDespesa) {
		
		totalDespesas += novaDespesa;
	}
	
	
	public double getTotalDespesas() {
		return totalDespesas;
	}
	
	public int getTotalAlunos() {
		return Aluno.getTotalAlunos();
	}
	
	public double getRendimentoTotal() {
		return Aluno.getTotalRendimentos();
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}


}
