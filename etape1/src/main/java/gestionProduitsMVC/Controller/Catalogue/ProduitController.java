package gestionProduitsMVC.Controller.Catalogue;

import gestionProduitsMVC.Controller.ApplicationController;
import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.Model.Produit;
import gestionProduitsMVC.View.Element;
import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Question;
import gestionProduitsMVC.View.Catalogue.CatalogueVue;
import gestionProduitsMVC.View.Catalogue.ProduitVue;
import gestionProduitsMVC.View.Menu.MenuModificationProduit;

public class ProduitController {
	
	//attributs
	private Produit produit;
	private Catalogue catalogue;
	private Annuaire annuaire;
	
	//getters et setters
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
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
	
	//constructeur
	public ProduitController(Produit produit, Catalogue catalogue) {
		super();
		this.produit = produit;
		this.catalogue = catalogue;
	}
	
	// -------------------------------------------------------------------------------
	//ajouter
	public void ajouterProduit(){
		ElementInteractif ad = new ElementInteractif("Ajouter un nouveau produit");
		ad.initElement();
		//reference
		Boolean refOk = false;
		String refP = "";
		while(!refOk){
			refP = this.questionAjoutProduit("Référence", "la référence");
			refOk = this.ckeckReference(refP);
		}
		this.getProduit().setReference(refP);
		//nom
		String nomP = this.questionAjoutProduit("Nom", "le nom");
		this.getProduit().setNom(nomP);
		//prix
		Boolean prixOk = false;
		String priP = "";
		while(!prixOk){
			priP = this.questionAjoutProduit("Prix", "le prix");
			prixOk = this.ckeckPrix(priP);
		}
		this.getProduit().setPrix(Double.valueOf(priP));
		//description courte
		String desP = this.questionAjoutProduit("Description", "la description");
		this.getProduit().setDescription(desP);
		//description longue
		String delP = this.questionAjoutProduit("Description longue", "la description longue");
		this.getProduit().setDescriptionLongue(delP);
		//confirmation
		ElementInteractif ok = new ElementInteractif("Produit de référence "+this.getProduit().getReference()+" ajouté au catalogue avec succès.");
		ok.initElement();
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
	public Boolean ckeckPrix(String prix){
		if(Double.valueOf(prix) < 0){
			return true;
		}
		ElementInteractif ok = new ElementInteractif("Attention : le prix ne doit pas être négatif.");
		ok.initElement();
		return false;
	}
	public Boolean ckeckReference(String reference){
		Produit p = this.getCatalogue().chercherProduitParRef(reference);
		if( p == null){
			return true;
		}
		ElementInteractif ok = new ElementInteractif("Attention : la référence ne doit pas être déjà attribuée à un autre produit.");
		ok.initElement();
		return false;
	}
	
	// -------------------------------------------------------------------------------
	//modifier
	public void modifierProduit(){
		MenuModificationProduit mmp = new MenuModificationProduit("Modifier le produit "+ this.getProduit().getReference());
		mmp.initMenu();
		MenuModificationProduitController mmpc = new MenuModificationProduitController(mmp, this.getProduit());
		mmpc.traitementModificationProduit();
		this.relancerAppli();
	}
	
	
	// -------------------------------------------------------------------------------
	//supprimer
	public void supprimerProduit(){
		Question modifAttribut = new Question("Suppression du produit " + this.getProduit().getReference(), "Etes-vous sur de vouloir supprimer le produit "+this.getProduit().getReference()+ " ? (O/N)");
		modifAttribut.initQuestion();
		String mess;
		Boolean ok = false;
		String nouvelleValeur = modifAttribut.getReponse();
		if(nouvelleValeur.equals("O")){
			mess = "Produit de référence "+this.getProduit().getReference()+" supprimé du catalogue avec succès.";
			ok = true;
			this.getCatalogue().getListeDeProduits().remove(this.getProduit());
		}else if(nouvelleValeur.equals("N")){
			ok = true;
			mess = "Produit de référence "+this.getProduit().getReference()+" non supprimé du catalogue .";
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
		ProduitVue pv = new ProduitVue(this.getProduit());
		pv.afficherProduitDetail();
		this.relancerAppli();
	}
	
	// -------------------------------------------------------------------------------
	//catalogue
	public void afficherCatalogue(){
		CatalogueVue cv = new CatalogueVue(this.getCatalogue());
		cv.afficherCatalogue();
		this.relancerAppli();
	}
	
	
	// -------------------------------------------------------------------------------
	// relancer appli
	public void relancerAppli(){
		new ApplicationController(this.getCatalogue(), this.getAnnuaire());
	}
	
	
	
	
	
	
}
