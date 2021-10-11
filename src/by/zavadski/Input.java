package by.zavadski;

import by.zavadski.enums.MessagesEnum;
import java.util.Scanner;

public class Input {

    public static void showInputHelp(String fieldName, String pattern) {
        System.out.printf("~~~~~~~~~~~~~~~~%S~~~~~~~~~~~~~~~~%n"
                + "Enter value for field '%s'(%s)%n", fieldName, fieldName, pattern);
    }

    public static void showAvailableOptionsForInput(String[] list) {
        System.out.printf("Available options:%n");
        for (int i = 0; i < list.length; i++) {
            System.out.printf("-%s(%d)%n", list[i], i + 1);
        }
    }

    public static String readString(String pattern) {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext(pattern)) {
            Switches.getMessage(2, pattern);
            sc.next();
        }
        return sc.next().toLowerCase();
    }

    public static int readPositiveInt() {
        int currentInt;
        do {
            currentInt = readKeyInt();
        } while (currentInt <= 0);
        return currentInt;
    }

    public static double readDouble() {
        double numberDouble;
        do {
            numberDouble = readKeyDouble();
        } while (numberDouble <= 0);
        return numberDouble;
    }

    public static int readKeyInt() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            printMessage(MessagesEnum.NOT_A_NUMBER.getText(), " ");
            sc.next();
        }
        return sc.nextInt();
    }

    public static double readKeyDouble() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            Switches.getMessage(3, "");
            sc.next();
        }
        return sc.nextDouble();
    }

    public static void printMessage(String messageText, String details) {
        System.out.printf("%s%nDetails: %s%n", messageText, details);
    }

    public static void printMessage(String messageText) {
        System.out.printf("%s%n", messageText);
    }


}
