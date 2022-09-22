import java.io.File;
import java.util.*;

public class Day16_1 {
    static int invalidCounter = 0;
    static int invalidCounter2 = 0;

    public static void main(String[] args) throws Exception {
        List<String> input = loadData("src/input/inputDay16.txt");

        List<String> rangOfValid = rangeOfValid(input);
        List<Integer> nearbyNumbers = getNearbyNumbers(input);

        for (Integer a: nearbyNumbers) {
            isValid(a, rangOfValid);
        }


        System.out.println(invalidCounter);
        System.out.println(invalidCounter2);
    }

    private static boolean isValid (Integer toCheck, List<String> rangeOfValid) {
        boolean isValid = false;

        for (String b: rangeOfValid) {
            String[] range = b.split("-");
            int min = Integer.parseInt(range[0]);
            int max = Integer.parseInt(range[1]);

            if (toCheck >= min && toCheck <= max) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            invalidCounter += toCheck;
            invalidCounter2++;
        }
        return isValid;
    }


    private static List<String> rangeOfValid (List<String> input) {
        List<String> rangeOfValid = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String[] arrTemp = input.get(i).split(": ");
            String[] range = arrTemp[1].split(" or ");
            for (String a: range) {
                rangeOfValid.add(a);
            }
            if (input.get(i+1).equals("")) {
                break;
            }
        }
        return rangeOfValid;
    }

    private static List<Integer> getNearbyNumbers (List<String> input) {
        List<Integer> nearbyNumbers= new ArrayList<>();

        for (int i = input.indexOf("nearby tickets:") + 1; i < input.size(); i++) {
            String[] numbersAsString = input.get(i).split(",");
            for (String a: numbersAsString) {
                nearbyNumbers.add(Integer.parseInt(a));
            }
        }
        return nearbyNumbers;
    }

    private static List<String> loadData(String file) throws Exception{
        List<String> output = new ArrayList<>();
        File myFile = new File(file);
        Scanner scanner = new Scanner(myFile);
        while (scanner.hasNext()) {
            output.add(scanner.nextLine());
        }
        scanner.close();
        return output;
    }
}
