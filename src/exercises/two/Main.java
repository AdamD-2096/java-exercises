package exercises.two;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> ints = Lists.IntList();
        Main.sum(ints);
        ArrayList<String> strs = Lists.StrList();
        Main.findfive(strs);

    }

    public static void sum(ArrayList<Integer> ints) {
        int i;
        Integer sum = 0;
        for (i = 0; i < ints.size(); i++) {
            if (ints.get(i) % 2 == 0) {
                sum += ints.get(i);
            }
        }
        System.out.println("\nSum of ints:".concat(String.valueOf(sum)));

    }

    public static void findfive(ArrayList<String> strs) {
        int i;
        String str;
        for (i = 0; i < strs.size(); i++) {
            str = strs.get(i);
            if (str.length() == 5) {
                System.out.println(str);
            }
        }
    }
}