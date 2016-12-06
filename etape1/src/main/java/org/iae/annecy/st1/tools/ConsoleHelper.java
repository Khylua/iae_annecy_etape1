/**
 * 
 */

package org.iae.annecy.st1.tools;

import gestionProduitsMVC.View.Element;

/**
 * Classe utilitaire pour gérer les intération utilisateur via une console.
 * 
 * @author Djer1013
 */
public final class ConsoleHelper {

	private ConsoleHelper() {

	}

	/**
	 * Affiche une message dans la console.
	 * 
	 * @param mesage
	 *            le message à afficher à l'utilisateur
	 */
	public static void display(final String mesage) {
		//System.out.println(mesage);
		(new Element(mesage)).initElement();
	}
}
