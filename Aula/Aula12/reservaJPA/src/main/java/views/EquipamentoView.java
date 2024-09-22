package views;

import entities.Equipamento;

import java.util.List;

public class EquipamentoView {

    public void imprimirEquipamentos(List<Equipamento> equipamentoList){
        System.out.println("---------- LISTA DE EQUIPAMENTOS ----------");
        for (int i=0;i<equipamentoList.size();i++){
            System.out.println(equipamentoList.get(i).getId() + " - " + equipamentoList.get(i).getDescricao());
        }
    }

    public void exibirMensagem(String text){
        System.out.println(text);
    }
}
