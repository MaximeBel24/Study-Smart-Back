package fr.doranco.study_smart.repositories;

import fr.doranco.study_smart.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
