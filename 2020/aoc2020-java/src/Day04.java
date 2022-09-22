import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class Day04 {
    public static void main(String[] args) {
        File myFile = new File("src/input/inputDay4.txt");
        HashSet<String> required = new HashSet<>(Arrays.asList("byr", "iyr","eyr","hgt","hcl","ecl","pid"));
        HashSet<String> passport = new HashSet<> ();
        HashSet<String> passport2 = new HashSet<>();
        int valid1 = 0;
        int valid2 = 0;

        try {
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNext()) {
                String[] lines = scanner.nextLine().split(" ");

                if( lines[0].length() != 0) {
                    for (String part : lines) {
                        String[] keyVal = part.split(":");
                        passport.add(keyVal[0]);
                        passport2.add(part);

                    }
                } else { // falls lines[i] leer ist, also leerzeile
                    valid1 += valid(required, passport);
                    valid2 += valid2(required, passport, passport2);
                    passport.clear();
                    passport2.clear();
                }
            }
            valid1 += valid(required, passport);
            valid2 += valid2(required, passport, passport2);
            scanner.close();






        } catch (FileNotFoundException e) {
            System.out.println("Error loading in data");
            e.printStackTrace();
        }
        System.out.println(valid1);
        System.out.println(valid2);
    }

    public static int valid(Set<String> required, HashSet<String> passport){
        for(String field : required){
            if (!passport.contains(field)){
                return 0;
            }
        }
        return 1;
    }

    public static int valid2(Set<String> required, HashSet<String> passport, HashSet<String> passport2){
        for(String field : required){
            if (!passport.contains(field)){
                return 0;
            }
        }
        if (passport2.contains("byr:")
            && passport2.contains("iyr:")
            && passport2.contains("eyr:")
            && passport2.contains("hgt:")
            && passport2.contains("hcl:")
            && passport2.contains("ecl:")
            && passport2.contains("pid:")){
            int isByr = 0;
            int isIyr = 0;
            int isEyr = 0;
            int isHgt = 0;
            int isHcl = 0;
            int isEcl = 0;
            int isPid = 0;
            int total2 = isByr + isIyr + isEyr + isHgt + isHcl + isEcl + isPid;
            int total = 0;

            for (String text : passport2) {
                if (text.contains("byr:")) {
                    total += checkYear(text, 1920, 2002);
                } else if (text.contains("iyr:")) {
                    total += checkYear(text, 2010, 2020);
                } else if (text.contains("eyr:")) {
                    total += checkYear(text, 2020, 2030);
                } else if (text.contains("hgt:")) {
                    total += checkHeight(text);
                } else if (text.contains("hcl:")) {
                    total += checkHair(text);
                } else if (text.contains("ecl:")) {
                    total += checkEye(text);
                } else if (text.contains("pid:")) {
                    total += checkId(text);
                }
            }

            if (total != 7) {
                return 0;
            }
        }
        return 1;
    }
    private static int checkYear(String text, int min, int max) {
        int numberToCheck = Integer.parseInt(text.substring(4, 8));
        if (min <= numberToCheck && max >= numberToCheck) {
            return 1;
        }
        return 0;
    }
    private static int checkHeight(String text) {
        String unit = text.substring(text.length()-2);
        int numberToCheck = Integer.parseInt(text.substring(4, text.length()-2));
        if (unit.equals("cm")) {
            if (150 <= numberToCheck && 193 >= numberToCheck) {
                return 1;
            }
        } else {
            if (59 <= numberToCheck && 76 >= numberToCheck) {
                return 1;
            }
        }
        return 0;
    }
    private static int checkHair(String text) {
        String colorCode = text.substring(4);
        String colorCode2 = text.substring(5);
        if (colorCode.charAt(0) == '#' && colorCode2.length() == 6) {
            int idkNumber = 0;
            for (char charToCheck : colorCode2.toCharArray()) {
                if ((charToCheck >= 48 && charToCheck <= 57) || (charToCheck >= 97 && charToCheck <= 102)) {
                    idkNumber++;
                }
            }
            if (idkNumber == 6) {
                return 1;
            }
        }
        return 0;
    }
    private static int checkEye(String text) {
        String color = text.substring(4);
        String[] colorPossible = {"amb", "blu", "gry", "grn", "hzl", "oth", "brn"};

        for (String toCheck : colorPossible) {
            int idkNumber = 0;
            if (color.equals(toCheck)) {
                idkNumber++;
            }
            if (idkNumber == 1) {
                return 1;
            }
        }
        return 0;
    }
    private static int checkId(String text) {
        String id = text.substring(4);
        if (id.length() == 9) {
            return 1;
        }
        return 0;
    }

}
