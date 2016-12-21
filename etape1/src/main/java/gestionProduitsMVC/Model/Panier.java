package gestionProduitsMVC.Model;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * @author karinerevet
 * modèle représentant la gestion de collection de produits, la notion de commande
 * nb : les paniers sont associés à un client chacun
 */
public class Panier implements Serializable{

	private static final long serialVersionUID = 1L;
	// attributs
	private Hashtable<Produit,Integer> produits;
	private Boolean commande;
	
	// getters et setters
	public Boolean getCommande() {
		return commande;
	}
	public Hashtable<Produit, Integer> getProduits() {
		return produits;
	}
	public void setProduits(Hashtable<Produit, Integer> produits) {
		this.produits = produits;
	}
	public void setCommande(Boolean commande) {
		this.commande = commande;
	}
	public Panier() {
		super();
		this.commande = false;
		this.produits = new Hashtable<Produit, Integer>();
	}
	
	// ajouter
	public void ajouterProduit(Produit cle, Integer valeur){
		this.getProduits().put(cle, valeur);
		//System.out.println(this.toString());
	}
	
	// rechercher quantité avec le produit
	public Integer chercherQuantiteProduit(Produit p){
		return this.getProduits().get(p);
	}
	@Override
	public String toString() {
		return "Panier [produits=" + produits + "]";
	}
	
	
	
	
}
