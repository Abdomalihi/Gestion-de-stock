package dao;

import java.util.List;

import metier.entities.Commande;


public interface ICommandeDAO {
	public Commande ajouter(Commande c);
	public Commande afficher(int idcmd);
	public Commande modifier(Commande c);
	public List<Commande> rechercher(int code);
	public void deleteCommande(int idcmd);

}
