package controllers;

import classes.equipamento.Equipamento;
import models.EquipamentoModel;
import utils.Utils;
import views.EquipamentoView;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static utils.Utils.get_text;
import static utils.Utils.get_number_in_range;

public class EquipamentoController {
    private EquipamentoModel equipamentoModel;
    private EquipamentoView equipamentoView;

    public EquipamentoController() throws SQLException {
        this.equipamentoModel = new EquipamentoModel();
        this.equipamentoView = new EquipamentoView();
    }

    public void inserir_equipamento(Scanner sc) throws Exception {
        try{
            System.out.println("Qual a descricao?");
            String descricao = get_text(sc);

            System.out.println("Qual a quantidade total?");
            int qntdTotal = sc.nextInt();

            System.out.println("Qual a quantidade disponivel?");
            int qntdDisp = sc.nextInt();

            Equipamento novo_equipamento = new Equipamento(descricao, qntdTotal, qntdDisp);
            equipamentoModel.add(novo_equipamento);
            equipamentoView.exibir_mensagem("Equipamento adicionado com sucesso!");
        } catch (Exception e) {
            throw new Exception("Erro ao inserir equipamento.");
        }
    }

    public void listar_equipamentos() throws SQLException{
        List<Equipamento> equipamentos = equipamentoModel.get_list();
        if (equipamentos.isEmpty()){
            equipamentoView.exibir_mensagem("Nenhum equipamento cadastrado.");
        } else{
            equipamentoView.imprimir_equipamentos(equipamentos);
        }
    }

    public Equipamento buscar_por_descricao(Scanner sc) throws Exception {
        System.out.println("Qual a descricao do item que voce deseja visualizar? ");
        String descricao_buscada = get_text(sc);

        return equipamentoModel.get_item_byDescricao(descricao_buscada);
    }

    public Equipamento buscar_por_id(int id) throws SQLException{
        return equipamentoModel.get_item_byId(id);
    }

    public void modificar_equipamento(Scanner sc) throws Exception {
        try{
            listar_equipamentos();
            System.out.println("Qual o Id do item que voce deseja modificar? ");
            int id = sc.nextInt();

            System.out.println("Qual a nova descricao?");
            String novaDescricao = get_text(sc);

            System.out.println("Qual a nova quantidade total?");
            int novaQntdTotal = sc.nextInt();

            System.out.println("Qual a nova quantidade disponivel?");
            int novaQntdDisp = sc.nextInt();

            Equipamento equipamento_modificado = new Equipamento(novaDescricao, novaQntdTotal, novaQntdDisp);

            equipamentoModel.update(id, equipamento_modificado);
        } catch (Exception e){
            throw new Exception("Erro ao modificar equipamento.");
        }
    }

    public void remover_equipamento(Scanner sc) throws SQLException{
        System.out.println("Qual o id do equipamento que voce deseja remover? ");
        listar_equipamentos();
        int idEquipamento = sc.nextInt();

        if (buscar_por_id(idEquipamento) != null){
            equipamentoModel.delete(idEquipamento);
            equipamentoView.exibir_mensagem("Equipamento excluido com sucesso!");
        } else{
            System.out.println("Equipamento nao existe.");
        }
    }
}
