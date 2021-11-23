package collections.wordcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
* Étant donné un text (String), et un tableau de chaînes des mots à ignorer 
* [bannis] (String[]), renvoie le mot le plus fréquent qui n'est pas ignoré. 
*/

// using lists :
public class FrequentNonBannedWord2 {

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

		String frequentWord = null;
		int maxFrequency = 0;

		// to get unique words; no need to iterate over the same word multiple times :)
		HashSet<String> sp_text_unique = new HashSet<String>(sp_text_list);

		for (String s : sp_text_unique) {

			int currentFrequency = Collections.frequency(sp_text_list, s);

			if (currentFrequency > maxFrequency) {
				maxFrequency = currentFrequency;
				frequentWord = s;
			}
		}

		System.out.println("Frequent non banned word is: " + frequentWord + " with frequency = " + maxFrequency);
	}

}
