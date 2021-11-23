package collections.gestion_exam;

import java.util.Arrays;

public class MainApp {

	public static void main(String[] args) {
		
		Question question1  = new Question("Lequel des éléments suivants n’est pas un concept POO en Java?",1, Arrays.asList(
				new Reponse("Héritage", false),
				new Reponse("Encapsulation", false),
				new Reponse("Polymorphisme", false),
				new Reponse("Compilation", true) // n'est pas...
		)) ;
		
		Question question2 = new Question("Quand la surcharge de méthode est-elle déterminée?",2, Arrays.asList(
				new Reponse("Au moment de l’exécution", false),
				new Reponse("Au moment de la compilation", true),
				new Reponse("Au moment du codage", false),
				new Reponse("Au moment de l’exécution", false)
		)) ;
		
		Question question3 = new Question("Quels keywords sont utilisés pour spécifier la visibilité des propriétés et des méthodes ?",2, Arrays.asList(
				new Reponse("final", false),
				new Reponse("private", true),
				new Reponse("abstract", false),
				new Reponse("public", true),
				new Reponse("protected", true)
		)) ;
		
		Examen examen1 = new Examen("Java: POO");
		examen1.getQuestions().addAll(Arrays.asList(question1, question2, question3));
		
		
		
		for(Question a_question : examen1.getQuestions()) {
			System.out.print(a_question.getEnnonce());
			System.out.print("("+ a_question.getReponses().size()+" choix)");
			System.out.println("\tDifficulté: "+ a_question.getDifficulte());
			
			for(Reponse a_reponse : a_question.getReponses()) {
				System.out.println("\t\t-"+a_reponse.getEnnonce());
			}
		}
		
		
	}
	
	
	
	
}
