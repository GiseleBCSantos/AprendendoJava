package Capitulo3_variaveis_primitivas_controle_de_fluxo;

public class Questao5 {
    public static void main(String[] args){

        for (int i = 1; i <= 20; i++){
            long acc = 1;

            for (int j = 1; j <= i; j++){
                acc *= j;
            }

            System.out.println("O fatorial de " + i + " é --> " + acc);
        }
    }
}
