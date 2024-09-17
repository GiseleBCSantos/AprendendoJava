package dao;

import entities.Equipamento;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EquipamentoDao {


    public void add(Equipamento equipamento){
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        manager.persist(equipamento);

        tx.commit();
        manager.close();
        HibernateUtil.close();
    }

    public void list_all(){
        EntityManager manager = HibernateUtil.getEntityManager();
        
    }
}
