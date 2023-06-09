package pet.store.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class PetStore {

    @Id
    @GeneratedValue
    private Long petStoreId;

    private String petStoreName;
    private String petStoreAddress;
    private String petStoreCity;
    private String petStoreState;
    private String petStoreZip;
    private String petStorePhone;

    @OneToMany(mappedBy = "petStore")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Employee> employees;

    @ManyToMany
    @JoinTable(
        name = "pet_store_customer",
        joinColumns = @JoinColumn(name = "pet_store_id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Customer> customers;

    // Getter and setter methods for employees and customers
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
