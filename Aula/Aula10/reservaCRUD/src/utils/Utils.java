package utils;

import java.util.Scanner;

public class Utils {
    public static int get_number_in_range(Scanner sc, int min, int max){
        int number = sc.nextInt();
        return number <= max && number >= min ? number : get_number_in_range(sc, min, max);
    }

    public static String get_text(Scanner sc){
        String _ = sc.nextLine();
        String text = sc.nextLine();
        return text;
    }
}
