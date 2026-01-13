package helly;

public abstract class Person {
    private String name;
    private int age;

    // Default constructor
    public Person() {}

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters (encapsulation)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Abstract method
    public abstract void displayInfo();
}
