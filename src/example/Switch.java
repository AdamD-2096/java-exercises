package example;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {

        System.out.println("Enter an integer: ");
        Scanner in = new Scanner(System.in);
        int dayNum = in.nextInt();

        int day = 0;
        switch (dayNum) {
            case 0:
                day += 5;
            case 1:
                day += 9;
            case 2:
                day += 3;
            case 3:
                day += 14;
            case 4:
                day += 2;
            case 5:
                day += 6;
            case 6:
                day += 1;
            default:
                day += 100;
        }
        System.out.println(day + dayNum);
    }
}

