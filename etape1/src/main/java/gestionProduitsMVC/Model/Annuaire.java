package gestionProduitsMVC.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author karinerevet
 * Model permettant la gestion de l'ensemble des clients, par rapport à un annuaire
 */
public class Annuaire implements Serializable{

	private static final long serialVersionUID = 1L;
	//attributs
	private ArrayList<Client> listeDesClients;
	private BddAnnuaire bddC;

	// getters et setters
	public ArrayList<Client> getListeDesClients() {
		return listeDesClients;
	}
	public void setListeDesClients(ArrayList<Client> listeDesClients) {
		this.listeDesClients = listeDesClients;
	}
	public BddAnnuaire getBddC() {
		return bddC;
	}
	public void setBddC(BddAnnuaire bddC) {
		this.bddC = bddC;
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
