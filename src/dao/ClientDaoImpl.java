	package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Client;

public class ClientDaoImpl implements IClientDAO{

	@Override
	public Client ajouter(Client c) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO CLIENT ( `NOMCLT`, `PRENOMCLT`, `ADRESSECLT`, `EMAILCLT`, `TELCLT`) VALUES (?,?,?,?,?)");
			ps.setString(1, c.getNomclt());
			ps.setString(2, c.getPrenomclt());
			ps.setString(3, c.getAdresseclt());
			ps.setString(4, c.getEmailclt());
			ps.setString(5, c.getTelclt());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Client afficher(int id) {
		Client c=null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM CLIENT WHERE IDCLIENT LIKE ?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				c=new Client();
				c.setIdclient(rs.getInt("IDCLIENT"));
				c.setNomclt(rs.getString("NOMCLT"));
				c.setPrenomclt(rs.getString("PRENOMCLT"));
				c.setAdresseclt(rs.getString("ADRESSECLT"));
				c.setEmailclt(rs.getString("EMAILCLT"));
				c.setTelclt(rs.getString("TELCLT"));
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public Client modifier(Client c) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("UPDATE `client` SET `NOMCLT`=?,`PRENOMCLT`=?,`ADRESSECLT`=?,`EMAILCLT`=?,`TELCLT`=? WHERE  `IDCLIENT`=? ");
			ps.setString(1, c.getNomclt());
			ps.setString(2, c.getPrenomclt());
			ps.setString(3, c.getAdresseclt());
			ps.setString(4, c.getEmailclt());
			ps.setString(5, c.getTelclt());
			ps.setInt(6, c.getIdclient());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Client> rechercher(String mc) {
		List<Client> clients=new ArrayList<Client>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM CLIENT WHERE NOMCLT LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Client c=new Client();
				c.setIdclient(rs.getInt("IDCLIENT"));
				c.setNomclt(rs.getString("NOMCLT"));
				c.setPrenomclt(rs.getString("PRENOMCLT"));
				c.setAdresseclt(rs.getString("ADRESSECLT"));
				c.setEmailclt(rs.getString("EMAILCLT"));
				c.setTelclt(rs.getString("TELCLT"));
				clients.add(c);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clients;
	}

	@Override
	public void deleteClient(int idclient) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("DELETE FROM CLIENT WHERE IDCLIENT=?");
			ps.setInt(1, idclient);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
