package fr.doranco.study_smart.repositories;

import fr.doranco.study_smart.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
