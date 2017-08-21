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
            System.out.println("options:\n5: get students level\n4: get students name, id, gpa, credits\n3: get student name, id\n2: get student name, gpa\n1: get student name, credits\n0: back");

            int choice = in.nextInt();

            if (choice == 5){
                Student obj = null;
                for (Student student : students) {
                    String name = student.getName();
                    System.out.println(name + "\n1:yes\n0:no");
                    int IO = in.nextInt();
                    if (IO == 1) {
                        obj = student;
                        break;
                    }
                }
                System.out.println(obj.getGradeLevel());
            } else if (choice == 4) {
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
                System.out.println("options:\n4: add grade\n3: set name\n2: set gpa\n1: set credits\n0: back");

                int choice = in.nextInt();

                if (choice == 4){
                    System.out.println("number of credits earned:");
                    int cred = in.nextInt();
                    System.out.println("Grade (from 0.0 to 4.0)");
                    double gp = in.nextDouble();
                    obj.addGrade(cred, gp);
                } else if (choice == 3) {
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
    public void addGrade(int courseCredits, double grade) {
        // Update the appropriate fields: numberOfCredits, gpa
        double gpaSum = this.GPA * this.credits;
        gpaSum = gpaSum + (grade * courseCredits);
        this.credits = this.credits + courseCredits;
        this.GPA = gpaSum / this.credits;
    }

    public String getGradeLevel() {
        // Determine the grade level of the student based on numberOfCredits
        if (this.credits < 30){
            return "freshman";
        }else if(this.credits < 60){
            return "sophomore";
        }else if(this.credits < 90){
            return "junior";
        }else{
            return "senior";
        }

    }
    @Override
    public String toString(){
        String id = String.valueOf(this.studentID);
        String cr = String.valueOf(this.credits);
        String gp = String.valueOf(this.GPA);

        return "\nname: " + this.name +
                "\nid: " + id +
                "\ntotal credits: " + cr +
                "\nGrade point Average: " + gp +
                "\n";
    }
    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.getClass() != getClass()) {
            return false;
        }

        Student tS = (Student) o;
        return (tS.getStudentID() == getStudentID() && tS.getName().equals(getName()) && tS.getcredits() == getcredits() && tS.getGPA() == getGPA());
    }
    @Override
    public int hashCode() {
        int hash = 67;
        hash = hash * this.studentID;
        hash = (int) (hash * this.GPA);
        hash = hash + this.name.length();
        hash = (int) (hash * 1000 * (this.credits * this.GPA - this.name.length() + 13));
        hash = (hash * (hash + hash)) / (this.credits + this.studentID);
        return hash;
    }
}