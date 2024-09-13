package models;

import classes.espaco.Espaco;
import dao.EspacoDao;

import java.sql.SQLException;
import java.util.List;

public class EspacoModel {
    private EspacoDao espacoDao;

    public EspacoModel() throws SQLException {
        this.espacoDao = new EspacoDao();
    }

    public void add(Espaco espaco) throws SQLException {
        espacoDao.add(espaco);
    }

    public List get_list() throws SQLException{
        return espacoDao.get_list();
    }

    public Espaco get_item(String descricao) throws SQLException{
        return espacoDao.get_item_byDescricao(descricao);
    }

    public void modificar_espaco(int id, Espaco espaco) throws SQLException {
        espacoDao.update(id, espaco);
    }

    public void delete(int id) throws SQLException{
        espacoDao.remove(id);
    }
}
