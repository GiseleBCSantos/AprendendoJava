package Capitulo3_variaveis_primitivas_controle_de_fluxo;

import java.util.Scanner;

public class Questao7 {
    public static void main(String[] args){
        int x = 13;
        String texto = "";

        while (x != 1){
            if (x % 2 == 0){
                x = x/2;
            }
            else{
                x = 3*x + 1;
            }

            if (x != 1){
                System.out.print(x + " -> ");
            }

            if (x == 1){
                System.out.print(x);
            }
        }

    }
}
