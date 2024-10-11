package util;

import java.util.Scanner;

public class Utils {
    public static String colorirErro (String txt){
        return Cores.ANSI_RED+ txt + Cores.ANSI_RESET;
    }

    public static void imprimirComentario (String txt){
        System.out.println(Cores.ANSI_YELLOW + txt + Cores.ANSI_RESET);
    }

    public static void pressEnterToContinue (){
        Scanner sc = new Scanner(System.in);
        imprimirComentario("Press ENTER to continue...");
        sc.nextLine();
    }

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
