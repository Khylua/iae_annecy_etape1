package gestionProduitsMVC.View.Panier;

import java.util.ArrayList;
import java.util.Iterator;

import gestionProduitsMVC.Model.Panier;
import gestionProduitsMVC.View.Element;

/**
 * @author karinerevet
 * Vue gérant l'affichage des commandes
 */
public class CommandesVue {
	//attribut
	private ArrayList<Panier> historique;
	
	//getters et setters
	public ArrayList<Panier> getHistorique() {
		return historique;
	}
	public void setHistorique(ArrayList<Panier> historique) {
		this.historique = historique;
	}
	
	//constructeur
	public CommandesVue(ArrayList<Panier> historique) {
		super();
		this.historique = historique;
	}
	
	

	// données catalogue
	@Override
	public String toString(){
		return "Historique ("+ historique.size() +" commandes)";
	}
	
	// afficher catalogue
	public void afficher(Double promo){
		Element cat = new Element(this.toString());
		cat.initElement();
		Iterator<Panier> it = this.getHistorique().iterator();
		Integer i = 1;
		while(it.hasNext()){
			Panier current = it.next();
			PanierVue pv = new PanierVue(current);
			pv.afficherPanier(promo);
			i++;
		}
	}
}
