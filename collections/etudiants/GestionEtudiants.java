package collections.etudiants;

import java.util.HashMap;
import java.util.Scanner;

public class GestionEtudiants {
	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Etudiant> etudiants = new HashMap<String, Etudiant>();

	public static int afficheMenu() {
		System.out.println("******* Gestion des étudiants ********");

		int selection = 0;
		System.out.println("Selectionner l'opération par num:");
		System.out.println("-------------------------\n");
		System.out.println("1 - Saisir un étudiant");
		System.out.println("2 - Supprimer un étudiants");
		System.out.println("3 - Trouver un étudiant par code");
		System.out.println("4 - Afficher la liste des étudiants");
		System.out.println("5 - Quit");
		selection = sc.nextInt();
		System.out.println("selection=" + selection);
		// sc.close();
		return selection;
	}

	public static void main(String[] args) {

		etudiants.put("123", new Etudiant("123", "Safhi", "Hicham Moad", "Marrakech", "Info", "01/01/2021"));
		etudiants.put("124", new Etudiant("124", "Ben", "Bial", "Fez", "Info", "01/01/2021"));
		etudiants.put("125", new Etudiant("125", "Ben", "Rachid", "Safi", "Info", "01/01/2021"));
		etudiants.put("126", new Etudiant("126", "Zou", "Abdelhay", "Fez", "Info", "01/01/2021"));

		int selection = 0;
		do {
			selection = afficheMenu();

			switch (selection) {
			case 1:
				System.out.println("Saisir les données de l'étudiant");
				System.out.println("Code:");
				String code = sc.next();

				System.out.println("Nom:");
				String nom = sc.next();

				System.out.println("Prenom:");
				String prenom = sc.next();

				System.out.println("Adresse:");
				String adresse = sc.next();

				System.out.println("Classe:");
				String classe = sc.next();

				System.out.println("DateNaissance:");
				String dateNaissance = sc.next();

				Etudiant e = new Etudiant(code, nom, prenom, adresse, classe, dateNaissance);
				etudiants.put(e.getCode(), e);
				System.out.println("Etudiant est ajouté avec succès!");

				break;
				
			case 2:
				System.out.println("******Supprimer un étudiant *********");
				System.out.println("Code de l'étudiant a supprimer:");
				String asupprumer = sc.next();
				if (etudiants.containsKey(asupprumer)) {
					etudiants.remove(asupprumer);
					System.out.println("Etudiant supprimé!");
				} else {
					System.err.println("Etudiant n'existe pas!");
				}

				break;
				
			case 3:
				System.out.println("******** Trouver un étudiant par code ******");
				System.out.println("Code étudiant:");
				String atrouver = sc.next();
				if (etudiants.containsKey(atrouver)) {
					System.out.println(etudiants.get(atrouver).toString());
				} else {
					System.err.println("Etudiant n'existe pas!");
				}
				break;
				
			case 4:
				System.out.println("********** Liste des étudiants ***********");
				for (String codeEtudiant : etudiants.keySet()) {
					System.out.println(etudiants.get(codeEtudiant).toString());
				}
				break;

			case 5:
				System.out.println("Quitting the app...");
				System.exit(0);
				break;
			default:
				System.err.println("Choix doit etre entre 1-5!!");
			}
		} while (true);

	}

}
