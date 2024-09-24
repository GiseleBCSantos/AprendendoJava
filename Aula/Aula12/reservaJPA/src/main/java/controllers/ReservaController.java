package controllers;

import entities.*;
import models.EquipamentoModel;
import models.EspacoModel;
import models.FuncionarioModel;
import models.ReservaModel;
import views.EquipamentoView;
import views.EspacoView;
import views.FuncionarioView;
import views.ReservaView;

import java.util.List;
import java.util.Scanner;

import static util.Utils.get_number_in_range;
import static util.Utils.get_text;

public class ReservaController {
    private ReservaModel reservaModel;
    private ReservaView reservaView;
    private EquipamentoModel equipamentoModel;
    private EquipamentoView equipamentoView;
    private EspacoModel espacoModel;
    private EspacoView espacoView;
    private FuncionarioModel funcionarioModel;
    private FuncionarioView funcionarioView;

    public ReservaController() {
        this.reservaModel = new ReservaModel();
        this.reservaView = new ReservaView();
        this.equipamentoModel = new EquipamentoModel();
        this.equipamentoView = new EquipamentoView();
        this.espacoModel = new EspacoModel();
        this.espacoView = new EspacoView();
        this.funcionarioModel = new FuncionarioModel();
        this.funcionarioView = new FuncionarioView();
    }

    public void inserirReserva(Scanner sc) throws Exception {
        System.out.println("Qual tipo de reserva deseja adicionar? " +
                "\n1) Equipamento" +
                "\n2) Espaco");
        int tipo_reserva = get_number_in_range(sc, 1, 2);

        List<Funcionario> lista_func = funcionarioModel.listarFuncionarios();
        funcionarioView.imprimirFuncionarios(lista_func);
        System.out.println("Qual o codigo do funcionario?");
        int codigo_func = sc.nextInt();
        Funcionario funcionario_desejado = funcionarioModel.obterFuncionario_byId(codigo_func);



        Reserva reserva = null;

        if (tipo_reserva == 1){
            List<Equipamento> lista_equip = equipamentoModel.listarEquipamentos();
            equipamentoView.imprimirEquipamentos(lista_equip);
            System.out.println("Qual o id do equipamento que deseja? ");
            int id_desejado = sc.nextInt();
            Equipamento equipamento_reservado = equipamentoModel.obterEquipamento_byId(id_desejado);

            if (funcionario_desejado != null && equipamento_reservado != null && equipamento_reservado.getQuantidadeDisponivel() > 0){
                reserva = new Reserva();
                reserva.setSolicitante(funcionario_desejado);
                reserva.setEquipamento(equipamento_reservado);
                reservaModel.reservarEquipamento(equipamento_reservado);
            }
        }
        else{
            if (funcionario_desejado instanceof Chefia){
                System.out.println("Insira sua senha: ");
                int senha = sc.nextInt();
                if (funcionarioModel.autenticarFuncionario(((Chefia) funcionario_desejado), senha)){

                    List<Espaco> lista_espacos = espacoModel.listarEspacos();
                    espacoView.imprimirEspacos(lista_espacos);
                    System.out.println("Qual o id do espaco que deseja? ");
                    int id_desejado = sc.nextInt();
                    Espaco espaco_reservado = espacoModel.obterEspaco_byId(id_desejado);

                    if (funcionario_desejado != null && espaco_reservado != null && espaco_reservado.isStatus()) {
                        reserva = new Reserva();

                        reserva.setSolicitante(funcionario_desejado);
                        reserva.setEspaco(espaco_reservado);
                        reservaModel.reservarEspaco(espaco_reservado);
                    }
                }
            }
        }


        if (reserva != null){
            System.out.println("Qual a data para reserva?");
            String data = get_text(sc);
            reserva.setData(data);
            reservaModel.adicionarReserva(reserva);
            reservaView.exibirMensagem("Reserva adicionada com sucesso!");
            reservaView.enviarEmail(funcionario_desejado.getEmail(), data);
        }else{
            System.out.println("Falha ao adicionar reserva.");
        }
    }

    public void listarReservas() throws Exception{
        List<Reserva> reservas = reservaModel.listarReservas();
        if (reservas.isEmpty()){
            reservaView.exibirMensagem("Nenhuma reserva cadastrada.");
        }else{
            reservaView.imprimirReservas(reservas);
        }
    }

    public Reserva exibir_reserva_porId(int id) throws  Exception{
        return reservaModel.obterReserva_byId(id);
    }

    public Reserva exibirReserva_porData_porNome(Scanner sc) throws Exception{
        System.out.println("Qual o nome do funcionario? ");
        String nome = get_text(sc);

        System.out.println("Qual a data da reserva? ");
        String data = sc.nextLine();

        return reservaModel.obterReserva_byNome_byData(nome, data);
    }

    public void deletarReserva(Scanner sc) throws Exception {
        listarReservas();

        if (! reservaModel.listarReservas().isEmpty()){
            System.out.println("Qual o id da reserva que voce deseja remover? ");
            int idReserva = sc.nextInt();

            if (exibir_reserva_porId(idReserva) != null){
                reservaModel.deletarReserva(idReserva);
                reservaView.exibirMensagem("Reserva deletada com sucesso!");
            } else{
                System.out.println("Reserva nao existe.");
            }
        }
    }
}
