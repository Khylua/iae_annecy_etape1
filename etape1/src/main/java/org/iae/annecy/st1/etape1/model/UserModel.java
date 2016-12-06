/**
 * 
 */

package org.iae.annecy.st1.etape1.model;

import org.iae.annecy.st1.common.mvc.Controller;
import org.iae.annecy.st1.common.mvc.DataParam;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.Model;

/**
 * Classe gérant les actions métiers possibles sur les utilisateurs.
 * 
 * @author Djer1013
 */
public class UserModel implements Model {

	/**
	 * Retourne les données d'exemple d'un utilisateur.
	 */
	public DataView get() {
		final DataView datas = new UserData();

		datas.add("name", "Karine");

		return datas;
	}

	/**
	 * Check Interface. {@inheritDoc}
	 */
	public String getPath() {
		return "user:display";
	}

	/**
	 * Check Interface. {@inheritDoc}
	 */
	public void register(final Controller controller) {
		controller.add(getPath(), this);
	}

	public DataView get(DataParam datas) {
		return null;
	}

}
