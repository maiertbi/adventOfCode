import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day09_1 {
    public static void main(String[] args) throws Exception {
        List<Long> input = loadData("src/input/inputDay9.txt");
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
                System.out.println(input.get(start));
                break;
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
