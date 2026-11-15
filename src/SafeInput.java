
import java.util.Scanner;

public class SafeInput {

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {

        String input;

        do {
            System.out.print(prompt);
            input = pipe.nextLine();

            if (!input.matches(regEx)) {
                System.out.println("Invalid input. Please try again.");
            }

        } while (!input.matches(regEx));

        return input;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {

        int number = 0;
        boolean valid = false;

        do {
            System.out.print(prompt);

            try {
                number = Integer.parseInt(pipe.nextLine());

                if (number >= low && number <= high) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between "
                            + low + " and " + high + ".");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }

        } while (!valid);

        return number;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {

        String input;

        do {
            System.out.print(prompt);
            input = pipe.nextLine().trim();

            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Please enter Y or N.");
            }

        } while (true);
    }
}

