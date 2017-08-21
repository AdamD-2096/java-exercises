package school;

import java.util.ArrayList;
import java.util.Scanner;

public class School {
    private static Student john = new Student("john", 1, 30, 2.9);
    private static Student mary = new Student("mary");
    private static Student kaitlyn = new Student("kaitlyn");
    private static Student ray = new Student("ray");
    private static Student fredrick = new Student("fredrick", 5, 12, 3.45);
    private static Course science = new Course("Douglis", "Science");
    private static Course math = new Course("Fisher", "Math");
    private static Course history = new Course("Hathaway", "History");
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        students.add(john);
        students.add(mary);
        students.add(kaitlyn);
        students.add(ray);
        students.add(fredrick);
        courses.add(science);
        courses.add(math);
        courses.add(history);

        Scanner in = new Scanner(System.in);
        /* - - - TEST PRINTS - - -
        System.out.println(math.toString());
        System.out.println(math.equals(math));
        System.out.println(math.equals(history));
        System.out.println(math.equals(ray));
        System.out.println(ray.equals(ray));
        System.out.println(ray.equals(mary));
        for (Student obj : students){
           System.out.println(obj.hashCode() + "\n");
        }*/
        while (true) {
            System.out.println("options:\n2: get student names\n1: login to get more access\n0: quit");

            int choice = in.nextInt();

            if(choice == 2) {
                getAllNames();
            }else if (choice == 1){
                in.nextLine();
                System.out.println("password:\n");
                String key = in.nextLine();
                login(key);
            }else{
                break;
            }
        }
    }

    private static void getAllNames(){
        for (Student student : students){
            String name = student.getName();
            System.out.println("---------\n" + name + "\n---------");
        }
    }

    private static void login(String key){
        Scanner in = new Scanner(System.in);
        if (key.equals("myKEY")){
            while (true) {
                System.out.println("options:\n3: add student\n2: login to student database\n1: login to course database\n0: back");
                int choice = in.nextInt();
                if (choice == 3){
                    addStudent();
                }else if (choice == 2){
                    Student.login(students, key);
                }else if (choice == 1){
                    Course.login(students, courses, key);
                }else{
                    break;
                }
            }
        }else{
            System.out.println("sorry access denied");
        }
    }

    private static void addStudent(){
        Scanner in = new Scanner(System.in);
        String name = "student";
        while (true) {
            System.out.println("options:\n3: new student(name)\n2: prep-school grad(name, id)\n1: transfer student(name, id, credits, gpa)\n0: back");

            int choice = in.nextInt();
            if (choice != 0) {
                in.nextLine();
                System.out.println("Name of Student:");
                name = in.nextLine();
            }
            if(choice == 3) {
                Student student = new Student(name);
                students.add(student);
            }else if (choice == 2){
                System.out.println("Students ID:");
                int id = in.nextInt();
                Student student = new Student(name, id);
                students.add(student);
            }else if (choice == 1){
                System.out.println("Students ID:");
                int id = in.nextInt();
                System.out.println("Students Credits:");
                int credits = in.nextInt();
                System.out.println("Students GPA:");
                double gpa = in.nextDouble();
                Student student = new Student(name, id, credits, gpa);
                students.add(student);
            }else{
                break;
            }
        }
    }
}
