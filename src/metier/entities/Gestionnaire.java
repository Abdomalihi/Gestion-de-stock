package metier.entities;

public class Gestionnaire {
	private int iduser;
	private String login;
	private String password;
	private String nomuser;
	private String prenomuser;
	private String teluser;
	private String emailuser;
	private String typeuser;
	public Gestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gestionnaire(String login, String password, String nomuser, String prenomuser, String teluser,
			String emailuser, String typeuser) {
		super();
		this.login = login;
		this.password = password;
		this.nomuser = nomuser;
		this.prenomuser = prenomuser;
		this.teluser = teluser;
		this.emailuser = emailuser;
		this.typeuser = typeuser;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNomuser() {
		return nomuser;
	}
	public void setNomuser(String nomuser) {
		this.nomuser = nomuser;
	}
	public String getPrenomuser() {
		return prenomuser;
	}
	public void setPrenomuser(String prenomuser) {
		this.prenomuser = prenomuser;
	}
	public String getTeluser() {
		return teluser;
	}
	public void setTeluser(String teluser) {
		this.teluser = teluser;
	}
	public String getEmailuser() {
		return emailuser;
	}
	public void setEmailuser(String emailuser) {
		this.emailuser = emailuser;
	}
	public String getTypeuser() {
		return typeuser;
	}
	public void setTypeuser(String typeuser) {
		this.typeuser = typeuser;
	}
	@Override
	public String toString() {
		return "Gestionnaire [iduser=" + iduser + ", login=" + login + ", password=" + password + ", nomuser=" + nomuser
				+ ", prenomuser=" + prenomuser + ", teluser=" + teluser + ", emailuser=" + emailuser + ", typeuser="
				+ typeuser + "]";
	}
	
	
}
