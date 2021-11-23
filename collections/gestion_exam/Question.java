package collections.gestion_exam;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private String ennonce;
	private int difficulte;
	private List<Reponse> reponses = new ArrayList<Reponse>();
	
	public Question(String ennonce, int difficulte, List<Reponse> reponses ) {
		this.ennonce = ennonce;
		this.difficulte = difficulte;
		this.reponses = reponses;
	}
	
	public String getEnnonce() {
		return ennonce;
	}
	
	public void setEnnonce(String ennonce) {
		this.ennonce = ennonce;
	}
	public int getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}
	public List<Reponse> getReponses() {
		return reponses;
	}
	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}
	
	
}

