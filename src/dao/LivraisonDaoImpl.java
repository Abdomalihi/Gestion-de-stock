package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Commande;
import metier.entities.Livraison;

public class LivraisonDaoImpl  implements ILivraisonDAO{

	@Override
	public Livraison ajouter(Livraison l) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO `livraison`(`IDFOUR`, `LIBELLELIVRAISON`) VALUES (?,?)");
			ps.setInt(1, l.getIdfour());
			ps.setString(2, l.getLibellelivraison());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Livraison afficher(int idlivraison) {
		Livraison l=null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM `commande` WHERE IDCMD LIKE ?");
			ps.setInt(1, idlivraison);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				l=new Livraison();
				l.setIdlivraison(rs.getInt("IDLIVRAISON"));
				l.setIdfour(rs.getInt("IDFOUR"));
				l.setLibellelivraison(rs.getString("LIBELLELIVRAISON"));
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public Livraison modifier(Livraison l) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("UPDATE `livraison` SET `IDFOUR`=?,`LIBELLELIVRAISON`=? WHERE `IDLIVRAISON`=?");
			ps.setInt(1, l.getIdfour());
			ps.setString(2, l.getLibellelivraison());
			ps.setInt(3, l.getIdlivraison());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Livraison> rechercher(int code) {
		List<Livraison> livraisons=new ArrayList<Livraison>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM `livraison` WHERE `IDLIVRAISON` LIKE ? ");
			ps.setInt(1, code);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Livraison l=new Livraison();
				l.setIdlivraison(rs.getInt("IDCMD"));
				l.setIdfour(rs.getInt("IDCLIENT"));
				l.setLibellelivraison(rs.getString("LIBELLECMD"));
				livraisons.add(l);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return livraisons;
	}

	@Override
	public void deleteLivraison(int idlivraison) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("DELETE FROM `livraison` WHERE IDLIVRAISON=?");
			ps.setInt(1, idlivraison);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
