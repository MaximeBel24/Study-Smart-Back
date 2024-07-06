package fr.doranco.study_smart.service;

import fr.doranco.study_smart.entities.Category;
import fr.doranco.study_smart.entities.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course c);
    Course updateCourse(Course c);
    void deleteCourse(Course c);
    void deleteCourseById(Long id);
    Course getCourse(Long id);
    List<Course> getAllCourses();
    List<Course> findByTitle(String title);
    List<Course> findByTitleContains(String title);
    List<Course> findByNamePrice(String title, Double price);
    List<Course> findByCategory(Category category);
    List<Course> findByCategoryId(Long id);
    List<Course> findByOrderByTitleAsc();
    List<Course> sortTitlePrice();

}
