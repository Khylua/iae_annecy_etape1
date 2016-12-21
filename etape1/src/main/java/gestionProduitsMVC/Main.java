
package gestionProduitsMVC;

// imports
import gestionProduitsMVC.Controller.ApplicationController;
import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.BddAnnuaire;
import gestionProduitsMVC.Model.BddCatalogue;
import gestionProduitsMVC.Model.Catalogue;
//import gestionProduitsMVC.Model.Client;
//import gestionProduitsMVC.Model.Produit;

/**
 * @author karinerevet
 * La classe Main sert uniquement à instancier les éléments du modèle et lancer le fonctionnement de l'application
 */

public class Main {
	public static void main(String[] args) {
		// -- création des éléments du modèle --
			// catalogue
			Catalogue c = new Catalogue();
			// annuaire
			Annuaire a = new Annuaire();
			
			// création des données pour remplir les BDD à la première utilisation 
			
			// ---------------------------------------------------------------------------------------------------------
			// TODO : à commenter après la première utilisation 
			/*
				// Clients
				new Client(a, "CLIENT1", "Client1", "1");
				new Client(a, "CLIENT2", "Client2", "2", "PROMO1");
				new Client(a, "CLIENT3", "Client3", "3");
				new Client(a, "CLIENT4", "Client4", "4", "PROMO1");
				// Produits
				new Produit("A", "Produit A", 10.5, c, "Description produit A", "Description longue du produit A");
				new Produit("B", "Produit B", 3.9, c, "Description produit B", "Description longue du produit B");
				new Produit("C", "Produit C", 0.1, c, "Description produit C", "Description longue du produit C");
				new Produit("D", "Produit D", 12.0 , c, "Description produit D", "Description longue du produit D");
				new Produit("E", "Produit E", 234.45 , c, "Description produit E", "Description longue du produit E");
				new Produit("F", "Produit F", 3.89 , c, "Description produit F", "Description longue du produit F");				
				// Paniers
				((a.chercherClientParNum("1")).getPanierEnCours()).ajouterProduit(c.chercherProduitParRef("A"), 3);
				((a.chercherClientParNum("1")).getPanierEnCours()).ajouterProduit(c.chercherProduitParRef("B"), 1);
				((a.chercherClientParNum("1")).getPanierEnCours()).ajouterProduit(c.chercherProduitParRef("D"), 4);
				((a.chercherClientParNum("2")).getPanierEnCours()).ajouterProduit(c.chercherProduitParRef("D"), 5);
				((a.chercherClientParNum("3")).getPanierEnCours()).ajouterProduit(c.chercherProduitParRef("E"), 7);
	
				// -- création des éléments de base de données / stockage --
					new BddCatalogue("bdd_catalogue.txt", c).miseAJourCatalogueBDD(c); 
					new BddAnnuaire("bdd_client.txt", a).miseAJourAnnuaireBDD(a);
			*/
			// ---------------------------------------------------------------------------------------------------------		
			// TODO : a utiliser si ce n'est pas la première utilsiation
					new BddCatalogue("bdd_catalogue.txt", c); 
					new BddAnnuaire("bdd_client.txt", a);	

		// -- démarrage de l'application --
			new ApplicationController(c, a);

	}

}
