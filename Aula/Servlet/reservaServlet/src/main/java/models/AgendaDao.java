package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Agenda;
import util.HibernateUtil;

public class AgendaDao {

    public void add(Agenda agenda) {
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(agenda);
        tx.commit();

    }

    public List<Agenda> list_all() {
        EntityManager manager = HibernateUtil.getEntityManager();
            Query query = manager.createQuery("select a from Agenda a");
            List<Agenda> listaEquipamentos = query.getResultList();
            return listaEquipamentos;

    }

      

//        public Agenda get_byId(int id) throws Exception {
//            EntityManager manager = HibernateUtil.getEntityManager();
//            EntityTransaction tx = manager.getTransaction();
//            try{
//                tx.begin();
//                Agenda equipamento = manager.find(Agenda.class, id);
//                return equipamento;
//            } catch (Exception e) {
//                throw new Exception("Nenhum equipamento encontrado");
//            }
//            finally {
//                tx.commit();
//                manager.close();
//            }
//        }

//        public void update(int id, Agenda novo_equipamento) throws Exception {
//            EntityManager manager = HibernateUtil.getEntityManager();
//            EntityTransaction tx = manager.getTransaction();
//            try{
//                tx.begin();
//                Agenda equipamento = manager.find(Agenda.class, id);
//                equipamento.setId(id);
//                equipamento.setDescricao(novo_equipamento.getDescricao());
//                equipamento.setQuantidadeTotal(novo_equipamento.getQuantidadeTotal());
//                equipamento.setQuantidadeDisponivel(novo_equipamento.getQuantidadeDisponivel());
//            } catch (Exception e) {
//                throw new Exception("Erro ao modificar equipamento.");
//            } finally {
//                tx.commit();
//                manager.close();
//            }
//        }

//        public void delete(int id) throws Exception {
//            EntityManager manager = HibernateUtil.getEntityManager();
//            EntityTransaction tx = manager.getTransaction();
//            try{
//                tx.begin();
//                Agenda equipamento = manager.find(Agenda.class, id);
//                manager.remove(equipamento);
//                tx.commit();
//            } catch (Exception e) {
//                throw new Exception("Erro ao excluir equipamento.");
//            }finally {
//                manager.close();
//            }
//        }


    

	
}
