package sheridan.woloszym.assignment2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import sheridan.woloszym.assignment2.model.PetForm;
import sheridan.woloszym.assignment2.service.PetDataService;

import java.util.List;

@Controller
public class PetDataCpntroller {
    private final PetDataService petDataService;

    public PetDataCpntroller(PetDataService petDataService) {
        this.petDataService = petDataService;
    }

    @GetMapping(value = {"/","/Index"})
    public String index() {
        return "Index";
    }

    @GetMapping(value = {"/ListPet"})
    public ModelAndView petList() {
        List<PetForm> list = petDataService.getAllPetForms();
        return new ModelAndView(
                "ListPet",
                "pets", list);
    }

    @GetMapping("PetDetails/{id}")
    public String petDetails(@PathVariable Integer id, Model model){
        try {
            PetForm form = petDataService.getPetForm(id);
            if (form != null) {
                model.addAttribute("pet", form);
                return "PetDetails";
            } else {
                return "PetList";
            }
        } catch (NumberFormatException e) {
            return "PetList";
        }
    }
}
