
package test;

import entity.Book;
import java.beans.PersistenceDelegate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {
    
    public static void main(String[] args) {
       
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExercisesDay-1PU");
     Persistence.generateSchema("ExercisesDay-1PU", null);
     EntityManager em = emf.createEntityManager();
     
     Book b1 = new Book("JPA for beginners");
     Book b2 = new Book("JPA for experts");
     Book b3 = new Book("Advanced JPA");
     em.getTransaction().begin();
     em.persist(b1);
     em.persist(b2);
     em.persist(b3);
     em.getTransaction().commit();
     System.out.println("Key: "+b1.getId());
     System.out.println("Key: "+b2.getId());
     System.out.println("Key: "+b3.getId());
     
    }
}
