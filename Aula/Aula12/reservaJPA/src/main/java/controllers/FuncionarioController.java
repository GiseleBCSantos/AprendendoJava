package controllers;

import entities.Chefia;
import entities.Funcionario;
import entities.Vigia;
import models.FuncionarioModel;
import views.FuncionarioView;

import java.util.List;
import java.util.Scanner;

import static util.Utils.get_number_in_range;
import static util.Utils.get_text;

public class FuncionarioController {
    private FuncionarioModel funcionarioModel;
    private FuncionarioView funcionarioView;

    public FuncionarioController() {
        this.funcionarioModel = new FuncionarioModel();
        this.funcionarioView = new FuncionarioView();
    }

    public void inserir_funcionario(Scanner sc) throws Exception{
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
            funcionario = new Vigia();
            funcionario.setNome(novo_nome);
            funcionario.setEmail(novo_email);

        } else{
            System.out.println("Qual o cargo do funcionario?");
            String novo_cargo = sc.nextLine();
            System.out.println("Qual o setor do funcionario?");
            String novo_setor = sc.nextLine();
            System.out.println("Qual a senha do funcionario?");
            int nova_senha = sc.nextInt();

            funcionario = new Chefia();
            funcionario.setNome(novo_nome);
            funcionario.setEmail(novo_email);
            ((Chefia) funcionario).setCargo(novo_cargo);
            ((Chefia) funcionario).setSetor(novo_setor);
            ((Chefia) funcionario).setSenha(nova_senha);
        }

        if (funcionario != null){
            funcionarioModel.adicionarFuncionario(funcionario);
            funcionarioView.exibirMensagem("Funcionario adicionado com sucesso!");
        } else{
            System.out.println("Falha ao adicionar funcionario.");
        }
    }

    public void listar_funcionarios() throws Exception{
        List<Funcionario> funcionarios = funcionarioModel.listarFuncionarios();
        if (funcionarios.isEmpty()){
            funcionarioView.exibirMensagem("Nenhum espaco cadastrado.");
        }else{
            funcionarioView.imprimirFuncionarios(funcionarios);
        }
    }

    public Funcionario buscar_porNome(Scanner sc) throws Exception{
        System.out.println("Qual o nome do funcionario que voce deseja visualizar? ");
        String nome_buscado = get_text(sc);
        return funcionarioModel.obterFuncionario_byNome(nome_buscado);
    }

    public Funcionario buscar_porId(int id) throws Exception{
        return funcionarioModel.obterFuncionario_byId(id);
    }

    public void modificar_funcionario(Scanner sc) throws Exception{
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
            funcionario_modificado = new Vigia();
            funcionario_modificado.setNome(novoNome);
            funcionario_modificado.setEmail(novoEmail);
        } else{
            System.out.println("Qual o novo cargo?");
            String novoCargo = sc.nextLine();

            System.out.println("Qual o novo setor?");
            String novoSetor = sc.nextLine();

            System.out.println("Qual a nova senha?");
            int novaSenha = sc.nextInt();

            funcionario_modificado = new Chefia();
            funcionario_modificado.setNome(novoNome);
            funcionario_modificado.setEmail(novoEmail);
            ((Chefia) funcionario_modificado).setCargo(novoCargo);
            ((Chefia) funcionario_modificado).setSetor(novoSetor);
            ((Chefia) funcionario_modificado).setSenha(novaSenha);
        }

        if (funcionario_modificado != null){
            funcionarioModel.modificarFuncionario(id, funcionario_modificado);
            funcionarioView.exibirMensagem("Funcionario alterado com sucesso!");
        } else{
            System.out.println("Falha ao modificar funcionario.");
        }
    }

    public void remover_funcionario(Scanner sc) throws Exception{
        System.out.println("Qual o id do funcionario que voce deseja remover? ");
        listar_funcionarios();
        int idFuncionario = sc.nextInt();

        if (buscar_porId(idFuncionario) != null){
            funcionarioModel.deletarFuncionario(idFuncionario);
            funcionarioView.exibirMensagem("Funcionario deletado com sucesso!");
        } else{
            System.out.println("Funcionario nao existe.");
        }
    }
}
