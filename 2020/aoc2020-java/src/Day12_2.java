import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day12_2 {
    public static void main(String[] args) throws Exception {
        List<String> input = loadData("src/input/inputDay12.txt");

        int northSouth = 0;
        int eastWest = 0;

        int northSouth2 = 1;
        int eastWest2 = 10;

        for (int i = 0; i < input.size(); i++) {
            char action = input.get(i).charAt(0);
            int number = Integer.parseInt(input.get(i).substring(1));

            switch (action) {
                case 'N':
                    northSouth2 += number;
                    break;
                case 'E':
                    eastWest2 += number;
                    break;
                case 'S':
                    northSouth2 -= number;
                    break;
                case 'W':
                    eastWest2 -= number;
                    break;
                case 'F':
//                    for (int j = 0; j < number; j++) {
//                        northSouth += northSouth2;
//                        eastWest += eastWest2;
//                    }

                    // oder

                    northSouth += (northSouth2 * number);
                    eastWest += (eastWest2 * number);

                    // Waypoint darf nicht geupdated werden!!
//                    northSouth2 += (northSouth2 * number);
//                    eastWest2 += (eastWest2 * number);
                    break;
                case 'L':
                    int[] arrL = changeDirection(action, number, northSouth2, eastWest2);
                    northSouth2 = arrL[0];
                    eastWest2 = arrL[1];
                    break;
                case 'R':
                    int[] arrR = changeDirection(action, number, northSouth2, eastWest2);
                    northSouth2 = arrR[0];
                    eastWest2 = arrR[1];
                    break;
            }

        }


        System.out.println(northSouth);
        System.out.println(eastWest);
        System.out.println( northSouth + eastWest);
    }


    public static int[] changeDirection (char action, int number, int currNorthSouth, int currEastWest) {
        int[] changeDirection = {currNorthSouth, currEastWest};

        if (action == 'L') {
            int num1 = 0;
            switch (number) {
                case 90:
                    num1 = changeDirection[0];
                    changeDirection[0] = changeDirection[1];
                    changeDirection[1] = -num1;
                    break;
                case 180:
                    changeDirection[0] = -changeDirection[0];
                    changeDirection[1] = -changeDirection[1];
                    break;
                case 270:
                    num1 = changeDirection[0];
                    changeDirection[0] = -changeDirection[1];
                    changeDirection[1] = num1;
                    break;
                default:
                    break;
            }
        } else if (action == 'R') {
            int num1 = 0;
            switch (number) {
                case 90:
                    num1 = changeDirection[0];
                    changeDirection[0] = -changeDirection[1];
                    changeDirection[1] = num1;
                    break;
                case 180:
                    changeDirection[0] = -changeDirection[0];
                    changeDirection[1] = -changeDirection[1];
                    break;
                case 270:
                    num1 = changeDirection[0];
                    changeDirection[0] = changeDirection[1];
                    changeDirection[1] = -num1;
                    break;
                default:
                    break;
            }
        }
        return changeDirection;
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
