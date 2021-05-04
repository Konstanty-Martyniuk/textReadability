package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
        String text = "";

        while (scanner.hasNext()) {
            text = scanner.nextLine();
        }
        scanner.close();

        TextStats textStats = new TextStats(text);
        UI ui = new UI(textStats);
        ui.printUI();
    }
}
