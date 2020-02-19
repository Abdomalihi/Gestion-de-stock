package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import metier.entities.Commande;

public class CommandeDaoImpl implements ICommandeDAO {

	@Override
	public Commande ajouter(Commande c) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO `commande`(`IDCLIENT`, `LIBELLECMD`) VALUES (?,?)");
			ps.setInt(1, c.getIdclient());
			ps.setString(2, c.getLibellecmd());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Commande afficher(int idcmd) {
		Commande c=null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM `commande` WHERE IDCMD LIKE ?");
			ps.setInt(1, idcmd);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				c=new Commande();
				c.setIdcmd(rs.getInt("IDCMD"));
				c.setIdclient(rs.getInt("IDCLIENT"));
				c.setLibellecmd(rs.getString("LIBELLECMD"));
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public Commande modifier(Commande c) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("UPDATE `commande` SET `IDCLIENT`=?,`LIBELLECMD`=? WHERE WHERE  `IDCMD`=? ");
			ps.setInt(1, c.getIdclient());
			ps.setString(2, c.getLibellecmd());
			ps.setInt(3, c.getIdcmd());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Commande> rechercher(int code) {
		List<Commande> commandes=new ArrayList<Commande>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM `commande` WHERE `IDCMD` LIKE ? ");
			ps.setInt(1, code);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Commande c=new Commande();
				c.setIdcmd(rs.getInt("IDCMD"));
				c.setIdclient(rs.getInt("IDCLIENT"));
				c.setLibellecmd(rs.getString("LIBELLECMD"));
				commandes.add(c);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commandes;
	}

	@Override
	public void deleteCommande(int idcmd) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("DELETE FROM `commande` WHERE IDCMD=?");
			ps.setInt(1, idcmd);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
