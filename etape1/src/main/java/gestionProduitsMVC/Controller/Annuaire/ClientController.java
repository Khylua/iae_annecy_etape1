package gestionProduitsMVC.Controller.Annuaire;

import gestionProduitsMVC.Controller.ApplicationController;
import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.Model.Client;
import gestionProduitsMVC.View.Element;
import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Question;
import gestionProduitsMVC.View.Annuaire.AnnuaireVue;
import gestionProduitsMVC.View.Menu.MenuModificationClient;

public class ClientController {
	//attributs
	private Client client;
	private Annuaire annuaire;
	private Catalogue catalogue;
	
	//getters et setters
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Annuaire getAnnuaire() {
		return annuaire;
	}
	public void setAnnuaire(Annuaire annuaire) {
		this.annuaire = annuaire;
	}
	public Catalogue getCatalogue() {
		return catalogue;
	}

	
	//constructeur
	public ClientController(Client client, Annuaire annuaire) {
		super();
		this.client = client;
		this.annuaire = annuaire;
	}
	
	// -------------------------------------------------------------------------------
	//ajouter
	public void ajouterClient(){
		ElementInteractif ad = new ElementInteractif("Ajouter un nouveau client");
		ad.initElement();
		//reference
		Boolean refOk = false;
		String numC = "";
		while(!refOk){
			numC = this.questionAjoutClient("Numéro", "le numéro");
			refOk = this.ckeckNumero(numC);
		}
		this.getClient().setNumero(numC);
		//nom
		String nomC = this.questionAjoutClient("Nom", "le nom");
		this.getClient().setNom(nomC);
		//prénom
		String preC = this.questionAjoutClient("Prénom", "le prénom");
		this.getClient().setPrenom(preC);
		//promo
		String proC = this.questionAjoutClient("Code promo", "le code promo");
		this.getClient().setCodePromo(proC);
		//confirmation
		ElementInteractif ok = new ElementInteractif("Client de numéro "+this.getClient().getNumero()+" ajouté au catalogue avec succès.");
		ok.initElement();
		this.relancerAppli();
	}
	
	//question ajout
	public String questionAjoutClient(String att1, String att2){
		Question qu = new Question(att1+" du client", "Saississez "+ att2 + " du client :");
		qu.initQuestion();
		String rep = qu.getReponse();
		return rep;
	}
	
	// vérifications
	public Boolean ckeckNumero(String num){
		Client c = this.getAnnuaire().chercherClientParNum(num);
		if( c == null){
			return true;
		}
		ElementInteractif ok = new ElementInteractif("Attention : le numéro ne doit pas être déjà attribuée à un autre client.");
		ok.initElement();
		return false;
	}
	
	// -------------------------------------------------------------------------------
	//modifier
	public void modifierClient(){
		MenuModificationClient mmc = new MenuModificationClient("Modifier le client "+ this.getClient().getNumero());
		mmc.initMenu();
		MenuModificationClientController mmcc = new MenuModificationClientController(mmc, this.getClient());
		mmcc.traitementModificationClient();
		this.relancerAppli();
	}
	
	
	// -------------------------------------------------------------------------------
	//supprimer
	public void supprimerClient(){
		Question modifAttribut = new Question("Suppression du client " + this.getClient().getNumero(), "Etes-vous sur de vouloir supprimer le client "+this.getClient().getNumero()+ " ? (O/N)");
		modifAttribut.initQuestion();
		String mess;
		Boolean ok = false;
		String nouvelleValeur = modifAttribut.getReponse();
		if(nouvelleValeur.equals("O")){
			mess = "Client de numéro "+this.getClient().getNumero()+" supprimé de l'annuaire avec succès.";
			ok = true;
			this.getAnnuaire().getListeDesClients().remove(this.getClient());
		}else if(nouvelleValeur.equals("N")){
			ok = true;
			mess = "Client de référence "+this.getClient().getNumero()+" non supprimé de l'annuaire .";
		}else{
			mess = "-- Erreur --";
		}
		Element e = new Element(mess);
		e.initElement();
		if(!ok){
			this.supprimerClient();
		}else{
			this.relancerAppli();
		}
	}
	
	// -------------------------------------------------------------------------------
	//annuaire
	public void afficherAnnuaire(){
		AnnuaireVue av = new AnnuaireVue(this.getAnnuaire());
		av.afficherAnnuaire();
		this.relancerAppli();
	}
	
	
	// -------------------------------------------------------------------------------
	// relancer appli
	public void relancerAppli(){
		new ApplicationController(bddP, bddC);
	}
	
	
	
}
