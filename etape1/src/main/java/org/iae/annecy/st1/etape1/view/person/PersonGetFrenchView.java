package org.iae.annecy.st1.etape1.view.person;

import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;

public class PersonGetFrenchView implements StringView {

	public String build(DataView datas) {
		return "Persone : id="+datas.getData("id")+", Nom = "+datas.getData("nom")+", prénom =" + datas.getData("prenom");
	}

}
