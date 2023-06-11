package pet.store.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {

    private final PetStoreService petStoreService;

    @Autowired
    public PetStoreController(PetStoreService petStoreService) {
        this.petStoreService = petStoreService;
    }

    // Existing method to create a new pet store
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {
        log.info("Received request to create PetStore: {}", petStoreData);
        PetStoreData savedPetStoreData = petStoreService.savePetStore(petStoreData);
        return savedPetStoreData;
    }

    // New method to update an existing pet store
    @PutMapping("/{storeId}")
    public PetStoreData updatePetStoreData(
            @PathVariable Long storeId,
            @RequestBody PetStoreData petStoreData
    ) {
        log.info("Received request to update PetStore with ID {}: {}", storeId, petStoreData);
        petStoreData.setPetStoreId(storeId);
        PetStoreData updatedPetStoreData = petStoreService.savePetStore(petStoreData);
        return updatedPetStoreData;
    }
}
