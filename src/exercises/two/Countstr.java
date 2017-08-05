package exercises.two;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Countstr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("from file:0 from keyboard:1");
        int pick = in.nextInt();
        in.nextLine();
        if (pick == 1){
            Countstr.input();
        }/*else{
            Countstr.file();
        }*/
    }
    public static void file(){
        try {
            System.out.print("Enter the file name with extension : ");

            Scanner input = new Scanner(System.in);

            File file = new File(input.nextLine());

            input = new Scanner(file);

            String line = "";
            while (input.hasNextLine()) {
                line = line.concat(input.nextLine());
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    /*


        Scanner in = new Scanner(System.in);
        System.out.println("file name: eg. file.txt");
        String filename = in.nextLine();
        File file = new File(filename);
        HashMap<String, Integer> alpha = new HashMap<>();
        Scanner sc = new Scanner(file);
        String text = sc.nextLine();

        for (int i = 0; i<text.length(); i++){
            String let = String.valueOf(text.charAt(i));
            if (!alpha.containsKey(let)){
                alpha.put(let, 1);
            }else{
                alpha.put(let, alpha.get(let) + 1);
            }
        }


        for (Map.Entry<String, Integer> a : alpha.entrySet()) {
            System.out.println(a.getKey() + ":" + a.getValue());
        }*/

    }
    public static void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("String to count characters:");
        String search = in.nextLine();
        HashMap<String, Integer> alpha = new HashMap<>();

        for (int i = 0; i<search.length(); i++){
            String let = String.valueOf(search.charAt(i));
            if (!alpha.containsKey(let)){
                alpha.put(let, 1);
            }else{
                alpha.put(let, alpha.get(let) + 1);
            }
        }


        for (Map.Entry<String, Integer> a : alpha.entrySet()) {
            System.out.println(a.getKey() + ":" + a.getValue());
        }
    }
}
