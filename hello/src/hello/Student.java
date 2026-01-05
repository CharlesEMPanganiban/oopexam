package hello;

abstract class Person {
    protected String name;  // Changed to protected, private doesn't work had to change
    private int age;
    
    public Person() { this.name = "Unknown"; this.age = 0; }
    public Person(String name, int age) { this.name = name; this.age = age; }
    
    public String getName() { return name; }
    public abstract void displayInfo();
}

interface Enrollable { void enroll(); }

enum GradeLevel { FIRST_YEAR, SECOND_YEAR, THIRD_YEAR }

class Student extends Person implements Enrollable {
    int id;  // Made public for simplicity
    double[] grades;
    GradeLevel yearLevel;
    
    public Student(int id, String name, GradeLevel yearLevel) {
        super(name, 20);
        this.id = id;
        this.name = name;  // Set name directly
        this.yearLevel = yearLevel;
        this.grades = new double[]{85, 90, 88};
    }
    
    public void displayInfo() {
        System.out.println("FOUND → ID: " + id + ", " + name + ", " + yearLevel);
    }
    
    public double getAverage() {
        double total = 0;
        for (double g : grades) total += g;
        return total / 3;
    }
    
    public void enroll() {
        System.out.println(name + " enrolled!");
    }
}
