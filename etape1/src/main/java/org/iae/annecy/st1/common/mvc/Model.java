/**
 * 
 */

package org.iae.annecy.st1.common.mvc;

/**
 * Definie le comprotement des Modeles.
 * 
 * @author Djer1013
 * 
 */
public interface Model {

	/**
	 * Recherche et récupère les données lié à ce modele.
	 * 
	 * @return Une represnetation des données géré par ce modèle.
	 */
	DataView get();

	/**
	 * Recherche et récupère les données lié à ce modele
	 * 
	 * @param datas
	 *            paramètre à envoyer au model
	 * @return Une represnetation des données géré par ce modèle.
	 */
	DataView get(DataParam datas);

	/**
	 * Définie le chemin d'acces à ce modèle.
	 * 
	 * @return Une chaine de texte identifiant de manière unique ce modèle.
	 */
	String getPath();

	/**
	 * Permet d'enregistrer ce modele auprès d'un controller
	 * 
	 * @param controller
	 *            Controlller à partir duquel se modele sera acessible.
	 */
	void register(Controller controller);
}
