import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day10_2 {
    public static void main(String[] args) throws Exception {
        List<Integer> input = loadData("src/input/inputDay10.txt");
        Collections.sort(input);

        int end = Collections.max(input);
        long[] sums = new long[end+1];
        sums[0] = 1;

        for (int i = 0; i < input.size(); i++) {
            long x = 0;
               if (input.get(i) >= 3) {
                   x = sums[input.get(i) - 3];
               }
            long y = 0;
                if (input.get(i) >= 2) {
                    y = sums[input.get(i) - 2];
                }
            long z = 0;
                if (input.get(i) >= 1) {
                    z = sums[input.get(i) - 1];
                }

            sums[input.get(i)] = x + y + z;
        }

        System.out.println(sums[sums.length - 1]);
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
