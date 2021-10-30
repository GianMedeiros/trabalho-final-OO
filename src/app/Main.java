package app;

import javax.swing.JOptionPane;

import classes.Republica;

public class Main {


	public static void main(String[] args) {
	
		int opcao;
		Republica novaRepublica = new Republica();
		
	do {
		
//		novaRepublica.calculaRendimento(novaRepublica.cadastraaluno());
		
		String strOpcao = JOptionPane.showInputDialog("Escolha uma opção de ação: \n\n" 
													+ "(1) Cadastrar aluno.\n"
													+ "(2) Imprime alunos.\n"
													+ "(3) Cadastro de despesas.\n"
													+ "(4) Imprime despesas.\n"
													+ "(5) Definir regra de negocio.\n "
													+ "(6) Gravar alunos\n\n"
													+ "(0) Sair\n");
		
		opcao = Integer.parseInt(strOpcao);
		
		switch (opcao) {
		case 1:
			// cria novo cadastro de alunos
			novaRepublica.calculaRendimento(novaRepublica.cadastraAluno());
			
			break;
		
		case 2:
			// Criar nova despesa
			novaRepublica.imprimeAlunos();
			
			break;
			
		case 3:
			// Criar nova despesa
			novaRepublica.cadastraDespesa();
			
			break;
			
		case 4:
			// Criar nova despesa
			novaRepublica.imprimeDespesas();
			
			break;
			
		case 5:
			// Decidir regra de cobrança de despesas
			
			break;
			
		case 6:
			// Decidir regra de cobrança de despesas
			novaRepublica.gravarArquivoAluno();
			JOptionPane.showMessageDialog(null, "arquivo atualizado!!");
			break;
			
		case 0:
			// Decidir regra de cobrança de despesas
			JOptionPane.showMessageDialog(null, "Fechando o programa!!");
			
			break;
			
		default:
			// opcao invalida
			JOptionPane.showMessageDialog(null, "Opção invalida!!");
			
			break;
		}
			
	}while(opcao != 0);
	

	}
	
	
	// Passar este metodo para a classe republica
	public static void regraIgualitaria(Republica novaRepublica) {
	
		float porcentagem = (100 / novaRepublica.getTotalAlunos());
		float valorPago = (novaRepublica.getTotalDespesas() / novaRepublica.getTotalAlunos());
		

		for (int i=0; i<novaRepublica.getAlunos().size(); i++) {
			String resposta = novaRepublica.getAlunos().get(i).getNome()
					+ " devera pagar a porcentagem de " + porcentagem + "% "
					+ "ou R$ " + valorPago;
			
			JOptionPane.showMessageDialog(null, resposta);
		}
	}

	
	// Passar este metodo para a classe republica
	public static void regraProporcional(Republica novaRepublica) {
		
		float porcentagem;
		float valorPago;
		
		for (int i=0; i<novaRepublica.getAlunos().size(); i++) {
			porcentagem = (novaRepublica.getAlunos().get(i).getRendimentos() * 100) / novaRepublica.getRendimentoTotal();
			valorPago = (porcentagem * novaRepublica.getTotalDespesas()) / 100;
			
			String resposta = novaRepublica.getAlunos().get(i).getNome()
					+ " devera pagar a porcentagem de " + porcentagem + "% "
					+ "ou R$ " + valorPago;
				
			JOptionPane.showMessageDialog(null, resposta);
					
		}
	}
	

}
