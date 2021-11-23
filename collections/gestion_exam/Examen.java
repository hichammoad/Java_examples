package collections.gestion_exam;

import java.util.ArrayList;
import java.util.List;

public class Examen {

	String thematique;
	private List<Question> questions = new ArrayList<Question>();

	public Examen(String thematique) {
		this.thematique = thematique;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
