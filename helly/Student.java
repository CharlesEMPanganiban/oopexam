package helly;

interface Enrollable {
    boolean canEnroll();  // Abstraction via interface
    double computeAverage(double[] grades);
}

public class Student extends Person implements Enrollable {
    private double[] grades;  // 1D array for input grades

    // Default constructor (overloading)
    public Student() {
        super();
        this.grades = new double[5];  // Fixed 5 subjects for simplicity
    }

    // Parameterized constructor (overloading)
    public Student(String name, int age, double[] grades) {
        super(name, age);
        this.grades = grades;
    }

    // Object method
    @Override
    public void displayInfo() {
        System.out.println("Student: " + getName() + ", Age: " + getAge());
    }

    // computeAverage method (returns value)
    @Override
    public double computeAverage(double[] grades) {
        double sum = 0;
        // FOR loop with break example (stop if invalid grade)
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Invalid grade at index " + i + ", stopping computation.");
                break;
            }
            sum += grades[i];
        }
        return sum / grades.length;
    }

    // canEnroll method (with parameters)
    @Override
    public boolean canEnroll() {
        double avg = computeAverage(grades);
        EnrollmentStatus status = (avg >= 75)? EnrollmentStatus.PASSED : EnrollmentStatus.FAILED;
        System.out.println("Average: " + avg);
        if (status == EnrollmentStatus.PASSED) {
            System.out.println("🎉 You PASSED! You can enroll.");
        } else {
            System.out.println("❌ FAILED. Cannot enroll.");
        }
        return status == EnrollmentStatus.PASSED;
    }

    // Setter for grades
    public void setGrades(double[] grades) { this.grades = grades; }

    // Method to display grades using FOR-EACH
    public void displayGrades() {
        System.out.print("Grades: ");
        for (double grade : grades) {  // FOR-EACH loop
            System.out.print(grade + " ");
        }
        System.out.println();
    }
}
