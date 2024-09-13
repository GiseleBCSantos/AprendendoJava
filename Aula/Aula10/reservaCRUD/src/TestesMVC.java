import classes.equipamento.Equipamento;
import classes.espaco.Espaco;
import classes.funcionario.Chefia;
import classes.funcionario.Funcionario;
import classes.funcionario.Vigia;
import controllers.EquipamentoController;
import controllers.EspacoController;
import controllers.FuncionarioController;
import controllers.ReservaController;
import models.EquipamentoModel;
import models.EspacoModel;
import models.FuncionarioModel;
import models.ReservaModel;
import views.EquipamentoView;
import views.EspacoView;
import views.FuncionarioView;
import views.ReservaView;

import java.sql.SQLException;
import java.util.Scanner;

public class TestesMVC {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("**** Testes MVC ****");

        boolean app_on = true;

        EquipamentoModel equipamentoModel = new EquipamentoModel();
        EquipamentoView equipamentoView = new EquipamentoView();
        EquipamentoController equipamentoController = new EquipamentoController(equipamentoModel, equipamentoView);

        EspacoModel espacoModel = new EspacoModel();
        EspacoView espacoView = new EspacoView();
        EspacoController espacoController = new EspacoController(espacoModel, espacoView);

        FuncionarioModel funcionarioModel = new FuncionarioModel();
        FuncionarioView funcionarioView = new FuncionarioView();
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioModel, funcionarioView);

        ReservaModel reservaModel = new ReservaModel();
        ReservaView reservaView = new ReservaView();
        ReservaController reservaController = new ReservaController(reservaModel, reservaView);

        while (app_on){
            System.out.println("\nSelecione o que deseja administrar: " +
                                "\n1) Equipamentos;" +
                                "\n2) Espacos;" +
                                "\n3) Funcionarios" +
                                "\n4) Reservas");
            int obj_administrado = get_number_in_range(sc, 1, 4);

            if (obj_administrado == 1){


                System.out.println("*** CRUD EQUIPAMENTOS ***");
                System.out.println("\nSelecione o que deseja fazer: " +
                        "\n1) Adicionar;" +
                        "\n2) Listar todos;" +
                        "\n3) Exibir por nome" +
                        "\n4) Modificar" +
                        "\n5) Remover");
                int opcao_crud = get_number_in_range(sc, 1, 5);

                switch (opcao_crud){
                    case 1:
                        System.out.println("Qual a descricao?");
                        String descricao = get_text(sc);

                        System.out.println("Qual a quantidade total?");
                        int qntdTotal = sc.nextInt();

                        System.out.println("Qual a quantidade disponivel?");
                        int qntdDisp = sc.nextInt();

                        Equipamento novo_equipamento = new Equipamento(descricao, qntdTotal, qntdDisp);
                        equipamentoController.inserir_equipamento(novo_equipamento);
                        break;
                    case 2:
                        equipamentoController.listar_equipamentos();
                        break;
                    case 3:
                        System.out.println("Qual a descricao do item que voce deseja visualizar? ");
                        String descricao_buscada = get_text(sc);
                        Equipamento equipamento = equipamentoController.buscar_por_descricao(descricao_buscada);
                        System.out.println(equipamento);
                        break;
                    case 4:
                        equipamentoController.listar_equipamentos();
                        System.out.println("Qual o Id do item que voce deseja modificar? ");
                        int id = sc.nextInt();

                        System.out.println("Qual a nova descricao?");
                        String novaDescricao = get_text(sc);

                        System.out.println("Qual a nova quantidade total?");
                        int novaQntdTotal = sc.nextInt();

                        System.out.println("Qual a nova quantidade disponivel?");
                        int novaQntdDisp = sc.nextInt();

                        Equipamento equipamento_modificado = new Equipamento(novaDescricao, novaQntdTotal, novaQntdDisp);

                        equipamentoController.modificar_equipamento(id, equipamento_modificado);
                        break;
                    case 5:
                        System.out.println("Qual o id do equipamento que voce deseja remover? ");
                        equipamentoController.listar_equipamentos();
                        int idEquipamento = sc.nextInt();
                        equipamentoController.remover_equipamento(idEquipamento);
                        break;
                }
            }

            if (obj_administrado == 2){
                System.out.println("*** CRUD ESPACOS ***");

                System.out.println("\nSelecione o que deseja fazer: " +
                        "\n1) Adicionar;" +
                        "\n2) Listar todos;" +
                        "\n3) Exibir por nome" +
                        "\n4) Modificar" +
                        "\n5) Remover");
                int opcao_crud = get_number_in_range(sc, 1, 5);

                switch (opcao_crud){
                    case 1:
                        System.out.println("Qual a descricao?");
                        String descricao = get_text(sc);

                        System.out.println("Ele esta disponivel? (1-sim) (2-nao)");
                        boolean desocupado = sc.nextInt() == 1;


                        Espaco novo_espaco = new Espaco(descricao, desocupado);
                        espacoController.inserir_espaco(novo_espaco);
                        break;
                    case 2:
                        espacoController.listar_espacos();
                        break;
                    case 3:
                        System.out.println("Qual a descricao do item que voce deseja visualizar? ");
                        String descricao_buscada = get_text(sc);
                        Espaco espaco = espacoController.buscar_por_descricao(descricao_buscada);
                        System.out.println(espaco);
                        break;
                    case 4:
                        espacoController.listar_espacos();
                        System.out.println("Qual o Id do item que voce deseja modificar? ");
                        int id = sc.nextInt();

                        System.out.println("Qual a nova descricao?");
                        String novaDescricao = get_text(sc);

                        System.out.println("Ele esta disponivel? (1-sim) (2-nao)");
                        boolean desocupado_modificar = sc.nextInt() == 1;

                        Espaco espaco_modificado = new Espaco(novaDescricao, desocupado_modificar);

                        espacoController.modificar_espaco(id, espaco_modificado);
                        break;
                    case 5:
                        System.out.println("Qual o id do equipamento que voce deseja remover? ");
                        espacoController.listar_espacos();
                        int idEspaco = sc.nextInt();
                        espacoController.remover_espaco(idEspaco);
                        break;
                }
            }

            if (obj_administrado == 3){


                System.out.println("*** CRUD FUNCIONARIOS ***");

                System.out.println("\nSelecione o que deseja fazer: " +
                        "\n1) Adicionar;" +
                        "\n2) Listar todos;" +
                        "\n3) Exibir por nome" +
                        "\n4) Modificar" +
                        "\n5) Remover");
                int opcao_crud = get_number_in_range(sc, 1, 5);

                switch (opcao_crud){
                    case 1:
                        System.out.println("Qual tipo de funcionario deseja adicionar? " +
                                "\n1) Vigia" +
                                "\n2) Chefia");
                        int tipo_funcionario = get_number_in_range(sc, 1, 2);

                        System.out.println("Qual o nome do funcionario?");
                        String novo_nome = get_text(sc);
                        System.out.println("Qual o email do funcionario?");
                        String novo_email = sc.nextLine();

                        if (tipo_funcionario == 1){
                            Vigia vigia = new Vigia(novo_nome, novo_email);
                            funcionarioController.inserir_funcionario(vigia);

                        } else{
                            System.out.println("Qual o cargo do funcionario?");
                            String novo_cargo = sc.nextLine();
                            System.out.println("Qual o setor do funcionario?");
                            String novo_setor = sc.nextLine();
                            System.out.println("Qual a senha do funcionario?");
                            int nova_senha = sc.nextInt();

                            Chefia chefia = new Chefia(novo_nome, novo_email, novo_cargo, novo_setor, nova_senha);
                            funcionarioController.inserir_funcionario(chefia);
                        }
                        break;
                    case 2:
                        funcionarioController.listar_funcionarios();
                        break;
                    case 3:
                        System.out.println("Qual o nome do funcionario que voce deseja visualizar? ");
                        String nome_buscado = get_text(sc);
                        Funcionario funcionario = funcionarioController.buscar_porNome(nome_buscado);
                        System.out.println(funcionario);
                        break;
                    case 4:
                        funcionarioController.listar_funcionarios();
                        System.out.println("Qual o Id do funcionario que voce deseja modificar? ");
                        int id = sc.nextInt();

                        Funcionario funcionario_para_atualizar = funcionarioController.buscar_porId(id);
                        Funcionario funcionario_modificado;

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


                        funcionarioController.modificar_funcionario(id, funcionario_modificado);
                        break;
                    case 5:
                        System.out.println("Qual o id do funcionario que voce deseja remover? ");
                        funcionarioController.listar_funcionarios();
                        int idFuncionario = sc.nextInt();
                        funcionarioController.remover_funcionario(idFuncionario);
                        break;
                }
            }

            if (obj_administrado == 4){
                System.out.println("*** CRUD RESERVAS ***");

                System.out.println("\nSelecione o que deseja fazer: " +
                        "\n1) Adicionar;" +
                        "\n2) Listar todos;" +
                        "\n3) Exibir por nome" +
                        "\n4) Modificar" +
                        "\n5) Remover");
                int opcao_crud = get_number_in_range(sc, 1, 5);

                switch (opcao_crud){
                    case 1:
                        System.out.println("Qual tipo de reserva deseja adicionar? " +
                                "\n1) Equipamento" +
                                "\n2) Espaco");
                        int tipo_reserva = get_number_in_range(sc, 1, 2);

                        System.out.println("Qual o nome do funcionario?");
                        String nome = get_text(sc);
                        Funcionario funcionario_a_reservar = funcionarioController.buscar_porNome(nome);
                        System.out.println("Qual a data para reserva?");
                        String data = sc.nextLine();

                        if (tipo_reserva == 1){
                            equipamentoController.listar_equipamentos();
                            System.out.println("Qual o id do equipamento que deseja? ");
                            int id_desejado = sc.nextInt();
                            Equipamento equipamento_reservado = equipamentoController.buscar_por_id(id_desejado);
                        }
                        else{
                            espacoController.listar_espacos();
                            System.out.println();
                        }


//                        if (tipo_funcionario == 1){
//                            Vigia vigia = new Vigia(novo_nome, novo_email);
//                            funcionarioController.inserir_funcionario(vigia);
//
//                        } else{
//                            System.out.println("Qual o cargo do funcionario?");
//                            String novo_cargo = sc.nextLine();
//                            System.out.println("Qual o setor do funcionario?");
//                            String novo_setor = sc.nextLine();
//                            System.out.println("Qual a senha do funcionario?");
//                            int nova_senha = sc.nextInt();
//
//                            Chefia chefia = new Chefia(novo_nome, novo_email, novo_cargo, novo_setor, nova_senha);
//                            funcionarioController.inserir_funcionario(chefia);
//                        }
                        break;
                    case 2:
                        funcionarioController.listar_funcionarios();
                        break;
                    case 3:
                        System.out.println("Qual o nome do funcionario que voce deseja visualizar? ");
                        String nome_buscado = get_text(sc);
                        Funcionario funcionario = funcionarioController.buscar_porNome(nome_buscado);
                        System.out.println(funcionario);
                        break;
                    case 4:
                        funcionarioController.listar_funcionarios();
                        System.out.println("Qual o Id do funcionario que voce deseja modificar? ");
                        int id = sc.nextInt();

                        Funcionario funcionario_para_atualizar = funcionarioController.buscar_porId(id);
                        Funcionario funcionario_modificado;

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


                        funcionarioController.modificar_funcionario(id, funcionario_modificado);
                        break;
                    case 5:
                        System.out.println("Qual o id do funcionario que voce deseja remover? ");
                        funcionarioController.listar_funcionarios();
                        int idFuncionario = sc.nextInt();
                        funcionarioController.remover_funcionario(idFuncionario);
                        break;

                }
            }


        }
    }

    public static int get_number_in_range(Scanner sc, int min, int max){
        int number = sc.nextInt();
        return number <= max && number >= min ? number : get_number_in_range(sc, min, max);
    }

    public static String get_text(Scanner sc){
        String _ = sc.nextLine();
        String text = sc.nextLine();
        return text;
    }
}
