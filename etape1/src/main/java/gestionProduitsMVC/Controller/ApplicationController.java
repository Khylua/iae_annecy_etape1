package gestionProduitsMVC.Controller;

import gestionProduitsMVC.Controller.Annuaire.MenuClientController;
import gestionProduitsMVC.Controller.Catalogue.MenuProduitController;
import gestionProduitsMVC.Controller.Panier.MenuPanierController;
import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.BddClient;
import gestionProduitsMVC.Model.BddProduit;
import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Menu.MenuClient;
import gestionProduitsMVC.View.Menu.MenuDemarrage;
import gestionProduitsMVC.View.Menu.MenuPanier;
import gestionProduitsMVC.View.Menu.MenuProduit;

public class ApplicationController {

	//attributs
	private Catalogue catalogue;
	private Annuaire annuaire;
	private BddProduit bddP;
	private BddClient bddC;

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
	public BddProduit getBddP() {
		return bddP;
	}
	public void setBddP(BddProduit bddP) {
		this.bddP = bddP;
	}
	public BddClient getBddC() {
		return bddC;
	}
	public void setBddC(BddClient bddC) {
		this.bddC = bddC;
	}
	
	//constructeur
	public ApplicationController(BddProduit bddP, BddClient bddC) {
		super();
		this.bddP = bddP;
		this.bddC = bddC;
		this.catalogue = bddP.getCatalogue();
		this.annuaire = bddC.getAnnuaire();
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
			ElementInteractif error = new ElementInteractif("-- Erreur de saisir --");
			error.initElement();
			this.demarrerAppli();
			break;
		}
	}
	

	
	//produit
	private void afficherMenuProduit(){
		MenuProduit mp = new MenuProduit("----------------------------------\nGestion des produits du catalogue\n----------------------------------");
		mp.initMenu();
		MenuProduitController mpc = new MenuProduitController(mp, catalogue);
		mpc.traitement();
	}
	
	// client
	private void afficherMenuClient(){
		MenuClient mc = new MenuClient("---------------------------------\nGestion des clients de l'annuaire\n---------------------------------");
		mc.initMenu();
		MenuClientController mcc = new MenuClientController(mc, annuaire);
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
