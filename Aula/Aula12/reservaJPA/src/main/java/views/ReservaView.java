package views;

import entities.Reserva;
import interfaces.EnviarEmail;

import java.util.List;

public class ReservaView implements EnviarEmail {
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

    public void enviarEmail(String email, String data){
        System.out.println("Email enviado para o endereco " + email + ". Reserva cadastrada para a data: " + data);
    }
}
