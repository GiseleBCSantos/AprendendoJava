package views;


import classes.reserva.Reserva;

import java.util.List;

public class ReservaView {
    public void imprimir_reservas(List<Reserva> reservas){
        System.out.println("---------- LISTA DE ESPACOS ----------");
        for (int i=0;i<reservas.size();i++){
            System.out.println(i+1 + " - " + (reservas.get(i)));
        }
        System.out.println("-------------------------------------------");
    }

    public void exibir_mensagem(String mensagem){
        System.out.println(mensagem);
    }
}
