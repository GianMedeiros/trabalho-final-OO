package classes;

public class Categoria {
	
	String descricao;
	Subcategoria subcategoria;
	
	public Categoria(String descriInf, String subcatInf) {
		
		this.descricao = descriInf;	
		if(subcatInf != " ") {
			subcategoria = new Subcategoria(subcatInf);
		}
		
	}
	
	public String getDescriCat() {
		return descricao;
	}
	
	public String getSubcat() {
		return subcategoria.getSubcategoria();
	}
	

}
