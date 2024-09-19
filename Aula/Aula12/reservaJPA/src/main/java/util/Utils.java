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
}
