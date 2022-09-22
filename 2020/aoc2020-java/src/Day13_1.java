import java.io.File;
import java.util.*;

public class Day13_1 {
    public static void main(String[] args) throws Exception {
        List<String> input = loadData("src/input/inputDay13.txt");
        int arrivalTime = Integer.parseInt(input.get(0));
        List<String> busAll = Arrays.asList(input.get(1).split(","));

        Set<String> busAsString = new HashSet<>(busAll);
        busAsString.remove("x");

        List<Integer> busID = new ArrayList<>();
        for (String a : busAsString) {
            busID.add(Integer.parseInt(a));
        }
        Collections.sort(busID);
        List<Integer> bus = new ArrayList<>(busID);
        System.out.println(busID);

        int i = 0;
        for (Integer a: bus) {
            while (a < arrivalTime) {
                bus.set(i, bus.get(i) + busID.get(i));
                a += busID.get(i);
            }
           i++;
        }


        for (int j = 0; j < bus.size(); j++) {
            bus.set(j, bus.get(j) - arrivalTime);
        }
        int solution = Collections.min(bus) * busID.get(bus.indexOf(Collections.min(bus)));
        System.out.println(solution);

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
