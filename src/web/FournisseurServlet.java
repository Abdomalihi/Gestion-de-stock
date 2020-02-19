package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FournisseurDaoImpl;
import dao.IFournisseurDAO;
import metier.entities.Fournisseur;



public class FournisseurServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IFournisseurDAO metier;

	@Override
	public void init() throws ServletException {
		metier = new FournisseurDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OK");
		String path=request.getServletPath();
		if (path.equals("/fournisseur.html")) {
			//request.getRequestDispatcher("/Fournisseur.jsp").forward(request, response);
			response.sendRedirect("chercherFournisseur.html?motcle="); 
		}
		else if (path.equals("chercherFournisseur.html")) {
			String motcle=request.getParameter("motcle");
			FournisseurModel model =new FournisseurModel();
			model.setMotcle(motcle);
			List<Fournisseur> fournisseurs=metier.rechercher("%"+motcle+"%");
			model.setFournisseurs(fournisseurs);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/Fournisseur.jsp").forward(request, response);
			
		}
		else if (path.equals("ajouterFournisseur.html") && (request.getMethod().equals("POST"))) {
			String nom=request.getParameter("nomfour");
			String prenom=request.getParameter("prenomfour");
			String adresse=request.getParameter("adressefour");
			String email=request.getParameter("emailfour");
			String tel=request.getParameter("telfour");
			Fournisseur f=metier.ajouter(new Fournisseur(nom, prenom, adresse, email, tel));
			request.setAttribute("fournisseur", f);
			response.sendRedirect("chercherFournisseur.html?motcle=");
		}
		else if (path.equals("supprimerFournisseur.html")) {
			int idfour=Integer.parseInt(request.getParameter("idfour"));
			metier.deleteFournisseur(idfour);
			response.sendRedirect("chercherFournisseur.html?motcle=");
		}
		else if (path.equals("modifierFournisseur.html")) {
			int idfour=Integer.parseInt(request.getParameter("idfour"));
			Fournisseur f=metier.afficher(idfour);
			request.setAttribute("fournisseur", f);
			request.getRequestDispatcher("modifierFournisseur.jsp").forward(request, response);
		}
		else if (path.equals("updateFournisseur.html") && (request.getMethod().equals("POST"))) {
			int idfour=Integer.parseInt(request.getParameter("idfour"));
			String nom=request.getParameter("nomfour");
			String prenom=request.getParameter("prenomfour");
			String adresse=request.getParameter("adressefour");
			String email=request.getParameter("emailfour");
			String tel=request.getParameter("telfour");
			Fournisseur f=new Fournisseur(nom, prenom, adresse, email, tel);
			f.setIdfour(idfour);
			metier.modifier(f);
			request.setAttribute("fournisseur", f);
			response.sendRedirect("chercherFournisseur.html?motcle=");
		}else {
			System.out.println("OK");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
