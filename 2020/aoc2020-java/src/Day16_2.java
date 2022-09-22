import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day16_2 {
    static List<String> nameOfRange = new ArrayList<>();
    static List<String> numbersOfRange = new ArrayList<>();
    static List<Integer> rangeNumbersSplitted = new ArrayList<>();

    static List<String> validRows = new ArrayList<>();
    static int invalidCounter = 0;


    public static void main(String[] args) throws Exception {
        List<String> input = loadData("src/input/inputDay16.txt");

        getRangeOfValid(input);
        onlyGetValidRows(input);


        System.out.println(invalidCounter);
        



    }

    public static void onlyGetValidRows (List<String> input) {
        List<String> nearbyTickets = new ArrayList<>();
        for (int i = input.indexOf("nearby tickets:") + 1; i < input.size(); i++) {
            nearbyTickets.add(input.get(i));
        }

        for (int i = 0; i < nearbyTickets.size(); i++) {
            if (!checkIfValid(nearbyTickets.get(i))) {
                nearbyTickets.remove(i);
                i--;
                continue;
            }
        }
        for (String a: nearbyTickets) {
            validRows.add(a);
        }

    }


    private static boolean checkIfValid (String numbersOfRow) {
        boolean isValid = false;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersOfRow.length(); i++) {
            String[] numbersAsString = numbersOfRow.split(",");
            for (String a: numbersAsString) {
                numbers.add(Integer.parseInt(a));
            }
        }

        for (Integer a: numbers) {
            for (int i = 0; i < rangeNumbersSplitted.size(); i += 2) {
                int min = rangeNumbersSplitted.get(i);
                int max = rangeNumbersSplitted.get(i + 1);

                if (a >= min && a <= max) {
                    isValid = true;
                    break;
                }
            }
        }
        if (!isValid) {
            invalidCounter++;
        }
        numbers.clear();
        return isValid;
    }

    private static void getAllNumbers () {
        for (String a: numbersOfRange) {
            String[] b = a.split(" or ");
            for (String c: b) {
                String[] arr = c.split("-");
                for (String d: arr) {
                    rangeNumbersSplitted.add(Integer.parseInt(d));
                }
            }
        }

    }

    private static void getRangeOfValid (List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            String[] arr = input.get(i).split(": ");
            nameOfRange.add(arr[0]);
            numbersOfRange.add(arr[1]);
            if (input.get(i+1).equals("")) {
                break;
            }
        }
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

