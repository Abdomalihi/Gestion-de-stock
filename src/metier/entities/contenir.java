package metier.entities;

import java.sql.Date;

public class contenir {
	private int idcontenir;
	private int idlivraison;
	private int idarticle;
	private int qttelivre;
	private Date datelivre;
	private double prixlivre;
	public contenir() {
		super();
		// TODO Auto-generated constructor stub
	}
	public contenir(int idlivraison, int idarticle, int qttelivre, Date datelivre, double prixlivre) {
		super();
		this.idlivraison = idlivraison;
		this.idarticle = idarticle;
		this.qttelivre = qttelivre;
		this.datelivre = datelivre;
		this.prixlivre = prixlivre;
	}
	public int getIdcontenir() {
		return idcontenir;
	}
	public void setIdcontenir(int idcontenir) {
		this.idcontenir = idcontenir;
	}
	public int getIdlivraison() {
		return idlivraison;
	}
	public void setIdlivraison(int idlivraison) {
		this.idlivraison = idlivraison;
	}
	public int getIdarticle() {
		return idarticle;
	}
	public void setIdarticle(int idarticle) {
		this.idarticle = idarticle;
	}
	public int getQttelivre() {
		return qttelivre;
	}
	public void setQttelivre(int qttelivre) {
		this.qttelivre = qttelivre;
	}
	public Date getDatelivre() {
		return datelivre;
	}
	public void setDatelivre(Date datelivre) {
		this.datelivre = datelivre;
	}
	public double getPrixlivre() {
		return prixlivre;
	}
	public void setPrixlivre(double prixlivre) {
		this.prixlivre = prixlivre;
	}
	@Override
	public String toString() {
		return "contenir [idcontenir=" + idcontenir + ", idlivraison=" + idlivraison + ", idarticle=" + idarticle
				+ ", qttelivre=" + qttelivre + ", datelivre=" + datelivre + ", prixlivre=" + prixlivre + "]";
	}
	

}
