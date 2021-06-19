package sheridan.woloszym.assignment2.service;

import sheridan.woloszym.assignment2.model.PetForm;

import java.util.List;

public interface PetDataService {
    void insertPetForm(PetForm form);
    void deletePetForm(int id);
    List<PetForm> getAllPetForms();
    PetForm getPetForm(int id);
    void updatePetForm(PetForm form);
}
