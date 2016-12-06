package gestionProduitsMVC.View.Menu;

public class MenuDemarrage  extends Menu{

	public MenuDemarrage(String nom) {
		super(nom);
		this.ajouterProposition("1", "Gérer les produits du catalogue");
		this.ajouterProposition("2", "Gérer les clients de l'annuaire");
		this.ajouterProposition("3", "Gérer son panier");
	}

}
