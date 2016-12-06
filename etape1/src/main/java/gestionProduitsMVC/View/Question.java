package gestionProduitsMVC.View;

public class Question extends ElementInteractif{
	
	// attributs
	private String question;

	
	// getters et setters
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	

	// constructeur
	public Question(String nom, String question) {
		super(nom);
		this.question = question;
	}
	
	//init
	public void initQuestion(){
		this.initElement();
		this.affichage(this.question);
		this.lectureReponse();
	}
	
	

}
