package controllers;

import entities.Equipamento;
import models.EquipamentoModel;
import views.EquipamentoView;

import java.util.List;
import java.util.Scanner;

import static util.Utils.get_text;

public class EquipamentoController {
    EquipamentoModel equipamentoModel;
    EquipamentoView equipamentoView;

    public EquipamentoController(){
        this.equipamentoModel = new EquipamentoModel();
        this.equipamentoView = new EquipamentoView();
    }

    public void adicionarEquipamento(Scanner sc) throws Exception {
        try{
            System.out.println("Qual a descricao?");
            String descricao = get_text(sc);

            System.out.println("Qual a quantidade total?");
            int qntdTotal = sc.nextInt();

            System.out.println("Qual a quantidade disponivel?");
            int qntdDisp = sc.nextInt();

            Equipamento novo_equipamento = new Equipamento();
            novo_equipamento.setDescricao(descricao);
            novo_equipamento.setQuantidadeTotal(qntdTotal);
            novo_equipamento.setQuantidadeDisponivel(qntdDisp);

            equipamentoModel.adicionarEquipamento(novo_equipamento);
            equipamentoView.exibirMensagem("Equipamento adicionado com sucesso!");
        } catch (Exception e) {
            throw new Exception("Erro ao inserir equipamento.");
        }
    }

    public void listarEquipamentos() throws Exception{
        try{
            List<Equipamento> equipamentos = equipamentoModel.listarEquipamentos();
            if (equipamentos.isEmpty()){
                equipamentoView.exibirMensagem("Nenhum equipamento cadastrado.");
            } else{
                equipamentoView.imprimirEquipamentos(equipamentos);
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Erro ao exibir equipamentos.");
        }
    }

    public Equipamento buscarPorDescricao(Scanner sc) throws Exception{
        System.out.println("Qual a descricao do item que voce deseja visualizar? ");
        String descricao_buscada = get_text(sc);

        return equipamentoModel.obterEquipamento_byDescricao(descricao_buscada);
    }

    public Equipamento buscar_por_id(int id) throws Exception{
        return equipamentoModel.obterEquipamento_byId(id);
    }

    public void modificarEquipamento(Scanner sc) throws Exception {
        try{
            listarEquipamentos();
            System.out.println("Qual o Id do item que voce deseja modificar? ");
            int id = sc.nextInt();

            System.out.println("Qual a nova descricao?");
            String novaDescricao = get_text(sc);

            System.out.println("Qual a nova quantidade total?");
            int novaQntdTotal = sc.nextInt();

            System.out.println("Qual a nova quantidade disponivel?");
            int novaQntdDisp = sc.nextInt();

            Equipamento equipamento_modificado = new Equipamento();
            equipamento_modificado.setDescricao(novaDescricao);
            equipamento_modificado.setQuantidadeTotal(novaQntdTotal);
            equipamento_modificado.setQuantidadeDisponivel(novaQntdDisp);

            equipamentoModel.modificarEquipamento(id, equipamento_modificado);
        } catch (Exception e){
            throw new Exception("Erro ao modificar equipamento.");
        }
    }

    public void removerEquipamento(Scanner sc) throws Exception{
        System.out.println("Qual o id do equipamento que voce deseja remover? ");
        listarEquipamentos();
        int idEquipamento = sc.nextInt();

        if (buscar_por_id(idEquipamento) != null){
            equipamentoModel.deletarEquipamento(idEquipamento);
            equipamentoView.exibirMensagem("Equipamento excluido com sucesso!");
        } else{
            System.out.println("Equipamento nao existe.");
        }
    }

}
