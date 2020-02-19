package metier.entities;

import java.sql.Date;

public class composer {
	private int idcomposer;
	private int idcmd;
	private int idarticle;
	private int qttecmd;
	private Date datecmd;
	private double prixcmd;
	public composer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public composer(int idcmd, int idarticle, int qttecmd, Date datecmd, double prixcmd) {
		super();
		this.idcmd = idcmd;
		this.idarticle = idarticle;
		this.qttecmd = qttecmd;
		this.datecmd = datecmd;
		this.prixcmd = prixcmd;
	}
	public int getIdcomposer() {
		return idcomposer;
	}
	public void setIdcomposer(int idcomposer) {
		this.idcomposer = idcomposer;
	}
	public int getIdcmd() {
		return idcmd;
	}
	public void setIdcmd(int idcmd) {
		this.idcmd = idcmd;
	}
	public int getIdarticle() {
		return idarticle;
	}
	public void setIdarticle(int idarticle) {
		this.idarticle = idarticle;
	}
	public int getQttecmd() {
		return qttecmd;
	}
	public void setQttecmd(int qttecmd) {
		this.qttecmd = qttecmd;
	}
	public Date getDatecmd() {
		return datecmd;
	}
	public void setDatecmd(Date datecmd) {
		this.datecmd = datecmd;
	}
	public double getPrixcmd() {
		return prixcmd;
	}
	public void setPrixcmd(double prixcmd) {
		this.prixcmd = prixcmd;
	}
	@Override
	public String toString() {
		return "composer [idcomposer=" + idcomposer + ", idcmd=" + idcmd + ", idarticle=" + idarticle + ", qttecmd="
				+ qttecmd + ", datecmd=" + datecmd + ", prixcmd=" + prixcmd + "]";
	}
	

}
