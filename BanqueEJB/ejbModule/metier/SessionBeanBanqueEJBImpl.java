package metier;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Compte;


@Stateless(name="Banque")
public class SessionBeanBanqueEJBImpl implements IBanqueLocal, IBanqueRemote{

	//ici optionel, parce que n'a qu'une seule unité de persistence
	//sinon on peut   creer des 'em1' 'em2' .. a chaque 'unite_persistence1' 'unite_persistence1'...
	@PersistenceContext(unitName="BanqueEJB") 
	private EntityManager em;
	
	

    public SessionBeanBanqueEJBImpl() {   
    }

    
    
    
	@Override
	public Compte addCompte(Compte compte) {
		em.persist(compte);
		return compte;
	}

	@Override
	public Compte getCompte(Long code) {
		Compte compte = em.find(Compte.class,code);
		if(compte == null) throw new RuntimeException("compte introuvable");
		return compte;
	}

	@Override
	public List<Compte> listeCompte() {
	Query requete = em.createQuery("select c from Compte c");
		return requete.getResultList();
	}

	@Override
	public void verser(Long code, double m) {
		Compte c = getCompte(code);
		c.setSolde(c.getSolde()+m);
		
	}

	@Override
	public void retirer(Long code, double m) {
		Compte c = getCompte(code);
		if(c.getSolde() < m) throw new RuntimeException("Solde insuffisant");
		c.setSolde(c.getSolde()-m);
		
	}

	@Override
	public void virement(Long code1, Long code2, double m) {
		retirer(code1, m);
		verser(code2,m);
		
		
	}

}
