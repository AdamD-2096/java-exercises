package exercises;

import java.util.Scanner;

public class RecArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("what is the rectangles length?");
        Double length = in.nextDouble();
        Scanner in2 = new Scanner(System.in);
        System.out.println("height?");
        Double height = in2.nextDouble();
        System.out.println("the area of your rectangle is");
        System.out.println(height * length);
    }
}
