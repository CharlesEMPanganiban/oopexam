// Student Grade Management System - ALL REQUIREMENTS IN ONE FILE
abstract class Person {  // Abstract class
    private String name;  // Encapsulation
    private int age;
    
    // Constructors (overloading)
    public Person() { this.name = "Unknown"; this.setAge(0); }
    public Person(String name, int age) { this.name = name; this.setAge(age); }
    
    // Getters/Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    // Abstract method
    public abstract void displayInfo();
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

// Interface
interface Enrollable {
    void enroll();
}

// Enum
enum GradeLevel { FIRST_YEAR, SECOND_YEAR, THIRD_YEAR }

// Student class - Inheritance + implements interface
class Student extends Person implements Enrollable {
    private int id;
    private double[] grades;
    private GradeLevel yearLevel;
    
    // Constructor overloading
    public Student(int id, String name, GradeLevel yearLevel) {
        super(name, 20);  // super() call
        this.id = id;
        this.yearLevel = yearLevel;
        this.grades = new double[]{85, 90, 88};  // Sample grades
    }
    
    // Polymorphism - override
    @Override
    public void displayInfo() {
        System.out.println("ID: " + id + ", " + getName() + ", " + yearLevel);
    }
    
    @Override
    public void enroll() {
        System.out.println(getName() + " enrolled!");
    }
    
    // Method that returns value
    public double getAverage() {
        double total = 0;
        for (double g : grades) total += g;  // FOR-EACH
        return total / grades.length;
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        // ARRAY OF OBJECTS
        Student[] students = {
            new Student(1, "Alice", GradeLevel.FIRST_YEAR),
            new Student(2, "Bob", GradeLevel.SECOND_YEAR),
            new Student(3, "Charlie", GradeLevel.THIRD_YEAR)
        };
        
        // FOR-EACH loop
        System.out.println("=== ALL STUDENTS (FOR-EACH) ===");
        for (Student s : students) {
            s.displayInfo();
        }
        
        // 2D ARRAY + NESTED LOOPS
        String[][] seating = {{"S1","S2","S3"}, {"S4","S5","S6"}};
        System.out.println("\n=== SEATING CHART (2D Array) ===");
        for (int i = 0; i < seating.length; i++) {  // Nested FOR
            for (int j = 0; j < seating[i].length; j++) {
                System.out.print(seating[i][j] + "\t");
            }
            System.out.println();
        }
        
        // FOR loop with BREAK
        System.out.println("\n=== SEARCH STUDENT (FOR + BREAK) ===");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter ID to find (1-3): ");
        int target = sc.nextInt();
        
        search: for (int i = 0; i < students.length; i++) {
            if (students[i].id == target) {
                students[i].displayInfo();
                break search;  // BREAK
            }
        }
        
        // Method call with parameters
        System.out.println("\nAlice average: " + students[0].getAverage());
    }
}
