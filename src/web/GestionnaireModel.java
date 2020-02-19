package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Fournisseur;
import metier.entities.Gestionnaire;



public class GestionnaireModel {
	private String motcle;
	private List<Gestionnaire> gestionnaires = new ArrayList<Gestionnaire>();
	public List<Gestionnaire> getGestionnaires() {
		return gestionnaires;
	}
	public void setGestionnaires(List<Gestionnaire> gestionnaires) {
		this.gestionnaires = gestionnaires;
	}
	public String getMotcle() {
		return motcle;
	}
	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
	
	
	
}
