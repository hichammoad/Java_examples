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

class wordFreq implements Comparable<wordFreq> {
	String word;
	int frequency;

	public wordFreq(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}

	public String getWord() {
		return word;
	}

	public int compareTo(wordFreq w2) {
		if (frequency > w2.getFrequency()) {
			return -1;
		} else if (frequency < w2.getFrequency()) {
			return 1;
		} else {
			return 0;
		}
	};
}

// using compareTo, sort,..
public class FrequentNonBannedWord4 {

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

		List<wordFreq> wordList = new ArrayList<wordFreq>();
		for (String w : new HashSet<String>(sp_text_list)) {
			wordList.add(new wordFreq(w, Collections.frequency(sp_text_list, w)));
		}

		Collections.sort(wordList);

		System.out.println("Frequent non banned word is: " + wordList.get(0).getWord() + " with frequency = "
				+ wordList.get(0).getFrequency());

	}

}
