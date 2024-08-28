package reservas;

import equipamentos.Equipamento;
import espacos.Espaco;
import funcionarios.Funcionario;

public class Reserva {
    private static int id;
    private String data_reserva;
    private Funcionario solicitante;
    private Espaco espaco_reservado;
    private Equipamento equipamento_reservado;

    public Reserva(String data_reserva, Funcionario solicitante, Espaco espaco){
        Reserva.id++;
        this.data_reserva = data_reserva;
        this.solicitante = solicitante;
        this.espaco_reservado = espaco;
    }

    public Reserva(String data_reserva, Funcionario solicitante, Equipamento equipamento){
        Reserva.id++;
        this.data_reserva = data_reserva;
        this.solicitante = solicitante;
        this.equipamento_reservado = equipamento;
    }
}
