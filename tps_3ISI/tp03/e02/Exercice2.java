package tps_3ISI.tp03.e02;

import java.util.Scanner;

public class Exercice2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("chaine:?");
		String s = sc.nextLine();
		sc.close();

		String[] splitted = s.split("\\s+");
		for (int i = splitted.length - 1; i >= 0; i--) {
			System.out.print(splitted[i] + " ");
		}

	}
}
