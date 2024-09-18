package org.example;

import dao.EquipamentoDao;
import dao.EspacoDao;
import dao.FuncionarioDao;
import entities.*;
import org.hibernate.sql.CacheJoinFragment;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
//        EquipamentoDao equipamentoDao = new EquipamentoDao();
//
//        Equipamento equipamento = new Equipamento();
//        equipamento.setDescricao("Monitor1");
//        equipamento.setQuantidadeDisponivel(10);
//        equipamento.setQuantidadeTotal(15);
//
//        equipamentoDao.add(equipamento);
//
//        List<Equipamento> lista = equipamentoDao.list_all();
//        System.out.println(lista);
//
//        System.out.println("--------------------------");
//        Equipamento monitor = equipamentoDao.get_byDescricao("Monitor");
//        System.out.println(monitor);
//
//        System.out.println("--------------------------");
//        Equipamento eq = equipamentoDao.get_byId(3);
//        System.out.println(eq);
//
//        System.out.println("--------------------------");
//        Equipamento equipamento1 = new Equipamento();
//        equipamento1.setDescricao("Monitor 21''");
//        equipamento1.setQuantidadeTotal(3);
//        equipamento1.setQuantidadeDisponivel(1);
//        equipamentoDao.update(4, equipamento1);
//        System.out.println(equipamentoDao.get_byId(4));
//
//        System.out.println("--------------------------");
//        equipamentoDao.delete(4);
//        List<Equipamento> lista2 = equipamentoDao.list_all();
//        System.out.println(lista2);

//        EspacoDao espacoDao = new EspacoDao();
//
//        Espaco espaco = new Espaco();
//        espaco.setDescricao("B3-18");
//
//        espacoDao.add(espaco);
//
//        System.out.println("---------------");
//
//        List<Espaco> listaEspacos = espacoDao.list_all();
//
//        System.out.println(listaEspacos);
//
//        System.out.println("---------------");
//
//        Espaco espaco1 = espacoDao.get_byDescricao("B3-10");
//
//        System.out.println(espaco1);
//        System.out.println("---------------");
//
//        Espaco espaco2 = espacoDao.get_byId(2);
//        System.out.println(espaco2);
//
//        System.out.println("---------------");
//
//        Espaco espaco3 = new Espaco();
//        espaco3.setDescricao("B3-181");
//        espaco3.setStatus(true);
//        espacoDao.update(4, espaco3);
//        Espaco espaco4 = espacoDao.get_byId(4);
//
//        System.out.println(espaco4);
//
//        System.out.println("---------------");
//
//        espacoDao.delete(4);


        FuncionarioDao funcionarioDao = new FuncionarioDao();

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
        funcionarioDao.add(chefia);

        System.out.println("--------------------------");

        Funcionario funcionario = funcionarioDao.get_byId(2);
        System.out.println(funcionario);

        System.out.println("--------------------------");

        List<Funcionario> listaFunc = funcionarioDao.list_all();
        System.out.println(listaFunc);

        System.out.println("--------------------------");

        Funcionario funcionario2 = funcionarioDao.get_byNome("Josefa");
        System.out.println(funcionario2);

        System.out.println("--------------------------");

        Chefia chefia1 = new Chefia();
        chefia1.setNome("Joao");
        chefia1.setEmail("joao@gmail.com");
        chefia1.setCargo("Agente de marketing");
        chefia1.setSetor("Publicitario");
        chefia1.setSenha(1234);

        funcionarioDao.update(2, chefia1);

        Funcionario vigia1 = new Vigia();
        vigia1.setNome("Claudio");
        vigia1.setEmail("claudio@gmail.com");

        funcionarioDao.update(1, vigia1);

        System.out.println("--------------------------");

        funcionarioDao.delete(1);



































    }
}
