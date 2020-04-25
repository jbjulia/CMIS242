package projects.cmis242.students;

import java.text.DecimalFormat;

/**
 * @author jbjulia
 */
public class Students {

    // Private DecimalFormat instance
    private static final DecimalFormat DEC = new DecimalFormat("#0.00");

    // Variable declaration
    private String name;
    private String major;
    private double credits;
    private double qualityPoints;
    private int gradePoints;
    private double gpa = 4.0;

    /**
     * Constructor for Database object
     *
     * @param name  is equal to student's name
     * @param major is equal to student's major
     */
    Students(String name, String major) {
        this.name = name;
        this.major = major;
        credits = 0;
        qualityPoints = 0;
    }

    /**
     * Calculates student record information
     *
     * @param grade       is equal to student's letter grade before conversion
     * @param creditHours is the number of credit hours for the course
     */
    void courseCompleted(String grade, int creditHours) {
        // Switch statement to swap grade String for int
        switch (grade) {
            case "A":
                gradePoints = 4;
                break;
            case "B":
                gradePoints = 3;
                break;
            case "C":
                gradePoints = 2;
                break;
            case "D":
                gradePoints = 1;
                break;
            case "F":
                gradePoints = 0;
                break;
        }
        // Calculations
        gradePoints = gradePoints * creditHours;
        qualityPoints += gradePoints;
        credits += creditHours;
        gpa = qualityPoints / credits;
    }

    /**
     * Overrides toString method
     *
     * @return Returns a String with student's name, major and GPA
     */
    @Override
    public String toString() {
        return "\nName: \t" + name + "\nMajor: \t" + major + "\nGPA: \t" + DEC.format(gpa);
    }
}
