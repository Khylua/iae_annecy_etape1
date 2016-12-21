package gestionProduitsMVC.View;


/**
 * @author karinerevet
 * La classe Element permet de définir un objet graphique, utilisé pour créé der vues
 * Il affiche un message, avec une gestion des couleurs selon le type de message
 */
public class Element {
	
	// attributs
	private String nom;
	private String code;
	
	// getters et setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	// constructeur
	public Element(String nom) {
		this(nom, 0);
	}
	
	// constructeur avec gestion des couleurs
	public Element(String nom, Integer type){
		this.nom = nom;
		switch (type){
		case 1 : // couleur rouge - code erreur
			this.code = "\033[31m";
			break;
		case 2 : // couleur vert - code validé
			this.code = "\033[32m";
			break;
		case 3 : // couleur bleu - code notification
			this.code = "\033[34m";
			break;
		default : // couleur noir - code défaut
			this.code = "\033[30m";
			break;
		}
		
	}
	
	//affichage
	public void affichage(String monAffichage){
		System.out.println(monAffichage);
	}
	
	// initialiation de l'élément
	public void initElement(){
		this.affichage(this.getCode()+this.getNom());
	}
	
	
}
