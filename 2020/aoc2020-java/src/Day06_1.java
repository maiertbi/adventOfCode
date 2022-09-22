import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day06_1 {
    public static void main(String[] args) {
        Set<Character> groupAnswers = new HashSet<> ();
        int sumCounts = 0;

        try {
            File myFile = new File("src/input/inputDay6.txt");
            Scanner scanner = new Scanner(myFile);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.length() != 0) { // falls es keine Leerzeile ist
                    for (int i = 0; i < line.length(); i++) {
                        groupAnswers.add(line.charAt(i)); // HashSet nützlich, da es keine doppelten Elemente speichert
                    }
                } else {
                    sumCounts += groupAnswers.size();
                    groupAnswers.clear();
                }
            }

            sumCounts += groupAnswers.size();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        System.out.println(sumCounts);
    }

}
