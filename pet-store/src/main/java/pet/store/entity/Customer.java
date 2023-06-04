package pet.store.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
	    @EqualsAndHashCode.Exclude
	    @ToString.Exclude
	    private Set<PetStore> petStores;
}
