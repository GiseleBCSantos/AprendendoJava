package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("agendaServlet");

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();
    }
    
    public void testeConexao() {
    	try {
    		EntityManager manager = getEntityManager();
    		System.out.println(manager);
    		close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
}
