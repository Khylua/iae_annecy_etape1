package gestionProduitsMVC.View.Menu;

/**
 * @author karinerevet
 * Vue gérant l'affichage du menu gérant les produits
 */
public class MenuProduit  extends Menu{

	public MenuProduit(String nom) {
		super(nom);
		this.ajouterProposition("1", "Ajouter un produit");
		this.ajouterProposition("2", "Modifier un produit");
		this.ajouterProposition("3", "Supprimer un produit");
		this.ajouterProposition("4", "Afficher le détail d'un produit");
		this.ajouterProposition("5", "Afficher le catalogue");
	}

}
