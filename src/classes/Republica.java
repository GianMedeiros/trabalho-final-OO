package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Republica {
	
	List<Aluno> alunos;
	List<Categoria> categorias = new LinkedList<Categoria>();
	Despesa[] despesas = new Despesa[0];

	String arquivoAlunos = "alunos.txt";
	String arquivoDespesas;
	private static int mes;
	private static int ano;
	
	public Republica() {
		alunos = new LinkedList<Aluno>();
	}

	public class CategoriaNaoInformadaException extends Exception { 
		public CategoriaNaoInformadaException() {
		}
	}

	public class DescricaoNaoInformadaException extends Exception { 
		public DescricaoNaoInformadaException() {
		}
	}

	public class ValorNaoInformadoException extends Exception { 
		public ValorNaoInformadoException() {
		}
	}

	public void cadastraDespesa(boolean info, String strDescricao, String strCategoria, String strSubcategoria, String strValorDespesa) throws DadosPessoaisIncompletosException, RendimentoInvalidoException {
		
		try{
			if (!info) {
				strDescricao = JOptionPane.showInputDialog("Informe a descricao da despesa:");
				String[] strResposta = escolheCategoria().split(";");
				strCategoria = strResposta[0];
				strSubcategoria = strResposta[1];
				strValorDespesa = JOptionPane.showInputDialog("Informe o valor da despesa:");
				
			}
			
			if(strDescricao.isEmpty()||strCategoria.isEmpty()||strValorDespesa.isEmpty())
			{
				throw new ValorNaoInformadoException();
			}
			else if(Double.parseDouble(strValorDespesa)<0)
			{
				throw new RendimentoInvalidoException();
			}
			
//			if(strValorDespesa.isEmpty())
//			{
//				throw new ValorNaoInformadoException();
//			}
//			
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
		catch(ValorNaoInformadoException vni)
		{
			JOptionPane.showMessageDialog(null, "Dados em falta!");
		}catch(RendimentoInvalidoException ri)	{
			JOptionPane.showMessageDialog(null, "RValor de despesa invalido!");
			
		}
	}

	public class DadosPessoaisIncompletosException extends Exception { 
		public DadosPessoaisIncompletosException() {
		}
	}
	public class RendimentoInvalidoException extends Exception { 
		public RendimentoInvalidoException() {
		}
	}
	boolean isNumber(String numero) {
		if (numero == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(numero);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public void cadastraAluno(boolean info, String strNome, String strEmail, String strRendimentos) {
			
		try{
			if (!info) {
				strNome = JOptionPane.showInputDialog("Informe o nome do aluno:");
				strEmail = JOptionPane.showInputDialog("Informe o email do aluno:");
				strRendimentos = JOptionPane.showInputDialog("Informe o valor total dos redimentos do aluno:");
			}
	
			if(strNome.isEmpty()||strEmail.isEmpty()||strRendimentos.isEmpty())
			{
				throw new DadosPessoaisIncompletosException();
			}
			else if(Double.parseDouble(strRendimentos)<0)
			{
				throw new RendimentoInvalidoException();
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
			}catch(DadosPessoaisIncompletosException dp)	{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				
			}catch(RendimentoInvalidoException ri)	{
				JOptionPane.showMessageDialog(null, "Rendimento invalido!");
				
			}catch(NumberFormatException nf)	{
				JOptionPane.showMessageDialog(null, "Rendimento invalido!");
			}
			
		}
	
	public void cadastrarCategoria(boolean info, String strDescriCat, String strOpcaoSubcat) {

		if(!info) {
			strDescriCat = JOptionPane.showInputDialog("Informe a descricao da categoria:");
			
		}

		Categoria c = new Categoria(strDescriCat, null);

		categorias.add(c);

		if(!info) {
			String resposta = "Categoria cadastrada!"; 
			JOptionPane.showMessageDialog(null, resposta);
			
			int opcaoSubcat = 0;
			do {
				strOpcaoSubcat = JOptionPane.showInputDialog("A categoria informada possui uma nova subcategoria?\n\n"
						+ "(1) Sim.\n"
						+ "(2) Nao.\n");
				opcaoSubcat = Integer.parseInt(strOpcaoSubcat);
				
				if(opcaoSubcat == 1) {
					c.cadastraSubcategoria(false, strOpcaoSubcat);
				}
				
			}while (opcaoSubcat == 1);
			
		}else {
			c.cadastraSubcategoria(true, strOpcaoSubcat);
		}
	}

	
	public void imprimeAlunos() {
		
		for (Aluno a: alunos) {
			String resposta = "Nome do aluno: " + a.getNome() + "\n"
					+ "Email: " + a.getEmail() + "\n"
					+ "Redimentos totais: " + a.getRendimentos();
				
			JOptionPane.showMessageDialog(null, resposta);

		}
		
			String resposta2 = "Numero de moradores: " + Aluno.getTotalAlunos()+ "\n"; 		
			JOptionPane.showMessageDialog(null, resposta2);
			
			String resposta3 = "Rendimento total da republica: " + Aluno.getTotalRendimentos() + "\n"; 		
			JOptionPane.showMessageDialog(null, resposta3);

	}
	
	public void imprimeDespesas() {
		
		for (int i=0; i<despesas.length; i++) {
			String resposta = "Despesa: " + despesas[i].getDescricao() + "\n"
					+ "Categoria: " + despesas[i].getCategoria() + "\n"
					+ "Subcategoria: " + despesas[i].getNovaCat().novaSubcat.getSubcategoria() + "\n\n"
					+ "valor: " + despesas[i].getValor() + "\n\n";
					
			JOptionPane.showMessageDialog(null, resposta);
		}
		
		String resposta2 = "Valor total das despesas: " + Despesa.getTotalDespesas() + "\n"; 		
		JOptionPane.showMessageDialog(null, resposta2);
	}


	public String escolheCategoria() {

		String resposta = "";
		String catEscolhida = "";
		String subcatEscolhida = "";
		int i = 0;
		for(Categoria cat : categorias) {
			resposta += "(" + (i + 1) + ") " + cat.getDescriCat() + "\n";
			i++;
		}

		String strTeste = JOptionPane.showInputDialog("A qual categoria pertence a despesa informada?\n\n"
														+ resposta + "\n");
		int opcaoCat = Integer.parseInt(strTeste);
		i = 0;

		for(Categoria cat2 : categorias) {
			if(i == (opcaoCat - 1)) {
				catEscolhida = cat2.getDescriCat();
				if(cat2.existeSubcat() == true) {
					subcatEscolhida = cat2.escolheSubcat();
				}else {
					subcatEscolhida = "";
				}
			}
			i++;
		}

		String resposta2 = catEscolhida + ";" + subcatEscolhida;

		return resposta2;
		
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
		
		File alunosTxt = new File("alunos.txt");
		if(!alunosTxt.exists() && alunosTxt.isDirectory()) { 
			// cria novo arquivo
			novoDespesaTxt(mes, ano);	
		}
		
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
	
	public boolean lerArquivoDespesas() throws DadosPessoaisIncompletosException, RendimentoInvalidoException{
		
		BufferedReader buffer = null;
		FileReader in = null;
		
		String linha = null;
		
		try {
			String novoAno = JOptionPane.showInputDialog("Digite o ANO que deseja cadastrar as despesas:\n");
			String novoMes = JOptionPane.showInputDialog("Digite o MES que deseja cadastrar as despesas:\n");
			
			if(novoAno.isEmpty()||novoMes.isEmpty())
			{
				throw new DadosPessoaisIncompletosException();
			}
			else if(Double.parseDouble(novoAno)<0||Double.parseDouble(novoMes)<1||Double.parseDouble(novoMes)>12)
			{
				throw new RendimentoInvalidoException();
			}
			
			ano = Integer.parseInt(novoAno);
			mes = Integer.parseInt(novoMes);
			
		}catch(DadosPessoaisIncompletosException dp) {
			JOptionPane.showMessageDialog(null, "Preencha os campos ano/mes corretamente!");
			lerArquivoDespesas();
		}catch(RendimentoInvalidoException ri) {
			JOptionPane.showMessageDialog(null, "Valor ano/mes invalidos invalido!");
			lerArquivoDespesas();
		}catch(NumberFormatException nf) {
			JOptionPane.showMessageDialog(null, "Valor ano/mes invalidos invalido!");
		}
		
		arquivoDespesas = "despesas_" + mes + "_" + ano + ".txt";
		
		File despesasTxt = new File("despesas_" + mes + "_" + ano + ".txt");
		if(despesasTxt.exists() && !despesasTxt.isDirectory()) { 
		    // l?? o arquivo normalmente
			
		}else {
			// cria novo arquivo
			novoDespesaTxt(mes, ano);
		}
		
		try {
			in = new FileReader(arquivoDespesas);
			buffer = new BufferedReader(in);
		
			do {
				linha = buffer.readLine();
				
				if (linha != null) {
					String[] registro = linha.split(";");
					cadastraDespesa(true, registro[0], registro[1], registro[2], registro[3]);
					cadastrarCategoria(true, registro[1], registro[2]);
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
	
	public void novoDespesaTxt(int mes, int ano) {
		
		FileWriter novoArquivoDes;
		
		try {
			novoArquivoDes = new FileWriter(new File("despesas_" + mes + "_" + ano + ".txt"));
			novoArquivoDes.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
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
	
	public void regraIgualitaria(Republica novaRepublica) {
		double porcentagem = (100.0 / novaRepublica.getTotalAlunos());
		double valorPago = (novaRepublica.getTotalDespesas() / novaRepublica.getTotalAlunos());

		// formatando resposta

		String strporcentagem = String.format("%.2f", porcentagem);
		String strvalorPago = String.format("%.2f", valorPago);

		for (int i=0; i<novaRepublica.getAlunos().size(); i++) {
			String resposta = novaRepublica.getAlunos().get(i).getNome()
					+ " devera pagar a porcentagem de " + strporcentagem + "% "
					+ "ou R$ " + strvalorPago;
			
			JOptionPane.showMessageDialog(null, resposta);
		}
	}

	public void regraProporcional(Republica novaRepublica) {
		
		for (int i=0; i<novaRepublica.getAlunos().size(); i++) {
			double porcentagem = (novaRepublica.getAlunos().get(i).getRendimentos() * 100) / novaRepublica.getRendimentoTotal();
			double valorPago = (porcentagem * novaRepublica.getTotalDespesas()) / 100;
			
			// formatando resposta
			String strporcentagem = String.format("%.2f", porcentagem);
			String strvalorPago = String.format("%.2f", valorPago);
			
			String resposta = novaRepublica.getAlunos().get(i).getNome()
					+ " devera pagar a porcentagem de " + strporcentagem + "% "
					+ "ou R$ " + strvalorPago;
				
			JOptionPane.showMessageDialog(null, resposta);
					
		}
	}


}