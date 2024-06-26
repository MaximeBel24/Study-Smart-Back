package fr.doranco.study_smart.service;

import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public Course updateCourse(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public void deleteCourse(Course c) {
        courseRepository.delete(c);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
}
