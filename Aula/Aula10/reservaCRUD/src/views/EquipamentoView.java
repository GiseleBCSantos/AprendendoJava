package views;

import classes.equipamento.Equipamento;

import java.util.List;

public class EquipamentoView {
    public void imprimir_equipamentos(List<Equipamento> equipamentos){
        System.out.println("---------- LISTA DE EQUIPAMENTOS ----------");
        for (int i=0;i<equipamentos.size();i++){
            System.out.println(equipamentos.get(i).getId() + " - " + (equipamentos.get(i)).getDescricao());
        }
        System.out.println("-------------------------------------------");
    }

    public void exibir_mensagem(String mensagem){
        System.out.println(mensagem);
    }
}
