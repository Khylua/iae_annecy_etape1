package gestionProduitsMVC.View.Annuaire;

import java.util.Iterator;

import gestionProduitsMVC.Model.Annuaire;
import gestionProduitsMVC.Model.Client;
import gestionProduitsMVC.View.Element;

/**
 * @author karinerevet
 * vue gérant l'affichage de l'annuaire des clients
 */
public class AnnuaireVue {
	//attribut
	private Annuaire annuaire;
	
	//getters et setters
	public Annuaire getAnnuaire() {
		return annuaire;
	}
	public void setAnnuaire(Annuaire annuaire) {
		this.annuaire = annuaire;
	}
	
	//constructeur
	public AnnuaireVue(Annuaire annuaire) {
		super();
		this.annuaire = annuaire;
	}
	
	// données catalogue
	@Override
	public String toString(){
		return "Annuaire ("+ annuaire.getListeDesClients().size() +" clients)";
	}
	
	// afficher catalogue
	public void afficherAnnuaire(){
		Element cat = new Element(this.toString());
		cat.initElement();
		Iterator<Client> it = this.getAnnuaire().getListeDesClients().iterator();
		while(it.hasNext()){
			Client current = it.next();
			ClientVue cv = new ClientVue(current);
			cv.afficherClientSimple();
		}
	}
}
