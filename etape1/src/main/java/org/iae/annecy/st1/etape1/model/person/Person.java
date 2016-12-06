package org.iae.annecy.st1.etape1.model.person;

import org.iae.annecy.st1.common.mvc.AbstractDataView;
import org.iae.annecy.st1.common.mvc.BasicDataView;
import org.iae.annecy.st1.common.mvc.DataView;

public class Person extends AbstractDataView {

	private Integer id;
	private String nom;
	private String prenom;

	public Person() {
		super();
	}

	public Person(Integer id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Person(DataView datas){
		this.id = Integer.parseInt(datas.getData("id"));
		this.prenom = datas.getData("prenom");
		this.nom = datas.getData("nom");
	}

	public DataView asDataView() {
		DataView datas = new BasicDataView();
		datas.add("id", id.toString());
		datas.add("nom", nom);
		datas.add("prenom", prenom);
		
		return datas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

}
