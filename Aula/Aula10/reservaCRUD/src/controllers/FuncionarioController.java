package controllers;

import classes.espaco.Espaco;
import classes.funcionario.Chefia;
import classes.funcionario.Funcionario;
import classes.funcionario.Vigia;
import models.FuncionarioModel;
import views.FuncionarioView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import static utils.Utils.get_text;
import static utils.Utils.get_number_in_range;

public class FuncionarioController {
    private FuncionarioModel funcionarioModel;
    private FuncionarioView funcionarioView;

    public FuncionarioController() throws SQLException {
        this.funcionarioModel = new FuncionarioModel();
        this.funcionarioView = new FuncionarioView();
    }

    public void inserir_funcionario(Scanner sc) throws SQLException{
        System.out.println("Qual tipo de funcionario deseja adicionar? " +
                "\n1) Vigia" +
                "\n2) Chefia");
        int tipo_funcionario = get_number_in_range(sc, 1, 2);

        System.out.println("Qual o nome do funcionario?");
        String novo_nome = get_text(sc);
        System.out.println("Qual o email do funcionario?");
        String novo_email = sc.nextLine();
        Funcionario funcionario = null;

        if (tipo_funcionario == 1){
            funcionario = new Vigia(novo_nome, novo_email);

        } else{
            System.out.println("Qual o cargo do funcionario?");
            String novo_cargo = sc.nextLine();
            System.out.println("Qual o setor do funcionario?");
            String novo_setor = sc.nextLine();
            System.out.println("Qual a senha do funcionario?");
            int nova_senha = sc.nextInt();

            funcionario = new Chefia(novo_nome, novo_email, novo_cargo, novo_setor, nova_senha);
        }

        if (funcionario != null){
            funcionarioModel.add(funcionario);
            funcionarioView.exibir_mensagem("Funcionario adicionado com sucesso!");
        } else{
            System.out.println("Falha ao adicionar funcionario.");
        }
    }

    public void listar_funcionarios() throws SQLException{
        List<Funcionario> funcionarios = funcionarioModel.get_list();
        if (funcionarios.isEmpty()){
            funcionarioView.exibir_mensagem("Nenhum espaco cadastrado.");
        }else{
            funcionarioView.imprimir_funcionarios(funcionarios);
        }
    }

    public Funcionario buscar_porNome(Scanner sc) throws SQLException{
        System.out.println("Qual o nome do funcionario que voce deseja visualizar? ");
        String nome_buscado = get_text(sc);
        return funcionarioModel.get_item_byName(nome_buscado);
    }

    public Funcionario buscar_porId(int id) throws SQLException{
        return funcionarioModel.get_item_byId(id);
    }

    public void modificar_funcionario(Scanner sc) throws SQLException{
        listar_funcionarios();
        System.out.println("Qual o Id do funcionario que voce deseja modificar? ");
        int id = sc.nextInt();

        Funcionario funcionario_para_atualizar = buscar_porId(id);
        Funcionario funcionario_modificado = null;

        System.out.println("Qual o novo nome?");
        String novoNome = get_text(sc);

        System.out.println("Qual o novo email?");
        String novoEmail = sc.nextLine();

        if (!(funcionario_para_atualizar instanceof Chefia)){
            funcionario_modificado = new Vigia(novoNome, novoEmail);
        } else{
            System.out.println("Qual o novo cargo?");
            String novoCargo = sc.nextLine();

            System.out.println("Qual o novo setor?");
            String novoSetor = sc.nextLine();

            System.out.println("Qual a nova senha?");
            int novaSenha = sc.nextInt();

            funcionario_modificado = new Chefia(novoNome, novoEmail, novoCargo, novoSetor, novaSenha);
        }

        if (funcionario_modificado != null){
            funcionarioModel.update(id, funcionario_modificado);
            funcionarioView.exibir_mensagem("Funcionario alterado com sucesso!");
        } else{
            System.out.println("Falha ao modificar funcionario.");
        }
    }

    public void remover_funcionario(Scanner sc) throws SQLException{
        System.out.println("Qual o id do funcionario que voce deseja remover? ");
        listar_funcionarios();
        int idFuncionario = sc.nextInt();

        if (buscar_porId(idFuncionario) != null){
            funcionarioModel.delete(idFuncionario);
            funcionarioView.exibir_mensagem("Funcionario deletado com sucesso!");
        } else{
            System.out.println("Funcionario nao existe.");
        }
    }


}
