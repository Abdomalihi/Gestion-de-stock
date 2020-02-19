package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Fournisseur;



public class FournisseurModel {
	private String motcle;
	private List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
	public String getMotcle() {
		return motcle;
	}
	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	
}
