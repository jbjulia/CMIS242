package projects.cmis242.employees;

// Import modules

import java.text.DecimalFormat;

/**
 * @author jbjulia
 */
public class Employee {

    // Private DecimalFormat instance
    protected static final DecimalFormat DEC = new DecimalFormat("$0.00");

    // Variable declaration
    private int year;
    private String type;
    private String name;
    private double monthlySalary;

    // Default constructor
    public Employee() {
    }

    // Specified constructor
    public Employee(int year, String name, String type, double monthlySalary) {
        this.year = year;
        this.name = name;
        this.type = type;
        this.monthlySalary = monthlySalary;
    }

    // Calculates annual salary
    public double annualSalary() {
        return this.monthlySalary * 12;
    }

    // toString method
    @Override
    public String toString() {
        String output = "\nEmployee Name: \t\t" + this.name
                + "\nEmployee Type: \t\t" + this.type
                + "\nAnnual Salary: \t\t" + DEC.format(this.annualSalary());
        return output;
    }

    // Getter methods
    public int getYear() {
        return year;
    }

    // Setter methods
    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
