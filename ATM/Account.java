package projects.cmis242.atm;

/**
 * @author jbjulia
 */
class Account {

    private static int count;
    // Variable declaration
    private double accountBalance;

    // Create object
    Account(double accBalance) {
        this.accountBalance = accBalance;
    }

    // Method to withdraw funds
    void withdraw(double amount) throws InsufficientFunds {
        if (count >= 4) {
            double serviceCharge = 1.50;
            amount += serviceCharge;
        }
        if (this.accountBalance >= amount) {
            this.accountBalance -= amount;
            count++;
        } else {
            double overdrawn = amount - this.accountBalance;
            throw new InsufficientFunds(overdrawn);
        }
    }

    // Method to deposit funds
    void deposit(double amount) {
        this.accountBalance += amount;
    }

    // Method to transfer funds
    void transferTo(Account from, Account to, double amount) throws InsufficientFunds {
        if (from.accountBalance >= amount) {
            from.accountBalance -= amount;
            to.accountBalance += amount;
        } else {
            double overdrawn = amount - from.accountBalance;
            throw new InsufficientFunds(overdrawn);
        }
    }

    // Returns current account balance
    double balance() {
        return accountBalance;
    }
}
