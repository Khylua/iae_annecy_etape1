package gestionProduitsMVC.Controller.Catalogue;

import gestionProduitsMVC.Model.Catalogue;

/**
 * @author karinerevet
 * Classe exemple commencée en cours... non utilisée
 */
public class CatalogueController {
	
	//attribut
	private Catalogue catalogue;
	
	//getters et setters
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
	
	// get
	public String get(){
		return this.getCatalogue().toString();
	}
	
}
