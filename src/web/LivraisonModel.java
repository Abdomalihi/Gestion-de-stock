package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Livraison;

public class LivraisonModel {
	private int codelivraison;
	private List<Livraison> livraisons=new ArrayList<Livraison>();
	public int getCodelivraison() {
		return codelivraison;
	}
	public void setCodelivraison(int codelivraison) {
		this.codelivraison = codelivraison;
	}
	public List<Livraison> getLivraisons() {
		return livraisons;
	}
	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	
}
