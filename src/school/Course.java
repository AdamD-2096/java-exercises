package school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Course {
    private static String key = "myKEY";
    private String teacher;
    private String course;
    private HashMap<Integer, Student> students = new HashMap<>();

    public Course(String theTeacher, String theClass, HashMap<Integer, Student> roster){
        this.teacher = theTeacher;
        this.course = theClass;
        this.students = roster;
    }

    public Course(String theTeacher, String theClass){
        this.teacher = theTeacher;
        this.course = theClass;
    }


    public String getTeacher(){
        return teacher;
    }
    private void setTeacher(String aTeacher){
        this.teacher = aTeacher;
    }


    public String getCourse() {
        return course;
    }
    private void setCourse(String aCourse){
        this.course = aCourse;
    }


    public HashMap getStudents(){
        return students;
    }
    protected void addStudent(Student student){
        Integer id = student.getStudentID();
        students.put(id, student);
    }
    protected void removeStudent(Student student){
        Integer id = student.getStudentID();
        students.remove(id);
    }

    public static void login(ArrayList<Student> students, ArrayList<Course> courses, String keyPass){
        if (keyPass.equals(key)){
            System.out.println("login success");
            Scanner in = new Scanner(System.in);
            while (true){
                System.out.println("options:\n2:edit roster\n1:edit course details\n0:back");
                int choice = in.nextInt();
                if(choice == 2){
                    editRoster(students, courses);
                }else if (choice == 1){
                    editCourse(courses);
                }else{
                    break;
                }
            }
        }
    }
    private static void editCourse(ArrayList<Course> courses){
        Scanner in = new Scanner(System.in);
        Course obj;
        while (true) {
            System.out.println("Continue:\n1:yes\n0:no");
            int choice = in.nextInt();
            if (choice == 1) {
                for (Course course : courses) {
                    System.out.println("Course Name: " + course.getCourse() + "\nTeachers Name: " + course.getTeacher() + "\nEdit:\n1:yes\n0:no");
                    int choice2 = in.nextInt();
                    if (choice2 == 1) {
                        obj = course;
                        while (true) {
                            System.out.println("options: \n2: set course name\n1: assign Teacher \n0: back");

                            int choice3 = in.nextInt();

                            if (choice3 == 2) {
                                System.out.println("new Course name:");
                                in.nextLine();
                                String aCourse = in.nextLine();
                                obj.setCourse(aCourse);
                            } else if (choice3 == 1) {
                                System.out.println("new Teacher name:");
                                in.nextLine();
                                String aTeacher = in.nextLine();
                                obj.setTeacher(aTeacher);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }else{
                break;
            }
        }
    }
    private static void editRoster(ArrayList<Student> studentz, ArrayList<Course> courses){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Continue:\n1:yes\n0:no");
            int choice = in.nextInt();
            if (choice == 1){
                System.out.println("Select from a list of classes to add or remove students to or from");
                for (Course course : courses) {
                    System.out.println("Course Name: " + course.getCourse() + "\nTeachers Name: " + course.getTeacher() + "\nThis class:\n1:yes\n0:no");
                    int choice2 = in.nextInt();
                    if (choice2 == 1) {
                        while (true) {
                            System.out.println("options: \n3: list current roster\n2: add Students\n1: remove students \n0: back");

                            int choice3 = in.nextInt();

                            if(choice3 == 3) {
                                for (Map.Entry<Integer, Student> idStudent : course.students.entrySet()) {
                                    Student student = idStudent.getValue();
                                    System.out.println("name: " + student.getName() + "\nSID: " + student.getStudentID());
                                }
                            }else if (choice3 == 2) {
                                for (Student student : studentz) {
                                    System.out.println("name: " + student.getName() + "\nSID: " + student.getStudentID() + "\nadd this student: \n1:yes\n2:no");
                                    int choice4 = in.nextInt();
                                    if(choice4 == 1){
                                        course.addStudent(student);
                                    }
                                }
                            } else if (choice3 == 1) {
                                while (true) {
                                    System.out.println("Continue:\n1:yes\n2:no");
                                    int choice4 = in.nextInt();
                                    if(choice4 == 1) {
                                        for (Map.Entry<Integer, Student> idStudent : course.students.entrySet()) {
                                            Student student = idStudent.getValue();
                                            System.out.println("name: " + student.getName() + "\nSID: " + student.getStudentID() + "\nremove this student: \n1:yes\n0:no");
                                            int choice5 = in.nextInt();
                                            if (choice5 == 1) {
                                                course.removeStudent(student);
                                                break;
                                            }
                                        }
                                    }else{
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }else{
                break;
            }
        }
    }
}
