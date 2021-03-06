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
 * Base de données : lien avec le fichier enregistrant la gestion des produits (catalogue)
 */
public class BddCatalogue implements Serializable{

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
	public BddCatalogue(String filename, Catalogue c) {
		super();
		this.filename = filename;
		this.lireCatalogueBDD(c);
		c.setBddP(this);
	}
	
	// lit la BDD et écrit dans le catalogue
	private void lireCatalogueBDD(Catalogue c){
		try {
			// récupération des données pour les mettre dans le catalogue
			ObjectInputStream ois;
			ois = new ObjectInputStream(
		              new BufferedInputStream(
		                new FileInputStream(
		                  new File(filename))));
			try {
				Catalogue cat = (Catalogue) ois.readObject();
				// on change la liste du catalogue
				c.setListeDeProduits(cat.getListeDeProduits());;
			
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
	
	// lit le catalogue et écrit dans la BDD
	public void ajoutCatalogueBDD(Catalogue c){
		// ajout au fichier bdd
		ObjectOutputStream oos;
		 try {
		      oos = new ObjectOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File(this.getFilename()))));
		      //écriture de l'objet dans le fichier
		      oos.writeObject(c);
		      //fermeture du fichier
		      oos.close();
		 } catch (FileNotFoundException e) {
		      e.printStackTrace();
		 } catch (IOException e) {
		      e.printStackTrace();
		 } 
	}
	
	// supprimer données
	public void clearCatalogueBDD(){
		// ajout du produit au fichier bdd
		ObjectOutputStream oos;
		 try {
		      oos = new ObjectOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File(this.getFilename()))));
		      oos.reset();
		      oos.flush();
		      //fermeture du fichier
		      oos.close();
		 } catch (FileNotFoundException e) {
		      e.printStackTrace();
		 } catch (IOException e) {
		      e.printStackTrace();
		 }
		 
	}
	
	// modifier	
	public void miseAJourCatalogueBDD(Catalogue c){
		// on efface le fichier
		this.clearCatalogueBDD();
		// on écrit dans le fichier avec la nouvelle liste
		this.ajoutCatalogueBDD(c);
	}
	
}
