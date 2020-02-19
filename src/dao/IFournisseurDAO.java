package dao;

import java.util.List;


import metier.entities.Fournisseur;

public interface IFournisseurDAO {
	public Fournisseur ajouter(Fournisseur f);
	public Fournisseur afficher(int idfour);
	public Fournisseur modifier(Fournisseur f);
	public List<Fournisseur> rechercher(String mc);
	public void deleteFournisseur(int idfour);

}
