package gestionProduitsMVC.Controller;

import gestionProduitsMVC.View.ElementInteractif;
import gestionProduitsMVC.View.Menu.MenuDemarrage;

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
	
	//constructeur
	public MenuDemarrageController(MenuDemarrage menuDemarrage) {
		super();
		this.menuDemarrage = menuDemarrage;
	}
	
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
				ElementInteractif error = new ElementInteractif("-- Erreur de saisir --");
				error.initElement();
				this.getMenuDemarrage().initMenu();
				break;
		}
		// TODO : gestion des erreurs si la saisie n'est pas de type integer - retourner même résultat que défault
		return rep;
	}
	
	
}
