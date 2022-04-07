package tps_3ISI.tp03.e01;

import java.util.Scanner;

public class Exerice1_v2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("donner une chaine:");
		String ch = sc.nextLine();
		sc.close();

		char chars[] = { 'a', 'o', 'i', 'u', 'y', 'e' };

		for (int j = 0; j < chars.length; j++) {
			int c = 0;
			for (int i = 0; i < ch.length(); i++) {
				if (ch.charAt(i) == chars[j]) {
					c++;
				}
			}
			System.out.println(chars[j] + " fois " + c);

		}

	}
}
