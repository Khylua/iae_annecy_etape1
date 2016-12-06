package org.iae.annecy.st1.etape1.view.person;

import java.util.Scanner;

import org.iae.annecy.st1.common.mvc.BasicDataParam;
import org.iae.annecy.st1.common.mvc.ConsoleInputView;
import org.iae.annecy.st1.common.mvc.DataParam;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.tools.ConsoleHelper;

public class PersonCreateFrenchView implements ConsoleInputView {

	public DataView ask(Scanner scan) {
		StringBuilder sbMessage = new StringBuilder();
		sbMessage.append("Veuillez saisir sur une ligne différence : ");
		sbMessage.append(System.getProperty("line.separator"));
		sbMessage.append("L'indetifiant");
		sbMessage.append(System.getProperty("line.separator"));
		sbMessage.append("Le nom");
		sbMessage.append(System.getProperty("line.separator"));
		sbMessage.append("Le prénom");
		
		ConsoleHelper.display(sbMessage.toString());

		// recueille les données saisies par l'utilisateur
		DataParam newCustomer = new BasicDataParam();
		String personIdBulk = ConsoleHelper.read(scan);
		newCustomer.add("id", personIdBulk); // <100 = OK, sinon KO
		String personNomBulk = ConsoleHelper.read(scan);
		newCustomer.add("nom", personNomBulk);
		String personPrenomBulk = ConsoleHelper.read(scan);
		newCustomer.add("prenom", personPrenomBulk);

		return newCustomer;
	}
}
