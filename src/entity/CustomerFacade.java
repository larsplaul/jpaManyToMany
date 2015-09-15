package entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CustomerFacade {
  EntityManagerFactory emf;

  public CustomerFacade(EntityManagerFactory emf) {
    this.emf = emf;
  }
  EntityManager getEntityManager(){ 
     return emf.createEntityManager();
  }
  
  public Customer getCustomer(int id){
    EntityManager em = getEntityManager();
    try{
      return em.find(Customer.class, id);
    }finally{
      em.close();
    }
  }
  public List<Customer> getCustomers(){
    EntityManager em = getEntityManager();
    try{
      return em.createQuery("select c from Customer c").getResultList();
      
    }finally{
      em.close();
    }
  }
  
  public Customer addCustomer(Customer cust){
    EntityManager em = getEntityManager();
    try{
      em.getTransaction().begin();
      em.persist(cust);
//      for(Address a: cust.getAddresses()){
//        em.persist(a);
//      }
      em.getTransaction().commit();
    }finally{
      em.close();
    }
    return cust;
  }
  
  public Customer editCustomer(Customer cust){
    EntityManager em = getEntityManager();
    try{
      em.getTransaction().begin();
      em.merge(cust);
      em.getTransaction().commit();
    }finally{
      em.close();
    }
    return cust;
  }
 
  public Customer deleteCustomer(int custId){
    EntityManager em = getEntityManager();
    Customer cust = em.find(Customer.class,custId);
    try{
      em.getTransaction().begin();
      em.remove(cust);
      em.getTransaction().commit();
    }finally{
      em.close();
    }
    return cust;
  }
  
  
}
