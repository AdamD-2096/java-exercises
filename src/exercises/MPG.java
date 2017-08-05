package exercises;

import java.util.Scanner;

public class MPG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("how many miles have you driven?");
        Double miles = in.nextDouble();
        Scanner in2 = new Scanner(System.in);
        System.out.println("how many gallons were depleted?");
        Double gallons = in2.nextDouble();
        String MPG = String.valueOf(miles / gallons);
        System.out.println("Your cars gets ".concat(MPG).concat(" miles per gallon:"));
    }
}
