package gestionProduitsMVC.View;

import java.util.Scanner;

/**
 * @author karinerevet
 * Vue héritant de Element
 * ajoute la gestion des interactions (scanner)
 */
public class ElementInteractif extends Element{

	// attributs
	private String reponse;
	
	// getters et setters
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	// constructeur
	public ElementInteractif(String nom) {
		super(nom);
	}
	
	public ElementInteractif(String nom, Integer code) {
		super(nom, code);
	}
	
	//lecture réponse
	public void lectureReponse(){
		Scanner scan1 = new Scanner(System.in);
		String choix = scan1.nextLine();
		this.setReponse(choix);
		//scan1.close();
	}
	
	
}
