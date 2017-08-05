package org.launchcode.java.studios;

import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        System.out.println("Area of a circle!!");
        Scanner in = new Scanner(System.in);
        System.out.println("what is the circles radius?");
        Double radius = in.nextDouble();
        Double area = (Math.PI * Math.pow(radius, 2));
        System.out.println("the area of your circle is ".concat(String.valueOf(area)));
    }
}
