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

public class BddClient {
	// attributs
	private String filename;
	private Annuaire annuaire;
	
	// getters et setters 
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Annuaire getAnnuaire() {
		return annuaire;
	}
	public void setAnnuaire(Annuaire annuaire) {
		this.annuaire = annuaire;
	}
	
	// constructeur
	public BddClient(String filename, Annuaire a) {
		super();
		this.filename = filename;
		this.annuaire = a;
		this.lireClientBDD();
	}
	
	// lit la BDD et écrit dans le annuaire
	private void lireClientBDD(){
		try {
			// récupération des données pour les mettre dans le annuaire
			ObjectInputStream ois;
			ois = new ObjectInputStream(
		              new BufferedInputStream(
		                new FileInputStream(
		                  new File(filename))));
			try {
				ArrayList<Client> listC = (ArrayList<Client>)ois.readObject();
				// on change la liste du annuaire
				this.getAnnuaire().setListeDesClients(listC);
			
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
	
	// lit le annuaire et écrit dans la BDD
	public void ajoutClientBDD(){
		// on récupère le annuaire
		ArrayList<Client> listC = this.getAnnuaire().getListeDesClients();
		// ajout au fichier bdd
		ObjectOutputStream oos;
		 try {
		      oos = new ObjectOutputStream(
		              new BufferedOutputStream(
		                new FileOutputStream(
		                  new File(this.getFilename()))));
		      //écriture de l'objet dans le fichier
		      oos.writeObject(listC);
		      //fermeture du fichier
		      oos.close();
		 } catch (FileNotFoundException e) {
		      e.printStackTrace();
		 } catch (IOException e) {
		      e.printStackTrace();
		 } 
	}
	
	// supprimer données
	public void clearClientBDD(){
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
		      e.printStackTrace();
		 }
	}
	
	// modifier	
	public void miseAJourClientBDD(){
		// on efface le fichier
		this.clearClientBDD();
		// on écrit dans le fichier avec la nouvelle liste
		this.ajoutClientBDD();
	}
	
}
