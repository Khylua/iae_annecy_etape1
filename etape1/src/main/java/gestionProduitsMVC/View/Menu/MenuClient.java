package gestionProduitsMVC.View.Menu;

/**
 * @author karinerevet
 * Vue gérant l'affichage du menu client
 */
public class MenuClient extends Menu{

	public MenuClient(String nom) {
		super(nom);
		this.ajouterProposition("1", "Ajouter un client");
		this.ajouterProposition("2", "Modifier un client");
		this.ajouterProposition("3", "Supprimer un client");
		this.ajouterProposition("4", "Affichier l'annuaire");
	}
}
