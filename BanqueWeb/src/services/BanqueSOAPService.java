package services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.IBanqueLocal;
import metier.entities.Compte;

@WebService
public class BanqueSOAPService {

	
	@EJB
	private IBanqueLocal metier;
	

	
	@WebMethod
	public Compte addCompte(
			@WebParam(name="solde")double solde) {
		Compte c = new Compte();
		c.setDateCreation(new Date());
		c.setSolde(solde);
		return metier.addCompte(c);
	}


	@WebMethod
	public Compte getCompte(
			@WebParam(name="code")Long code) {
		return metier.getCompte(code);
	}


	@WebMethod
	public List<Compte> listeCompte() {
		return metier.listeCompte();
	}



	@WebMethod
	public void verser(
			@WebParam(name="code")Long code,
			@WebParam(name="montant")double montant) {
		metier.verser(code, montant);
	}
	
	
	
	@WebMethod
	public void retirer(
			@WebParam(name="code")Long code,
			@WebParam(name="montant")double montant) {
		metier.verser(code, montant);
	}
	
	
	
	@WebMethod
	public void virement(
			@WebParam(name="code1")Long code1,
			@WebParam(name="code2")Long code2,
			@WebParam(name="montant")double m) {
		metier.virement(code1, code2, m);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
