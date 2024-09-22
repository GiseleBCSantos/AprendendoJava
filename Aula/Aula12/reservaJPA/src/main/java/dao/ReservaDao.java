package dao;

import entities.Chefia;
import entities.Funcionario;
import entities.Reserva;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import static util.Utils.colorirErro;

public class ReservaDao {

    private FuncionarioDao funcionarioDao;

    public ReservaDao(){
        funcionarioDao = new FuncionarioDao();
    }

    public void add(Reserva reserva) throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();

            if (reserva.getEspaco() != null){
                if (! (reserva.getSolicitante() instanceof Chefia)){
                    throw new Exception(colorirErro("Funcionario comum nao pode reservar espaco."));
                }
            }

            manager.persist(reserva);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(colorirErro("Erro ao adicionar reserva."));

        } finally {
            manager.close();
        }
    }

    public List<Reserva> list_all() throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        try{
            TypedQuery<Reserva> query = manager.createQuery("select r from Reserva r", Reserva.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception(colorirErro("Erro ao listar reservas."));
        } finally {
            manager.close();
        }
    }

    public Reserva get_byNome_byData(String nome, String data) throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        Funcionario funcionario_buscado = funcionarioDao.get_byNome(nome);
        try{
            TypedQuery<Reserva> query = manager.createQuery("select r from Reserva r where solicitante_id= :solicitante_id and data= :data", Reserva.class);
            query.setParameter("solicitante_id", funcionario_buscado.getId());
            query.setParameter("data", data);
            return query.getResultList().get(0);
        } catch (Exception e) {
            throw new Exception(colorirErro("Erro ao listar reserva por nome e data."));
        } finally {
            manager.close();
        }
    }

    public Reserva get_byId(int id) throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        try{
            return manager.find(Reserva.class, id);
        } catch (Exception e) {
            throw new Exception(colorirErro("Erro ao listar reserva por id."));
        } finally {
            manager.close();
        }
    }

    public void update(int id, Reserva reserva_modificada) throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        Reserva reserva = manager.find(Reserva.class, id);
        try{
            tx.begin();

            if ((reserva_modificada.getEspaco() != null && reserva.getEspaco() != null) || (reserva.getEquipamento() != null && reserva_modificada.getEquipamento() != null)){
                reserva.setData(reserva_modificada.getData());
                reserva.setSolicitante(reserva_modificada.getSolicitante());
                reserva.setEquipamento(reserva.getEquipamento());
                reserva.setEspaco(reserva.getEspaco());
            } else{
                throw new Exception(colorirErro("Nao e possivel alterar reservas para tipos diferentes."));
            }


        } catch (Exception e){
            e.printStackTrace();
            throw new Exception(colorirErro("Erro ao modificar reserva."));
        }finally {
            tx.commit();
            manager.close();
        }
    }

    public void delete(int id) throws Exception{
        EntityManager manager = HibernateUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try{
            tx.begin();
            Reserva reserva = manager.find(Reserva.class, id);
            manager.remove(reserva);
            tx.commit();
        } catch (Exception e) {
            throw new Exception(colorirErro("Erro ao deletar reserva."));
        } finally {
            manager.close();
        }
    }
}

































