package views;


import classes.funcionario.Funcionario;

import java.util.List;

public class FuncionarioView {
    public void imprimir_funcionarios(List<Funcionario> funcionarios){
        System.out.println("---------- LISTA DE FUNCIONARIOS ----------");
        for (int i=0;i<funcionarios.size();i++){
            System.out.println(funcionarios.get(i).getId() + " - " + (funcionarios.get(i).getNome()));
        }
        System.out.println("-------------------------------------------");
    }

    public void exibir_mensagem(String mensagem){
        System.out.println(mensagem);
    }
}
