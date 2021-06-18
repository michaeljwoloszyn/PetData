package sheridan.woloszym.assignment2.service;

import sheridan.woloszym.assignment2.model.PetForm;

import java.util.List;

public interface PetDataService {
    List<PetForm> getAllPetForms();
    PetForm getPetForm(int id);
}
