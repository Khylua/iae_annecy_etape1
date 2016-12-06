package gestionProduitsMVC.Controller.Panier;

import gestionProduitsMVC.Controller.ApplicationController;
import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.Model.Client;
import gestionProduitsMVC.Model.Panier;
import gestionProduitsMVC.Model.Produit;
import gestionProduitsMVC.View.Element;
import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Question;
import gestionProduitsMVC.View.Panier.CommandesVue;
import gestionProduitsMVC.View.Panier.PanierVue;

public class PanierController {

	//attributs
	private Catalogue catalogue;
	private Annuaire annuaire;
	private Client client;
	
	
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setAnnuaire(Annuaire annuaire) {
		this.annuaire = annuaire;
	}
	
	//constructeur
	public PanierController(Client cl, Catalogue ca, Annuaire a) {
		super();
		this.client = cl;
		this.catalogue = ca;
		this.annuaire = a;
		if(this.getClient().getPanierEnCours()== null){
			this.getClient().setPanierEnCours(new Panier());
		}
	}
	
	// -------------------------------------------------------------------------------
	//ajouter
	public void ajouterProduit(){
		ElementInteractif ad = new ElementInteractif("Ajouter un nouveau produit");
		ad.initElement();
		//demande de la référence à l'utilisateur
		Boolean refOk = false;
		String refP = "";
		// si la référence est trouvée dans le catalogue
		while(!refOk){
			refP = this.questionAjoutProduit("Référence", "la référence");
			refOk = this.ckeckReference(refP);
		}
		//on dit que le produit est celui saisi
		Produit p = this.getCatalogue().chercherProduitParRef(refP);
		//demande de la quantité de produit
		Boolean qOk = false;
		String qP = "";
		// si la quantité est valide
		while(!qOk){
			qP = this.questionAjoutProduit("Quantité", "la quantité");
			qOk = this.ckeckQuantite(qP);
		}
		// ajout du produit dans sa bonne quantité au panier
		Integer q = Integer.parseInt(qP);
		if(q != 0){
			// si la quantité saisie n'est pas nulle (annulation de l'ajout du produit)
			if(this.getClient().getPanierEnCours().getProduits().get(p) == null){
				// si le produit n'existe pas encore dans le panier
				// ajout du produit simple
				this.getClient().getPanierEnCours().ajouterProduit(p, q);
			}else{
				// sinon ajout en additionnant les quantités
				Integer newQ = q + this.getClient().getPanierEnCours().getProduits().get(p);
				this.getClient().getPanierEnCours().ajouterProduit(p, newQ);
			}
		}
		//confirmation
		ElementInteractif ok = new ElementInteractif("Produit de référence "+p.getReference()+" ajouté au panier en "+qP+" exemplaire(s).");
		ok.initElement();
		//retour menu
		this.relancerAppli();
	}
	
	
	//question ajout
	public String questionAjoutProduit(String att1, String att2){
		Question qu = new Question(att1+" du produit", "Saississez "+ att2 + " du produit :");
		qu.initQuestion();
		String rep = qu.getReponse();
		return rep;
	}
	
	// vérifications
	public Boolean ckeckQuantite(String q){
		if(Integer.parseInt(q) >= 0){
			return true;
		}
		ElementInteractif ok = new ElementInteractif("Attention : la quantité ne doit pas être négative. (0 pour ne pas ajouter le produit)");
		ok.initElement();
		return false;
	}
	public Boolean ckeckReference(String reference){
		Produit p = this.getCatalogue().chercherProduitParRef(reference);
		if( p != null){
			return true;
		}
		ElementInteractif ok = new ElementInteractif("Attention : la référence doit exister dans le catalogue.");
		ok.initElement();
		return false;
	}
	
	// -------------------------------------------------------------------------------
	//modifier
	public void modifierProduit(){
		// choix du produit à modifier
		Produit p = this.choisirProduit();
		// rappel ancienne quantité
		ElementInteractif qA = new ElementInteractif("La quantité actuelle de ce produit est actuellement de "+this.getClient().getPanierEnCours().chercherQuantiteProduit(p)+ " dans votre panier.");
		qA.initElement();
		// demande nouvelle quantité 
		String q="";
		Boolean qOk = false;
		// si la quantité est valide
		while(!qOk){
			Question choixQ = new Question("Choisir la quantité", "Saississez la nouvelle quantité du produit :");
			choixQ.initQuestion();
			q = choixQ.getReponse();
			qOk = this.ckeckQuantite(q);
		}
		// modification et confirmation modification
		this.getClient().getPanierEnCours().ajouterProduit(p, Integer.parseInt(q));
		ElementInteractif ok = new ElementInteractif("Quantité du produit de référence "+p.getReference()+" modifiée pour "+q+" exemplaire(s).");
		ok.initElement();
		//retour menu
		this.relancerAppli();
	}
	
	// choix produit dans le panier
	public Produit choisirProduit(){
		Produit p = null;
		Question choixProduit = new Question("Choisir un produit", "Saississez la référence du produit :");
		choixProduit.initQuestion();
		String refP = choixProduit.getReponse();
		p = this.getCatalogue().chercherProduitParRef(refP);
		if(p == null){
			// si le produit n'existe pas
			Element error = new Element("-- Produit non trouvé dans le catalogue --");
			error.initElement();
			this.choisirProduit();
		}else if(!this.getClient().getPanierEnCours().getProduits().containsKey(p)){
			// si le produit n'est pas dans le panier
			Element error = new Element("-- Produit non présent dans le panier --");
			error.initElement();
			this.choisirProduit();
		}
		return p;
	}
	
	
	// -------------------------------------------------------------------------------
	//supprimer
	public void supprimerProduit(){
		// choix du produit à modifier
		Produit p = this.choisirProduit();
		// suppression
		Question modifAttribut = new Question("Suppression du produit " + p.getReference(), "Etes-vous sur de vouloir supprimer le produit "+p.getReference()+ " ? (O/N)");
		modifAttribut.initQuestion();
		String mess;
		Boolean ok = false;
		String nouvelleValeur = modifAttribut.getReponse();
		if(nouvelleValeur.equals("O")){
			mess = "Produit de référence "+p.getReference()+" supprimé du panier avec succès.";
			ok = true;
			this.getClient().getPanierEnCours().getProduits().remove(p);
		}else if(nouvelleValeur.equals("N")){
			ok = true;
			mess = "Produit de référence "+p.getReference()+" non supprimé du panier .";
		}else{
			mess = "-- Erreur --";
		}
		Element e = new Element(mess);
		e.initElement();
		if(!ok){
			this.supprimerProduit();
		}else{
			this.relancerAppli();
		}
	}
	
	
	// -------------------------------------------------------------------------------
	//détails
	public void détailsProduit(){
		PanierVue pv = new PanierVue(this.getClient().getPanierEnCours());
		pv.afficherPanier(this.promo());
		this.relancerAppli();
	}
	
	// promo
	public Double promo(){
		Double reduction = 0.00;
		if(this.getClient().getCodePromo() == "PROMO1"){
			reduction = 5.00;
		}
		return reduction;
	}
	
	// -------------------------------------------------------------------------------
	// valider panier pour commande
	public void validerPanier(){
		Question val = new Question("Validation du panier ", "Etes-vous sur de vouloir valider votre panier pour le transformer en commande ? (O/N)");
		val.initQuestion();
		String mess;
		Boolean ok = false;
		if(val.getReponse().equals("O")){
			mess = "Panier validé avec succès";
			ok = true;
			this.getClient().getPanierEnCours().setCommande(true);
			this.getClient().getPaniersHistorique().add(this.getClient().getPanierEnCours());
			this.getClient().setPanierEnCours(new Panier());
		}else if(val.getReponse().equals("N")){
			mess = "Panier non validé";
			ok = true;
		}else{
			mess = "-- Erreur --";
		}
		Element e = new Element(mess);
		e.initElement();
		if(!ok){
			this.validerPanier();
		}else{
			this.relancerAppli();
		}
	}
	
	// -------------------------------------------------------------------------------
	public void historiqueCommandes(){
		CommandesVue cv = new CommandesVue(this.getClient().getPaniersHistorique());
		cv.afficher(this.promo());
		this.relancerAppli();
	}
	
	// -------------------------------------------------------------------------------
	// relancer appli
	public void relancerAppli(){
		new ApplicationController(this.getCatalogue(), this.getAnnuaire());
	}
	
	
	
	
	
}
