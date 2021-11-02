package classes;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Categoria {
	
	private String descricaoCategoria;
	Subcategoria novaSubcat;
	List<Subcategoria> subcategorias = new LinkedList<Subcategoria>();

	public Categoria(String descriInf, String subcategoria) {

		this.descricaoCategoria = descriInf;
		novaSubcat = new Subcategoria(subcategoria);

	}
	
	public void cadastraSubcategoria(boolean info, String strDescriSubcat) {
		
		if(!info) {
			strDescriSubcat = JOptionPane.showInputDialog("Informe a descricao da subcategoria:");
			
		}

		Subcategoria s = new Subcategoria(strDescriSubcat);

		subcategorias.add(s);

		
		if(!info) {
			String resposta = "subcategoria cadastrada!"; 
			JOptionPane.showMessageDialog(null, resposta);			
			
		}

	}

	public String escolheSubcat() {

		String resposta = "";
		String subcatEscolhida = "";
		int i = 0;
		for(Subcategoria scat : subcategorias) {
			resposta += "(" + (i + 1) + ") " + scat.getSubcategoria() + "\n";
			i++;
		}

		String strTeste = JOptionPane.showInputDialog("A qual subcategoria pertence a despesa informada?\n\n"
														+ resposta + "\n");
		int opcaoCat = Integer.parseInt(strTeste);
		i = 0;

		for(Subcategoria scat2 : subcategorias) {
			if(i == (opcaoCat - 1)) {
				subcatEscolhida = scat2.getSubcategoria();
			}
			i++;
		}
		return subcatEscolhida;
	}
	
	public String getDescriCat() {
		return descricaoCategoria;
	}
	
	public boolean existeSubcat() {

		boolean existeSubcat = true;

		if(subcategorias.isEmpty() == true) {
			existeSubcat = false;
		}else {
			existeSubcat = true;
		}
		return existeSubcat;
	}

	public void setDescricaoCat(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
	

}