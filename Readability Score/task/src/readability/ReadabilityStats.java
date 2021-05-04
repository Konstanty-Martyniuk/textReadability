package readability;

import java.util.function.ToDoubleFunction;

import static java.lang.Math.*;

public class ReadabilityStats {

    //Statistic formulas
    public static double getARI(TextStats text) {
        return 4.71 * text.getCharacters() / text.getWords()
                + 0.5 * text.getWords() / text.getSentences() - 21.43;
    }

    public static double getFK(TextStats text) {
        return 0.39 * text.getWords() / text.getSentences()
                + 11.8 * text.countAllSyllablesInText() / text.getWords() - 15.59;
    }

    public static double getSMOG(TextStats text) {
        return 1.043 * sqrt(text.countAllPolysyllableWords() * 30. / text.getSentences()) + 3.1291;
    }

    public static double getCL(TextStats text) {
        double l = 100. * text.getCharacters() / text.getWords();
        double s = 100. * text.getSentences() / text.getWords();
        return 0.0588 * l - 0.296 * s - 15.8;
    }


    static int calculateAge(double score) {
        final int level = min(14, max(1, (int) ceil(score))) - 1;
        return new int[]{6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24, 25}[level];
    }

    public static void printResult(double score) {
        System.out.printf("%.2f", score);
        System.out.println(" (about " + ReadabilityStats.calculateAge(score) + "-year-olds).");
    }

//    String getScoreAndAge(final TextStats text) {
//        final double score = String.applyAsDouble(text);
//        return String.format("%s: %.2f (about %d year olds).%n", fullName, score, calculateAge(score));
//    }
//
//    int getAge(final TextStats text) {
//        return calculateAge(formula.applyAsDouble(text));
//    }
}