package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.IBanqueLocal;
import metier.entities.Compte;


@WebServlet(name="cs",urlPatterns= {"/controller"})
public class Controller extends HttpServlet{
	
	
	@EJB
	private IBanqueLocal metier;
	
	
	/*
	   @EJB
	   	<<==>>
	   	//dans le constructeur 
	   Context ctx;
		try {
			ctx = new InitialContext();
			ctx.lookup("ejb:/BanqueEJB/Banque!meteir.IBanqueLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	  	//recuperer l'obj de l'annuaire : code technique, lucky us, Jboss will do it for us
	  
	 */
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		request.getRequestDispatcher("myBanque.jsp").forward(request, response);
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		double montant = Double.parseDouble(request.getParameter("montant"));
		String action = request.getParameter("action");
		
		if(action.equals("verser")) {
			Long code = Long.parseLong(request.getParameter("code"));
			metier.verser(code, montant);
		}else if(action.equals("retirer")){
			Long code = Long.parseLong(request.getParameter("code"));
			metier.retirer(code, montant);
		}else if(action.equals("virement")) {
			Long code1 = Long.parseLong(request.getParameter("code1"));
			Long code2 = Long.parseLong(request.getParameter("code2"));
			metier.virement(code1,code2, montant);
		}
	
		
		List<Compte> comptes = new ArrayList<>();
		comptes = metier.listeCompte();
		request.setAttribute("comptes", comptes);
		doGet(request, response);
		
		
		
		
		
	}
	
	
	
	
	
	

}
