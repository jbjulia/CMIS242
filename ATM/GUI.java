package projects.cmis242.atm;

// Import modules

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

/**
 * @author jbjulia
 */
public class GUI extends JFrame {

    // Private DecimalFormat instance
    private static final DecimalFormat DEC = new DecimalFormat("#0.00");
    // Variable declaration
    private double withdrawalAmount;
    private double depositAmount;
    private double transferAmount;
    private double balanceAmount;
    private String accountName;
    // Constructors
    private Account checkingAccount = new Account(0);
    private Account savingsAccount = new Account(0);
    // Configure GUI
    private GUI() {
        // Set title
        super("ATM");

        // Main window
        JPanel main = new JPanel();

        // Set layout
        main.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Create components
        JButton btnWithdraw = new JButton("Withdraw");
        JButton btnDeposit = new JButton("Deposit");
        JButton btnTransfer = new JButton("Transfer");
        JButton btnBalance = new JButton("Balance");
        JRadioButton radChecking = new JRadioButton("Checking");
        JRadioButton radSavings = new JRadioButton("Savings");
        JTextField txtAmount = new JTextField("");

        // Configure components
        c.fill = GridBagConstraints.HORIZONTAL;

        c.insets = new Insets(0, 0, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        main.add(btnWithdraw, c);

        c.insets = new Insets(0, 5, 5, 0);
        c.gridx = 1;
        c.gridy = 0;
        main.add(btnDeposit, c);

        c.insets = new Insets(5, 0, 5, 5);
        c.gridx = 0;
        c.gridy = 2;
        main.add(btnTransfer, c);

        c.insets = new Insets(5, 5, 5, 0);
        c.gridx = 1;
        c.gridy = 2;
        main.add(btnBalance, c);

        c.insets = new Insets(5, 0, 5, 5);
        c.gridx = 0;
        c.gridy = 3;
        main.add(radChecking, c);

        c.insets = new Insets(5, 5, 5, 0);
        c.gridx = 1;
        c.gridy = 3;
        main.add(radSavings, c);

        c.insets = new Insets(5, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        main.add(txtAmount, c);

        add(main);

        // Create ButtonGroup for JRadioButtons
        ButtonGroup group = new ButtonGroup();
        group.add(radChecking);
        group.add(radSavings);

        // Set radChecking to default
        radChecking.doClick();

        // btnWithdraw_Click
        btnWithdraw.addActionListener((ActionEvent e) -> {
            try {
                withdrawalAmount = Double.parseDouble(txtAmount.getText());
                // Check for correct increment ammount
                if (withdrawalAmount % 20 == 0) {
                    try {
                        if (radChecking.isSelected()) {
                            checkingAccount.withdraw(withdrawalAmount);
                            accountName = "Checking account.";
                        } else {
                            savingsAccount.withdraw(withdrawalAmount);
                            accountName = "Savings account.";
                        }
                        JOptionPane.showMessageDialog(null, "You have withdrawn \n\n$" + DEC.format(withdrawalAmount) + "\n\nfrom your " + accountName);
                    } catch (InsufficientFunds c1) {
                        JOptionPane.showMessageDialog(null, "There are insufficient funds in this account!\n\nAmount Overdrawn : $-" + DEC.format(c1.overdrawn()));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error!\n\nPlease enter an amount in increments of $20.00.");
                }
            } catch (NumberFormatException d) {
                JOptionPane.showMessageDialog(null, "Error!\n\nPlease enter a valid number.");
            }
        });

        // btnDeposit_Click
        btnDeposit.addActionListener((ActionEvent e) -> {
            try {
                depositAmount = Double.parseDouble(txtAmount.getText());
                if (radChecking.isSelected()) {
                    checkingAccount.deposit(depositAmount);
                    accountName = "Checking account.";
                } else {
                    savingsAccount.deposit(depositAmount);
                    accountName = "Savings account.";
                }
                JOptionPane.showMessageDialog(null, "You have deposited \n\n$" + DEC.format(depositAmount) + "\n\nto your " + accountName);
            } catch (NumberFormatException d) {
                JOptionPane.showMessageDialog(null, "Error!\n\nPlease enter a valid number.");
            }
        });

        // btnTransfer_Click
        btnTransfer.addActionListener((ActionEvent e) -> {
            try {
                transferAmount = Double.parseDouble(txtAmount.getText());
                if (radChecking.isSelected()) {
                    checkingAccount.transferTo(savingsAccount, checkingAccount, transferAmount);
                    accountName = "Savings account.";
                } else {
                    savingsAccount.transferTo(checkingAccount, savingsAccount, transferAmount);
                    accountName = "Checking account.";
                }
                JOptionPane.showMessageDialog(null, "You have transferred \n\n$" + DEC.format(transferAmount) + "\n\nto your " + accountName);
            } catch (NumberFormatException d) {
                JOptionPane.showMessageDialog(null, "Error!\n\nPlease enter a valid number.");
            } catch (InsufficientFunds c12) {
                JOptionPane.showMessageDialog(null, "There are insufficient funds in this account!\n\nAmount Overdrawn : $-" + DEC.format(c12.overdrawn()));
            }
        });

        // btnBalance_Click
        btnBalance.addActionListener((ActionEvent e) -> {
            if (radChecking.isSelected()) {
                balanceAmount = checkingAccount.balance();
                accountName = "Checking account.";
            } else {
                balanceAmount = savingsAccount.balance();
                accountName = "Savings account.";
            }
            JOptionPane.showMessageDialog(null, "You have a balance of \n\n$" + DEC.format(balanceAmount) + "\n\nin your " + accountName);
        });

        // Configure window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
