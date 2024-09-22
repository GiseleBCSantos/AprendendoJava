package models;

import dao.EspacoDao;
import entities.Espaco;

import java.util.List;

public class EspacoModel {
    EspacoDao espacoDao;

    public EspacoModel(){
        espacoDao = new EspacoDao();
    }

    public void adicionarEspaco(Espaco espaco) throws Exception{
        espacoDao.add(espaco);
    }

    public List<Espaco> listarEspacos() throws Exception{
        return espacoDao.list_all();
    }

    public Espaco obterEspaco_byDescricao(String descricao) throws Exception{
        return espacoDao.get_byDescricao(descricao);
    }

    public Espaco obterEspaco_byId(int id) throws Exception{
        return espacoDao.get_byId(id);
    }

    public void modificarEspaco(int id, Espaco novo_espaco) throws Exception{
        espacoDao.update(id, novo_espaco);
    }

    public void deletarEspaco(int id) throws Exception{
        espacoDao.delete(id);
    }
}
