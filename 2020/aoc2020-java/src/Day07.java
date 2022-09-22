import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;



public class Day07 {
    public static List<String> getAllBagsThatContains(List<Day07_Helper> currentBags, String name) {
        List<String> names = new ArrayList<>();
        for(Day07_Helper b : currentBags) {
            if(b.containsBag(name)) {
                names.add(b.getName());
            }
        }
        return names;
    }

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input/inputDay7.txt"));

            List<Day07_Helper> allBags = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                allBags.add(new Day07_Helper(line));
            }

            Set<String> names = new HashSet<>();
            names.add("shiny gold");
            int numOfNames = 0;
            while(names.size() != numOfNames) {
                numOfNames = names.size();
                Set<String> newNames = new HashSet<>();
                for(String name : names) {
                    newNames.addAll(getAllBagsThatContains(allBags, name));
                }
                names.addAll(newNames);
            }

            System.out.println(numOfNames);

            for (Day07_Helper b : allBags) {
                if (b.getName().equals("shiny gold")) {
                    System.out.println(b.containsNumberOfBags(allBags));
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
