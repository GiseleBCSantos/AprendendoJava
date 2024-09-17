package org.example;

import dao.EquipamentoDao;
import entities.Equipamento;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        EquipamentoDao equipamentoDao = new EquipamentoDao();

        Equipamento equipamento = new Equipamento();
        equipamento.setDescricao("Monitor");
        equipamento.setQuantidadeDisponivel(10);
        equipamento.setQuantidadeTotal(15);

        equipamentoDao.add(equipamento);
    }
}
