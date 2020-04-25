package discussions.cmis242;

// Import modules

import java.util.*;

/**
 * @author jbjulia
 */
public class Toaster {

    // Variable declaration and initialization
    private boolean isOn;
    private int powerLevel;
    private String breakfastSelection;
    private String strYourPlate = "";
    private List<String> yourPlate = new ArrayList<>();
    private List<String> breakfast = Arrays.asList("toast", "bagel", "english muffin", "waffle", "nothing else");

    // Main method
    public static void main(String[] args) {
        Toaster breakfast = new Toaster();
        breakfast.makeBreakfast();
    }

    // Default constructor
    public void toaster() {
        isOn = true;
        powerLevel = 4;
        breakfastSelection = "toast";
    }

    // Takes user input (breakfast selections) and cooks it to desired level
    public String makeBreakfast() {
        // Set boolean value
        isOn = true;

        // Loop while user selects breakfast options
        do {
            // Flushes terminal to clear screen for output
            System.out.print("\033[H\033[2J");
            System.out.flush();
            try {
                System.out.println("What would you like for breakfast?\n");
                if (!yourPlate.isEmpty()) {
                    System.out.print("So far you have selected " + yourPlate);
                    System.out.println("\n");
                }
                System.out.print(breakfast);
                System.out.println("\n");
                Scanner choice = new Scanner(System.in);
                breakfastSelection = choice.nextLine();
                if (!breakfast.contains(breakfastSelection)) {
                    System.out.println("Sorry, that's not on the menu.\n");
                } else if (breakfastSelection.matches("nothing else")) {
                    System.out.println("Okay, I'll turn the toaster off.\n");
                    isOn = false;
                } else {
                    yourPlate.add(breakfastSelection);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!\n");
                System.exit(0);
            }
        } while (isOn);

        // Checks for empty plate
        if (yourPlate.isEmpty()) {
            strYourPlate = "Oh, I guess you were not very hungry then.\n";
            System.exit(0);
        }

        // Flushes terminal to clear screen for output
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Prompts user to specify Toaster powerLevel
        try {
            System.out.println("Please specify how you would liked it cooked [1 - 10]\n");
            Scanner input = new Scanner(System.in);
            powerLevel = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!\n");
            System.exit(0);
        }

        // Constructs strYourPlate
        if (powerLevel >= 1 && powerLevel < 4) {
            strYourPlate = "Yum! You've made " + yourPlate + " for breakfast, and cooked it lightly at level " + powerLevel + "!\n";
        } else if (powerLevel >= 4 && powerLevel < 7) {
            strYourPlate = "Yum! You've made " + yourPlate + " for breakfast, and cooked it perfectly at level " + powerLevel + "!\n";
        } else if (powerLevel >= 7 && powerLevel <= 10) {
            strYourPlate = "Yum! You've made " + yourPlate + " for breakfast, and cooked it well at level " + powerLevel + "!\n";
        } else {
            strYourPlate = "Uh-Oh! You burnt your " + yourPlate + " at level " + powerLevel + "!\n";
        }

        // Flushes terminal to clear screen for output
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Prints strYourPlate
        System.out.print(strYourPlate);
        return strYourPlate;
    }
}
