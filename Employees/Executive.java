package projects.cmis242.employees;

/**
 * @author jbjulia
 */
public class Executive extends Employee {

    // Variable declaration
    private double currentStockPrice;

    // Default constructor
    public Executive() {
    }

    // Specified constructor
    public Executive(int year, String name, String type, double monthlySalary, double currentStockPrice) {
        super(year, name, type, monthlySalary);
        this.currentStockPrice = currentStockPrice;
    }

    // Calculates annual salary of Executive Employee
    @Override
    public double annualSalary() {
        double bonus = 0;

        // Set bonus to max amount if stock price greater than $50
        if (this.currentStockPrice > 50) {
            bonus = 30000;
        }

        return super.annualSalary() + bonus;
    }

    // toString method that overrides Employee toString method
    @Override
    public String toString() {
        return super.toString() + "\nCurrent Stock Price: \t"
                + DEC.format(this.currentStockPrice);
    }

    // Getter methods
    @Override
    public int getYear() {
        return super.getYear();
    }

    // Setter methods
    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public double getMonthlySalary() {
        return super.getMonthlySalary();
    }

    @Override
    public void setMonthlySalary(double monthlySalary) {
        super.setMonthlySalary(monthlySalary);
    }

    public double getCurrentStockPrice() {
        return currentStockPrice;
    }

    public void setCurrentStockPrice(double currentStockPrice) {
        this.currentStockPrice = currentStockPrice;
    }
}
