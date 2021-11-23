package collections.gestion_exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Examen {

	private int id;
	String thematique;
	private List<Question> questions = new ArrayList<Question>();

	public Examen(int id, String thematique) {
		this.id = id;
		this.thematique = thematique;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThematique() {
		return thematique;
	}

	public void setThematique(String thematique) {
		this.thematique = thematique;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public static Examen generateExam() {
		Question question1 = new Question(1, "Lequel des éléments suivants n’est pas un concept POO en Java?", 1,
				Arrays.asList(new Reponse(1, "Héritage", false), new Reponse(2, "Encapsulation", false),
						new Reponse(3, "Polymorphisme", false), new Reponse(4, "Compilation", true) // n'est pas...
				));

		Question question2 = new Question(2, "Quand la surcharge de méthode est-elle déterminée?", 2,
				Arrays.asList(new Reponse(1, "Au moment de l’exécution", false),
						new Reponse(2, "Au moment de la compilation", true),
						new Reponse(3, "Au moment du codage", false)));

		Question question3 = new Question(3,
				"Quels keywords sont utilisés pour spécifier la visibilité des propriétés et des méthodes ?", 2,
				Arrays.asList(new Reponse(1, "final", false), new Reponse(2, "private", true),
						new Reponse(3, "abstract", false), new Reponse(4, "public", true),
						new Reponse(5, "protected", true)));

		Examen examen1 = new Examen(1, "Java: POO");
		examen1.getQuestions().addAll(Arrays.asList(question1, question2, question3));

		return (examen1);
	}

	public double startExamen() {
		double noteExam = 0;
		for (Question question : questions) {
			question.printQuestion();
			System.out.println("What is/are your answer(s)? enter values separated by space ex:1 2");
			Scanner sc = new Scanner(System.in);
			String[] stringResps;

			stringResps = sc.nextLine().split(" ");
			int[] resps = new int[stringResps.length];
			for (int i = 0; i < stringResps.length; i++) {
				resps[i] = Integer.parseInt(stringResps[i]);
			}

			double n = question.calculateNote(resps);
			noteExam += n;
		}
		return (noteExam);
	}

}
