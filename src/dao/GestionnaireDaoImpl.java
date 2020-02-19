package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Fournisseur;
import metier.entities.Gestionnaire;

public class GestionnaireDaoImpl implements IGestionnaireDAO {

	@Override
	public Gestionnaire ajouter(Gestionnaire g) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO `gestionnaire`( `LOGIN`, `PASSWORD`, `NOMUSER`, `PRENOMUSER`, `EMAILUSER`, `TELUSER`, `TYPEUSER`)"
							+ " (?,?,?,?,?,?,?)");
			ps.setString(1, g.getLogin());
			ps.setString(2, g.getPassword());
			ps.setString(3, g.getNomuser());
			ps.setString(4, g.getPrenomuser());
			ps.setString(5, g.getEmailuser());
			ps.setString(6, g.getTeluser());
			ps.setString(7, g.getTypeuser());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}

	@Override
	public Gestionnaire afficher(int iduser) {
		Gestionnaire g=null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM GESTIONNAIRE WHERE IDUSER LIKE ?");
			ps.setInt(1, iduser);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				g=new Gestionnaire();
				g.setIduser(rs.getInt("IDUSER"));
				g.setLogin(rs.getString("LOGIN"));
				g.setPassword(rs.getString("PASSWORD"));
				g.setNomuser(rs.getString("NOMUSER"));
				g.setPrenomuser(rs.getString("PRENOMUSER"));
				g.setEmailuser(rs.getString("EMAILUSER"));
				g.setTeluser(rs.getString("TELUSER"));
				g.setTypeuser(rs.getString("TYPEUSER"));
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return g;
	}

	@Override
	public Gestionnaire modifier(Gestionnaire g) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("UPDATE `gestionnaire` SET `LOGIN`=?,`PASSWORD`=?,`NOMUSER`=?,`PRENOMUSER`=?,`EMAILUSER`=?,`TELUSER`=?,`TYPEUSER`=? WHERE  `IDUSER`=? ");
			ps.setString(1, g.getLogin());
			ps.setString(2, g.getPassword());
			ps.setString(3, g.getNomuser());
			ps.setString(4, g.getPrenomuser());
			ps.setString(5, g.getEmailuser());
			ps.setString(6, g.getTeluser());
			ps.setString(7, g.getTypeuser());
			ps.setInt(8, g.getIduser());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}

	@Override
	public List<Gestionnaire> rechercher(String mc) {
		List<Gestionnaire> gestionnaires=new ArrayList<Gestionnaire>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM GESTIONNAIRE WHERE LOGIN LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Gestionnaire g=new Gestionnaire();
				g.setIduser(rs.getInt("IDUSER"));
				g.setLogin(rs.getString("LOGIN"));
				g.setPassword(rs.getString("PASSWORD"));
				g.setNomuser(rs.getString("NOMUSER"));
				g.setPrenomuser(rs.getString("PRENOMUSER"));
				g.setEmailuser(rs.getString("EMAILUSER"));
				g.setTeluser(rs.getString("TELUSER"));
				g.setTypeuser(rs.getString("TYPEUSER"));
				gestionnaires.add(g);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gestionnaires;
	}

	@Override
	public void deleteGestionnaire(int iduser) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("DELETE FROM GESTIONNAIRE WHERE IDUSER=?");
			ps.setInt(1, iduser);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
