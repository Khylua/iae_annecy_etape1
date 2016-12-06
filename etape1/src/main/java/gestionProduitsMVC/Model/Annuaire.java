package gestionProduitsMVC.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Annuaire implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//attributs
	private ArrayList<Client> listeDesClients;

	// getters et setters
	public ArrayList<Client> getListeDesClients() {
		return listeDesClients;
	}
	public void setListeDesClients(ArrayList<Client> listeDesClients) {
		this.listeDesClients = listeDesClients;
	}
	
	// constructeur
	public Annuaire() {
		super();
		this.listeDesClients = new ArrayList<Client>();
	}
	
	// méthodes d'ajout
		public void ajouterClient(Client unClient){
			this.listeDesClients.add(unClient);
		}
		
	// recherche
	public Client chercherClientParNum(String num){
		Iterator<Client> it = this.getListeDesClients().iterator();
		while(it.hasNext()){
			Client current = it.next();
			if(num.equals(current.getNumero())){
				return current;
			}
		}
		Client c = null;
		return c;
	}
	
}
