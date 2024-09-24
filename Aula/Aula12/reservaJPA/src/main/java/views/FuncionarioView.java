package views;

import entities.Funcionario;

import java.util.List;

public class FuncionarioView
{
    public void imprimirFuncionarios(List<Funcionario> funcionarioList){
        if( funcionarioList.isEmpty()){
            System.out.println("Nao ha funcionarios cadastrados!");
        }
        else{
            for (Funcionario funcionario : funcionarioList){
                System.out.println(funcionario.getId() + " - " + funcionario.getNome());
            }
        }
    }

    public void exibirMensagem(String text){
        System.out.println(text);
    }
}
