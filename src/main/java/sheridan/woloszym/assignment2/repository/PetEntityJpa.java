package sheridan.woloszym.assignment2.repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="pet")
public class PetEntityJpa implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pet_name")
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
