package models;

import classes.reserva.Reserva;
import dao.ReservaDao;

import java.sql.SQLException;
import java.util.List;

public class ReservaModel {
    private ReservaDao reservaDao;

    public ReservaModel() throws SQLException {
        this.reservaDao = new ReservaDao();
    }

    public void add(Reserva reserva) throws SQLException{
        reservaDao.add(reserva);
    }

    public List list_all() throws SQLException{
        return reservaDao.list_all();
    }

    public Reserva list_item(String nome, String data) throws SQLException{
        return reservaDao.list_item(nome, data);
    }

    public Reserva list_byId(int id) throws SQLException{
        return reservaDao.list_byId(id);
    }

    public void delete(int id) throws SQLException{
        reservaDao.delete(id);
    }
}
