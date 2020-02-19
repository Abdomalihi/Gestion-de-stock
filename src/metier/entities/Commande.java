package metier.entities;

public class Commande {
	
	private int idcmd;
	private int idclient;
	private String libellecmd;
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(int idclient, String libellecmd) {
		super();
		this.idclient = idclient;
		this.libellecmd = libellecmd;
	}
	public int getIdcmd() {
		return idcmd;
	}
	public void setIdcmd(int idcmd) {
		this.idcmd = idcmd;
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String getLibellecmd() {
		return libellecmd;
	}
	public void setLibellecmd(String libellecmd) {
		this.libellecmd = libellecmd;
	}
	@Override
	public String toString() {
		return "Commande [idcmd=" + idcmd + ", idclient=" + idclient + ", libellecmd=" + libellecmd + "]";
	}
	

}
