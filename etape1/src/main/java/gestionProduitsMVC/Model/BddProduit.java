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
import java.util.ArrayList;

public class BddProduit {
	// attributs
	private String filename;
	private Catalogue catalogue;
	
	// getters et setters 
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Catalogue getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
	
	// constructeur
	public BddProduit(String filename, Catalogue c) {
		super();
		this.filename = filename;
		this.catalogue = c;
		this.lireProduitBDD();
	}
	
	// lit la BDD et écrit dans le catalogue
	private void lireProduitBDD(){
		try {
			// récupération des données pour les mettre dans le catalogue
			ObjectInputStream ois;
			ois = new ObjectInputStream(
		              new BufferedInputStream(
		                new FileInputStream(
		                  new File(filename))));
			try {
				ArrayList<Produit> listP = (ArrayList<Produit>)ois.readObject();
				// on change la liste du catalogue
				this.getCatalogue().setListeDeProduits(listP);
			
			}catch (EOFException e){
				ois.close(); // gestion erreur de fin de fichier
			}catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }  
		} catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }  
	}
	
	// lit le catalogue et écrit dans la BDD
	public void ajoutProduitBDD(){
		// on récupère le catalogue
		ArrayList<Produit> listP = this.getCatalogue().getListeDeProduits();
		// ajout au fichier bdd
		ObjectOutputStream oos;
		 try {
		      oos = new ObjectOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File(this.getFilename()))));
		      //écriture de l'objet dans le fichier
		      oos.writeObject(listP);
		      //fermeture du fichier
		      oos.close();
		 } catch (FileNotFoundException e) {
		      e.printStackTrace();
		 } catch (IOException e) {
		      e.printStackTrace();
		 } 
	}
	
	// supprimer données
	public void clearProduitBDD(){
		// ajout du produit au fichier bdd
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
		      e.printStackTrace();
		 }
	}
	
	// modifier	
	public void miseAJourProduitBDD(){
		// on efface le fichier
		this.clearProduitBDD();
		// on écrit dans le fichier avec la nouvelle liste
		this.ajoutProduitBDD();
	}
	
}
