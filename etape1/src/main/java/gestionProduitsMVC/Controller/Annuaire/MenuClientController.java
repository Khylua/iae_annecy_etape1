package gestionProduitsMVC.Controller.Annuaire;

import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.Model.Client;
import gestionProduitsMVC.View.Element;
import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Question;
import gestionProduitsMVC.View.Menu.MenuClient;

/**
 * @author karinerevet
 * La classe MenuClientController permet la gestion du menu dédié aux fonctionnalités en lien avec les clients
 */
public class MenuClientController {
	//attribut
	private MenuClient menuClient;
	private Annuaire annuaire;
	private Catalogue catalogue;
	private Client client;
	
	//getters et setters
	public MenuClient getMenuClient() {
		return menuClient;
	}
	public Client getClient(){
		return client;
	}
	public void setClient(Client client){
		this.client = client;
	}
	public Annuaire getAnnuaire() {
		return annuaire;
	}
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setAnnuaire(Annuaire annuaire) {
		this.annuaire = annuaire;
	}
	public void setMenuClient(MenuClient menuClient) {
		this.menuClient = menuClient;
	}
	
	//constructeur
	public MenuClientController(MenuClient menuClient, Annuaire annuaire, Catalogue catalogue) {
		super();
		this.menuClient = menuClient;
		this.annuaire = annuaire;
		this.catalogue = catalogue;
	}
	
	public void traitement(){
		String choix = this.getMenuClient().getReponse();
		if(Integer.parseInt(choix) == 1){
			// ajout
			this.setClient(new Client(this.getAnnuaire()));
		}else if(Integer.parseInt(choix) == 2 || Integer.parseInt(choix) == 3 ){
			// modification, suppression
			// choix du produit
			this.choisirClient();
		}else if(Integer.parseInt(choix) == 4){	
			// annuaire
			this.setClient(null);
		}else{
			ElementInteractif error = new ElementInteractif("-- Erreur de saisir --", 1);
			error.initElement();
			this.getMenuClient().initMenu();
		}
		
		// traitement de la réponse précédente
		ClientController cc = new ClientController(this.getClient(), this.getAnnuaire(), this.getCatalogue());
		switch(Integer.parseInt(choix)){
			case 0 :
				this.getMenuClient().sortieApplication();
				break;
			case 1 : // ajouter
				cc.ajouterClient();
				break;
			case 2 : // modifier
				cc.modifierClient();
				break;
			case 3 : // supprimer
				cc.supprimerClient();
				break;
			case 4 : // annuaire
				cc.afficherAnnuaire();
				break;
			default :
				ElementInteractif error = new ElementInteractif("-- Erreur de saisir --", 1);
				error.initElement();
				this.getMenuClient().initMenu();
				break;
		}
	}
	
	// choix client à gérer
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
