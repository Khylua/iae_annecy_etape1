package gestionProduitsMVC.Model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author karinerevet
 * Base de données : lien avec le fichier enregistrant la gestion des clients (annuaire)
 */
public class BddAnnuaire implements Serializable{
	private static final long serialVersionUID = 1L;
	// attributs
	private String filename;
	
	// getters et setters 
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	// constructeur
	public BddAnnuaire(String filename, Annuaire a) {
		super();
		this.filename = filename;
		this.lireAnnuaireBDD(a);
		a.setBddC(this);
	}
	
	// lit la BDD et écrit dans le annuaire
	private void lireAnnuaireBDD(Annuaire a){
		try {
			// récupération des données pour les mettre dans le annuaire
			ObjectInputStream ois;
			ois = new ObjectInputStream(
		              new BufferedInputStream(
		                new FileInputStream(
		                  new File(filename))));
			try {
				Annuaire ann = (Annuaire)ois.readObject();
				// on change la liste du annuaire
				a.setListeDesClients(ann.getListeDesClients());
			
			}catch (EOFException e){
				ois.close(); // gestion erreur de fin de fichier
			}catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }  
		} catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      //e.printStackTrace();
	    }  
	}
	
	// lit l'annuaire et écrit dans la BDD
	public void ajoutAnnuaireBDD(Annuaire a){
		// ajout au fichier bdd
		ObjectOutputStream oos;
		 try {
		      oos = new ObjectOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File(this.getFilename()))));
		      //écriture de l'objet dans le fichier
		      oos.writeObject(a);
		      //fermeture du fichier
		      oos.close();
		 } catch (FileNotFoundException e) {
		      e.printStackTrace();
		 } catch (IOException e) {
		      e.printStackTrace();
		 } 
	}
	
	// supprimer données
	public void clearAnnuaireBDD(){
		// ajout du client au fichier bdd
		ObjectOutputStream oos;
		 try {
		      oos = new ObjectOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File(this.getFilename()))));
		      oos.reset();
		      //fermeture du fichier
		      oos.close();
		 } catch (FileNotFoundException e) {
		      e.printStackTrace();
		 } catch (IOException e) {
		      //e.printStackTrace();
		 }
		 
	}
	
	// modifier	
	public void miseAJourAnnuaireBDD(Annuaire a){
		// on efface le fichier
		this.clearAnnuaireBDD();
		// on écrit dans le fichier avec la nouvelle liste
		this.ajoutAnnuaireBDD(a);
	}
	
}
