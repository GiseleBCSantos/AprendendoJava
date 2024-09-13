package views;

import classes.espaco.Espaco;

import java.util.List;

public class EspacoView {
    public void imprimir_espacos(List<Espaco> espacos){
        System.out.println("---------- LISTA DE ESPACOS ----------");
        for (int i=0;i<espacos.size();i++){
            System.out.println(espacos.get(i).getId() + " - " + (espacos.get(i)).getDescricao());
        }
        System.out.println("-------------------------------------------");
    }

    public void exibir_mensagem(String mensagem){
        System.out.println(mensagem);
    }
}
