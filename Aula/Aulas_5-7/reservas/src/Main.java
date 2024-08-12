import obj_reserva.Equipamento;
import obj_reserva.Espaco;

public class Main {
    public static void main(String[] args) {

        Equipamento impressora = new Equipamento(1, "Impressora", 10, 1);
        Equipamento grampeador = new Equipamento(2, "Grampeadora", 15, 10);

        Espaco sala_b12 = new Espaco(1, "Sala B-12", true);
        Espaco sala_b10 = new Espaco(2, "Sala B-10", false);
        Espaco sala_b11 = new Espaco(3, "Sala B-11", true);

        Reserva reserva_joao = new Reserva(1, "10/03/2024", "José Felipe");
        reserva_joao.reservar_espaco(sala_b10);
        reserva_joao.reservar_espaco(sala_b12);

        Reserva reserva_marcos = new Reserva(2, "11/03/2024", "Marcos");

        reserva_marcos.reservar_equipamento(impressora);
        reserva_marcos.reservar_equipamento(impressora);

    }
}