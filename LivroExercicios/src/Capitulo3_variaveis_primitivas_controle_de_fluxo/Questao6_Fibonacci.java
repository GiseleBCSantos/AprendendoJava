package Capitulo3_variaveis_primitivas_controle_de_fluxo;

import java.util.ArrayList;

public class Questao6_Fibonacci {
    public static void main(String[] args){

        ArrayList<Integer> lista = new ArrayList<Integer>();
        int contador = 0;
        int num_atual = 0;

        while (num_atual <= 100){
            contador++;

            if (contador == 1){
                lista.add(0);
            }

            if (contador == 2){
                lista.add(1);
            }

            if (contador != 1 && contador != 2) {
                int ultimo_da_lista = lista.get(lista.size() -1);
                int penultimo_da_lista = lista.get(lista.size()-2);
                num_atual = ultimo_da_lista + penultimo_da_lista;
                lista.add(num_atual);
            }
        }

        System.out.println(lista);


    }
}
