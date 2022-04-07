package tps_3ISI.tp03.e03;

import java.util.Scanner;

public class Exercice3 {

	private static String SUFFIXE_ER = "er";
	private static final String[] PRONOMS = { "je", "tu", "il", "nous", "vous", "elles" };
	private static final String[] SUFFIXES = { "e", "es", "e", "ons", "ez", "ent" };

	private static boolean estPremierGroupe(String verbe) {
		
		return (2<verbe.length() && verbe.substring(verbe.length() - 2).equals(SUFFIXE_ER));

	}

	public static void conjuguer(String verbe) {
		estPremierGroupe(verbe);
		verbe = verbe.substring(0, verbe.length() - SUFFIXE_ER.length());
		for (int i = 0; i < PRONOMS.length; i++)
			System.out.println(PRONOMS[i] + " " + verbe + SUFFIXES[i]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String verbe = "";

		
		while (!estPremierGroupe(verbe)) {
			System.out.println("Verbe?");
			verbe = sc.nextLine();
			// estPremierGroupe(verbe);
		}
		conjuguer(verbe);

	}
}
