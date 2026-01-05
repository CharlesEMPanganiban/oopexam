package hello;
public class StudentDemo {
    public static void main(String[] args) {
        // ARRAY OF OBJECTS
        Student[] students = new Student[3];
        students[0] = new Student(1, "ALICE", GradeLevel.FIRST_YEAR);
        students[1] = new Student(2, "BOB", GradeLevel.SECOND_YEAR);
        students[2] = new Student(3, "CHARLIE", GradeLevel.THIRD_YEAR);
        
        // 1. FOR-EACH LOOP
        System.out.println("=== 1. FOR-EACH LOOP ===");
        for (Student s : students) {
            s.displayInfo();
        }
        
        // 2. 2D ARRAY + NESTED LOOPS
        System.out.println("\n=== 2. 2D ARRAY + NESTED LOOPS ===");
        String[][] seating = {{"S1","S2","S3"}, {"S4","S5","S6"}};
        for (int i = 0; i < seating.length; i++) {
            for (int j = 0; j < seating[i].length; j++) {
                System.out.print(seating[i][j] + "  ");
            }
            System.out.println();
        }
        
        // 3. FOR LOOP + BREAK
        System.out.println("\n=== 3. FOR LOOP + BREAK ===");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter ID (1,2,3): ");
        int target = sc.nextInt();
        
        for (int i = 0; i < students.length; i++) {
            if (students[i].id == target) {
                students[i].displayInfo();
                break;
            }
        }
        
        // 🔥 4. GRADE COMPUTATION - NEW!
        System.out.println("\n=== 4. GRADE COMPUTATION (Method Return) ===");
        System.out.println("ALICE average: " + students[0].getAverage());
        System.out.println("ALL students' grades:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i+1) + " average: " + students[i].getAverage());
        }
        
        sc.close();
    }
}
