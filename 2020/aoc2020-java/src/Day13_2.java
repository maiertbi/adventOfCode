import java.io.File;
import java.util.*;

public class Day13_2 {
    public static void main(String[] args) throws Exception {
        final List<String> input = loadData("src/input/inputDay13.txt");
        final List<Long> bus = new ArrayList<>();

        for (String id : input.get(1).split(",")) {
            bus.add(id.equals("x") ? -1 : Long.parseLong(id));
        }
        part2(bus);
    }

    private static void part2(List<Long> bus) {
        long lcm = -1, time = -1;
        int index = 0;
        while (true) {
            long id = bus.get(index);
            if (id == -1) {
                index++;
                continue;
            }
            if (lcm == -1) {
                lcm = id;
                time = id - index;
                index++;
                continue;
            }
            if ((time + index) % id == 0) {
                if (++index >= bus.size()) {
                    System.out.println(time);
                    return;
                }
                lcm *= id;
                continue;
            }

            time += lcm;
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
