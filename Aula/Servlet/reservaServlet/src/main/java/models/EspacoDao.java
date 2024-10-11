package models;

import entities.Espaco;
import org.hibernate.loader.plan.exec.process.spi.EntityReferenceInitializer;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Handler;

public class EspacoDao {

    public void add(Espaco espaco) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();
            manager.persist(espaco);
            tx.commit();
        } catch (Exception e){
            throw new Exception("Erro ao adicionar espaco");
        } finally {
            manager.close();
        }
    }

    public List<Espaco> list_all() throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        try {
            TypedQuery<Espaco> query = manager.createQuery("select esp from Espaco esp", Espaco.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Erro ao listar espacos");
        } finally {
            manager.close();
        }
    }

    public Espaco get_byDescricao(String descricao) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        try{
            TypedQuery<Espaco> query = manager.createQuery("select esp from Espaco esp where esp.descricao= :descricao", Espaco.class);
            query.setParameter("descricao", descricao);
            System.out.println(query.getResultList().get(0));
            return query.getResultList().get(0);
        } catch (Exception e){
            throw new Exception("Erro ao obter espaco.");
        } finally {
            manager.close();
        }
    }

    public Espaco get_byId(int id) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        try{
            return manager.find(Espaco.class, id);
        } catch (Exception e) {
            throw new Exception("Erro ao obter espaco.");
        } finally {
            manager.close();
        }
    }

    public void update(int id, Espaco novo_espaco) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();
            Espaco espaco = manager.find(Espaco.class, id);
            espaco.setDescricao(novo_espaco.getDescricao());
            espaco.setStatus(novo_espaco.isStatus());
            tx.commit();
        } catch (Exception e) {
            throw new Exception("Erro ao modificar espaco.");
        } finally {
            manager.close();
        }
    }

    public void delete(int id) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();
            Espaco espaco = manager.find(Espaco.class, id);
            manager.remove(espaco);
            tx.commit();
        } catch (Exception e) {
            throw new Exception("Erro ao deletar espaco.");
        } finally {
            manager.close();
        }
    }
}
