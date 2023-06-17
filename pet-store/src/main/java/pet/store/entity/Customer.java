package pet.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;

    @ManyToMany(mappedBy = "customers")
    private Set<PetStore> petStores;
    
    public Customer() {
        this.petStores = new HashSet<>();
    }
}
