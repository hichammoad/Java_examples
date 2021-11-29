package collections.revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionsMap {
	public static void main(String[] args) {

		// ********* Déclaration d'une collection Set *********
		Map<String, String> m1 = new HashMap<String, String>();
		Map<String, String> m2 = new HashMap<>();
		Map m3 = new HashMap<>();
		Map m4 = new HashMap<String, String>();

		/*
		 * Les memes déclarations sont autorisé si on remplace le nom de l'interface Map
		 * par le nom de la class HashMap par exemple: HashMap<String> l1 = new
		 * HashMap<String>();
		 */

		/*
		 * Cette déclaration est non autorisé, car Map est une interface et elle n'a pas
		 * de définition de constructeur! Map<String,String> m1 = new
		 * Map<String,String>();
		 */

		// ********* méthodes de Map *********

		// *************** La classe HashSet ******************
		HashMap<String, String> map1 = new HashMap<String, String>();

		map1.put("22", "element2");
		map1.put("11", "element1");
		map1.put("33", "element3");
		map1.put("44", "element4");

		System.out.println("Hashmap size: " + map1.size());
		map1.put("44", "element4");

		System.out.println("HashSet size après insertion element4: " + map1.size());
		/*
		 * La taille ne change pas, donc HashSet n'accepte pas les doublons pour les
		 * clés!
		 */
		// accept des valeurs null:
		map1.put(null, null);
		map1.put(null, null);
		System.out.println("avec des key et values null: " + map1.size());

		/// liste des clés::
		System.out.println("keySet = " + map1.keySet());
		System.out.println("values = " + map1.values());

		// parcourir la map:
//		for(String key : map1.keySet()) {
//			System.out.println(key+" "+map1.get(key));
//		}

		// ************************* Treemap **********************************
		TreeMap<String, String> map2 = new TreeMap<String, String>();

		map2.put("22", "element2");
		map2.put("11", "element1");
		map2.put("33", "element3");
		map2.put("44", "element4");

		System.out.println("Treemap size: " + map2.size());
		map2.put("44", "element4");

		System.out.println("Treemap size après insertion element0: " + map2.size());
		/*
		 * La taille ne change pas, donc HashSet n'accepte pas les doublons pour les
		 * clés!
		 */
		// n'accept des clés null:
		// map2.put(null,"ok");
		// aucun prob avec valeurs null:
		map2.put("ok", null);
		map2.put("ok2", null);
		System.out.println("avec des key et values null: " + map2.size());

		/// liste des clés::
		System.out.println("keySet = " + map2.keySet());
		System.out.println("values = " + map2.values());

		// parcourir la map:
//		for(String key : map1.keySet()) {
//			System.out.println(key+" "+map1.get(key));
//		}

		// TreeMap trie les valeurs!

	}

}
