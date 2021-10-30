package app;

import javax.swing.JOptionPane;

import classes.Republica;

public class Main {


	public static void main(String[] args) {
	
		int opcao;
		int regraDeNegocio;
		Republica novaRepublica = new Republica();
		
	if (novaRepublica.lerArquivoAluno()) {
		JOptionPane.showMessageDialog(null, "Leitura total realizada com sucesso!!");
	} else {
		JOptionPane.showMessageDialog(null, "Erro no leitura total do arquivo!!");
	}
		
	do {
		
//		novaRepublica.calculaRendimento(novaRepublica.cadastraaluno());
		
		String strOpcao = JOptionPane.showInputDialog("Escolha uma opção de ação: \n\n" 
													+ "(1) Cadastrar aluno.\n"
													+ "(2) Cadastro de despesas.\n"
													+ "(3) Cadastro de categoria.\n"
													+ "(4) Imprime alunos.\n"
													+ "(5) Imprime despesas.\n"
													+ "(6) Imprime categorias.\n"
													+ "(7) Calcular pagamento.\n\n"
													+ "(0) Sair\n");
		
		opcao = Integer.parseInt(strOpcao);
		
		switch (opcao) {
		case 1:
			// cria novo cadastro de alunos
			novaRepublica.cadastraAluno(false, null, null, null);
			
			break;
			
		case 2:
			// cria novo cadastro de despesas
			novaRepublica.calculaDespesas(novaRepublica.cadastraDespesa());
			
			break;
			
		case 3:
			// cria novo cadastro de categoria
			JOptionPane.showMessageDialog(null, "função ainda não feita!!");
			
			break;
		
		case 4:
			// Imprime alunos
			novaRepublica.imprimeAlunos();
			
			break;
			
		case 5:
			// Imprime despesas
			novaRepublica.imprimeDespesas();
			
			break;
			
		case 6:
			// Imprime categorias
			JOptionPane.showMessageDialog(null, "função ainda não feita!!");
			
			break;
			
		case 7:
			
			do {
				
				String strregraDeNegocio = JOptionPane.showInputDialog("Escolha o modo de cobrança:\n\n"
						+ "(1) Regra igualitaria.\n"
						+ "(2) Regra proposcional.\n\n"
						+ "(0) Voltar ao menu.\n");

				regraDeNegocio = Integer.parseInt(strregraDeNegocio);
				
				switch (regraDeNegocio) {
				
				case 1:
					// regra Igualitaria
					regraIgualitaria(novaRepublica);
					
					break;
				
				case 2:
					// regra Proporcional
//					regraProporcional(novaRepublica);
					
					break;
				
				case 0:
					// Voltando ao menu
					JOptionPane.showMessageDialog(null, "Voltando ao menu!!");
					
					break;
				
				default:
					// opcao invalida
					JOptionPane.showMessageDialog(null, "Opção invalida!!");
					
					break;
						
				}
				
			} while (regraDeNegocio != 0);
			
			
			
			
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
	
	public static void regraIgualitaria(Republica novaRepublica) {
		double porcentagem = (100.0 / novaRepublica.getTotalAlunos());
		double valorPago = (novaRepublica.getTotalDespesas() / novaRepublica.getTotalAlunos());
		String strporcentagem = String.format("%.2f", porcentagem);
		String strvalorPago = String.format("%.2f", valorPago);

		for (int i=0; i<novaRepublica.getAlunos().size(); i++) {
			String resposta = novaRepublica.getAlunos().get(i).getNome()
					+ " devera pagar a porcentagem de " + strporcentagem + "% "
					+ "ou R$ " + strvalorPago;
			
			JOptionPane.showMessageDialog(null, resposta);
		}
	}
	
//	public static void regraProporcional(Republica novaRepublica) {
//		
//		double porcentagem;
//		double valorPago;
//		
//		for (int i=0; i<novaRepublica.getAlunos().size(); i++) {
//			porcentagem = (novaRepublica.getAlunos().get(i).getRendimentos() * 100) / novaRepublica.getRendimentoTotal();
//			valorPago = (porcentagem * novaRepublica.getTotalDespesas()) / 100;
//			
//			String resposta = novaRepublica.getAlunos().get(i).getNome()
//					+ " devera pagar a porcentagem de " + porcentagem + "% "
//					+ "ou R$ " + valorPago;
//				
//			JOptionPane.showMessageDialog(null, resposta);
//					
//		}
//	}
	

}
