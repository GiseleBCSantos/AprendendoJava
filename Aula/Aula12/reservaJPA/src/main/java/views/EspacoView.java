package views;

import entities.Equipamento;
import entities.Espaco;

import java.util.List;

public class EspacoView {
    public void imprimirEspacos(List<Espaco> espacoList){
        if (espacoList.isEmpty()){
            System.out.println("Nao ha nenhum espaco cadastrado!");
        }
        else{
            for (int i=0;i<espacoList.size();i++){
                System.out.println(espacoList.get(i).getId() + " - " + espacoList.get(i).getDescricao());
            }
        }
    }

    public void exibirMensagem(String text){
        System.out.println(text);
    }
}
