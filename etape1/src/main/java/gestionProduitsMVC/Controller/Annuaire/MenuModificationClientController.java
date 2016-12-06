package gestionProduitsMVC.Controller.Annuaire;

import gestionProduitsMVC.Model.Client;
import gestionProduitsMVC.View.Element;
import gestionProduitsMVC.View.Question;
import gestionProduitsMVC.View.Menu.MenuModificationClient;

public class MenuModificationClientController {
	// attributs
	private MenuModificationClient mmc;
	private Client client;
	
	// getters et setters
	public MenuModificationClient getMmc() {
		return mmc;
	}
	public void setMmp(MenuModificationClient mmc) {
		this.mmc = mmc;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	// constructeur
	public MenuModificationClientController(MenuModificationClient mmc, Client client) {
		super();
		this.mmc = mmc;
		this.client = client;
	}
	
	// modification attribut 
	public void traitementModificationClient(){
		// valeur attribut
		String attribut = "";
		switch(Integer.parseInt(this.getMmc().getReponse())){
			case 0 :
				Element out = new Element("-- Sortie de l'application ! --");
				out.initElement();
				System.exit(0);
				break;
			case 1 : // nom
				attribut = "le nom";
				break;
			case 2 : // prénom
				attribut = "le prénom";
				break;
			case 3 : // numero
				attribut = "lae numéro";
				break;
			case 4 : // promo
				attribut = "le code rpomo";
				break;
			default :
				Element error = new Element("-- Erreur de saisir --");
				error.initElement();
				this.getMmc().initMenu();
				break;
		}
		// question de modification
		Question modifAttribut = new Question("Modification du client " + this.getClient().getNumero(), "Saississez la nouvelle valeur pour "+attribut);
		modifAttribut.initQuestion();
		String nouvelleValeur = modifAttribut.getReponse();
		// traitement question
		switch(Integer.parseInt(this.getMmc().getReponse())){
			case 1 : // nom
				this.getClient().setNom(nouvelleValeur);
				break;
			case 2 : // prénom
				this.getClient().setPrenom(nouvelleValeur);
				break;
			case 3 : // numero
				this.getClient().setNumero(nouvelleValeur);
				break;
			case 4 : // promo
				this.getClient().setCodePromo(nouvelleValeur);
				break;
			default :
				Element error = new Element("-- Erreur --");
				error.initElement();
				this.getMmc().initMenu();
				break;
		}
		// message réussite
		Element messReussite = new Element("Modification effectuée avec succès sur "+attribut+" du client "+this.getClient().getNumero());
		messReussite.initElement();
	}
}
