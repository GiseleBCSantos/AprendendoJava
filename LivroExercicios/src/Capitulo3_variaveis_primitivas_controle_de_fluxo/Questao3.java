package Capitulo3_variaveis_primitivas_controle_de_fluxo;

public class Questao3 {
    public static void main(String[] args){
        System.out.println("São múltiplos de 3 entre 1 e 100 os seguintes números:");

        for (int i = 3; i < 100; i++){
            if (i % 3 == 0){
                System.out.println(i);
            }
        }
    }
}
