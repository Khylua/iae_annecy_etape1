package gestionProduitsMVC.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// attributs
	private String nom;
	private String prenom;
	private String numero;
	private String codePromo;
	private Annuaire annuaire;
	private Panier panierEnCours;
	private ArrayList<Panier> paniersHistorique;
	
	// getters et setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodePromo() {
		return codePromo;
	}
	public void setCodePromo(String codePromo) {
		this.codePromo = codePromo;
	}
	public Annuaire getAnnuaire() {
		return annuaire;
	}
	public void setAnnuaire(Annuaire annuaire) {
		this.annuaire = annuaire;
	}
	public Panier getPanierEnCours() {
		return panierEnCours;
	}
	public void setPanierEnCours(Panier panierEnCours) {
		this.panierEnCours = panierEnCours;
	}
	public ArrayList<Panier> getPaniersHistorique() {
		return paniersHistorique;
	}
	public void setPaniersHistorique(ArrayList<Panier> paniersHistorique) {
		this.paniersHistorique = paniersHistorique;
	}
	
	
	// constructeurs
	public Client(Annuaire annuaire){
		super();
		annuaire.ajouterClient(this);
		this.paniersHistorique = new ArrayList<Panier>();
	}
	public Client(Annuaire a, String nom, String prenom, String numero, String codePromo) {
		this(a, nom, prenom, numero);
		this.codePromo = codePromo;
	}
	public Client(Annuaire a, String nom, String prenom, String numero) {
		this(a);
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.annuaire = a;
	}
	
	// affichage
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", codePromo=" + codePromo + "]";
	}
	
	
	
	
}
