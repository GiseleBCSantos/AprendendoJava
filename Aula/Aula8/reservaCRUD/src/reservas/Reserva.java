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

    public static int getId() {
        return id;
    }

    public String getData_reserva() {
        return data_reserva;
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public Espaco getEspaco_reservado() {
        return espaco_reservado;
    }

    public Equipamento getEquipamento_reservado() {
        return equipamento_reservado;
    }

    public Reserva(String data_reserva, Funcionario solicitante, Espaco espaco) {
        Reserva.id++;
        this.data_reserva = data_reserva;
        this.solicitante = solicitante;
        this.espaco_reservado = espaco;
    }

    public Reserva(String data_reserva, Funcionario solicitante, Equipamento equipamento) {
        Reserva.id++;
        this.data_reserva = data_reserva;
        this.solicitante = solicitante;
        this.equipamento_reservado = equipamento;
    }

    @Override
    public String toString() {
        String txt_reserva = "\nSolicitante: " + solicitante.getNome() +
                "\nData: " + data_reserva;

        if (espaco_reservado != null) {
            txt_reserva += "\nEspaco: " + espaco_reservado.getDescricao() + "\n";
        }
        if (equipamento_reservado != null) {
            txt_reserva += "\nEquipamento: " + equipamento_reservado.getDescricao() + "\n";
        }

        return txt_reserva;
    }
}