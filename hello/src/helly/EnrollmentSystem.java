package helly;

import java.util.Scanner;

public class EnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[2];  // Array of objects (manage multiple students)

        // 2D array example: grades table [students][subjects]
        double[][] gradesTable = new double[2][5];

        // Nested FOR loops to input grades
        for (int i = 0; i < gradesTable.length; i++) {  // Outer FOR
            System.out.print("Enter name for student " + (i+1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.println("Enter 5 grades for " + name + ":");
            for (int j = 0; j < gradesTable[i].length; j++) {  // Nested FOR
                System.out.print("Grade " + (j+1) + ": ");
                gradesTable[i][j] = scanner.nextDouble();
            }
            scanner.nextLine();

            students[i] = new Student(name, age, gradesTable[i]);  // Create object
            students[i].displayInfo();  // Polymorphism (inherited method)
            students[i].displayGrades();

            // Check enrollment
            boolean eligible = students[i].canEnroll();  // Interface method
            System.out.println(eligible ? "Enrollment approved!" : "Enrollment denied!" + "\n");
        }

        // Nested FOR-EACH to display summary table
        System.out.println("Grades Summary:");
        for (double[] row : gradesTable) {
            for (double grade : row) {
                System.out.printf("%.1f ", grade);
            }
            System.out.println();
        }

        scanner.close();
    }

    // Additional method with parameters (requirement: 3+ methods)
    public static void printWelcome(String appName) {
        System.out.println("Welcome to " + appName + " System!");
    }
}
