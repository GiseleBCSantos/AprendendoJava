package Capitulo12_excecoes;

import Banco.Cliente.Cliente;
import Banco.Conta.ContaCorrente;

public class Principal {
    public static void main(String[] args){
        System.out.println("Inicio do main");
        try{
            metodo1();
        }
        catch (NullPointerException e){
            System.out.println("erro: " + e);
        }
        System.out.println("Fim do main");
    }


    static void metodo1(){
        System.out.println("inicio do metodo 1");
        metodo2();
        System.out.println("fim do metodo 2");
    }

    static void metodo2() {
        System.out.println("inicio do metodo2");
        ContaCorrente cc = new ContaCorrente(1, new Cliente("Joao", "Rua 17"), 500);
        for (int i = 0; i <= 15; i++) {
            cc.deposita(i + 1000);
            System.out.println(cc.getSaldo());
            if (i == 5) {
                cc = null;
            }


        }
        System.out.println("fim do metodo2");


    }
}
