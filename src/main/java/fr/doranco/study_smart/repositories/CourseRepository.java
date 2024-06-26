package fr.doranco.study_smart.repositories;

import fr.doranco.study_smart.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
