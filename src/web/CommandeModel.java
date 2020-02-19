package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Commande;

public class CommandeModel {
	private int codecommande;
	private List<Commande> commandes=new ArrayList<Commande>();
	public int getCodecommande() {
		return codecommande;
	}
	public void setCodecommande(int codecommande) {
		this.codecommande = codecommande;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
