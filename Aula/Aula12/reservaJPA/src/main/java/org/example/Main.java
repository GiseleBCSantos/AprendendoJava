package org.example;

import controllers.EquipamentoController;
import controllers.EspacoController;
import controllers.FuncionarioController;
import controllers.ReservaController;
import entities.Equipamento;
import entities.Espaco;
import entities.Funcionario;
import entities.Reserva;

import java.util.Scanner;

import static util.Utils.get_number_in_range;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = null;
        boolean app_on = true;

        EquipamentoController equipamentoController = new EquipamentoController();
        EspacoController espacoController = new EspacoController();
        FuncionarioController funcionarioController = new FuncionarioController();
        ReservaController reservaController = new ReservaController();

        System.out.println("**** Testes MVC ****");


        while (app_on){
            sc = new Scanner(System.in);
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
                        try{
                            equipamentoController.adicionarEquipamento(sc);
                        }
                        catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        equipamentoController.listarEquipamentos();
                        break;
                    case 3:
                        Equipamento equipamento = equipamentoController.buscarPorDescricao(sc);
                        System.out.println(equipamento != null ? equipamento : "Equipamento nao encontrado.");
                        break;
                    case 4:
                        try{
                            equipamentoController.modificarEquipamento(sc);
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try{
                            equipamentoController.removerEquipamento(sc);
                        } catch (Exception e){
                            System.out.println("Erro ao remover equipamento.");
                        }
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
                        try{
                            espacoController.inserirEspaco(sc);
                        } catch (Exception e) {
                            System.out.println("Erro ao adicionar espaco.");
                        }
                        break;

                    case 2:
                        espacoController.listarEspacos();
                        break;

                    case 3:
                        Espaco espaco = espacoController.buscarPorDescricao(sc);
                        System.out.println(espaco != null ? espaco : "Espaco nao encontrado.");
                        break;

                    case 4:
                        try{
                            espacoController.modificarEspaco(sc);
                        } catch (Exception e) {
                            System.out.println("Erro ao modificar espaco.");
                        }
                        break;

                    case 5:
                        try{
                            espacoController.removerEspaco(sc);
                        } catch (Exception e) {
                            System.out.println("Erro ao remover espaco.");
                        }
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
                        try{
                            funcionarioController.inserir_funcionario(sc);
                        } catch (Exception e) {
                            System.out.println("Erro ao inserir funcionario.");
                        }
                        break;
                    case 2:
                        funcionarioController.listar_funcionarios();
                        break;
                    case 3:

                        Funcionario funcionario = funcionarioController.buscar_porNome(sc);
                        System.out.println(funcionario != null ? funcionario : "Funcionario nao encontrado.");
                        break;
                    case 4:
                        try{
                            funcionarioController.modificar_funcionario(sc);
                        } catch (Exception e) {
                            System.out.println("Erro ao modificar funcionario.");
                        }
                        break;
                    case 5:
                        try{
                            funcionarioController.remover_funcionario(sc);
                        } catch (Exception e){
                            System.out.println("Erro ao remover funcionario.");
                        }
                        break;
                }
            }

            if (obj_administrado == 4){
                System.out.println("*** CRUD RESERVAS ***");

                System.out.println("\nSelecione o que deseja fazer: " +
                        "\n1) Adicionar;" +
                        "\n2) Listar todos;" +
                        "\n3) Exibir por funcionario e data" +
                        "\n4) Remover");
                int opcao_crud = get_number_in_range(sc, 1, 5);

                switch (opcao_crud){
                    case 1:
                        try{
                            reservaController.inserirReserva(sc);
                        } catch (Exception e) {
                            System.out.println("Erro ao inserir reserva.");
                        }
                        break;
                    case 2:
                        reservaController.listarReservas();
                        break;
                    case 3:
                        Reserva reserva = reservaController.exibirReserva_porData_porNome(sc);
                        System.out.println(reserva != null ? reserva : "Reserva nao encontrada.");
                        break;
                    case 4:
                        try{
                            reservaController.deletarReserva(sc);
                        } catch (Exception e) {
                            System.out.println("Erro ao deletar reserva.");
                        }
                        break;

                }
            }


        }
    }
}
