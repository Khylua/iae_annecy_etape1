package gestionProduitsMVC.View.Menu;

/**
 * @author karinerevet
 * Vue gérant l'affichage du menu d'accès au panier
 */
public class MenuPanier extends Menu{
	
	public MenuPanier(String nom) {
		super(nom);
		this.ajouterProposition("1", "Ajouter un produit au panier");
		this.ajouterProposition("2", "Modifier la quantité d'un produit du panier");
		this.ajouterProposition("3", "Supprimer un produit du panier");
		this.ajouterProposition("4", "Afficher le récapitulatif du panier");
		this.ajouterProposition("5", "Valider mon panier en commande");
		this.ajouterProposition("6", "Visualiser l'historique des commandes");
	}
}
