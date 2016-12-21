package gestionProduitsMVC.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author karinerevet
 * Modèle gérant la collection de produit (catalogue)
 */
public class Catalogue implements Serializable{

	private static final long serialVersionUID = 1L;
	//attributs
	private ArrayList<Produit> listeDeProduits;
	private BddCatalogue bddP;
	
	//getters et setters
	public ArrayList<Produit> getListeDeProduits() {
		return listeDeProduits;
	}
	public void setListeDeProduits(ArrayList<Produit> listeDeProduits) {
		this.listeDeProduits = listeDeProduits;
	}
	public BddCatalogue getBddP() {
		return bddP;
	}
	public void setBddP(BddCatalogue bddP) {
		this.bddP = bddP;
	}
	
	//constructeur
	public Catalogue() {
		super();
		this.listeDeProduits = new ArrayList<Produit>();
	}
	
	// méthodes d'ajout
	public void ajouterProduit(Produit unProduit){
		this.listeDeProduits.add(unProduit);
	}
	
	// recherche
	public Produit chercherProduitParRef(String ref){
		/*for(int i = 0; i < this.getListeDeProduits().size(); i++){
			if(ref.equals(this.getListeDeProduits().get(i).getReference())){
				return this.getListeDeProduits().get(i);
			}
		}
		Produit p = null;
		return p;
		*/

		Iterator<Produit> it = this.getListeDeProduits().iterator();
		while(it.hasNext()){
			Produit current = it.next();
			if(ref.equals(current.getReference())){
				return current;
			}
		}
		Produit p = null;
		return p;
	}
	
}
