package readability;

import java.util.Scanner;

public class UI {
    private final TextStats textStats;

    public UI(TextStats text) {
        this.textStats = text;
    }

    void printUI() {
        Scanner scanner = new Scanner(System.in);
        textStats.printStats();
        System.out.println();
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String response = scanner.nextLine();
        System.out.println();

        switch (response) {
            case "ARI":
                System.out.print("Automated Readability Index: ");
                ReadabilityStats.printResult(ReadabilityStats.getARI(textStats));
                break;
            case "FK":
                System.out.print("Flesch–Kincaid readability tests: ");
                ReadabilityStats.printResult(ReadabilityStats.getFK(textStats));
                break;
            case "SMOG":
                System.out.print("Simple Measure of Gobbledygook: ");
                ReadabilityStats.printResult(ReadabilityStats.getSMOG(textStats));
                break;
            case "CL":
                System.out.print("Coleman–Liau index: ");
                ReadabilityStats.printResult(ReadabilityStats.getCL(textStats));
                break;
            case "all":
                double scoreARI = ReadabilityStats.getARI(textStats);
                System.out.print("Automated Readability Index: ");
                ReadabilityStats.printResult(scoreARI);
                double scoreFK = ReadabilityStats.getFK(textStats);
                System.out.print("Flesch–Kincaid readability tests: ");
                ReadabilityStats.printResult(scoreFK);
                double scoreSMOG = ReadabilityStats.getSMOG(textStats);
                System.out.print("Simple Measure of Gobbledygook: ");
                ReadabilityStats.printResult(scoreSMOG);
                double scoreCL = ReadabilityStats.getCL(textStats);
                System.out.print("Coleman–Liau index: ");
                ReadabilityStats.printResult(scoreCL);

                double averageAge = (double) (ReadabilityStats.calculateAge(scoreARI) + ReadabilityStats.calculateAge(scoreFK) +
                        ReadabilityStats.calculateAge(scoreSMOG) + ReadabilityStats.calculateAge(scoreCL)) / 4;
                System.out.printf("\nThis text should be understood in average by %.2f" + "-year-olds.", averageAge);
                break;
        }
    }
}
