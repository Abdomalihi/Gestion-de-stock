package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import dao.ArticleDaoImpl;
import dao.ClientDaoImpl;
import dao.GestionnaireDaoImpl;
import dao.IArticleDAO;
import dao.IClientDAO;
import dao.IGestionnaireDAO;
import metier.entities.Article;
import metier.entities.Client;
import metier.entities.Gestionnaire;

public class ArticleServlet extends HttpServlet {
	
	private IArticleDAO metier;

	@Override
	public void init() throws ServletException {
		metier = new ArticleDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/article-index.html")) {
			response.sendRedirect("article-chercher.html?motcle="); 
		}
		else if (path.equals("/article-chercher.html")) {
			String motcle=request.getParameter("motcle");
			ArticleModel model =new ArticleModel();
			model.setMotcle(motcle);
			List<Article> articles=metier.rechercher("%"+motcle+"%");
			model.setArticles(articles);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/Article.jsp").forward(request, response);
			
		}
		else if (path.equals("/article-ajouter.html") && (request.getMethod().equals("POST"))) {
			int qttestock=Integer.parseInt(request.getParameter("qttestock"));
			String nomarticle=request.getParameter("nomarticle");
			String designation=request.getParameter("designation");
			Article a=metier.ajouter(new Article(qttestock, nomarticle, designation));
			request.setAttribute("article", a);
			response.sendRedirect("article-chercher.html?motcle=");
		}
		else if (path.equals("/article-supprimer.html")) {
			int idarticle=Integer.parseInt(request.getParameter("idarticle"));
			metier.deleteArticle(idarticle);
			response.sendRedirect("article-chercher.html?motcle=");
		}
		else if (path.equals("/article-modifier.html")) {
			int idarticle=Integer.parseInt(request.getParameter("idarticle"));
			Article a=metier.afficher(idarticle);
			request.setAttribute("article", a);
			request.getRequestDispatcher("/WEB-INF/modifierArticle.jsp").forward(request, response);
		}
		else if (path.equals("/article-update.html") && (request.getMethod().equals("POST"))) {
			int idarticle=Integer.parseInt(request.getParameter("idarticle"));
			int qttestock=Integer.parseInt(request.getParameter("qttestock"));
			String nomarticle=request.getParameter("nomarticle");
			String designation=request.getParameter("designation");
			Article a=new Article(qttestock, nomarticle, designation);
			a.setIdarticle(idarticle);
			metier.modifier(a);
			request.setAttribute("article", a);
			response.sendRedirect("chercher.html?motcle=");
		}
		else {
			
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
}
