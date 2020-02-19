package dao;

import java.util.List;

import metier.entities.Livraison;

public interface ILivraisonDAO {
	public Livraison ajouter(Livraison l);
	public Livraison afficher(int idlivraison);
	public Livraison modifier(Livraison l);
	public List<Livraison> rechercher(int code);
	public void deleteLivraison(int idlivraison);

}
