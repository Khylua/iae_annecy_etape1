package org.iae.annecy.st1.etape1.view.person;

import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;

public class PersonAddFrenchView implements StringView {

	public String build(DataView datas) {
		Boolean status = Boolean.parseBoolean(datas.getData("status"));
		String message = "La personne n'a pas put être ajoutée";
		if (status) {
			message = "Personne ajoutée avec succès";
		}

		return message;
	}

}
