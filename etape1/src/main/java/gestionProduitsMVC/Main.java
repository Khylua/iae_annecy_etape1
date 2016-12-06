
package gestionProduitsMVC;

import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.BddClient;
import gestionProduitsMVC.Model.BddProduit;
//import gestionProduitsMVC.Model.BddProduit;
import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.Controller.ApplicationController;

public class Main {
	public static void main(String[] args) {
		// catalogue
		Catalogue c = new Catalogue();
		// produits
		//new Produit("AA123", "p1", 10.50, c, "Produit 1", "Description produit 1");
		//new Produit("AB456", "p2", 1.99, c, "Produit 2", "Description produit 2");
		
		// annuaire
		Annuaire a = new Annuaire();
		// clients
		//new Client(a, "DUPONT", "Jean", "A111");
		//new Client (a, "DURAND", "Paul", "B222", "PROMO1");
		
		// appli
		//ApplicationController ac = new ApplicationController(c, a);
		//ac.demarrerAppli();
		
		// on démarre les bdd
		BddProduit bddP = new BddProduit("bdd_catalogue.txt", c); 
		bddP.clearProduitBDD();
		bddP.miseAJourProduitBDD();
		
		BddClient bddC = new BddClient("bdd_client.txt", a);
		bddC.clearClientBDD();
		bddC.miseAJourClientBDD();
		
		
		// on lance l'application sur les données de bdd crées
		new ApplicationController(bddP, bddC);

	}

}
