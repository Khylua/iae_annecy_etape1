package gestionProduitsMVC.View.Menu;

/**
 * @author karinerevet
 * Vue gérant l'affichage du menu de modification produit
 */
public class MenuModificationProduit extends Menu {

	public MenuModificationProduit(String nom) {
		super(nom);
		this.ajouterProposition("1", "Nom");
		this.ajouterProposition("2", "Prix");
		this.ajouterProposition("3", "Description courte");
		this.ajouterProposition("4", "Description longue");
		//this.ajouterProposition("5", "Référence");
	}

}
