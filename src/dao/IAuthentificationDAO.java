package dao;

import metier.entities.Gestionnaire;

public interface IAuthentificationDAO {
	public boolean valider(Gestionnaire g);

}
