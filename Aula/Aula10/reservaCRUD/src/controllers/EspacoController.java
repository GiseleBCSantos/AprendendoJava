package controllers;

import classes.espaco.Espaco;
import models.EspacoModel;
import views.EspacoView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static utils.Utils.get_text;
public class EspacoController {
    private EspacoModel espacoModel;
    private EspacoView espacoView;

    public EspacoController() throws SQLException {
        this.espacoModel = new EspacoModel();
        this.espacoView = new EspacoView();
    }

    public void inserir_espaco(Scanner sc) throws SQLException{
        System.out.println("Qual a descricao?");
        String descricao = get_text(sc);

        System.out.println("Ele esta disponivel? (1-sim) (2-nao)");
        boolean desocupado = sc.nextInt() == 1;


        Espaco novo_espaco = new Espaco(descricao, desocupado);

        espacoModel.add(novo_espaco);
        espacoView.exibir_mensagem("Espaco adicionado com sucesso!");
    }

    public void listar_espacos() throws SQLException{
        List<Espaco> espacos = espacoModel.get_list();
        if (espacos.isEmpty()){
            espacoView.exibir_mensagem("Nenhum espaco cadastrado.");
        }else{
            espacoView.imprimir_espacos(espacos);
        }
    }

    public Espaco buscar_por_descricao(Scanner sc) throws SQLException{
        System.out.println("Qual a descricao do item que voce deseja visualizar? ");
        String descricao_buscada = get_text(sc);

        return espacoModel.get_item_byDescricao(descricao_buscada);
    }

    public Espaco buscar_porId(int id) throws SQLException{
        return espacoModel.get_item_byId(id);
    }

    public void modificar_espaco(Scanner sc) throws SQLException{
        listar_espacos();
        System.out.println("Qual o Id do item que voce deseja modificar? ");
        int id = sc.nextInt();

        System.out.println("Qual a nova descricao?");
        String novaDescricao = get_text(sc);

        System.out.println("Ele esta disponivel? (1-sim) (2-nao)");
        boolean desocupado_modificar = sc.nextInt() == 1;

        Espaco espaco_modificado = new Espaco(novaDescricao, desocupado_modificar);

        espacoModel.modificar_espaco(id, espaco_modificado);
    }

    public void remover_espaco(Scanner sc) throws SQLException{
        listar_espacos();
        System.out.println("Qual o id do espaco que voce deseja remover? ");
        int idEspaco = sc.nextInt();

        if (buscar_porId(idEspaco) != null){
            espacoModel.delete(idEspaco);
            espacoView.exibir_mensagem("Espaco excluido com sucesso.");
        } else{
            System.out.println("Espaco nao existe.");
        }
    }
}
