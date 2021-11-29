package collections.revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsSet {
	public static void main(String[] args) {

		// ********* Déclaration d'une collection Set *********
		Set<String> l1 = new HashSet<String>();
		Set<String> l2 = new HashSet<>();
		Set l3 = new HashSet<>();
		Set l4 = new HashSet<String>();

		/*
		 * Les memes déclarations sont autorisé si on remplace le nom de l'interface Set
		 * par le nom de la class HashSet par exemple: HashSet<String> l1 = new
		 * HashSet<String>();
		 */

		/*
		 * Cette déclaration est non autorisé, car Set est une interface et elle n'a pas
		 * de définition de constructeur! Set<String> l5 = new Set<String>();
		 */

		// ********* méthodes de Set *********

		// *************** La classe HashSet ******************
		HashSet<String> setOfStrings = new HashSet<String>();

		setOfStrings.add("element2");
		setOfStrings.add("element1");
		setOfStrings.add("element3");
		setOfStrings.add("element5");
		setOfStrings.add("element0");

		// La classe HashSet n'a pas d'implémentation pour la méthode get
		// ce n'pas possible d'utiliser les indices pour accéder au élements.

		// ArrayList accept les doublons:
		System.out.println("HashSet size: " + setOfStrings.size());
		setOfStrings.add("element0");
		System.out.println("HashSet size après insertion element0: " + setOfStrings.size());
		/*
		 * La taille ne change pas, donc HashSet n'accepte pas les doublons!
		 */

		// accept des valeurs null:
		setOfStrings.add(null);
		setOfStrings.add(null);
		System.out.println("avec des éléments null: " + setOfStrings.size());

		setOfStrings.remove("element0");

		System.out.println("après suppression d'elements0: " + setOfStrings.size());

	}

}
