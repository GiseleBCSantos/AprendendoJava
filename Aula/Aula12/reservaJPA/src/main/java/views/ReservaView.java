package views;

import entities.Reserva;

import java.util.List;

public class ReservaView {
    public void imprimirReservas(List<Reserva> reservaList){
        if (reservaList.isEmpty()){
            System.out.println("Nao ha reservas cadastradas!");
        }
        else{
            for (Reserva reserva : reservaList){
                System.out.println(reserva);
            }
        }
    }

    public void exibirMensagem(String text){
        System.out.println(text);
    }
}
