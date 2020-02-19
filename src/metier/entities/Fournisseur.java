package metier.entities;

public class Fournisseur {
	private int idfour;
	private String nomfour;
	private String prenomfour;
	private String adressefour;
	private String emailfour;
	private String telfour;
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(String nomfour, String prenomfour, String adressefour, String emailfour,
			String telfour) {
		super();
		this.nomfour = nomfour;
		this.prenomfour = prenomfour;
		this.adressefour = adressefour;
		this.emailfour = emailfour;
		this.telfour = telfour;
	}
	public int getIdfour() {
		return idfour;
	}
	public void setIdfour(int idfour) {
		this.idfour = idfour;
	}
	public String getNomfour() {
		return nomfour;
	}
	public void setNomfour(String nomfour) {
		this.nomfour = nomfour;
	}
	public String getPrenomfour() {
		return prenomfour;
	}
	public void setPrenomfour(String prenomfour) {
		this.prenomfour = prenomfour;
	}
	public String getAdressefour() {
		return adressefour;
	}
	public void setAdressefour(String adressefour) {
		this.adressefour = adressefour;
	}
	public String getEmailfour() {
		return emailfour;
	}
	public void setEmailfour(String emailfour) {
		this.emailfour = emailfour;
	}
	public String getTelfour() {
		return telfour;
	}
	public void setTelfour(String telfour) {
		this.telfour = telfour;
	}
	@Override
	public String toString() {
		return "Fournisseur [idfour=" + idfour + ", nomfour=" + nomfour + ", prenomfour=" + prenomfour
				+ ", adressefour=" + adressefour + ", emailfour=" + emailfour + ", telfour=" + telfour + "]";
	}
	
	
	
	

}
