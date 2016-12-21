package gestionProduitsMVC.Controller;

import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Menu.MenuDemarrage;

/**
 * @author karinerevet
  La classe MenuDemarrageController permet de gérer la saisie utilisateur du menu initial
 */

public class MenuDemarrageController {
	
	//attribut
	private MenuDemarrage menuDemarrage;
	
	//getters et setters
	public MenuDemarrage getMenuDemarrage() {
		return menuDemarrage;
	}
	public void setMenuDemarrage(MenuDemarrage menuDemarrage) {
		this.menuDemarrage = menuDemarrage;
	}
	
	// constructeur
	/**
	 * @param menuDemarrage
	 * Permet de lier le controller à l'élément qu'il gère, à savoir un MenuDemarrage
	 */
	public MenuDemarrageController(MenuDemarrage menuDemarrage) {
		super();
		this.menuDemarrage = menuDemarrage;
	}
	
	// traitement de la réponse associée au MenuDemarrage
	/**
	 * @return un entier (Integer)
	 */
	public int traitementDemarrage(){
		String choix = this.getMenuDemarrage().getReponse();
		Integer rep = 0;
		switch(Integer.parseInt(choix)){
			case 0 :
				this.getMenuDemarrage().sortieApplication();
				break;
			case 1 : // produit
				rep = 1;
				break;
			case 2 : // client
				rep = 2;
				break;
			case 3 : // panier
				rep = 3;
				break;
			default :
				ElementInteractif error = new ElementInteractif("-- Erreur de saisir --", 1);
				error.initElement();
				this.getMenuDemarrage().initMenu();
				break;
		}
		// TODO : gestion des erreurs si la saisie n'est pas de type integer - retourner même résultat que défault
		return rep;
	}
	
}