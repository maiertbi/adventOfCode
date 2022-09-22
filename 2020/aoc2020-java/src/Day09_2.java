import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day09_2 {
    public static void main(String[] args) throws Exception {
        List<Long> input = loadData("src/input/inputDay9.txt");
        long number = getWrongNumber(input);

        for (int i = 0; i < input.indexOf(getWrongNumber(input)) - 1; i++) {
            List<Long> allNumbers = new ArrayList<>();
            allNumbers.add(input.get(i));
            long sum = input.get(i);
            for (int j = i + 1; j < input.indexOf(getWrongNumber(input)); j++) {
                sum += input.get(j);
                allNumbers.add(input.get(j));
                if (sum == number) {
                    long value = Collections.min(allNumbers) + Collections.max(allNumbers);
                    System.out.println(value);
                    break;
                }
            }
            allNumbers.clear();
        }
    }

    public static long getWrongNumber (List<Long> input) {
        int start = 25;
        while (true) {
            boolean doesWork = false;
            check:
            {
                for (int i = start - 25; i < start - 1; i++) {
                    for (int j = start - 24; j < start; j++) {
                        if (input.get(i) + input.get(j) == input.get(start)) {
                            doesWork = true;
                            break check;
                        }
                    }
                }
            }
            if (!doesWork) {
                return input.get(start);
            }
            start++;
        }
    }

    private static List<Long> loadData(String file) throws Exception{
        List<Long> output = new ArrayList<>();
        File myFile = new File(file);
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            output.add(scanner.nextLong());
        }
        scanner.close();
        return output;
    }
}
