package collections.gestion_exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
	private int id;
	private String ennonce;
	private int difficulte;
	private List<Reponse> reponses = new ArrayList<Reponse>();

	public Question(int id, String ennonce, int difficulte, List<Reponse> reponses) {
		this.id = id;
		this.ennonce = ennonce;
		this.difficulte = difficulte;
		this.reponses = reponses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void printQuestion() {
		System.out.print(id + ": " + ennonce);
		System.out.print("(" + reponses.size() + " choix)");
		System.out.println("\tDifficulté: " + difficulte);

		for (Reponse a_reponse : reponses) {
			System.out.println("\t\t-" + a_reponse.getId() + " : " + a_reponse.getEnnonce() + " " + scorePerForTrueResp());
		}
	}

	// questions à choix multiples,=== get score per response! ex: 1, 1/2, 1/3, 1/4,
	// ...;
	public double scorePerForTrueResp() {
		int nbrTrue = 0;
		for (Reponse r : reponses) {
			if (r.isVerite()) {
				nbrTrue++;
			}
		}
		return ((double) 1 / nbrTrue);
	}

	// you can update this to consider other evaluation dimensions such as question
	// difficulty etc.
	public double calculateNote(int[] respIds) {
		double note = 0;
		for (Reponse r : reponses) {
			for (int respId : respIds) {
				if (r.getId() == respId) {
					if (r.isVerite()) {
						note = note + scorePerForTrueResp();
					} else {
						// penalize wrong responses:
						note = note - scorePerForTrueResp();
					}
				}
			}
		}
		if (note < 0) {
			note = 0;
		}
		return (note);
	}

}
