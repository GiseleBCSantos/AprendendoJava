package classes.reserva;

import classes.equipamento.Equipamento;
import classes.espaco.Espaco;
import classes.funcionario.Funcionario;

public class Reserva {
    private int id;
    private String data_reserva;
    private Funcionario solicitante;
    private Espaco espaco_reservado;
    private Equipamento equipamento_reservado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(String data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Funcionario solicitante) {
        this.solicitante = solicitante;
    }

    public Espaco getEspaco_reservado() {
        return espaco_reservado;
    }

    public void setEspaco_reservado(Espaco espaco_reservado) {
        this.espaco_reservado = espaco_reservado;
    }

    public Equipamento getEquipamento_reservado() {
        return equipamento_reservado;
    }

    public void setEquipamento_reservado(Equipamento equipamento_reservado) {
        this.equipamento_reservado = equipamento_reservado;
    }

    public Reserva(String data_reserva, Funcionario solicitante, Espaco espaco) {
        this.data_reserva = data_reserva;
        this.solicitante = solicitante;
        this.espaco_reservado = espaco;
    }

    public Reserva(String data_reserva, Funcionario solicitante, Equipamento equipamento) {
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
        else if (equipamento_reservado != null) {
            txt_reserva += "\nEquipamento: " + equipamento_reservado.getDescricao() + "\n";
        }

        return txt_reserva;
    }
}