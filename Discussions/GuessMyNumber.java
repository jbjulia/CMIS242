package discussions.cmis242;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jbjulia
 */
public class GuessMyNumber {

    // Main method
    public static void main(String[] args) {
        // Variable declaration and initialization
        int randomNum = 0;
        int userNum = 0;
        int userAttempt = 0;

        // Generates a random integer between 1 and 10
        randomNum = ThreadLocalRandom.current().nextInt(1, 11);

        // Flushes terminal to clear screen for output
        System.out.print(
                "\033[H\033[2J");
        System.out.flush();

        System.out.println(
                "I'm thinking of a number between 1 and 10...");
        System.out.println(
                "Try and guess it!");

        // Loop until user guess correct number
        while (userNum != randomNum) {
            try {
                Scanner num = new Scanner(System.in);
                userNum = num.nextInt();
                if (userNum > 10 || userNum < 1) {
                    System.out.println("Try again, this time between 1 and 10.");
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Numbers only, please.");
                System.exit(0);
            }
            // Counts attempts until number is guessed correctly
            System.out.println("Nope! Try again!");
            userAttempt = userAttempt + 1;
        } // End loop

        // Displays the correct number and total attempts that were required
        System.out.println(
                "That's right! My number was " + randomNum + ".");

        if (userAttempt
                > 1) {
            System.out.println("It only took you " + userAttempt + " tries!");
        } else {
            System.out.println("You guessed right on the first try!");
        }
    }
}
