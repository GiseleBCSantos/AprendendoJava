package controllers;

import classes.reserva.Reserva;
import models.ReservaModel;
import views.ReservaView;

import java.sql.SQLException;
import java.util.List;

public class ReservaController {
    private ReservaModel reservaModel;
    private ReservaView reservaView;

    public ReservaController(ReservaModel reservaModel, ReservaView reservaView){
        this.reservaModel = reservaModel;
        this.reservaView = reservaView;
    }

    public void inserir_reserva(Reserva reserva) throws SQLException {
        reservaModel.add(reserva);
        reservaView.exibir_mensagem("Reserva adicionada com sucesso!");
    }

    public void listar_reservas() throws SQLException{
        List<Reserva> lista_reservas = reservaModel.list_all();
        reservaView.imprimir_reservas(lista_reservas);
    }

    public Reserva exibir_reserva(String nome, String data) throws SQLException{
        return reservaModel.list_item(nome, data);
    }

    public void deletar_reserva(int id) throws SQLException {
        reservaModel.delete(id);
        reservaView.exibir_mensagem("Reserva deletada com sucesso!");
    }
}
