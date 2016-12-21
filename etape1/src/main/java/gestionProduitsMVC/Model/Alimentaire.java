package gestionProduitsMVC.Model;

import java.util.Date;

/**
 * @author karinerevet
 * Model représentant les produits de type alimentaire
 */
public class Alimentaire extends Produit{
	
	private static final long serialVersionUID = 1L;
	// attribut
	private Date peremption;
	
	// getters et setters
	public Date getPeremption() {
		return peremption;
	}
	public void setPeremption(Date peremption) {
		this.peremption = peremption;
	}

	// constructeur
	public Alimentaire(String reference, String nom, Double prix, Catalogue catalogue, String description,
			String descriptionLongue, Date peremption) {
		super(reference, nom, prix, catalogue, description, descriptionLongue);
		this.peremption = peremption;
	}

	
}
