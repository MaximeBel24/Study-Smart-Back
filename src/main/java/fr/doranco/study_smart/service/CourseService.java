package fr.doranco.study_smart.service;

import fr.doranco.study_smart.dto.CourseDTO;
import fr.doranco.study_smart.entities.Category;
import fr.doranco.study_smart.entities.Course;

import java.util.List;

public interface CourseService {
    CourseDTO saveCourse(CourseDTO c);
    CourseDTO updateCourse(CourseDTO c);
    void deleteCourse(Course c);
    void deleteCourseById(Long id);
    CourseDTO getCourse(Long id);
    List<CourseDTO> getAllCourses();
    List<Course> findByTitle(String title);
    List<Course> findByTitleContains(String title);
    List<Course> findByNamePrice(String title, Double price);
    List<Course> findByCategory(Category category);
    List<Course> findByCategoryId(Long id);
    List<Course> findByOrderByTitleAsc();
    List<Course> sortTitlePrice();

    CourseDTO convertEntityToDto(Course course);
    Course converDtoToEntity(CourseDTO courseDTO);
}
