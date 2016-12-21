package gestionProduitsMVC.Model;

/**
 * @author karinerevet
 * modèle représentant les produits de type multimédia
 */
public class Multimedia extends Produit{

	private static final long serialVersionUID = 1L;
	//attributs
	Double taxeRecyclage;
	//getters et setters
	public Double getTaxeRecyclage() {
		return taxeRecyclage;
	}
	public void setTaxeRecyclage(Double taxeRecyclage) {
		this.taxeRecyclage = taxeRecyclage;
	}
	
	//constructeur
	public Multimedia(String reference, String nom, Double prix, Catalogue catalogue, String description,
			String descriptionLongue, Double taxeRecyclage) {
		super(reference, nom, prix, catalogue, description, descriptionLongue);
		// TODO Auto-generated constructor stub
		this.taxeRecyclage = taxeRecyclage;
	}

}
