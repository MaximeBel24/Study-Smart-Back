package fr.doranco.study_smart.repositories;

import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findByTitle(String title);
    @Query("select m from Module m where m.course = ?1")
    List<Module> findByCourse(Course course);
    List<Module> findByCourseId(Long id);


}
