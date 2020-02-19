package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import metier.entities.Article;
import metier.entities.Client;

public class ArticleDaoImpl implements IArticleDAO {

	@Override
	public Article ajouter(Article a) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO ARTICLE ( `NOMARTICLE`, `DESIGNATION`, `QTTESTOCK`) VALUES (?,?,?)");
			ps.setString(1, a.getNomarticle());
			ps.setString(2, a.getDesignation());
			ps.setInt(3, a.getQttestock());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Article afficher(int idarticle) {
		Article a=null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM ARTICLE WHERE IDARTICLE LIKE ?");
			ps.setInt(1, idarticle);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				a=new Article();
				a.setIdarticle(rs.getInt("IDARTICLE"));
				a.setNomarticle(rs.getString("NOMARTICLE"));
				a.setDesignation(rs.getString("DESIGNATION"));
				a.setQttestock(rs.getInt("QTTESTOCK"));
				
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public Article modifier(Article a) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("UPDATE `article` SET `NOMARTICLE`=?,`DESIGNATION`=?,`QTTESTOCK`=? WHERE  `IDARTICLE`=? ");
			ps.setString(1, a.getNomarticle());
			ps.setString(2, a.getDesignation());
			ps.setInt(3, a.getQttestock());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Article> rechercher(String mc) {
		List<Article>articles=new ArrayList<Article>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM ARTICLE WHERE NOMARTICLE LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Article a=new Article();
				a.setIdarticle(rs.getInt("IDARTICLE"));
				a.setNomarticle(rs.getString("NOMARTICLE"));
				a.setDesignation(rs.getString("DESIGNATION"));
				a.setQttestock(rs.getInt("QTTESTOCK"));
				articles.add(a);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return articles;
	}

	@Override
	public void deleteArticle(int idarticle) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("DELETE FROM ARTICLE WHERE IDARTICLE=?");
			ps.setInt(1, idarticle);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
