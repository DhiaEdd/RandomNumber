package com.inti.formation.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inti.formation.metier.MetierJeu;
import com.inti.formation.models.ModelJeu;

/**
 * Servlet implementation class JeuController
 */
@WebServlet(name="controller",urlPatterns= {"/controller","*.php"})
public class JeuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ModelJeu model;
	MetierJeu metier;
	String gagnant = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JeuController() {
        super();
        // TODO Auto-generated constructor stub
    }
@Override
public void init() throws ServletException {
	metier=new MetierJeu();
	metier.genererNbSecret();
	
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("page.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String rep;
		
		if(session.getAttribute("modelJ")==null) {
			
			model=new ModelJeu();
			session.setAttribute("modelJ", model);
			
		}
		else {
			
			model=(ModelJeu) session.getAttribute("modelJ");
		}
		if(request.getParameter("action").equals("relancer")) {
			
			if(metier.isFin()==true)
			{
				metier.genererNbSecret();
				metier.setFin(false);
				model.setHistoriques(new ArrayList<String>());
				
			}
			else
				model.getHistoriques().add("Le jeu n'est pas encore fini");
			
			
		}
		else {
		model.setNombre(Integer.parseInt(request.getParameter("nombre")));
		rep=metier.jouer(model.getNombre());
		if(rep.indexOf("Bravo")>=0) {
			
			gagnant=request.getRemoteAddr();
		}
		if(rep.indexOf("Le jeu est terminé")>=0)
			rep=rep+", le gagnant est "+gagnant;
		
		model.getHistoriques().add(rep);
		
		
		
		}
		request.getRequestDispatcher("page.jsp").forward(request, response);

		
		
	}

}
