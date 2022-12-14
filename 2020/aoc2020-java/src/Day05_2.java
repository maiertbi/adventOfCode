import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Day05_2 {
    public static void main(String[] args) {
        Set<Integer> seatTaken = new TreeSet<>();
        try {
            File myFile = new File("src/input/inputDay5.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                String pass = scanner.nextLine();
                int minR = 0;
                int maxR = 127;
                int minC = 0;
                int maxC = 7;
                for (int i = 0; i < pass.length(); i++) {
                    if(pass.charAt(i) == 'F'){
                        maxR = maxR - (maxR - minR)/2 - 1;
                    }else if (pass.charAt(i) == 'B'){
                        minR = minR + (maxR - minR)/2 + 1;
                    }else if (pass.charAt(i) == 'L'){
                        maxC = maxC - (maxC - minC)/2 - 1;
                    }else if (pass.charAt(i) == 'R'){
                        minC = minC + (maxC - minC)/2 + 1;
                    }
                }
                seatTaken.add((minR*8)+minC);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        Iterator<Integer> i = seatTaken.iterator();

        while(i.hasNext()) {
            int currentSeat = i.next();
            if(seatTaken.contains(currentSeat+2) && !seatTaken.contains(currentSeat+1)){
                System.out.println(currentSeat+1);
                return;
            }
        }
    }
}
