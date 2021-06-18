package sheridan.woloszym.assignment2.model;

import javax.persistence.Column;
import javax.validation.constraints.*;

import java.io.Serializable;

public class PetForm implements Serializable {

    private Integer id;

    @NotBlank
    private String petName = "";

    @Column(name = "pet_kind")
    private String petKind = "";

    @Column(name = "gender")
    private String gender = "";

    @Column(name = "vaccineStatus")
    private Boolean vaccineStatus = false;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetKind() {
        return petKind;
    }

    public void setPetKind(String petKind) {
        this.petKind = petKind;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getVaccineStatus() {
        return vaccineStatus;
    }

    public void setVaccineStatus(Boolean vaccineStatus) {
        this.vaccineStatus = vaccineStatus;
    }
}
