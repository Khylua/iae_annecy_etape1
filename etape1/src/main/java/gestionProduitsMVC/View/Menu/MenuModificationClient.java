package gestionProduitsMVC.View.Menu;

public class MenuModificationClient extends Menu{

	public MenuModificationClient(String nom) {
		super(nom);
		this.ajouterProposition("1", "Nom");
		this.ajouterProposition("2", "Prénom");
		this.ajouterProposition("3", "Numéro");
		this.ajouterProposition("4", "Code promo");
	}
}
