package discussions.cmis242;

/**
 * @author jbjulia
 */
public class ExceptionPropagation {

    // Main method
    public static void main(String[] args) {
        ExceptionPropagation test = new ExceptionPropagation();
        test.firstMethod();

        System.out.println("After exception handling... Goodbye!");
    }

    // Method that contains error
    private void thirdMethod() {
        System.out.println("Hi again, from Method 3!");

        int badMath = 8 / 0; // This divide-by-zero equation will cause an error

        System.out.println(badMath);
    }

    // Method that calls thirdMethod
    private void secondMethod() {
        System.out.println("Hello, from Method 2!");

        thirdMethod();
    }

    // Method that handles exception
    private void firstMethod() {
        try {
            secondMethod();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " <-- Hooray! We caught the exception!");
        }
    }
}
