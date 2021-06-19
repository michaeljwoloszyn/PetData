package sheridan.woloszym.assignment2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = {"/AddPet"})
    public ModelAndView addPet() {
        ModelAndView modelAndView=
                new ModelAndView("AddPet",
                        "form", new PetForm());
        return modelAndView;
    }

    @GetMapping("/DeletePet")
    public String deletePet(@RequestParam Integer id, Model model) {
        try {
            PetForm form = petDataService.getPetForm(id);
            if (form != null) {
                model.addAttribute("pet", form);
                return "DeletePet";
            } else {
                return "redirect:ListPet";
            }
        } catch (NumberFormatException e) {
            return "redirect:ListPet";
        }
    }

    @PostMapping("/RemovePet")
    public String removePet(@RequestParam String id) {
        try {
            petDataService.deletePetForm(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return "redirect:ListPet";
        }
        return "redirect:ListPet";
    }

    @GetMapping(value = {"/ListPet"})
    public ModelAndView listPet() {
        List<PetForm> list = petDataService.getAllPetForms();
        return new ModelAndView(
                "ListPet",
                "pets", list);
    }

}
