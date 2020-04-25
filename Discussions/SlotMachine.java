package discussions.cmis242;

// Import modules

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author jbjulia
 */
public class SlotMachine {

    // Main method
    public static void main(String[] args) {

        // Check for valid number of args
        if (args.length == 0) {
            System.out.println("To use this slot machine, you must enter 3 unique numbers in the command line.");
            System.out.println("\tExample: java SlotMachine 1 5 7\n");
            System.exit(0);
        } else if (args.length > 0 && args.length < 3) {
            System.out.println("To use this slot machine, you must enter 3 unique numbers in the command line.");
            System.out.println("\tExample: java SlotMachine 2 4 9\n");
            System.exit(0);
        }

        // Variable declaration
        int low = 1;
        int high = 10;
        ArrayList<String> slotMachine = new ArrayList<>(Arrays.asList());
        ArrayList<String> userRoll = new ArrayList<>(Arrays.asList(args[0], args[1], args[2]));

        // Flushes terminal to clear screen for output
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Append array with random numbers
        do {
            Random r = new Random();
            int x = r.nextInt(high - low) + low;
            String value = Integer.toString(x);
            // Check for duplicates
            if (!slotMachine.contains(value)) {
                slotMachine.add(value);
            }
        } while (slotMachine.size() < 3);

        // Print slot machine numbers
        System.out.println("\tSlot Machine: " + slotMachine);

        // Check for matches
        userRoll.retainAll(slotMachine);
        int size = userRoll.size();

        // Print results
        switch (size) {
            case 0:
                System.out.println("\nOof. No matches.");
                break;
            case 1:
                System.out.println("\tYou rolled:   " + userRoll);
                System.out.println("\nYou only matched 1 number, try again.");
                break;
            case 2:
                System.out.println("\tYou rolled:   " + userRoll);
                System.out.println("\nOooh, so close. You matched 2 numbers.");
                break;
            case 3:
                System.out.println("\tYou rolled:   " + userRoll);
                System.out.println("\nWINNER WINNER, CHICKEN DINNER!");
                break;
            default:
                break;
        }
    }
}
