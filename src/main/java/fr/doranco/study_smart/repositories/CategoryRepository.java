package fr.doranco.study_smart.repositories;

import fr.doranco.study_smart.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource( path = "cat")
@CrossOrigin("http://localhost:4200/")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
