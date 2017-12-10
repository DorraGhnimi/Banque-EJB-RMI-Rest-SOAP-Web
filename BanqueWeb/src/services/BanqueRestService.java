package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.IBanqueLocal;
import metier.entities.Compte;

@Stateless
@Path("/myRestService")
public class BanqueRestService {
	
	
	//lorsque j'utilise @EJB, cette classe elle meme devient un composat EJB, et donc je dois preciserr "@Stateless" ou autre..
	//le SOAP ws on a pas besoin , JBOSS interprete "@Webservice" comme un composant EJB 
	//deja on peut utiliser @Webservice (SOAP ws )dans un projet EJB sans le mettre  ds un projet web ..
	@EJB
	private IBanqueLocal metier;

	
	
	
	
	@POST
	@Path("/comptes")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // 
	public Compte addCompte(Compte c) {
		return metier.addCompte(c);
	}

	
	@GET
	@Path("/comptes/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(
			@PathParam(value="code") Long code) {
		return metier.getCompte(code);
	}

	
	@GET
	@Path("/comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> listeCompte() {
		return metier.listeCompte();
	}

	
	
	
	@PUT
	@Path("/comptes/verser")
	@Produces(MediaType.APPLICATION_JSON)
	public void verser(
			@FormParam(value="code")Long code,
			@FormParam(value="montant")double m) {
		metier.verser(code, m);
	}

	
	
	@PUT
	@Path("/comptes/retirer")
	@Produces(MediaType.APPLICATION_JSON)
	public void retirer(
			@FormParam(value="code")Long code,
			@FormParam(value="montant")double m) {
		metier.retirer(code, m);
	}

	
	
	
	
	@PUT
	@Path("/comptes/virement")
	@Produces(MediaType.APPLICATION_JSON)
	public void virement(
			@FormParam(value="code1")Long code1,
			@FormParam(value="code2")Long code2,
			@FormParam(value="montant")double m) {
		metier.virement(code1, code2, m);
	}
	
	
	
	
	
}
