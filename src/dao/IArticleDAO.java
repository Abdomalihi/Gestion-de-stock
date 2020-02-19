package dao;

import java.util.List;

import metier.entities.Article;

public interface IArticleDAO {
	public Article ajouter(Article a);
	public Article afficher(int idarticle);
	public Article modifier(Article a);
	public List<Article> rechercher(String mc);
	public void deleteArticle(int idarticle);
	
	

}
