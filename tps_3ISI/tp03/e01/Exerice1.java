package tps_3ISI.tp03.e01;

import java.util.Scanner;

public class Exerice1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("donner une chaine:");
		String ch = sc.nextLine();
		sc.close();

		char chars[] = new char[128];

		
		for (int i=0; i<ch.length(); i++) {
			chars[ch.charAt(i)]++;
		}
		
		for (int i=0; i<chars.length; i++) {
			if (chars[i] != 0) {
				System.out.println( (char)i+ " fois " + chars[i]);
			}
		}

	}
}
