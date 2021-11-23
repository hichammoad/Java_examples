package collections.gestion_exam;

public class MainApp {

	public static void main(String[] args) {

		Examen examen = Examen.generateExam();

		double note = examen.startExamen();

		System.out.println("La note finale est: " + note + " / " + examen.getQuestions().size());

	}

}
