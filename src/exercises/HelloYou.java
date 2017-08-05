package exercises;

import java.util.Scanner;

public class HelloYou {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, what is your name?");
        String name = in.next();
        System.out.println("Nice to meet you ".concat(name));
    }
}

