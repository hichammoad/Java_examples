package tps_3ISI.tp01e02;

public class Exercice2 {
	public static void main(String[] args) {
		int total = 0;
		
		int score=0;
		int tentatives=0;
		while (total < 21) {
			tentatives++;
			score = (int) (Math.random() * 6 + 1);
			total += score;
		}
		System.out.println("Score total obtenu = "+total+" Nombre des tentatives  = "+tentatives);
	}
}
