package metier.entities;

public class Livraison {
	
	private int idlivraison;
	private int idfour;
	private String libellelivraison;
	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livraison(int idfour, String libellelivraison) {
		super();
		this.idfour = idfour;
		this.libellelivraison = libellelivraison;
	}
	public int getIdlivraison() {
		return idlivraison;
	}
	public void setIdlivraison(int idlivraison) {
		this.idlivraison = idlivraison;
	}
	public int getIdfour() {
		return idfour;
	}
	public void setIdfour(int idfour) {
		this.idfour = idfour;
	}
	public String getLibellelivraison() {
		return libellelivraison;
	}
	public void setLibellelivraison(String libellelivraison) {
		this.libellelivraison = libellelivraison;
	}
	@Override
	public String toString() {
		return "Livraison [idlivraison=" + idlivraison + ", idfour=" + idfour + ", libellelivraison=" + libellelivraison
				+ "]";
	}
	
	

}
