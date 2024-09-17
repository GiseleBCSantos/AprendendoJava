import classes.equipamento.Equipamento;
import classes.espaco.Espaco;
import classes.funcionario.Funcionario;
import classes.reserva.Reserva;
import controllers.EquipamentoController;
import controllers.EspacoController;
import controllers.FuncionarioController;
import controllers.ReservaController;

import static utils.Utils.get_number_in_range;


import java.sql.SQLException;
import java.util.Scanner;

public class MainMVC {
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
                            equipamentoController.inserir_equipamento(sc);
                        }
                        catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        equipamentoController.listar_equipamentos();
                        break;
                    case 3:
                        Equipamento equipamento = equipamentoController.buscar_por_descricao(sc);
                        System.out.println(equipamento != null ? equipamento : "Equipamento nao encontrado.");
                        break;
                    case 4:
                        try{
                            equipamentoController.modificar_equipamento(sc);
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try{
                            equipamentoController.remover_equipamento(sc);
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
                            espacoController.inserir_espaco(sc);
                        } catch (SQLException e) {
                            System.out.println("Erro ao adicionar espaco.");
                        }
                        break;

                    case 2:
                        espacoController.listar_espacos();
                        break;

                    case 3:
                        Espaco espaco = espacoController.buscar_por_descricao(sc);
                        System.out.println(espaco != null ? espaco : "Espaco nao encontrado.");
                        break;

                    case 4:
                        try{
                            espacoController.modificar_espaco(sc);
                        } catch (SQLException e) {
                            System.out.println("Erro ao modificar espaco.");
                        }
                        break;

                    case 5:
                        try{
                            espacoController.remover_espaco(sc);
                        } catch (SQLException e) {
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
                        } catch (SQLException e) {
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
                        } catch (SQLException e) {
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
                            reservaController.inserir_reserva(sc);
                        } catch (SQLException e) {
                            System.out.println("Erro ao inserir reserva.");
                        }
                        break;
                    case 2:
                        reservaController.listar_reservas();
                        break;
                    case 3:
                        Reserva reserva = reservaController.exibir_reserva_porData_porNome(sc);
                        System.out.println(reserva != null ? reserva : "Reserva nao encontrada.");
                        break;
                    case 4:
                        try{
                            reservaController.deletar_reserva(sc);
                        } catch (SQLException e) {
                            System.out.println("Erro ao deletar reserva.");
                        }
                        break;

                }
            }


        }
    }

}