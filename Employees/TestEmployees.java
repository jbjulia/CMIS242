package projects.cmis242.employees;

// Import modules

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author jbjulia
 */
public class TestEmployees {

    // Private DecimalFormat instance
    private static final DecimalFormat DEC = new DecimalFormat("$0.00");
    // Declaration and initialization of Arrays
    private final ArrayList<Employee> employees2014 = new ArrayList<>();
    private final ArrayList<Employee> employees2015 = new ArrayList<>();

    // Main method
    public static void main(String[] args) {
        // Check for valid arguments
        switch (args.length) {
            case 0: {
                // Get current directory and set file path
                String filePath = System.getProperty("user.dir") + "/data.csv";
                //String filePath = "/home/jbjulia/NetBeansProjects/Project1/src/main/java/projects/cmis242/employees/data.csv";
                TestEmployees test = new TestEmployees();
                test.readFile(filePath);
                test.displayReport();
                break;
            }
            case 1: {
                // Take args[0] and set file path
                String filePath = args[0];
                TestEmployees test = new TestEmployees();
                test.readFile(filePath);
                test.displayReport();
                break;
            }
            default:
                System.out.println("Please include the file path of the '.csv' file you wish to use, or place the 'data.csv' file in this directory.");
                System.exit(0);
        }
    }

    public void readFile(String filePath) {
        // Attempts to read in file and store data into Arrays
        try {
            // Initialize Scanner
            Scanner fileReader = new Scanner(new FileInputStream(new File(filePath)));
            // Loop until EOF
            while (fileReader.hasNext()) {
                // Skip column headers
                fileReader.nextLine();
                // Sorts by year
                int year = fileReader.nextInt();

                // Populates ArrayList with year 2014 data
                if (year == 2014) {
                    String type = fileReader.next();
                    String name = fileReader.next();
                    double monthlySalary = fileReader.nextDouble();

                    // Switch case for sorting employee types
                    switch (type) {
                        case "Salesman": {
                            double annualSalesOrStockPrice = fileReader.nextDouble();
                            employees2014.add(new Salesman(year, name, type, monthlySalary, annualSalesOrStockPrice));
                            break;
                        }

                        case "Executive": {
                            double annualSalesOrStockPrice = fileReader.nextDouble();
                            employees2014.add(new Executive(year, name, type, monthlySalary, annualSalesOrStockPrice));
                            break;
                        }
                        default:
                            employees2014.add(new Employee(year, name, type, monthlySalary));
                            break;
                    }
                    // Populates ArrayList with year 2015 data
                } else if (year == 2015) {
                    String type = fileReader.next();
                    String name = fileReader.next();
                    double monthlySalary = fileReader.nextDouble();

                    // Switch case for sorting employee types
                    switch (type) {
                        case "Salesman": {
                            double annualSalesOrStockPrice = fileReader.nextDouble();
                            employees2015.add(new Salesman(year, name, type, monthlySalary, annualSalesOrStockPrice));
                            break;
                        }
                        case "Executive": {
                            double annualSalesOrStockPrice = fileReader.nextDouble();
                            employees2015.add(new Executive(year, name, type, monthlySalary, annualSalesOrStockPrice));
                            break;
                        }
                        default:
                            employees2015.add(new Employee(year, name, type, monthlySalary));
                            break;
                    }
                }
            }
            // Multi-catch statement for IO exceptions that prints and exits
        } catch (IOException | NullPointerException | NoSuchElementException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    // Print EOY Reports for years 2014 and 2015
    public void displayReport() {
        // Initialize variables
        double avgSalary2014 = 0;
        double avgSalary2015 = 0;

        // Print EOY Report for 2014
        System.out.println("\n2014 EOY Report:");
        avgSalary2014 = employees2014.stream().map((var employee) -> {
            System.out.println(employee.toString());
            return employee;
        }).map((employee) -> employee.annualSalary()).reduce(avgSalary2014, (accumulator, _item) -> accumulator + _item);

        // Print average salaray for 2014
        avgSalary2014 = avgSalary2014 / employees2014.size();
        System.out.println("\nThe average salary for 2014 was " + DEC.format(avgSalary2014) + ".");
        System.out.println("\n\033[3m- End of Report -\033[0m\n");

        // Print EOY report for 2015
        System.out.println("\n2015 EOY Report:");
        avgSalary2015 = employees2015.stream().map((employee) -> {
            System.out.println(employee.toString());
            return employee;
        }).map((employee) -> employee.annualSalary()).reduce(avgSalary2015, (accumulator, _item) -> accumulator + _item);

        // Print average salaray for 2015
        avgSalary2015 = avgSalary2015 / employees2015.size();
        System.out.println("\nThe average salary for 2015 was " + DEC.format(avgSalary2015) + ".");
        System.out.println("\n\033[3m- End of Report -\033[0m\n");
    }
}
