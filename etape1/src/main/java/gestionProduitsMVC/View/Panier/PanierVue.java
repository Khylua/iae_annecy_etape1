package gestionProduitsMVC.View.Panier;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import gestionProduitsMVC.Model.Panier;
import gestionProduitsMVC.Model.Produit;
import gestionProduitsMVC.View.Element;
import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Catalogue.ProduitVue;

/**
 * @author karinerevet
 * Vue gérant l'affichage du panier de produits d'un client
 */
public class PanierVue {
	//attribut
	private Panier panier;
	
	//getters et setters
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	//constructeur
	public PanierVue(Panier panier) {
		super();
		this.panier = panier;
	}
	
	// données catalogue
	@Override
	public String toString(){
		return "------ \nPanier \n------";
	}
	
	// afficher panier
	public void afficherPanier(Double reduction){
		// titre panier
		Element cat = new Element(this.toString());
		cat.initElement();
		// différents éléments du panier
		Set<Entry<Produit, Integer>> set = this.getPanier().getProduits().entrySet();
	    Iterator<Entry<Produit, Integer>> it = set.iterator();
	    Double facture = 0.0;
	    while (it.hasNext()) {
	      Map.Entry<Produit, Integer> entry = (Map.Entry<Produit, Integer>) it.next();
	      // affichage du produit
	      ProduitVue pv = new ProduitVue((Produit)entry.getKey());
	      pv.afficherProduitCommande();
	      // affichage de sa quantité
	      ElementInteractif qu = new ElementInteractif("\tQuantité = "+entry.getValue() +" exemplaire(s).");
	      qu.initElement();
	      // affichage prix total p * q
	      Integer quantite = (Integer)entry.getValue();
	      Double prix = ((Produit)entry.getKey()).getPrix();
	      Double qp = quantite*prix;
	      ElementInteractif qpT = new ElementInteractif("\tPrix global = "+ qp +"\n");
	      qpT.initElement();
	      facture = facture + qp;
	    }
	    Double fraisPort =6.00;
	    if(facture>=30){
	    	fraisPort=0.00;
	    }
	    // affichage total panier
	    ElementInteractif qpT = new ElementInteractif("\n\t --- TOTAL PANIER --- \n"
	    											+ "\t\t\t"+facture+"\n"
	    											+ "\t Frais port :\t"+fraisPort+"\n"
													+ "\t Réduction :\t"+reduction+"\n"
													+ "\t TOTAL = \t"+(facture-reduction+fraisPort)+"\n");
	    qpT.initElement();
	}

}
