package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Client;

public class ClientModel {
	private String motcle;
	private List<Client> clients = new ArrayList<Client>();
	public String getMotcle() {
		return motcle;
	}
	public void setMotcle(String motcl) {
		this.motcle = motcle;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	

}
