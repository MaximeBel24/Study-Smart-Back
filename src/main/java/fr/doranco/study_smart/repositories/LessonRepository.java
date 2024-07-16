package fr.doranco.study_smart.repositories;

import fr.doranco.study_smart.entities.Lesson;
import fr.doranco.study_smart.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByTitle(String title);
    @Query("select l from Lesson l where l.module = ?1")
    List<Lesson> findByModule(Module module);
    List<Lesson> findByModuleId(Long id);
}
