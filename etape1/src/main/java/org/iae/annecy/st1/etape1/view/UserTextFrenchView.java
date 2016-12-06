/**
 * 
 */

package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;

/**
 * Permet une representation textuel d'un utilisateur.
 * 
 * @author Djer1013
 */
public class UserTextFrenchView implements StringView {

	/**
	 * Renvoie une representation en text brute d'un utilsiateur.
	 */
	public String build(final DataView datas) {

		final String textView = "Bonjour " + datas.getData("name") + "!";

		return textView;
	}

}
