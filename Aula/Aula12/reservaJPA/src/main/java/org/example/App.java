package org.example;

import dao.EquipamentoDao;
import dao.EspacoDao;
import dao.FuncionarioDao;
import dao.ReservaDao;
import entities.*;

import java.util.List;
import static util.Utils.pressEnterToContinue;
import static util.Utils.imprimirComentario;

public class App 
{
    public static void main( String[] args ) throws Exception {

        System.out.println("******** Area equipamento ********");
        EquipamentoDao equipamentoDao = new EquipamentoDao();
        imprimirComentario("Criacao de tabelas");
        pressEnterToContinue();

        Equipamento equipamento = new Equipamento();
        equipamento.setDescricao("Monitor1");
        equipamento.setQuantidadeDisponivel(10);
        equipamento.setQuantidadeTotal(15);

        equipamentoDao.add(equipamento);
        imprimirComentario("Equipamento adicionado");
        pressEnterToContinue();

        List<Equipamento> lista = equipamentoDao.list_all();
        System.out.println(lista);
        imprimirComentario("Lista equipamento exibida");
        pressEnterToContinue();

        System.out.println("--------------------------");
        Equipamento monitor = equipamentoDao.get_byDescricao("Monitor");
        System.out.println(monitor);
        imprimirComentario("Equipamento exibido por descricao");
        pressEnterToContinue();

        System.out.println("--------------------------");
        Equipamento eq = equipamentoDao.get_byId(3);
        System.out.println(eq);
        imprimirComentario("Equipamento exibido por id");
        pressEnterToContinue();

        System.out.println("--------------------------");
        Equipamento equipamento1 = new Equipamento();
        equipamento1.setDescricao("Monitor 21''");
        equipamento1.setQuantidadeTotal(3);
        equipamento1.setQuantidadeDisponivel(1);
        equipamentoDao.update(4, equipamento1);
        System.out.println(equipamentoDao.get_byId(4));
        System.out.println("Equipamento modificado");
        pressEnterToContinue();

        System.out.println("--------------------------");
        equipamentoDao.delete(4);
        System.out.println("Equipamento deletado");
        pressEnterToContinue();

        List<Equipamento> lista2 = equipamentoDao.list_all();
        System.out.println(lista2);
        System.out.println("Exibir lista equipamentos");
        pressEnterToContinue();

        System.out.println("********** Fim Area Equipamento **********\n\n");


        System.out.println("******** Area espaco ********");
        EspacoDao espacoDao = new EspacoDao();

        Espaco espaco = new Espaco();
        espaco.setDescricao("B3-18");
//
        espacoDao.add(espaco);
        System.out.println("Espaco adicionado");
        pressEnterToContinue();
//
        System.out.println("---------------");

        List<Espaco> listaEspacos = espacoDao.list_all();

        System.out.println(listaEspacos);
        System.out.println("Lista espacos exibida");
        pressEnterToContinue();

        System.out.println("---------------");

        Espaco espaco1 = espacoDao.get_byDescricao("B3-10");
        System.out.println(espaco1);

        System.out.println("Espaco exibido por descricao");
        pressEnterToContinue();
        System.out.println("---------------");

        Espaco espaco2 = espacoDao.get_byId(2);
        System.out.println(espaco2);

        System.out.println("Espaco exibido por id");
        pressEnterToContinue();

        System.out.println("---------------");

        Espaco espaco3 = new Espaco();
        espaco3.setDescricao("B3-181");
        espaco3.setStatus(true);
        espacoDao.update(4, espaco3);
        Espaco espaco4 = espacoDao.get_byId(4);

        System.out.println(espaco4);
        System.out.println("Espaco modificado");
        pressEnterToContinue();

        System.out.println("---------------");

        espacoDao.delete(4);
        System.out.println("Espaco deletado");
        pressEnterToContinue();

        System.out.println("********** Fim Area Espaco **********");


        System.out.println("******** Area Funcionario ********");

        FuncionarioDao funcionarioDao = new FuncionarioDao();
//
        Vigia vigia = new Vigia();
        vigia.setNome("Jose");
        vigia.setEmail("jose@gmail.com");

        Chefia chefia = new Chefia();
        chefia.setNome("Josefa");
        chefia.setEmail("josefa@gmail.com");
        chefia.setCargo("Gerente");
        chefia.setSetor("Financeiro");
        chefia.setSenha(1234);

        funcionarioDao.add(vigia);
        System.out.println("Vigia adicionado");
        pressEnterToContinue();

        funcionarioDao.add(chefia);
        System.out.println("Chefia adicionado");
        pressEnterToContinue();
//
        System.out.println("--------------------------");

        Funcionario funcionario = funcionarioDao.get_byId(2);
        System.out.println(funcionario);
        System.out.println("Obter funcionario por id");
        pressEnterToContinue();

        System.out.println("--------------------------");

        List<Funcionario> listaFunc = funcionarioDao.list_all();
        System.out.println(listaFunc);
        System.out.println("Obter lista funcionarios");
        pressEnterToContinue();

        System.out.println("--------------------------");

        Funcionario funcionario2 = funcionarioDao.get_byNome("Josefa");
        System.out.println(funcionario2);
        System.out.println("Obter funcionario por nome");
        pressEnterToContinue();

        System.out.println("--------------------------");

        Chefia chefia1 = new Chefia();
        chefia1.setNome("Joao");
        chefia1.setEmail("joao@gmail.com");
        chefia1.setCargo("Agente de marketing");
        chefia1.setSetor("Publicitario");
        chefia1.setSenha(1234);

        funcionarioDao.update(2, chefia1);
        System.out.println("Alterar funcionario chefia");
        pressEnterToContinue();

        Funcionario vigia1 = new Vigia();
        vigia1.setNome("Claudio");
        vigia1.setEmail("claudio@gmail.com");

        funcionarioDao.update(1, vigia1);
        System.out.println("Alterar funcionario vigia");
        pressEnterToContinue();

        System.out.println("--------------------------");

        funcionarioDao.delete(1);
        System.out.println("Deletar funcionario");
        pressEnterToContinue();

        System.out.println("********** Fim Area Funcionario **********");


        System.out.println("******** Area Reserva ********");
        ReservaDao reservaDao = new ReservaDao();

        Reserva reserva = new Reserva();
        reserva.setData("15/05/2025");
        reserva.setSolicitante(chefia);
        reserva.setEquipamento(equipamento);


        Reserva reserva2 = new Reserva();
        reserva2.setData("15/05/2025");
        reserva2.setSolicitante(vigia);
        reserva2.setEspaco(espaco);


        reservaDao.add(reserva);
        System.out.println("Reserva adicionada");
        pressEnterToContinue();

        try{
            reservaDao.add(reserva2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Tentar adicionar reserva com erro pois e funcionario comum.");
        pressEnterToContinue();

        System.out.println("----------------------------");

        List<Reserva> listaReserva = reservaDao.list_all();

        System.out.println(listaReserva);
        System.out.println("Listar reservas");
        pressEnterToContinue();

        System.out.println("----------------------------");

        Reserva reserva1 = reservaDao.get_byId(1);
        System.out.println(reserva1);
        System.out.println("Listar reserva por id");
        pressEnterToContinue();

        System.out.println("----------------------------");

        Reserva reserva3 = reservaDao.get_byNome_byData("Joao", "15/05/2025");
        System.out.println(reserva3);
        System.out.println("Listar reserva por nome e data");
        pressEnterToContinue();

        System.out.println("----------------------------");

        Reserva reserva_modificada = new Reserva();
        reserva_modificada.setSolicitante(chefia);
        reserva_modificada.setEspaco(espaco);
        reserva_modificada.setData("24/05/2052");

        try{
            reservaDao.update(1, reserva_modificada);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Tentar modificar reserva (trocando de um tipo de reserva para outra)");
        pressEnterToContinue();

        Reserva reserva_modificada2 = new Reserva();
        reserva_modificada2.setSolicitante(chefia);
        reserva_modificada2.setEquipamento(equipamento);
        reserva_modificada2.setData("24/05/2052");

        reservaDao.update(1, reserva_modificada2);

        System.out.println("Modificar reserva");
        pressEnterToContinue();
//

        System.out.println("-----------------------");

        reservaDao.delete(1);
        System.out.println("deletar reserva");
        pressEnterToContinue();

        System.out.println("********** Fim Area Reserva **********");

//
































    }
}
