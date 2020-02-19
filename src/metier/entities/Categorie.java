package metier.entities;

public class Categorie {
	
	private int idcat;
	private String nomcat;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(int idcat, String nomcat) {
		super();
		this.nomcat = nomcat;
	}
	public int getIdcat() {
		return idcat;
	}
	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}
	public String getNomcat() {
		return nomcat;
	}
	public void setNomcat(String nomcat) {
		this.nomcat = nomcat;
	}
	@Override
	public String toString() {
		return "Categorie [idcat=" + idcat + ", nomcat=" + nomcat + "]";
	}
	
	

}
