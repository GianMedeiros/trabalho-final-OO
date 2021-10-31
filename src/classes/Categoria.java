package classes;

public class Categoria {
	
	String descricaoCategoria;
	Subcategoria subcategoria;
	
	public Categoria(String descriInf, String subcatInf) {
		
		this.descricaoCategoria = descriInf;	
		if(subcatInf != " ") {
			subcategoria = new Subcategoria(subcatInf);
		}
		
	}
	
	public String getDescriCat() {
		return descricaoCategoria;
	}
	
	public String getSubcat() {
		return subcategoria.getSubcategoria();
	}
	

}