package gestionProduitsMVC.Controller;

// imports
import gestionProduitsMVC.Controller.Annuaire.MenuClientController;
import gestionProduitsMVC.Controller.Catalogue.MenuProduitController;
import gestionProduitsMVC.Controller.Panier.MenuPanierController;
import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Menu.MenuClient;
import gestionProduitsMVC.View.Menu.MenuDemarrage;
import gestionProduitsMVC.View.Menu.MenuPanier;
import gestionProduitsMVC.View.Menu.MenuProduit;

/**
 * @author karinerevet
 * La classe ApplicationController permet de gérer globalement l'application, faire l'appel au premier menu, 
 * puis en fonction du résultat, appeler les controller compétents (responsabilité)
 */

public class ApplicationController {

	//attributs
	private Catalogue catalogue;
	private Annuaire annuaire;

	//getters et setters
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
	public Annuaire getAnnuaire() {
		return annuaire;
	}
	public void setAnnuaire(Annuaire annuaire) {
		this.annuaire = annuaire;
	}
	
	//constructeur
	public ApplicationController(Catalogue catalogue, Annuaire annuaire) {
		super();
		this.catalogue = catalogue;
		this.annuaire = annuaire;
		this.demarrerAppli();
	}
	
	//demmarage
	private void demarrerAppli(){
		MenuDemarrage menuDem = new MenuDemarrage("----\nMENU\n----");
		menuDem.initMenu();
		MenuDemarrageController mdc = new MenuDemarrageController(menuDem);
		Integer rep = mdc.traitementDemarrage();
		this.traitementMenuDemarrage(rep);
	}
	
	// traitement du résulat du menu de démarrage
	/**
	 * @param reponse
	 * La réponse doit être un entier correspondant à la saisie utilisateur en réponse du menu
	 */
	private void traitementMenuDemarrage(Integer reponse){
		switch(reponse){
		case 1 : // produit
			this.afficherMenuProduit();
			break;
		case 2 : // client
			this.afficherMenuClient();
			break;
		case 3 : // panier
			this.afficherMenuPanier();
			break;
		default :
			ElementInteractif error = new ElementInteractif("-- Erreur de saisir --", 1);
			error.initElement();
			this.demarrerAppli();
			break;
		}
	}
	
	// produit
	private void afficherMenuProduit(){
		MenuProduit mp = new MenuProduit("----------------------------------\nGestion des produits du catalogue\n----------------------------------");
		mp.initMenu();
		MenuProduitController mpc = new MenuProduitController(mp, catalogue, annuaire);
		mpc.traitement();
	}
	
	// client
	private void afficherMenuClient(){
		MenuClient mc = new MenuClient("---------------------------------\nGestion des clients de l'annuaire\n---------------------------------");
		mc.initMenu();
		MenuClientController mcc = new MenuClientController(mc, annuaire, catalogue);
		mcc.traitement();
	}

	// panier
	private void afficherMenuPanier(){
		MenuPanier mp = new MenuPanier("-----------------\nGestion du panier\n-----------------");
		MenuPanierController mpc = new MenuPanierController(mp, annuaire, catalogue);
		// choix du client
		mpc.choisirClient();
		//menu
		mp.initMenu();
		mpc.traitement();
	}
	
}
