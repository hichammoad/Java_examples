package collections.wordcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
* Étant donné un text (String), et un tableau de chaînes des mots à ignorer 
* [bannis] (String[]), renvoie le mot le plus fréquent qui n'est pas ignoré. 
*/

// using hashmap :
public class FrequentNonBannedWord3 {

	public static void main(String[] args) {
		String text = "About Java : Oracle a annoncé la disponibilité générale de Java 17, la huitième version de fonctionnalité et la prochaine version de support à long terme, qui font partie de la cadence de publication semestrielle de Java.";
		String[] banned = { "est", "un", "de", "la", "le", "les", "en", "par" };

		// remove punctuation form text:
		text = text.toLowerCase().replaceAll("[,\\.]+", " ");
		String[] sp_text = text.split("\\s+"); // space, tab, newline, ..

		List<String> bannedList = Arrays.asList(banned);
		// because we can't edit the array if we use only Arrays.asList
		List<String> sp_text_list = new ArrayList<String>(Arrays.asList(sp_text));

		sp_text_list.removeAll(bannedList);
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		// we suppose that the first word is the most frequent:
		String frequentWord = sp_text_list.get(0);
		// add words frequency to the map:
		for (String w : sp_text_list) {
			int currentFrequency = Collections.frequency(sp_text_list, w);
			hashMap.put(w, currentFrequency);
			if (currentFrequency >= hashMap.get(frequentWord)) {
				frequentWord = w;
			}
		}

		System.out.println(
				"Frequent non banned word is: " + frequentWord + " with frequency = " + hashMap.get(frequentWord));
	}

}
