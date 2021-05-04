package readability;

import static java.lang.Math.max;
import static java.lang.String.join;

public class TextStats {
    public static final int NOT_CALCULATED = Integer.MIN_VALUE;
    private final String text;
    private int sentences = NOT_CALCULATED;
    private int words = NOT_CALCULATED;
    private int characters = NOT_CALCULATED;
    private int syllables = NOT_CALCULATED;
    private int polysyllables = NOT_CALCULATED;

    public TextStats(String text) {
        this.text = text;
    }

    public int getSentences() {
        return text.split("[.!?]").length;
    }

    public int getWords() {
        return text.split(" ").length;
    }

    public int getCharacters() {
        return text.replaceAll("\\s", "").length();
    }

    public static int countSyllables(String word) {
        return Math.max(1, word.toLowerCase() //if word has no vowels, max will return 1
        .replaceAll("e$" , "") //"remove" all 'e' at the end of word
        .replaceAll("[aouiey]{2}", "a") //replace all double vowels with 'a'
        .replaceAll("[^aouiey]", "") //remove all non-vowels
        .length());
    }

    int countAllSyllablesInText() {
        int result = 0;
        for (String word: text.split(" ")) {
            result += countSyllables(word);
        }
        return result;
    }

    public static boolean isPolysyllable(String word) {
        return countSyllables(word) > 2;
    }

    int countAllPolysyllableWords() {
        int count = 0;
        for (String word: text.split(" ")) {
            if (isPolysyllable(word)) {
                count++;
            }
        }
        return count;
    }

    public void printStats() {
        System.out.println(String.format(join("%n",
                "The text is: %n%s",
                "Words: %d",
                "Sentences: %d",
                "Characters: %d",
                "Syllables: %d",
                "Polysyllables: %d%n"),
                text, getWords(), getSentences(), getCharacters(), countAllSyllablesInText(), countAllPolysyllableWords()));
    }
}
