package controllers;

import entities.Espaco;
import models.EspacoModel;
import views.EspacoView;

import java.util.List;
import java.util.Scanner;

import static util.Utils.get_text;

public class EspacoController {
    private EspacoModel espacoModel;
    private EspacoView espacoView;

    public EspacoController() {
        this.espacoModel = new EspacoModel();
        this.espacoView = new EspacoView();
    }

    public void inserirEspaco(Scanner sc) throws Exception{
        System.out.println("Qual a descricao?");
        String descricao = get_text(sc);

        System.out.println("Ele esta disponivel? (1-sim) (2-nao)");
        boolean desocupado = sc.nextInt() == 1;


        Espaco novo_espaco = new Espaco();
        novo_espaco.setDescricao(descricao);
        novo_espaco.setStatus(desocupado);

        espacoModel.adicionarEspaco(novo_espaco);
        espacoView.exibirMensagem("Espaco adicionado com sucesso!");
    }

    public void listarEspacos() throws Exception{
        List<Espaco> espacos = espacoModel.listarEspacos();
        if (espacos.isEmpty()){
            espacoView.exibirMensagem("Nenhum espaco cadastrado.");
        }else{
            espacoView.imprimirEspacos(espacos);
        }
    }

    public Espaco buscarPorDescricao(Scanner sc) throws Exception{
        System.out.println("Qual a descricao do item que voce deseja visualizar? ");
        String descricao_buscada = get_text(sc);

        return espacoModel.obterEspaco_byDescricao(descricao_buscada);
    }

    public Espaco buscar_porId(int id) throws Exception{
        return espacoModel.obterEspaco_byId(id);
    }

    public void modificarEspaco(Scanner sc) throws Exception{
        listarEspacos();
        System.out.println("Qual o Id do item que voce deseja modificar? ");
        int id = sc.nextInt();

        System.out.println("Qual a nova descricao?");
        String novaDescricao = get_text(sc);

        System.out.println("Ele esta disponivel? (1-sim) (2-nao)");
        boolean desocupado_modificar = sc.nextInt() == 1;

        Espaco espaco_modificado = new Espaco();
        espaco_modificado.setDescricao(novaDescricao);
        espaco_modificado.setStatus(desocupado_modificar);

        espacoModel.modificarEspaco(id, espaco_modificado);
    }

    public void removerEspaco(Scanner sc) throws Exception{
        listarEspacos();
        System.out.println("Qual o id do espaco que voce deseja remover? ");
        int idEspaco = sc.nextInt();

        if (buscar_porId(idEspaco) != null){
            espacoModel.deletarEspaco(idEspaco);
            espacoView.exibirMensagem("Espaco excluido com sucesso.");
        } else{
            System.out.println("Espaco nao existe.");
        }
    }
}
