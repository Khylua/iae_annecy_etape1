package gestionProduitsMVC.Controller.Catalogue;

import gestionProduitsMVC.Model.Produit;
import gestionProduitsMVC.View.Element;
import gestionProduitsMVC.View.Question;
import gestionProduitsMVC.View.Menu.MenuModificationProduit;

/**
 * @author karinerevet
 * Controller pour gérer la modification de produit - quel attribut modifier 
 */
public class MenuModificationProduitController {
	
	// attributs
	private MenuModificationProduit mmp;
	private Produit produit;
	
	// getters et setters
	public MenuModificationProduit getMmp() {
		return mmp;
	}
	public void setMmp(MenuModificationProduit mmp) {
		this.mmp = mmp;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	// constructeur
	public MenuModificationProduitController(MenuModificationProduit mmp, Produit produit) {
		super();
		this.mmp = mmp;
		this.produit = produit;
	}
	
	// modification attribut produit
	public void traitementModificationProduit(){
		// valeur attribut
		String attribut = "";
		switch(Integer.parseInt(this.getMmp().getReponse())){
			case 0 :
				Element out = new Element("-- Sortie de l'application ! --", 3);
				out.initElement();
				System.exit(0);
				break;
			case 1 : // nom
				attribut = "le nom";
				break;
			case 2 : // prix
				attribut = "le prix";
				break;
			case 3 : // desc courte
				attribut = "la description courte";
				break;
			case 4 : // desc longue
				attribut = "la description longue";
				break;
			/*case 5 : // reference
				attribut = "la référence";
				break;
			*/
			default :
				Element error = new Element("-- Erreur de saisir --", 1);
				error.initElement();
				this.getMmp().initMenu();
				break;
		}
		// question de modification
		Question modifAttribut = new Question("Modification du produit " + this.getProduit().getReference(), "Saississez la nouvelle valeur pour "+attribut);
		modifAttribut.initQuestion();
		String nouvelleValeur = modifAttribut.getReponse();
		// traitement question
		switch(Integer.parseInt(this.getMmp().getReponse())){
			case 1 : // nom
				this.getProduit().setNom(nouvelleValeur);
				break;
			case 2 : // prix
				this.getProduit().setPrix(Double.parseDouble(nouvelleValeur));
				break;
			case 3 : // desc courte
				this.getProduit().setDescription(nouvelleValeur);
				break;
			case 4 : // desc longue
				this.getProduit().setDescriptionLongue(nouvelleValeur);
				break;
			/*case 5 : // reference
				this.getProduit().setReference(nouvelle_valeur);
				break;
			*/
			default :
				Element error = new Element("-- Erreur --", 1);
				error.initElement();
				this.getMmp().initMenu();
				break;
		}
		// message réussite
		Element messReussite = new Element("Modification effectuée avec succès sur "+attribut+" du produit "+this.getProduit().getReference(), 2);
		messReussite.initElement();
	}
	

}
