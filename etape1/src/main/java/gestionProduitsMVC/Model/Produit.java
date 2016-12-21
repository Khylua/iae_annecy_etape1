package gestionProduitsMVC.Model;

import java.io.Serializable;

/**
 * @author karinerevet
 * modèle représentant les produits
 */
public class Produit implements Serializable{

	private static final long serialVersionUID = 1L;
	//attributs
	private String reference;
	private String description;
	private Double prix;
	private Catalogue catalogue;
	private String nom;
	private String descriptionLongue;
	
	//getters et setters
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescriptionLongue() {
		return descriptionLongue;
	}
	public void setDescriptionLongue(String descriptionLongue) {
		this.descriptionLongue = descriptionLongue;
	}
	
	// constructeurs
	public Produit(Catalogue catalogue){
		super();
		catalogue.ajouterProduit(this);
	}
	public Produit(String reference, String nom, Double prix, Catalogue catalogue, String description, 
			String descriptionLongue) {
		super();
		this.reference = reference;
		this.description = description;
		this.prix = prix;
		this.catalogue = catalogue;
		this.nom = nom;
		this.descriptionLongue = descriptionLongue;
		// ajout du produit au catalogue
		catalogue.ajouterProduit(this);
	}
	@Override
	public String toString() {
		return "Produit [reference=" + reference + ", description=" + description + ", prix=" + prix + ", nom=" + nom
				+ ", descriptionLongue=" + descriptionLongue + "]";
	}
	
	
	
	
}
