package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.entities.Gestionnaire;

public class AuthentificationDaoImpl implements IAuthentificationDAO {

	@Override
	public boolean valider(Gestionnaire g) {
		boolean status=false;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement(" SELECT * FROM GESTIONNAIRE WHERE LOGIN=? AND PASSWORD=?");
			ps.setString(1, g.getLogin());
			ps.setString(2, g.getPassword());
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return status;
	}
	

}
