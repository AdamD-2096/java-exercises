package exercises.two;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashmap {
    public static void main(String[] args) {

        HashMap<Integer, String> students = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String newStudent;
        Integer newId;

        System.out.println("Enter your students ID(or 0 to finish):");

        // Get student Id and names
        do {

            System.out.print("Student ID: ");
            newId = in.nextInt();
            in.nextLine();
            if (newId > 0) {
                System.out.print("Student name: ");
                newStudent = in.nextLine();
                students.put(newId, newStudent);
            }

        } while(newId > 0);

        // Print class roster
        System.out.println("\nClass roster:");

        for (Map.Entry<Integer, String> student : students.entrySet()) {
            System.out.println(student.getKey() + " (".concat(student.getValue()).concat(")"));
        }
    }
}
