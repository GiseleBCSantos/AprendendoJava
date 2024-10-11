package models;

import entities.Equipamento;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EquipamentoDao {


    public void add(Equipamento equipamento){
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(equipamento);
        tx.commit();
    }

    public List<Equipamento> list_all() throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();

        try{
            Query query = manager.createQuery("select eq from Equipamento eq");
            List<Equipamento> listaEquipamentos = query.getResultList();
            return listaEquipamentos;
        } catch (Exception e) {
            throw new Exception("Erro ao obter lista.");
        } finally {
            manager.close();
        }
    }

    public Equipamento get_byDescricao(String descricao) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        try{
            TypedQuery<Equipamento> query = manager.createQuery("select eq from Equipamento eq where eq.descricao= :descricao", Equipamento.class);
            query.setParameter("descricao", descricao);
            Equipamento equipamento = query.getSingleResult();
            return equipamento;
        } catch (Exception e) {
            throw new Exception("Nenhum equipamento encontrado.");
        } finally {
            manager.close();
        }
    }

    public Equipamento get_byId(int id) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();
            Equipamento equipamento = manager.find(Equipamento.class, id);
            return equipamento;
        } catch (Exception e) {
            throw new Exception("Nenhum equipamento encontrado");
        }
        finally {
            tx.commit();
            manager.close();
        }
    }

    public void update(int id, Equipamento novo_equipamento) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();
            Equipamento equipamento = manager.find(Equipamento.class, id);
            equipamento.setId(id);
            equipamento.setDescricao(novo_equipamento.getDescricao());
            equipamento.setQuantidadeTotal(novo_equipamento.getQuantidadeTotal());
            equipamento.setQuantidadeDisponivel(novo_equipamento.getQuantidadeDisponivel());
        } catch (Exception e) {
            throw new Exception("Erro ao modificar equipamento.");
        } finally {
            tx.commit();
            manager.close();
        }
    }

    public void delete(int id) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();
            Equipamento equipamento = manager.find(Equipamento.class, id);
            manager.remove(equipamento);
            tx.commit();
        } catch (Exception e) {
            throw new Exception("Erro ao excluir equipamento.");
        }finally {
            manager.close();
        }
    }


}
