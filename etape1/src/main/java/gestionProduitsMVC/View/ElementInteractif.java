package gestionProduitsMVC.View;

import java.util.Scanner;

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
	
	//lecture réponse
	public void lectureReponse(){
		Scanner scan1 = new Scanner(System.in);
		String choix = scan1.nextLine();
		this.setReponse(choix);
		//scan1.close();
	}
	
	
}
