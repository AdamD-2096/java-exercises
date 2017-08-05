package exercises.two;

import java.util.ArrayList;
import java.util.Scanner;

public class Lists {
    public static void main (String[] args){
        ArrayList<Integer> ints = Lists.IntList();
        System.out.println(ints);
        ArrayList<String> strs = Lists.StrList();
        System.out.println(strs);
    }
    public static ArrayList<Integer> IntList() {

        ArrayList<Integer> ints = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Integer newInt;

        System.out.println("Enter a number (num < 1 will exit loop)");

        // Get numbers
        do {
            newInt = in.nextInt();

            if (newInt > 0) {
                ints.add(newInt);
            }

        } while(newInt > 0);

        return ints;
    }
    public static ArrayList<String> StrList() {

        ArrayList<String> strs = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String newStr;

        System.out.println("Enter a word (or ENTER to finish):");

        // Get words
        do {
            newStr = in.nextLine();

            if (!newStr.equals("")) {
                strs.add(newStr);
            }

        } while(!newStr.equals(""));

        return strs;
    }

}
