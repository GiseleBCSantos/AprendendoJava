package models;

import dao.ReservaDao;
import entities.Equipamento;
import entities.Reserva;
import interfaces.EnviarEmail;
import entities.Espaco;

import java.util.List;

public class ReservaModel {
    ReservaDao reservaDao;

    public ReservaModel(){
        reservaDao = new ReservaDao();
    }

    public void adicionarReserva(Reserva reserva) throws Exception{
        reservaDao.add(reserva);
    }

    public List<Reserva> listarReservas() throws Exception{
        return reservaDao.list_all();
    }

    public Reserva obterReserva_byNome_byData(String nome, String data) throws Exception{
        return reservaDao.get_byNome_byData(nome, data);
    }

    public Reserva obterReserva_byId(int id) throws Exception{
        return reservaDao.get_byId(id);
    }

    public void modificarReserva(int id, Reserva nova_reserva) throws Exception{
        reservaDao.update(id, nova_reserva);
    }

    public void deletarReserva(int id) throws Exception{
        reservaDao.delete(id);
    }

    public void reservarEspaco(Espaco espaco) throws Exception {
        reservaDao.reservarEspaco(espaco);
    }

    public void reservarEquipamento(Equipamento equipamento) throws Exception {
        reservaDao.reservarEquipamento(equipamento);
    }
}
