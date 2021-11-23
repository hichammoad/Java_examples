package collections.wordcount;

/*
* Étant donné un text (String), et un tableau de chaînes des mots à ignorer 
* [bannis] (String[]), renvoie le mot le plus fréquent qui n'est pas ignoré. 
*/

// without collections:
public class FrequentNonBannedWord1 {

	public static void main(String[] args) {
		String text = "About Java : Oracle a annoncé la disponibilité générale de Java 17, la huitième version de fonctionnalité et la prochaine version de support à long terme, qui font partie de la cadence de publication semestrielle de Java.";

		String[] banned = { "est", "un", "de", "la", "le", "les", "en", "par" };

		// remove punctuation form text:
		text = text.toLowerCase().replaceAll("[,\\.]+", " ");
		String[] sp_text = text.split("\\s+"); // space, tab, newline, ..

		String frequentWord = null;
		int maxFrequency = 0;

		for (int i = 0; i < sp_text.length; i++) {

			// check if word is banned:
			boolean is_banned = false;
			for (String b : banned) {
				if (b.equals(sp_text[i])) {
					is_banned = true;
					break;
				}
			}

			if (is_banned)
				continue;

			// count word occurences:
			int currentFrequency = 0;
			for (int j = i; j < sp_text.length; j++) {
				if (sp_text[i].equals(sp_text[j])) {
					currentFrequency++;
				}
			}

			if (currentFrequency > maxFrequency) {
				maxFrequency = currentFrequency;
				frequentWord = sp_text[i];
			}

		}

		System.out.println("Frequent non banned word is: " + frequentWord + " with frequency = " + maxFrequency);
	}

}
