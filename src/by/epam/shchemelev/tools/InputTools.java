package by.epam.shchemelev.tools;

import java.util.Scanner;

public class InputTools {
    public static int inputIntegerNumberInRange(int rangeFrom, int rangeTo){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String value = scanner.nextLine();
            if (isIntegerNumberInRange(value, rangeFrom, rangeTo)){
                return Integer.parseInt(value);
            } else {
                System.out.println("The number entered in the wrong format or does not match the desired range of numbers, please try again");
            }
        }
    }

    public static float inputFloatNumber(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String value = scanner.nextLine();
            if (isFloatNumber(value)){
                return Float.parseFloat(value);
            } else {
                System.out.println("The number is entered in the wrong format, please try again");
            }
        }
    }

    private static boolean isFloatNumber(String number) {
        return number.matches("\\d+(\\.\\d{1,2})?");
    }

    public static boolean isIntegerNumberInRange(String number, int rangeFrom, int rangeTo){
        return number.matches("\\d+") && Integer.parseInt(number) >= rangeFrom && Integer.parseInt(number) <= rangeTo;
    }
}
