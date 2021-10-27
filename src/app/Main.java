package app;

import javax.swing.JOptionPane;

import classes.Republica;

public class Main {


	public static void main(String[] args) {
	
		float opcao;
		Republica novaRepublica = new Republica();
		
	do {
		
		novaRepublica.calculaRendimento(novaRepublica.cadastraPessoa());
		
		String strOpcao = JOptionPane.showInputDialog("Digite 1 para cadastrar uma nova pessoa ou 0 para ir ao cadastro de despesas:");
		opcao = Float.parseFloat(strOpcao);
			
	}while(opcao != 0);
	
	novaRepublica.setTotalPessoas();
	
	do {
		
		novaRepublica.calculaDespesas(novaRepublica.cadastraDespesa());
		
		String strOpcao = JOptionPane.showInputDialog("Digite 1 para cadastrar uma nova despesa ou 0 para sair imprimir os dados:");
		opcao = Float.parseFloat(strOpcao);
		
	}while(opcao != 0);
	
	//novaRepublica.imprimePessoas();
	//novaRepublica.imprimeDespesas();
	regraIgualitaria(novaRepublica);
	regraProporcional(novaRepublica);
		
	}
	
	public static void regraIgualitaria(Republica novaRepublica) {
	
		float porcentagem = (100 / novaRepublica.getTotalPessoas());
		float valorPago = (novaRepublica.getTotalDespesas() / novaRepublica.getTotalPessoas());
		
		for (int i=0; i<novaRepublica.getPessoas().length; i++) {
			String resposta = novaRepublica.getPessoas()[i].getNome()
					+ " deverá pagar a porcentagem de " + porcentagem + "% "
					+ "ou R$ " + valorPago;
			
			JOptionPane.showMessageDialog(null, resposta);
		}
	}
	
	public static void regraProporcional(Republica novaRepublica) {
		
		float porcentagem;
		float valorPago;
		
		for (int i=0; i<novaRepublica.getPessoas().length; i++) {
			porcentagem = (novaRepublica.getPessoas()[i].getRendimentos() * 100) / novaRepublica.getRendimentoTotal();
			valorPago = (porcentagem * novaRepublica.getTotalDespesas()) / 100;
			
			String resposta = novaRepublica.getPessoas()[i].getNome()
					+ " deverá pagar a porcentagem de " + porcentagem + "% "
					+ "ou R$ " + valorPago;
				
			JOptionPane.showMessageDialog(null, resposta);
					
		}
	}
	

}
