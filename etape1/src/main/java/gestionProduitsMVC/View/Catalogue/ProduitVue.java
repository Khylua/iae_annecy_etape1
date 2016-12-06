package gestionProduitsMVC.View.Catalogue;


import gestionProduitsMVC.Model.Produit;
import gestionProduitsMVC.View.Element;

public class ProduitVue {
	// attribut
	private Produit produit;
	
	// getters et setters 
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	// constructeur
	public ProduitVue(Produit produit) {
		super();
		this.produit = produit;
	}
	
	// données produit simple
	@Override
	public String toString() {
		return "\t Produit --> reference = " + produit.getReference() + 
				", nom = " + produit.getNom() + 
				", description = " + produit.getDescription() + 
				", prix = " + produit.getPrix() + "";
	}
	
	// affichage produit simple
	public void afficherProduitSimple(){
		Element cat = new Element(this.toString());
		cat.initElement();
	}
	public String produitCommande() {
		return "\tProduit :" + produit.getReference() + 
				" - " + produit.getNom() + 
				"\n\tprix unitaire = " + produit.getPrix() + "";
	}
	
	public void afficherProduitCommande(){
		Element cat = new Element(this.produitCommande());
		cat.initElement();
	}
	
	// données produit détail
	public String détailProduit() {
		return "Produit N° = " + produit.getReference() + "\n" 
				+ "\t Nom : " + produit.getNom() + "\n"
				+ "\t Prix : " + produit.getPrix() + "\n"
				+ "\t Description courte : " + produit.getDescription() + "\n"
				+ "\t Description longue : \n " + produit.getDescriptionLongue() + "";
	}
	
	// affichage produit détail
	public void afficherProduitDetail(){
		Element cat = new Element(this.détailProduit());
		cat.initElement();
	}
	
	
	
}
