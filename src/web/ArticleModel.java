package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Article;



public class ArticleModel {
	private String motcle;
	private List<Article> articles = new ArrayList<Article>();
	public String getMotcle() {
		return motcle;
	}
	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
