package models;

import classes.funcionario.Funcionario;
import dao.FuncionarioDao;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioModel {
    private FuncionarioDao funcionarioDao;

    public FuncionarioModel() throws SQLException{
        funcionarioDao = new FuncionarioDao();
    }

    public void add(Funcionario funcionario) throws SQLException{
        funcionarioDao.add(funcionario);
    }

    public List get_list() throws SQLException{
        return funcionarioDao.get_list();
    }

    public Funcionario get_item_byName(String nome) throws SQLException {
        return funcionarioDao.get_item_byNome(nome);
    }

    public Funcionario get_item_byId(int id) throws SQLException {
        return funcionarioDao.get_item_byId(id);
    }

    public void update(int id, Funcionario funcionario) throws SQLException{
        funcionarioDao.update(id, funcionario);
    }

    public void delete(int id) throws SQLException{
        funcionarioDao.remove(id);
    }
}
