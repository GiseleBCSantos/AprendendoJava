package controllers;

import classes.equipamento.Equipamento;
import classes.espaco.Espaco;
import classes.funcionario.Funcionario;
import classes.reserva.Reserva;
import models.EquipamentoModel;
import models.EspacoModel;
import models.FuncionarioModel;
import models.ReservaModel;
import views.EquipamentoView;
import views.EspacoView;
import views.FuncionarioView;
import views.ReservaView;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static utils.Utils.get_number_in_range;
import static utils.Utils.get_text;

public class ReservaController {
    private ReservaModel reservaModel;
    private ReservaView reservaView;
    private EquipamentoModel equipamentoModel;
    private EquipamentoView equipamentoView;
    private EspacoModel espacoModel;
    private EspacoView espacoView;
    private FuncionarioModel funcionarioModel;
    private FuncionarioView funcionarioView;

    public ReservaController() throws SQLException {
        this.reservaModel = new ReservaModel();
        this.reservaView = new ReservaView();
        this.equipamentoModel = new EquipamentoModel();
        this.equipamentoView = new EquipamentoView();
        this.espacoModel = new EspacoModel();
        this.espacoView = new EspacoView();
        this.funcionarioModel = new FuncionarioModel();
        this.funcionarioView = new FuncionarioView();
    }

    public void inserir_reserva(Scanner sc) throws SQLException {
        System.out.println("Qual tipo de reserva deseja adicionar? " +
                "\n1) Equipamento" +
                "\n2) Espaco");
        int tipo_reserva = get_number_in_range(sc, 1, 2);

        List<Funcionario> lista_func = funcionarioModel.get_list();
        funcionarioView.imprimir_funcionarios(lista_func);
        System.out.println("Qual o codigo do funcionario?");
        int codigo_func = sc.nextInt();
        Funcionario funcionario_desejado = funcionarioModel.get_item_byId(codigo_func);

        System.out.println("Qual a data para reserva?");
        String data = get_text(sc);

        Reserva reserva = null;

        if (tipo_reserva == 1){
            List<Equipamento> lista_equip = equipamentoModel.get_list();
            equipamentoView.imprimir_equipamentos(lista_equip);
            System.out.println("Qual o id do equipamento que deseja? ");
            int id_desejado = sc.nextInt();
            Equipamento equipamento_reservado = equipamentoModel.get_item_byId(id_desejado);

            if (funcionario_desejado != null && equipamento_reservado != null){
                reserva = new Reserva(data, funcionario_desejado, equipamento_reservado);
            }
        }
        else{
            List<Espaco> lista_espacos = espacoModel.get_list();
            espacoView.imprimir_espacos(lista_espacos);
            System.out.println("Qual o id do espaco que deseja? ");
            int id_desejado = sc.nextInt();
            Espaco espaco_reservado = espacoModel.get_item_byId(id_desejado);

            if (funcionario_desejado != null && espaco_reservado != null) {
                reserva = new Reserva(data, funcionario_desejado, espaco_reservado);
            }
        }

        if (reserva != null){
            reservaModel.add(reserva);
            reservaView.exibir_mensagem("Reserva adicionada com sucesso!");
        }else{
            System.out.println("Falha ao adicionar reserva.");
        }
    }

    public void listar_reservas() throws SQLException{
        List<Reserva> reservas = reservaModel.list_all();
        if (reservas.isEmpty()){
            reservaView.exibir_mensagem("Nenhuma reserva cadastrada.");
        }else{
            reservaView.imprimir_reservas(reservas);
        }
    }

    public Reserva exibir_reserva_porId(int id) throws  SQLException{
        return reservaModel.list_byId(id);
    }

    public Reserva exibir_reserva_porData_porNome(Scanner sc) throws SQLException{
        System.out.println("Qual o nome do funcionario? ");
        String nome = get_text(sc);

        System.out.println("Qual a data da reserva? ");
        String data = sc.nextLine();

        return reservaModel.list_item(nome, data);
    }

    public void deletar_reserva(Scanner sc) throws SQLException {
        listar_reservas();

        if (! reservaModel.list_all().isEmpty()){
            System.out.println("Qual o id da reserva que voce deseja remover? ");
            int idReserva = sc.nextInt();

            if (exibir_reserva_porId(idReserva) != null){
                reservaModel.delete(idReserva);
                reservaView.exibir_mensagem("Reserva deletada com sucesso!");
            } else{
                System.out.println("Reserva nao existe.");
            }
        }
    }
}
