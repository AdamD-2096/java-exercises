package school;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private static ArrayList<Integer> IDz = new ArrayList<>();
    private String name;
    private final int studentID;
    private double GPA;
    private int credits;

    public Student(String studentName, int studentId,
                   int numberOfCredits, double gpa) {
        this.name = studentName;
        while (this.IDz.contains(studentId)){
            studentId++;
        }
        this.studentID = studentId;
        this.IDz.add(studentId);
        this.credits = numberOfCredits;
        this.GPA = gpa;
    }

    public Student(String studentName, int studentId) {

        this(studentName, studentId, 0, 0);
    }

    public Student(String studentName) {
        this(studentName, 1);
    }

    public String getName() {
        return name;
    }

    private void setName(String aName) {
        name = aName;
    }


    protected int getStudentID() {
        return studentID;
    }


    protected double getGPA() {
        return GPA;
    }

    private void setGPA(double aGPA) {
        GPA = aGPA;
    }


    protected int getcredits() {
        return credits;
    }

    private void setcredits(int acredits) {
        credits = acredits;
    }

    public static void login(ArrayList<Student> students, String key) {
        if (key.equals("myKEY")) {
            System.out.println("access granted");
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("options:\n2: get student data\n1: change student data\n0: back");

                int choice = in.nextInt();

                if (choice == 2) {
                    getData(students);
                } else if (choice == 1) {
                    setData(students);
                } else {
                    break;
                }
            }
        } else {
            System.out.println("sorry access denied");
        }

    }

    private static void getData(ArrayList<Student> students) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("options:\n4: get students name, id, gpa, credits\n3: get student name, id\n2: get student name, gpa\n1: get student name, credits\n0: back");

            int choice = in.nextInt();

            if (choice == 4) {
                for (Student student : students) {
                    String name = student.getName();
                    int id = student.getStudentID();
                    double gpa = student.getGPA();
                    int credits = student.getcredits();
                    System.out.println("Name:" + name + "\nID:" + id + "\nGPA:" + gpa + "\nCredits:" + credits + "\n\n-----------------------------\n");
                }
            } else if (choice == 3) {
                for (Student student : students) {
                    String name = student.getName();
                    int id = student.getStudentID();
                    System.out.println("Name:" + name + "\nID:" + id + "\n\n-----------------------------\n");
                }
            } else if (choice == 2) {
                for (Student student : students) {
                    String name = student.getName();
                    double gpa = student.getGPA();
                    System.out.println("Name:" + name + "\nGPA:" + gpa + "\n\n-----------------------------\n");
                }
            } else if (choice == 1) {
                for (Student student : students) {
                    String name = student.getName();
                    int credits = student.getcredits();
                    System.out.println("Name:" + name + "\nCredits:" + credits + "\n\n-----------------------------\n");
                }
            } else {
                break;
            }
        }
    }

    private static void setData(ArrayList<Student> students) {
        Scanner in = new Scanner(System.in);
        Student obj = null;
        while (true) {
            System.out.println("Continue? \n1:yes\n0:no");
            int back = in.nextInt();
            if (back == 0) {
                break;
            }
            System.out.println("pick a student to edit");
            for (Student student : students) {
                String name = student.getName();
                System.out.println(name + "\n1:yes\n0:no");
                int IO = in.nextInt();
                if (IO == 1) {
                    obj = student;
                    break;
                }
            }
            while (true) {
                System.out.println("options:\n3: set name\n2: set gpa\n1: set credits\n0: back");

                int choice = in.nextInt();

                if (choice == 3) {
                    in.nextLine();
                    System.out.println("set Name to: ");
                    String name = in.nextLine();
                    obj.setName(name);
                    System.out.println("Name set to: " + name);
                } else if (choice == 2) {
                    System.out.println("set GPA to: ");
                    double gpa = in.nextDouble();
                    obj.setGPA(gpa);
                    System.out.println("GPA set to: " + gpa);
                } else if (choice == 1) {
                    System.out.println("set Credits to: ");
                    int credits = in.nextInt();
                    obj.setcredits(credits);
                    System.out.println("Credits set to: " + credits);
                } else {
                    String name = obj.getName();
                    int id = obj.getStudentID();
                    double gpa = obj.getGPA();
                    int credits = obj.getcredits();
                    System.out.println("Name:" + name + "\nID:" + id + "\nGPA:" + gpa + "\nCredits:" + credits);

                    break;
                }
            }
        }
    }
}
