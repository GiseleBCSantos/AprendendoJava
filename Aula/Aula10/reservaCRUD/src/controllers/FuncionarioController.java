package controllers;

import classes.funcionario.Funcionario;
import models.FuncionarioModel;
import views.FuncionarioView;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    private FuncionarioModel funcionarioModel;
    private FuncionarioView funcionarioView;

    public FuncionarioController(FuncionarioModel funcionarioModel, FuncionarioView funcionarioView){
        this.funcionarioModel = funcionarioModel;
        this.funcionarioView = funcionarioView;
    }

    public void inserir_funcionario(Funcionario funcionario) throws SQLException{
        funcionarioModel.add(funcionario);
        funcionarioView.exibir_mensagem("Funcionario adicionado com sucesso!");
    }

    public void listar_funcionarios() throws SQLException{
        List<Funcionario> lista_funcionarios = funcionarioModel.get_list();
        funcionarioView.imprimir_funcionarios(lista_funcionarios);
    }

    public Funcionario buscar_porNome(String nome) throws SQLException{
        return funcionarioModel.get_item_byName(nome);
    }

    public Funcionario buscar_porId(int id) throws SQLException{
        return funcionarioModel.get_item_byId(id);
    }

    public void modificar_funcionario(int id, Funcionario funcionario) throws SQLException{
        funcionarioModel.update(id, funcionario);
        funcionarioView.exibir_mensagem("Funcionario alterado com sucesso!");
    }

    public void remover_funcionario(int id) throws SQLException{
        funcionarioModel.delete(id);
        funcionarioView.exibir_mensagem("Funcionario deletado com sucesso!");
    }


}
