package fr.doranco.study_smart.repositories;

import fr.doranco.study_smart.entities.Category;
import fr.doranco.study_smart.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitle(String name);
    List<Course> findByTitleContains(String name);
    @Query("select c from Course c where c.title like %:title and c.price > :price")
    List<Course> findByTitlePrice(@Param("title") String title, @Param("price") Double price);
    @Query("select c from Course c where c.category = ?1")
    List<Course> findByCategory (Category category);
    List<Course> findByCategoryId(Long id);
    List<Course> findByOrderByTitleAsc();
    @Query("select c from Course c order by c.title ASC, c.price DESC")
    List<Course> sortTitlePrice();

}
