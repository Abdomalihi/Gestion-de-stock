package metier.entities;

public class Client {
	private int idclient;
	private String nomclt;
	private String prenomclt;
	private String adresseclt;
	private String emailclt;
	private String telclt;
	
	public Client( String nomclt, String prenomclt, String adresseclt, String emailclt, String telclt) {
		super();
		this.nomclt = nomclt;
		this.prenomclt = prenomclt;
		this.adresseclt = adresseclt;
		this.emailclt = emailclt;
		this.telclt = telclt;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String getNomclt() {
		return nomclt;
	}
	public void setNomclt(String nomclt) {
		this.nomclt = nomclt;
	}
	public String getPrenomclt() {
		return prenomclt;
	}
	public void setPrenomclt(String prenomclt) {
		this.prenomclt = prenomclt;
	}
	public String getAdresseclt() {
		return adresseclt;
	}
	public void setAdresseclt(String adresseclt) {
		this.adresseclt = adresseclt;
	}
	public String getEmailclt() {
		return emailclt;
	}
	public void setEmailclt(String emailclt) {
		this.emailclt = emailclt;
	}
	public String getTelclt() {
		return telclt;
	}
	public void setTelclt(String telclt) {
		this.telclt = telclt;
	}
	
	@Override
	public String toString() {
		return "Client [idclient=" + idclient + ", nomclt=" + nomclt + ", prenomclt=" + prenomclt + ", adresseclt="
				+ adresseclt + ", emailclt=" + emailclt + ", telclt=" + telclt + "]";
	}
	
	
	

}
