package test;

import entity.Address;
import entity.Customer;
import entity.CustomerFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class facadeTester {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExercisesDay-1PU");
    CustomerFacade facade = new CustomerFacade(emf);
    
    //Create customer Kurt Wonnegut + one address
    Customer cust = new Customer("Kurt", "Wonnegut");
    Address address = new Address("Aaa street", "Aaa city");
    address.addCustomer(cust);
    cust = facade.addCustomer(cust);
    
    //Provide Kurt Wonnegut with one more address
    Address address2 = new Address("Bbb street", "Bbb city");
    address2.addCustomer(cust);
    cust = facade.editCustomer(cust);
    
    //Create customer Hanne Wonnegut at samme (first) address as Kurt
    Customer cust2 = new Customer("Hanne","Wonnegut");
    address.addCustomer(cust2);
    facade.addCustomer(cust2);
    
    System.out.println(cust.getFirstName()+", "+cust.getLastName()+", ID: "+cust.getId());
    for(Address a: cust.getAddresses()){
      System.out.println(a.getStreet());
    }
    
    //Find Kurt
    System.out.println("Found : "+facade.getCustomer(cust.getId()).getFirstName());
    //Find all Customers
    System.out.println("Listing all Customers");
    for(Customer c : facade.getCustomers()){
      System.out.println(c);
    }
    
    //Delete Kurt Wonnegut
    facade.deleteCustomer(cust.getId());
  }
  
}
