package pet.store;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"pet.store.controller.model", "pet.store.service", "pet.store.dao"})
public class PetStoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(PetStoreApplication.class, args);

	}

}
