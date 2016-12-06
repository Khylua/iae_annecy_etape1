package org.iae.annecy.st1.etape1.model.person;

import org.iae.annecy.st1.common.mvc.Controller;
import org.iae.annecy.st1.common.mvc.DataParam;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.Model;

public class PersonGetModel implements Model {

	public Person get(Integer id) {
		Person retrunVal = null;
		if (id > 10) {
			retrunVal = new Person(id, "DERUETTE", "Jérémie");
		} else if (id > 5) {
			retrunVal = new Person(id, "TEST", "test 42");
		}else{
			retrunVal = new Person(0, "UNKNOW", "Inconu");
		}
		return retrunVal;
	}

	public DataView get() {
		return null;
	}

	public DataView get(DataParam datas) {
		Person customer = get(Integer.parseInt(datas.getData("id")));
		return customer.asDataView();
	}

	public String getPath() {
		return "person:get";
	}

	public void register(Controller controller) {
		controller.add(getPath(), this);
	}
}
