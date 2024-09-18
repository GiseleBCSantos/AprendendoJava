package org.example;

public class Exercicio {
    public static void main(String[] args) {
        int lugares = 120;
        double noShow = 0.1;
        double custoPassagem = 500;
        double multaExtra = 1000;
        double multaNoShow = 50;

        int passagensVendidas = 120;


        while (passagensVendidas < 200) {
            int pessoasPresentes = (int) (passagensVendidas*(1-noShow));

            int pessoasExtras = pessoasPresentes > lugares ? pessoasPresentes - lugares : 0;
            int pessoasNoShow = passagensVendidas - pessoasPresentes;


            System.out.println(
                    "Passagens vendidas= " + passagensVendidas +
                    " | Passageiros presentes= " + pessoasPresentes +
                    " | Lucro para empresa= " + (passagensVendidas*custoPassagem + pessoasNoShow*multaNoShow - (pessoasExtras*(multaExtra+custoPassagem))
            ));

            passagensVendidas++;
        }
    }
}
