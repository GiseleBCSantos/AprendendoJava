import obj_reserva.Equipamento;
import obj_reserva.Espaco;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Equipamento impressora = new Equipamento(1, "Imprime", 10, 1);
        Equipamento grampeador = new Equipamento(2, "Grampeia", 15, 10);

        Espaco sala_b12 = new Espaco(1, "Sala B-12", true);
        Espaco sala_b10 = new Espaco(2, "Sala B-10", false);
        Espaco sala_b11 = new Espaco(3, "Sala B-11", true);

        Reserva reserva1 = new Reserva(1, "José Felipe");
        reserva1.reservar_espaco(sala_b10);
        reserva1.reservar_espaco(sala_b12);

        reserva1.reservar_equipamento(impressora);
        reserva1.reservar_equipamento(impressora);

    }
}