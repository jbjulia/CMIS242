package discussions.cmis242;

// Import modules

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author jbjulia
 */
public class BirthdayBugs {

    // Main method
    public static void main(String[] args) {

        // Variable declaration and initialization
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1; // Month is zero indexed
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        int currentYear = cal.get(Calendar.YEAR);
        int birthdayMonth = 0;
        int birthdayDay = 0;
        int birthdayYear = 0;
        int monthDiff = 0;
        int yearDiff = 0;

        // Prompts for user input
        System.out.println("What month were you born on? (Example: 11)");

        // Error handling for user input
        try {
            Scanner month = new Scanner(System.in);
            birthdayMonth = month.nextInt();
            if (birthdayMonth > 12 || birthdayMonth < 1) {
                System.out.println("You have not entered a valid month.");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("You have not entered a valid number.");
            System.exit(0);
        }

        // Prompts for user input
        System.out.println("What day of the month were you born? (Example: 10)");

        // Error handling for user input
        try {
            Scanner day = new Scanner(System.in);
            birthdayDay = day.nextInt();
            if (birthdayDay > 31 || birthdayDay < 1) {
                System.out.println("You have not entered a valid day.");
                System.exit(0);
            } else if (birthdayMonth == 2 && birthdayDay > 28) {
                System.out.println("There are not 31 days in this month.");
                System.exit(0);
            } else if (birthdayMonth == 4 && birthdayDay == 31) {
                System.out.println("There are not 31 days in this month.");
                System.exit(0);
            } else if (birthdayMonth == 6 && birthdayDay == 31) {
                System.out.println("There are not 31 days in this month.");
                System.exit(0);
            } else if (birthdayMonth == 9 && birthdayDay == 31) {
                System.out.println("There are not 31 days in this month.");
                System.exit(0);
            } else if (birthdayMonth == 11 && birthdayDay == 31) {
                System.out.println("There are not 31 days in this month.");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("You have not entered a valid number.");
            System.exit(0);
        }

        // Prompts for user input
        System.out.println("What year were you born? (Example: 1993)");

        // Error handling for user input
        try {
            Scanner year = new Scanner(System.in);
            birthdayYear = year.nextInt();
            if (birthdayYear > currentYear) {
                System.out.println("You must be a time traveller!");
                System.out.println("I can't determine how old you are.");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("You have not entered a valid number.");
            System.exit(0);
        }

        // Extremely complicated calculations...
        monthDiff = (currentMonth - birthdayMonth);
        yearDiff = (currentYear - birthdayYear);

        // Print results for different cases
        if (currentMonth == birthdayMonth && currentDay == birthdayDay) {
            System.out.println("It looks like your birthday is today! HAPPY BIRTHDAY!");
            System.out.println("You are " + yearDiff + " years old!");
            System.exit(0);
        } else if (monthDiff < 0) {
            System.out.println("You are " + (yearDiff - 1) + " years old!");
            System.exit(0);
        } else if (monthDiff > 0) {
            System.out.println("You are " + yearDiff + " years old!");
            System.exit(0);
        }
    }
}
