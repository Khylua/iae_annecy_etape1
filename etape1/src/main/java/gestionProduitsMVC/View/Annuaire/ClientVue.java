package gestionProduitsMVC.View.Annuaire;

import gestionProduitsMVC.Model.Client;
import gestionProduitsMVC.View.Element;

/**
 * @author karinerevet
 * vue gérant l'affichage d'un client
 */
public class ClientVue {
	// attribut
	private Client client;
	
	// getters et setters 
	public Client getClient() {
		return client;
	}
	public void setProduit(Client client) {
		this.client = client;
	}
	
	
	// constructeur
	public ClientVue(Client client) {
		super();
		this.client = client;
	}
	
	// données client simple
	@Override
	public String toString() {
		return "\t Client --> numero = " + client.getNumero() + 
				", nom = " + client.getNom() + 
				", prenom = " + client.getPrenom() + 
				", code promo = " + client.getCodePromo() + "";
	}
	
	// affichage client simple
	public void afficherClientSimple(){
		Element cat = new Element(this.toString());
		cat.initElement();
	}
	
}
