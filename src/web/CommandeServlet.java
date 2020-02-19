package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommandeDaoImpl;
import dao.ICommandeDAO;
import metier.entities.Commande;


public class CommandeServlet extends HttpServlet {
	private ICommandeDAO metiercommande;
	
	@Override
	public void init() throws ServletException {
		metiercommande = new CommandeDaoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("commande.html")) {
			response.sendRedirect("chercherCommande.html?codecommande="); 
		}
		else if (path.equals("chercherCommande.html")) {
			int codecommande=Integer.parseInt(request.getParameter("codecommande"));
			CommandeModel model =new CommandeModel();
			model.setCodecommande(codecommande);
			List<Commande> commandes=metiercommande.rechercher(codecommande);
			model.setCommandes(commandes);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Commande.jsp").forward(request, response);
			
		}
		else if (path.equals("ajouterCommande.html") && (request.getMethod().equals("POST"))) {
			int idclient=Integer.parseInt(request.getParameter("idclient"));
			String libellecmd=request.getParameter("libellecmd");
			Commande c=metiercommande.ajouter(new Commande(idclient, libellecmd));
			request.setAttribute("commande", c);
			response.sendRedirect("chercherCommande.html?codecommande=");
		}
		else if (path.equals("supprimerCommande.html")) {
			int idcmd=Integer.parseInt(request.getParameter("idcmd"));
			metiercommande.deleteCommande(idcmd);
			response.sendRedirect("chercherCommande.html?motcle=");
		}
		else if (path.equals("modifierCommande.html")) {
			int idcmd=Integer.parseInt(request.getParameter("idcmd"));
			Commande c=metiercommande.afficher(idcmd);
			request.setAttribute("commande", c);
			request.getRequestDispatcher("modifierCommande.jsp").forward(request, response);
		}
		else if (path.equals("updateCommande.html") && (request.getMethod().equals("POST"))) {
			int idcmd=Integer.parseInt(request.getParameter("idcmd"));
			int idclient=Integer.parseInt(request.getParameter("idclient"));
			String libellecmd=request.getParameter("libellecmd");
			Commande c=new Commande(idclient, libellecmd) ;
			c.setIdcmd(idcmd);
			metiercommande.modifier(c);
			request.setAttribute("commande", c);
			response.sendRedirect("chercherCommande.html?motcle=");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
