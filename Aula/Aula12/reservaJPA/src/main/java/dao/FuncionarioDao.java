package dao;

import entities.Chefia;
import entities.Funcionario;
import entities.Vigia;
import util.HibernateUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class FuncionarioDao {

    public void add(Funcionario funcionario) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();
            manager.persist(funcionario);
            tx.commit();
        } catch (Exception e) {
            throw new Exception("Erro ao criar funcionarios.");
        } finally {
            manager.close();
        }
    }

    public List<Funcionario> list_all() throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        try{
            TypedQuery<Funcionario> query = manager.createQuery("select func from Funcionario func", Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Erro ao listar funcionarios.");
        } finally {
            manager.close();
        }
    }

    public Funcionario get_byNome(String nome) throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        try{
            TypedQuery<Funcionario> query = manager.createQuery("select func from Funcionario func where nome= :nome", Funcionario.class);
            query.setParameter("nome", nome);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new Exception("Erro ao obter funcionario.");
        } finally {
            manager.close();
        }
    }

    public Funcionario get_byId(int id) throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        try {
            return manager.find(Funcionario.class, id);
        } catch (Exception e) {
            throw new Exception("Erro ao obter funcionario.");
        } finally {
            manager.close();
        }
    }

    public void update(int id, Funcionario funcionario_modificado) throws Exception {
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        Funcionario funcionario = manager.find(Funcionario.class, id);
        try{
            tx.begin();

            if (funcionario.getClass() == funcionario_modificado.getClass()) {
                if (funcionario instanceof Chefia){
                    System.out.println("Entrou");
                    funcionario.setNome(funcionario_modificado.getNome());
                    funcionario.setEmail(funcionario_modificado.getEmail());
                    ((Chefia) funcionario).setSetor(((Chefia) funcionario_modificado).getSetor());
                    ((Chefia) funcionario).setCargo(((Chefia) funcionario_modificado).getCargo());
                    ((Chefia) funcionario).setSenha(((Chefia) funcionario_modificado).getSenha());
                }
                else{
                    funcionario.setNome(funcionario_modificado.getNome());
                    funcionario.setEmail(funcionario_modificado.getEmail());;
                }
            }
            else{
                throw new Exception("Erro ao modificar funcionario. Tipos nao sao iguais.");
            }
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao modificar funcionario.");
        } finally {
            manager.close();
        }
    }

    public void delete(int id) throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();
            manager.remove(manager.find(Funcionario.class, id));
            tx.commit();
        } catch (Exception e) {
            throw new Exception("Erro ao deletar funcionario.");
        } finally {
            manager.close();
        }
    }
}
