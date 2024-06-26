package fr.doranco.study_smart.service;

import fr.doranco.study_smart.entities.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course c);
    Course updateCourse(Course c);
    void deleteCourse(Course c);
    void deleteCourseById(Long id);
    Course getCourse(Long id);
    List<Course> getAllCourse();

}
