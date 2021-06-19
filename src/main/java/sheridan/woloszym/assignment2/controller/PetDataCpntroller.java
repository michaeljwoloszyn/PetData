package sheridan.woloszym.assignment2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/InsertPet")
    public String insertPet(
            @Validated @ModelAttribute("form") PetForm form,
            BindingResult bindingResult,
            Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("form", form);
            return "AddPet";
        } else {
            petDataService.insertPetForm(form);
            return "redirect:ConfirmInsert/" + form.getId();
        }
    }

    @GetMapping("/ConfirmInsert/{id}")
    public String confirmInsert(@PathVariable(name = "id") String strId, Model model){
        try {
            int id = Integer.parseInt(strId);
            PetForm form = petDataService.getPetForm(id);
            if (form == null) {
                return "DataNotFound";
            } else {
                model.addAttribute("form", form);
                return "ConfirmInsert";
            }
        } catch (NumberFormatException e) {
            return "AddPet";
        }
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
