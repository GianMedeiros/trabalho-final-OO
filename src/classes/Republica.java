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
	String arquivoAlunos = "alunos.txt";
	String arquivoDespesas = "despesas.txt";
	
	public Republica() {
		alunos = new LinkedList<Aluno>();
	}

	public void cadastraDespesa(boolean info, String strDescricao, String strCategoria, String strSubcategoria, String strValorDespesa) {
		
		if (!info) {
			strDescricao = JOptionPane.showInputDialog("Informe a descricao da despesa:");
			strCategoria = JOptionPane.showInputDialog("Informe a categoria da despesa:");
			strSubcategoria = JOptionPane.showInputDialog("Informe a subcategoria da despesa (caso nao tenha, deixe em branco):");
			strValorDespesa = JOptionPane.showInputDialog("Informe o valor da despesa:");
			
		}
		
		float vDespesa = Float.parseFloat(strValorDespesa);
		Despesa d = new Despesa(strDescricao, strCategoria, strSubcategoria, vDespesa);

		Despesa[] temp2 = new Despesa[despesas.length + 1];
		for (int i=0; i<despesas.length; i++) {
			temp2[i] = despesas[i];
		}
		
		temp2[despesas.length] = d;
		despesas = temp2;

		if(!info) {
			JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso");
			gravarArquivoDespesas();
			JOptionPane.showMessageDialog(null, "arquivo atualizado!!");
			
		}
		
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
					+ "da categoria '" + despesas[i].getCategoria()
					+ "' (" + despesas[i].getNovaCat().getSubcat() + ")\n"
					+ "valor: " + despesas[i].getValor() + "\n";
					
			JOptionPane.showMessageDialog(null, resposta);
		}
		
		String resposta2 = "Valor total das despesas: " + Despesa.getTotalDespesas() + "\n"; 		
		JOptionPane.showMessageDialog(null, resposta2);
	}
	
	// Função ainda não implementada
	public void imprimeCategorias() {
		
	}
	
	public boolean gravarArquivoAluno() {
		// Metodo para adicionar aluno ao arquivo alunos.txt
		BufferedWriter buffer = null;
		FileWriter out = null;
		
		try {
			out = new FileWriter(arquivoAlunos);
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
			in = new FileReader(arquivoAlunos);
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
	
	public boolean gravarArquivoDespesas() {
		// Metodo para adicionar aluno ao arquivo alunos.txt
		BufferedWriter buffer = null;
		FileWriter out = null;
		
		
		
		try {
			out = new FileWriter(arquivoDespesas);
			buffer = new BufferedWriter(out);
			
			for (Despesa d : despesas) {
				buffer.write(d.toString());
				buffer.write('\n');
			}
			
			buffer.close();
			return true;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"erro ao gravar a DESPESA no arquivo" + e.getMessage());
			return false;
		}
		
	}
	
	public boolean lerArquivoDespesas() {
		
		BufferedReader buffer = null;
		FileReader in = null;
		
		String linha = null;
		
		try {
			in = new FileReader(arquivoDespesas);
			buffer = new BufferedReader(in);
		
			do {
				linha = buffer.readLine();
				
				if (linha != null) {
					String[] registro = linha.split(";");
					cadastraDespesa(true, registro[0], registro[1], registro[2], registro[3]);
				}
			} while (linha != null);
			
			buffer.close();
			
			return true;
		} catch (IOException ex) {
			String mensagem = "Erro na leitura de arquivo despesa.txt: " + ex.getMessage();
			JOptionPane.showMessageDialog(null, mensagem);
			ex.printStackTrace();
		}
		
		
		
		return false;
	}
	
	public double getTotalDespesas() {
		return Despesa.getTotalDespesas();
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
