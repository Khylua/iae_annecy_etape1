package gestionProduitsMVC.Controller.Catalogue;

import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.Model.Produit;
import gestionProduitsMVC.View.Element;
import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Question;
import gestionProduitsMVC.View.Menu.MenuProduit;

/**
 * @author karinerevet
 * Controller pour toute la gestion des produits et du catalogue :
 * choix du produit dans le catalogue
 * appel aux controller selon l'action à mener sur le produit
 */
public class MenuProduitController {
	//attribut
	private MenuProduit menuProduit;
	private Catalogue catalogue;
	private Produit produit;
	private Annuaire annuaire;
	
	//getters et setters
	public MenuProduit getMenuProduit() {
		return menuProduit;
	}
	public Produit getProduit(){
		return produit;
	}
	public void setProduit(Produit produit){
		this.produit = produit;
	}
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public Annuaire getAnnuaire() {
		return annuaire;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
	public void setMenuProduit(MenuProduit menuProduit) {
		this.menuProduit = menuProduit;
	}
	
	//constructeur
	public MenuProduitController(MenuProduit menuProduit, Catalogue catalogue, Annuaire annuaire) {
		super();
		this.menuProduit = menuProduit;
		this.catalogue = catalogue;
		this.annuaire = annuaire;
	}
	
	public void traitement(){
		String choix = this.getMenuProduit().getReponse();
		if(Integer.parseInt(choix) == 1){ 
			// ajout produit
			this.setProduit(new Produit(this.getCatalogue()));
		}else if(Integer.parseInt(choix) == 2 || Integer.parseInt(choix) == 3 || Integer.parseInt(choix) == 4){
			// modification, suppression, détails
			// choix du produit
			this.choisirProduit();
		}else if(Integer.parseInt(choix) == 5){
			// affichage catalogue
			this.setProduit(null);
		}else{
			ElementInteractif error = new ElementInteractif("-- Erreur de saisir --", 1);
			error.initElement();
			this.getMenuProduit().initMenu();
		}
		// traitement de la réponse précédente
		ProduitController pc = new ProduitController(this.getProduit(), this.getCatalogue(), this.getAnnuaire());
		
		switch(Integer.parseInt(choix)){
			case 0 :
				this.getMenuProduit().sortieApplication();
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
				pc.détailsProduit();
				break;
			case 5 : // catalogue
				pc.afficherCatalogue();
				break;
			default :
				ElementInteractif error = new ElementInteractif("-- Erreur de saisir --", 1);
				error.initElement();
				this.getMenuProduit().initMenu();
				break;
		}
	}
	
	// choix produit à gérer
	public void choisirProduit(){
		Question choixProduit = new Question("Choisir un produit", "Saississez la référence du produit :");
		choixProduit.initQuestion();
		String refP = choixProduit.getReponse();
		Produit p = this.getCatalogue().chercherProduitParRef(refP);
		if(p == null){
			Element error = new Element("-- Produit non trouvé --", 1);
			error.initElement();
			this.choisirProduit();
		}else{
			this.setProduit(p);
		}
	}
	
	
}
