package gestionProduitsMVC.Controller.Panier;

import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.Model.Client;
import gestionProduitsMVC.View.Element;
import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Question;
import gestionProduitsMVC.View.Menu.MenuPanier;

/**
 * @author karinerevet
 * Controller pour la gestion du panier
 * choix du client sur lequel la gestion porte
 * appel aux controller selon l'action à mener sur le panier
 */
public class MenuPanierController {
	//attribut
	private MenuPanier menuPanier;
	private Catalogue catalogue;
	private Annuaire annuaire;
	private Client client;
	
	//getters et setters
	public MenuPanier getMenuPanier() {
		return menuPanier;
	}
	public void setMenuPanier(MenuPanier menuPanier) {
		this.menuPanier = menuPanier;
	}
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	//constructeur
	public MenuPanierController(MenuPanier mp, Annuaire a, Catalogue c) {
		super();
		this.menuPanier = mp;
		this.catalogue = c;
		this.annuaire = a;
	}
	
	public void traitement(){
		String choix = this.getMenuPanier().getReponse();
		// traitement de la réponse précédente
		PanierController pc = new PanierController(this.getClient(), this.getCatalogue(), this.getAnnuaire());
		
		switch(Integer.parseInt(choix)){
			case 0 :
				this.getMenuPanier().sortieApplication();
				break;
			case 1 : // ajouter
				pc.ajouterProduit();
				break;
			case 2 : // modifier
				pc.modifierProduit();
				break;
			case 3 : // supprimer
				pc.supprimerProduit();
				break;
			case 4 : // detail
				pc.detailsProduit();
				break;
			case 5 : // valider pour commande
				pc.validerPanier();
				break;
			case 6 : // historique des commandes
				pc.historiqueCommandes();
				break;
			default :
				ElementInteractif error = new ElementInteractif("-- Erreur de saisir --", 1);
				error.initElement();
				this.getMenuPanier().initMenu();
				break;
		}
	}
	
	public void choisirClient(){
		Question choix = new Question("Choisir un client", "Saississez le numéro du client :");
		choix.initQuestion();
		String num = choix.getReponse();
		Client c = this.getAnnuaire().chercherClientParNum(num);
		if(c == null){
			Element error = new Element("-- Client non trouvé --", 1);
			error.initElement();
			this.choisirClient();
		}else{
			this.setClient(c);
		}
	}
}