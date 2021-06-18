package sheridan.woloszym.assignment2.service;

import org.springframework.stereotype.Service;
import sheridan.woloszym.assignment2.model.PetForm;
import sheridan.woloszym.assignment2.repository.PetDataRepositoryJpa;
import sheridan.woloszym.assignment2.repository.PetEntityJpa;

import java.util.List;
import java.util.Optional;

@Service
public class PetDataServiceImpl implements PetDataService{
    private final PetDataRepositoryJpa petDataRepositoryJpa;

    public PetDataServiceImpl(PetDataRepositoryJpa petDataRepositoryJpa) {
        this.petDataRepositoryJpa = petDataRepositoryJpa;
    }

    private static void copyEntityToForm(PetEntityJpa student, PetForm form){
        form.setId(student.getId());
        form.setPetName(student.getPetName());
        form.setPetKind(student.getPetKind());
        form.setGender(student.getGender());
    }

    public List<PetForm> getAllPetForms() {
        return null;
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
}
