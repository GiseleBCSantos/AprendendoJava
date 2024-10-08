package models;

import dao.FuncionarioDao;
import entities.Chefia;
import entities.Funcionario;
import interfaces.Autenticar;

import java.util.List;

public class FuncionarioModel implements Autenticar {
    FuncionarioDao funcionarioDao;

    public FuncionarioModel(){
        funcionarioDao = new FuncionarioDao();
    }

    @Override
    public boolean autenticarFuncionario(Chefia chefia, int senha) {
        return chefia.getSenha() == senha;
    }

    public void adicionarFuncionario(Funcionario funcionario) throws Exception{
        funcionarioDao.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() throws Exception{
        return funcionarioDao.list_all();
    }

    public Funcionario obterFuncionario_byNome(String nome) throws Exception{
        return funcionarioDao.get_byNome(nome);
    }

    public Funcionario obterFuncionario_byId(int id) throws Exception{
        return funcionarioDao.get_byId(id);
    }

    public void modificarFuncionario(int id, Funcionario novo_funcionario) throws Exception{
        funcionarioDao.update(id, novo_funcionario);
    }

    public void deletarFuncionario(int id) throws Exception{
        funcionarioDao.delete(id);
    }


}
