package gestionProduitsMVC.View.Menu;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import gestionProduitsMVC.View.ElementInteractif;

/**
 * @author karinerevet
 * Vue gérant l'affichage d'un menu
 * un menu est un élément interactif
 */
public class Menu extends ElementInteractif{
	
	// attributs
	private Hashtable<String,String> propositions;
	
	// getters and setters
	public Hashtable<String,String> getPropositions() {
		return propositions;
	}
	public void setPropositions(Hashtable<String, String> propositions) {
		this.propositions = propositions;
	}
	
	// constructeur
	public Menu(String nom) {
		super(nom);
		this.propositions = new Hashtable<String, String>();
		this.ajouterProposition("0", "Quitter");
	}
    
	// ajouterProposition
	public void ajouterProposition(String cle, String valeur){
		this.getPropositions().put(cle, valeur);
	}

	// rechercher valeur avec la clé
	public String chercherValeur(String cle){
		return this.getPropositions().get(cle);
	}
	
	//init
	public void initMenu(){
		this.initElement();
		this.affichage(this.afficherPropositions());
		this.lectureReponse();
	}
	
	// afficher propositions
	public String afficherPropositions(){
		String res = "";
		Set<Entry<String, String>> set = this.getPropositions().entrySet();
	    Iterator<Entry<String, String>> it = set.iterator();
	    while (it.hasNext()) {
	      Map.Entry<String,String> entry = (Map.Entry<String,String>) it.next();
	      res = res + entry.getKey() + " - " + entry.getValue() + "\n";
	    }
	    return res;
	}
	
	
	public void sortieApplication(){
		ElementInteractif out = new ElementInteractif("-- Sortie de l'application ! --");
		out.initElement();
		// TODO : enregistrement des données avant de quitter
		System.exit(0);
	}
	

}
