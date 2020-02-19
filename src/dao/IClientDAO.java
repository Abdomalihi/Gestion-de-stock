package dao;

import java.util.List;

import metier.entities.Client;

public interface IClientDAO {
	public Client ajouter(Client c);
	public Client afficher(int idclient);
	public Client modifier(Client c);
	public List<Client> rechercher(String mc);
	public void deleteClient(int idclient);

}
