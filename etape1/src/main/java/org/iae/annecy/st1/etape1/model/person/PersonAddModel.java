package org.iae.annecy.st1.etape1.model.person;

import org.iae.annecy.st1.common.mvc.Controller;
import org.iae.annecy.st1.common.mvc.DataParam;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.Model;
import org.iae.annecy.st1.etape1.model.UserData;

public class PersonAddModel implements Model {

	public Boolean add(Person customer) {
		Boolean added = Boolean.FALSE;
		if (customer.getId() < 100) {
			added = Boolean.TRUE;
		} else {
			added = Boolean.FALSE;
		}
		return added;
	}

	public DataView get(DataParam datas) {
		final DataView datasRet = new UserData();
		final Boolean isAdded = add(new Person(datas));
		datasRet.add("status", isAdded.toString());

		return datasRet;
	}

	public String getPath() {
		return "person:add";
	}

	public void register(Controller controller) {
		controller.add(getPath(), this);
	}

	public DataView get() {
		return null;
	}
}
