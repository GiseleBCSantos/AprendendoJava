package models;

import dao.EquipamentoDao;
import entities.Equipamento;

import java.util.List;

public class EquipamentoModel {
    EquipamentoDao equipamentoDao;

    public EquipamentoModel(){
        equipamentoDao = new EquipamentoDao();
    }

    public void adicionarEquipamento(Equipamento equipamento) throws Exception {
        equipamentoDao.add(equipamento);
    }

    public List<Equipamento> listarEquipamentos() throws Exception{
        return equipamentoDao.list_all();
    }

    public Equipamento obterEquipamento_byDescricao(String descricao) throws Exception{
        return equipamentoDao.get_byDescricao(descricao);
    }

    public Equipamento obterEquipamento_byId(int id) throws Exception{
        return equipamentoDao.get_byId(id);
    }

    public void modificarEquipamento(int id, Equipamento novo_equipamento) throws Exception{
        equipamentoDao.update(id, novo_equipamento);
    }

    public void deletarEquipamento(int id) throws Exception{
        equipamentoDao.delete(id);
    }
}
