import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day08_1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input/inputDay8.txt");
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        List<Integer> checkPosition = new ArrayList<>();
        int position = 0;
        int accValue = 0;

        while (!checkPosition.contains(position)) {
            String[] splitted = input.get(position).split(" ");
            checkPosition.add(position);
            System.out.println(position);
            if (splitted[0].equals("acc")) {
                accValue += Integer.parseInt(splitted[1]);
                position++;

            } else if (splitted[0].equals("jmp")) {
                position += Integer.parseInt(splitted[1]);


            } else if (splitted[0].equals("nop")) {
                position++;
            }
        }
        System.out.println(accValue);
    }
}
