import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day10_1 {
    public static void main(String[] args) throws Exception {
        List<Integer> input = loadData("src/input/inputDay10.txt");

        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 1;

        Collections.sort(input);
        int currentNumber = 0;

        for (int i = 0; i < input.size(); i++) {
            switch (input.get(i) - currentNumber) {
                case 1:
                    counter1++;
                    currentNumber = input.get(i);
                    break;
                case 2:
                    counter2++;
                    currentNumber = input.get(i);
                    break;
                case 3:
                    counter3++;
                    currentNumber = input.get(i);
                    break;
                default:
                    System.out.println("End of the line " + Collections.max(input));
                    System.out.println();
                    break;
            }
        }
        System.out.println(counter1 * counter3);
    }




    private static List<Integer> loadData(String file) throws Exception{
        List<Integer> output = new ArrayList<>();
        File myFile = new File(file);
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            output.add(scanner.nextInt());
        }
        scanner.close();
        return output;
    }
}
