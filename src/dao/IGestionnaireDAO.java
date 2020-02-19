package dao;

import java.util.List;

import metier.entities.Gestionnaire;


public interface IGestionnaireDAO {
	public Gestionnaire ajouter(Gestionnaire g);
	public Gestionnaire afficher(int iduser);
	public Gestionnaire modifier(Gestionnaire g);
	public List<Gestionnaire> rechercher(String mc);
	public void deleteGestionnaire(int iduser);

}
