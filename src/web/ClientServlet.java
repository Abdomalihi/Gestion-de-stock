package web;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDaoImpl;
import dao.IClientDAO;
import metier.entities.Client;

public class ClientServlet extends HttpServlet {
	
	private IClientDAO metier;

	@Override
	public void init() throws ServletException {
		metier = new ClientDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/client-index.html")) {
			response.sendRedirect("client-chercher.html?motcle="); 
		}
		else if (path.equals("/client-chercher.html")) {
			String motcle=request.getParameter("motcle");
			ClientModel model =new ClientModel();
			model.setMotcle(motcle);
			List<Client> clients=metier.rechercher("%"+motcle+"%");
			model.setClients(clients);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Client.jsp").forward(request, response);
			
		}
		else if (path.equals("/client-ajouter.html") && (request.getMethod().equals("POST"))) {
			String nom=request.getParameter("nomclt");
			String prenom=request.getParameter("prenomclt");
			String adresse=request.getParameter("adresseclt");
			String email=request.getParameter("emailclt");
			String tel=request.getParameter("telclt");
			Client c=metier.ajouter(new Client(nom, prenom, adresse, email, tel));
			request.setAttribute("client", c);
			//request.getRequestDispatcher("/WEB-INF/AjouterClient.jsp").forward(request, response);
			response.sendRedirect("client-chercher.html?motcle=");
		}
		else if (path.equals("/client-supprimer.html")) {
			int idclient=Integer.parseInt(request.getParameter("idclient"));
			metier.deleteClient(idclient);
			//request.getRequestDispatcher("/WEB-INF/Client.jsp").forward(request, response);
			response.sendRedirect("client-chercher.html?motcle=");
		}
		else if (path.equals("/client-modifier.html")) {
			int idclient=Integer.parseInt(request.getParameter("idclient"));
			Client c=metier.afficher(idclient);
			request.setAttribute("client", c);
			request.getRequestDispatcher("/WEB-INF/modifierClient.jsp").forward(request, response);
		}
		else if (path.equals("/client-update.html") && (request.getMethod().equals("POST"))) {
			int idclient=Integer.parseInt(request.getParameter("idclient"));
			String nom=request.getParameter("nomclt");
			String prenom=request.getParameter("prenomclt");
			String adresse=request.getParameter("adresseclt");
			String email=request.getParameter("emailclt");
			String tel=request.getParameter("telclt");
			Client c=new Client(nom, prenom, adresse, email, tel);
			c.setIdclient(idclient);
			metier.modifier(c);
			request.setAttribute("client", c);
			//request.getRequestDispatcher("/WEB-INF/AjouterClient.jsp").forward(request, response);
			response.sendRedirect("client-chercher.html?motcle=");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
}
