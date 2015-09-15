package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String firstName;
  private String lastName;
  

  
  @ManyToMany(cascade = {CascadeType.ALL})
  private List<Address> addressses = new ArrayList();

  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Customer() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
  }
  
  public void addAddress(Address address) {
    addressses.add(address);
  }
  
  public List<Address> getAddresses(){
    return addressses;
  }

  @Override
  public String toString() {
    return "Customer, id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ",Number of addresses: "+ addressses.size();
  }

}
