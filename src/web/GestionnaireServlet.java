package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import dao.ClientDaoImpl;
import dao.GestionnaireDaoImpl;
import dao.IClientDAO;
import dao.IGestionnaireDAO;
import metier.entities.Client;
import metier.entities.Gestionnaire;

public class GestionnaireServlet extends HttpServlet {
	
	private IGestionnaireDAO metier;

	@Override
	public void init() throws ServletException {
		metier = new GestionnaireDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/gestionnaire-index.html")) {
			response.sendRedirect("chercher-gestionnaire.html?motcle="); 
		}
		else if (path.equals("/gestionnaire-chercher.html")) {
			String motcle=request.getParameter("motcle");
			GestionnaireModel model =new GestionnaireModel();
			model.setMotcle(motcle);
			List<Gestionnaire> gestionnaires=metier.rechercher("%"+motcle+"%");
			model.setGestionnaires(gestionnaires);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/Gestionnaire.jsp").forward(request, response);
			
		}
		else if (path.equals("/gestionnaire-ajouter.html") && (request.getMethod().equals("POST"))) {
			String login=request.getParameter("login");
			String password=request.getParameter("password");
			String nomuser=request.getParameter("nomuser");
			String prenomuser=request.getParameter("prenomuser");
			String emailuser=request.getParameter("emailuser");
			String teluser=request.getParameter("teluser");
			String typeuser=request.getParameter("typeuser");
			Gestionnaire g=metier.ajouter(new Gestionnaire(login, password, nomuser, prenomuser, teluser, emailuser, typeuser));
			request.setAttribute("gestionnaire", g);
			response.sendRedirect("gestionnaire-chercher.html?motcle=");
		}
		else if (path.equals("/gestionnaire-supprimer.html")) {
			int iduser=Integer.parseInt(request.getParameter("iduser"));
			metier.deleteGestionnaire(iduser);
			response.sendRedirect("gestionnaire-chercher.html?motcle=");
		}
		else if (path.equals("/gestionnaire-modifier.html")) {
			int iduser=Integer.parseInt(request.getParameter("iduser"));
			Gestionnaire g=metier.afficher(iduser);
			request.setAttribute("gestionnaire", g);
			request.getRequestDispatcher("/WEB-INF/modifierGestionnaire.jsp").forward(request, response);
		}
		else if (path.equals("/gestionnaire-update.html") && (request.getMethod().equals("POST"))) {
			int iduser=Integer.parseInt(request.getParameter("iduser"));
			String login=request.getParameter("login");
			String password=request.getParameter("password");
			String nomuser=request.getParameter("nomuser");
			String prenomuser=request.getParameter("prenomuser");
			String emailuser=request.getParameter("emailuser");
			String teluser=request.getParameter("teluser");
			String typeuser=request.getParameter("typeuser");
			Gestionnaire g=new Gestionnaire(login, password, nomuser, prenomuser, teluser, emailuser, typeuser);
			g.setIduser(iduser);
			metier.modifier(g);
			request.setAttribute("gestionnaire", g);
			response.sendRedirect("gestionnaire-chercher.html?motcle=");
		}
		else {
			
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
}
