package sheridan.woloszym.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDataRepositoryJpa extends JpaRepository<PetEntityJpa, Integer> {
}
