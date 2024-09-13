package controllers;

import classes.equipamento.Equipamento;
import models.EquipamentoModel;
import views.EquipamentoView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EquipamentoController {
    private EquipamentoModel equipamentoModel;
    private EquipamentoView equipamentoView;

    public EquipamentoController(EquipamentoModel equipamentoModel, EquipamentoView equipamentoView){
        this.equipamentoModel = equipamentoModel;
        this.equipamentoView = equipamentoView;
    }

    public void inserir_equipamento(Equipamento equipamento){
        equipamentoModel.add(equipamento);
        equipamentoView.exibir_mensagem("Equipamento adicionado com sucesso!");
    }

    public void listar_equipamentos() throws SQLException{
        List<Equipamento> equipamentos = equipamentoModel.get_list();
        if (equipamentos.isEmpty()){
            equipamentoView.exibir_mensagem("Nenhum equipamento cadastrado.");
        } else{
            equipamentoView.imprimir_equipamentos(equipamentos);
        }
    }

    public Equipamento buscar_por_descricao(String descricao) throws SQLException{
        return equipamentoModel.get_item_byDescricao(descricao);
    }

    public Equipamento buscar_por_id(int id) throws SQLException{
        return equipamentoModel.get_item_byId(id);
    }

    public void modificar_equipamento(int id, Equipamento novo_equipamento) throws SQLException{
        equipamentoModel.update(id, novo_equipamento);

    }

    public void remover_equipamento(int id) throws SQLException{
        equipamentoModel.delete(id);
        equipamentoView.exibir_mensagem("Equipamento excluido com sucesso!");
    }
}
