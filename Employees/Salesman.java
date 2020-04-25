package projects.cmis242.employees;

/**
 * @author jbjulia
 */
public class Salesman extends Employee {

    // Variable declaration
    private double annualSales;

    // Default constructor
    public Salesman() {
    }

    // Specified constructor
    public Salesman(int year, String name, String type, double monthlySalary, double annualSales) {
        super(year, name, type, monthlySalary);
        this.annualSales = annualSales;
    }

    // Calculates annual salaray of Salesman Employee
    @Override
    public double annualSalary() {
        double commission = this.annualSales * .02;

        // Set commission to max amount if commission is greater than $20000
        if (commission > 20000) {
            commission = 20000;
        }

        return super.annualSalary() + commission;
    }

    // toString method that overrides Employee toString method
    @Override
    public String toString() {
        return super.toString() + "\nAnnual Sales: \t\t"
                + DEC.format(this.annualSales);
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

    public double getAnnualSales() {
        return annualSales;
    }

    public void setAnnualSales(double annualSales) {
        this.annualSales = annualSales;
    }
}
