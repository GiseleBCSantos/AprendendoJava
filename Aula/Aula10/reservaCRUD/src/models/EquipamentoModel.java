package models;

import classes.equipamento.Equipamento;
import dao.EquipamentoDao;

import java.sql.SQLException;
import java.util.List;

public class EquipamentoModel {
    private EquipamentoDao equipamentoDao;

    public EquipamentoModel() throws SQLException {
        equipamentoDao = new EquipamentoDao();
    }

    public void add(Equipamento equipamento){
        equipamentoDao.add(equipamento);
    }

    public List get_list() throws SQLException {
        return equipamentoDao.get_list();
    }

    public Equipamento get_item_byDescricao(String descricao) throws SQLException{
        return equipamentoDao.get_item_byDescricao(descricao);
    }

    public Equipamento get_item_byId(int id) throws SQLException{
        return equipamentoDao.get_item_byId(id);
    }

    public void update(int id, Equipamento equipamento) throws SQLException{
        equipamentoDao.update(id, equipamento);
    }

    public void delete(int id) throws SQLException{
        equipamentoDao.delete(id);
    }


}
