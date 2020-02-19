package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Client;
import metier.entities.Fournisseur;

public class FournisseurDaoImpl implements IFournisseurDAO{

	@Override
	public Fournisseur ajouter(Fournisseur f) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO FOURNISSEUR ( `NOMFOUR`, `PRENOMFOUR`, `ADRESSEFOUR`, `EMAILFOUR`, `TELFOUR`) VALUES (?,?,?,?,?)");
			ps.setString(1, f.getNomfour());
			ps.setString(2, f.getPrenomfour());
			ps.setString(3, f.getAdressefour());
			ps.setString(4, f.getEmailfour());
			ps.setString(5, f.getTelfour());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public Fournisseur afficher(int idfour) {
		Fournisseur f=null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM FOURNISSEUR WHERE IDFOUR LIKE ?");
			ps.setInt(1, idfour);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				f=new Fournisseur();
				f.setIdfour(rs.getInt("IDFOUR"));
				f.setNomfour(rs.getString("NOMFOUR"));
				f.setPrenomfour(rs.getString("PRENOMFOUR"));
				f.setAdressefour(rs.getString("ADRESSEFOUR"));
				f.setEmailfour(rs.getString("EMAILFOUR"));
				f.setTelfour(rs.getString("TELFOUR"));
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public Fournisseur modifier(Fournisseur f) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("UPDATE FOURNISSEUR SET `NOMFOUR`=?,`PRENOMFOUR`=?,`ADRESSEFOUR`=?,`EMAILFOUR`=?,`TELFOUR`=? WHERE  `IDFOUR`=? ");
			ps.setString(1, f.getNomfour());
			ps.setString(2, f.getPrenomfour());
			ps.setString(3, f.getAdressefour());
			ps.setString(4, f.getEmailfour());
			ps.setString(5, f.getTelfour());
			ps.setInt(6, f.getIdfour());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Fournisseur> rechercher(String mc) {
		List<Fournisseur> fournisseurs=new ArrayList<Fournisseur>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM FOURNISSEUR WHERE NOMCLT LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Fournisseur f=new Fournisseur();
				f.setIdfour(rs.getInt("IDFOUR"));
				f.setNomfour(rs.getString("NOMFOUR"));
				f.setPrenomfour(rs.getString("PRENOMFOUR"));
				f.setAdressefour(rs.getString("ADRESSEFOUR"));
				f.setEmailfour(rs.getString("EMAILFOUR"));
				f.setTelfour(rs.getString("TELFOUR"));
				fournisseurs.add(f);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fournisseurs;
	}

	@Override
	public void deleteFournisseur(int idfour) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("DELETE FROM FOURNISSEUR WHERE IDFOUR=?");
			ps.setInt(1, idfour);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
