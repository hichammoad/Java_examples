package collections.revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CollectionsList {
	public static void main(String[] args) {
			
		// ********* Déclaration d'une collection ********* 
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<>();
		List l3 = new ArrayList<>();
		List l4 = new ArrayList<String>();
		
		 /* 
		  * Les memes déclarations sont autorisé si on remplace le nom
		  * de l'interface List par le nom de la class ArrayList
		  * par exemple:  
		  * ArrayList<String> l1 = new ArrayList<String>();
		  */
		
		/* Cette déclaration est non autorisé, car List est une interface
		 * et elle n'a pas de définition de constructeur!
		 * List<String> l5 = new List<String>();
		 */
		
		// ********* méthodes de List ********* 
		
		
		// *************** La classe ArrayList ******************
		ArrayList<String> listOfStrings = new ArrayList<String>();
		
		listOfStrings.add("element2");
		listOfStrings.add("element1");
		listOfStrings.add("element3");
		listOfStrings.add("element5");
		listOfStrings.add("element0");
		
		System.out.println(listOfStrings.get(4));  // element0
		/*
		 * Affiche "element0", car ArrayList ne trie pas les éléments
		 * L'ordre d'accès est l'ordre d'insertion!
		 * 
		 */
		
		// pour trier la liste:
		Collections.sort(listOfStrings);
		
		System.out.println(listOfStrings.get(4));  // element5
		/*
		 * Affiche "element5", car on a trié les éléments
		 * Les chaines de caractères sont triés par ordre alphabétique.
		 * Pour utiliser la méthode "sort" de "Collections" avec une
		 * classe personnalisé (exemple trie des personnes par age), 
		 * la classe doit implémenter l'interface "Comparable", et 
		 * redéfinie la méthode CompareTo!
		 */
		
		
		// ArrayList accept les doublons:
		System.out.println("Arraylist size: "+listOfStrings.size());
		listOfStrings.add("element0");
		System.out.println("Arraylist size après insertion element0: "+listOfStrings.size());
		// accept des valeurs null:
		listOfStrings.add(null);
		listOfStrings.add(null);
		System.out.println("avec des éléments null: "+listOfStrings.size());
		// To DO: Tester la méthode sort après insertion des valeurs null!
		listOfStrings.remove(0);
		listOfStrings.remove("element0");
		
		// *************** La classe Vector et LinkedList ******************
		/*
		 * Pour les opérations de base, et sans utilisation du multithreading,
		 * on peux considérer que le comportement de Vector est identique a celui de LinkedList.
		 * La meme chose pour ces opérations de bases, le comportement de ArrayList
		 * est presque similaire à ArrayList.
		 */
		
		
		
		
	}

}
