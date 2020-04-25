package discussions.cmis242;

// Import modules

import java.awt.*;
import java.util.Scanner;

/**
 * @author jbjulia
 */
public class Microwave {

    // Define member variables
    private String food;
    private boolean isOn;
    private int timer;
    // Constructor
    Microwave() {
        food = "";
        timer = 0;
        System.out.println("Your microwave is ready to heat up your food.\n");
    }

    // Main method
    public static void main(String[] args) {
        Microwave microwave = new Microwave();
        microwave.pickFood();
        microwave.setTimer();
        microwave.start();
    }

    // Ask user for food choice
    public void pickFood() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What would you like to cook in the microwave?\n");
        food = scanner.nextLine();
    } // End method

    // Ask user for time in minutes
    public void setTimer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter timer (in minutes): \n");

        // Convert time (minutes) to seconds
        timer = (Integer.parseInt(scanner.nextLine()) * 60);
    } // End method

    // Start timer
    public void start() {
        // Flushes terminal to clear screen for output
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Print to screen and initiate microwave
        System.out.println("Starting to cook food...\n");
        isOn = true;

        // Loop while microwave is on (isOn = true)
        do {
            for (int i = timer; i > 0; i--) {
                System.out.println(i);
                try { // Sleep for one second
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } // End for loop (timer)
            }
            for (int i = 0; i < 6; i++) {
                Toolkit.getDefaultToolkit().beep();
            } // End for loop (microwave beep)
            isOn = false;
        } while (isOn); // End do loop

        // Print results
        System.out.print("DING DING DING!\nYour " + food + " is ready!\n");
    }
}
