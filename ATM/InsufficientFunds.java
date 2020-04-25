package projects.cmis242.atm;

/**
 * @author jbjulia
 */
public class InsufficientFunds extends Exception {

    // Variable declaration
    private final double AMOUNT;

    // Amount needed for account transaction
    InsufficientFunds(double amount) {
        this.AMOUNT = amount;
    }

    // Returns amount overdrawn
    double overdrawn() {
        return AMOUNT;
    }
}
