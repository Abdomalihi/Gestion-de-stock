package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ILivraisonDAO;
import dao.LivraisonDaoImpl;
import metier.entities.Livraison;



public class LivraisonServlet extends HttpServlet {
	private ILivraisonDAO metierlivraison;
	
	@Override
	public void init() throws ServletException {
		metierlivraison = new LivraisonDaoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("livraison.html")) {
			response.sendRedirect("chercherLivraison.html?codelivraison="); 
		}
		else if (path.equals("chercherLivraison.html")) {
			int codelivraison=Integer.parseInt(request.getParameter("codelivraison"));
			LivraisonModel model =new LivraisonModel();
			model.setCodelivraison(codelivraison);
			List<Livraison> livraisons=metierlivraison.rechercher(codelivraison);
			model.setLivraisons(livraisons);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Livraison.jsp").forward(request, response);
			
		}
		else if (path.equals("ajouterLivraison.html") && (request.getMethod().equals("POST"))) {
			int idfour=Integer.parseInt(request.getParameter("idfour"));
			String libellelivraison=request.getParameter("libellelivraison");
			Livraison l=metierlivraison.ajouter(new Livraison(idfour, libellelivraison));
			request.setAttribute("livraison", l);
			response.sendRedirect("chercherLivraison.html?codelivraison=");
		}
		else if (path.equals("supprimerLivraison.html")) {
			int idlivraison=Integer.parseInt(request.getParameter("idlivraison"));
			metierlivraison.deleteLivraison(idlivraison);
			response.sendRedirect("chercherLivraison.html?codelivraison=");
		}
		else if (path.equals("modifierLivraison.html")) {
			int idlivraison=Integer.parseInt(request.getParameter("idlivraison"));
			Livraison l=metierlivraison.afficher(idlivraison);
			request.setAttribute("livraison", l);
			request.getRequestDispatcher("modifierLivraison.jsp").forward(request, response);
		}
		else if (path.equals("updateLivraison.html") && (request.getMethod().equals("POST"))) {
			int idlivraison=Integer.parseInt(request.getParameter("idlivraison"));
			int idfour=Integer.parseInt(request.getParameter("idfour"));
			String libellelivraison=request.getParameter("libellelivraison");
			Livraison l=new Livraison(idfour, libellelivraison) ;
			l.setIdlivraison(idlivraison);
			metierlivraison.modifier(l);
			request.setAttribute("livraison", l);
			response.sendRedirect("chercherLivraison.html?codelivraison=");
		}
	}

}
