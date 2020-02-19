package web;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthentificationDaoImpl;
import dao.IAuthentificationDAO;
import metier.entities.Gestionnaire;

public class AuthentificationServlet extends HttpServlet {
	
	private IAuthentificationDAO metier;

	@Override
	public void init() throws ServletException {
		metier = new AuthentificationDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/login") && (request.getMethod().equals("POST"))) {
			String login=request.getParameter("login");
			String password=request.getParameter("password");
			Gestionnaire g=new Gestionnaire();
			g.setLogin(login);
			g.setPassword(password);
			try {
				if (metier.valider(g)) {
					response.sendRedirect("Dashboard.jsp");
				}else {
					response.sendRedirect("Authentification.jsp");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			 
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
}
