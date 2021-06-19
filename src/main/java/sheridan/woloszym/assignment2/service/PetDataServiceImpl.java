package sheridan.woloszym.assignment2.service;

import org.springframework.stereotype.Service;
import sheridan.woloszym.assignment2.model.PetForm;
import sheridan.woloszym.assignment2.repository.PetDataRepositoryJpa;
import sheridan.woloszym.assignment2.repository.PetEntityJpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetDataServiceImpl implements PetDataService{
    private final PetDataRepositoryJpa petDataRepositoryJpa;

    public PetDataServiceImpl(PetDataRepositoryJpa petDataRepositoryJpa) {
        this.petDataRepositoryJpa = petDataRepositoryJpa;
    }

    private static void copyFormToEntity(PetForm form, PetEntityJpa pet){
        pet.setId(pet.getId());
        pet.setPetName(pet.getPetName());
        pet.setPetKind(pet.getPetKind());
        pet.setGender(pet.getGender());
        pet.setVaccineStatus(pet.getVaccineStatus());
    }

    private static void copyEntityToForm(PetEntityJpa pet, PetForm form){
        form.setId(pet.getId());
        form.setPetName(pet.getPetName());
        form.setPetKind(pet.getPetKind());
        form.setGender(pet.getGender());
        form.setVaccineStatus(pet.getVaccineStatus());
    }

    public void insertPetForm(PetForm form) {
        PetEntityJpa pet = new PetEntityJpa();
        copyFormToEntity(form, pet);
        pet = petDataRepositoryJpa.save(pet);
        form.setId(pet.getId());
    }


    public void deletePetForm(int id) {
        petDataRepositoryJpa.deleteById(id);
    }

    public List<PetForm> getAllPetForms() {
        List<PetForm> formList = new ArrayList<>();
        List<PetEntityJpa> petList = petDataRepositoryJpa.findAll();
        for(PetEntityJpa pet: petList){
            PetForm form = new PetForm();
            copyEntityToForm(pet, form);
            formList.add(form);
        }
        return formList;
    }

    public PetForm getPetForm(int id) {
        Optional<PetEntityJpa> result = petDataRepositoryJpa.findById(id);
        if(result.isPresent()){
            PetForm form = new PetForm();
            PetEntityJpa pet = result.get();
            copyEntityToForm(pet, form);
            return form;
        }
        return null;
    }

    public void updatePetForm(PetForm form) {
        Optional<PetEntityJpa> result = petDataRepositoryJpa.findById(form.getId());
        if(result.isPresent()){
            PetEntityJpa pet = result.get();
            copyFormToEntity(form, pet);
            petDataRepositoryJpa.save(pet);
        }
    }
}
