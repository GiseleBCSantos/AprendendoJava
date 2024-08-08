import obj_reserva.Equipamento;
import obj_reserva.Espaco;

public class Reserva {
    int id;
    String nome_solicitante;
    Espaco espaco_reservado;
    Equipamento equipamento_reservado;


    public Reserva(int id, String nome_solicitante){
        this.id = id;
        this.nome_solicitante = nome_solicitante;
    }

    public void reservar_espaco(Espaco espaco){
        this.espaco_reservado = espaco;
        this.espaco_reservado.reservar_espaco();
    }

    public void reservar_equipamento(Equipamento equipamento){
        this.equipamento_reservado = equipamento;
        this.equipamento_reservado.reservar_equipamento();
    }
}
