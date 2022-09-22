import java.io.File;
import java.util.*;

public class Day12_1 {
    public static void main(String[] args) throws Exception {
        List<String> input = loadData("src/input/inputDay12.txt");

        int northSouth = 0;
        int eastWest = 0;

        char[] turns = {'N', 'E', 'S', 'W'};
        int currentTurn = 1;

        for (int i = 0; i < input.size(); i++) {
            char action = input.get(i).charAt(0);
            int number = Integer.parseInt(input.get(i).substring(1));

            if (action == 'F') {
                action = turns[currentTurn];
            }
            switch (action) {
                case 'N':
                    northSouth += number;
                    break;
                case 'E':
                    eastWest += number;
                    break;
                case 'S':
                    northSouth -= number;
                    break;
                case 'W':
                    eastWest -= number;
                    break;
                case 'L':
                    currentTurn = changeDirection(action, number, currentTurn);
                    break;
                case 'R':
                    currentTurn = changeDirection(action, number, currentTurn);
                    break;
            }


        }
        System.out.println(northSouth);
        System.out.println(eastWest);

    }

    public static int changeDirection (char direction, int number, int currentTurn) {
        int newDirection = currentTurn;

        if (direction == 'L') {
            switch (number) {
                case 90:
                    newDirection -= 1;
                    break;
                case 180:
                    newDirection -= 2;
                    break;
                case 270:
                    newDirection -= 3;
                    break;
                default:
                    break;
            }
        } else if (direction == 'R') {
            switch (number) {
                case 90:
                    newDirection += 1;
                    break;
                case 180:
                    newDirection += 2;
                    break;
                case 270:
                    newDirection += 3;
                    break;
                default:
                    break;
            }
        }

        if (newDirection < 0) {
            newDirection = 4 + (newDirection);
        } else if (newDirection > 3) {
            newDirection = -1 + (newDirection - 3);
        }

        return newDirection;
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
