package gestionProduitsMVC.View.Catalogue;

import java.util.Iterator;

import gestionProduitsMVC.Model.Catalogue;
import gestionProduitsMVC.Model.Produit;
import gestionProduitsMVC.View.Element;

public class CatalogueVue {
	//attribut
	private Catalogue catalogue;
	
	//getters et setters
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
	
	//constructeur
	public CatalogueVue(Catalogue catalogue) {
		super();
		this.catalogue = catalogue;
	}
	
	// données catalogue
	@Override
	public String toString(){
		return "Catalogue ("+ catalogue.getListeDeProduits().size() +" produits)";
	}
	
	// afficher catalogue
	public void afficherCatalogue(){
		Element cat = new Element(this.toString());
		cat.initElement();
		Iterator<Produit> it = this.getCatalogue().getListeDeProduits().iterator();
		while(it.hasNext()){
			Produit current = it.next();
			ProduitVue pv = new ProduitVue(current);
			pv.afficherProduitSimple();
		}
	}
	
}
