package controllers;

import classes.espaco.Espaco;
import models.EspacoModel;
import views.EspacoView;

import java.sql.SQLException;
import java.util.List;

public class EspacoController {
    private EspacoModel espacoModel;
    private EspacoView espacoView;

    public EspacoController(EspacoModel espacoModel, EspacoView espacoView){
        this.espacoModel = espacoModel;
        this.espacoView = espacoView;
    }

    public void inserir_espaco(Espaco espaco) throws SQLException{
        espacoModel.add(espaco);
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

    public Espaco buscar_por_descricao(String descricao) throws SQLException{
        return espacoModel.get_item(descricao);
    }

    public void modificar_espaco(int id, Espaco espaco) throws SQLException{
        espacoModel.modificar_espaco(id, espaco);
    }

    public void remover_espaco(int id) throws SQLException{
        espacoModel.delete(id);
        espacoView.exibir_mensagem("Espaco excluido com sucesso.");
    }
}
