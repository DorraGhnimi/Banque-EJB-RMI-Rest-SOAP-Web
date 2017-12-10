import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.IBanqueRemote;
import metier.entities.Compte;

public class ClientRemote {

	public static void main(String[] args) {
		
		
		
		
		try {
			Context ctx = new InitialContext();
			String appName = "";
			String moduleName = "BanqueEJB";
			String beanName = "Banque";
			String remoteInterface = "metier.IBanqueRemote";    //IBanqueRemote.claas.getName();
			
			String name ="ejb:"+ appName+"/"+moduleName+"/"+beanName+"!"+remoteInterface;
			
			//IBanqueRemote proxy = (IBanqueRemote) ctx.lookup("BanqueEJB/Banque!metier.IBanqueRemote");
			IBanqueRemote proxy = (IBanqueRemote) ctx.lookup(name);
			
			
			
			/*proxy.addCompte(new Compte());
			proxy.addCompte(new Compte());
			proxy.addCompte(new Compte());
			*/
			System.out.println("Liste initiale :");
			List<Compte> comptes = proxy.listeCompte();
			for (Compte compte : comptes) {
				System.out.println(compte.getCode()+" : "+compte.getSolde());
			}
			
			proxy.verser(1L, 1000);
			proxy.virement(1L, 2L, 100);
			proxy.retirer(1L, 100);

			System.out.println("\n\nListe finale :");
			comptes = proxy.listeCompte();
			for (Compte compte : comptes) {
				System.out.println(compte.getCode()+" : "+compte.getSolde());
			}
			
			
			
			
			
			
			
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
